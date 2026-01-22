package com.magistuarmory.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ThrownProjectile extends ThrownTrident {

    public ThrownProjectile(EntityType<? extends ThrownTrident> entityType, Level level) {
        super(entityType, level);
    }

    public ThrownProjectile(Level level, LivingEntity livingEntity, ItemStack itemStack) {
        super(level, livingEntity, itemStack);
    }

    public ThrownProjectile(Level level, double x, double y, double z, ItemStack itemStack) {
        super(level, x, y, z, itemStack);
    }
}