package com.magistuarmory.item;

public class RangedWeaponType
{
    private final int durability;
    private final int pullTime;
    private final float projectileSpeed;
    private final boolean enabled;

    public RangedWeaponType(int durability, int pullTime, float projectileSpeed, boolean enabled)
    {
        this.durability = durability;
        this.pullTime = pullTime;
        this.projectileSpeed = projectileSpeed;
        this.enabled = enabled;
    }

    public int getDurability()
    {
        return this.durability;
    }

    public int getPullTime()
    {
        return this.pullTime;
    }

    public float getProjectileSpeed()
    {
        return this.projectileSpeed;
    }

    public boolean isDisabled()
    {
        return !this.enabled;
    }
}
