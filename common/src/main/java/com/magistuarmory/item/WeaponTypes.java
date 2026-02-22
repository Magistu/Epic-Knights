package com.magistuarmory.item;

import net.minecraftforge.common.ForgeConfigSpec;

public final class WeaponTypes
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec WEAPONS_CONFIG;

    public static final RangedWeaponType LONGBOW;
    public static final RangedWeaponType HEAVY_CROSSBOW;
    public static final WeaponType STILETTO;
    public static final WeaponType SHORT_SWORD;
    public static final WeaponType KATZBALGER;
    public static final WeaponType PIKE;
    public static final WeaponType RANSEUR;
    public static final WeaponType AHLSPIESS;
    public static final WeaponType GIANT_LANCE;
    public static final WeaponType BASTARD_SWORD;
    public static final WeaponType ESTOC;
    public static final WeaponType CLAYMORE;
    public static final WeaponType ZWEIHANDER;
    public static final WeaponType FLAME_BLADED_SWORD;
    public static final WeaponType LOCHABER_AXE;
    public static final WeaponType CONCAVE_EDGED_HALBERD;
    public static final WeaponType HEAVY_MACE;
    public static final WeaponType HEAVY_WAR_HAMMER;
    public static final WeaponType LUCERNE_HAMMER;
    public static final WeaponType MORNINGSTAR;
    public static final WeaponType FLAIL;
    public static final WeaponType GUISARME;
    public static final WeaponType BLACKSMITH_HAMMER;
    public static final WeaponType BARBED_CLUB;
    public static final WeaponType PITCHFORK;
    public static final WeaponType NOBLE_SWORD;
    public static final WeaponType RUSTED_BASTARD_SWORD;
    public static final WeaponType RUSTED_HEAVY_MACE;
    public static final WeaponType CLUB;
    public static final WeaponType MESSER_SWORD;

    static {
        LONGBOW = new RangedWeaponType(BUILDER, "longbow", 420, 36, 4.3, true);
        HEAVY_CROSSBOW = new RangedWeaponType(BUILDER, "heavyCrossbow", 500, 50, 4.3, true);
        STILETTO = new WeaponType(BUILDER, "stiletto", 2.00, 1.60, 0.00, 0.0, 0.6, 15, true);
        SHORT_SWORD = new WeaponType(BUILDER, "shortSword", 2.50, 1.70, 0.00, 0.0, 0.9, 0, true);
        KATZBALGER = new WeaponType(BUILDER, "katzbalger", 3.20, 1.65, 0.00, 0.0, 1.1, 0, true);
        PIKE = new WeaponType(BUILDER, "pike", 3.00, 1.17, 3.00, 0.0, 3.0, 0, true, 2, 0.0, false, false, false);
        RANSEUR = new WeaponType(BUILDER, "ranseur", 3.30, 1.17, 2.00, 0.0, 2.5, 0, true, 1, 3.0, true, false, false);
        AHLSPIESS = new WeaponType(BUILDER, "ahlspiess", 2.80, 1.28, 1.00, 0.02, 4.0, 12, true, 2, 3.0, true, false, false);
        GIANT_LANCE = new WeaponType(BUILDER, "giantLance", 2.50, 0.84, 2.00, 0.0, 4.5, 10, true);
        BASTARD_SWORD = new WeaponType(BUILDER, "bastardSword", 4.25, 1.40, 0.00, 0.02, 1.8, 0, true, 1, 5.0, true, false, false);
        ESTOC = new WeaponType(BUILDER, "estoc", 4.10, 1.40, 0.50, 0.02, 2.0, 3, true, 1, 5.0, true, false, false);
        CLAYMORE = new WeaponType(BUILDER, "claymore", 5.30, 1.22, 0.00, 0.1, 2.6, 0, true, 2, 6.0, true, false, false);
        ZWEIHANDER = new WeaponType(BUILDER, "zweihander", 6.00, 1.12, 0.50, 0.05, 4.0, 4, true, 2, 6.0, true, false, false);
        FLAME_BLADED_SWORD = new WeaponType(BUILDER, "flameBladedSword", 6.00, 1.12, 0.50, 0.05, 4.0, 4, true, 2, 6.0, true, true, false);
        LOCHABER_AXE = new WeaponType(BUILDER, "lochaberAxe", 7.00, 1.00, 0.90, 0.05, 3.5, 0, true, 1, 3.0, true, false, false);
        CONCAVE_EDGED_HALBERD = new WeaponType(BUILDER, "concaveEdgedHalberd", 7.30, 0.90, 1.00, 0.05, 4.1, 2, true, 2, 3.0, true, false, true);
        HEAVY_MACE = new WeaponType(BUILDER, "heavyMace", 4.80, 1.15, 0.00, 0.05, 2.6, 0, true);
        HEAVY_WAR_HAMMER = new WeaponType(BUILDER, "heavyWarHammer", 5.00, 1.05, 0.00, 0.05, 2.5, 15, true);
        LUCERNE_HAMMER = new WeaponType(BUILDER, "lucerneHammer", 4.40, 1.10, 0.70, 0.05, 2.5, 20, true, 1, 0.0, false, false, false);
        MORNINGSTAR = new WeaponType(BUILDER, "morningstar", 4.70, 1.25, 0.00, 0.05, 2.5, 0, true);
        FLAIL = new WeaponType(BUILDER, "flail", 6.20, 1.00, 0.00, 0.06, 3.0, 0, true);
        GUISARME = new WeaponType(BUILDER, "guisarme", 3.15, 1.12, 1.90, 0.0, 2.5, 0, true, 1, 3.3, true, false, false);
        BLACKSMITH_HAMMER = new WeaponType(BUILDER, "blacksmithHammer", 5.00, 1.00, 0.00, 0.05, 1.4, 4, true);
        BARBED_CLUB = new WeaponType(BUILDER, "barbedClub", 5.20, 1.00, 0.00, 0.0, 1.0, 0, true);
        PITCHFORK = new WeaponType(BUILDER, "pitchfork", 2.80, 1.10, 2.00, 0.05, 1.2, 0, true);
        NOBLE_SWORD = new WeaponType(BUILDER, "nobleSword", 4.25, 1.51, 0.00, 0.02, 2.7, 0, true, 1, 5.0, true, false, false);
        RUSTED_BASTARD_SWORD = new WeaponType(BUILDER, "rustedBastardSword", 2.00, 1.51, 0.00, 0.02, 2.7, 0, true, 1, 5.0, true, false, false);
        RUSTED_HEAVY_MACE = new WeaponType(BUILDER, "rustedHeavyMace", 2.00, 1.51, 0.00, 0.02, 2.6, 0, true);
        CLUB = new WeaponType(BUILDER, "club", 7.00, 0.80, 0.00, 0.0, 5.0, 0, true, 1, 0.0, false, false, false);
        MESSER_SWORD = new WeaponType(BUILDER, "messerSword", 3.40, 1.50, 0.00, 0.02, 1.2, 0, true, 0, 5.0, true, false, false);

        WEAPONS_CONFIG = BUILDER.build();
    }
}
