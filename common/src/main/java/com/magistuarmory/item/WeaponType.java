package com.magistuarmory.item;

import com.magistuarmory.EpicKnights;

public class WeaponType
{
    private final float baseAttackDamage;
    private final float baseAttackSpeed;
    private final float bonusAttackReach;
    private final float sizeFactor;
    private final float weight;
    private final int armorPiercing;
    private int twoHanded = 0;
    private float maxBlockDamage = 0;
    private boolean canBlock = false;
    private boolean isFlamebladed = false;
    private boolean isHalberd = false;
    private final boolean enabled;

    public WeaponType(float baseAttackDamage, float baseAttackSpeed, float bonusAttackReach, float sizeFactor, float weight, int armorPiercing, boolean enabled)
    {
        this.baseAttackDamage = baseAttackDamage;
        this.baseAttackSpeed = baseAttackSpeed;
        this.bonusAttackReach = bonusAttackReach;
        this.sizeFactor = sizeFactor;
        this.weight = weight;
        this.armorPiercing = armorPiercing;
        this.enabled = enabled;
    }

    public WeaponType setFlamebladed()
    {
        this.isFlamebladed = true;
        return this;
    }

    public WeaponType setTwoHanded(int level)
    {
        this.twoHanded = level;
        return this;
    }

    public WeaponType setMaxBlockDamage(float maxBlockDamage)
    {
        this.maxBlockDamage = maxBlockDamage;
        this.canBlock = true;
        return this;
    }

    public WeaponType setHalberd()
    {
        this.isHalberd = true;
        return this;
    }

    public float getAttackSpeed(ModItemTier material)
    {
        return -material.getDensity() * this.getSizeFactor() + this.getBaseAttackSpeed();
    }

    public float getBaseAttackDamage()
    {
        return this.baseAttackDamage;
    }

    public float getBaseAttackSpeed()
    {
        return this.baseAttackSpeed;
    }

    public float getSizeFactor()
    {
        return this.sizeFactor;
    }

    public float getWeight()
    {
        return this.weight;
    }

    public int getArmorPiercing()
    {
        return !EpicKnights.GENERAL_CONFIG.disableArmorPiercing ? this.armorPiercing : 0;
    }

    public float getBonusAttackReach()
    {
        return !EpicKnights.GENERAL_CONFIG.disableAttackReach ? this.bonusAttackReach : 0.0f;
    }

    public int getTwoHanded()
    {
        return !EpicKnights.GENERAL_CONFIG.disableTwoHanded ? this.twoHanded : 0;
    }

    public float getMaxBlockDamage()
    {
        return !EpicKnights.GENERAL_CONFIG.disableWeaponBlocking ? this.maxBlockDamage : 0.0f;
    }

    public boolean canBlock()
    {
        return !EpicKnights.GENERAL_CONFIG.disableWeaponBlocking && this.canBlock;
    }

    public boolean isFlamebladed()
    {
        return this.isFlamebladed;
    }

    public boolean isHalberd()
    {
        return this.isHalberd;
    }

    public boolean isDisabled()
    {
        return !this.enabled;
    }

    public int getDurability(ModItemTier material)
    {
        return (int) (material.getUses() * (1.0f + this.getSizeFactor() * 5.0f));
    }
}
