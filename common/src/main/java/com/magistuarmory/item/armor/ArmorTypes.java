package com.magistuarmory.item.armor;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.config.ArmorConfig;
import dev.architectury.platform.Platform;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public final class ArmorTypes
{
	public static final ArmorConfig ARMOR_CONFIG = EpicKnights.CONFIG.armor;

	public static final ArmorType KNIGHT = new ArmorType("knight", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableKnightArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
	public static final ArmorType ARMET = new ArmorType("armet", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableKnightArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType STECHHELM = new ArmorType("stechhelm", 2.0f, 1.5f, new int[] { 345, 500, 440, 385 }, new int[] { 3, 6, 9, 4 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableJoustingArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
	public static final ArmorType JOUSTING = new ArmorType("jousting", 2.0f, 1.5f, new int[] { 345, 500, 440, 385 }, new int[] { 3, 6, 9, 4 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableJoustingArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType SALLET = new ArmorType("sallet", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableGothicArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
	public static final ArmorType GOTHIC = new ArmorType("gothic", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableGothicArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType MAXIMILIAN_HELMET = new ArmorType("maximilian_helmet", 1.8f, 0.5f, new int[] { 345, 500, 440, 385 }, new int[] { 3, 6, 9, 4 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableMaximilianArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
	public static final ArmorType MAXIMILIAN = new ArmorType("maximilian", 1.8f, 0.5f, new int[] { 345, 500, 440, 385 }, new int[] { 3, 6, 9, 4 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableMaximilianArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType CHAINMAIL = new ArmorType("chainmail", 0.0f, 0.0f, new int[] { 170, 235, 250, 205 }, new int[] { 1, 4, 5, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, ARMOR_CONFIG.enableChainmailArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType KETTLEHAT = new ArmorType("kettlehat", 0.3f, 0.0f, new int[] { 200, 270, 200, 240 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, ARMOR_CONFIG.enablePlatemailArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
	public static final ArmorType PLATEMAIL = new ArmorType("platemail", 0.3f, 0.0f, new int[] { 200, 270, 200, 240 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, ARMOR_CONFIG.enablePlatemailArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType BARBUTE = new ArmorType("barbute", 0.5f, 0.0f, new int[] { 180, 290, 315, 170 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableHalfarmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
	public static final ArmorType HALFARMOR = new ArmorType("halfarmor", 0.5f, 0.0f, new int[] { 180, 290, 315, 170 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableHalfarmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType CRUSADER = new ArmorType("crusader", 0.6f, 0.0f, new int[] { 150, 280, 295, 220 }, new int[] { 1, 5, 6, 3 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, ARMOR_CONFIG.enableCrusaderArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType BRIGANDINE = new ArmorType("brigandine", 0.25f, 0.0f, new int[] { 100, 200, 265, 170 }, new int[] { 2, 3, 5, 2 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, ARMOR_CONFIG.enableBrigandineArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType GAMBESON = new ArmorType("gambeson", 0.0f, 0.0f, new int[] { 100, 0, 128, 88 }, new int[] { 1, 0, 2, 1 }, 9, SoundEvents.ARMOR_EQUIP_LEATHER, ARMOR_CONFIG.enableGambesonArmor, () -> Ingredient.of(() -> Registry.ITEM.getOptional(new ResourceLocation(EpicKnights.ID, "woolen_fabric")).orElse(Items.BARRIER)));

	public static final ArmorType CEREMONIAL_ARMET = new ArmorType("ceremonialarmet", 1.25f, 0.0f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableCeremonialArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
	public static final ArmorType CEREMONIAL = new ArmorType("ceremonial", 1.25f, 0.0f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableCeremonialArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType SHISHAK = new ArmorType("shishak", 0.3f, 0.0f, new int[] { 200, 270, 200, 210 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableShishak, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType NORMAN = new ArmorType("norman", 0.2f, 0.0f, new int[] { 200, 270, 200, 190 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableNormanHelmet, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType RUSTED_BARBUTE = new ArmorType("rustedbarbute", 0.0f, 0.0f, new int[] { 100, 160, 170, 90 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableRustedHalfarmorArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
	public static final ArmorType RUSTED_HALFARMOR = new ArmorType("rustedhalfarmor", 0.0f, 0.0f, new int[] { 100, 160, 170, 90 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableRustedHalfarmorArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType RUSTED_CHAINMAIL = new ArmorType("rustedchainmail", 0.0f, 0.0f, new int[] { 85, 115, 125, 100 }, new int[] { 1, 4, 5, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, ARMOR_CONFIG.enableRustedChainmailArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType RUSTED_KETTLEHAT = new ArmorType("rustedkettlehat", 0.0f, 0.0f, new int[] { 50, 185, 100, 120 }, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, ARMOR_CONFIG.enableRustedKettlehat, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType RUSTED_NORMAN = new ArmorType("rustednorman", 0.0f, 0.0f, new int[] { 100, 185, 100, 85 }, new int[] { 1, 4, 5, 2 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, ARMOR_CONFIG.enableRustedNormanHelmet, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType RUSTED_CRUSADER = new ArmorType("rustedcrusader", 0.0f, 0.0f, new int[] { 75, 140, 150, 110 }, new int[] { 1, 5, 6, 3 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, ARMOR_CONFIG.enableRustedCrusaderArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType BASCINET = new ArmorType("bascinet", 1.25f, 0.0f, new int[] { 210, 300, 320, 250 }, new int[] { 2, 5, 7, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableXIVCenturyKnightArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
	public static final ArmorType XIV_CENTURY_KNIGHT = new ArmorType("xivcenturyknight", 1.25f, 0.0f, new int[] { 210, 300, 320, 250 }, new int[] { 2, 5, 7, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableXIVCenturyKnightArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType WINGED_HUSSAR_CHESTPLATE = new ArmorType("wingedhussarchestplate", 1.0f, 0.0f, new int[] { 150, 0, 360, 170 }, new int[] { 1, 0, 7, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableWingedHussarArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType CUIRASSIER = new ArmorType("cuirassier", 0.5f, 0.0f, new int[] { 150, 0, 315, 170 }, new int[] { 1, 0, 6, 2 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableCuirassierArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType KASTENBRUST = new ArmorType("kastenbrust", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableKastenbrustArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
	public static final ArmorType GRAND_BASCINET = new ArmorType("grand_bascinet", 1.25f, 0.5f, new int[] { 230, 315, 335, 275 }, new int[] { 2, 5, 8, 3 }, 9, SoundEvents.ARMOR_EQUIP_IRON, ARMOR_CONFIG.enableKastenbrustArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");

	public static final ArmorType LAMELLAR = new ArmorType("lamellar", 0.3f, 0.0f, new int[] { 200, 270, 200, 240 }, new int[] { 2, 5, 6, 3 }, 9, SoundEvents.ARMOR_EQUIP_CHAIN, ARMOR_CONFIG.enableLamellarArmor, Platform.isForge() ? "forge:ingots/steel" : "c:steel_ingots");
}
