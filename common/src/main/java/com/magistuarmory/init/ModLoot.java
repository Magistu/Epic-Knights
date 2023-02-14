package com.magistuarmory.init;


import com.magistuarmory.KnightlyArmory;
import dev.architectury.event.events.common.LootEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;

public class ModLoot
{
    public static void modifyLootTable(ResourceLocation id, LootEvent.LootTableModificationContext context) 
    {
        String prefix = "minecraft:chests/";
        String name = id.toString();

        if (name.startsWith(prefix)) 
        {
            String file = name.substring(name.indexOf(prefix) + prefix.length());
            switch (file) {
                case "desert_pyramid", "end_city_treasure", "jungle_temple", "nether_bridge", "ruined_portal", "simple_dungeon", "stronghold_corridor", "village/village_weaponsmith" ->
                        context.addPool(getPool(file));
                default -> {}
            }
        }
    }

    public static LootPool getPool(String entryName) 
    {
        return LootPool.lootPool().add(getPoolEntry(entryName)).build();
    }

    @SuppressWarnings("rawtypes")
    private static LootPoolEntryContainer.Builder getPoolEntry(String name) 
    {
        ResourceLocation table = new ResourceLocation(KnightlyArmory.ID, "chests/" + name);
        return LootTableReference.lootTableReference(table);
    }
}
