package com.magistuarmory.item;

import com.magistuarmory.client.render.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;

public class MedievalCrossbowItem extends CrossbowItem implements IHasModelProperty
{
	static ChargingSounds DEFAULT_SOUNDS;
	static {
		DEFAULT_SOUNDS = new ChargingSounds(Optional.of(SoundEvents.CROSSBOW_LOADING_START), Optional.of(SoundEvents.CROSSBOW_LOADING_MIDDLE), Optional.of(SoundEvents.CROSSBOW_LOADING_END));
	}
	
	private final int pullTime;
    private final float projectileSpeed;

	protected boolean startSoundPlayed = false;
	protected boolean midLoadSoundPlayed = false;
	
    public MedievalCrossbowItem(Properties properties, float projectileSpeed, int pullTime)
    {
        super(properties.stacksTo(1));
		this.projectileSpeed = projectileSpeed;
        this.pullTime = pullTime;
    }

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		ChargedProjectiles chargedProjectiles = itemStack.get(DataComponents.CHARGED_PROJECTILES);
		if (chargedProjectiles != null && !chargedProjectiles.isEmpty()) {
			this.performShooting(level, player, interactionHand, itemStack, getProjectileSpeed(chargedProjectiles), 1.0F, null);
			return InteractionResult.CONSUME;
		} else if (!player.getProjectile(itemStack).isEmpty()) {
			this.startSoundPlayed = false;
			this.midLoadSoundPlayed = false;
			player.startUsingItem(interactionHand);
			return InteractionResult.CONSUME;
		} else {
			return InteractionResult.FAIL;
		}
	}

	@Override
	public boolean releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int i) {
		int j = this.getUseDuration(itemStack, livingEntity) - i;
		float f = getPower(j, itemStack, livingEntity);
		if (f >= 1.0F && !isCharged(itemStack) && tryLoadProjectiles(livingEntity, itemStack)) {
			ChargingSounds chargingSounds = this.getChargingSounds(itemStack);
			chargingSounds.end().ifPresent((holder) -> {
				level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), holder.value(), livingEntity.getSoundSource(), 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.5F + 1.0F) + 0.2F);
			});
            return true;
		}


        return false;
    }

	private static boolean tryLoadProjectiles(LivingEntity livingEntity, ItemStack itemStack) {
		List<ItemStack> list = draw(itemStack, livingEntity.getProjectile(itemStack), livingEntity);
		if (!list.isEmpty()) {
			itemStack.set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.ofNonEmpty(list));
			return true;
		} else {
			return false;
		}
	}


	ChargingSounds getChargingSounds(ItemStack itemStack) {
		return EnchantmentHelper.pickHighestLevel(itemStack, EnchantmentEffectComponents.CROSSBOW_CHARGING_SOUNDS).orElse(DEFAULT_SOUNDS);
	}

	private float getProjectileSpeed(ChargedProjectiles chargedProjectiles) {
		return chargedProjectiles.contains(Items.FIREWORK_ROCKET) ? projectileSpeed / 2 : projectileSpeed;
	}
	
	public int getPullTime(ItemStack itemStack, LivingEntity shooter) {
		float f = EnchantmentHelper.modifyCrossbowChargingTime(itemStack, shooter, pullTime / 20.0f);
		return Mth.floor(f * 20.0F);
	}

	private float getPower(int p_40854_, ItemStack stack, LivingEntity shooter) {
		float f = (float)p_40854_ / (float)this.getPullTime(stack, shooter);
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	@Override
	public int getUseDuration(ItemStack stack, LivingEntity entity) {
		return getPullTime(stack, entity) + 3;
	}

    @Override
	@Environment(EnvType.CLIENT)
	public void registerModelProperty()
	{
		ItemPropertiesRegistry.register(this, Identifier.withDefaultNamespace("pull"), (stack, level, entity, i) -> {
			if (entity == null) {
				return 0.0F;
			} else {
				return CrossbowItem.isCharged(stack) ? 0.0F : (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / (float)getPullTime(stack, entity);
			}
		});
		ItemPropertiesRegistry.register(this, Identifier.withDefaultNamespace("pulling"), (stack, level, entity, i) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack && !CrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
		ItemPropertiesRegistry.register(this, Identifier.withDefaultNamespace("charged"), (stack, level, entity, i) -> entity != null && CrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
		ItemPropertiesRegistry.register(this, Identifier.withDefaultNamespace("firework"), (stack, level, entity, i) -> entity != null && CrossbowItem.isCharged(stack) && stack.has(DataComponents.CHARGED_PROJECTILES) && stack.get(DataComponents.CHARGED_PROJECTILES).contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F);
	}
}
