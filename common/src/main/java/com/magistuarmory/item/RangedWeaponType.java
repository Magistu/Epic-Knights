package com.magistuarmory.item;

public class RangedWeaponType
{
    private int durability;
    private int pullTime;
    private float projectileSpeed;
    private boolean enabled;

    public RangedWeaponType() {}

    public static RangedWeaponType of(int durability, int pullTime, float projectileSpeed, boolean enabled)
    {
        RangedWeaponType type = new RangedWeaponType();
        type.durability = durability;
        type.pullTime = pullTime;
        type.projectileSpeed = projectileSpeed;
        type.enabled = enabled;
        return type;
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
