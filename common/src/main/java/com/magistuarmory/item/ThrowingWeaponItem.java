package com.magistuarmory.item;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

public class ThrowingWeaponItem extends TridentItem
{
    private final float shootThresholdTime;
    private final float baseDamage;
    private final float projectileSpeed;
    private final boolean spinning;

    public ThrowingWeaponItem(Item.Properties properties, float shootThresholdTime, float baseDamage, float projectileSpeed, boolean spinning)
    {
        super(properties);
        this.shootThresholdTime = shootThresholdTime;
        this.baseDamage = baseDamage;
        this.projectileSpeed = projectileSpeed;
        this.spinning = spinning;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity shooter, int i) {
        int duration = this.getUseDuration(stack, shooter) - i;
        if (duration >= this.shootThresholdTime && !isTooDamagedToUse(stack)) {
            if (!level.isClientSide) {
                stack.hurtAndBreak(1, shooter, LivingEntity.getSlotForHand(shooter.getUsedItemHand()));
                ThrownProjectile projectile = new ThrownProjectile(level, shooter, stack);
                projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0F, this.projectileSpeed, 1.0F);
                if (shooter.hasInfiniteMaterials()) {
                    projectile.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                }

                level.addFreshEntity(projectile);
                Holder<SoundEvent> holder = EnchantmentHelper.pickHighestLevel(stack, EnchantmentEffectComponents.TRIDENT_SOUND).orElse(SoundEvents.TRIDENT_THROW);
                level.playSound(null, projectile, holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                if (shooter instanceof Player player && !player.hasInfiniteMaterials()) {
                    player.getInventory().removeItem(stack);
                }
            }

            if (shooter instanceof Player player) {
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    private static boolean isTooDamagedToUse(ItemStack stack) {
        return stack.getDamageValue() >= stack.getMaxDamage() - 1;
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        ThrownProjectile thrownProjectile = new ThrownProjectile(level, position.x(), position.y(), position.z(), itemStack.copyWithCount(1));
        thrownProjectile.pickup = AbstractArrow.Pickup.ALLOWED;
        return thrownProjectile;
    }
}
