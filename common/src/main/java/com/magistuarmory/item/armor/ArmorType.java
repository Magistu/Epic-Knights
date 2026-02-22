package com.magistuarmory.item.armor;

import java.util.EnumMap;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import com.magistuarmory.client.render.model.ModModels;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeConfigSpec;
import org.jetbrains.annotations.NotNull;

public final class ArmorType implements ArmorMaterial
{
	private final ResourceLocation location;
	private final ResourceLocation modellocation;
	private final Supplier<Double> toughness;
	private final Supplier<Double> knockbackResistance;
	private final EnumMap<ArmorItem.Type, Supplier<Integer>> durability;
	private final EnumMap<ArmorItem.Type, Supplier<Integer>> defenseForSlot;
	private final Supplier<Integer> enchantmentValue;
	private final SoundEvent equipSound;
	private final Supplier<Boolean> enabled;
	
	private Supplier<Ingredient> repairIngredient = () -> Ingredient.EMPTY;

	public ArmorType(ForgeConfigSpec.Builder builder, ResourceLocation location, ResourceLocation modellocation, ArmorMaterial material, boolean enabled)
	{
		this(
				builder,
				location, 
				modellocation, 
				material.getToughness(),
				material.getKnockbackResistance(),
				new Integer[] {
						material.getDurabilityForType(ArmorItem.Type.BOOTS),
						material.getDurabilityForType(ArmorItem.Type.LEGGINGS),
						material.getDurabilityForType(ArmorItem.Type.CHESTPLATE),
						material.getDurabilityForType(ArmorItem.Type.HELMET)
				},
				new Integer[] {
						material.getDefenseForType(ArmorItem.Type.BOOTS),
						material.getDefenseForType(ArmorItem.Type.LEGGINGS),
						material.getDefenseForType(ArmorItem.Type.CHESTPLATE),
						material.getDefenseForType(ArmorItem.Type.HELMET)
				},
				material.getEnchantmentValue(),
				material.getEquipSound(),
				enabled,
				material::getRepairIngredient
		);
	}

	public ArmorType(ForgeConfigSpec.Builder builder, ResourceLocation location, ResourceLocation modellocation, float toughness, float knockbackResistance, Integer[] durability, Integer[] defenseForSlot, int enchantmentValue, SoundEvent equipSound, boolean enabled, Supplier<Ingredient> repairIngredient)
	{
		this(builder, location, modellocation, toughness, knockbackResistance, durability, defenseForSlot, enchantmentValue, equipSound, enabled);
		this.repairIngredient = repairIngredient;
	}

	public ArmorType(ForgeConfigSpec.Builder builder, ResourceLocation location, ResourceLocation modellocation, float toughness, float knockbackResistance, Integer[] durability, Integer[] defenseForSlot, int enchantmentValue, SoundEvent equipSound, boolean enabled, String repairitemtag)
	{
		this(builder, location, modellocation, toughness, knockbackResistance, durability, defenseForSlot, enchantmentValue, equipSound, enabled);
		this.repairIngredient = () -> Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation(repairitemtag)));
	}

	public ArmorType(ForgeConfigSpec.Builder builder, ResourceLocation location, ResourceLocation modellocation, float toughness, float knockbackResistance, Integer[] durability, Integer[] defenseForSlot, int enchantmentValue, SoundEvent equipSound, boolean enabled)
	{
		builder.push(location.getPath());

		this.location = location;
		this.modellocation = modellocation;
		this.toughness = builder.defineInRange("toughness", toughness, 0, Integer.MAX_VALUE);
		this.knockbackResistance = builder.defineInRange("knockbackResistance", knockbackResistance, 0, Integer.MAX_VALUE);

		this.durability = new EnumMap<>(ArmorItem.Type.class);
		this.durability.put(ArmorItem.Type.BOOTS, builder.defineInRange("bootsDurability", durability[0], 0, Integer.MAX_VALUE));
		this.durability.put(ArmorItem.Type.LEGGINGS, builder.defineInRange("leggingsDurability", durability[1], 0, Integer.MAX_VALUE));
		this.durability.put(ArmorItem.Type.CHESTPLATE, builder.defineInRange("chestplateDurability", durability[2], 0, Integer.MAX_VALUE));
		this.durability.put(ArmorItem.Type.HELMET, builder.defineInRange("helmetDurability", durability[3], 0, Integer.MAX_VALUE));

		this.defenseForSlot = new EnumMap<>(ArmorItem.Type.class);
		this.defenseForSlot.put(ArmorItem.Type.BOOTS, builder.defineInRange("bootsDefense", defenseForSlot[0], 0, Integer.MAX_VALUE));
		this.defenseForSlot.put(ArmorItem.Type.LEGGINGS, builder.defineInRange("leggingsDefense", defenseForSlot[1], 0, Integer.MAX_VALUE));
		this.defenseForSlot.put(ArmorItem.Type.CHESTPLATE, builder.defineInRange("chestplateDefense", defenseForSlot[2], 0, Integer.MAX_VALUE));
		this.defenseForSlot.put(ArmorItem.Type.HELMET, builder.defineInRange("helmetDefense", defenseForSlot[3], 0, Integer.MAX_VALUE));

		this.enchantmentValue = builder.defineInRange("enchantmentValue", enchantmentValue, 0, Integer.MAX_VALUE);
		this.equipSound = equipSound;
		this.enabled = builder.define("enabled", enabled);

		builder.pop();
	}

	// use constructor with builder and name parameters
	@Deprecated(forRemoval = true)
	public ArmorType(ResourceLocation location, ResourceLocation modellocation, ArmorMaterial material, boolean enabled)
	{
		this(
				location,
				modellocation,
				material.getToughness(),
				material.getKnockbackResistance(),
				new Integer[] {
						material.getDurabilityForType(ArmorItem.Type.BOOTS),
						material.getDurabilityForType(ArmorItem.Type.LEGGINGS),
						material.getDurabilityForType(ArmorItem.Type.CHESTPLATE),
						material.getDurabilityForType(ArmorItem.Type.HELMET)
				},
				new Integer[] {
						material.getDefenseForType(ArmorItem.Type.BOOTS),
						material.getDefenseForType(ArmorItem.Type.LEGGINGS),
						material.getDefenseForType(ArmorItem.Type.CHESTPLATE),
						material.getDefenseForType(ArmorItem.Type.HELMET)
				},
				material.getEnchantmentValue(),
				material.getEquipSound(),
				enabled,
				material::getRepairIngredient
		);
	}

	// use constructor with builder and name parameters
	@Deprecated(forRemoval = true)
	public ArmorType(ResourceLocation location, ResourceLocation modellocation, float toughness, float knockbackResistance, Integer[] durability, Integer[] defenseForSlot, int enchantmentValue, SoundEvent equipSound, boolean enabled, Supplier<Ingredient> repairIngredient)
	{
		this(location, modellocation, toughness, knockbackResistance, durability, defenseForSlot, enchantmentValue, equipSound, enabled);
		this.repairIngredient = repairIngredient;
	}

	// use constructor with builder and name parameters
	@Deprecated(forRemoval = true)
	public ArmorType(ResourceLocation location, ResourceLocation modellocation, float toughness, float knockbackResistance, Integer[] durability, Integer[] defenseForSlot, int enchantmentValue, SoundEvent equipSound, boolean enabled, String repairitemtag)
	{
		this(location, modellocation, toughness, knockbackResistance, durability, defenseForSlot, enchantmentValue, equipSound, enabled);
		this.repairIngredient = () -> Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation(repairitemtag)));
	}

	// use constructor with builder and name parameters
	@Deprecated(forRemoval = true)
	public ArmorType(ResourceLocation location, ResourceLocation modellocation, float toughness, float knockbackResistance, Integer[] durability, Integer[] defenseForSlot, int enchantmentValue, SoundEvent equipSound, boolean enabled)
	{
		this.location = location;
		this.modellocation = modellocation;
		this.toughness = () -> Double.valueOf(toughness);
		this.knockbackResistance = () -> Double.valueOf(knockbackResistance);

		this.durability = new EnumMap<>(ArmorItem.Type.class);
		this.durability.put(ArmorItem.Type.BOOTS, () -> durability[0]);
		this.durability.put(ArmorItem.Type.LEGGINGS, () -> durability[1]);
		this.durability.put(ArmorItem.Type.CHESTPLATE, () -> durability[2]);
		this.durability.put(ArmorItem.Type.HELMET, () -> durability[3]);

		this.defenseForSlot = new EnumMap<>(ArmorItem.Type.class);
		this.defenseForSlot.put(ArmorItem.Type.BOOTS, () -> defenseForSlot[0]);
		this.defenseForSlot.put(ArmorItem.Type.LEGGINGS, () -> defenseForSlot[1]);
		this.defenseForSlot.put(ArmorItem.Type.CHESTPLATE, () -> defenseForSlot[2]);
		this.defenseForSlot.put(ArmorItem.Type.HELMET, () -> defenseForSlot[3]);

		this.enchantmentValue = () -> enchantmentValue;
		this.equipSound = equipSound;
		this.enabled = () -> enabled;
	}

	@Override
	public String getName() {
		return this.location.toString();
	}

	@Override
	public float getToughness() {
		return this.toughness.get().floatValue();
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance.get().floatValue();
	}

	@Override
	public int getDurabilityForType(ArmorItem.@NotNull Type type) {
		return this.durability.get(type).get();
	}

	@Override
	public int getDefenseForType(ArmorItem.@NotNull Type type) {
		return this.defenseForSlot.get(type).get();
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue.get();
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
		return !this.enabled.get();
	}
	
	@Environment(EnvType.CLIENT)
	public Optional<ModelLayerLocation> getModelLocation()
	{
		if (Objects.equals(this.modellocation.getPath(), "default"))
			return Optional.empty();
		return Optional.of(ModModels.createArmorLocation(this.modellocation));
	}
}
