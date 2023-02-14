package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;

public class WeaponType
{
    public static final WeaponType STILETTO = new WeaponType(2.0f, 1.6f, 0.0f, 15, 0.0f, 0.6f);
    public static final WeaponType SHORT_SWORD = new WeaponType(2.5f, 1.7f, 0.0f, 0.9f);
    public static final WeaponType KATZBALGER = new WeaponType(3.0f, 1.65f, 0.0f, 1.1f);
    public static final WeaponType PIKE = new WeaponType(3.0f, 1.07f, 0.0f, 0, 3.0f, 3.0f).setTwoHanded(2);
    public static final WeaponType RANSEUR = new WeaponType(3.1f, 1.07f, 0.0f, 0, 2.0f, 2.5f).setTwoHanded(1).setMaxBlockDamage(3.0f);
    public static final WeaponType AHLSPIESS = new WeaponType(4.0f, 1.28f, 0.02f, 12, 1.2f, 4.0f).setTwoHanded(2).setMaxBlockDamage(3.0f);
    public static final WeaponType GIANT_LANCE = new WeaponType(2.5f, 0.84f, 0.0f, 10, 2.0f, 4.5f);
    public static final WeaponType BASTARD_SWORD = new WeaponType(4.25f, 1.4f, 0.1f, 1.8f).setTwoHanded(1).setMaxBlockDamage(5.0f);
    public static final WeaponType ESTOC = new WeaponType(4.1f, 1.4f, 0.02f, 3, 0.5f, 2.0f).setTwoHanded(1).setMaxBlockDamage(5.0f);
    public static final WeaponType CLAYMORE = new WeaponType(5.4f, 1.22f, 0.1f, 2.6f).setTwoHanded(2).setMaxBlockDamage(6.0f);
    public static final WeaponType ZWEIHANDER = new WeaponType(6.5f, 1.12f, 0.05f, 4, 0.5f, 4.0f).setTwoHanded(2).setMaxBlockDamage(6.0f);
    public static final WeaponType FlAME_BLADED_SWORD = new WeaponType(6.4f, 1.12f, 0.05f, 4, 0.5f, 4.0f).setTwoHanded(2).setFlamebladed().setMaxBlockDamage(6.0f);
    public static final WeaponType LOCHABER_AXE = new WeaponType(7.0f, 1.0f, 0.05f, 0, 1.0f, 3.5f).setTwoHanded(1).setMaxBlockDamage(3.0f);
    public static final WeaponType CONCAVE_EDGED_HALBERD = new WeaponType(8.0f, 0.9f, 0.05f, 2, 2.0f, 4.1f).setTwoHanded(2).setMaxBlockDamage(3.0f).setHalberd();
    public static final WeaponType HEAVY_MACE = new WeaponType(4.5f, 1.15f, 0.05f, 11, 0.0f, 2.6f);
    public static final WeaponType HEAVY_WAR_HAMMER = new WeaponType(5.2f, 1.05f, 0.05f, 15, 0.0f, 2.5f);
    public static final WeaponType LUCERNE_HAMMER = new WeaponType(4.8f, 1.1f, 0.05f, 20, 0.0f, 2.5f).setTwoHanded(1);
    public static final WeaponType MORNINGSTAR = new WeaponType(5.0f, 1.25f, 0.05f, 2.5f);
    public static final WeaponType FLAIL = new WeaponType(6.2f, 1.1f, 0.06f, 3.0f);
    public static final WeaponType GUISARME = new WeaponType(3.15f, 1.02f, 0.0f, 0, 1.9f, 2.5f).setTwoHanded(1).setMaxBlockDamage(3.3f);
    
    public static final WeaponType BLACKSMITH_HAMMER = new WeaponType(5.0f, 1.0f, 0.05f, 4, 0.0f, 1.4f);
    public static final WeaponType BARBED_CLUB = new WeaponType(5.6f, 1.0f, 0.0f, 1.0f);
    public static final WeaponType PITCHFORK = new WeaponType(2.8f, 1.0f, 0.05f, 0, 1.0f, 1.2f);
    public static final WeaponType NOBLE_SWORD = new WeaponType(4.25f, 1.51f, 0.02f, 2.7f).setTwoHanded(1).setMaxBlockDamage(6.0f);
    public static final WeaponType RUSTED_BASTARD_SWORD = new WeaponType(2.0F, 1.51F, 0.02f, 2.7f).setTwoHanded(1).setMaxBlockDamage(6.0f);
    public static final WeaponType RUSTED_HEAVY_MACE = new WeaponType(2.0F, 1.51F, 0.02f, 2.6f);
    public static final WeaponType CLUB = new WeaponType(11.3F, 0.8f, 0.0f, 5.0f).setTwoHanded(1);
    public static final WeaponType MESSER_SWORD = new WeaponType(3.8f, 1.56f, 0.02f, 1.2f).setMaxBlockDamage(5.0f);
    
    public final float baseAttackDamage;
    public final float baseAttackSpeed;
    public final float sizeFactor;
    public final float weight;
    public int armorPiercing = 0;
    public float bonusReachDistance = 0.0f;
    public int twoHanded = 0;
    public float maxBlockDamage = 0.0f;
    public boolean canBlock = false;
    public boolean isFlamebladed = false;
    public boolean isHalberd = false;

    public WeaponType(float baseAttackDamage, float baseAttackSpeed, float sizeFactor, int armorPiercing, float reachDistance, float weight)
    {
        this(baseAttackDamage, baseAttackSpeed, sizeFactor, weight);
        if (!KnightlyArmory.CONFIG.disableArmorPiercing)
            this.armorPiercing = armorPiercing;
        if (!KnightlyArmory.CONFIG.disableReachDistance)
            this.bonusReachDistance = reachDistance;
    }
    
    public WeaponType(float baseAttackDamage, float baseAttackSpeed, float sizeFactor, float weight)
    {
        this.baseAttackDamage = baseAttackDamage;
        this.baseAttackSpeed = baseAttackSpeed;
        this.sizeFactor = sizeFactor;
        this.weight = weight;
    }

    public WeaponType setFlamebladed()
    {
        this.isFlamebladed = true;
        return this;
    }

    public WeaponType setTwoHanded(int level)
    {
        if (KnightlyArmory.CONFIG.disableTwoHanded)
            return this;
        this.twoHanded = level;
        return this;
    }

    public WeaponType setMaxBlockDamage(float maxBlockDamage)
    {
        if (KnightlyArmory.CONFIG.disableWeaponBlocking)
            return this;
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
        return -material.getDensity() * this.sizeFactor + this.baseAttackSpeed;
    }
}
