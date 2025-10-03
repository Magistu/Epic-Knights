package com.magistuarmory.item;

import dev.architectury.platform.Platform;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ModItemTier implements Tier
{
	private final String name;
	private final float attackDamageBonus;
	private final int enchantmentValue;
	private final Supplier<Ingredient> repairIngredient;
	private final float speed;
	private final int uses;
	private final float density;

	public static ModItemTier WOOD = new ModItemTier("wood", Tiers.WOOD, 0);
	public static ModItemTier STONE = new ModItemTier("stone", Tiers.STONE, 1);
	public static ModItemTier IRON = new ModItemTier("iron", Tiers.IRON, 2);
	public static ModItemTier DIAMOND = new ModItemTier("diamond", Tiers.DIAMOND, 3);
	public static ModItemTier GOLD = new ModItemTier("gold", Tiers.GOLD, 4);
	public static ModItemTier NETHERITE = new ModItemTier("netherite", Tiers.NETHERITE, 5);

	public static ModItemTier COPPER = new ModItemTier("copper", BlockTags.INCORRECT_FOR_STONE_TOOL, 150, 0.7F, 0.0F, 10, "c:ingots/copper", 1);
	public static ModItemTier SILVER = new ModItemTier("silver", BlockTags.INCORRECT_FOR_STONE_TOOL, 230, 5.5F, 1.0F, 18, "c:ingots/silver", 2);
	public static ModItemTier STEEL = new ModItemTier("steel", BlockTags.INCORRECT_FOR_IRON_TOOL, 400, 6.0F, 2.5F, 14, "c:ingots/steel", 2);
	public static ModItemTier TIN = new ModItemTier("tin", BlockTags.INCORRECT_FOR_STONE_TOOL, 130, 6.0F, 0.0F, 20, "c:ingots/tin", 2);
	public static ModItemTier BRONZE = new ModItemTier("bronze", BlockTags.INCORRECT_FOR_IRON_TOOL, 200, 6.0F, 2.0F, 15, "c:ingots/bronze", 2);
	private final TagKey<Block> incorrectBlocks;

	public ModItemTier(String name, Tier tier, float density)
	{
		this.name = name;
		this.incorrectBlocks = tier.getIncorrectBlocksForDrops();
		this.uses = tier.getUses();
		this.speed = tier.getSpeed();
		this.attackDamageBonus = tier.getAttackDamageBonus();
		this.enchantmentValue = tier.getEnchantmentValue();
		this.repairIngredient = tier::getRepairIngredient;
		this.density = density;
	}

	public ModItemTier(String name, TagKey<Block> incorrectBlocks, int uses, float speed, float attack, int enchantment, String repairitemtag, float density)
	{
		this.name = name;
		this.incorrectBlocks = incorrectBlocks;
		this.uses = uses;
		this.speed = speed;
		this.attackDamageBonus = attack;
		this.enchantmentValue = enchantment;
		this.repairIngredient = () -> Ingredient.of(TagKey.create(Registries.ITEM, ResourceLocation.parse(repairitemtag)));
		this.density = density;
	}

	@Override
	public float getAttackDamageBonus()
	{
		return attackDamageBonus;
	}

	@Override
	public @NotNull TagKey<Block> getIncorrectBlocksForDrops()
	{
		return this.incorrectBlocks;
	}

	@Override
	public int getEnchantmentValue()
	{
		return enchantmentValue;
	}

	@Override
	public Ingredient getRepairIngredient()
	{
		return repairIngredient.get();
	}

	@Override
	public float getSpeed()
	{
		return speed;
	}

	@Override
	public int getUses()
	{
		return uses;
	}

	public String getMaterialName()
	{
		return name;
	}

	public float getDensity()
	{
		return density;
	}
}
