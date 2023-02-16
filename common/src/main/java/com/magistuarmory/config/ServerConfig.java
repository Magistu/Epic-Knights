package com.magistuarmory.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "server")
public final class ServerConfig implements ConfigData
{
    @Comment("Works only in game with the difficulty set to hard. If true, monsters will be equipped with some armor and weapons of the mod. This is an boolean. Default value is true.")
    public boolean equipMonsters = true;
    
    @Comment("Works only if the game is set to the hard difficulty. Affects the chance that monsters will be equipped with some armor and weapons of the mod. This is an float. Default value is 0.5, Maximum value is 1.0.")
    public float equipChance = 0.5f;
    
    @Comment("Works only if the game is set to the hard difficulty. If false, equipment will not be overriden by equipping an armor. This is an float. Default value is false.")
    public boolean overrideEquipment = false;
    
    @Comment("If true, crafting recipes with the surcoat is available not only for the armor of this mod. Default value is true.")
    public boolean enableSurcoatRecipeForAllArmor = true;
    
    @Comment("If Epic Fight or Better Combat is installed, it will be used as true. If true, all the weapons have the same reach distance. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.")
    public boolean disableAttackReach = false;
    
    @Comment("If true, all the weapons don't penetrate armor. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.")
    public boolean disableArmorPiercing = false;
    
    @Comment("If true, all the weapons don't have any debuff as long as you hold something with both hands. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.")
    public boolean disableTwoHanded = false;
    
    @Comment("If true, you can't block with the weapons from the mod. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.")
    public boolean disableWeaponBlocking = false;
}
