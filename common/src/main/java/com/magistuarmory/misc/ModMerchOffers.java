package com.magistuarmory.misc;

import com.magistuarmory.item.ModItems;
import dev.architectury.registry.level.entity.trade.SimpleTrade;
import dev.architectury.registry.level.entity.trade.TradeRegistry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModMerchOffers
{
	public static VillagerTrades.ItemListing[] SHEPHERD_TRADES;
	public static VillagerTrades.ItemListing[] WANDERING_TRADER_TRADES;
	
	public static void setup()
	{
		SHEPHERD_TRADES = new VillagerTrades.ItemListing[]{
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.APOSTOLIC_CROSS_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.BOWL_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.BULL_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.CHESS_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.CRUSADER_CROSS_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.DRAGON_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.EAGLE_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.HORSE_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.LILY_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.LION1_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.LION2_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.ORTHODOX_CROSS_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.SNAKE_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.SUN_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.SWORDS_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.TOWER_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.TREE_PATTERN.get()), 7, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.TWOHEADED_EAGLE_PATTERN.get()), 7, 0, 1),
		};

		WANDERING_TRADER_TRADES = new VillagerTrades.ItemListing[] {
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.GAZELLE_HORNS_DECORATION.get()), 3, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.DUCK_DECORATION.get()), 3, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.HORSE_DECORATION.get()), 3, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD, 10), ItemStack.EMPTY, new ItemStack(ModItems.CROWN_DECORATION.get()), 1, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.UNICORN_DECORATION.get()), 3, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.BULLHORNS_DECORATION.get()), 3, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.DRAGON_DECORATION.get()), 3, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD, 8), ItemStack.EMPTY, new ItemStack(ModItems.MINICROWN.get()), 1, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.ANTLERS_DECORATION.get()), 3, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.BEAR_DECORATION.get()), 3, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.LILY_DECORATION.get()), 3, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.LION_DECORATION.get()), 3, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.DEMON_HORNS_DECORATION.get()), 3, 0, 1),
			new SimpleTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(ModItems.GRIFFIN_DECORATION.get()), 3, 0, 1),
		};
		
		TradeRegistry.registerVillagerTrade(VillagerProfession.SHEPHERD, 1, ModMerchOffers.SHEPHERD_TRADES);
		TradeRegistry.registerTradeForWanderingTrader(false, ModMerchOffers.WANDERING_TRADER_TRADES);
	}
}
