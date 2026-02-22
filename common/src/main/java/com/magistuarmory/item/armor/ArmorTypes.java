package com.magistuarmory.item.armor;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.config.ArmorConfig;
import dev.architectury.platform.Platform;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class ArmorTypes
{
	public static final ArmorConfig ARMOR_CONFIG = EpicKnights.CONFIG.armor;

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
		MINICROWN = create(new ResourceLocation("magistuarmory", "minicrown"), new ResourceLocation("magistuarmory:minicrown"), ARMOR_CONFIG.get("minicrown"), SoundEvents.ARMOR_EQUIP_GOLD, Platform.isForge() ? "forge:ingots/gold" : "c:gold_ingots");
		CROWN = create(new ResourceLocation("magistuarmory", "crown"), new ResourceLocation("magistuarmory:crown"), ARMOR_CONFIG.get("crown"), SoundEvents.ARMOR_EQUIP_GOLD, Platform.isForge() ? "forge:ingots/gold" : "c:gold_ingots");
		FLOWERCROWN = create(new ResourceLocation("magistuarmory", "flowercrown"), new ResourceLocation("magistuarmory:flowercrown"), ARMOR_CONFIG.get("flowercrown"), SoundEvents.ARMOR_EQUIP_LEATHER);
		KNIGHT = create(new ResourceLocation("magistuarmory", "knight"), new ResourceLocation("default"), ARMOR_CONFIG.get("knight"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		ARMET = create(new ResourceLocation("magistuarmory", "armet"), new ResourceLocation("magistuarmory:armet"), ARMOR_CONFIG.get("armet"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		STECHHELM = create(new ResourceLocation("magistuarmory", "stechhelm"), new ResourceLocation("magistuarmory:stechhelm"), ARMOR_CONFIG.get("stechhelm"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		JOUSTING = create(new ResourceLocation("magistuarmory", "jousting"), new ResourceLocation("default"), ARMOR_CONFIG.get("jousting"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		SALLET = create(new ResourceLocation("magistuarmory", "sallet"), new ResourceLocation("magistuarmory:sallet"), ARMOR_CONFIG.get("sallet"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		GOTHIC = create(new ResourceLocation("magistuarmory", "gothic"), new ResourceLocation("default"), ARMOR_CONFIG.get("gothic"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		MAXIMILIAN_HELMET = create(new ResourceLocation("magistuarmory", "maximilian_helmet"), new ResourceLocation("magistuarmory:maximilian_helmet"), ARMOR_CONFIG.get("maximilianHelmet"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		MAXIMILIAN = create(new ResourceLocation("magistuarmory", "maximilian"), new ResourceLocation("default"), ARMOR_CONFIG.get("maximilian"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		CHAINMAIL = create(new ResourceLocation("magistuarmory", "chainmail"), new ResourceLocation("default"), ARMOR_CONFIG.get("chainmail"), SoundEvents.ARMOR_EQUIP_CHAIN, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		KETTLEHAT = create(new ResourceLocation("magistuarmory", "kettlehat"), new ResourceLocation("magistuarmory:kettlehat"), ARMOR_CONFIG.get("kettlehat"), SoundEvents.ARMOR_EQUIP_CHAIN, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		PLATEMAIL = create(new ResourceLocation("magistuarmory", "platemail"), new ResourceLocation("default"), ARMOR_CONFIG.get("platemail"), SoundEvents.ARMOR_EQUIP_CHAIN, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		BARBUTE = create(new ResourceLocation("magistuarmory", "barbute"), new ResourceLocation("magistuarmory:barbute"), ARMOR_CONFIG.get("barbute"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		HALFARMOR = create(new ResourceLocation("magistuarmory", "halfarmor"), new ResourceLocation("default"), ARMOR_CONFIG.get("halfarmor"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		GREATHELM = create(new ResourceLocation("magistuarmory", "greathelm"), new ResourceLocation("magistuarmory:crusader"), ARMOR_CONFIG.get("greathelm"), SoundEvents.ARMOR_EQUIP_CHAIN, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		CRUSADER = create(new ResourceLocation("magistuarmory", "crusader"), new ResourceLocation("default"), ARMOR_CONFIG.get("crusader"), SoundEvents.ARMOR_EQUIP_CHAIN, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		BRIGANDINE = create(new ResourceLocation("magistuarmory", "brigandine"), new ResourceLocation("default"), ARMOR_CONFIG.get("brigandine"), SoundEvents.ARMOR_EQUIP_LEATHER, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		GAMBESON = create(new ResourceLocation("magistuarmory", "gambeson"), new ResourceLocation("default"), ARMOR_CONFIG.get("gambeson"), SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(TagKey.create(Registries.ITEM, new ResourceLocation("magistuarmory:woolen_fabric"))));
		CEREMONIAL_ARMET = create(new ResourceLocation("magistuarmory", "ceremonialarmet"), new ResourceLocation("magistuarmory:armet"), ARMOR_CONFIG.get("ceremonialArmet"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		CEREMONIAL = create(new ResourceLocation("magistuarmory", "ceremonial"), new ResourceLocation("default"), ARMOR_CONFIG.get("ceremonial"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		SHISHAK = create(new ResourceLocation("magistuarmory", "shishak"), new ResourceLocation("magistuarmory:conic_helmet"), ARMOR_CONFIG.get("shishak"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		NORMAN = create(new ResourceLocation("magistuarmory", "norman"), new ResourceLocation("magistuarmory:conic_helmet"), ARMOR_CONFIG.get("norman"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_BARBUTE = create(new ResourceLocation("magistuarmory", "rustedbarbute"), new ResourceLocation("magistuarmory:barbute"), ARMOR_CONFIG.get("rustedBarbute"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_HALFARMOR = create(new ResourceLocation("magistuarmory", "rustedhalfarmor"), new ResourceLocation("default"), ARMOR_CONFIG.get("rustedHalfarmor"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_CHAINMAIL = create(new ResourceLocation("magistuarmory", "rustedchainmail"), new ResourceLocation("default"), ARMOR_CONFIG.get("rustedChainmail"), SoundEvents.ARMOR_EQUIP_CHAIN, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_KETTLEHAT = create(new ResourceLocation("magistuarmory", "rustedkettlehat"), new ResourceLocation("magistuarmory:kettlehat"), ARMOR_CONFIG.get("rustedKettlehat"), SoundEvents.ARMOR_EQUIP_CHAIN, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_NORMAN = create(new ResourceLocation("magistuarmory", "rustednorman"), new ResourceLocation("magistuarmory:conic_helmet"), ARMOR_CONFIG.get("rustedNorman"), SoundEvents.ARMOR_EQUIP_CHAIN, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_GREATHELM = create(new ResourceLocation("magistuarmory", "rustedgreathelm"), new ResourceLocation("magistuarmory:crusader"), ARMOR_CONFIG.get("rustedGreathelm"), SoundEvents.ARMOR_EQUIP_CHAIN, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		RUSTED_CRUSADER = create(new ResourceLocation("magistuarmory", "rustedcrusader"), new ResourceLocation("default"), ARMOR_CONFIG.get("rustedCrusader"), SoundEvents.ARMOR_EQUIP_CHAIN, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		BASCINET = create(new ResourceLocation("magistuarmory", "bascinet"), new ResourceLocation("magistuarmory:bascinet"), ARMOR_CONFIG.get("bascinet"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		XIV_CENTURY_KNIGHT = create(new ResourceLocation("magistuarmory", "xivcenturyknight"), new ResourceLocation("default"), ARMOR_CONFIG.get("xivCenturyKnight"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		WINGED_HUSSAR_CHESTPLATE = create(new ResourceLocation("magistuarmory", "wingedhussarchestplate"), new ResourceLocation("magistuarmory:wingedhussarchestplate"), ARMOR_CONFIG.get("wingedHussarChestplate"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		CUIRASSIER = create(new ResourceLocation("magistuarmory", "cuirassier"), new ResourceLocation("default"), ARMOR_CONFIG.get("cuirassier"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		KASTENBRUST = create(new ResourceLocation("magistuarmory", "kastenbrust"), new ResourceLocation("default"), ARMOR_CONFIG.get("kastenbrust"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		GRAND_BASCINET = create(new ResourceLocation("magistuarmory", "grand_bascinet"), new ResourceLocation("magistuarmory:grand_bascinet"), ARMOR_CONFIG.get("grandBascinet"), SoundEvents.ARMOR_EQUIP_IRON, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
		LAMELLAR = create(new ResourceLocation("magistuarmory", "lamellar"), new ResourceLocation("default"), ARMOR_CONFIG.get("lamellar"), SoundEvents.ARMOR_EQUIP_CHAIN, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
	}

	private static ArmorType create(ResourceLocation location,
									ResourceLocation modelLocation,
									ArmorConfig.ArmorTypeConfig config,
									SoundEvent equipSound,
									String repairItemTag) {
		return new ArmorType(location, modelLocation, config.toughness, config.knockbackResistance, new Integer[] {config.bootsDurability, config.leggingsDurability, config.chestplateDurability, config.helmetDurability}, new Integer[] {config.bootsDefense, config.leggingsDefense, config.chestplateDefense, config.helmetDefense}, config.enchantmentValue, equipSound, config.enabled, repairItemTag);
	}

	private static ArmorType create(ResourceLocation location,
									ResourceLocation modelLocation,
									ArmorConfig.ArmorTypeConfig config,
									SoundEvent equipSound,
									Supplier<Ingredient> ingredientSupplier) {
		return new ArmorType(location, modelLocation, config.toughness, config.knockbackResistance, new Integer[] {config.bootsDurability, config.leggingsDurability, config.chestplateDurability, config.helmetDurability}, new Integer[] {config.bootsDefense, config.leggingsDefense, config.chestplateDefense, config.helmetDefense}, config.enchantmentValue, equipSound, config.enabled, ingredientSupplier);
	}

	private static ArmorType create(ResourceLocation location,
									ResourceLocation modelLocation,
									ArmorConfig.ArmorTypeConfig config,
									SoundEvent equipSound) {
		return new ArmorType(location, modelLocation, config.toughness, config.knockbackResistance, new Integer[] {config.bootsDurability, config.leggingsDurability, config.chestplateDurability, config.helmetDurability}, new Integer[] {config.bootsDefense, config.leggingsDefense, config.chestplateDefense, config.helmetDefense}, config.enchantmentValue, equipSound, config.enabled);
	}
}
