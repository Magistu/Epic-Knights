package com.magistuarmory.item;

import com.magistuarmory.config.GeneralConfig;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

public class WeaponType {
    private final Supplier<Double> baseAttackDamage;
    private final Supplier<Double> baseAttackSpeed;
    private final Supplier<Double> bonusAttackReach;
    private final Supplier<Double> sizeFactor;
    private final Supplier<Double> weight;
    private final Supplier<Integer> armorPiercing;
    private Supplier<Integer> twoHanded = () -> 0;
    private Supplier<Double> maxBlockDamage = () -> 0.0;
    private Supplier<Boolean> canBlock = () -> false;
    private Supplier<Boolean> isFlamebladed = () -> false;
    private Supplier<Boolean> isHalberd = () -> false;
    private final Supplier<Boolean> enabled;

    public WeaponType(ForgeConfigSpec.Builder builder, String name, double baseAttackDamage, double baseAttackSpeed, double bonusAttackReach, double sizeFactor, double weight, int armorPiercing, boolean enabled) {
        this(builder, name, baseAttackDamage, baseAttackSpeed, bonusAttackReach, sizeFactor, weight, armorPiercing, enabled, 0, 0.0, false, false, false);
    }

    public WeaponType(ForgeConfigSpec.Builder builder, String name, double baseAttackDamage, double baseAttackSpeed, double bonusAttackReach, double sizeFactor, double weight, int armorPiercing, boolean enabled, int twoHanded, double maxBlockDamage, boolean canBlock, boolean isFlamebladed, boolean isHalberd) {
        builder.push(name);
        this.baseAttackDamage = builder.defineInRange("baseAttackDamage", baseAttackDamage, 0, Double.MAX_VALUE);
        this.baseAttackSpeed = builder.defineInRange("baseAttackSpeed", baseAttackSpeed, 0, Double.MAX_VALUE);
        this.bonusAttackReach = builder.defineInRange("bonusAttackReach", bonusAttackReach, 0, Double.MAX_VALUE);
        this.sizeFactor = builder.defineInRange("sizeFactor", sizeFactor, 0, Double.MAX_VALUE);
        this.weight = builder.defineInRange("weight", weight, 0, Double.MAX_VALUE);
        this.armorPiercing = builder.defineInRange("armorPiercing", armorPiercing, 0, 100);
        this.enabled = () -> enabled;
        this.twoHanded = builder.defineInRange("twoHanded", twoHanded, 0, 2);
        this.maxBlockDamage = builder.defineInRange("maxBlockDamage", maxBlockDamage, 0, Double.MAX_VALUE);
        this.canBlock = builder.define("canBlock", canBlock);
        this.isFlamebladed = builder.define("isFlamebladed", isFlamebladed);
        this.isHalberd = builder.define("isHalberd", isHalberd);
        builder.pop();
    }

    // use constructor with builder and name parameters
    @Deprecated(forRemoval = true)
    public WeaponType(float baseAttackDamage, float baseAttackSpeed, float bonusAttackReach, float sizeFactor, float weight, int armorPiercing, boolean enabled) {
        this.baseAttackDamage = () -> Double.valueOf(baseAttackDamage);
        this.baseAttackSpeed = () -> Double.valueOf(baseAttackSpeed);
        this.bonusAttackReach = () -> Double.valueOf(bonusAttackReach);
        this.sizeFactor = () -> Double.valueOf(sizeFactor);
        this.weight = () -> Double.valueOf(weight);
        this.armorPiercing = () -> armorPiercing;
        this.enabled = () -> enabled;
    }

    // use constructor with builder and name parameters
    @Deprecated(forRemoval = true)
    public WeaponType setFlamebladed() {
        this.isFlamebladed = () -> true;
        return this;
    }

    // use constructor with builder and name parameters
    @Deprecated(forRemoval = true)
    public WeaponType setTwoHanded(int level) {
        this.twoHanded = () -> level;
        return this;
    }

    // use constructor with builder and name parameters
    @Deprecated(forRemoval = true)
    public WeaponType setMaxBlockDamage(float maxBlockDamage) {
        this.maxBlockDamage = () -> Double.valueOf(maxBlockDamage);
        this.canBlock = () -> true;
        return this;
    }

    // use constructor with builder and name parameters
    @Deprecated(forRemoval = true)
    public WeaponType setHalberd() {
        this.isHalberd = () -> true;
        return this;
    }

    public float getAttackSpeed(ModItemTier material) {
        return -material.getDensity() * this.getSizeFactor() + this.getBaseAttackSpeed();
    }

    public float getBaseAttackDamage() {
        return this.baseAttackDamage.get().floatValue();
    }

    public float getBaseAttackSpeed() {
        return this.baseAttackSpeed.get().floatValue();
    }

    public float getSizeFactor() {
        return this.sizeFactor.get().floatValue();
    }

    public float getWeight() {
        return this.weight.get().floatValue();
    }

    public int getArmorPiercing() {
        return !GeneralConfig.DISABLE_ARMOR_PIERCING.get() ? this.armorPiercing.get() : 0;
    }

    public float getBonusAttackReach() {
        return !GeneralConfig.DISABLE_ATTACK_REACH.get() ? this.bonusAttackReach.get().floatValue() : 0.0f;
    }

    public int getTwoHanded() {
        return !GeneralConfig.DISABLE_TWO_HANDED.get() ? this.twoHanded.get() : 0;
    }

    public float getMaxBlockDamage() {
        return !GeneralConfig.DISABLE_WEAPON_BLOCKING.get() ? this.maxBlockDamage.get().floatValue() : 0.0f;
    }

    public boolean canBlock() {
        return !GeneralConfig.DISABLE_WEAPON_BLOCKING.get() && this.canBlock.get();
    }

    public boolean isFlamebladed() {
        return !GeneralConfig.DISABLE_LACERATION.get() && this.isFlamebladed.get();
    }

    public boolean isHalberd() {
        return this.isHalberd.get();
    }

    public boolean isDisabled() {
        return !this.enabled.get();
    }

    public int getDurability(ModItemTier material) {
        return (int) (material.getUses() * (1.0f + this.getSizeFactor() * 5.0f));
    }
}
