package com.magistuarmory.item;

import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class MedievalBowItem extends BowItem implements IHasModelProperty
{
    private final float pullTime;
    private final float arrowSpeed;

    public MedievalBowItem(Properties properties, float arrowSpeed, float pullTime)
    {
        super(properties);
        this.arrowSpeed = arrowSpeed;
        this.pullTime = pullTime;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int t)
    {
        if (entity instanceof Player player)
        {
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
            ItemStack stack2 = player.getProjectile(stack);

            int i = this.getUseDuration(stack) - t;
            if (!stack2.isEmpty() || flag)
            {
                if (stack2.isEmpty())
                    stack2 = new ItemStack(Items.ARROW);

                float f = this.getPower(i);
                if (!((double)f < 0.1D))
                {
                    boolean flag1 = player.getAbilities().instabuild || (stack2.getItem() instanceof ArrowItem && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0);
                    if (!level.isClientSide)
                    {
                        ArrowItem arrowitem = (ArrowItem)(stack2.getItem() instanceof ArrowItem ? stack2.getItem() : Items.ARROW);
                        AbstractArrow abstractarrow = arrowitem.createArrow(level, stack2, player);
                        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * this.arrowSpeed, 1.0F);
                        if (f == 1.0F)
                            abstractarrow.setCritArrow(true);

                        int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
                        if (j > 0)
                            abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + (double)j * 0.5D + 0.5D);

                        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
                        if (k > 0)
                            abstractarrow.setKnockback(k);

                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0)
                            abstractarrow.setSecondsOnFire(100);

                        stack.hurtAndBreak(1, player, (p_40665_) -> {
                            p_40665_.broadcastBreakEvent(player.getUsedItemHand());
                        });
                        if (flag1 || player.getAbilities().instabuild && (stack2.is(Items.SPECTRAL_ARROW) || stack2.is(Items.TIPPED_ARROW)))
                            abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;

                        level.addFreshEntity(abstractarrow);
                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !player.getAbilities().instabuild)
                    {
                        stack2.shrink(1);
                        if (stack2.isEmpty())
                            player.getInventory().removeItem(stack2);
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public float getPower(int t)
    {
        float f = (float) t / this.pullTime;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F)
            f = 1.0F;
        return f;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void registerModelProperty()
    {
        ItemPropertiesRegistry.register(this, new ResourceLocation("pulling"), (stack, level, entity, i) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);

        ItemPropertiesRegistry.register(this, new ResourceLocation("pull"), (stack, level, entity, i) ->
        {
            if (entity == null) 
                return 0.0F;
            else 
                return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
        });
    }
}
