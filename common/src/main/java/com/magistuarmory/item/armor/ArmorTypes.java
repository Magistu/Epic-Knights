package com.magistuarmory.item.armor;

import dev.architectury.platform.Platform;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeConfigSpec;

public class ArmorTypes
{
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec ARMOR_CONFIG;

	public static final ArmorType MINICROWN;
	public static final ArmorType CROWN;
	public static final ArmorType FLOWERCROWN;
	public static final ArmorType KNIGHT;
	public static final ArmorType ARMET;
	public static final ArmorType STECHHELM;
	public static final ArmorType JOUSTING;
	public static final ArmorType SALLET;
	public static final ArmorType GOTHIC;
	public static final ArmorType MAXIMILIAN_HELMET;
	public static final ArmorType MAXIMILIAN;
	public static final ArmorType CHAINMAIL;
	public static final ArmorType KETTLEHAT;
	public static final ArmorType PLATEMAIL;
	public static final ArmorType BARBUTE;
	public static final ArmorType HALFARMOR;
	public static final ArmorType GREATHELM;
	public static final ArmorType CRUSADER;
	public static final ArmorType BRIGANDINE;
	public static final ArmorType GAMBESON;
	public static final ArmorType CEREMONIAL_ARMET;
	public static final ArmorType CEREMONIAL;
	public static final ArmorType SHISHAK;
	public static final ArmorType NORMAN;
	public static final ArmorType RUSTED_BARBUTE;
	public static final ArmorType RUSTED_HALFARMOR;
	public static final ArmorType RUSTED_CHAINMAIL;
	public static final ArmorType RUSTED_KETTLEHAT;
	public static final ArmorType RUSTED_NORMAN;
	public static final ArmorType RUSTED_GREATHELM;
	public static final ArmorType RUSTED_CRUSADER;
	public static final ArmorType BASCINET;
	public static final ArmorType XIV_CENTURY_KNIGHT;
	public static final ArmorType WINGED_HUSSAR_CHESTPLATE;
	public static final ArmorType CUIRASSIER;
	public static final ArmorType KASTENBRUST;
	public static final ArmorType GRAND_BASCINET;
	public static final ArmorType LAMELLAR;

	static {
		MINICROWN = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "minicrown"), new ResourceLocation("magistuarmory:minicrown"), 0.00f, 0.0f, new Integer[] { 0, 0, 0, 77 }, new Integer[] { 0, 0, 0, 2 }, 25, SoundEvents.ARMOR_EQUIP_GOLD, true, Platform.isForge() ? "forge:ingots/gold" : "c:gold_ingots");
		CROWN = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "crown"), new ResourceLocation("magistuarmory:crown"), 0.00f, 0.0f, new Integer[] { 0, 0, 0, 77 }, new Integer[] { 0, 0, 0, 2 }, 25, SoundEvents.ARMOR_EQUIP_GOLD, true, Platform.isForge() ? "forge:ingots/gold" : "c:gold_ingots");
		FLOWERCROWN = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "flowercrown"), new ResourceLocation("magistuarmory:flowercrown"), 0.00f, 0.0f, new Integer[] { 0, 0, 0, 77 }, new Integer[] { 0, 0, 0, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, true);
		KNIGHT = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "knight"), new ResourceLocation("default"), 1.25f, 0.5f, new Integer[] { 230, 315, 335, 0 }, new Integer[] { 2, 5, 8, 0 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		ARMET = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "armet"), new ResourceLocation("magistuarmory:armet"), 1.25f, 0.5f, new Integer[] { 0, 0, 0, 275 }, new Integer[] { 0, 0, 0, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		STECHHELM = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "stechhelm"), new ResourceLocation("magistuarmory:stechhelm"), 2.00f, 1.5f, new Integer[] { 0, 0, 0, 385 }, new Integer[] { 0, 0, 0, 4 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		JOUSTING = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "jousting"), new ResourceLocation("default"), 2.00f, 1.5f, new Integer[] { 345, 440, 500, 0 }, new Integer[] { 3, 6, 9, 0 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		SALLET = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "sallet"), new ResourceLocation("magistuarmory:sallet"), 1.25f, 0.5f, new Integer[] { 0, 0, 0, 275 }, new Integer[] { 0, 0, 0, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		GOTHIC = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "gothic"), new ResourceLocation("default"), 1.25f, 0.5f, new Integer[] { 230, 315, 335, 0 }, new Integer[] { 2, 5, 8, 0 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		MAXIMILIAN_HELMET = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "maximilian_helmet"), new ResourceLocation("magistuarmory:maximilian_helmet"), 1.80f, 0.5f, new Integer[] { 0, 0, 0, 385 }, new Integer[] { 0, 0, 0, 4 }, 12, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		MAXIMILIAN = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "maximilian"), new ResourceLocation("default"), 1.80f, 0.5f, new Integer[] { 345, 440, 500, 0 }, new Integer[] { 3, 6, 9, 0 }, 12, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		CHAINMAIL = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "chainmail"), new ResourceLocation("default"), 0.00f, 0.0f, new Integer[] { 170, 235, 250, 205 }, new Integer[] { 1, 4, 5, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		KETTLEHAT = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "kettlehat"), new ResourceLocation("magistuarmory:kettlehat"), 0.50f, 0.0f, new Integer[] { 0, 0, 0, 240 }, new Integer[] { 0, 0, 0, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		PLATEMAIL = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "platemail"), new ResourceLocation("default"), 0.50f, 0.0f, new Integer[] { 200, 230, 290, 0 }, new Integer[] { 3, 4, 6, 0 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		BARBUTE = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "barbute"), new ResourceLocation("magistuarmory:barbute"), 0.50f, 0.0f, new Integer[] { 0, 0, 0, 170 }, new Integer[] { 0, 0, 0, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		HALFARMOR = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "halfarmor"), new ResourceLocation("default"), 0.50f, 0.0f, new Integer[] { 0, 0, 315, 0 }, new Integer[] { 0, 0, 6, 0 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		GREATHELM = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "greathelm"), new ResourceLocation("magistuarmory:crusader"), 0.60f, 0.0f, new Integer[] { 150, 280, 295, 220 }, new Integer[] { 1, 5, 6, 3 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		CRUSADER = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "crusader"), new ResourceLocation("default"), 0.60f, 0.0f, new Integer[] { 150, 280, 295, 220 }, new Integer[] { 1, 5, 6, 3 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		BRIGANDINE = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "brigandine"), new ResourceLocation("default"), 0.25f, 0.0f, new Integer[] { 0, 0, 265, 0 }, new Integer[] { 0, 0, 5, 0 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		GAMBESON = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "gambeson"), new ResourceLocation("default"), 0.00f, 0.0f, new Integer[] { 100, 100, 128, 88 }, new Integer[] { 1, 1, 3, 1 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, true, () -> Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("magistuarmory:woolen_fabric"))));
		CEREMONIAL_ARMET = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "ceremonialarmet"), new ResourceLocation("magistuarmory:armet"), 1.25f, 0.5f, new Integer[] { 0, 0, 0, 275 }, new Integer[] { 0, 0, 0, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		CEREMONIAL = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "ceremonial"), new ResourceLocation("default"), 1.25f, 0.5f, new Integer[] { 230, 0, 335, 0 }, new Integer[] { 2, 0, 8, 0 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		SHISHAK = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "shishak"), new ResourceLocation("magistuarmory:conic_helmet"), 0.30f, 0.0f, new Integer[] { 0, 0, 0, 210 }, new Integer[] { 0, 0, 0, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		NORMAN = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "norman"), new ResourceLocation("magistuarmory:conic_helmet"), 0.20f, 0.0f, new Integer[] { 0, 0, 0, 190 }, new Integer[] { 0, 0, 0, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_BARBUTE = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "rustedbarbute"), new ResourceLocation("magistuarmory:barbute"), 0.00f, 0.0f, new Integer[] { 0, 0, 0, 90 }, new Integer[] { 0, 0, 0, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_HALFARMOR = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "rustedhalfarmor"), new ResourceLocation("default"), 0.00f, 0.0f, new Integer[] { 0, 0, 170, 0 }, new Integer[] { 0, 0, 6, 0 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_CHAINMAIL = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "rustedchainmail"), new ResourceLocation("default"), 0.00f, 0.0f, new Integer[] { 85, 115, 125, 100 }, new Integer[] { 1, 4, 5, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_KETTLEHAT = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "rustedkettlehat"), new ResourceLocation("magistuarmory:kettlehat"), 0.00f, 0.0f, new Integer[] { 0, 0, 0, 120 }, new Integer[] { 0, 0, 0, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_NORMAN = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "rustednorman"), new ResourceLocation("magistuarmory:conic_helmet"), 0.00f, 0.0f, new Integer[] { 0, 0, 0, 85 }, new Integer[] { 0, 0, 0, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_GREATHELM = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "rustedgreathelm"), new ResourceLocation("magistuarmory:crusader"), 0.00f, 0.0f, new Integer[] { 75, 0, 150, 110 }, new Integer[] { 1, 0, 6, 3 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_CRUSADER = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "rustedcrusader"), new ResourceLocation("default"), 0.00f, 0.0f, new Integer[] { 75, 0, 150, 110 }, new Integer[] { 1, 0, 6, 3 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		BASCINET = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "bascinet"), new ResourceLocation("magistuarmory:bascinet"), 1.25f, 0.0f, new Integer[] { 0, 0, 0, 250 }, new Integer[] { 0, 0, 0, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		XIV_CENTURY_KNIGHT = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "xivcenturyknight"), new ResourceLocation("default"), 1.25f, 0.0f, new Integer[] { 210, 300, 320, 0 }, new Integer[] { 2, 5, 7, 0 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		WINGED_HUSSAR_CHESTPLATE = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "wingedhussarchestplate"), new ResourceLocation("magistuarmory:wingedhussarchestplate"), 0.50f, 0.0f, new Integer[] { 0, 0, 360, 0 }, new Integer[] { 0, 0, 6, 0 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		CUIRASSIER = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "cuirassier"), new ResourceLocation("default"), 0.50f, 0.0f, new Integer[] { 150, 100, 315, 170 }, new Integer[] { 1, 1, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		KASTENBRUST = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "kastenbrust"), new ResourceLocation("default"), 1.25f, 0.5f, new Integer[] { 230, 315, 335, 0 }, new Integer[] { 2, 5, 8, 0 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		GRAND_BASCINET = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "grand_bascinet"), new ResourceLocation("magistuarmory:grand_bascinet"), 1.25f, 0.5f, new Integer[] { 0, 0, 0, 275 }, new Integer[] { 0, 0, 0, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		LAMELLAR = new ArmorType(BUILDER, new ResourceLocation("magistuarmory", "lamellar"), new ResourceLocation("default"), 0.30f, 0.0f, new Integer[] { 200, 0, 250, 240 }, new Integer[] { 2, 0, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, true, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

		ARMOR_CONFIG = BUILDER.build();
	}
}
