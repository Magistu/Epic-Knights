package com.magistuarmory.item.armor;

import java.util.function.Supplier;

import com.magistuarmory.EpicKnights;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public final class ArmorType implements ArmorMaterial
{
	private final String name;
	private final float toughness;
	private final float knockbackResistance;
	private final int[] durability;
	private final int[] defenseForSlot;
	private final int enchantmentValue;
	private final SoundEvent equipSound;
	private final boolean enabled;

	private Supplier<Ingredient> repairIngredient = () -> Ingredient.EMPTY;;

	ArmorType(String name, float toughness, float knockbackResistance, int[] durability, int[] defenseForSlot, int enchantmentValue, SoundEvent equipSound, boolean enabled)
	{
		this.name = EpicKnights.ID + ":" + name;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.durability = durability;
		this.defenseForSlot = defenseForSlot;
		this.enchantmentValue = enchantmentValue;
		this.equipSound = equipSound;
		this.enabled = enabled;
	}

	ArmorType(String name, float toughness, float knockbackResistance, int[] durability, int[] defenseForSlot, int enchantmentValue, SoundEvent equipSound, boolean enabled, Supplier<Ingredient> repairIngredient)
	{
		this(name, toughness, knockbackResistance, durability, defenseForSlot, enchantmentValue, equipSound, enabled);
		this.repairIngredient = repairIngredient;
	}

	ArmorType(String name, float toughness, float knockbackResistance, int[] durability, int[] defenseForSlot, int enchantmentValue, SoundEvent equipSound, boolean enabled, String repairitemtag)
	{
		this(name, toughness, knockbackResistance, durability, defenseForSlot, enchantmentValue, equipSound, enabled);
		this.repairIngredient = () -> Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(repairitemtag)));
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlot slot) {
		return this.durability[slot.getIndex()];
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot slot) {
		return this.defenseForSlot[slot.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	public boolean isDisabled()
	{
		return !this.enabled;
	}
}
