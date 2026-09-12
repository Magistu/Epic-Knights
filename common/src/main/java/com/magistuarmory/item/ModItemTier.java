package com.magistuarmory.item;

import dev.architectury.platform.Platform;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ModItemTier
{
	private final String name;
	private final float attackDamageBonus;
	private final int enchantmentValue;
	private final TagKey<Item> repairItems;
	private final float speed;
	private final int uses;
	private final float density;

	public static ModItemTier WOOD = new ModItemTier("wood", ToolMaterial.WOOD, 0);
	public static ModItemTier STONE = new ModItemTier("stone", ToolMaterial.STONE, 1);
	public static ModItemTier IRON = new ModItemTier("iron", ToolMaterial.IRON, 2);
	public static ModItemTier DIAMOND = new ModItemTier("diamond", ToolMaterial.DIAMOND, 3);
	public static ModItemTier GOLD = new ModItemTier("gold", ToolMaterial.GOLD, 4);
	public static ModItemTier NETHERITE = new ModItemTier("netherite", ToolMaterial.NETHERITE, 5);

	public static ModItemTier COPPER = new ModItemTier("copper", BlockTags.INCORRECT_FOR_STONE_TOOL, 150, 0.7F, 0.0F, 10, "c:ingots/copper", 1);
	public static ModItemTier SILVER = new ModItemTier("silver", BlockTags.INCORRECT_FOR_STONE_TOOL, 230, 5.5F, 1.0F, 18, "c:ingots/silver", 2);
	public static ModItemTier STEEL = new ModItemTier("steel", BlockTags.INCORRECT_FOR_IRON_TOOL, 400, 6.0F, 2.5F, 14, "c:ingots/steel", 2);
	public static ModItemTier TIN = new ModItemTier("tin", BlockTags.INCORRECT_FOR_STONE_TOOL, 130, 6.0F, 0.0F, 20, "c:ingots/tin", 2);
	public static ModItemTier BRONZE = new ModItemTier("bronze", BlockTags.INCORRECT_FOR_IRON_TOOL, 200, 6.0F, 2.0F, 15, "c:ingots/bronze", 2);
	private final TagKey<Block> incorrectBlocks;

	public ModItemTier(String name, ToolMaterial tier, float density)
	{
		this.name = name;
		this.incorrectBlocks = tier.incorrectBlocksForDrops();
		this.uses = tier.durability();
		this.speed = tier.speed();
		this.attackDamageBonus = tier.attackDamageBonus();
		this.enchantmentValue = tier.enchantmentValue();
		this.repairItems = tier.repairItems();
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
		this.repairItems = TagKey.create(Registries.ITEM, Identifier.parse(repairitemtag));
		this.density = density;
	}


	public float getAttackDamageBonus()
	{
		return attackDamageBonus;
	}


	public @NotNull TagKey<Block> getIncorrectBlocksForDrops()
	{
		return this.incorrectBlocks;
	}


	public int getEnchantmentValue()
	{
		return enchantmentValue;
	}


	public Ingredient getRepairIngredient()
	{
		return Ingredient.of(net.minecraft.core.registries.BuiltInRegistries.ITEM.getOrThrow(repairItems));
	}


	public float getSpeed()
	{
		return speed;
	}


	public int getUses()
	{
		return uses;
	}

	public ToolMaterial asToolMaterial() {
		return new ToolMaterial(incorrectBlocks, uses, speed, attackDamageBonus, enchantmentValue, repairItems);
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
