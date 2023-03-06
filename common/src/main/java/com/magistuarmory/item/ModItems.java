package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.init.HeraldryPattern;
import com.magistuarmory.init.ModCreativeTabs;
import com.magistuarmory.item.armor.ArmorTypes;
import com.magistuarmory.item.armor.*;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(KnightlyArmory.ID, Registry.ITEM_REGISTRY);

	public static final List<RegistrySupplier<MedievalShieldItem>> SHIELD_ITEMS = new ArrayList<>();
	public static final List<RegistrySupplier<MedievalWeaponItem>> WEAPON_ITEMS = new ArrayList<>();
	public static final List<RegistrySupplier<? extends Item>> DYEABLE_ITEMS = new ArrayList<>();
	public static final List<RegistrySupplier<MedievalArmorItem>> ARMOR_ITEMS = new ArrayList<>();
	public static final List<RegistrySupplier<Item>> INGREDIENT_ITEMS = new ArrayList<>();
	
	//Armor
	public static final RegistrySupplier<MedievalArmorItem> ARMET = addKnightItem("armet", ArmorTypes.ARMET, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> KNIGHT_CHESTPLATE = addMedievalArmorItem("knight_chestplate", ArmorTypes.KNIGHT, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> KNIGHT_LEGGINGS = addMedievalArmorItem("knight_leggings", ArmorTypes.KNIGHT, EquipmentSlot.LEGS, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> KNIGHT_BOOTS = addMedievalArmorItem("knight_boots", ArmorTypes.KNIGHT, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> STECHHELM = addJoustingItem("stechhelm", ArmorTypes.STECHHELM, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> JOUSTING_CHESTPLATE = addJoustingItem("jousting_chestplate", ArmorTypes.JOUSTING, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> JOUSTING_LEGGINGS = addJoustingItem("jousting_leggings", ArmorTypes.JOUSTING, EquipmentSlot.LEGS, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> JOUSTING_BOOTS = addJoustingItem("jousting_boots", ArmorTypes.JOUSTING, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> SALLET = addMedievalArmorItem("sallet", ArmorTypes.SALLET, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.SALLET);
	public static final RegistrySupplier<MedievalArmorItem> GOTHIC_CHESTPLATE = addMedievalArmorItem("gothic_chestplate", ArmorTypes.GOTHIC, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> GOTHIC_LEGGINGS = addMedievalArmorItem("gothic_leggings", ArmorTypes.GOTHIC, EquipmentSlot.LEGS, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> GOTHIC_BOOTS = addMedievalArmorItem("gothic_boots", ArmorTypes.GOTHIC, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> MAXIMILIAN_HELMET = addMedievalArmorItem("maximilian_helmet", ArmorTypes.MAXIMILIAN_HELMET, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.MAXIMILIAN_HELMET);
	public static final RegistrySupplier<MedievalArmorItem> MAXIMILIAN_CHESTPLATE = addMedievalArmorItem("maximilian_chestplate", ArmorTypes.MAXIMILIAN, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> MAXIMILIAN_LEGGINGS = addMedievalArmorItem("maximilian_leggings", ArmorTypes.MAXIMILIAN, EquipmentSlot.LEGS, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> MAXIMILIAN_BOOTS = addMedievalArmorItem("maximilian_boots", ArmorTypes.MAXIMILIAN, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> CHAINMAIL_HELMET = addMedievalArmorItem("chainmail_helmet", ArmorTypes.CHAINMAIL, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CHAINMAIL_CHESTPLATE = addMedievalArmorItem("chainmail_chestplate", ArmorTypes.CHAINMAIL, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CHAINMAIL_LEGGINGS = addMedievalArmorItem("chainmail_leggings", ArmorTypes.CHAINMAIL, EquipmentSlot.LEGS, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CHAINMAIL_BOOTS = addMedievalArmorItem("chainmail_boots", ArmorTypes.CHAINMAIL, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> KETTLEHAT = addMedievalArmorItem("kettlehat", ArmorTypes.KETTLEHAT, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.KETTLEHAT);
	public static final RegistrySupplier<MedievalArmorItem> PLATEMAIL_CHESTPLATE = addMedievalArmorItem("platemail_chestplate", ArmorTypes.PLATEMAIL, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> PLATEMAIL_LEGGINGS = addMedievalArmorItem("platemail_leggings", ArmorTypes.PLATEMAIL, EquipmentSlot.LEGS, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> PLATEMAIL_BOOTS = addMedievalArmorItem("platemail_boots", ArmorTypes.PLATEMAIL, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> BARBUTE = addMedievalArmorItem("barbute", ArmorTypes.BARBUTE, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.BARBUTE);
	public static final RegistrySupplier<MedievalArmorItem> HALFARMOR_CHESTPLATE = addMedievalArmorItem("halfarmor_chestplate", ArmorTypes.HALFARMOR, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> GREATHELM = addMedievalArmorItem("greathelm", ArmorTypes.CRUSADER, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CRUSADER_CHESTPLATE = addDyeableMedievalArmorItem("crusader_chestplate", ArmorTypes.CRUSADER, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR), -3227226);
	public static final RegistrySupplier<MedievalArmorItem> CRUSADER_LEGGINGS = addMedievalArmorItem("crusader_leggings", ArmorTypes.CRUSADER, EquipmentSlot.LEGS, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CRUSADER_BOOTS = addDyeableMedievalArmorItem("crusader_boots", ArmorTypes.CRUSADER, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR), -3227226);

	public static final RegistrySupplier<MedievalArmorItem> CEREMONIAL_ARMET = addKnightItem("ceremonialarmet", ArmorTypes.CEREMONIAL_ARMET, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CEREMONIAL_CHESTPLATE = addMedievalArmorItem("ceremonial_chestplate", ArmorTypes.CEREMONIAL, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CEREMONIAL_BOOTS = addMedievalArmorItem("ceremonial_boots", ArmorTypes.CEREMONIAL, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> COIF = addDyeableMedievalArmorItem("coif", ArmorTypes.GAMBESON, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR), -4280691);
	public static final RegistrySupplier<MedievalArmorItem> GAMBESON = addDyeableMedievalArmorItem("gambeson_chestplate", ArmorTypes.GAMBESON, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR), -4280691);
	public static final RegistrySupplier<MedievalArmorItem> PANTYHOSE = addDyeableMedievalArmorItem("pantyhose", ArmorTypes.GAMBESON, EquipmentSlot.LEGS, new Properties().tab(ModCreativeTabs.ARMOR), -14531028);
	public static final RegistrySupplier<MedievalArmorItem> GAMBESON_BOOTS = addDyeableMedievalArmorItem("gambeson_boots", ArmorTypes.GAMBESON, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR), -4280691);

	public static final RegistrySupplier<MedievalArmorItem> BRIGANDINE = addDyeableMedievalArmorItem("brigandine_chestplate", ArmorTypes.BRIGANDINE, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR), 10511680);

	public static final RegistrySupplier<MedievalArmorItem> NORMAN_HELMET = addMedievalArmorItem("norman_helmet", ArmorTypes.NORMAN, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> SHISHAK = addMedievalArmorItem("shishak", ArmorTypes.SHISHAK, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> RUSTED_BARBUTE = addMedievalArmorItem("rustedbarbute", ArmorTypes.RUSTED_BARBUTE, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.RUSTED), Models.ArmorEnum.BARBUTE);
	public static final RegistrySupplier<MedievalArmorItem> RUSTED_HALFARMOR_CHESTPLATE = addMedievalArmorItem("rustedhalfarmor_chestplate", ArmorTypes.RUSTED_HALFARMOR, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.RUSTED));

	public static final RegistrySupplier<MedievalArmorItem> RUSTED_GREATHELM = addMedievalArmorItem("rustedgreathelm", ArmorTypes.RUSTED_CRUSADER, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.RUSTED));
	public static final RegistrySupplier<MedievalArmorItem> RUSTED_CRUSADER_CHESTPLATE = addMedievalArmorItem("rustedcrusader_chestplate", ArmorTypes.RUSTED_CRUSADER, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.RUSTED));
	public static final RegistrySupplier<MedievalArmorItem> RUSTED_CRUSADER_BOOTS = addMedievalArmorItem("rustedcrusader_boots", ArmorTypes.RUSTED_CRUSADER, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.RUSTED));

	public static final RegistrySupplier<MedievalArmorItem> RUSTED_NORMAN_HELMET = addMedievalArmorItem("rustednorman_helmet", ArmorTypes.RUSTED_NORMAN, EquipmentSlot.HEAD,new Properties().tab(ModCreativeTabs.RUSTED));

	public static final RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_HELMET = addMedievalArmorItem("rustedchainmail_helmet", ArmorTypes.RUSTED_CHAINMAIL, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.RUSTED));
	public static final RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_CHESTPLATE = addMedievalArmorItem("rustedchainmail_chestplate", ArmorTypes.RUSTED_CHAINMAIL, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.RUSTED));
	public static final RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_LEGGINGS = addMedievalArmorItem("rustedchainmail_leggings", ArmorTypes.RUSTED_CHAINMAIL, EquipmentSlot.LEGS, new Properties().tab(ModCreativeTabs.RUSTED));
	public static final RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_BOOTS = addMedievalArmorItem("rustedchainmail_boots", ArmorTypes.RUSTED_CHAINMAIL, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.RUSTED));

	public static final RegistrySupplier<MedievalArmorItem> RUSTED_KETTLEHAT = addMedievalArmorItem("rustedkettlehat", ArmorTypes.RUSTED_KETTLEHAT, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.RUSTED), Models.ArmorEnum.KETTLEHAT);

	public static final RegistrySupplier<MedievalArmorItem> BASCINET = addMedievalArmorItem("bascinet", ArmorTypes.BASCINET, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.BASCINET);
	public static final RegistrySupplier<MedievalArmorItem> XIV_CENTURY_KNIGHT_CHESTPLATE = addMedievalArmorItem("xivcenturyknight_chestplate", ArmorTypes.XIV_CENTURY_KNIGHT, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> XIV_CENTURY_KNIGHT_LEGGINGS = addMedievalArmorItem("xivcenturyknight_leggings", ArmorTypes.XIV_CENTURY_KNIGHT, EquipmentSlot.LEGS, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> XIV_CENTURY_KNIGHT_BOOTS = addMedievalArmorItem("xivcenturyknight_boots", ArmorTypes.XIV_CENTURY_KNIGHT, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> WINGED_HUSSAR_CHESTPLATE = addMedievalArmorItem("wingedhussar_chestplate", ArmorTypes.WINGED_HUSSAR_CHESTPLATE, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.WINGED_HUSSAR_CHESTPLATE);

	public static final RegistrySupplier<MedievalArmorItem> BURGONET = addMedievalArmorItem("cuirassier_helmet", ArmorTypes.CUIRASSIER, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CUIRASSIER_CHESTPLATE = addDyeableMedievalArmorItem("cuirassier_chestplate", ArmorTypes.CUIRASSIER, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR), -5465480);
	public static final RegistrySupplier<MedievalArmorItem> CUIRASSIER_LEGGINGS = addDyeableMedievalArmorItem("cuirassier_leggings", ArmorTypes.CUIRASSIER, EquipmentSlot.LEGS, new Properties().tab(ModCreativeTabs.ARMOR), -5465480);
	public static final RegistrySupplier<MedievalArmorItem> CUIRASSIER_BOOTS = addMedievalArmorItem("cuirassier_boots", ArmorTypes.CUIRASSIER, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> GRAND_BASCINET = addMedievalArmorItem("grand_bascinet", ArmorTypes.GRAND_BASCINET, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.GRAND_BASCINET);
	public static final RegistrySupplier<MedievalArmorItem> KASTENBRUST_CHESTPLATE = addMedievalArmorItem("kastenbrust_chestplate", ArmorTypes.KASTENBRUST, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> KASTENBRUST_LEGGINGS = addMedievalArmorItem("kastenbrust_leggings", ArmorTypes.KASTENBRUST, EquipmentSlot.LEGS, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> KASTENBRUST_BOOTS = addMedievalArmorItem("kastenbrust_boots", ArmorTypes.KASTENBRUST, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> FACE_HELMET = addMedievalArmorItem("face_helmet", ArmorTypes.LAMELLAR, EquipmentSlot.HEAD, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> LAMELLAR_CHESTPLATE = addMedievalArmorItem("lamellar_chestplate", ArmorTypes.LAMELLAR, EquipmentSlot.CHEST, new Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> LAMELLAR_BOOTS = addMedievalArmorItem("lamellar_boots", ArmorTypes.LAMELLAR, EquipmentSlot.FEET, new Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalHorseArmorItem> BARDING = ITEMS.register("barding", () -> new MedievalHorseArmorItem(12, new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/barding.png"), new Properties().stacksTo(1).tab(ModCreativeTabs.ARMOR)));
	public static final RegistrySupplier<MedievalHorseArmorItem> CHAINMAIL_HORSE_ARMOR = ITEMS.register("chainmail_horse_armor", () -> new MedievalHorseArmorItem(6, new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/horse_armor_chainmail.png"), new Properties().stacksTo(1).tab(ModCreativeTabs.ARMOR)));

	//Weapons
	public static final WeaponsSupply STILETTOS = new WeaponsSupply(WeaponsWorkshop.STILETTO);
	public static final WeaponsSupply SHORT_SWORDS = new WeaponsSupply(WeaponsWorkshop.SHORT_SWORD);
	public static final WeaponsSupply KATZBALGERS = new WeaponsSupply(WeaponsWorkshop.KATZBALGER);
	public static final WeaponsSupply PIKES = new WeaponsSupply(WeaponsWorkshop.PIKE);
	public static final WeaponsSupply RANSEURS = new WeaponsSupply(WeaponsWorkshop.RANSEUR);
	public static final WeaponsSupply AHLSPIESSES = new WeaponsSupply(WeaponsWorkshop.AHLSPIESS);
	public static final WeaponsSupply GIANT_LANCES = new WeaponsSupply(WeaponsWorkshop.GIANT_LANCE);
	public static final WeaponsSupply BASTARD_SWORDS = new WeaponsSupply(WeaponsWorkshop.BASTARD_SWORD);
	public static final WeaponsSupply ESTOCS = new WeaponsSupply(WeaponsWorkshop.ESTOC);
	public static final WeaponsSupply CLAYMORS = new WeaponsSupply(WeaponsWorkshop.CLAYMORE);
	public static final WeaponsSupply ZWEIHANDERS = new WeaponsSupply(WeaponsWorkshop.ZWEIHANDER);
	public static final WeaponsSupply FLAME_BLADED_SWORDS = new WeaponsSupply(WeaponsWorkshop.FlAME_BLADED_SWORD);
	public static final WeaponsSupply LOCHABER_AXES = new WeaponsSupply(WeaponsWorkshop.LOCHABER_AXE);
	public static final WeaponsSupply CONCAVE_EDGED_HALBERDS = new WeaponsSupply(WeaponsWorkshop.CONCAVE_EDGED_HALBERD);
	public static final WeaponsSupply HEAVY_MACES = new WeaponsSupply(WeaponsWorkshop.HEAVY_MACE);
	public static final WeaponsSupply HEAVY_WAR_HAMMERS = new WeaponsSupply(WeaponsWorkshop.HEAVY_WAR_HAMMER);
	public static final WeaponsSupply LUCERNE_HAMMERS = new WeaponsSupply(WeaponsWorkshop.LUCERNE_HAMMER);
	public static final WeaponsSupply MORNINGSTARS = new WeaponsSupply(WeaponsWorkshop.MORNINGSTAR);
	public static final WeaponsSupply FLAILS = new WeaponsSupply(WeaponsWorkshop.FLAIL);
	public static final WeaponsSupply GUISARMES = new WeaponsSupply(WeaponsWorkshop.GUISARME);

	public static final RegistrySupplier<MedievalWeaponItem> BLACKSMITH_HAMMER = addMedievalWeaponItem("blacksmith_hammer", new Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS), ModItemTier.STEEL, WeaponTypes.BLACKSMITH_HAMMER);
	public static final RegistrySupplier<MedievalWeaponItem> BARBED_CLUB = addMedievalWeaponItem("barbedclub", new Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS), ModItemTier.IRON, WeaponTypes.BARBED_CLUB);
	public static final RegistrySupplier<MedievalWeaponItem> PITCHFORK = addMedievalWeaponItem("pitchfork", new Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS), ModItemTier.IRON, WeaponTypes.PITCHFORK);
	public static final RegistrySupplier<MedievalWeaponItem> NOBLE_SWORD = addMedievalWeaponItem("noble_sword", new Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS), ModItemTier.IRON, WeaponTypes.NOBLE_SWORD);
	public static final RegistrySupplier<MedievalWeaponItem> RUSTED_BASTARD_SWORD = addMedievalWeaponItem("rusted_bastardsword", new Properties().tab(ModCreativeTabs.RUSTED), ModItemTier.IRON, WeaponTypes.RUSTED_BASTARD_SWORD);
	public static final RegistrySupplier<MedievalWeaponItem> RUSTED_HEAVY_MACE = addMedievalWeaponItem("rusted_heavymace", new Properties().tab(ModCreativeTabs.RUSTED), ModItemTier.IRON, WeaponTypes.RUSTED_HEAVY_MACE);
	public static final RegistrySupplier<MedievalWeaponItem> CLUB = addMedievalWeaponItem("club", new Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS), ModItemTier.WOOD, WeaponTypes.CLUB);
	public static final RegistrySupplier<MedievalWeaponItem> MESSER_SWORD = addMedievalWeaponItem("messer_sword", new Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS), ModItemTier.IRON, WeaponTypes.MESSER_SWORD);

	public static final RegistrySupplier<BowItem> LONGBOW = ITEMS.register("longbow", () -> new MedievalBowItem(new Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS).stacksTo(1).durability(420), 4.2f, 26.0f));
	public static final RegistrySupplier<CrossbowItem> HEAVY_CROSSBOW = ITEMS.register("heavy_crossbow", () -> new MedievalCrossbowItem(new Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS).stacksTo(1).durability(500), 4.3f, 50));

	//Shields
	public static final ShieldsSupply HEATER_SHIELDS = new ShieldsSupply(ShieldsWorkshop.HEATER_SHIELD, "heatershield");
	public static final ShieldsSupply TARGETS = new ShieldsSupply(ShieldsWorkshop.TARGET, "target");
	public static final ShieldsSupply BUCKLERS = new ShieldsSupply(ShieldsWorkshop.BUCKLER, "buckler");
	public static final ShieldsSupply RONDACHES = new ShieldsSupply(ShieldsWorkshop.RONDACHE, "rondache");
	public static final ShieldsSupply TARTSCHES = new ShieldsSupply(ShieldsWorkshop.TARTSCHE, "tartsche");
	public static final ShieldsSupply ELLIPTICAL_SHIELDS = new ShieldsSupply(ShieldsWorkshop.ELLIPTICAL_SHIELD, "ellipticalshield");
	public static final ShieldsSupply ROUND_SHIELDS = new ShieldsSupply(ShieldsWorkshop.ROUND_SHIELD, "roundshield");
	public static final ShieldsSupply PAVESES = new ShieldsSupply(ShieldsWorkshop.PAVESE, "pavese");
	public static final ShieldsSupply KITE_SHIELDS = new ShieldsSupply(ShieldsWorkshop.KITE_SHIELD, "kiteshield");

	public static final RegistrySupplier<MedievalShieldItem> CORRUPTED_ROUND_SHIELD = addMedievalShieldItem("corruptedroundshield", "corruptedroundshield", new Properties().tab(ModCreativeTabs.RUSTED), ModItemTier.WOOD, false, true, ShieldTypes.CORRUPTED_ROUND_SHIELD, Models.ShieldEnum.CORRUPTED_ROUND_SHIELD);

	//Patterns
	public static final RegistrySupplier<Item> APOSTOLIC_CROSS_PATTERN = ITEMS.register("apostolic_cross_pattern", () -> new HeraldryPatternItem(HeraldryPattern.APOSTOLIC_CROSS_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> BOWL_PATTERN = ITEMS.register("bowl_pattern", () -> new HeraldryPatternItem(HeraldryPattern.BOWL_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> BULL_PATTERN = ITEMS.register("bull_pattern", () -> new HeraldryPatternItem(HeraldryPattern.BULL_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> CHESS_PATTERN = ITEMS.register("chess_pattern", () -> new HeraldryPatternItem(HeraldryPattern.CHESS_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> CRUSADER_CROSS_PATTERN = ITEMS.register("crusader_cross_pattern", () -> new HeraldryPatternItem(HeraldryPattern.CRUSADER_CROSS_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> DRAGON_PATTERN = ITEMS.register("dragon_pattern", () -> new HeraldryPatternItem(HeraldryPattern.DRAGON_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> EAGLE_PATTERN = ITEMS.register("eagle_pattern", () -> new HeraldryPatternItem(HeraldryPattern.EAGLE_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> HORSE_PATTERN = ITEMS.register("horse_pattern", () -> new HeraldryPatternItem(HeraldryPattern.HORSE_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> LILY_PATTERN = ITEMS.register("lily_pattern", () -> new HeraldryPatternItem(HeraldryPattern.LILY_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> LION1_PATTERN = ITEMS.register("lion1_pattern", () -> new HeraldryPatternItem(HeraldryPattern.LION1_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> LION2_PATTERN = ITEMS.register("lion2_pattern", () -> new HeraldryPatternItem(HeraldryPattern.LION2_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> ORTHODOX_CROSS_PATTERN = ITEMS.register("orthodox_cross_pattern", () -> new HeraldryPatternItem(HeraldryPattern.ORTHODOX_CROSS_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> SNAKE_PATTERN = ITEMS.register("snake_pattern", () -> new HeraldryPatternItem(HeraldryPattern.SNAKE_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> SUN_PATTERN = ITEMS.register("sun_pattern", () -> new HeraldryPatternItem(HeraldryPattern.SUN_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> SWORDS_PATTERN = ITEMS.register("swords_pattern", () -> new HeraldryPatternItem(HeraldryPattern.SWORDS_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> TOWER_PATTERN = ITEMS.register("tower_pattern", () -> new HeraldryPatternItem(HeraldryPattern.TOWER_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> TREE_PATTERN = ITEMS.register("tree_pattern", () -> new HeraldryPatternItem(HeraldryPattern.TREE_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> TWOHEADED_EAGLE_PATTERN = ITEMS.register("two-headed_eagle_pattern", () -> new HeraldryPatternItem(HeraldryPattern.TWOHEADED_EAGLE_PATTERN, new Properties().tab(CreativeModeTab.TAB_MATERIALS)));

	//Materials
	public static final RegistrySupplier<Item> STEEL_INGOT = addIngredientItem("steel_ingot", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> STEEL_NUGGET = addIngredientItem("steel_nugget", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> STEEL_RING = addIngredientItem("steel_ring", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> STEEL_CHAINMAIL = addIngredientItem("steel_chainmail", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> STEEL_PLATE = addIngredientItem("steel_plate", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> LEATHER_STRIP = addIngredientItem("leather_strip", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> HILT = addIngredientItem("hilt", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> POLE = addIngredientItem("pole", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> STEEL_CHAIN = addIngredientItem("steel_chain", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> WOOLEN_FABRIC = addIngredientItem("woolen_fabric", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> SMALL_STEEL_PLATE = addIngredientItem("small_steel_plate", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> LAMELLAR_ROWS = addIngredientItem("lamellar_rows", () -> new Item(new Properties().tab(CreativeModeTab.TAB_MATERIALS)));

	static
	{
		if (Platform.isFabric())
		{
			ITEMS.register("tin_ingot", () -> new Item(new Properties()));
			ITEMS.register("silver_ingot", () -> new Item(new Properties()));
			ITEMS.register("bronze_ingot", () -> new Item(new Properties()));
		}
	}

	public static class ItemsSupply<T extends Item>
	{
		public RegistrySupplier<T> wood;
		public RegistrySupplier<T> stone;
		public RegistrySupplier<T> iron;
		public RegistrySupplier<T> gold;
		public RegistrySupplier<T> diamond;

		public RegistrySupplier<T> copper;
		public RegistrySupplier<T> steel;
		public RegistrySupplier<T> silver;
		public RegistrySupplier<T> netherite;
		public RegistrySupplier<T> tin;
		public RegistrySupplier<T> bronze;

		public ItemsSupply(BiFunction<ModItemTier, Properties, RegistrySupplier<T>> workshop, Properties prop)
		{
			this.wood = workshop.apply(ModItemTier.WOOD, prop);
			this.stone = workshop.apply(ModItemTier.STONE, prop);
			this.iron = workshop.apply(ModItemTier.IRON, prop);
			this.gold = workshop.apply(ModItemTier.GOLD, prop);
			this.diamond = workshop.apply(ModItemTier.DIAMOND, prop);
			this.netherite = workshop.apply(ModItemTier.NETHERITE, prop.fireResistant());

			this.copper = workshop.apply(ModItemTier.COPPER, prop);
			this.steel = workshop.apply(ModItemTier.STEEL, prop);
			this.silver = workshop.apply(ModItemTier.SILVER, prop);
			this.tin = workshop.apply(ModItemTier.TIN, prop);
			this.bronze = workshop.apply(ModItemTier.BRONZE, prop);
		}

		public ArrayList<RegistrySupplier<T>> get()
		{
			ArrayList<RegistrySupplier<T>> suppliers = new ArrayList<>();

			suppliers.add(this.wood);
			suppliers.add(this.stone);
			suppliers.add(this.iron);
			suppliers.add(this.gold);
			suppliers.add(this.diamond);
			suppliers.add(this.copper);
			suppliers.add(this.steel);
			suppliers.add(this.silver);
			suppliers.add(this.netherite);
			suppliers.add(this.tin);
			suppliers.add(this.bronze);

			return suppliers;
		}
	}

	public static class WeaponsSupply extends ItemsSupply<MedievalWeaponItem>
	{
		public WeaponsSupply(BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> workshop)
		{
			super(workshop, new Properties().tab(ModCreativeTabs.WEAPONS));
		}
	}

	public static class ShieldsSupply extends ItemsSupply<MedievalShieldItem>
	{
		public String shieldName;

		public String woodTexture;
		public String stoneTexture;
		public String ironTexture;
		public String goldTexture;
		public String diamondTexture;
		public String netheriteTexture;

		public String copperTexture;
		public String steelTexture;
		public String silverTexture;
		public String tinTexture;
		public String bronzeTexture;

		public ShieldsSupply(BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> workshop, String shieldName)
		{
			super(workshop, new Properties().tab(ModCreativeTabs.SHIELDS));

			this.shieldName = shieldName;

			this.woodTexture = "entity/" + ModItemTier.WOOD.getMaterialName() + "_" + shieldName;
			this.stoneTexture = "entity/" + ModItemTier.STONE.getMaterialName() + "_" + shieldName;
			this.ironTexture = "entity/" + ModItemTier.IRON.getMaterialName() + "_" + shieldName;
			this.goldTexture = "entity/" + ModItemTier.GOLD.getMaterialName() + "_" + shieldName;
			this.diamondTexture = "entity/" + ModItemTier.DIAMOND.getMaterialName() + "_" + shieldName;
			this.copperTexture = "entity/" + ModItemTier.COPPER.getMaterialName() + "_" + shieldName;
			this.steelTexture = "entity/" + ModItemTier.STEEL.getMaterialName() + "_" + shieldName;
			this.silverTexture = "entity/" + ModItemTier.SILVER.getMaterialName() + "_" + shieldName;
			this.netheriteTexture = "entity/" + ModItemTier.NETHERITE.getMaterialName() + "_" + shieldName;
			this.tinTexture = "entity/" + ModItemTier.TIN.getMaterialName() + "_" + shieldName;
			this.bronzeTexture = "entity/" + ModItemTier.BRONZE.getMaterialName() + "_" + shieldName;
		}

		public void stitchWithoutPatterns(TextureAtlas atlas, Consumer<ResourceLocation> adder)
		{
			if (atlas.location() == TextureAtlas.LOCATION_BLOCKS)
			{
				String[] textures = new String[] { this.woodTexture, this.stoneTexture, this.ironTexture, this.goldTexture, this.diamondTexture, this.netheriteTexture, this.copperTexture, this.steelTexture, this.silverTexture, this.netheriteTexture, this.tinTexture, this.bronzeTexture };
				for (String texture : textures)
				{
					adder.accept(new ResourceLocation(KnightlyArmory.ID, texture + "_nopattern"));
				}
			}
		}

		public void stitch(TextureAtlas atlas, Consumer<ResourceLocation> adder)
		{
			if (atlas.location() == TextureAtlas.LOCATION_BLOCKS)
			{
				String[] textures = new String[] { this.woodTexture, this.stoneTexture, this.ironTexture, this.goldTexture, this.diamondTexture, this.netheriteTexture, this.copperTexture, this.steelTexture, this.silverTexture, this.netheriteTexture, this.tinTexture, this.bronzeTexture };
				for (String texture : textures)
				{
					ResourceLocation location1 = new ResourceLocation(KnightlyArmory.ID, texture + "_pattern");
					adder.accept(location1);
					ResourceLocation location2 = new ResourceLocation(KnightlyArmory.ID, texture + "_nopattern");
					adder.accept(location2);
				}
			}

			if (atlas.location() == Sheets.SHIELD_SHEET)
			{
				for (BannerPattern bannerPattern : BannerPattern.values())
				{
					String filename = bannerPattern.getFilename();
					if (filename.contains(":"))
						filename = filename.split(":")[1];
					ResourceLocation location = new ResourceLocation(KnightlyArmory.ID, "entity/" + this.shieldName + "/" + filename);
					adder.accept(location);
				}
			}
		}
	}

	public static RegistrySupplier<MedievalArmorItem> addKnightItem(String id, ArmorType type, EquipmentSlot slot, Item.Properties properties)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalArmorItem> armor = ItemRegistryHelper.registerKnightItem(id, type, slot, properties);
		DYEABLE_ITEMS.add(armor);
		ARMOR_ITEMS.add(armor);
		return armor;
	}

	public static RegistrySupplier<MedievalArmorItem> addJoustingItem(String id, ArmorType type, EquipmentSlot slot, Item.Properties properties)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalArmorItem> armor = ItemRegistryHelper.registerJoustingItem(id, type, slot, properties);
		ARMOR_ITEMS.add(armor);
		return armor;
	}

	public static RegistrySupplier<MedievalArmorItem> addMedievalArmorItem(String id, ArmorType type, EquipmentSlot slot, Item.Properties properties)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalArmorItem> armor = ItemRegistryHelper.registerMedievalArmorItem(id, type, slot, properties);
		ARMOR_ITEMS.add(armor);
		return armor;
	}

	public static RegistrySupplier<MedievalArmorItem> addMedievalArmorItem(String id, ArmorType type, EquipmentSlot slot, Item.Properties properties, Models.ArmorEnum modelkey)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalArmorItem> armor = ItemRegistryHelper.registerMedievalArmorItem(id, type, slot, properties, modelkey);
		ARMOR_ITEMS.add(armor);
		return armor;
	}

	public static RegistrySupplier<MedievalArmorItem> addDyeableMedievalArmorItem(String id, ArmorType type, EquipmentSlot slot, Item.Properties properties, int defaultcolor)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalArmorItem> armor = ItemRegistryHelper.registerDyeableMedievalArmorItem(id, type, slot, properties, defaultcolor);
		DYEABLE_ITEMS.add(armor);
		ARMOR_ITEMS.add(armor);
		return armor;
	}

	public static RegistrySupplier<MedievalArmorItem> addDyeableMedievalArmorItem(String id, ArmorType type, EquipmentSlot slot, Item.Properties properties, int defaultcolor, Models.ArmorEnum modelkey)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalArmorItem> armor = ItemRegistryHelper.registerDyeableMedievalArmorItem(id, type, slot, properties, defaultcolor, modelkey);
		DYEABLE_ITEMS.add(armor);
		ARMOR_ITEMS.add(armor);
		return armor;
	}

	public static RegistrySupplier<MedievalWeaponItem> addMedievalWeaponItem(String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalWeaponItem> weapon = ItemRegistryHelper.registerMedievalWeaponItem(id, properties, material, type);
		WEAPON_ITEMS.add(weapon);
		return weapon;
	}

	public static RegistrySupplier<MedievalWeaponItem> addLanceItem(String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalWeaponItem> weapon = ItemRegistryHelper.registerLanceItem(id, properties, material, type);
		WEAPON_ITEMS.add(weapon);
		return weapon;
	}

	public static RegistrySupplier<Item> addIngredientItem(String id, Supplier<Item> supplier)
	{
		RegistrySupplier<Item> registrysupplier = ITEMS.register(id, supplier);
		INGREDIENT_ITEMS.add(registrysupplier);
		return registrysupplier;
	}

	public static RegistrySupplier<MedievalShieldItem> addMedievalShieldItem(String id, String name, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Models.ShieldEnum modelkey)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalShieldItem> shield = ItemRegistryHelper.registerMedievalShieldItem(id, name, properties, material, paintable, is3d, type, modelkey);
		SHIELD_ITEMS.add(shield);
		return shield;
	}

	static class ShieldsWorkshop
	{
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> HEATER_SHIELD = (material, prop) -> addMedievalShieldItem(material.getMaterialName() + "_heatershield", "heatershield", prop, material, true, true, ShieldTypes.HEATER_SHIELD, Models.ShieldEnum.HEATER_SHIELD);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> TARGET = (material, prop) -> addMedievalShieldItem(material.getMaterialName() + "_target", "target", prop, material, false, true, ShieldTypes.TARGET, Models.ShieldEnum.TARGET);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> BUCKLER = (material, prop) -> addMedievalShieldItem(material.getMaterialName() + "_buckler", "buckler", prop, material, false, true, ShieldTypes.BUCKLER, Models.ShieldEnum.BUCKLER);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> RONDACHE = (material, prop) -> addMedievalShieldItem(material.getMaterialName() + "_rondache", "rondache", prop, material, false, true, ShieldTypes.RONDACHE, Models.ShieldEnum.RONDACHE);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> TARTSCHE = (material, prop) -> addMedievalShieldItem(material.getMaterialName() + "_tartsche", "tartsche", prop, material, true, true, ShieldTypes.TARTSCHE, Models.ShieldEnum.TARTSCHE);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> ELLIPTICAL_SHIELD = (material, prop) -> addMedievalShieldItem(material.getMaterialName() + "_ellipticalshield", "ellipticalshield", prop, material, true, true, ShieldTypes.ELLIPTICAL_SHIELD, Models.ShieldEnum.ELLIPTICAL_SHIELD);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> ROUND_SHIELD = (material, prop) -> addMedievalShieldItem(material.getMaterialName() + "_roundshield", "roundshield", prop, material, true, true, ShieldTypes.ROUND_SHIELD, Models.ShieldEnum.ROUND_SHIELD);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> PAVESE = (material, prop) -> addMedievalShieldItem(material.getMaterialName() + "_pavese", "pavese", prop, material, true, true, ShieldTypes.PAVESE, Models.ShieldEnum.PAVESE);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> KITE_SHIELD = (material, prop) -> addMedievalShieldItem(material.getMaterialName() + "_kiteshield", "kiteshield", prop, material, true, true, ShieldTypes.KITE_SHIELD, Models.ShieldEnum.KITE_SHIELD);
	}

	static class WeaponsWorkshop
	{
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> STILETTO = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_stylet", prop, material, WeaponTypes.STILETTO);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> SHORT_SWORD = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_shortsword", prop, material, WeaponTypes.SHORT_SWORD);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> KATZBALGER = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_katzbalger", prop, material, WeaponTypes.KATZBALGER);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> PIKE = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_pike", prop, material, WeaponTypes.PIKE);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> RANSEUR = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_ranseur", prop, material, WeaponTypes.RANSEUR);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> AHLSPIESS = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_ahlspiess", prop, material, WeaponTypes.AHLSPIESS);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> GIANT_LANCE = (material, prop) -> addLanceItem(material.getMaterialName() + "_chivalrylance", prop, material, WeaponTypes.GIANT_LANCE);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> BASTARD_SWORD = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_bastardsword", prop, material, WeaponTypes.BASTARD_SWORD);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> ESTOC = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_estoc", prop, material, WeaponTypes.ESTOC);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> CLAYMORE = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_claymore", prop, material, WeaponTypes.CLAYMORE);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> ZWEIHANDER = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_zweihander", prop, material, WeaponTypes.ZWEIHANDER);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> FlAME_BLADED_SWORD = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_flamebladedsword", prop, material, WeaponTypes.FlAME_BLADED_SWORD);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> LOCHABER_AXE = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_lochaberaxe", prop, material, WeaponTypes.LOCHABER_AXE);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> CONCAVE_EDGED_HALBERD = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_concavehalberd", prop, material, WeaponTypes.CONCAVE_EDGED_HALBERD);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> HEAVY_MACE = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_heavymace", prop, material, WeaponTypes.HEAVY_MACE);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> HEAVY_WAR_HAMMER = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_heavywarhammer", prop, material, WeaponTypes.HEAVY_WAR_HAMMER);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> LUCERNE_HAMMER = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_lucernhammer", prop, material, WeaponTypes.LUCERNE_HAMMER);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> MORNINGSTAR = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_morgenstern", prop, material, WeaponTypes.MORNINGSTAR);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> FLAIL = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_chainmorgenstern", prop, material, WeaponTypes.FLAIL);
		public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> GUISARME = (material, prop) -> addMedievalWeaponItem(material.getMaterialName() + "_guisarme", prop, material, WeaponTypes.GUISARME);
	}

	public static void init()
	{
		ITEMS.register();
	}
}




