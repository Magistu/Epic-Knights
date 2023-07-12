// 
// Decompiled by Procyon v0.5.36
// 

package com.magistuarmory.config;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.ConfigData;

@Config(name = "general")
public final class GeneralConfig implements ConfigData
{
    @Comment("If true, monsters will be equipped with some armor and weapons of the mod. This is an boolean. Default value is true.")
    public boolean equipMonsters;
    @Comment("If true, monsters will be equipped with some armor and weapons only if game the game difficulty set to hard. This is an boolean. Default value is true.")
    public boolean equipMonstersOnlyIfHard;
    @Comment("Affects the chance that monsters will be equipped by default. This is an float. Default value is 0.5, Maximum value is 1.0.")
    public float equipChance;
    @Comment("If false, equipment will not be overriden. This is an float. Default value is false.")
    public boolean overrideEquipment;
    @Comment("If true, crafting recipes with the surcoat is available not only for the armor of this mod. Default value is true.")
    public boolean enableSurcoatRecipeForAllArmor;
    @Comment("If Epic Fight or Better Combat is installed, it will be used as true. If true, all the weapons have the same reach distance. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.")
    public boolean disableAttackReach;
    @Comment("If true, lance will not collide with mobs when you're riding a horse. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.")
    public boolean disableLanceCollision;
    @Comment("If true, all the weapons don't penetrate armor. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.")
    public boolean disableArmorPiercing;
    @Comment("If true, all the weapons don't have any debuff as long as you hold something with both hands. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.")
    public boolean disableTwoHanded;
    @Comment("If true, you can't block with the weapons from the mod. It's recommended to set to true to avoid conflicts with some combat mods. Default value is false.")
    public boolean disableWeaponBlocking;
    
    public GeneralConfig() {
        this.equipMonsters = true;
        this.equipMonstersOnlyIfHard = true;
        this.equipChance = 0.5f;
        this.overrideEquipment = false;
        this.enableSurcoatRecipeForAllArmor = true;
        this.disableAttackReach = false;
        this.disableLanceCollision = false;
        this.disableArmorPiercing = false;
        this.disableTwoHanded = false;
        this.disableWeaponBlocking = false;
    }
}
