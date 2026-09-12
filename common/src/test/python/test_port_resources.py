"""Regression checks for the resource formats and model states used by the 26.1 port."""
import json
from pathlib import Path
import unittest

COMMON = Path(__file__).resolve().parents[3]
RESOURCES = COMMON / "src/main/resources"
ASSETS = RESOURCES / "assets/magistuarmory"


def read(path):
    return json.loads(path.read_text(encoding="utf-8-sig"))


def select(item, values):
    node = read(ASSETS / "items" / f"{item}.json")["model"]
    while node["type"] == "minecraft:range_dispatch":
        value = values.get(node["name"], 0)
        matching = [entry for entry in node["entries"] if value >= entry["threshold"]]
        node = matching[-1]["model"] if matching else node["fallback"]
    return node


class PortResourcesTest(unittest.TestCase):
    def test_all_resource_json_is_valid(self):
        for path in RESOURCES.rglob("*.json"):
            with self.subTest(path=path):
                read(path)

    def test_bow_requires_active_use_and_preserves_pull_thresholds(self):
        for values, suffix in [({}, ""), ({"minecraft:pull": 1}, ""),
                               ({"minecraft:pulling": 1}, "_pulling_0"),
                               ({"minecraft:pulling": 1, "minecraft:pull": .65}, "_pulling_1"),
                               ({"minecraft:pulling": 1, "minecraft:pull": .9}, "_pulling_2")]:
            with self.subTest(values=values):
                self.assertEqual(select("longbow", values)["model"], "magistuarmory:item/longbow" + suffix)

    def test_plume_model_selection(self):
        self.assertEqual(select("armet", {})["model"], "magistuarmory:item/armet")
        self.assertEqual(select("armet", {"magistuarmory:has_plume": 1})["model"],
                         "magistuarmory:item/armet_with_plume")

    def test_shield_blocking_preserves_material_and_geometry(self):
        for value, suffix in [(0, ""), (1, "_blocking")]:
            node = select("wood_heatershield", {"minecraft:blocking": value})
            self.assertEqual(node["type"], "minecraft:special")
            self.assertEqual(node["base"], "magistuarmory:item/wood_heatershield" + suffix)
            self.assertEqual(node["model"]["id"], "wood_heatershield")
            self.assertEqual(node["model"]["location"], "magistuarmory:heatershield")

    def test_equipment_textures_exist(self):
        for path in (ASSETS / "equipment").glob("*.json"):
            for kind, layers in read(path)["layers"].items():
                for layer in layers:
                    namespace, texture = layer["texture"].split(":")
                    location = RESOURCES / "assets" / namespace / "textures/entity/equipment" / kind / f"{texture}.png"
                    with self.subTest(asset=path.name, layer=kind):
                        self.assertTrue(location.is_file(), location)

    def test_recipe_ingredients_use_26_1_format(self):
        def check(value):
            if isinstance(value, list):
                self.assertTrue(value)
                for alternative in value:
                    check(alternative)
            else:
                self.assertIsInstance(value, str)
                self.assertIn(":", value)
        for path in (RESOURCES / "data/magistuarmory/recipe").glob("*.json"):
            data = read(path)
            with self.subTest(recipe=path.name):
                for value in data.get("key", {}).values():
                    check(value)
                for value in data.get("ingredients", []):
                    check(value)
                for name in ("ingredient", "template", "base", "addition"):
                    if name in data:
                        check(data[name])

    def test_trade_tags_append_all_original_offers(self):
        for group, count in [("shepherd/level_1", 18), ("wandering_trader/common", 14)]:
            data = read(RESOURCES / "data/minecraft/tags/villager_trade" / f"{group}.json")
            self.assertFalse(data.get("replace", False))
            self.assertEqual(len(data["values"]), count)
            for value in data["values"]:
                namespace, path = value.split(":")
                self.assertTrue((RESOURCES / "data" / namespace / "villager_trade" / f"{path}.json").is_file())
        crown = read(RESOURCES / "data/magistuarmory/villager_trade/wandering_trader/crown_decoration.json")
        self.assertEqual(crown["wants"]["count"], 10)
        self.assertEqual(crown["max_uses"], 1)

    def test_loot_tables_use_singular_directory(self):
        self.assertEqual(len(list((RESOURCES / "data/magistuarmory/loot_table").rglob("*.json"))), 8)
        self.assertFalse(list((RESOURCES / "data/magistuarmory/loot_tables").rglob("*.json")))


if __name__ == "__main__":
    unittest.main()
