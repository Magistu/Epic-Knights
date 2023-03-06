package com.magistuarmory.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "mobs_equipment")
public class MobEquipmentConfig implements ConfigData
{
    @Comment("Specify mob IDs, dimensions and the items that mobs will have with some chance, all separated by a space")
    public String[] equipments = new String[]
    {
            "minecraft:zombie minecraft:overworld magistuarmory:rustedchainmail_helmet magistuarmory:rustednorman_helmet magistuarmory:rustedkettlehat magistuarmory:rustedbarbute magistuarmory:rustedgreathelm magistuarmory:rustedchainmail_chestplate magistuarmory:rustedcrusader_chestplate magistuarmory:rustedhalfarmor_chestplate magistuarmory:rustedchainmail_leggings magistuarmory:rustedchainmail_boots magistuarmory:rustedcrusader_boots magistuarmory:rusted_bastardsword magistuarmory:rusted_bastardsword magistuarmory:rusted_heavymace magistuarmory:corruptedroundshield",

            "minecraft:skeleton minecraft:overworld magistuarmory:rustedchainmail_helmet magistuarmory:rustednorman_helmet magistuarmory:rustedkettlehat magistuarmory:rustedbarbute magistuarmory:rustedgreathelm magistuarmory:rustedchainmail_chestplate magistuarmory:rustedcrusader_chestplate magistuarmory:rustedhalfarmor_chestplate magistuarmory:rustedchainmail_leggings magistuarmory:rustedchainmail_boots magistuarmory:corruptedroundshield magistuarmory:rustedcrusader_boots magistuarmory:rusted_bastardsword minecraft:bow",

            "minecraft:piglin_brute minecraft:zombified_piglin minecraft:golden_helmet minecraft:golden_chestplate minecraft:golden_leggings minecraft:golden_boots magistuarmory:brigandine_chestplate magistuarmory:gambeson_boots magistuarmory:gold_bastardsword magistuarmory:gold_guisarme magistuarmory:gold_shortsword magistuarmory:gold_lochaberaxe magistuarmory:gold_buckler magistuarmory:gold_target",

            "minecraft:wither_skeleton 0.3 magistuarmory:sallet magistuarmory:maximilian_helmet magistuarmory:gothic_chestplate magistuarmory:maximilian_chestplate magistuarmory:gothic_leggings magistuarmory:maximilian_leggings magistuarmory:gothic_boots magistuarmory:maximilian_helmet magistuarmory:steel_zweihander magistuarmory:steel_flamebladedsword magistuarmory:steel_lucernhammer" 
    };
}
