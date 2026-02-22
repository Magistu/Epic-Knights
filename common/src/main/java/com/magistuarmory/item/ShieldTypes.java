package com.magistuarmory.item;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ShieldTypes {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SHIELDS_CONFIG;

    public static final ShieldType HEATER_SHIELD;
    public static final ShieldType TARGET;
    public static final ShieldType BUCKLER;
    public static final ShieldType RONDACHE;
    public static final ShieldType TARTSCHE;
    public static final ShieldType ELLIPTICAL_SHIELD;
    public static final ShieldType ROUND_SHIELD;
    public static final ShieldType PAVISE;
    public static final ShieldType KITE_SHIELD;
    public static final ShieldType CORRUPTED_ROUND_SHIELD;

    static {
        HEATER_SHIELD = new ShieldType(BUILDER, "heaterShield", 350, 0.8f, 4, 10, true, false);
        TARGET = new ShieldType(BUILDER, "target", 350, 0.8f, 1, 6, true, false);
        BUCKLER = new ShieldType(BUILDER, "buckler", 350, 0.8f, 1, 6, true, false);
        RONDACHE = new ShieldType(BUILDER, "rondache", 420, 1.2f, 6, 13, true, false);
        TARTSCHE = new ShieldType(BUILDER, "tartsche", 350, 0.8f, 4, 10, true, false);
        ELLIPTICAL_SHIELD = new ShieldType(BUILDER, "ellipticalShield", 370, 0.8f, 5, 10, true, false);
        ROUND_SHIELD = new ShieldType(BUILDER, "roundShield", 350, 0.8f, 3, 7, true, false);
        PAVISE = new ShieldType(BUILDER, "pavise", 450, 0.7f, 10, 17, true, false);
        KITE_SHIELD = new ShieldType(BUILDER, "kiteShield", 370, 0.8f, 5, 10, true, false);
        CORRUPTED_ROUND_SHIELD = new ShieldType(BUILDER, "corruptedRoundShield", 100, 0.8f, 2, 4, true, false);

        SHIELDS_CONFIG = BUILDER.build();
    }
}
