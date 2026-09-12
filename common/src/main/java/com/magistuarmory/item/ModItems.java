package com.magistuarmory.item;

import net.minecraft.core.registries.Registries;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.api.item.ModItemsProvider;
import com.magistuarmory.block.ModBlocks;
import com.magistuarmory.config.ShieldsConfig;
import com.magistuarmory.item.armor.*;
import com.magistuarmory.misc.ModBannerPatternTags;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.RegistrySupplier;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.material.MapColor;

import java.util.List;
import java.util.function.BiFunction;

public class ModItems extends ModItemsProvider
{
	private static final ShieldsConfig SHIELDS_CONFIG = EpicKnights.CONFIG.shields;

	public static ModItems INSTANCE = new ModItems();

	//Armor
    private static Properties properties(String id) {
        return new Properties().setId(net.minecraft.resources.ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(EpicKnights.ID, id)));
    }

	public static final @Nullable RegistrySupplier<KnightItem> ARMET = INSTANCE.addKnightItem("armet", ArmorTypes.ARMET, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("armet"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> KNIGHT_CHESTPLATE = INSTANCE.addMedievalArmorItem("knight_chestplate", ArmorTypes.KNIGHT, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("knight_chestplate"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> KNIGHT_LEGGINGS = INSTANCE.addMedievalArmorItem("knight_leggings", ArmorTypes.KNIGHT, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, properties("knight_leggings"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> KNIGHT_BOOTS = INSTANCE.addMedievalArmorItem("knight_boots", ArmorTypes.KNIGHT, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("knight_boots"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> STECHHELM = INSTANCE.addJoustingItem("stechhelm", ArmorTypes.STECHHELM, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("stechhelm"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> JOUSTING_CHESTPLATE = INSTANCE.addJoustingItem("jousting_chestplate", ArmorTypes.JOUSTING, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("jousting_chestplate"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> JOUSTING_LEGGINGS = INSTANCE.addJoustingItem("jousting_leggings", ArmorTypes.JOUSTING, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, properties("jousting_leggings"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> JOUSTING_BOOTS = INSTANCE.addJoustingItem("jousting_boots", ArmorTypes.JOUSTING, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("jousting_boots"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> SALLET = INSTANCE.addMedievalArmorItem("sallet", ArmorTypes.SALLET, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("sallet"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> GOTHIC_CHESTPLATE = INSTANCE.addMedievalArmorItem("gothic_chestplate", ArmorTypes.GOTHIC, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("gothic_chestplate"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> GOTHIC_LEGGINGS = INSTANCE.addMedievalArmorItem("gothic_leggings", ArmorTypes.GOTHIC, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, properties("gothic_leggings"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> GOTHIC_BOOTS = INSTANCE.addMedievalArmorItem("gothic_boots", ArmorTypes.GOTHIC, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("gothic_boots"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> MAXIMILIAN_HELMET = INSTANCE.addMedievalArmorItem("maximilian_helmet", ArmorTypes.MAXIMILIAN_HELMET, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("maximilian_helmet"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> MAXIMILIAN_CHESTPLATE = INSTANCE.addMedievalArmorItem("maximilian_chestplate", ArmorTypes.MAXIMILIAN, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("maximilian_chestplate"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> MAXIMILIAN_LEGGINGS = INSTANCE.addMedievalArmorItem("maximilian_leggings", ArmorTypes.MAXIMILIAN, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, properties("maximilian_leggings"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> MAXIMILIAN_BOOTS = INSTANCE.addMedievalArmorItem("maximilian_boots", ArmorTypes.MAXIMILIAN, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("maximilian_boots"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> CHAINMAIL_HELMET = INSTANCE.addMedievalArmorItem("chainmail_helmet", ArmorTypes.CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("chainmail_helmet"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CHAINMAIL_CHESTPLATE = INSTANCE.addMedievalArmorItem("chainmail_chestplate", ArmorTypes.CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("chainmail_chestplate"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CHAINMAIL_LEGGINGS = INSTANCE.addMedievalArmorItem("chainmail_leggings", ArmorTypes.CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, properties("chainmail_leggings"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CHAINMAIL_BOOTS = INSTANCE.addMedievalArmorItem("chainmail_boots", ArmorTypes.CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("chainmail_boots"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> KETTLEHAT = INSTANCE.addMedievalArmorItem("kettlehat", ArmorTypes.KETTLEHAT, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("kettlehat"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> PLATEMAIL_CHESTPLATE = INSTANCE.addMedievalArmorItem("platemail_chestplate", ArmorTypes.PLATEMAIL, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("platemail_chestplate"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> PLATEMAIL_LEGGINGS = INSTANCE.addMedievalArmorItem("platemail_leggings", ArmorTypes.PLATEMAIL, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, properties("platemail_leggings"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> PLATEMAIL_BOOTS = INSTANCE.addMedievalArmorItem("platemail_boots", ArmorTypes.PLATEMAIL, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("platemail_boots"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> BARBUTE = INSTANCE.addMedievalArmorItem("barbute", ArmorTypes.BARBUTE, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("barbute"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> HALFARMOR_CHESTPLATE = INSTANCE.addMedievalArmorItem("halfarmor_chestplate", ArmorTypes.HALFARMOR, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("halfarmor_chestplate"));

	public static final @Nullable RegistrySupplier<DyeableMedievalArmorItem> GREATHELM = INSTANCE.addDyeableMedievalArmorItem("greathelm", ArmorTypes.GREATHELM, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("greathelm"), 0xd3d3d3);
	public static final @Nullable RegistrySupplier<DyeableMedievalArmorItem> CRUSADER_CHESTPLATE = INSTANCE.addDyeableMedievalArmorItem("crusader_chestplate", ArmorTypes.CRUSADER, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("crusader_chestplate"), 0xffffff);
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CRUSADER_LEGGINGS = INSTANCE.addMedievalArmorItem("crusader_leggings", ArmorTypes.CRUSADER, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, properties("crusader_leggings"));
	public static final @Nullable RegistrySupplier<DyeableMedievalArmorItem> CRUSADER_BOOTS = INSTANCE.addDyeableMedievalArmorItem("crusader_boots", ArmorTypes.CRUSADER, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("crusader_boots"), 0xffffff);

	public static final @Nullable RegistrySupplier<KnightItem> CEREMONIAL_ARMET = INSTANCE.addKnightItem("ceremonialarmet", ArmorTypes.CEREMONIAL_ARMET, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("ceremonialarmet"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CEREMONIAL_CHESTPLATE = INSTANCE.addMedievalArmorItem("ceremonial_chestplate", ArmorTypes.CEREMONIAL, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("ceremonial_chestplate"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CEREMONIAL_BOOTS = INSTANCE.addMedievalArmorItem("ceremonial_boots", ArmorTypes.CEREMONIAL, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("ceremonial_boots"));

	public static final @Nullable RegistrySupplier<DyeableMedievalArmorItem> COIF = INSTANCE.addDyeableMedievalArmorItem("coif", ArmorTypes.GAMBESON, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("coif"), -4280691);
	public static final @Nullable RegistrySupplier<DyeableMedievalArmorItem> GAMBESON = INSTANCE.addDyeableMedievalArmorItem("gambeson_chestplate", ArmorTypes.GAMBESON, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("gambeson_chestplate"), -4280691);
	public static final @Nullable RegistrySupplier<DyeableMedievalArmorItem> PANTYHOSE = INSTANCE.addDyeableMedievalArmorItem("pantyhose", ArmorTypes.GAMBESON, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, properties("pantyhose"), 0x22462C);
	public static final @Nullable RegistrySupplier<DyeableMedievalArmorItem> GAMBESON_BOOTS = INSTANCE.addDyeableMedievalArmorItem("gambeson_boots", ArmorTypes.GAMBESON, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("gambeson_boots"), -4280691);

	public static final @Nullable RegistrySupplier<DyeableMedievalArmorItem> BRIGANDINE = INSTANCE.addDyeableMedievalArmorItem("brigandine_chestplate", ArmorTypes.BRIGANDINE, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("brigandine_chestplate"), 10511680);

	public static final @Nullable RegistrySupplier<DyeableMedievalArmorItem> NORMAN_HELMET = INSTANCE.addDyeableMedievalArmorItem("norman_helmet", ArmorTypes.NORMAN, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("norman_helmet"), 0xF1F1F1);

	public static final @Nullable RegistrySupplier<MedievalArmorItem> SHISHAK = INSTANCE.addMedievalArmorItem("shishak", ArmorTypes.SHISHAK, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("shishak"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_BARBUTE = INSTANCE.addMedievalArmorItem("rustedbarbute", ArmorTypes.RUSTED_BARBUTE, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("rustedbarbute"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_HALFARMOR_CHESTPLATE = INSTANCE.addMedievalArmorItem("rustedhalfarmor_chestplate", ArmorTypes.RUSTED_HALFARMOR, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("rustedhalfarmor_chestplate"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_GREATHELM = INSTANCE.addMedievalArmorItem("rustedgreathelm", ArmorTypes.RUSTED_GREATHELM, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("rustedgreathelm"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_CRUSADER_CHESTPLATE = INSTANCE.addMedievalArmorItem("rustedcrusader_chestplate", ArmorTypes.RUSTED_CRUSADER, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("rustedcrusader_chestplate"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_CRUSADER_BOOTS = INSTANCE.addMedievalArmorItem("rustedcrusader_boots", ArmorTypes.RUSTED_CRUSADER, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("rustedcrusader_boots"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_NORMAN_HELMET = INSTANCE.addMedievalArmorItem("rustednorman_helmet", ArmorTypes.RUSTED_NORMAN, net.minecraft.world.item.equipment.ArmorType.HELMET,properties("rustednorman_helmet"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_HELMET = INSTANCE.addMedievalArmorItem("rustedchainmail_helmet", ArmorTypes.RUSTED_CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("rustedchainmail_helmet"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_CHESTPLATE = INSTANCE.addMedievalArmorItem("rustedchainmail_chestplate", ArmorTypes.RUSTED_CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("rustedchainmail_chestplate"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_LEGGINGS = INSTANCE.addMedievalArmorItem("rustedchainmail_leggings", ArmorTypes.RUSTED_CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, properties("rustedchainmail_leggings"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_BOOTS = INSTANCE.addMedievalArmorItem("rustedchainmail_boots", ArmorTypes.RUSTED_CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("rustedchainmail_boots"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_KETTLEHAT = INSTANCE.addMedievalArmorItem("rustedkettlehat", ArmorTypes.RUSTED_KETTLEHAT, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("rustedkettlehat"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> BASCINET = INSTANCE.addMedievalArmorItem("bascinet", ArmorTypes.BASCINET, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("bascinet"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> XIV_CENTURY_KNIGHT_CHESTPLATE = INSTANCE.addMedievalArmorItem("xivcenturyknight_chestplate", ArmorTypes.XIV_CENTURY_KNIGHT, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("xivcenturyknight_chestplate"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> XIV_CENTURY_KNIGHT_LEGGINGS = INSTANCE.addMedievalArmorItem("xivcenturyknight_leggings", ArmorTypes.XIV_CENTURY_KNIGHT, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, properties("xivcenturyknight_leggings"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> XIV_CENTURY_KNIGHT_BOOTS = INSTANCE.addMedievalArmorItem("xivcenturyknight_boots", ArmorTypes.XIV_CENTURY_KNIGHT, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("xivcenturyknight_boots"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> WINGED_HUSSAR_CHESTPLATE = INSTANCE.addMedievalArmorItem("wingedhussar_chestplate", ArmorTypes.WINGED_HUSSAR_CHESTPLATE, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("wingedhussar_chestplate"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> BURGONET = INSTANCE.addMedievalArmorItem("cuirassier_helmet", ArmorTypes.CUIRASSIER, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("cuirassier_helmet"));
	public static final @Nullable RegistrySupplier<DyeableMedievalArmorItem> CUIRASSIER_CHESTPLATE = INSTANCE.addDyeableMedievalArmorItem("cuirassier_chestplate", ArmorTypes.CUIRASSIER, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("cuirassier_chestplate"), -5465480);
	public static final @Nullable RegistrySupplier<DyeableMedievalArmorItem> CUIRASSIER_LEGGINGS = INSTANCE.addDyeableMedievalArmorItem("cuirassier_leggings", ArmorTypes.CUIRASSIER, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, properties("cuirassier_leggings"), -5465480);
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CUIRASSIER_BOOTS = INSTANCE.addMedievalArmorItem("cuirassier_boots", ArmorTypes.CUIRASSIER, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("cuirassier_boots"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> GRAND_BASCINET = INSTANCE.addMedievalArmorItem("grand_bascinet", ArmorTypes.GRAND_BASCINET, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("grand_bascinet"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> KASTENBRUST_CHESTPLATE = INSTANCE.addMedievalArmorItem("kastenbrust_chestplate", ArmorTypes.KASTENBRUST, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("kastenbrust_chestplate"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> KASTENBRUST_LEGGINGS = INSTANCE.addMedievalArmorItem("kastenbrust_leggings", ArmorTypes.KASTENBRUST, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, properties("kastenbrust_leggings"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> KASTENBRUST_BOOTS = INSTANCE.addMedievalArmorItem("kastenbrust_boots", ArmorTypes.KASTENBRUST, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("kastenbrust_boots"));

	public static final @Nullable RegistrySupplier<MedievalArmorItem> FACE_HELMET = INSTANCE.addMedievalArmorItem("face_helmet", ArmorTypes.LAMELLAR, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("face_helmet"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> LAMELLAR_CHESTPLATE = INSTANCE.addMedievalArmorItem("lamellar_chestplate", ArmorTypes.LAMELLAR, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, properties("lamellar_chestplate"));
	public static final @Nullable RegistrySupplier<MedievalArmorItem> LAMELLAR_BOOTS = INSTANCE.addMedievalArmorItem("lamellar_boots", ArmorTypes.LAMELLAR, net.minecraft.world.item.equipment.ArmorType.BOOTS, properties("lamellar_boots"));

	public static final RegistrySupplier<MedievalHorseArmorItem> BARDING = INSTANCE.items.register("barding", () -> new MedievalHorseArmorItem(ArmorMaterials.DIAMOND, Identifier.fromNamespaceAndPath(EpicKnights.ID, "textures/entity/horse/armor/barding.png"), false, properties("barding").stacksTo(1)));
	public static final RegistrySupplier<MedievalHorseArmorItem> CHAINMAIL_HORSE_ARMOR = INSTANCE.items.register("chainmail_horse_armor", () -> new MedievalHorseArmorItem(ArmorMaterials.IRON, Identifier.fromNamespaceAndPath(EpicKnights.ID, "textures/entity/horse/armor/horse_armor_chainmail.png"), false, properties("chainmail_horse_armor").stacksTo(1)));

	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> HEATER_SHIELD_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_heatershield", "heatershield", prop, material, true, true, SHIELDS_CONFIG.get("heaterShield"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> TARGET_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_target", "target", prop, material, false, true, SHIELDS_CONFIG.get("target"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> BUCKLER_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_buckler", "buckler", prop, material, false, true, SHIELDS_CONFIG.get("buckler"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> RONDACHE_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_rondache", "rondache", prop, material, false, true, SHIELDS_CONFIG.get("rondache"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> TARTSCHE_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_tartsche", "tartsche", prop, material, true, true, SHIELDS_CONFIG.get("tartsche"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> ELLIPTICAL_SHIELD_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_ellipticalshield", "ellipticalshield", prop, material, true, true, SHIELDS_CONFIG.get("ellipticalShield"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> ROUND_SHIELD_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_roundshield", "roundshield", prop, material, true, true, SHIELDS_CONFIG.get("roundShield"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> PAVISE_SUPPLY = (material, prop) -> INSTANCE.addPaviseItem(material.getMaterialName() + "_pavese", "pavese", prop, material, true, true, SHIELDS_CONFIG.get("pavise"), ModBlocks.getPaviseByMaterialName(material));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> KITE_SHIELD_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_kiteshield", "kiteshield", prop, material, true, true, SHIELDS_CONFIG.get("kiteShield"));

	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> STILETTO_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_stylet", prop, material, WeaponTypes.STILETTO);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> SHORT_SWORD_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_shortsword", prop, material, WeaponTypes.SHORT_SWORD);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> KATZBALGER_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_katzbalger", prop, material, WeaponTypes.KATZBALGER);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> PIKE_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_pike", prop, material, WeaponTypes.PIKE);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> RANSEUR_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_ranseur", prop, material, WeaponTypes.RANSEUR);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> AHLSPIESS_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_ahlspiess", prop, material, WeaponTypes.AHLSPIESS);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> GIANT_LANCE_SUPPLY = (material, prop) -> INSTANCE.addLanceItem(material.getMaterialName() + "_chivalrylance", prop, material, WeaponTypes.GIANT_LANCE);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> BASTARD_SWORD_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_bastardsword", prop, material, WeaponTypes.BASTARD_SWORD);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> ESTOC_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_estoc", prop, material, WeaponTypes.ESTOC);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> CLAYMORE_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_claymore", prop, material, WeaponTypes.CLAYMORE);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> ZWEIHANDER_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_zweihander", prop, material, WeaponTypes.ZWEIHANDER);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> FlAME_BLADED_SWORD_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_flamebladedsword", prop, material, WeaponTypes.FLAME_BLADED_SWORD);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> LOCHABER_AXE_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_lochaberaxe", prop, material, WeaponTypes.LOCHABER_AXE);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> CONCAVE_EDGED_HALBERD_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_concavehalberd", prop, material, WeaponTypes.CONCAVE_EDGED_HALBERD);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> HEAVY_MACE_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_heavymace", prop, material, WeaponTypes.HEAVY_MACE);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> HEAVY_WAR_HAMMER_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_heavywarhammer", prop, material, WeaponTypes.HEAVY_WAR_HAMMER);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> LUCERNE_HAMMER_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_lucernhammer", prop, material, WeaponTypes.LUCERNE_HAMMER);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> MORNINGSTAR_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_morgenstern", prop, material, WeaponTypes.MORNINGSTAR);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> FLAIL_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_chainmorgenstern", prop, material, WeaponTypes.FLAIL);
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> GUISARME_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_guisarme", prop, material, WeaponTypes.GUISARME);

	//Weapons
	public static final WeaponsSupply STILETTOS = INSTANCE.addWeaponsSupply(STILETTO_SUPPLY);
	public static final WeaponsSupply SHORT_SWORDS = INSTANCE.addWeaponsSupply(SHORT_SWORD_SUPPLY);
	public static final WeaponsSupply KATZBALGERS = INSTANCE.addWeaponsSupply(KATZBALGER_SUPPLY);
	public static final WeaponsSupply PIKES = INSTANCE.addWeaponsSupply(PIKE_SUPPLY);
	public static final WeaponsSupply RANSEURS = INSTANCE.addWeaponsSupply(RANSEUR_SUPPLY);
	public static final WeaponsSupply AHLSPIESSES = INSTANCE.addWeaponsSupply(AHLSPIESS_SUPPLY);
	public static final WeaponsSupply GIANT_LANCES = INSTANCE.addWeaponsSupply(GIANT_LANCE_SUPPLY);
	public static final WeaponsSupply BASTARD_SWORDS = INSTANCE.addWeaponsSupply(BASTARD_SWORD_SUPPLY);
	public static final WeaponsSupply ESTOCS = INSTANCE.addWeaponsSupply(ESTOC_SUPPLY);
	public static final WeaponsSupply CLAYMORS = INSTANCE.addWeaponsSupply(CLAYMORE_SUPPLY);
	public static final WeaponsSupply ZWEIHANDERS = INSTANCE.addWeaponsSupply(ZWEIHANDER_SUPPLY);
	public static final WeaponsSupply FLAME_BLADED_SWORDS = INSTANCE.addWeaponsSupply(FlAME_BLADED_SWORD_SUPPLY);
	public static final WeaponsSupply LOCHABER_AXES = INSTANCE.addWeaponsSupply(LOCHABER_AXE_SUPPLY);
	public static final WeaponsSupply CONCAVE_EDGED_HALBERDS = INSTANCE.addWeaponsSupply(CONCAVE_EDGED_HALBERD_SUPPLY);
	public static final WeaponsSupply HEAVY_MACES = INSTANCE.addWeaponsSupply(HEAVY_MACE_SUPPLY);
	public static final WeaponsSupply HEAVY_WAR_HAMMERS = INSTANCE.addWeaponsSupply(HEAVY_WAR_HAMMER_SUPPLY);
	public static final WeaponsSupply LUCERNE_HAMMERS = INSTANCE.addWeaponsSupply(LUCERNE_HAMMER_SUPPLY);
	public static final WeaponsSupply MORNINGSTARS = INSTANCE.addWeaponsSupply(MORNINGSTAR_SUPPLY);
	public static final WeaponsSupply FLAILS = INSTANCE.addWeaponsSupply(FLAIL_SUPPLY);
	public static final WeaponsSupply GUISARMES = INSTANCE.addWeaponsSupply(GUISARME_SUPPLY);

	public static final @Nullable RegistrySupplier<MedievalWeaponItem> BLACKSMITH_HAMMER = INSTANCE.addMedievalWeaponItem("blacksmith_hammer", properties("blacksmith_hammer"), ModItemTier.STEEL, WeaponTypes.BLACKSMITH_HAMMER);
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> BARBED_CLUB = INSTANCE.addMedievalWeaponItem("barbedclub", properties("barbedclub"), ModItemTier.IRON, WeaponTypes.BARBED_CLUB);
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> PITCHFORK = INSTANCE.addMedievalWeaponItem("pitchfork", properties("pitchfork"), ModItemTier.IRON, WeaponTypes.PITCHFORK);
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> NOBLE_SWORD = INSTANCE.addMedievalWeaponItem("noble_sword", properties("noble_sword"), ModItemTier.IRON, WeaponTypes.NOBLE_SWORD);
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> RUSTED_BASTARD_SWORD = INSTANCE.addMedievalWeaponItem("rusted_bastardsword", properties("rusted_bastardsword"), ModItemTier.IRON, WeaponTypes.RUSTED_BASTARD_SWORD);
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> RUSTED_HEAVY_MACE = INSTANCE.addMedievalWeaponItem("rusted_heavymace", properties("rusted_heavymace"), ModItemTier.IRON, WeaponTypes.RUSTED_HEAVY_MACE);
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> CLUB = INSTANCE.addMedievalWeaponItem("club", properties("club"), ModItemTier.WOOD, WeaponTypes.CLUB);
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> MESSER_SWORD = INSTANCE.addMedievalWeaponItem("messer_sword", properties("messer_sword"), ModItemTier.IRON, WeaponTypes.MESSER_SWORD);

	public static final @Nullable RegistrySupplier<Item> LONGBOW = INSTANCE.addMedievalBowItem("longbow", WeaponTypes.LONGBOW);
	public static final @Nullable RegistrySupplier<Item> HEAVY_CROSSBOW = INSTANCE.addMedievalCrossbowItem("heavy_crossbow", WeaponTypes.HEAVY_CROSSBOW);

	//Shields
	public static final ShieldsSupply HEATER_SHIELDS = INSTANCE.addShieldsSupply(HEATER_SHIELD_SUPPLY, "heatershield");
	public static final ShieldsSupply TARGETS = INSTANCE.addShieldsSupply(TARGET_SUPPLY, "target");
	public static final ShieldsSupply BUCKLERS = INSTANCE.addShieldsSupply(BUCKLER_SUPPLY, "buckler");
	public static final ShieldsSupply RONDACHES = INSTANCE.addShieldsSupply(RONDACHE_SUPPLY, "rondache");
	public static final ShieldsSupply TARTSCHES = INSTANCE.addShieldsSupply(TARTSCHE_SUPPLY, "tartsche");
	public static final ShieldsSupply ELLIPTICAL_SHIELDS = INSTANCE.addShieldsSupply(ELLIPTICAL_SHIELD_SUPPLY, "ellipticalshield");
	public static final ShieldsSupply ROUND_SHIELDS = INSTANCE.addShieldsSupply(ROUND_SHIELD_SUPPLY, "roundshield");
	public static final ShieldsSupply PAVISES = INSTANCE.addShieldsSupply(PAVISE_SUPPLY, "pavese");
	public static final ShieldsSupply KITE_SHIELDS = INSTANCE.addShieldsSupply(KITE_SHIELD_SUPPLY, "kiteshield");

	public static final RegistrySupplier<MedievalShieldItem> CORRUPTED_ROUND_SHIELD = INSTANCE.addMedievalShieldItem("corruptedroundshield", "corruptedroundshield", properties("corruptedroundshield"), ModItemTier.WOOD, false, true, SHIELDS_CONFIG.get("corruptedRoundShield"));

	//Patterns
	public static final RegistrySupplier<Item> APOSTOLIC_CROSS_PATTERN = INSTANCE.addIngredientItem("apostolic_cross_pattern", () -> new Item(properties("apostolic_cross_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.APOSTOLIC_CROSS_PATTERN))));
	public static final RegistrySupplier<Item> BOWL_PATTERN = INSTANCE.addIngredientItem("bowl_pattern", () -> new Item(properties("bowl_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.BOWL_PATTERN))));
	public static final RegistrySupplier<Item> BULL_PATTERN = INSTANCE.addIngredientItem("bull_pattern", () -> new Item(properties("bull_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.BULL_PATTERN))));
	public static final RegistrySupplier<Item> CHESS_PATTERN = INSTANCE.addIngredientItem("chess_pattern", () -> new Item(properties("chess_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.CHESS_PATTERN))));
	public static final RegistrySupplier<Item> CRUSADER_CROSS_PATTERN = INSTANCE.addIngredientItem("crusader_cross_pattern", () -> new Item(properties("crusader_cross_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.CRUSADER_CROSS_PATTERN))));
	public static final RegistrySupplier<Item> DRAGON_PATTERN = INSTANCE.addIngredientItem("dragon_pattern", () -> new Item(properties("dragon_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.DRAGON_PATTERN))));
	public static final RegistrySupplier<Item> EAGLE_PATTERN = INSTANCE.addIngredientItem("eagle_pattern", () -> new Item(properties("eagle_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.EAGLE_PATTERN))));
	public static final RegistrySupplier<Item> HORSE_PATTERN = INSTANCE.addIngredientItem("horse_pattern", () -> new Item(properties("horse_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.HORSE_PATTERN))));
	public static final RegistrySupplier<Item> LILY_PATTERN = INSTANCE.addIngredientItem("lily_pattern", () -> new Item(properties("lily_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.LILY_PATTERN))));
	public static final RegistrySupplier<Item> LION1_PATTERN = INSTANCE.addIngredientItem("lion1_pattern", () -> new Item(properties("lion1_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.LION1_PATTERN))));
	public static final RegistrySupplier<Item> LION2_PATTERN = INSTANCE.addIngredientItem("lion2_pattern", () -> new Item(properties("lion2_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.LION2_PATTERN))));
	public static final RegistrySupplier<Item> ORTHODOX_CROSS_PATTERN = INSTANCE.addIngredientItem("orthodox_cross_pattern", () -> new Item(properties("orthodox_cross_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.ORTHODOX_CROSS_PATTERN))));
	public static final RegistrySupplier<Item> SNAKE_PATTERN = INSTANCE.addIngredientItem("snake_pattern", () -> new Item(properties("snake_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.SNAKE_PATTERN))));
	public static final RegistrySupplier<Item> SUN_PATTERN = INSTANCE.addIngredientItem("sun_pattern", () -> new Item(properties("sun_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.SUN_PATTERN))));
	public static final RegistrySupplier<Item> SWORDS_PATTERN = INSTANCE.addIngredientItem("swords_pattern", () -> new Item(properties("swords_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.SWORDS_PATTERN))));
	public static final RegistrySupplier<Item> TOWER_PATTERN = INSTANCE.addIngredientItem("tower_pattern", () -> new Item(properties("tower_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.TOWER_PATTERN))));
	public static final RegistrySupplier<Item> TREE_PATTERN = INSTANCE.addIngredientItem("tree_pattern", () -> new Item(properties("tree_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.TREE_PATTERN))));
	public static final RegistrySupplier<Item> TWOHEADED_EAGLE_PATTERN = INSTANCE.addIngredientItem("two_headed_eagle_pattern", () -> new Item(properties("two_headed_eagle_pattern").stacksTo(1).delayedComponent(net.minecraft.core.component.DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(ModBannerPatternTags.TWOHEADED_EAGLE_PATTERN))));

	//Materials
	public static final RegistrySupplier<Item> STEEL_INGOT = INSTANCE.addIngredientItem("steel_ingot", () -> new Item(properties("steel_ingot")));
	public static final RegistrySupplier<Item> STEEL_NUGGET = INSTANCE.addIngredientItem("steel_nugget", () -> new Item(properties("steel_nugget")));
	public static final RegistrySupplier<Item> STEEL_RING = INSTANCE.addIngredientItem("steel_ring", () -> new Item(properties("steel_ring")));
	public static final RegistrySupplier<Item> STEEL_CHAINMAIL = INSTANCE.addIngredientItem("steel_chainmail", () -> new Item(properties("steel_chainmail")));
	public static final RegistrySupplier<Item> STEEL_PLATE = INSTANCE.addIngredientItem("steel_plate", () -> new Item(properties("steel_plate")));
	public static final RegistrySupplier<Item> LEATHER_STRIP = INSTANCE.addIngredientItem("leather_strip", () -> new Item(properties("leather_strip")));
	public static final RegistrySupplier<Item> HILT = INSTANCE.addIngredientItem("hilt", () -> new Item(properties("hilt")));
	public static final RegistrySupplier<Item> POLE = INSTANCE.addIngredientItem("pole", () -> new Item(properties("pole")));
	public static final RegistrySupplier<Item> STEEL_CHAIN = INSTANCE.addIngredientItem("steel_chain", () -> new Item(properties("steel_chain")));
	public static final RegistrySupplier<Item> WOOLEN_FABRIC = INSTANCE.addIngredientItem("woolen_fabric", () -> new Item(properties("woolen_fabric")));
	public static final RegistrySupplier<Item> SMALL_STEEL_PLATE = INSTANCE.addIngredientItem("small_steel_plate", () -> new Item(properties("small_steel_plate")));
	public static final RegistrySupplier<Item> LAMELLAR_ROWS = INSTANCE.addIngredientItem("lamellar_rows", () -> new Item(properties("lamellar_rows")));
	public static final @Nullable RegistrySupplier<Item> DARKENING_TEMPLATE = INSTANCE.addIngredientItem("darkening_template", () -> new SmithingTemplateItem(
			Component.translatable(EpicKnights.ID + ".darkening_template.applies_to"),
			Component.translatable(EpicKnights.ID + ".darkening_template.ingredients"),
			Component.translatable(EpicKnights.ID + ".darkening_template.base_slot_description"),
			Component.translatable(EpicKnights.ID + ".darkening_template.additions_slot_description"),
			List.of(),
			List.of(), properties("darkening_template")));
	public static final @Nullable RegistrySupplier<Item> GILDING_TEMPLATE = INSTANCE.addIngredientItem("gilding_template", () -> new SmithingTemplateItem(
			Component.translatable(EpicKnights.ID + ".gilding_template.applies_to"),
			Component.translatable(EpicKnights.ID + ".gilding_template.ingredients"),
			Component.translatable(EpicKnights.ID + ".gilding_template.base_slot_description"),
			Component.translatable(EpicKnights.ID + ".gilding_template.additions_slot_description"),
			List.of(),
			List.of(), properties("gilding_template")));
	
	//Decorations
	public static final RegistrySupplier<DyeableArmorDecorationItem> TORSE_AND_MANTLE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("torse_and_mantle_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "torse_and_mantle"), properties("torse_and_mantle_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<ArmorDecorationItem> GAZELLE_HORNS_DECORATION = INSTANCE.addArmorDecorationItem("gazelle_horns_decoration", () -> new ArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "gazelle_horns"), properties("gazelle_horns_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<ArmorDecorationItem> DUCK_DECORATION = INSTANCE.addArmorDecorationItem("duck_decoration", () -> new ArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "duck"), properties("duck_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> SPIKE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("spike_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "spike"), properties("spike_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> HORSE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("horse_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "horse"), properties("horse_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET, MapColor.TERRACOTTA_ORANGE.col));
	public static final RegistrySupplier<DyeableWearableArmorDecorationItem> CROWN_DECORATION = INSTANCE.addDyeableWearableArmorDecorationItem("crown_decoration", ArmorTypes.CROWN, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("crown_decoration"), MapColor.COLOR_CYAN.col);
	public static final RegistrySupplier<DyeableWearableArmorDecorationItem> FLOWERCROWN_DECORATION = INSTANCE.addDyeableWearableArmorDecorationItem("flowercrown_decoration", ArmorTypes.FLOWERCROWN, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("flowercrown_decoration"), DyeColor.WHITE.getMapColor().col);
	public static final RegistrySupplier<DyeableArmorDecorationItem> UNICORN_DECORATION = INSTANCE.addDyeableArmorDecorationItem("unicorn_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "unicorn"), properties("unicorn_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<ArmorDecorationItem> BULLHORNS_DECORATION = INSTANCE.addArmorDecorationItem("bullhorns_decoration", () -> new ArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "bullhorns"), properties("bullhorns_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> DRAGON_DECORATION = INSTANCE.addDyeableArmorDecorationItem("dragon_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "dragon"), properties("dragon_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET, MapColor.COLOR_GRAY.col));
	public static final RegistrySupplier<WearableArmorDecorationItem> MINICROWN_DECORATION = INSTANCE.addWearableArmorDecorationItem("minicrown_decoration", ArmorTypes.MINICROWN, net.minecraft.world.item.equipment.ArmorType.HELMET, properties("minicrown_decoration"));
	public static final RegistrySupplier<DyeableArmorDecorationItem> TORSE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("torse_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "torse"), properties("torse_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> TWO_PLUMES_DECORATION = INSTANCE.addDyeableArmorDecorationItem("two_plumes_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "two_plumes"), properties("two_plumes_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<ArmorDecorationItem> ANTLERS_DECORATION = INSTANCE.addArmorDecorationItem("antlers_decoration", () -> new ArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "antlers"), properties("antlers_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> BIG_PLUME_DECORATION = INSTANCE.addDyeableArmorDecorationItem("big_plume_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "big_plume"), properties("big_plume_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET, -10092544));
	public static final RegistrySupplier<DyeableArmorDecorationItem> PLUME_LEFT_DECORATION = INSTANCE.addDyeableArmorDecorationItem("plume_left_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "plume_left"), properties("plume_left_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> PLUME_MIDDLE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("plume_middle_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "plume_middle"), properties("plume_middle_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> PLUME_RIGHT_DECORATION = INSTANCE.addDyeableArmorDecorationItem("plume_right_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "plume_right"), properties("plume_right_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> BEAR_DECORATION = INSTANCE.addDyeableArmorDecorationItem("bear_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "bear"), properties("bear_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET, MapColor.COLOR_BROWN.col));
	public static final RegistrySupplier<DyeableArmorDecorationItem> LILY_DECORATION = INSTANCE.addDyeableArmorDecorationItem("lily_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "lily"), properties("lily_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET, MapColor.GOLD.col));
	public static final RegistrySupplier<DyeableArmorDecorationItem> LION_DECORATION = INSTANCE.addDyeableArmorDecorationItem("lion_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "lion"), properties("lion_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET, 0xFBC237));
	public static final RegistrySupplier<ArmorDecorationItem> DEMON_HORNS_DECORATION = INSTANCE.addArmorDecorationItem("demon_horns_decoration", () -> new ArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "demon_horns"), properties("demon_horns_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> FEATHERS_DECORATION = INSTANCE.addDyeableArmorDecorationItem("feathers_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "feathers"), properties("feathers_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> VIKING_HORNS_DECORATION = INSTANCE.addDyeableArmorDecorationItem("viking_horns_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "viking_horns"), properties("viking_horns_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> GRIFFIN_DECORATION = INSTANCE.addDyeableArmorDecorationItem("griffin_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "griffin"), properties("griffin_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET, 0xFBC237));
	public static final RegistrySupplier<DyeableArmorDecorationItem> HOOD_DECORATION = INSTANCE.addDyeableArmorDecorationItem("hood_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "hood"), properties("hood_decoration"), net.minecraft.world.item.equipment.ArmorType.CHESTPLATE));
	public static final RegistrySupplier<DyeableArmorDecorationItem> ECRANCHE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("ecranche_decoration", () -> new DyeableArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "ecranche"), properties("ecranche_decoration"), net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, 0xDFDFDF));
	public static final RegistrySupplier<ArmorDecorationItem> RONDEL_DECORATION = INSTANCE.addArmorDecorationItem("rondel_decoration", () -> new ArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "rondel"), properties("rondel_decoration"), net.minecraft.world.item.equipment.ArmorType.CHESTPLATE));
	public static final RegistrySupplier<ArmorDecorationItem> CAT_EARS_DECORATION = INSTANCE.addArmorDecorationItem("cat_ears_decoration", () -> new ArmorDecorationItem(Identifier.fromNamespaceAndPath(EpicKnights.ID, "cat_ears"), properties("cat_ears_decoration"), net.minecraft.world.item.equipment.ArmorType.HELMET));

	public static final RegistrySupplier<MedievalBagItem> MEDIEVAL_BAG = INSTANCE.items.register("medieval_bag", () -> new MedievalBagItem(properties("medieval_bag")));
	
	{
		if (Platform.isFabric())
		{
			this.items.register("tin_ingot", () -> new Item(properties("tin_ingot")));
			this.items.register("silver_ingot", () -> new Item(properties("silver_ingot")));
			this.items.register("bronze_ingot", () -> new Item(properties("bronze_ingot")));
		}
	}
	
	public ModItems()
	{
		super(EpicKnights.ID);
	}
}




