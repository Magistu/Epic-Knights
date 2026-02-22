package com.magistuarmory.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public final class MobEquipmentConfig {

    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> EQUIPMENTS;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("mobs_equipment");

        EQUIPMENTS = builder
                .comment(
                        "Specify mob IDs, dimensions and the items that mobs will have with some chance,",
                        "All values must be separated by spaces.",
                        "Format examples:",
                        "  <mob_id> <dimension> <item_1> <item_2> ...",
                        "  <mob_id> <chance> <item_1> <item_2> ..."
                )
                .defineList(
                        "equipments",
                        List.of(
                                "minecraft:zombie minecraft:overworld magistuarmory:rustedchainmail_helmet magistuarmory:rustednorman_helmet magistuarmory:rustedkettlehat magistuarmory:rustedbarbute magistuarmory:rustedgreathelm magistuarmory:rustedchainmail_chestplate magistuarmory:rustedcrusader_chestplate magistuarmory:rustedhalfarmor_chestplate magistuarmory:rustedchainmail_leggings magistuarmory:rustedchainmail_boots magistuarmory:rustedcrusader_boots magistuarmory:rusted_bastardsword magistuarmory:rusted_bastardsword magistuarmory:rusted_heavymace magistuarmory:corruptedroundshield",
                                "minecraft:skeleton minecraft:overworld magistuarmory:rustedchainmail_helmet magistuarmory:rustednorman_helmet magistuarmory:rustedkettlehat magistuarmory:rustedbarbute magistuarmory:rustedgreathelm magistuarmory:rustedchainmail_chestplate magistuarmory:rustedcrusader_chestplate magistuarmory:rustedhalfarmor_chestplate magistuarmory:rustedchainmail_leggings magistuarmory:rustedchainmail_boots magistuarmory:corruptedroundshield magistuarmory:rustedcrusader_boots magistuarmory:rusted_bastardsword minecraft:bow",
                                "minecraft:piglin_brute minecraft:zombified_piglin minecraft:golden_helmet minecraft:golden_chestplate minecraft:golden_leggings minecraft:golden_boots magistuarmory:brigandine_chestplate magistuarmory:gambeson_boots magistuarmory:gold_bastardsword magistuarmory:gold_guisarme magistuarmory:gold_shortsword magistuarmory:gold_lochaberaxe magistuarmory:gold_buckler magistuarmory:gold_target",
                                "minecraft:wither_skeleton 0.3 magistuarmory:sallet magistuarmory:maximilian_helmet magistuarmory:gothic_chestplate magistuarmory:maximilian_chestplate magistuarmory:gothic_leggings magistuarmory:maximilian_leggings magistuarmory:gothic_boots magistuarmory:maximilian_helmet magistuarmory:steel_zweihander magistuarmory:steel_flamebladedsword magistuarmory:steel_lucernhammer"
                        ),
                        o -> o instanceof String
                );

        builder.pop();

        SPEC = builder.build();
    }
}