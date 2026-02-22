package com.magistuarmory.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.ConfigData;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

import java.util.LinkedHashMap;
import java.util.Map;

@Config(name = "armor")
public class ArmorConfig implements ConfigData
{
    @ConfigEntry.Gui.CollapsibleObject
    public Map<String, ArmorTypeConfig> armor = new LinkedHashMap<>() {{
        put("minicrown", ArmorTypeConfig.of(0.00f, 0.0f, new Integer[] { 0, 0, 0, 77 }, new Integer[] { 0, 0, 0, 2 }, 25, true));
        put("crown", ArmorTypeConfig.of(0.00f, 0.0f, new Integer[] { 0, 0, 0, 77 }, new Integer[] { 0, 0, 0, 2 }, 25, true));
        put("flowercrown", ArmorTypeConfig.of(0.00f, 0.0f, new Integer[] { 0, 0, 0, 77 }, new Integer[] { 0, 0, 0, 2 }, 9, true));
        put("knight", ArmorTypeConfig.of(1.25f, 0.5f, new Integer[] { 230, 315, 335, 0 }, new Integer[] { 2, 5, 8, 0 }, 9, true));
        put("armet", ArmorTypeConfig.of(1.25f, 0.5f, new Integer[] { 0, 0, 0, 275 }, new Integer[] { 0, 0, 0, 3 }, 9, true));
        put("stechhelm", ArmorTypeConfig.of(2.00f, 1.5f, new Integer[] { 0, 0, 0, 385 }, new Integer[] { 0, 0, 0, 4 }, 9, true));
        put("jousting", ArmorTypeConfig.of(2.00f, 1.5f, new Integer[] { 345, 440, 500, 0 }, new Integer[] { 3, 6, 9, 0 }, 9, true));
        put("sallet", ArmorTypeConfig.of(1.25f, 0.5f, new Integer[] { 0, 0, 0, 275 }, new Integer[] { 0, 0, 0, 3 }, 9, true));
        put("gothic", ArmorTypeConfig.of(1.25f, 0.5f, new Integer[] { 230, 315, 335, 0 }, new Integer[] { 2, 5, 8, 0 }, 9, true));
        put("maximilianHelmet", ArmorTypeConfig.of(1.80f, 0.5f, new Integer[] { 0, 0, 0, 385 }, new Integer[] { 0, 0, 0, 4 }, 12, true));
        put("maximilian", ArmorTypeConfig.of(1.80f, 0.5f, new Integer[] { 345, 440, 500, 0 }, new Integer[] { 3, 6, 9, 0 }, 12, true));
        put("chainmail", ArmorTypeConfig.of(0.00f, 0.0f, new Integer[] { 170, 235, 250, 205 }, new Integer[] { 1, 4, 5, 2 }, 9, true));
        put("kettlehat", ArmorTypeConfig.of(0.50f, 0.0f, new Integer[] { 0, 0, 0, 240 }, new Integer[] { 0, 0, 0, 2 }, 9, true));
        put("platemail", ArmorTypeConfig.of(0.50f, 0.0f, new Integer[] { 200, 230, 290, 0 }, new Integer[] { 3, 4, 6, 0 }, 9, true));
        put("barbute", ArmorTypeConfig.of(0.50f, 0.0f, new Integer[] { 0, 0, 0, 170 }, new Integer[] { 0, 0, 0, 2 }, 9, true));
        put("halfarmor", ArmorTypeConfig.of(0.50f, 0.0f, new Integer[] { 0, 0, 315, 0 }, new Integer[] { 0, 0, 6, 0 }, 9, true));
        put("greathelm", ArmorTypeConfig.of(0.60f, 0.0f, new Integer[] { 150, 280, 295, 220 }, new Integer[] { 1, 5, 6, 3 }, 9, true));
        put("crusader", ArmorTypeConfig.of(0.60f, 0.0f, new Integer[] { 150, 280, 295, 220 }, new Integer[] { 1, 5, 6, 3 }, 9, true));
        put("brigandine", ArmorTypeConfig.of(0.25f, 0.0f, new Integer[] { 0, 0, 265, 0 }, new Integer[] { 0, 0, 5, 0 }, 9, true));
        put("gambeson", ArmorTypeConfig.of(0.00f, 0.0f, new Integer[] { 100, 100, 128, 88 }, new Integer[] { 1, 1, 3, 1 }, 9, true));
        put("ceremonialArmet", ArmorTypeConfig.of(1.25f, 0.5f, new Integer[] { 0, 0, 0, 275 }, new Integer[] { 0, 0, 0, 3 }, 9, true));
        put("ceremonial", ArmorTypeConfig.of(1.25f, 0.5f, new Integer[] { 230, 0, 335, 0 }, new Integer[] { 2, 0, 8, 0 }, 9, true));
        put("shishak", ArmorTypeConfig.of(0.30f, 0.0f, new Integer[] { 0, 0, 0, 210 }, new Integer[] { 0, 0, 0, 2 }, 9, true));
        put("norman", ArmorTypeConfig.of(0.20f, 0.0f, new Integer[] { 0, 0, 0, 190 }, new Integer[] { 0, 0, 0, 2 }, 9, true));
        put("rustedBarbute", ArmorTypeConfig.of(0.00f, 0.0f, new Integer[] { 0, 0, 0, 90 }, new Integer[] { 0, 0, 0, 2 }, 9, true));
        put("rustedHalfarmor", ArmorTypeConfig.of(0.00f, 0.0f, new Integer[] { 0, 0, 170, 0 }, new Integer[] { 0, 0, 6, 0 }, 9, true));
        put("rustedChainmail", ArmorTypeConfig.of(0.00f, 0.0f, new Integer[] { 85, 115, 125, 100 }, new Integer[] { 1, 4, 5, 2 }, 9, true));
        put("rustedKettlehat", ArmorTypeConfig.of(0.00f, 0.0f, new Integer[] { 0, 0, 0, 120 }, new Integer[] { 0, 0, 0, 2 }, 9, true));
        put("rustedNorman", ArmorTypeConfig.of(0.00f, 0.0f, new Integer[] { 0, 0, 0, 85 }, new Integer[] { 0, 0, 0, 2 }, 9, true));
        put("rustedGreathelm", ArmorTypeConfig.of(0.00f, 0.0f, new Integer[] { 75, 0, 150, 110 }, new Integer[] { 1, 0, 6, 3 }, 9, true));
        put("rustedCrusader", ArmorTypeConfig.of(0.00f, 0.0f, new Integer[] { 75, 0, 150, 110 }, new Integer[] { 1, 0, 6, 3 }, 9, true));
        put("bascinet", ArmorTypeConfig.of(1.25f, 0.0f, new Integer[] { 0, 0, 0, 250 }, new Integer[] { 0, 0, 0, 3 }, 9, true));
        put("xivCenturyKnight", ArmorTypeConfig.of(1.25f, 0.0f, new Integer[] { 210, 300, 320, 0 }, new Integer[] { 2, 5, 7, 0 }, 9, true));
        put("wingedHussarChestplate", ArmorTypeConfig.of(0.50f, 0.0f, new Integer[] { 0, 0, 360, 0 }, new Integer[] { 0, 0, 6, 0 }, 9, true));
        put("cuirassier", ArmorTypeConfig.of(0.50f, 0.0f, new Integer[] { 150, 100, 315, 170 }, new Integer[] { 1, 1, 6, 2 }, 9, true));
        put("kastenbrust", ArmorTypeConfig.of(1.25f, 0.5f, new Integer[] { 230, 315, 335, 0 }, new Integer[] { 2, 5, 8, 0 }, 9, true));
        put("grandBascinet", ArmorTypeConfig.of(1.25f, 0.5f, new Integer[] { 0, 0, 0, 275 }, new Integer[] { 0, 0, 0, 3 }, 9, true));
        put("lamellar", ArmorTypeConfig.of(0.30f, 0.0f, new Integer[] { 200, 0, 250, 240 }, new Integer[] { 2, 0, 6, 2 }, 9, true));
    }};

    public ArmorTypeConfig get(String name) {
        return this.armor.get(name);
    }

    public static class ArmorTypeConfig {
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public float knockbackResistance;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int enchantmentValue;
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;

        private ArmorTypeConfig() {}

        public static ArmorTypeConfig of(
                                   float toughness,
                                   float knockbackResistance,
                                   Integer[] durability,
                                   Integer[] defenseForSlot,
                                   int enchantmentValue,
                                   boolean enabled) {
            ArmorTypeConfig cfg = new ArmorTypeConfig();
            cfg.toughness = toughness;
            cfg.knockbackResistance = knockbackResistance;
            cfg.bootsDurability = durability[0];
            cfg.leggingsDurability = durability[1];
            cfg.chestplateDurability = durability[2];
            cfg.helmetDurability = durability[3];
            cfg.bootsDefense = defenseForSlot[0];
            cfg.leggingsDefense = defenseForSlot[1];
            cfg.chestplateDefense = defenseForSlot[2];
            cfg.helmetDefense = defenseForSlot[3];
            cfg.enchantmentValue = enchantmentValue;
            cfg.enabled = enabled;
            return cfg;
        }

        public static ArmorTypeConfig of(
                                   ArmorMaterial material,
                                   boolean enabled) {

            return of(
                    material.getToughness(),
                    material.getKnockbackResistance(),
                    new Integer[]{
                            material.getDurabilityForType(ArmorItem.Type.BOOTS),
                            material.getDurabilityForType(ArmorItem.Type.LEGGINGS),
                            material.getDurabilityForType(ArmorItem.Type.CHESTPLATE),
                            material.getDurabilityForType(ArmorItem.Type.HELMET)
                    },
                    new Integer[]{
                            material.getDefenseForType(ArmorItem.Type.BOOTS),
                            material.getDefenseForType(ArmorItem.Type.LEGGINGS),
                            material.getDefenseForType(ArmorItem.Type.CHESTPLATE),
                            material.getDefenseForType(ArmorItem.Type.HELMET)
                    },
                    material.getEnchantmentValue(),
                    enabled
            );
        }
    }
}
