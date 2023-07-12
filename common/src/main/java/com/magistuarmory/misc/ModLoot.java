package com.magistuarmory.misc;


import com.magistuarmory.EpicKnights;
import com.magistuarmory.block.ModBlocks;
import dev.architectury.event.events.common.LootEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

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
        ResourceLocation table = new ResourceLocation(EpicKnights.ID, "chests/" + name);
        return LootTableReference.lootTableReference(table);
    }
}
