package com.magistuarmory.init;

import com.magistuarmory.item.ModItems;
import dev.architectury.registry.level.entity.trade.SimpleTrade;
import dev.architectury.registry.level.entity.trade.TradeRegistry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ModMerchOffers
{
	public static VillagerTrades.ItemListing[] SHEPHERD_TRADES;
	
	public static void setup()
	{
		SHEPHERD_TRADES = new VillagerTrades.ItemListing[] {
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.APOSTOLIC_CROSS_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.BOWL_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.BULL_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.CHESS_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.CRUSADER_CROSS_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.DRAGON_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.EAGLE_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.HORSE_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.LILY_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.LION1_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.LION2_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.ORTHODOX_CROSS_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.SNAKE_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.SUN_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.SWORDS_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.TOWER_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.TREE_PATTERN.get()), 100, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.TWOHEADED_EAGLE_PATTERN.get()), 100, 0, 1)
		};
		
		TradeRegistry.registerVillagerTrade(VillagerProfession.SHEPHERD, 1, ModMerchOffers.SHEPHERD_TRADES);
	}
}
