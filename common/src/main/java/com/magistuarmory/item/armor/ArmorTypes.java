package com.magistuarmory.item.armor;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.config.ArmorConfig;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.equipment.ArmorMaterial;
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
		MINICROWN = create(Identifier.fromNamespaceAndPath("magistuarmory", "minicrown"), Identifier.parse("magistuarmory:minicrown"), ARMOR_CONFIG.get("minicrown"), SoundEvents.ARMOR_EQUIP_GOLD, false, "c:ingots/gold");
		CROWN = create(Identifier.fromNamespaceAndPath("magistuarmory", "crown"), Identifier.parse("magistuarmory:crown"), ARMOR_CONFIG.get("crown"), SoundEvents.ARMOR_EQUIP_GOLD, true, "c:ingots/gold");
		FLOWERCROWN = create(Identifier.fromNamespaceAndPath("magistuarmory", "flowercrown"), Identifier.parse("magistuarmory:flowercrown"), ARMOR_CONFIG.get("flowercrown"), SoundEvents.ARMOR_EQUIP_LEATHER, true);
		KNIGHT = create(Identifier.fromNamespaceAndPath("magistuarmory", "knight"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("knight"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		ARMET = create(Identifier.fromNamespaceAndPath("magistuarmory", "armet"), Identifier.parse("magistuarmory:armet"), ARMOR_CONFIG.get("armet"), SoundEvents.ARMOR_EQUIP_IRON, true, "c:ingots/steel");
		STECHHELM = create(Identifier.fromNamespaceAndPath("magistuarmory", "stechhelm"), Identifier.parse("magistuarmory:stechhelm"), ARMOR_CONFIG.get("stechhelm"), SoundEvents.ARMOR_EQUIP_IRON, true, "c:ingots/steel");
		JOUSTING = create(Identifier.fromNamespaceAndPath("magistuarmory", "jousting"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("jousting"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		SALLET = create(Identifier.fromNamespaceAndPath("magistuarmory", "sallet"), Identifier.parse("magistuarmory:sallet"), ARMOR_CONFIG.get("sallet"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		GOTHIC = create(Identifier.fromNamespaceAndPath("magistuarmory", "gothic"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("gothic"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		MAXIMILIAN_HELMET = create(Identifier.fromNamespaceAndPath("magistuarmory", "maximilian_helmet"), Identifier.parse("magistuarmory:maximilian_helmet"), ARMOR_CONFIG.get("maximilianHelmet"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		MAXIMILIAN = create(Identifier.fromNamespaceAndPath("magistuarmory", "maximilian"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("maximilian"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		CHAINMAIL = create(Identifier.fromNamespaceAndPath("magistuarmory", "chainmail"), Identifier.parse("magistuarmory:conic_helmet"), ARMOR_CONFIG.get("chainmail"), SoundEvents.ARMOR_EQUIP_CHAIN, false, "c:ingots/steel");
		KETTLEHAT = create(Identifier.fromNamespaceAndPath("magistuarmory", "kettlehat"), Identifier.parse("magistuarmory:kettlehat"), ARMOR_CONFIG.get("kettlehat"), SoundEvents.ARMOR_EQUIP_CHAIN, false, "c:ingots/steel");
		PLATEMAIL = create(Identifier.fromNamespaceAndPath("magistuarmory", "platemail"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("platemail"), SoundEvents.ARMOR_EQUIP_CHAIN, false, "c:ingots/steel");
		BARBUTE = create(Identifier.fromNamespaceAndPath("magistuarmory", "barbute"), Identifier.parse("magistuarmory:barbute"), ARMOR_CONFIG.get("barbute"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		HALFARMOR = create(Identifier.fromNamespaceAndPath("magistuarmory", "halfarmor"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("halfarmor"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		GREATHELM = create(Identifier.fromNamespaceAndPath("magistuarmory", "greathelm"), Identifier.parse("magistuarmory:crusader"), ARMOR_CONFIG.get("crusader"), SoundEvents.ARMOR_EQUIP_CHAIN, true, "c:ingots/steel");
		CRUSADER = create(Identifier.fromNamespaceAndPath("magistuarmory", "crusader"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("crusader"), SoundEvents.ARMOR_EQUIP_CHAIN, true, "c:ingots/steel");
		BRIGANDINE = create(Identifier.fromNamespaceAndPath("magistuarmory", "brigandine"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("brigandine"), SoundEvents.ARMOR_EQUIP_LEATHER, true, "c:ingots/steel");
		GAMBESON = create(Identifier.fromNamespaceAndPath("magistuarmory", "gambeson"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("gambeson"), SoundEvents.ARMOR_EQUIP_LEATHER, true, TagKey.create(Registries.ITEM, Identifier.parse("magistuarmory:woolen_fabric")));
		CEREMONIAL_ARMET = create(Identifier.fromNamespaceAndPath("magistuarmory", "ceremonialarmet"), Identifier.parse("magistuarmory:armet"), ARMOR_CONFIG.get("ceremonialArmet"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		CEREMONIAL = create(Identifier.fromNamespaceAndPath("magistuarmory", "ceremonial"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("ceremonial"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		SHISHAK = create(Identifier.fromNamespaceAndPath("magistuarmory", "shishak"), Identifier.parse("magistuarmory:conic_helmet"), ARMOR_CONFIG.get("shishak"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		NORMAN = create(Identifier.fromNamespaceAndPath("magistuarmory", "norman"), Identifier.parse("magistuarmory:conic_helmet"), ARMOR_CONFIG.get("norman"), SoundEvents.ARMOR_EQUIP_IRON, true, "c:ingots/steel");
		RUSTED_BARBUTE = create(Identifier.fromNamespaceAndPath("magistuarmory", "rustedbarbute"), Identifier.parse("magistuarmory:barbute"), ARMOR_CONFIG.get("rustedBarbute"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		RUSTED_HALFARMOR = create(Identifier.fromNamespaceAndPath("magistuarmory", "rustedhalfarmor"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("rustedHalfarmor"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		RUSTED_CHAINMAIL = create(Identifier.fromNamespaceAndPath("magistuarmory", "rustedchainmail"), Identifier.parse("magistuarmory:conic_helmet"), ARMOR_CONFIG.get("rustedChainmail"), SoundEvents.ARMOR_EQUIP_CHAIN, false, "c:ingots/steel");
		RUSTED_KETTLEHAT = create(Identifier.fromNamespaceAndPath("magistuarmory", "rustedkettlehat"), Identifier.parse("magistuarmory:kettlehat"), ARMOR_CONFIG.get("rustedKettlehat"), SoundEvents.ARMOR_EQUIP_CHAIN, false, "c:ingots/steel");
		RUSTED_NORMAN = create(Identifier.fromNamespaceAndPath("magistuarmory", "rustednorman"), Identifier.parse("magistuarmory:conic_helmet"), ARMOR_CONFIG.get("rustedNorman"), SoundEvents.ARMOR_EQUIP_CHAIN, false, "c:ingots/steel");
		RUSTED_GREATHELM = create(Identifier.fromNamespaceAndPath("magistuarmory", "rustedgreathelm"), Identifier.parse("magistuarmory:crusader"), ARMOR_CONFIG.get("rustedCrusader"), SoundEvents.ARMOR_EQUIP_CHAIN, false, "c:ingots/steel");
		RUSTED_CRUSADER = create(Identifier.fromNamespaceAndPath("magistuarmory", "rustedcrusader"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("rustedCrusader"), SoundEvents.ARMOR_EQUIP_CHAIN, false, "c:ingots/steel");
		BASCINET = create(Identifier.fromNamespaceAndPath("magistuarmory", "bascinet"), Identifier.parse("magistuarmory:bascinet"), ARMOR_CONFIG.get("bascinet"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		XIV_CENTURY_KNIGHT = create(Identifier.fromNamespaceAndPath("magistuarmory", "xivcenturyknight"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("xivCenturyKnight"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		WINGED_HUSSAR_CHESTPLATE = create(Identifier.fromNamespaceAndPath("magistuarmory", "wingedhussarchestplate"), Identifier.parse("magistuarmory:wingedhussarchestplate"), ARMOR_CONFIG.get("wingedHussarChestplate"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		CUIRASSIER = create(Identifier.fromNamespaceAndPath("magistuarmory", "cuirassier"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("cuirassier"), SoundEvents.ARMOR_EQUIP_IRON, true, "c:ingots/steel");
		KASTENBRUST = create(Identifier.fromNamespaceAndPath("magistuarmory", "kastenbrust"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("kastenbrust"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		GRAND_BASCINET = create(Identifier.fromNamespaceAndPath("magistuarmory", "grand_bascinet"), Identifier.parse("magistuarmory:grand_bascinet"), ARMOR_CONFIG.get("grandBascinet"), SoundEvents.ARMOR_EQUIP_IRON, false, "c:ingots/steel");
		LAMELLAR = create(Identifier.fromNamespaceAndPath("magistuarmory", "lamellar"), Identifier.withDefaultNamespace("default"), ARMOR_CONFIG.get("lamellar"), SoundEvents.ARMOR_EQUIP_CHAIN, false, "c:ingots/steel");
	}

	private static ArmorType create(
									Identifier location,
									Identifier modelLocation,
									ArmorConfig.ArmorTypeConfig config,
									Holder<SoundEvent> equipSound,
									boolean dyeable,
									String repairItemTag) {
		return new ArmorType(location, modelLocation, config.toughness, config.knockbackResistance, new Integer[] {config.bootsDurability, config.leggingsDurability, config.chestplateDurability, config.helmetDurability}, new Integer[] {config.bootsDefense, config.leggingsDefense, config.chestplateDefense, config.helmetDefense}, config.enchantmentValue, equipSound, config.enabled, dyeable, repairItemTag);
	}

	private static ArmorType create(
									Identifier location,
									Identifier modelLocation,
									ArmorConfig.ArmorTypeConfig config,
									Holder<SoundEvent> equipSound,
									boolean dyeable,
									TagKey<net.minecraft.world.item.Item> ingredientSupplier) {
		return new ArmorType(location, modelLocation, config.toughness, config.knockbackResistance, new Integer[] {config.bootsDurability, config.leggingsDurability, config.chestplateDurability, config.helmetDurability}, new Integer[] {config.bootsDefense, config.leggingsDefense, config.chestplateDefense, config.helmetDefense}, config.enchantmentValue, equipSound, config.enabled, dyeable, ingredientSupplier);
	}

	private static ArmorType create(
									Identifier location,
									Identifier modelLocation,
									ArmorConfig.ArmorTypeConfig config,
									Holder<SoundEvent> equipSound,
									boolean dyeable) {
		return new ArmorType(location, modelLocation, config.toughness, config.knockbackResistance, new Integer[] {config.bootsDurability, config.leggingsDurability, config.chestplateDurability, config.helmetDurability}, new Integer[] {config.bootsDefense, config.leggingsDefense, config.chestplateDefense, config.helmetDefense}, config.enchantmentValue, equipSound, config.enabled, dyeable);
	}

	public static void init() {

	}
}
