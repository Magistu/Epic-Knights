package com.magistuarmory.item;

import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class MedievalBowItem extends BowItem implements IHasModelProperty
{
    private final float pullTime;
    private final float arrowSpeed;

    public MedievalBowItem(Properties properties, float arrowSpeed, float pullTime)
    {
        super(properties.stacksTo(1));
        this.arrowSpeed = arrowSpeed;
        this.pullTime = pullTime;
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int i) {
        if (livingEntity instanceof Player player) {
            ItemStack itemStack2 = player.getProjectile(itemStack);
            if (!itemStack2.isEmpty()) {
                int j = this.getUseDuration(itemStack, livingEntity) - i;
                float f = this.getPower(j);
                if (!((double)f < 0.1)) {
                    List<ItemStack> list = draw(itemStack, itemStack2, player);
                    if (level instanceof ServerLevel serverLevel) {
                        this.shoot(serverLevel, player, player.getUsedItemHand(), itemStack, list, f * this.arrowSpeed, 1.0F, f == 1.0F, null);
                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public float getPower(int p_185059_0_)
    {
        float f = (float)p_185059_0_ / this.pullTime;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F)
            f = 1.0F;
        return f;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void registerModelProperty()
    {
        ItemPropertiesRegistry.register(this, ResourceLocation.withDefaultNamespace("pulling"), (stack, level, entity, i) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);

        ItemPropertiesRegistry.register(this, ResourceLocation.withDefaultNamespace("pull"), (stack, level, entity, i) ->
        {
            if (entity == null) 
                return 0.0F;
            else 
                return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20.0F;
        });
    }
}
