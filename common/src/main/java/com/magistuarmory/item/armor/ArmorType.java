package com.magistuarmory.item.armor;

import com.magistuarmory.client.render.model.ModModels;
import dev.architectury.registry.registries.DeferredRegister;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Util;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;

import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public final class ArmorType
{
	private final ArmorMaterial material;
	private final Identifier location;
	private final Identifier modellocation;
	private final EnumMap<net.minecraft.world.item.equipment.ArmorType, Integer> durability;
	private final boolean enabled;

	public ArmorType(Identifier location, Identifier modellocation, ArmorMaterial material, Integer[] durability, boolean enabled)
	{
		this.material = material;
		this.location = location;
		this.modellocation = modellocation;
		this.durability = Util.make(new EnumMap<>(net.minecraft.world.item.equipment.ArmorType.class), (enumMap) -> {
			enumMap.put(net.minecraft.world.item.equipment.ArmorType.BOOTS, durability[0]);
			enumMap.put(net.minecraft.world.item.equipment.ArmorType.LEGGINGS, durability[1]);
			enumMap.put(net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, durability[2]);
			enumMap.put(net.minecraft.world.item.equipment.ArmorType.HELMET, durability[3]);
			enumMap.put(net.minecraft.world.item.equipment.ArmorType.BODY, durability[2]);
		});
		this.enabled = enabled;
	}

	public ArmorType(Identifier location, Identifier modellocation, float toughness, float knockbackResistance, Integer[] durability, Integer[] defenseForSlot, int enchantmentValue, Holder<SoundEvent> equipSound, boolean enabled, boolean dyeable, TagKey<net.minecraft.world.item.Item> repairIngredient)
	{
        this.material = new ArmorMaterial(1,
                java.util.Map.of(
                    net.minecraft.world.item.equipment.ArmorType.BOOTS, defenseForSlot[0],
                    net.minecraft.world.item.equipment.ArmorType.LEGGINGS, defenseForSlot[1],
                    net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, defenseForSlot[2],
                    net.minecraft.world.item.equipment.ArmorType.HELMET, defenseForSlot[3],
                    net.minecraft.world.item.equipment.ArmorType.BODY, defenseForSlot[2]),
                enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient,
                net.minecraft.resources.ResourceKey.create(net.minecraft.world.item.equipment.EquipmentAssets.ROOT_ID, location));

		this.location = location;
		this.modellocation = modellocation;
		this.durability = Util.make(new EnumMap<>(net.minecraft.world.item.equipment.ArmorType.class), (enumMap) -> {
			enumMap.put(net.minecraft.world.item.equipment.ArmorType.BOOTS, durability[0]);
			enumMap.put(net.minecraft.world.item.equipment.ArmorType.LEGGINGS, durability[1]);
			enumMap.put(net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, durability[2]);
			enumMap.put(net.minecraft.world.item.equipment.ArmorType.BODY, durability[2]);
			enumMap.put(net.minecraft.world.item.equipment.ArmorType.HELMET, durability[3]);
		});
		this.enabled = enabled;
	}

	public ArmorType(Identifier location, Identifier modellocation, float toughness, float knockbackResistance, Integer[] durability, Integer[] defenseForSlot, int enchantmentValue, Holder<SoundEvent> equipSound, boolean enabled, boolean dyeable)
	{
		this(location, modellocation, toughness, knockbackResistance, durability, defenseForSlot, enchantmentValue, equipSound, enabled, dyeable, TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("magistuarmory", "unrepairable")));
	}

	public ArmorType(Identifier location, Identifier modellocation, float toughness, float knockbackResistance, Integer[] durability, Integer[] defenseForSlot, int enchantmentValue, Holder<SoundEvent> equipSound, boolean enabled, boolean dyeable, String repairitemtag)
	{
		this(location, modellocation, toughness, knockbackResistance, durability, defenseForSlot, enchantmentValue, equipSound, enabled, dyeable, TagKey.create(Registries.ITEM, Identifier.parse(repairitemtag)));
	}

	public String getName() {
		return this.location.toString();
	}

	public float getToughness() {
		return this.material.toughness();
	}

	public float getKnockbackResistance() {
		return this.material.knockbackResistance();
	}

	public int getDurabilityForType(net.minecraft.world.item.equipment.ArmorType type) {
		return this.durability.get(type);
	}

	public int getDefenseForType(net.minecraft.world.item.equipment.ArmorType type) {
		return this.material.defense().getOrDefault(type, 0);
	}

	public int getEnchantmentValue() {
		return this.material.enchantmentValue();
	}

	public Holder<SoundEvent> getEquipSound() {
		return this.material.equipSound();
	}

	public TagKey<net.minecraft.world.item.Item> getRepairIngredient() {
		return this.material.repairIngredient();
	}
	
	public boolean isDisabled()
	{
		return !this.enabled;
	}
	
	@Environment(EnvType.CLIENT)
	public Optional<ModelLayerLocation> getModelLocation()
	{
		if (Objects.equals(this.modellocation.getPath(), "default"))
			return Optional.empty();
		return Optional.of(ModModels.createArmorLocation(this.modellocation));
	}

	public ArmorMaterial getMaterial()
	{
		return this.material;
	}

	public Identifier getLocation()
	{
		return this.location;
	}
}
