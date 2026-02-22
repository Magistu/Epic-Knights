package com.magistuarmory.item;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.api.item.ModItemsProvider;
import com.magistuarmory.config.ArmorConfig;
import com.magistuarmory.config.ShieldsConfig;
import com.magistuarmory.config.WeaponsConfig;
import com.magistuarmory.item.armor.*;
import com.magistuarmory.misc.ModBannerPatternTags;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.RegistrySupplier;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.material.MapColor;

import java.util.List;
import java.util.function.BiFunction;

public class ModItems extends ModItemsProvider
{
	public static final WeaponsConfig WEAPONS_CONFIG = EpicKnights.CONFIG.weapons;
	public static final ShieldsConfig SHIELDS_CONFIG = EpicKnights.CONFIG.shields;

	public static ModItems INSTANCE = new ModItems();

	//Armor
	public static final @Nullable RegistrySupplier<MedievalArmorItem> ARMET = INSTANCE.addKnightItem("armet", ArmorTypes.ARMET, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> KNIGHT_CHESTPLATE = INSTANCE.addMedievalArmorItem("knight_chestplate", ArmorTypes.KNIGHT, ArmorItem.Type.CHESTPLATE, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> KNIGHT_LEGGINGS = INSTANCE.addMedievalArmorItem("knight_leggings", ArmorTypes.KNIGHT, ArmorItem.Type.LEGGINGS, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> KNIGHT_BOOTS = INSTANCE.addMedievalArmorItem("knight_boots", ArmorTypes.KNIGHT, ArmorItem.Type.BOOTS, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> STECHHELM = INSTANCE.addJoustingItem("stechhelm", ArmorTypes.STECHHELM, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> JOUSTING_CHESTPLATE = INSTANCE.addJoustingItem("jousting_chestplate", ArmorTypes.JOUSTING, ArmorItem.Type.CHESTPLATE, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> JOUSTING_LEGGINGS = INSTANCE.addJoustingItem("jousting_leggings", ArmorTypes.JOUSTING, ArmorItem.Type.LEGGINGS, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> JOUSTING_BOOTS = INSTANCE.addJoustingItem("jousting_boots", ArmorTypes.JOUSTING, ArmorItem.Type.BOOTS, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> SALLET = INSTANCE.addMedievalArmorItem("sallet", ArmorTypes.SALLET, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> GOTHIC_CHESTPLATE = INSTANCE.addMedievalArmorItem("gothic_chestplate", ArmorTypes.GOTHIC, ArmorItem.Type.CHESTPLATE, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> GOTHIC_LEGGINGS = INSTANCE.addMedievalArmorItem("gothic_leggings", ArmorTypes.GOTHIC, ArmorItem.Type.LEGGINGS, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> GOTHIC_BOOTS = INSTANCE.addMedievalArmorItem("gothic_boots", ArmorTypes.GOTHIC, ArmorItem.Type.BOOTS, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> MAXIMILIAN_HELMET = INSTANCE.addMedievalArmorItem("maximilian_helmet", ArmorTypes.MAXIMILIAN_HELMET, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> MAXIMILIAN_CHESTPLATE = INSTANCE.addMedievalArmorItem("maximilian_chestplate", ArmorTypes.MAXIMILIAN, ArmorItem.Type.CHESTPLATE, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> MAXIMILIAN_LEGGINGS = INSTANCE.addMedievalArmorItem("maximilian_leggings", ArmorTypes.MAXIMILIAN, ArmorItem.Type.LEGGINGS, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> MAXIMILIAN_BOOTS = INSTANCE.addMedievalArmorItem("maximilian_boots", ArmorTypes.MAXIMILIAN, ArmorItem.Type.BOOTS, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> CHAINMAIL_HELMET = INSTANCE.addMedievalArmorItem("chainmail_helmet", ArmorTypes.CHAINMAIL, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CHAINMAIL_CHESTPLATE = INSTANCE.addMedievalArmorItem("chainmail_chestplate", ArmorTypes.CHAINMAIL, ArmorItem.Type.CHESTPLATE, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CHAINMAIL_LEGGINGS = INSTANCE.addMedievalArmorItem("chainmail_leggings", ArmorTypes.CHAINMAIL, ArmorItem.Type.LEGGINGS, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CHAINMAIL_BOOTS = INSTANCE.addMedievalArmorItem("chainmail_boots", ArmorTypes.CHAINMAIL, ArmorItem.Type.BOOTS, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> KETTLEHAT = INSTANCE.addMedievalArmorItem("kettlehat", ArmorTypes.KETTLEHAT, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> PLATEMAIL_CHESTPLATE = INSTANCE.addMedievalArmorItem("platemail_chestplate", ArmorTypes.PLATEMAIL, ArmorItem.Type.CHESTPLATE, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> PLATEMAIL_LEGGINGS = INSTANCE.addMedievalArmorItem("platemail_leggings", ArmorTypes.PLATEMAIL, ArmorItem.Type.LEGGINGS, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> PLATEMAIL_BOOTS = INSTANCE.addMedievalArmorItem("platemail_boots", ArmorTypes.PLATEMAIL, ArmorItem.Type.BOOTS, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> BARBUTE = INSTANCE.addMedievalArmorItem("barbute", ArmorTypes.BARBUTE, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> HALFARMOR_CHESTPLATE = INSTANCE.addMedievalArmorItem("halfarmor_chestplate", ArmorTypes.HALFARMOR, ArmorItem.Type.CHESTPLATE, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> GREATHELM = INSTANCE.addDyeableMedievalArmorItem("greathelm", ArmorTypes.GREATHELM, ArmorItem.Type.HELMET, new Properties(), 0xd3d3d3);
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CRUSADER_CHESTPLATE = INSTANCE.addDyeableMedievalArmorItem("crusader_chestplate", ArmorTypes.CRUSADER, ArmorItem.Type.CHESTPLATE, new Properties(), -3227226);
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CRUSADER_LEGGINGS = INSTANCE.addMedievalArmorItem("crusader_leggings", ArmorTypes.CRUSADER, ArmorItem.Type.LEGGINGS, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CRUSADER_BOOTS = INSTANCE.addDyeableMedievalArmorItem("crusader_boots", ArmorTypes.CRUSADER, ArmorItem.Type.BOOTS, new Properties(), -3227226);

	public static final @Nullable RegistrySupplier<MedievalArmorItem> CEREMONIAL_ARMET = INSTANCE.addKnightItem("ceremonialarmet", ArmorTypes.CEREMONIAL_ARMET, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CEREMONIAL_CHESTPLATE = INSTANCE.addMedievalArmorItem("ceremonial_chestplate", ArmorTypes.CEREMONIAL, ArmorItem.Type.CHESTPLATE, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CEREMONIAL_BOOTS = INSTANCE.addMedievalArmorItem("ceremonial_boots", ArmorTypes.CEREMONIAL, ArmorItem.Type.BOOTS, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> COIF = INSTANCE.addDyeableMedievalArmorItem("coif", ArmorTypes.GAMBESON, ArmorItem.Type.HELMET, new Properties(), -4280691);
	public static final @Nullable RegistrySupplier<MedievalArmorItem> GAMBESON = INSTANCE.addDyeableMedievalArmorItem("gambeson_chestplate", ArmorTypes.GAMBESON, ArmorItem.Type.CHESTPLATE, new Properties(), -4280691);
	public static final @Nullable RegistrySupplier<MedievalArmorItem> PANTYHOSE = INSTANCE.addDyeableMedievalArmorItem("pantyhose", ArmorTypes.GAMBESON, ArmorItem.Type.LEGGINGS, new Properties(), -14531028);
	public static final @Nullable RegistrySupplier<MedievalArmorItem> GAMBESON_BOOTS = INSTANCE.addDyeableMedievalArmorItem("gambeson_boots", ArmorTypes.GAMBESON, ArmorItem.Type.BOOTS, new Properties(), -4280691);

	public static final @Nullable RegistrySupplier<MedievalArmorItem> BRIGANDINE = INSTANCE.addDyeableMedievalArmorItem("brigandine_chestplate", ArmorTypes.BRIGANDINE, ArmorItem.Type.CHESTPLATE, new Properties(), 10511680);

	public static final @Nullable RegistrySupplier<MedievalArmorItem> NORMAN_HELMET = INSTANCE.addDyeableMedievalArmorItem("norman_helmet", ArmorTypes.NORMAN, ArmorItem.Type.HELMET, new Properties(), 0xF1F1F1);

	public static final @Nullable RegistrySupplier<MedievalArmorItem> SHISHAK = INSTANCE.addMedievalArmorItem("shishak", ArmorTypes.SHISHAK, ArmorItem.Type.HELMET, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_BARBUTE = INSTANCE.addMedievalArmorItem("rustedbarbute", ArmorTypes.RUSTED_BARBUTE, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_HALFARMOR_CHESTPLATE = INSTANCE.addMedievalArmorItem("rustedhalfarmor_chestplate", ArmorTypes.RUSTED_HALFARMOR, ArmorItem.Type.CHESTPLATE, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_GREATHELM = INSTANCE.addMedievalArmorItem("rustedgreathelm", ArmorTypes.RUSTED_GREATHELM, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_CRUSADER_CHESTPLATE = INSTANCE.addMedievalArmorItem("rustedcrusader_chestplate", ArmorTypes.RUSTED_CRUSADER, ArmorItem.Type.CHESTPLATE, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_CRUSADER_BOOTS = INSTANCE.addMedievalArmorItem("rustedcrusader_boots", ArmorTypes.RUSTED_CRUSADER, ArmorItem.Type.BOOTS, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_NORMAN_HELMET = INSTANCE.addMedievalArmorItem("rustednorman_helmet", ArmorTypes.RUSTED_NORMAN, ArmorItem.Type.HELMET,new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_HELMET = INSTANCE.addMedievalArmorItem("rustedchainmail_helmet", ArmorTypes.RUSTED_CHAINMAIL, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_CHESTPLATE = INSTANCE.addMedievalArmorItem("rustedchainmail_chestplate", ArmorTypes.RUSTED_CHAINMAIL, ArmorItem.Type.CHESTPLATE, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_LEGGINGS = INSTANCE.addMedievalArmorItem("rustedchainmail_leggings", ArmorTypes.RUSTED_CHAINMAIL, ArmorItem.Type.LEGGINGS, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_BOOTS = INSTANCE.addMedievalArmorItem("rustedchainmail_boots", ArmorTypes.RUSTED_CHAINMAIL, ArmorItem.Type.BOOTS, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> RUSTED_KETTLEHAT = INSTANCE.addMedievalArmorItem("rustedkettlehat", ArmorTypes.RUSTED_KETTLEHAT, ArmorItem.Type.HELMET, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> BASCINET = INSTANCE.addMedievalArmorItem("bascinet", ArmorTypes.BASCINET, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> XIV_CENTURY_KNIGHT_CHESTPLATE = INSTANCE.addMedievalArmorItem("xivcenturyknight_chestplate", ArmorTypes.XIV_CENTURY_KNIGHT, ArmorItem.Type.CHESTPLATE, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> XIV_CENTURY_KNIGHT_LEGGINGS = INSTANCE.addMedievalArmorItem("xivcenturyknight_leggings", ArmorTypes.XIV_CENTURY_KNIGHT, ArmorItem.Type.LEGGINGS, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> XIV_CENTURY_KNIGHT_BOOTS = INSTANCE.addMedievalArmorItem("xivcenturyknight_boots", ArmorTypes.XIV_CENTURY_KNIGHT, ArmorItem.Type.BOOTS, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> WINGED_HUSSAR_CHESTPLATE = INSTANCE.addMedievalArmorItem("wingedhussar_chestplate", ArmorTypes.WINGED_HUSSAR_CHESTPLATE, ArmorItem.Type.CHESTPLATE, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> BURGONET = INSTANCE.addMedievalArmorItem("cuirassier_helmet", ArmorTypes.CUIRASSIER, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CUIRASSIER_CHESTPLATE = INSTANCE.addDyeableMedievalArmorItem("cuirassier_chestplate", ArmorTypes.CUIRASSIER, ArmorItem.Type.CHESTPLATE, new Properties(), -5465480);
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CUIRASSIER_LEGGINGS = INSTANCE.addDyeableMedievalArmorItem("cuirassier_leggings", ArmorTypes.CUIRASSIER, ArmorItem.Type.LEGGINGS, new Properties(), -5465480);
	public static final @Nullable RegistrySupplier<MedievalArmorItem> CUIRASSIER_BOOTS = INSTANCE.addMedievalArmorItem("cuirassier_boots", ArmorTypes.CUIRASSIER, ArmorItem.Type.BOOTS, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> GRAND_BASCINET = INSTANCE.addMedievalArmorItem("grand_bascinet", ArmorTypes.GRAND_BASCINET, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> KASTENBRUST_CHESTPLATE = INSTANCE.addMedievalArmorItem("kastenbrust_chestplate", ArmorTypes.KASTENBRUST, ArmorItem.Type.CHESTPLATE, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> KASTENBRUST_LEGGINGS = INSTANCE.addMedievalArmorItem("kastenbrust_leggings", ArmorTypes.KASTENBRUST, ArmorItem.Type.LEGGINGS, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> KASTENBRUST_BOOTS = INSTANCE.addMedievalArmorItem("kastenbrust_boots", ArmorTypes.KASTENBRUST, ArmorItem.Type.BOOTS, new Properties());

	public static final @Nullable RegistrySupplier<MedievalArmorItem> FACE_HELMET = INSTANCE.addMedievalArmorItem("face_helmet", ArmorTypes.LAMELLAR, ArmorItem.Type.HELMET, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> LAMELLAR_CHESTPLATE = INSTANCE.addMedievalArmorItem("lamellar_chestplate", ArmorTypes.LAMELLAR, ArmorItem.Type.CHESTPLATE, new Properties());
	public static final @Nullable RegistrySupplier<MedievalArmorItem> LAMELLAR_BOOTS = INSTANCE.addMedievalArmorItem("lamellar_boots", ArmorTypes.LAMELLAR, ArmorItem.Type.BOOTS, new Properties());

	public static final RegistrySupplier<MedievalHorseArmorItem> BARDING = INSTANCE.items.register("barding", () -> new MedievalHorseArmorItem(12, new ResourceLocation(EpicKnights.ID, "textures/entity/horse/armor/barding.png"), new Properties().stacksTo(1)));
	public static final RegistrySupplier<MedievalHorseArmorItem> CHAINMAIL_HORSE_ARMOR = INSTANCE.items.register("chainmail_horse_armor", () -> new MedievalHorseArmorItem(6, new ResourceLocation(EpicKnights.ID, "textures/entity/horse/armor/horse_armor_chainmail.png"), new Properties().stacksTo(1)));

	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> HEATER_SHIELD_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_heatershield", "heatershield", prop, material, true, true, SHIELDS_CONFIG.get("heaterShield"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> TARGET_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_target", "target", prop, material, false, true, SHIELDS_CONFIG.get("target"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> BUCKLER_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_buckler", "buckler", prop, material, false, true, SHIELDS_CONFIG.get("buckler"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> RONDACHE_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_rondache", "rondache", prop, material, false, true, SHIELDS_CONFIG.get("rondache"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> TARTSCHE_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_tartsche", "tartsche", prop, material, true, true, SHIELDS_CONFIG.get("tartsche"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> ELLIPTICAL_SHIELD_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_ellipticalshield", "ellipticalshield", prop, material, true, true, SHIELDS_CONFIG.get("ellipticalShield"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> ROUND_SHIELD_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_roundshield", "roundshield", prop, material, true, true, SHIELDS_CONFIG.get("roundShield"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> PAVISE_SUPPLY = (material, prop) -> INSTANCE.addPaviseItem(material.getMaterialName() + "_pavese", "pavese", prop, material, true, true, SHIELDS_CONFIG.get("pavise"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> KITE_SHIELD_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_kiteshield", "kiteshield", prop, material, true, true, SHIELDS_CONFIG.get("kiteShield"));

	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> STILETTO_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_stylet", prop, material, WEAPONS_CONFIG.getMelee("stiletto"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> SHORT_SWORD_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_shortsword", prop, material, WEAPONS_CONFIG.getMelee("shortSword"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> KATZBALGER_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_katzbalger", prop, material, WEAPONS_CONFIG.getMelee("katzbalger"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> PIKE_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_pike", prop, material, WEAPONS_CONFIG.getMelee("pike"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> RANSEUR_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_ranseur", prop, material, WEAPONS_CONFIG.getMelee("ranseur"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> AHLSPIESS_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_ahlspiess", prop, material, WEAPONS_CONFIG.getMelee("ahlspiess"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> GIANT_LANCE_SUPPLY = (material, prop) -> INSTANCE.addLanceItem(material.getMaterialName() + "_chivalrylance", prop, material, WEAPONS_CONFIG.getMelee("giantLance"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> BASTARD_SWORD_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_bastardsword", prop, material, WEAPONS_CONFIG.getMelee("bastardSword"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> ESTOC_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_estoc", prop, material, WEAPONS_CONFIG.getMelee("estoc"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> CLAYMORE_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_claymore", prop, material, WEAPONS_CONFIG.getMelee("claymore"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> ZWEIHANDER_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_zweihander", prop, material, WEAPONS_CONFIG.getMelee("zweihander"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> FlAME_BLADED_SWORD_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_flamebladedsword", prop, material, WEAPONS_CONFIG.getMelee("flameBladedSword"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> LOCHABER_AXE_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_lochaberaxe", prop, material, WEAPONS_CONFIG.getMelee("lochaberAxe"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> CONCAVE_EDGED_HALBERD_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_concavehalberd", prop, material, WEAPONS_CONFIG.getMelee("concaveEdgedHalberd"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> HEAVY_MACE_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_heavymace", prop, material, WEAPONS_CONFIG.getMelee("heavyMace"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> HEAVY_WAR_HAMMER_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_heavywarhammer", prop, material, WEAPONS_CONFIG.getMelee("heavyWarHammer"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> LUCERNE_HAMMER_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_lucernhammer", prop, material, WEAPONS_CONFIG.getMelee("lucerneHammer"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> MORNINGSTAR_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_morgenstern", prop, material, WEAPONS_CONFIG.getMelee("morningstar"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> FLAIL_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_chainmorgenstern", prop, material, WEAPONS_CONFIG.getMelee("flail"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> GUISARME_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_guisarme", prop, material, WEAPONS_CONFIG.getMelee("guisarme"));

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

	public static final @Nullable RegistrySupplier<MedievalWeaponItem> BLACKSMITH_HAMMER = INSTANCE.addMedievalWeaponItem("blacksmith_hammer", new Properties(), ModItemTier.STEEL, WEAPONS_CONFIG.getMelee("blacksmithHammer"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> BARBED_CLUB = INSTANCE.addMedievalWeaponItem("barbedclub", new Properties(), ModItemTier.IRON, WEAPONS_CONFIG.getMelee("barbedClub"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> PITCHFORK = INSTANCE.addMedievalWeaponItem("pitchfork", new Properties(), ModItemTier.IRON, WEAPONS_CONFIG.getMelee("pitchfork"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> NOBLE_SWORD = INSTANCE.addMedievalWeaponItem("noble_sword", new Properties(), ModItemTier.IRON, WEAPONS_CONFIG.getMelee("nobleSword"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> RUSTED_BASTARD_SWORD = INSTANCE.addMedievalWeaponItem("rusted_bastardsword", new Properties(), ModItemTier.IRON, WEAPONS_CONFIG.getMelee("rustedBastardSword"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> RUSTED_HEAVY_MACE = INSTANCE.addMedievalWeaponItem("rusted_heavymace", new Properties(), ModItemTier.IRON, WEAPONS_CONFIG.getMelee("rustedHeavyMace"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> CLUB = INSTANCE.addMedievalWeaponItem("club", new Properties(), ModItemTier.WOOD, WEAPONS_CONFIG.getMelee("club"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> MESSER_SWORD = INSTANCE.addMedievalWeaponItem("messer_sword", new Properties(), ModItemTier.IRON, WEAPONS_CONFIG.getMelee("messerSword"));

	public static final @Nullable RegistrySupplier<Item> LONGBOW = INSTANCE.addMedievalBowItem("longbow", WEAPONS_CONFIG.getRanged("longbow"));
	public static final @Nullable RegistrySupplier<Item> HEAVY_CROSSBOW = INSTANCE.addMedievalCrossbowItem("heavy_crossbow", WEAPONS_CONFIG.getRanged("heavyCrossbow"));

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

	public static final RegistrySupplier<MedievalShieldItem> CORRUPTED_ROUND_SHIELD = INSTANCE.addMedievalShieldItem("corruptedroundshield", "corruptedroundshield", new Properties(), ModItemTier.WOOD, false, true, SHIELDS_CONFIG.get("corruptedRoundShield"));

	//Patterns
	public static final RegistrySupplier<Item> APOSTOLIC_CROSS_PATTERN = INSTANCE.addIngredientItem("apostolic_cross_pattern", () -> new BannerPatternItem(ModBannerPatternTags.APOSTOLIC_CROSS_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> BOWL_PATTERN = INSTANCE.addIngredientItem("bowl_pattern", () -> new BannerPatternItem(ModBannerPatternTags.BOWL_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> BULL_PATTERN = INSTANCE.addIngredientItem("bull_pattern", () -> new BannerPatternItem(ModBannerPatternTags.BULL_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> CHESS_PATTERN = INSTANCE.addIngredientItem("chess_pattern", () -> new BannerPatternItem(ModBannerPatternTags.CHESS_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> CRUSADER_CROSS_PATTERN = INSTANCE.addIngredientItem("crusader_cross_pattern", () -> new BannerPatternItem(ModBannerPatternTags.CRUSADER_CROSS_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> DRAGON_PATTERN = INSTANCE.addIngredientItem("dragon_pattern", () -> new BannerPatternItem(ModBannerPatternTags.DRAGON_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> EAGLE_PATTERN = INSTANCE.addIngredientItem("eagle_pattern", () -> new BannerPatternItem(ModBannerPatternTags.EAGLE_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> HORSE_PATTERN = INSTANCE.addIngredientItem("horse_pattern", () -> new BannerPatternItem(ModBannerPatternTags.HORSE_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> LILY_PATTERN = INSTANCE.addIngredientItem("lily_pattern", () -> new BannerPatternItem(ModBannerPatternTags.LILY_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> LION1_PATTERN = INSTANCE.addIngredientItem("lion1_pattern", () -> new BannerPatternItem(ModBannerPatternTags.LION1_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> LION2_PATTERN = INSTANCE.addIngredientItem("lion2_pattern", () -> new BannerPatternItem(ModBannerPatternTags.LION2_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> ORTHODOX_CROSS_PATTERN = INSTANCE.addIngredientItem("orthodox_cross_pattern", () -> new BannerPatternItem(ModBannerPatternTags.ORTHODOX_CROSS_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> SNAKE_PATTERN = INSTANCE.addIngredientItem("snake_pattern", () -> new BannerPatternItem(ModBannerPatternTags.SNAKE_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> SUN_PATTERN = INSTANCE.addIngredientItem("sun_pattern", () -> new BannerPatternItem(ModBannerPatternTags.SUN_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> SWORDS_PATTERN = INSTANCE.addIngredientItem("swords_pattern", () -> new BannerPatternItem(ModBannerPatternTags.SWORDS_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> TOWER_PATTERN = INSTANCE.addIngredientItem("tower_pattern", () -> new BannerPatternItem(ModBannerPatternTags.TOWER_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> TREE_PATTERN = INSTANCE.addIngredientItem("tree_pattern", () -> new BannerPatternItem(ModBannerPatternTags.TREE_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> TWOHEADED_EAGLE_PATTERN = INSTANCE.addIngredientItem("two-headed_eagle_pattern", () -> new BannerPatternItem(ModBannerPatternTags.TWOHEADED_EAGLE_PATTERN, new Properties().stacksTo(1)));

	//Materials
	public static final RegistrySupplier<Item> STEEL_INGOT = INSTANCE.addIngredientItem("steel_ingot", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> STEEL_NUGGET = INSTANCE.addIngredientItem("steel_nugget", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> STEEL_RING = INSTANCE.addIngredientItem("steel_ring", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> STEEL_CHAINMAIL = INSTANCE.addIngredientItem("steel_chainmail", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> STEEL_PLATE = INSTANCE.addIngredientItem("steel_plate", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> LEATHER_STRIP = INSTANCE.addIngredientItem("leather_strip", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> HILT = INSTANCE.addIngredientItem("hilt", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> POLE = INSTANCE.addIngredientItem("pole", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> STEEL_CHAIN = INSTANCE.addIngredientItem("steel_chain", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> WOOLEN_FABRIC = INSTANCE.addIngredientItem("woolen_fabric", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> SMALL_STEEL_PLATE = INSTANCE.addIngredientItem("small_steel_plate", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> LAMELLAR_ROWS = INSTANCE.addIngredientItem("lamellar_rows", () -> new Item(new Properties()));
	public static final @Nullable RegistrySupplier<Item> DARKENING_TEMPLATE = INSTANCE.addIngredientItem("darkening_template", () -> new SmithingTemplateItem(
			Component.translatable(EpicKnights.ID + ".darkening_template.applies_to"),
			Component.translatable(EpicKnights.ID + ".darkening_template.ingredients"),
			Component.translatable(EpicKnights.ID + ".darkening_template.upgrade_description"),
			Component.translatable(EpicKnights.ID + ".darkening_template.base_slot_description"),
			Component.translatable(EpicKnights.ID + ".darkening_template.additions_slot_description"),
			List.of(),
			List.of()));
	public static final @Nullable RegistrySupplier<Item> GILDING_TEMPLATE = INSTANCE.addIngredientItem("gilding_template", () -> new SmithingTemplateItem(
			Component.translatable(EpicKnights.ID + ".gilding_template.applies_to"),
			Component.translatable(EpicKnights.ID + ".gilding_template.ingredients"),
			Component.translatable(EpicKnights.ID + ".gilding_template.upgrade_description"),
			Component.translatable(EpicKnights.ID + ".gilding_template.base_slot_description"),
			Component.translatable(EpicKnights.ID + ".gilding_template.additions_slot_description"),
			List.of(),
			List.of()));
	
	//Decorations
	public static final RegistrySupplier<DyeableArmorDecorationItem> TORSE_AND_MANTLE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("torse_and_mantle_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "torse_and_mantle"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<ArmorDecorationItem> GAZELLE_HORNS_DECORATION = INSTANCE.addArmorDecorationItem("gazelle_horns_decoration", () -> new ArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "gazelle_horns"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<ArmorDecorationItem> DUCK_DECORATION = INSTANCE.addArmorDecorationItem("duck_decoration", () -> new ArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "duck"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> SPIKE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("spike_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "spike"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> HORSE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("horse_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "horse"), new Properties(), ArmorItem.Type.HELMET, MapColor.TERRACOTTA_ORANGE.col));
	public static final RegistrySupplier<DyeableWearableArmorDecorationItem> CROWN_DECORATION = INSTANCE.addDyeableWearableArmorDecorationItem("crown_decoration", ArmorTypes.CROWN, ArmorItem.Type.HELMET, new Properties(), MapColor.COLOR_CYAN.col);
	public static final RegistrySupplier<DyeableWearableArmorDecorationItem> FLOWERCROWN_DECORATION = INSTANCE.addDyeableWearableArmorDecorationItem("flowercrown_decoration", ArmorTypes.FLOWERCROWN, ArmorItem.Type.HELMET, new Properties(), DyeColor.WHITE.getMapColor().col);
	public static final RegistrySupplier<DyeableArmorDecorationItem> UNICORN_DECORATION = INSTANCE.addDyeableArmorDecorationItem("unicorn_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "unicorn"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<ArmorDecorationItem> BULLHORNS_DECORATION = INSTANCE.addArmorDecorationItem("bullhorns_decoration", () -> new ArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "bullhorns"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> DRAGON_DECORATION = INSTANCE.addDyeableArmorDecorationItem("dragon_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "dragon"), new Properties(), ArmorItem.Type.HELMET, MapColor.COLOR_GRAY.col));
	public static final RegistrySupplier<WearableArmorDecorationItem> MINICROWN_DECORATION = INSTANCE.addWearableArmorDecorationItem("minicrown_decoration", ArmorTypes.MINICROWN, ArmorItem.Type.HELMET, new Properties());
	public static final RegistrySupplier<DyeableArmorDecorationItem> TORSE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("torse_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "torse"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> TWO_PLUMES_DECORATION = INSTANCE.addDyeableArmorDecorationItem("two_plumes_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "two_plumes"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<ArmorDecorationItem> ANTLERS_DECORATION = INSTANCE.addArmorDecorationItem("antlers_decoration", () -> new ArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "antlers"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> BIG_PLUME_DECORATION = INSTANCE.addDyeableArmorDecorationItem("big_plume_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "big_plume"), new Properties(), ArmorItem.Type.HELMET, -10092544));
	public static final RegistrySupplier<DyeableArmorDecorationItem> PLUME_LEFT_DECORATION = INSTANCE.addDyeableArmorDecorationItem("plume_left_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "plume_left"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> PLUME_MIDDLE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("plume_middle_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "plume_middle"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> PLUME_RIGHT_DECORATION = INSTANCE.addDyeableArmorDecorationItem("plume_right_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "plume_right"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> BEAR_DECORATION = INSTANCE.addDyeableArmorDecorationItem("bear_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "bear"), new Properties(), ArmorItem.Type.HELMET, MapColor.COLOR_BROWN.col));
	public static final RegistrySupplier<DyeableArmorDecorationItem> LILY_DECORATION = INSTANCE.addDyeableArmorDecorationItem("lily_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "lily"), new Properties(), ArmorItem.Type.HELMET, MapColor.GOLD.col));
	public static final RegistrySupplier<DyeableArmorDecorationItem> LION_DECORATION = INSTANCE.addDyeableArmorDecorationItem("lion_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "lion"), new Properties(), ArmorItem.Type.HELMET, 0xFBC237));
	public static final RegistrySupplier<ArmorDecorationItem> DEMON_HORNS_DECORATION = INSTANCE.addArmorDecorationItem("demon_horns_decoration", () -> new ArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "demon_horns"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> FEATHERS_DECORATION = INSTANCE.addDyeableArmorDecorationItem("feathers_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "feathers"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> VIKING_HORNS_DECORATION = INSTANCE.addDyeableArmorDecorationItem("viking_horns_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "viking_horns"), new Properties(), ArmorItem.Type.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> GRIFFIN_DECORATION = INSTANCE.addDyeableArmorDecorationItem("griffin_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "griffin"), new Properties(), ArmorItem.Type.HELMET, 0xFBC237));
	public static final RegistrySupplier<DyeableArmorDecorationItem> HOOD_DECORATION = INSTANCE.addDyeableArmorDecorationItem("hood_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "hood"), new Properties(), ArmorItem.Type.CHESTPLATE));
	public static final RegistrySupplier<DyeableArmorDecorationItem> ECRANCHE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("ecranche_decoration", () -> new DyeableArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "ecranche"), new Properties(), ArmorItem.Type.CHESTPLATE, 0xDFDFDF));
	public static final RegistrySupplier<ArmorDecorationItem> RONDEL_DECORATION = INSTANCE.addArmorDecorationItem("rondel_decoration", () -> new ArmorDecorationItem(new ResourceLocation(EpicKnights.ID, "rondel"), new Properties(), ArmorItem.Type.CHESTPLATE));

	public static final RegistrySupplier<MedievalBagItem> MEDIEVAL_BAG = INSTANCE.items.register("medieval_bag", MedievalBagItem::new);
	
	{
		if (Platform.isFabric())
		{
			this.items.register("tin_ingot", () -> new Item(new Properties()));
			this.items.register("silver_ingot", () -> new Item(new Properties()));
			this.items.register("bronze_ingot", () -> new Item(new Properties()));
		}
	}
	
	public ModItems()
	{
		super(EpicKnights.ID);
	}
}




