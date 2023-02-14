package com.magistuarmory.item.armor;

import java.util.function.Supplier;

import com.magistuarmory.KnightlyArmory;

import com.magistuarmory.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum ArmorMaterials implements ArmorMaterial
{
	KNIGHT("knight", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),
	ARMET("armet", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	STECHHELM("stechhelm", 2.0f, 1.5f, new int[] { 345, 500, 440, 385 }, new int[] { 3, 6, 9, 4 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),
	JOUSTING("jousting", 2.0f, 1.5f, new int[] { 345, 500, 440, 385 }, new int[] { 3, 6, 9, 4 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	SALLET("sallet", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),
	GOTHIC("gothic", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	MAXIMILIANHELMET("maximilian_helmet", 1.8f, 0.5f, new int[] { 345, 500, 440, 385 }, new int[] { 3, 6, 9, 4 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),
	MAXIMILIAN("maximilian", 1.8f, 0.5f, new int[] { 345, 500, 440, 385 }, new int[] { 3, 6, 9, 4 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	CHAINMAIL("chainmail", 0.0f, 0f, new int[] { 170, 235, 250, 205 }, new int[] { 1, 4, 5, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	KETTLEHAT("kettlehat", 0.3f, 0f, new int[] { 200, 270, 200, 240 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),
	PLATEMAIL("platemail", 0.3f, 0f, new int[] { 200, 270, 200, 240 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	BARBUTE("barbute", 0.5f, 0f, new int[] { 180, 290, 315, 170 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),
	HALFARMOR("halfarmor", 0.5f, 0f, new int[] { 180, 290, 315, 170 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	CRUSADER("crusader", 0.6f, 0f, new int[] { 150, 280, 295, 220 }, new int[] { 1, 5, 6, 3 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	BRIGANDINE("brigandine", 0.25f, 0f, new int[] { 100, 200, 265, 170 }, new int[] { 2, 3, 5, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	GAMBESON("gambeson", 0f, 0f, new int[] { 100, 0, 128, 88 }, new int[] { 1, 0, 2, 1 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, () -> { return Ingredient.of(ModItems.WOOLEN_FABRIC.get()); }),

	CEREMONIAL_ARMET("ceremonialarmet", 1.25f, 0f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),
	CEREMONIAL("ceremonial", 1.25f, 0f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	SHISHAK("shishak", 0.3f, 0f, new int[] { 200, 270, 200, 210 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	NORMAN("norman", 0.2f, 0f, new int[] { 200, 270, 200, 190 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	RUSTED_BARBUTE("rustedbarbute", 0.0f, 0f, new int[] { 100, 160, 170, 90 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),
	RUSTED_HALFARMOR("rustedhalfarmor", 0.0f, 0f, new int[] { 100, 160, 170, 90 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	RUSTED_CHAINMAIL("rustedchainmail", 0.0f, 0f, new int[] { 85, 115, 125, 100 }, new int[] { 1, 4, 5, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	RUSTED_KETTLEHAT("rustedkettlehat", 0.0f, 0f, new int[] { 50, 185, 100, 120 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	RUSTED_NORMAN("rustednorman", 0.0f, 0f, new int[] { 100, 185, 100, 85 }, new int[] { 1, 4, 5, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	RUSTED_CRUSADER("rustedcrusader", 0.0f, 0f, new int[] { 75, 140, 150, 110 }, new int[] { 1, 5, 6, 3 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	BASCINET("bascinet", 1.25f, 0f, new int[] { 210, 300, 320, 250 }, new int[] { 2, 5, 7, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),
	XIV_CENTURY_KNIGHT("xivcenturyknight", 1.25f, 0f, new int[] { 210, 300, 320, 250 }, new int[] { 2, 5, 7, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	WINGEDHUSSARCHESTPLATE("wingedhussarchestplate", 1.0f, 0f, new int[] { 150, 0, 360, 170 }, new int[] { 1, 0, 7, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	CUIRASSIER("cuirassier", 0.5f, 0f, new int[] { 150, 0, 315, 170 }, new int[] { 1, 0, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	KASTENBRUST("kastenbrust", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),
	GRAND_BASCINET("grand_bascinet", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); }),

	LAMELLAR("lamellar", 0.3f, 0f, new int[] { 200, 270, 200, 240 }, new int[] { 2, 5, 6, 3 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, () -> { return Ingredient.of(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:ingots/steel"))); });

	private final String name;
	private final float toughness;
	private final float knockbackResistance;
	private final int[] durability;
	private final int[] defenseForSlot;
	private final int enchantmentValue;
	private final SoundEvent equipSound;
	private final Supplier<Ingredient> repairIngredient;

	ArmorMaterials(String name, float toughness, float knockbackResistance, int[] durability, int[] defenseForSlot, int enchantmentValue, SoundEvent equipSound, Supplier<Ingredient> repairIngredient)
	{
		this.name = KnightlyArmory.ID + ":" + name;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.durability = durability;
		this.defenseForSlot = defenseForSlot;
		this.enchantmentValue = enchantmentValue;
		this.equipSound = equipSound;
		this.repairIngredient = repairIngredient;
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
}
