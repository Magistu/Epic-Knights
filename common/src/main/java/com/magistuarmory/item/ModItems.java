package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.init.HeraldryPattern;
import com.magistuarmory.init.ModCreativeTabs;
import com.magistuarmory.item.armor.ArmorMaterials;
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
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class ModItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(KnightlyArmory.ID, Registry.ITEM_REGISTRY);

	//Armor
	public static final RegistrySupplier<MedievalArmorItem> ARMET = ItemRegistryHelper.registerKnightItem("armet", ArmorMaterials.ARMET, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> KNIGHT_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("knight_chestplate", ArmorMaterials.KNIGHT, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> KNIGHT_LEGGINGS = ItemRegistryHelper.registerMedievalArmorItem("knight_leggings", ArmorMaterials.KNIGHT, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> KNIGHT_BOOTS = ItemRegistryHelper.registerMedievalArmorItem("knight_boots", ArmorMaterials.KNIGHT, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> STECHHELM = ItemRegistryHelper.registerJoustingItem("stechhelm", ArmorMaterials.STECHHELM, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> JOUSTING_CHESTPLATE = ItemRegistryHelper.registerJoustingItem("jousting_chestplate", ArmorMaterials.JOUSTING, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> JOUSTING_LEGGINGS = ItemRegistryHelper.registerJoustingItem("jousting_leggings", ArmorMaterials.JOUSTING, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> JOUSTING_BOOTS = ItemRegistryHelper.registerJoustingItem("jousting_boots", ArmorMaterials.JOUSTING, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> SALLET = ItemRegistryHelper.registerMedievalArmorItem("sallet", ArmorMaterials.SALLET, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.SALLET);
	public static final RegistrySupplier<MedievalArmorItem> GOTHIC_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("gothic_chestplate", ArmorMaterials.GOTHIC, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> GOTHIC_LEGGINGS = ItemRegistryHelper.registerMedievalArmorItem("gothic_leggings", ArmorMaterials.GOTHIC, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> GOTHIC_BOOTS = ItemRegistryHelper.registerMedievalArmorItem("gothic_boots", ArmorMaterials.GOTHIC, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> MAXIMILIAN_HELMET = ItemRegistryHelper.registerMedievalArmorItem("maximilian_helmet", ArmorMaterials.MAXIMILIANHELMET, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.MAXIMILIAN_HELMET);
	public static final RegistrySupplier<MedievalArmorItem> MAXIMILIAN_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("maximilian_chestplate", ArmorMaterials.MAXIMILIAN, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> MAXIMILIAN_LEGGINGS = ItemRegistryHelper.registerMedievalArmorItem("maximilian_leggings", ArmorMaterials.MAXIMILIAN, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> MAXIMILIAN_BOOTS = ItemRegistryHelper.registerMedievalArmorItem("maximilian_boots", ArmorMaterials.MAXIMILIAN, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> CHAINMAIL_HELMET = ItemRegistryHelper.registerMedievalArmorItem("chainmail_helmet", ArmorMaterials.CHAINMAIL, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CHAINMAIL_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("chainmail_chestplate", ArmorMaterials.CHAINMAIL, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CHAINMAIL_LEGGINGS = ItemRegistryHelper.registerMedievalArmorItem("chainmail_leggings", ArmorMaterials.CHAINMAIL, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CHAINMAIL_BOOTS = ItemRegistryHelper.registerMedievalArmorItem("chainmail_boots", ArmorMaterials.CHAINMAIL, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> KETTLEHAT = ItemRegistryHelper.registerMedievalArmorItem("kettlehat", ArmorMaterials.KETTLEHAT, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.KETTLEHAT);
	public static final RegistrySupplier<MedievalArmorItem> PLATEMAIL_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("platemail_chestplate", ArmorMaterials.PLATEMAIL, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> PLATEMAIL_LEGGINGS = ItemRegistryHelper.registerMedievalArmorItem("platemail_leggings", ArmorMaterials.PLATEMAIL, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> PLATEMAIL_BOOTS = ItemRegistryHelper.registerMedievalArmorItem("platemail_boots", ArmorMaterials.PLATEMAIL, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> BARBUTE = ItemRegistryHelper.registerMedievalArmorItem("barbute", ArmorMaterials.BARBUTE, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.BARBUTE);
	public static final RegistrySupplier<MedievalArmorItem> HALFARMOR_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("halfarmor_chestplate", ArmorMaterials.HALFARMOR, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> GREATHELM = ItemRegistryHelper.registerMedievalArmorItem("greathelm", ArmorMaterials.CRUSADER, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CRUSADER_CHESTPLATE = ItemRegistryHelper.registerDyeableMedievalArmorItem("crusader_chestplate", ArmorMaterials.CRUSADER, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR), -3227226);
	public static final RegistrySupplier<MedievalArmorItem> CRUSADER_LEGGINGS = ItemRegistryHelper.registerMedievalArmorItem("crusader_leggings", ArmorMaterials.CRUSADER, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CRUSADER_BOOTS = ItemRegistryHelper.registerDyeableMedievalArmorItem("crusader_boots", ArmorMaterials.CRUSADER, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR), -3227226);

	public static final RegistrySupplier<MedievalArmorItem> CEREMONIAL_ARMET = ItemRegistryHelper.registerKnightItem("ceremonialarmet", ArmorMaterials.CEREMONIAL_ARMET, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CEREMONIAL_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("ceremonial_chestplate", ArmorMaterials.CEREMONIAL, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CEREMONIAL_BOOTS = ItemRegistryHelper.registerMedievalArmorItem("ceremonial_boots", ArmorMaterials.CEREMONIAL, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> COIF = ItemRegistryHelper.registerDyeableMedievalArmorItem("coif", ArmorMaterials.GAMBESON, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR), -4280691);
	public static final RegistrySupplier<MedievalArmorItem> GAMBESON = ItemRegistryHelper.registerDyeableMedievalArmorItem("gambeson_chestplate", ArmorMaterials.GAMBESON, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR), -4280691);
	public static final RegistrySupplier<MedievalArmorItem> PANTYHOSE = ItemRegistryHelper.registerDyeableMedievalArmorItem("pantyhose", ArmorMaterials.GAMBESON, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTabs.ARMOR), -14531028);
	public static final RegistrySupplier<MedievalArmorItem> GAMBESON_BOOTS = ItemRegistryHelper.registerDyeableMedievalArmorItem("gambeson_boots", ArmorMaterials.GAMBESON, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR), -4280691);

	public static final RegistrySupplier<MedievalArmorItem> BRIGANDINE = ItemRegistryHelper.registerDyeableMedievalArmorItem("brigandine_chestplate", ArmorMaterials.BRIGANDINE, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR), 10511680);

	public static final RegistrySupplier<MedievalArmorItem> NORMAN_HELMET = ItemRegistryHelper.registerMedievalArmorItem("norman_helmet", ArmorMaterials.NORMAN, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> SHISHAK = ItemRegistryHelper.registerMedievalArmorItem("shishak", ArmorMaterials.SHISHAK, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> RUSTED_BARBUTE = ItemRegistryHelper.registerMedievalArmorItem("rustedbarbute", ArmorMaterials.RUSTED_BARBUTE, EquipmentSlot.HEAD, new Item.Properties(), Models.ArmorEnum.BARBUTE);
	public static final RegistrySupplier<MedievalArmorItem> RUSTED_HALFARMOR_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("rustedhalfarmor_chestplate", ArmorMaterials.RUSTED_HALFARMOR, EquipmentSlot.CHEST, new Item.Properties());

	public static final RegistrySupplier<MedievalArmorItem> RUSTED_GREATHELM = ItemRegistryHelper.registerMedievalArmorItem("rustedgreathelm", ArmorMaterials.RUSTED_CRUSADER, EquipmentSlot.HEAD, new Item.Properties());
	public static final RegistrySupplier<MedievalArmorItem> RUSTED_CRUSADER_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("rustedcrusader_chestplate", ArmorMaterials.RUSTED_CRUSADER, EquipmentSlot.CHEST, new Item.Properties());
	public static final RegistrySupplier<MedievalArmorItem> RUSTED_CRUSADER_BOOTS = ItemRegistryHelper.registerMedievalArmorItem("rustedcrusader_boots", ArmorMaterials.RUSTED_CRUSADER, EquipmentSlot.FEET, new Item.Properties());

	public static final RegistrySupplier<MedievalArmorItem> RUSTED_NORMAN_HELMET = ItemRegistryHelper.registerMedievalArmorItem("rustednorman_helmet", ArmorMaterials.RUSTED_NORMAN, EquipmentSlot.HEAD, new Item.Properties());

	public static final RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_HELMET = ItemRegistryHelper.registerMedievalArmorItem("rustedchainmail_helmet", ArmorMaterials.RUSTED_CHAINMAIL, EquipmentSlot.HEAD, (new Item.Properties()));
	public static final RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("rustedchainmail_chestplate", ArmorMaterials.RUSTED_CHAINMAIL, EquipmentSlot.CHEST, (new Item.Properties()));
	public static final RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_LEGGINGS = ItemRegistryHelper.registerMedievalArmorItem("rustedchainmail_leggings", ArmorMaterials.RUSTED_CHAINMAIL, EquipmentSlot.LEGS, (new Item.Properties()));
	public static final RegistrySupplier<MedievalArmorItem> RUSTED_CHAINMAIL_BOOTS = ItemRegistryHelper.registerMedievalArmorItem("rustedchainmail_boots", ArmorMaterials.RUSTED_CHAINMAIL, EquipmentSlot.FEET, (new Item.Properties()));

	public static final RegistrySupplier<MedievalArmorItem> RUSTED_KETTLEHAT = ItemRegistryHelper.registerMedievalArmorItem("rustedkettlehat", ArmorMaterials.RUSTED_KETTLEHAT, EquipmentSlot.HEAD, (new Item.Properties()), Models.ArmorEnum.KETTLEHAT);

	public static final RegistrySupplier<MedievalArmorItem> BASCINET = ItemRegistryHelper.registerMedievalArmorItem("bascinet", ArmorMaterials.BASCINET, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.BASCINET);
	public static final RegistrySupplier<MedievalArmorItem> XIV_CENTURY_KNIGHT_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("xivcenturyknight_chestplate", ArmorMaterials.XIV_CENTURY_KNIGHT, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> XIV_CENTURY_KNIGHT_LEGGINGS = ItemRegistryHelper.registerMedievalArmorItem("xivcenturyknight_leggings", ArmorMaterials.XIV_CENTURY_KNIGHT, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> XIV_CENTURY_KNIGHT_BOOTS = ItemRegistryHelper.registerMedievalArmorItem("xivcenturyknight_boots", ArmorMaterials.XIV_CENTURY_KNIGHT, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> WINGED_HUSSAR_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("wingedhussar_chestplate", ArmorMaterials.WINGEDHUSSARCHESTPLATE, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.WINGED_HUSSAR_CHESTPLATE);

	public static final RegistrySupplier<MedievalArmorItem> BURGONET = ItemRegistryHelper.registerMedievalArmorItem("cuirassier_helmet", ArmorMaterials.CUIRASSIER, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> CUIRASSIER_CHESTPLATE = ItemRegistryHelper.registerDyeableMedievalArmorItem("cuirassier_chestplate", ArmorMaterials.CUIRASSIER, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR), -5465480);
	public static final RegistrySupplier<MedievalArmorItem> CUIRASSIER_LEGGINGS = ItemRegistryHelper.registerDyeableMedievalArmorItem("cuirassier_leggings", ArmorMaterials.CUIRASSIER, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTabs.ARMOR), -5465480);
	public static final RegistrySupplier<MedievalArmorItem> CUIRASSIER_BOOTS = ItemRegistryHelper.registerMedievalArmorItem("cuirassier_boots", ArmorMaterials.CUIRASSIER, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> GRAND_BASCINET = ItemRegistryHelper.registerMedievalArmorItem("grand_bascinet", ArmorMaterials.GRAND_BASCINET, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR), Models.ArmorEnum.GRAND_BASCINET);
	public static final RegistrySupplier<MedievalArmorItem> KASTENBRUST_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("kastenbrust_chestplate", ArmorMaterials.KASTENBRUST, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> KASTENBRUST_LEGGINGS = ItemRegistryHelper.registerMedievalArmorItem("kastenbrust_leggings", ArmorMaterials.KASTENBRUST, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> KASTENBRUST_BOOTS = ItemRegistryHelper.registerMedievalArmorItem("kastenbrust_boots", ArmorMaterials.KASTENBRUST, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalArmorItem> FACE_HELMET = ItemRegistryHelper.registerMedievalArmorItem("face_helmet", ArmorMaterials.LAMELLAR, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> LAMELLAR_CHESTPLATE = ItemRegistryHelper.registerMedievalArmorItem("lamellar_chestplate", ArmorMaterials.LAMELLAR, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeTabs.ARMOR));
	public static final RegistrySupplier<MedievalArmorItem> LAMELLAR_BOOTS = ItemRegistryHelper.registerMedievalArmorItem("lamellar_boots", ArmorMaterials.LAMELLAR, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeTabs.ARMOR));

	public static final RegistrySupplier<MedievalHorseArmorItem> BARDING = ITEMS.register("barding", () -> new MedievalHorseArmorItem(12, new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/barding.png"), new Item.Properties().stacksTo(1).tab(ModCreativeTabs.ARMOR)));
	public static final RegistrySupplier<MedievalHorseArmorItem> CHAINMAIL_HORSE_ARMOR = ITEMS.register("chainmail_horse_armor", () -> new MedievalHorseArmorItem(6, new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/horse_armor_chainmail.png"), new Item.Properties().stacksTo(1).tab(ModCreativeTabs.ARMOR)));

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

	public static final RegistrySupplier<MedievalWeaponItem> BLACKSMITH_HAMMER = ItemRegistryHelper.registerMedievalWeaponItem("blacksmith_hammer", new Item.Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS), ModItemTier.STEEL, WeaponType.BLACKSMITH_HAMMER);
	public static final RegistrySupplier<MedievalWeaponItem> BARBED_CLUB = ItemRegistryHelper.registerMedievalWeaponItem("barbedclub", new Item.Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS), ModItemTier.IRON, WeaponType.BARBED_CLUB);
	public static final RegistrySupplier<MedievalWeaponItem> PITCHFORK = ItemRegistryHelper.registerMedievalWeaponItem("pitchfork", new Item.Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS), ModItemTier.IRON, WeaponType.PITCHFORK);
	public static final RegistrySupplier<MedievalWeaponItem> NOBLE_SWORD = ItemRegistryHelper.registerMedievalWeaponItem("noble_sword", new Item.Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS), ModItemTier.IRON, WeaponType.NOBLE_SWORD);
	public static final RegistrySupplier<MedievalWeaponItem> RUSTED_BASTARD_SWORD = ItemRegistryHelper.registerMedievalWeaponItem("rusted_bastardsword", new Item.Properties(), ModItemTier.IRON, WeaponType.RUSTED_BASTARD_SWORD);
	public static final RegistrySupplier<MedievalWeaponItem> RUSTED_HEAVY_MACE = ItemRegistryHelper.registerMedievalWeaponItem("rusted_heavymace", new Item.Properties(), ModItemTier.IRON, WeaponType.RUSTED_HEAVY_MACE);
	public static final RegistrySupplier<MedievalWeaponItem> CLUB = ItemRegistryHelper.registerMedievalWeaponItem("club", new Item.Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS), ModItemTier.WOOD, WeaponType.CLUB);
	public static final RegistrySupplier<MedievalWeaponItem> MESSER_SWORD = ItemRegistryHelper.registerMedievalWeaponItem("messer_sword", new Item.Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS), ModItemTier.IRON, WeaponType.MESSER_SWORD);

	public static final RegistrySupplier<BowItem> LONGBOW = ITEMS.register("longbow", () -> new MedievalBowItem(new Item.Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS).stacksTo(1).durability(420), 4.2f, 26.0f));
	public static final RegistrySupplier<CrossbowItem> HEAVY_CROSSBOW = ITEMS.register("heavy_crossbow", () -> new MedievalCrossbowItem(new Item.Properties().tab(ModCreativeTabs.PARTICULAR_WEAPONS).stacksTo(1).durability(500), 4.3f, 50));

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

	public static final RegistrySupplier<MedievalShieldItem> CORRUPTED_ROUND_SHIELD = ItemRegistryHelper.registerMedievalShieldItem("corruptedroundshield", "corruptedroundshield", new Item.Properties(), ModItemTier.WOOD, false, true, ShieldType.CORRUPTED_ROUND_SHIELD, Models.ShieldEnum.CORRUPTED_ROUND_SHIELD);

	//Patterns
	public static final RegistrySupplier<Item> APOSTOLIC_CROSS_PATTERN = ITEMS.register("apostolic_cross_pattern", () -> new HeraldryPatternItem(HeraldryPattern.APOSTOLIC_CROSS_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> BOWL_PATTERN = ITEMS.register("bowl_pattern", () -> new HeraldryPatternItem(HeraldryPattern.BOWL_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> BULL_PATTERN = ITEMS.register("bull_pattern", () -> new HeraldryPatternItem(HeraldryPattern.BULL_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> CHESS_PATTERN = ITEMS.register("chess_pattern", () -> new HeraldryPatternItem(HeraldryPattern.CHESS_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> CRUSADER_CROSS_PATTERN = ITEMS.register("crusader_cross_pattern", () -> new HeraldryPatternItem(HeraldryPattern.CRUSADER_CROSS_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> DRAGON_PATTERN = ITEMS.register("dragon_pattern", () -> new HeraldryPatternItem(HeraldryPattern.DRAGON_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> EAGLE_PATTERN = ITEMS.register("eagle_pattern", () -> new HeraldryPatternItem(HeraldryPattern.EAGLE_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> HORSE_PATTERN = ITEMS.register("horse_pattern", () -> new HeraldryPatternItem(HeraldryPattern.HORSE_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> LILY_PATTERN = ITEMS.register("lily_pattern", () -> new HeraldryPatternItem(HeraldryPattern.LILY_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> LION1_PATTERN = ITEMS.register("lion1_pattern", () -> new HeraldryPatternItem(HeraldryPattern.LION1_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> LION2_PATTERN = ITEMS.register("lion2_pattern", () -> new HeraldryPatternItem(HeraldryPattern.LION2_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> ORTHODOX_CROSS_PATTERN = ITEMS.register("orthodox_cross_pattern", () -> new HeraldryPatternItem(HeraldryPattern.ORTHODOX_CROSS_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> SNAKE_PATTERN = ITEMS.register("snake_pattern", () -> new HeraldryPatternItem(HeraldryPattern.SNAKE_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> SUN_PATTERN = ITEMS.register("sun_pattern", () -> new HeraldryPatternItem(HeraldryPattern.SUN_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> SWORDS_PATTERN = ITEMS.register("swords_pattern", () -> new HeraldryPatternItem(HeraldryPattern.SWORDS_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> TOWER_PATTERN = ITEMS.register("tower_pattern", () -> new HeraldryPatternItem(HeraldryPattern.TOWER_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> TREE_PATTERN = ITEMS.register("tree_pattern", () -> new HeraldryPatternItem(HeraldryPattern.TREE_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> TWOHEADED_EAGLE_PATTERN = ITEMS.register("two-headed_eagle_pattern", () -> new HeraldryPatternItem(HeraldryPattern.TWOHEADED_EAGLE_PATTERN, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

	//Materials
	public static final RegistrySupplier<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> STEEL_RING = ITEMS.register("steel_ring", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> STEEL_CHAINMAIL = ITEMS.register("steel_chainmail", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> STEEL_PLATE = ITEMS.register("steel_plate", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> LEATHER_STRIP = ITEMS.register("leather_strip", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> HILT = ITEMS.register("hilt", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> POLE = ITEMS.register("pole", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> STEEL_CHAIN = ITEMS.register("steel_chain", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> WOOLEN_FABRIC = ITEMS.register("woolen_fabric", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> SMALL_STEEL_PLATE = ITEMS.register("small_steel_plate", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistrySupplier<Item> LAMELLAR_ROWS = ITEMS.register("lamellar_rows", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	
	static
	{
		if (Platform.isFabric())
		{
			ITEMS.register("tin_ingot", () -> new Item(new Item.Properties()));
			ITEMS.register("silver_ingot", () -> new Item(new Item.Properties()));
			ITEMS.register("bronze_ingot", () -> new Item(new Item.Properties()));
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

		public ItemsSupply(BiFunction<ModItemTier, Item.Properties, RegistrySupplier<T>> workshop, Item.Properties prop)
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
		public WeaponsSupply(BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> workshop)
		{
			super(workshop, new Item.Properties().tab(ModCreativeTabs.WEAPONS));
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
			super(workshop, new Item.Properties().tab(ModCreativeTabs.SHIELDS));

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
					ResourceLocation location = new ResourceLocation(KnightlyArmory.ID, "entity/" + shieldName + "/" + filename);
					adder.accept(location);
				}
			}
		}
	}

	public static final ShieldsSupply[] shieldsSupply = new ShieldsSupply[] {HEATER_SHIELDS, TARGETS, BUCKLERS, RONDACHES, TARTSCHES, ELLIPTICAL_SHIELDS, ROUND_SHIELDS, PAVESES, KITE_SHIELDS};
	public static final WeaponsSupply[] weaponsSupply = new WeaponsSupply[] {STILETTOS, SHORT_SWORDS, KATZBALGERS, PIKES, RANSEURS, AHLSPIESSES, GIANT_LANCES, BASTARD_SWORDS, ESTOCS, CLAYMORS, ZWEIHANDERS, FLAME_BLADED_SWORDS, LOCHABER_AXES, CONCAVE_EDGED_HALBERDS, HEAVY_MACES, HEAVY_WAR_HAMMERS, LUCERNE_HAMMERS, MORNINGSTARS, FLAILS, GUISARMES};
	public static ArrayList<RegistrySupplier<? extends Item>> dyeableItems;
	static
	{
		dyeableItems = new ArrayList<>();
		dyeableItems.add(ARMET);
		dyeableItems.add(CRUSADER_CHESTPLATE);
		dyeableItems.add(CRUSADER_BOOTS);
		dyeableItems.add(CEREMONIAL_ARMET);
		dyeableItems.add(COIF);
		dyeableItems.add(GAMBESON);
		dyeableItems.add(PANTYHOSE);
		dyeableItems.add(GAMBESON_BOOTS);
		dyeableItems.add(BRIGANDINE);
		dyeableItems.add(CUIRASSIER_CHESTPLATE);
		dyeableItems.add(CUIRASSIER_LEGGINGS);
		dyeableItems.addAll(GIANT_LANCES.get());
	}

	public static ArrayList<RegistrySupplier<MedievalArmorItem>> armorItems;

	static {
		armorItems = new ArrayList<>();
		armorItems.add(ARMET);
		armorItems.add(KNIGHT_CHESTPLATE);
		armorItems.add(KNIGHT_LEGGINGS);
		armorItems.add(KNIGHT_BOOTS);
		armorItems.add(STECHHELM);
		armorItems.add(JOUSTING_CHESTPLATE);
		armorItems.add(JOUSTING_LEGGINGS);
		armorItems.add(JOUSTING_BOOTS);
		armorItems.add(SALLET);
		armorItems.add(GOTHIC_CHESTPLATE);
		armorItems.add(GOTHIC_LEGGINGS);
		armorItems.add(GOTHIC_BOOTS);
		armorItems.add(MAXIMILIAN_HELMET);
		armorItems.add(MAXIMILIAN_CHESTPLATE);
		armorItems.add(MAXIMILIAN_LEGGINGS);
		armorItems.add(MAXIMILIAN_BOOTS);
		armorItems.add(CHAINMAIL_HELMET);
		armorItems.add(CHAINMAIL_CHESTPLATE);
		armorItems.add(CHAINMAIL_LEGGINGS);
		armorItems.add(CHAINMAIL_BOOTS);
		armorItems.add(KETTLEHAT);
		armorItems.add(PLATEMAIL_CHESTPLATE);
		armorItems.add(PLATEMAIL_LEGGINGS);
		armorItems.add(PLATEMAIL_BOOTS);
		armorItems.add(BARBUTE);
		armorItems.add(HALFARMOR_CHESTPLATE);
		armorItems.add(GREATHELM);
		armorItems.add(CRUSADER_CHESTPLATE);
		armorItems.add(CRUSADER_LEGGINGS);
		armorItems.add(CRUSADER_BOOTS);
		armorItems.add(CEREMONIAL_ARMET);
		armorItems.add(CEREMONIAL_CHESTPLATE);
		armorItems.add(CEREMONIAL_BOOTS);
		armorItems.add(COIF);
		armorItems.add(GAMBESON);
		armorItems.add(PANTYHOSE);
		armorItems.add(GAMBESON_BOOTS);
		armorItems.add(BRIGANDINE);
		armorItems.add(NORMAN_HELMET);
		armorItems.add(SHISHAK);
		armorItems.add(RUSTED_BARBUTE);
		armorItems.add(RUSTED_HALFARMOR_CHESTPLATE);
		armorItems.add(RUSTED_GREATHELM);
		armorItems.add(RUSTED_CRUSADER_CHESTPLATE);
		armorItems.add(RUSTED_CRUSADER_BOOTS);
		armorItems.add(RUSTED_NORMAN_HELMET);
		armorItems.add(RUSTED_CHAINMAIL_HELMET);
		armorItems.add(RUSTED_CHAINMAIL_CHESTPLATE);
		armorItems.add(RUSTED_CHAINMAIL_LEGGINGS);
		armorItems.add(RUSTED_CHAINMAIL_BOOTS);
		armorItems.add(RUSTED_KETTLEHAT);
		armorItems.add(BASCINET);
		armorItems.add(XIV_CENTURY_KNIGHT_CHESTPLATE);
		armorItems.add(XIV_CENTURY_KNIGHT_LEGGINGS);
		armorItems.add(XIV_CENTURY_KNIGHT_BOOTS);
		armorItems.add(WINGED_HUSSAR_CHESTPLATE);
		armorItems.add(BURGONET);
		armorItems.add(CUIRASSIER_CHESTPLATE);
		armorItems.add(CUIRASSIER_LEGGINGS);
		armorItems.add(CUIRASSIER_BOOTS);
		armorItems.add(GRAND_BASCINET);
		armorItems.add(KASTENBRUST_CHESTPLATE);
		armorItems.add(KASTENBRUST_LEGGINGS);
		armorItems.add(KASTENBRUST_BOOTS);
		armorItems.add(FACE_HELMET);
		armorItems.add(LAMELLAR_CHESTPLATE);
		armorItems.add(LAMELLAR_BOOTS);
	}

	static class ShieldsWorkshop
	{
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalShieldItem>> HEATER_SHIELD = (material, prop) -> ItemRegistryHelper.registerMedievalShieldItem(material.getMaterialName() + "_heatershield", "heatershield", prop, material, true, true, ShieldType.HEATERSHIELD, Models.ShieldEnum.HEATER_SHIELD);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalShieldItem>> TARGET = (material, prop) -> ItemRegistryHelper.registerMedievalShieldItem(material.getMaterialName() + "_target", "target", prop, material, false, true, ShieldType.TARGET, Models.ShieldEnum.TARGET);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalShieldItem>> BUCKLER = (material, prop) -> ItemRegistryHelper.registerMedievalShieldItem(material.getMaterialName() + "_buckler", "buckler", prop, material, false, true, ShieldType.BUCKLER, Models.ShieldEnum.BUCKLER);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalShieldItem>> RONDACHE = (material, prop) -> ItemRegistryHelper.registerMedievalShieldItem(material.getMaterialName() + "_rondache", "rondache", prop, material, false, true, ShieldType.RONDACHE, Models.ShieldEnum.RONDACHE);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalShieldItem>> TARTSCHE = (material, prop) -> ItemRegistryHelper.registerMedievalShieldItem(material.getMaterialName() + "_tartsche", "tartsche", prop, material, true, true, ShieldType.TARTSCHE, Models.ShieldEnum.TARTSCHE);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalShieldItem>> ELLIPTICAL_SHIELD = (material, prop) -> ItemRegistryHelper.registerMedievalShieldItem(material.getMaterialName() + "_ellipticalshield", "ellipticalshield", prop, material, true, true, ShieldType.ELLIPTICALSHIELD, Models.ShieldEnum.ELLIPTICAL_SHIELD);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalShieldItem>> ROUND_SHIELD = (material, prop) -> ItemRegistryHelper.registerMedievalShieldItem(material.getMaterialName() + "_roundshield", "roundshield", prop, material, true, true, ShieldType.ROUNDSHIELD, Models.ShieldEnum.ROUND_SHIELD);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalShieldItem>> PAVESE = (material, prop) -> ItemRegistryHelper.registerMedievalShieldItem(material.getMaterialName() + "_pavese", "pavese", prop, material, true, true, ShieldType.PAVESE, Models.ShieldEnum.PAVESE);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalShieldItem>> KITE_SHIELD = (material, prop) -> ItemRegistryHelper.registerMedievalShieldItem(material.getMaterialName() + "_kiteshield", "kiteshield", prop, material, true, true, ShieldType.KITESHIELD, Models.ShieldEnum.KITE_SHIELD);
	}

	static class WeaponsWorkshop
	{
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> STILETTO = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_stylet", prop.durability(material.getUses()), material, WeaponType.STILETTO);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> SHORT_SWORD = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_shortsword", prop.durability(material.getUses()), material, WeaponType.SHORT_SWORD);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> KATZBALGER = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_katzbalger", prop.durability(material.getUses()), material, WeaponType.KATZBALGER);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> PIKE = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_pike", prop.durability(material.getUses()), material, WeaponType.PIKE);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> RANSEUR = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_ranseur", prop.durability(material.getUses()), material, WeaponType.RANSEUR);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> AHLSPIESS = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_ahlspiess", prop.durability(material.getUses()), material, WeaponType.AHLSPIESS);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> GIANT_LANCE = (material, prop) -> ItemRegistryHelper.registerLanceItem(material.getMaterialName() + "_chivalrylance", prop.durability(material.getUses()), material, WeaponType.GIANT_LANCE);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> BASTARD_SWORD = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_bastardsword", prop.durability(material.getUses()), material, WeaponType.BASTARD_SWORD);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> ESTOC = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_estoc", prop.durability(material.getUses()), material, WeaponType.ESTOC);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> CLAYMORE = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_claymore", prop.durability(material.getUses()), material, WeaponType.CLAYMORE);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> ZWEIHANDER = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_zweihander", prop.durability(material.getUses()), material, WeaponType.ZWEIHANDER);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> FlAME_BLADED_SWORD = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_flamebladedsword", prop.durability(material.getUses()), material, WeaponType.FlAME_BLADED_SWORD);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> LOCHABER_AXE = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_lochaberaxe", prop.durability(material.getUses()), material, WeaponType.LOCHABER_AXE);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> CONCAVE_EDGED_HALBERD = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_concavehalberd", prop.durability(material.getUses()), material, WeaponType.CONCAVE_EDGED_HALBERD);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> HEAVY_MACE = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_heavymace", prop.durability(material.getUses()), material, WeaponType.HEAVY_MACE);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> HEAVY_WAR_HAMMER = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_heavywarhammer", prop.durability(material.getUses()), material, WeaponType.HEAVY_WAR_HAMMER);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> LUCERNE_HAMMER = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_lucernhammer", prop.durability(material.getUses()), material, WeaponType.LUCERNE_HAMMER);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> MORNINGSTAR = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_morgenstern", prop.durability(material.getUses()), material, WeaponType.MORNINGSTAR);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> FLAIL = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_chainmorgenstern", prop.durability(material.getUses()), material, WeaponType.FLAIL);
		public static final BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> GUISARME = (material, prop) -> ItemRegistryHelper.registerMedievalWeaponItem(material.getMaterialName() + "_guisarme", prop.durability(material.getUses()), material, WeaponType.GUISARME);
	}

	public static void init()
	{
		ITEMS.register();
	}
}




