package com.magistuarmory.item;

import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class MedievalCrossbowItem extends CrossbowItem implements IHasModelProperty
{
	private final int pullTime;
    private final float projectileSpeed;

	protected boolean startSoundPlayed = false;
	protected boolean midLoadSoundPlayed = false;

    public MedievalCrossbowItem(Properties p_40660_, float projectileSpeed, int pullTime)
    {
        super(p_40660_);
		this.projectileSpeed = projectileSpeed;
        this.pullTime = pullTime;
    }

	public void onUseTick(Level p_40910_, LivingEntity p_40911_, ItemStack p_40912_, int p_40913_) {
		if (!p_40910_.isClientSide) {
			int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, p_40912_);
			SoundEvent soundevent = this.getStartSound(i);
			SoundEvent soundevent1 = i == 0 ? SoundEvents.CROSSBOW_LOADING_MIDDLE : null;
			float f = (float)(p_40912_.getUseDuration() - p_40913_) / (float)getPullTime(p_40912_);
			if (f < 0.2F) {
				this.startSoundPlayed = false;
				this.midLoadSoundPlayed = false;
			}

			if (f >= 0.2F && !this.startSoundPlayed) {
				this.startSoundPlayed = true;
				p_40910_.playSound((Player)null, p_40911_.getX(), p_40911_.getY(), p_40911_.getZ(), soundevent, SoundSource.PLAYERS, 0.5F, 1.0F);
			}

			if (f >= 0.5F && soundevent1 != null && !this.midLoadSoundPlayed) {
				this.midLoadSoundPlayed = true;
				p_40910_.playSound((Player)null, p_40911_.getX(), p_40911_.getY(), p_40911_.getZ(), soundevent1, SoundSource.PLAYERS, 0.5F, 1.0F);
			}
		}

	}

	public void releaseUsing(ItemStack p_40875_, Level p_40876_, LivingEntity p_40877_, int p_40878_) {
		int i = this.getUseDuration(p_40875_) - p_40878_;
		float f = getPower(i, p_40875_);
		if (f >= 1.0F && !isCharged(p_40875_) && tryLoadProjectiles(p_40877_, p_40875_)) {
			setCharged(p_40875_, true);
			SoundSource soundsource = p_40877_ instanceof Player ? SoundSource.PLAYERS : SoundSource.HOSTILE;
			p_40876_.playSound((Player)null, p_40877_.getX(), p_40877_.getY(), p_40877_.getZ(), SoundEvents.CROSSBOW_LOADING_END, soundsource, 1.0F, 1.0F / (p_40876_.getRandom().nextFloat() * 0.5F + 1.0F) + 0.2F);
		}

	}

	private static boolean tryLoadProjectiles(LivingEntity p_40860_, ItemStack p_40861_) {
		int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MULTISHOT, p_40861_);
		int j = i == 0 ? 1 : 3;
		boolean flag = p_40860_ instanceof Player && ((Player)p_40860_).getAbilities().instabuild;
		ItemStack itemstack = p_40860_.getProjectile(p_40861_);
		ItemStack itemstack1 = itemstack.copy();

		for(int k = 0; k < j; ++k) {
			if (k > 0) {
				itemstack = itemstack1.copy();
			}

			if (itemstack.isEmpty() && flag) {
				itemstack = new ItemStack(Items.ARROW);
				itemstack1 = itemstack.copy();
			}

			if (!loadProjectile(p_40860_, p_40861_, itemstack, k > 0, flag)) {
				return false;
			}
		}

		return true;
	}

	private static boolean loadProjectile(LivingEntity p_40863_, ItemStack p_40864_, ItemStack p_40865_, boolean p_40866_, boolean p_40867_) {
		if (p_40865_.isEmpty()) {
			return false;
		} else {
			boolean flag = p_40867_ && p_40865_.getItem() instanceof ArrowItem;
			ItemStack itemstack;
			if (!flag && !p_40867_ && !p_40866_) {
				itemstack = p_40865_.split(1);
				if (p_40865_.isEmpty() && p_40863_ instanceof Player) {
					((Player)p_40863_).getInventory().removeItem(p_40865_);
				}
			} else {
				itemstack = p_40865_.copy();
			}

			addChargedProjectile(p_40864_, itemstack);
			return true;
		}
	}

	private static void addChargedProjectile(ItemStack p_40929_, ItemStack p_40930_) {
		CompoundTag compoundtag = p_40929_.getOrCreateTag();
		ListTag listtag;
		if (compoundtag.contains("ChargedProjectiles", 9)) {
			listtag = compoundtag.getList("ChargedProjectiles", 10);
		} else {
			listtag = new ListTag();
		}

		CompoundTag compoundtag1 = new CompoundTag();
		p_40930_.save(compoundtag1);
		listtag.add(compoundtag1);
		compoundtag.put("ChargedProjectiles", listtag);
	}

	public InteractionResultHolder<ItemStack> use(Level p_40920_, Player p_40921_, InteractionHand p_40922_) {
		ItemStack itemstack = p_40921_.getItemInHand(p_40922_);
		if (isCharged(itemstack)) {
			performShooting(p_40920_, p_40921_, p_40922_, itemstack, getProjectileSpeed(itemstack), 1.0F);
			setCharged(itemstack, false);
			return InteractionResultHolder.consume(itemstack);
		} else if (!p_40921_.getProjectile(itemstack).isEmpty()) {
			if (!isCharged(itemstack)) {
				this.startSoundPlayed = false;
				this.midLoadSoundPlayed = false;
				p_40921_.startUsingItem(p_40922_);
			}

			return InteractionResultHolder.consume(itemstack);
		} else {
			return InteractionResultHolder.fail(itemstack);
		}
	}

	private SoundEvent getStartSound(int p_40852_) {
		switch (p_40852_) {
			case 1:
				return SoundEvents.CROSSBOW_QUICK_CHARGE_1;
			case 2:
				return SoundEvents.CROSSBOW_QUICK_CHARGE_2;
			case 3:
				return SoundEvents.CROSSBOW_QUICK_CHARGE_3;
			default:
				return SoundEvents.CROSSBOW_LOADING_START;
		}
	}

	public int getPullTime(ItemStack p_40940_) {
		int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, p_40940_);
		return i == 0 ? pullTime : pullTime - 5 * i;
	}

	public float getProjectileSpeed(ItemStack p_40946_) {
		return containsChargedProjectile(p_40946_, Items.FIREWORK_ROCKET) ? 1.6F : projectileSpeed;
	}

	private float getPower(int p_40854_, ItemStack p_40855_) {
		float f = (float)p_40854_ / (float)getPullTime(p_40855_);
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	@Override
	public int getUseDuration(ItemStack p_40938_) {
		return getPullTime(p_40938_) + 3;
	}

    @Override
	@Environment(EnvType.CLIENT)
	public void registerModelProperty()
	{
		ItemPropertiesRegistry.register(this, new ResourceLocation("pull"), (stack, level, entity, i) -> {
			if (entity == null) {
				return 0.0F;
			} else {
				return CrossbowItem.isCharged(stack) ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / (float)getPullTime(stack);
			}
		});
		ItemPropertiesRegistry.register(this, new ResourceLocation("pulling"), (stack, level, entity, i) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack && !CrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
		ItemPropertiesRegistry.register(this, new ResourceLocation("charged"), (stack, level, entity, i) -> entity != null && CrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
		ItemPropertiesRegistry.register(this, new ResourceLocation("firework"), (stack, level, entity, i) -> entity != null && CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F);
	}
}
