package com.magistuarmory.item;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

public class RangedWeaponType {
    private final Supplier<Integer> durability;
    private final Supplier<Integer> pullTime;
    private final Supplier<Double> projectileSpeed;
    private final Supplier<Boolean> enabled;

    public RangedWeaponType(ForgeConfigSpec.Builder builder, String name, int durability, int pullTime, double projectileSpeed, boolean enabled) {
        builder.push(name);
        this.durability = builder.defineInRange("durability", durability, 0, Integer.MAX_VALUE);
        this.pullTime = builder.defineInRange("pullTime", pullTime, 0, Integer.MAX_VALUE);
        this.projectileSpeed = builder.defineInRange("projectileSpeed", projectileSpeed, 0, Double.MAX_VALUE);
        this.enabled = builder.define("enabled", enabled);
        builder.pop();
    }

    public int getDurability() {
        return this.durability.get();
    }

    public int getPullTime() {
        return this.pullTime.get();
    }

    public float getProjectileSpeed() {
        return this.projectileSpeed.get().floatValue();
    }

    public boolean isDisabled() {
        return !this.enabled.get();
    }
}
