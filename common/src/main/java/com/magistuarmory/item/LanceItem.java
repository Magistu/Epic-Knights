package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.ClientHelper;
import com.magistuarmory.event.ClientEvents;
import com.magistuarmory.network.PacketLanceCollision;
import com.magistuarmory.util.CombatHelper;
import com.magistuarmory.util.ModDamageSource;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;


public class LanceItem extends MedievalWeaponItem
{
	protected int clickedticks = 0;
	protected double velproj;

	public LanceItem(Item.Properties build, ModItemTier material, WeaponType type)
	{
		super(build, material, type);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
	{
		setRaised(player, !isRaised(player));
		return super.use(level, player, hand);
	}

	@Override
	public boolean onAttackClickEntity(ItemStack stack, Player player, Entity entity)
	{
		if (player.isPassenger() && !this.isRaised(player) && !player.getCooldowns().isOnCooldown(this))
			clickedticks = 15;
		
		return false;
	}
	
	public void onCollide(ItemStack stack, Player player, Entity victim, float damage)
	{
		if (stack.getDamageValue() >= stack.getMaxDamage() - 1)
		{
			this.onBroken(player);
		}
		else if (!player.isCreative() && ((LivingEntity) victim).getArmorValue() >= 18)
		{
			stack.setDamageValue(stack.getDamageValue() + (int)((0.6 + damage / 20) * Math.random() * stack.getMaxDamage()));
		}

		// player.attack(victim);
		victim.hurt(ModDamageSource.entityAttack(player), damage);

		for (ItemStack stack0 : player.getInventory().items)
		{
			this.setRaised(player, true);
			player.getCooldowns().addCooldown(stack0.getItem(), (int)(40 / (4 + this.getAttackSpeed(stack))));
		}
		player.swing(InteractionHand.MAIN_HAND);

		if (stack.getDamageValue() >= stack.getMaxDamage())
		{
			this.onBroken(player);
			stack.setCount(0);
		}
		
		Vec3 vec = player.getViewVector(1.0f);
		double b = 70.0 * Math.sqrt(Math.max(0.0, this.velproj) / Math.max(0.5, vec.length() * getSummaryMass(victim))) / 5.0;

		if (victim.isPassenger())
		{
			victim.getRootVehicle().setDeltaMovement(victim.getRootVehicle().getDeltaMovement().add(vec.x * b, vec.y * b, vec.z * b));
			victim.getRootVehicle().hasImpulse = true;
			if (((clickedticks > 0 ? 0.3 : 0.0) + 0.6 + 0.2 * victim.getBoundingBox().getCenter().subtract(player.getEyePosition(1.0f).add(player.getViewVector(CombatHelper.getReachDistance(player, this)))).dot(vec) / vec.length()) * Math.random() > 1)
				victim.stopRiding();
		}
		else
		{
			victim.setDeltaMovement(victim.getDeltaMovement().add(vec.x * b, vec.y * b, vec.z * b));
			victim.hasImpulse = true;
		}
		player.swing(InteractionHand.MAIN_HAND);
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack)
	{
		return UseAnim.BOW;
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean selected)
	{
		if (entity instanceof Player player)
		{
			if (level.isClientSide && player.getMainHandItem().getItem() instanceof LanceItem)
			{
				HitResult hit = ClientHelper.getMouseOver(Minecraft.getInstance(), CombatHelper.getReachDistance(player, this));
				if (hit instanceof EntityHitResult entityhit)
				{
					Entity victim = entityhit.getEntity();
					if (player.isPassenger() && victim instanceof LivingEntity && victim.isAlive() && victim.getId() != player.getVehicle().getId())
						collide(player, (LivingEntity) victim, level);
				}
			}

			if (clickedticks > 0)
				clickedticks--;

			if (!isRaised(player) && player.getCooldowns().isOnCooldown(this))
				setRaised(player, true);
		}
		super.inventoryTick(stack, level, entity, i, selected);
	}

	public void collide(Player player, LivingEntity victim, Level level)
	{
		if (player == null)
			return;
		
		if (level == null)
			return;

		if (!isRaised(player) && !player.getCooldowns().isOnCooldown(this) && player.isPassenger())
		{
			this.velproj = getVelocityProjection(player, victim);

			if ((player.getRootVehicle() instanceof Horse &&
					velproj >= ((Horse)player.getRootVehicle()).getAttribute(Attributes.MOVEMENT_SPEED).getValue())
					|| (!(player.getRootVehicle() instanceof Horse) && velproj >= 0.233))
			{
				int bonusdamage = (int) calcBonusDamage(player, velproj);
				PacketLanceCollision.sendToServer(victim.getId(), bonusdamage);
			}
		}
	}

	@Override
	public InteractionResult useOn(UseOnContext context)
	{
		return InteractionResult.PASS;
	}

	public double calcBonusDamage(Entity player, double velproj)
	{
		double bonusdamage = 5.0 * getSummaryMass(player) * velproj;
		return Math.max(0.0, bonusdamage);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag)
	{
		tooltip.add((new TranslatableComponent("lance.rideronly")).withStyle(ChatFormatting.BLUE));
		tooltip.add((new TranslatableComponent("lance.leftclick")).withStyle(ChatFormatting.BLUE));
		tooltip.add((new TranslatableComponent("lance.bonusdamage")).withStyle(ChatFormatting.BLUE));

		super.appendHoverText(stack, level, tooltip, flag);
	}


	double getVelocityProjection(Entity entity1, Entity entity2)
	{
		Vec3 velocity;
		if (entity1.isPassenger())
		{
			velocity = entity1.getRootVehicle().getDeltaMovement();
		}
		else
		{
			velocity = entity1.getDeltaMovement();
		}

		Vec3 vec = entity1.getViewVector(1.0f);

		if (vec.lengthSqr() == 0.0)
		{
			return 0.0;
		}

		return velocity.dot(vec) / vec.length();
	}


	public double getSummaryMass(Entity entity)
	{
		double summarymass = getMass(entity);

		while (entity.isPassenger())
		{
			entity = entity.getVehicle();
			summarymass += getMass(entity);
		}

		while (entity.getControllingPassenger() != null)
		{
			entity = entity.getControllingPassenger();
			summarymass += getMass(entity);
		}

		return summarymass;
	}


	public double getMass(Entity entity)
	{
		double mass = 0.0F;

		AABB box = entity.getBoundingBox();
		if (box != null)
		{
			mass += (box.maxX - box.minX) * (box.maxY - box.minY) * (box.maxZ - box.minZ);
		}

		for (ItemStack armorpiece : entity.getArmorSlots())
		{
			if (!armorpiece.isEmpty() && armorpiece.getItem() instanceof ArmorItem)
			{
				mass += (((ArmorItem)armorpiece.getItem()).getDefense() + ((ArmorItem)armorpiece.getItem()).getToughness()) / 20.0;
			}
		}

		return mass;
	}

	public void onBroken(Player player)
	{
		if (player.getMainHandItem() != null && player.getMainHandItem().getItem() == this)
		{
			player.drop(new ItemStack(Items.STICK), true);
			player.playSound(SoundEvents.ITEM_BREAK, 1.0f, 1.0f);
		}
	}

	public boolean isRaised(@Nullable LivingEntity entity)
	{
		if (entity == null)
			return false;
		
		ItemStack stack = entity.getMainHandItem();
		if (stack.hasTag())
		{
			CompoundTag nbt = stack.getTag();
			return nbt.contains("raised") && nbt.getInt("raised") == 1;
		}
		
		return false;
	}

	public void setRaised(LivingEntity entity, boolean raised)
	{
		ItemStack stack = entity.getMainHandItem();
		CompoundTag nbt = stack.hasTag() ? stack.getTag() : new CompoundTag();
		nbt.putInt("raised", raised ? 1 : 0);
		stack.setTag(nbt);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void registerModelProperty()
	{
		ItemPropertiesRegistry.register(this, new ResourceLocation(KnightlyArmory.ID, "raised"), (stack, level, entity, i) -> isRaised(entity) ? 1 : 0);
	}
}