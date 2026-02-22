package com.magistuarmory.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class GeneralConfig {

    public static final ForgeConfigSpec GENERAL_CONFIG;

    public static final ForgeConfigSpec.BooleanValue EQUIP_MONSTERS;
    public static final ForgeConfigSpec.BooleanValue EQUIP_MONSTERS_ONLY_IF_HARD;
    public static final ForgeConfigSpec.DoubleValue EQUIP_CHANCE;
    public static final ForgeConfigSpec.BooleanValue OVERRIDE_EQUIPMENT;
    public static final ForgeConfigSpec.BooleanValue ENABLE_SURCOAT_RECIPE_FOR_ALL_ARMOR;
    public static final ForgeConfigSpec.BooleanValue DISABLE_ATTACK_REACH;
    public static final ForgeConfigSpec.BooleanValue DISABLE_LANCE_COLLISION;
    public static final ForgeConfigSpec.BooleanValue DISABLE_ARMOR_PIERCING;
    public static final ForgeConfigSpec.BooleanValue DISABLE_LACERATION;
    public static final ForgeConfigSpec.BooleanValue DISABLE_TWO_HANDED;
    public static final ForgeConfigSpec.BooleanValue DISABLE_WEAPON_BLOCKING;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("general");

        EQUIP_MONSTERS = builder
                .comment("If true, monsters will be equipped with some armor and weapons of the mod.")
                .define("equipMonsters", true);

        EQUIP_MONSTERS_ONLY_IF_HARD = builder
                .comment("If true, monsters will be equipped only if game difficulty is HARD.")
                .define("equipMonstersOnlyIfHard", true);

        EQUIP_CHANCE = builder
                .comment(
                        "Affects the chance that monsters will be equipped.",
                        "Range: 0.0 ~ 1.0"
                )
                .defineInRange("equipChance", 0.5D, 0.0D, 1.0D);

        OVERRIDE_EQUIPMENT = builder
                .comment("If false, existing equipment will not be overridden.")
                .define("overrideEquipment", false);

        ENABLE_SURCOAT_RECIPE_FOR_ALL_ARMOR = builder
                .comment("If true, surcoat recipes apply to armor from other mods.")
                .define("enableSurcoatRecipeForAllArmor", true);

        DISABLE_ATTACK_REACH = builder
                .comment(
                        "If true, all weapons have the same reach distance.",
                        "Recommended when using combat mods."
                )
                .define("disableAttackReach", false);

        DISABLE_LANCE_COLLISION = builder
                .comment(
                        "If true, lances will not collide with mobs while riding.",
                        "Recommended when using combat mods."
                )
                .define("disableLanceCollision", false);

        DISABLE_ARMOR_PIERCING = builder
                .comment(
                        "If true, weapons will not penetrate armor.",
                        "Recommended when using combat mods."
                )
                .define("disableArmorPiercing", false);

        DISABLE_LACERATION = builder
                .comment("If true, flame-bladed swords will not apply laceration.")
                .define("disableLaceration", false);

        DISABLE_TWO_HANDED = builder
                .comment(
                        "If true, two-handed weapon debuffs are disabled.",
                        "Recommended when using combat mods."
                )
                .define("disableTwoHanded", false);

        DISABLE_WEAPON_BLOCKING = builder
                .comment(
                        "If true, weapons from the mod cannot be used to block.",
                        "Recommended when using combat mods."
                )
                .define("disableWeaponBlocking", false);

        builder.pop();

        GENERAL_CONFIG = builder.build();
    }
}