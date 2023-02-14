package com.magistuarmory.item;

import net.minecraft.world.item.Tier;

public class ShieldType
{
    public static final ShieldType HEATERSHIELD = new ShieldType(350, 0.8f, 4, 10);
    public static final ShieldType TARGET = new ShieldType(350, 0.8f, 1, 6).setRepairable();
    public static final ShieldType BUCKLER = new ShieldType(350, 0.8f, 1, 6).setRepairable();
    public static final ShieldType RONDACHE = new ShieldType(420, 1.2f, 6, 13).setRepairable();
    public static final ShieldType TARTSCHE = new ShieldType(350, 0.8f, 4, 10);
    public static final ShieldType ELLIPTICALSHIELD = new ShieldType(370, 0.8f, 5, 10);
    public static final ShieldType ROUNDSHIELD = new ShieldType(350, 0.8f, 3, 7);
    public static final ShieldType PAVESE = new ShieldType(450, 0.7f, 10, 17);
    public static final ShieldType KITESHIELD = new ShieldType(370, 0.8f, 5, 10);

    public static final ShieldType CORRUPTED_ROUND_SHIELD = new ShieldType(100, 0.8f, 2, 4);
    
    public final int baseDurability;
    public final float materialFactor;
    public final float weigth;
    public final float maxBlockDamage;
    public boolean repairable = false;

    public ShieldType(int baseDurability, float materialFactor, float weigth, float maxBlockDamage)
    {
        this.baseDurability = baseDurability;
        this.materialFactor = materialFactor;
        this.weigth = weigth;
        this.maxBlockDamage = maxBlockDamage;
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
}
