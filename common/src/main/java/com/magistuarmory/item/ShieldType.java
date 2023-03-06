package com.magistuarmory.item;

import net.minecraft.world.item.Tier;

public final class ShieldType
{
    private final int baseDurability;
    private final float materialFactor;
    private final float weight;
    private final float maxBlockDamage;
    private boolean repairable = false;
    public final boolean enabled;

    public ShieldType(int baseDurability, float materialFactor, float weight, float maxBlockDamage, boolean enabled)
    {
        this.baseDurability = baseDurability;
        this.materialFactor = materialFactor;
        this.weight = weight;
        this.maxBlockDamage = maxBlockDamage;
        this.enabled = enabled;
    }
    
    public ShieldType setRepairable()
    {
        this.repairable = true;
        return this;
    }

    public int getDurability(Tier material)
    {
        return (int) (this.baseDurability + this.materialFactor * material.getUses());
    }

    public int getBaseDurability()
    {
        return this.baseDurability;
    }

    public float getMaterialFactor()
    {
        return this.materialFactor;
    }

    public float getWeight()
    {
        return this.weight;
    }

    public float getMaxBlockDamage()
    {
        return this.maxBlockDamage;
    }

    public boolean isRepairable()
    {
        return this.repairable;
    }

    public boolean isDisabled()
    {
        return !this.enabled;
    }
}
