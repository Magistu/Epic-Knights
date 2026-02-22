package com.magistuarmory.item.armor;

import com.magistuarmory.client.render.model.ModModels;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
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
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public class ArmorType implements ArmorMaterial {
	private transient ResourceLocation location;
	private transient ResourceLocation modelLocation;
	@ConfigEntry.Gui.RequiresRestart
	private float toughness;
	@ConfigEntry.Gui.RequiresRestart
	private float knockbackResistance;
	@ConfigEntry.Gui.RequiresRestart
	private int bootsDurability;
	@ConfigEntry.Gui.RequiresRestart
	private int leggingsDurability;
	@ConfigEntry.Gui.RequiresRestart
	private int chestplateDurability;
	@ConfigEntry.Gui.RequiresRestart
	private int helmetDurability;
	@ConfigEntry.Gui.RequiresRestart
	private int bootsDefense;
	@ConfigEntry.Gui.RequiresRestart
	private int leggingsDefense;
	@ConfigEntry.Gui.RequiresRestart
	private int chestplateDefense;
	@ConfigEntry.Gui.RequiresRestart
	private int helmetDefense;
	@ConfigEntry.Gui.RequiresRestart
	private int enchantmentValue;
	private transient SoundEvent equipSound;
	@ConfigEntry.Gui.RequiresRestart
	private boolean enabled;
	private transient Supplier<Ingredient> repairIngredient = () -> Ingredient.EMPTY;

	private ArmorType() {}

	public ArmorType(ResourceLocation location,
					  ResourceLocation modelLocation,
					  float toughness,
					  float knockbackResistance,
					  Integer[] durability,
					  Integer[] defenseForSlot,
					  int enchantmentValue,
					  SoundEvent equipSound,
					  boolean enabled,
					  Supplier<Ingredient> repairIngredient) {
		this.location = location;
		this.modelLocation = modelLocation;
		System.out.println(this.modelLocation);
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.bootsDurability = durability[0];
		this.leggingsDurability = durability[1];
		this.chestplateDurability = durability[2];
		this.helmetDurability = durability[3];
		this.bootsDefense = defenseForSlot[0];
		this.leggingsDefense = defenseForSlot[1];
		this.chestplateDefense = defenseForSlot[2];
		this.helmetDefense = defenseForSlot[3];
		this.enchantmentValue = enchantmentValue;
		this.equipSound = equipSound;
		this.enabled = enabled;
		if (repairIngredient != null) this.repairIngredient = repairIngredient;
	}

	public ArmorType(ResourceLocation location,
							   ResourceLocation modelLocation,
							   float toughness,
							   float knockbackResistance,
							   Integer[] durability,
							   Integer[] defenseForSlot,
							   int enchantmentValue,
							   SoundEvent equipSound,
							   boolean enabled) {

		this(location, modelLocation, toughness, knockbackResistance, durability, defenseForSlot, enchantmentValue, equipSound, enabled,
				() -> Ingredient.EMPTY);
	}

	public ArmorType(ResourceLocation location,
							   ResourceLocation modelLocation,
							   float toughness,
							   float knockbackResistance,
							   Integer[] durability,
							   Integer[] defenseForSlot,
							   int enchantmentValue,
							   SoundEvent equipSound,
							   boolean enabled,
							   String repairItemTag) {

		this(location, modelLocation, toughness, knockbackResistance, durability, defenseForSlot, enchantmentValue, equipSound, enabled,
				() -> Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation(repairItemTag))));
	}

	public ArmorType(ResourceLocation location,
							   ResourceLocation modelLocation,
							   ArmorMaterial material,
							   boolean enabled) {
		this(
				location,
				modelLocation,
				material.getToughness(),
				material.getKnockbackResistance(),
				new Integer[]{
						material.getDurabilityForType(ArmorItem.Type.BOOTS),
						material.getDurabilityForType(ArmorItem.Type.LEGGINGS),
						material.getDurabilityForType(ArmorItem.Type.CHESTPLATE),
						material.getDurabilityForType(ArmorItem.Type.HELMET)
				},
				new Integer[]{
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

	@Override
	public @NotNull String getName() {
		return this.location.toString();
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
	public int getDurabilityForType(@NotNull ArmorItem.Type type) {
        return switch (type) {
            case BOOTS -> this.bootsDurability;
            case LEGGINGS -> this.leggingsDurability;
            case CHESTPLATE -> this.chestplateDurability;
            case HELMET -> this.helmetDurability;
        };
	}

	@Override
	public int getDefenseForType(@NotNull ArmorItem.Type type) {
		return switch (type) {
			case BOOTS -> this.bootsDefense;
			case LEGGINGS -> this.leggingsDefense;
			case CHESTPLATE -> this.chestplateDefense;
			case HELMET -> this.helmetDefense;
		};
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public @NotNull SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public @NotNull Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	public boolean isDisabled() {
		return !this.enabled;
	}

	@Environment(EnvType.CLIENT)
	public Optional<ModelLayerLocation> getModelLocation() {
		if (Objects.equals(this.modelLocation.getPath(), "default"))
			return Optional.empty();
		return Optional.of(ModModels.createArmorLocation(this.modelLocation));
	}
}