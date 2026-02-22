package com.magistuarmory.item;

import com.magistuarmory.EpicKnights;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class WeaponType {
    @ConfigEntry.Gui.RequiresRestart
    private float baseAttackDamage;
    @ConfigEntry.Gui.RequiresRestart
    private float baseAttackSpeed;
    @ConfigEntry.Gui.RequiresRestart
    private float bonusAttackReach;
    @ConfigEntry.Gui.RequiresRestart
    private float sizeFactor;
    @ConfigEntry.Gui.RequiresRestart
    private float weight;
    @ConfigEntry.Gui.RequiresRestart
    private int armorPiercing;
    @ConfigEntry.Gui.RequiresRestart
    private int twoHanded;
    @ConfigEntry.Gui.RequiresRestart
    private float maxBlockDamage;
    @ConfigEntry.Gui.RequiresRestart
    private boolean canBlock;
    @ConfigEntry.Gui.RequiresRestart
    private boolean isFlamebladed;
    @ConfigEntry.Gui.RequiresRestart
    private boolean isHalberd;
    @ConfigEntry.Gui.CollapsibleObject
    private boolean enabled;

    public WeaponType() {}

    public static WeaponType of(float baseAttackDamage, float baseAttackSpeed, float bonusAttackReach, float sizeFactor, float weight, int armorPiercing, boolean enabled, int twoHanded, float maxBlockDamage, boolean canBlock, boolean isFlamebladed, boolean isHalberd) {
        WeaponType type = new WeaponType();
        type.baseAttackDamage = baseAttackDamage;
        type.baseAttackSpeed = baseAttackSpeed;
        type.bonusAttackReach = bonusAttackReach;
        type.sizeFactor = sizeFactor;
        type.weight = weight;
        type.armorPiercing = armorPiercing;
        type.enabled = enabled;
        type.twoHanded = twoHanded;
        type.maxBlockDamage = maxBlockDamage;
        type.canBlock = canBlock;
        type.isFlamebladed = isFlamebladed;
        type.isHalberd = isHalberd;
        return type;
    }

    public static WeaponType of(float baseAttackDamage, float baseAttackSpeed, float bonusAttackReach, float sizeFactor, float weight, int armorPiercing, boolean enabled) {
        return of(baseAttackDamage, baseAttackSpeed, bonusAttackReach, sizeFactor, weight, armorPiercing, enabled, 0, 0.0f, false, false, false);
    }

    // use WeaponType.of
    @Deprecated(forRemoval = true)
    public WeaponType(float baseAttackDamage, float baseAttackSpeed, float bonusAttackReach, float sizeFactor, float weight, int armorPiercing, boolean enabled) {
        this.baseAttackDamage = baseAttackDamage;
        this.baseAttackSpeed = baseAttackSpeed;
        this.bonusAttackReach = bonusAttackReach;
        this.sizeFactor = sizeFactor;
        this.weight = weight;
        this.armorPiercing = armorPiercing;
        this.enabled = enabled;
        this.twoHanded = 0;
        this.maxBlockDamage = 0;
        this.canBlock = false;
        this.isFlamebladed = false;
        this.isHalberd = false;
    }

    // use WeaponType.of
    @Deprecated(forRemoval = true)
    public WeaponType setFlamebladed() {
        this.isFlamebladed = true;
        return this;
    }

    // use WeaponType.of
    @Deprecated(forRemoval = true)
    public WeaponType setTwoHanded(int level) {
        this.twoHanded = level;
        return this;
    }

    // use WeaponType.of
    @Deprecated(forRemoval = true)
    public WeaponType setMaxBlockDamage(float maxBlockDamage) {
        this.maxBlockDamage = maxBlockDamage;
        this.canBlock = true;
        return this;
    }

    // use WeaponType.of
    @Deprecated(forRemoval = true)
    public WeaponType setHalberd() {
        this.isHalberd = true;
        return this;
    }

    public float getAttackSpeed(ModItemTier material) {
        return -material.getDensity() * this.getSizeFactor() + this.getBaseAttackSpeed();
    }

    public float getBaseAttackDamage() {
        return this.baseAttackDamage;
    }

    public float getBaseAttackSpeed() {
        return this.baseAttackSpeed;
    }

    public float getSizeFactor() {
        return this.sizeFactor;
    }

    public float getWeight() {
        return this.weight;
    }

    public int getArmorPiercing() {
        return !EpicKnights.GENERAL_CONFIG.disableArmorPiercing ? this.armorPiercing : 0;
    }

    public float getBonusAttackReach() {
        return !EpicKnights.GENERAL_CONFIG.disableAttackReach ? this.bonusAttackReach : 0.0f;
    }

    public int getTwoHanded() {
        return !EpicKnights.GENERAL_CONFIG.disableTwoHanded ? this.twoHanded : 0;
    }

    public float getMaxBlockDamage() {
        return !EpicKnights.GENERAL_CONFIG.disableWeaponBlocking ? this.maxBlockDamage : 0.0f;
    }

    public boolean canBlock() {
        return !EpicKnights.GENERAL_CONFIG.disableWeaponBlocking && this.canBlock;
    }

    public boolean isFlamebladed() {
        return !EpicKnights.GENERAL_CONFIG.disableLaceration && this.isFlamebladed;
    }

    public boolean isHalberd() {
        return this.isHalberd;
    }

    public boolean isDisabled() {
        return !this.enabled;
    }

    public int getDurability(ModItemTier material) {
        return (int) (material.getUses() * (1.0f + this.getSizeFactor() * 5.0f));
    }
}
