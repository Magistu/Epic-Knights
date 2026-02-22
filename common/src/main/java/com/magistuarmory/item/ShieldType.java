package com.magistuarmory.item;

import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

public final class ShieldType
{
    private final Supplier<Integer> baseDurability;
    private final Supplier<Double> materialFactor;
    private final Supplier<Double> weight;
    private final Supplier<Double> maxBlockDamage;
    private Supplier<Boolean> repairable = () -> false;
    public final Supplier<Boolean> enabled;

    public ShieldType(ForgeConfigSpec.Builder builder, String name, int baseDurability, float materialFactor, float weight, float maxBlockDamage, boolean enabled, boolean repairable)
    {
        builder.push(name);
        this.baseDurability = builder.defineInRange("baseDurability", baseDurability, 0, Integer.MAX_VALUE);
        this.materialFactor = builder.defineInRange("materialFactor", materialFactor, 0, Double.MAX_VALUE);
        this.weight = builder.defineInRange("weight", weight, 0, Double.MAX_VALUE);
        this.maxBlockDamage = builder.defineInRange("maxBlockDamage", maxBlockDamage, 0, Double.MAX_VALUE);
        this.enabled = builder.define("enabled", enabled);
        this.repairable = builder.define("repairable", repairable);
        builder.pop();
    }

    // use constructor with builder and name parameters
    @Deprecated(forRemoval = true)
    public ShieldType(int baseDurability, float materialFactor, float weight, float maxBlockDamage, boolean enabled)
    {
        this.baseDurability = () -> baseDurability;
        this.materialFactor = () -> Double.valueOf(materialFactor);
        this.weight = () -> Double.valueOf(weight);
        this.maxBlockDamage = () -> Double.valueOf(maxBlockDamage);
        this.enabled = () -> enabled;
    }

    // use constructor with builder and name parameters
    @Deprecated(forRemoval = true)
    public ShieldType setRepairable()
    {
        this.repairable = () -> true;
        return this;
    }

    public int getDurability(Tier material)
    {
        return (int) (this.baseDurability.get() + this.materialFactor.get() * material.getUses());
    }

    public int getBaseDurability()
    {
        return this.baseDurability.get();
    }

    public float getMaterialFactor()
    {
        return this.materialFactor.get().floatValue();
    }

    public float getWeight()
    {
        return this.weight.get().floatValue();
    }

    public float getMaxBlockDamage()
    {
        return this.maxBlockDamage.get().floatValue();
    }

    public boolean isRepairable()
    {
        return this.repairable.get();
    }

    public boolean isDisabled()
    {
        return !this.enabled.get();
    }
}
