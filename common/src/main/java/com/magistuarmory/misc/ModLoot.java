package com.magistuarmory.misc;


import com.magistuarmory.EpicKnights;
import dev.architectury.event.events.common.LootEvent;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;

public class ModLoot
{
    public static void modifyLootTable(HolderGetter.Provider registries, ResourceKey<LootTable> key, LootEvent.LootTableModificationContext context, boolean builtin) 
    {
        String prefix = "minecraft:chests/";
        String name = key.identifier().toString();

        if (name.startsWith(prefix)) 
        {
            String file = name.substring(name.indexOf(prefix) + prefix.length());
            switch (file) {
                case "desert_pyramid", "end_city_treasure", "jungle_temple", "nether_bridge", "ruined_portal", "simple_dungeon", "stronghold_corridor", "village/village_weaponsmith" -> 
                        context.addPool(getPoolEntry(registries, key));
                default -> {}
            }
        }
    }

    private static LootPool.Builder getPoolEntry(HolderGetter.Provider registries, ResourceKey<LootTable> key) 
    {
        Identifier table = Identifier.fromNamespaceAndPath(EpicKnights.ID, key.identifier().getPath());
        ResourceKey<LootTable> ourKey = ResourceKey.create(Registries.LOOT_TABLE, table);
        Holder<LootTable> holder = registries.lookupOrThrow(Registries.LOOT_TABLE).getOrThrow(ourKey);
        return LootPool.lootPool().add(NestedLootTable.lootTableReference(holder));
    }
}
