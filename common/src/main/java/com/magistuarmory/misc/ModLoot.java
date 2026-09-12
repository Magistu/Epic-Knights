package com.magistuarmory.misc;


import com.magistuarmory.EpicKnights;
import dev.architectury.event.events.common.LootEvent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;

public class ModLoot
{
    public static void modifyLootTable(ResourceKey<LootTable> key, LootEvent.LootTableModificationContext context, boolean builtin) 
    {
        String prefix = "minecraft:chests/";
        String name = key.identifier().toString();

        if (name.startsWith(prefix)) 
        {
            String file = name.substring(name.indexOf(prefix) + prefix.length());
            switch (file) {
                case "desert_pyramid", "end_city_treasure", "jungle_temple", "nether_bridge", "ruined_portal", "simple_dungeon", "stronghold_corridor", "village/village_weaponsmith" -> 
                        context.addPool(getPoolEntry(key));
                default -> {}
            }
        }
    }

    private static LootPool.Builder getPoolEntry(ResourceKey<LootTable> key) 
    {
        Identifier table = Identifier.fromNamespaceAndPath(EpicKnights.ID, key.identifier().getPath());
        return LootPool.lootPool().add(NestedLootTable.lootTableReference(ResourceKey.create(net.minecraft.core.registries.Registries.LOOT_TABLE, table)));
    }
}
