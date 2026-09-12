package com.magistuarmory.item;

import me.shedaniel.autoconfig.annotation.ConfigEntry;


public class ShieldType {

    @ConfigEntry.Gui.RequiresRestart
    private int baseDurability;
    @ConfigEntry.Gui.RequiresRestart
    private float materialFactor;
    @ConfigEntry.Gui.RequiresRestart
    private float weight;
    @ConfigEntry.Gui.RequiresRestart
    private float maxBlockDamage;
    @ConfigEntry.Gui.RequiresRestart
    private boolean repairable = false;
    @ConfigEntry.Gui.CollapsibleObject
    private boolean enabled = true;

    public ShieldType() {}

    public static ShieldType of(int baseDurability, float materialFactor, float weight, float maxBlockDamage, boolean enabled, boolean repairable) {
        ShieldType shield = new ShieldType();
        shield.baseDurability = baseDurability;
        shield.materialFactor = materialFactor;
        shield.weight = weight;
        shield.maxBlockDamage = maxBlockDamage;
        shield.enabled = enabled;
        shield.repairable = repairable;
        return shield;
    }

    public static ShieldType of(int baseDurability, float materialFactor, float weight, float maxBlockDamage) {
        return of(baseDurability, materialFactor, weight, maxBlockDamage, true, false);
    }

    // use ShieldType.of
    @Deprecated(forRemoval = true)
    public ShieldType(int baseDurability, float materialFactor, float weight, float maxBlockDamage, boolean enabled)
    {
        this.baseDurability = baseDurability;
        this.materialFactor = materialFactor;
        this.weight = weight;
        this.maxBlockDamage = maxBlockDamage;
        this.enabled = enabled;
    }

    // use ShieldType.of
    @Deprecated(forRemoval = true)
    public ShieldType setRepairable() {
        this.repairable = true;
        return this;
    }

    public int getDurability(ModItemTier material) {
        return (int) (this.baseDurability + this.materialFactor * material.getUses());
    }

    public int getBaseDurability() {
        return this.baseDurability;
    }

    public float getMaterialFactor() {
        return this.materialFactor;
    }

    public float getWeight() {
        return this.weight;
    }

    public float getMaxBlockDamage() {
        return this.maxBlockDamage;
    }

    public boolean isRepairable() {
        return this.repairable;
    }

    public boolean isDisabled() {
        return !this.enabled;
    }
}