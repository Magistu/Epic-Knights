package com.magistuarmory.item;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.ClientHelper;
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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
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
import java.util.ArrayList;
import java.util.List;


public class LanceItem extends MedievalWeaponItem
{
	private List<ItemStack> dropItems = new ArrayList<>();
	protected int clickedticks = 0;

	public LanceItem(Properties properties, ModItemTier material, WeaponType type)
	{
		super(properties, material, type);
		this.setDropItems(material);
	}

	public LanceItem setDropItems(ModItemTier material)
	{
		this.dropItems.add(new ItemStack(Items.STICK, 2));
		ItemStack[] repairItems = material.getRepairIngredient().getItems();
		if (repairItems.length > 0)
			this.dropItems.add(repairItems[0]);
		return this;
	}
	
	public LanceItem setDropItems(List<ItemStack> stacks)
	{
		this.dropItems = stacks;
		return this;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
	{
		this.setRaised(player, !this.isRaised(player));
		return super.use(level, player, hand);
	}

	@Override
	public boolean onAttackClickEntity(ItemStack stack, Player player, Entity entity)
	{
		if (KnightlyArmory.GENERAL_CONFIG.disableLanceCollision)
			return super.onAttackClickEntity(stack, player, entity);
		
		if (player.isPassenger() && !this.isRaised(player) && !player.getCooldowns().isOnCooldown(this))
			this.clickedticks = 15;
		player.swing(InteractionHand.MAIN_HAND);
		
		return false;
	}

    public void collide(Player player, LivingEntity victim, Level level)
    {
        if (player == null || level == null)
            return;

        if (!this.isRaised(player) && !player.getCooldowns().isOnCooldown(this) && player.isPassenger())
        {
            float speed = this.getVelocityProjection(player);

            if ((player.getRootVehicle() instanceof Horse &&
					speed >= ((Horse)player.getRootVehicle()).getAttribute(Attributes.MOVEMENT_SPEED).getValue())
                    || (!(player.getRootVehicle() instanceof Horse) && speed >= 0.233))
            {
				float attackreach = CombatHelper.getAttackReach(player, this);
				Vec3 vec = player.getViewVector(1.0f);
				boolean dismount = ((this.clickedticks > 0 ? 0.3 : 0.0) + 0.6 + 0.2 * victim.getBoundingBox().getCenter().subtract(player.getEyePosition(1.0f).add(player.getViewVector(attackreach))).dot(vec) / vec.length()) * victim.level.getRandom().nextDouble() > 1;
                PacketLanceCollision.sendToServer(victim.getId(), speed, dismount);
				player.resetAttackStrengthTicker();
            }
        }
    }

	@Override
	public boolean onHurtEntity(DamageSource source, LivingEntity victim, float damage)
	{
		if (KnightlyArmory.GENERAL_CONFIG.disableLanceCollision)
			return super.onHurtEntity(source, victim, damage);
		
		if (victim.level.isClientSide() || ModDamageSource.isAdditional(source) || !(source.getEntity() instanceof LivingEntity attacker))
			return true;
		
		float speed = 0.0f;
		float bonusdamage = 0.0f;
		boolean dismount = false;

		if (attacker instanceof Mob mob) 
		{
			ItemStack stack = mob.getMainHandItem();
			speed = this.getRideSpeed(stack);
			this.setRideSpeed(stack, 0.0f);
			bonusdamage = this.calcBonusDamage(attacker, speed);
			dismount = this.getDismount(stack);
			this.setDismount(stack, false);
		}
		else if (attacker instanceof Player player)
		{
			ItemStack stack = player.getMainHandItem();
			speed = this.getRideSpeed(stack);
			this.setRideSpeed(stack, 0.0f);
			bonusdamage = this.calcBonusDamage(attacker, speed);
			dismount = this.getDismount(stack);
			this.setDismount(stack, false);
			
			if (stack.getDamageValue() >= stack.getMaxDamage() - 1)
				this.onBroken(player);
			else if (!player.isCreative() && (victim.getArmorValue() >= 18 || victim.isBlocking()))
				stack.setDamageValue(stack.getDamageValue() + (int) ((0.6 + bonusdamage / 20) * victim.level.getRandom().nextDouble() * stack.getMaxDamage()));

			for (ItemStack stack0 : player.getInventory().items)
			{
				this.setRaised(player, true);
				player.getCooldowns().addCooldown(stack0.getItem(), (int) (40 / (4 + this.getAttackSpeed(stack))));
			}

			if (stack.getDamageValue() >= stack.getMaxDamage())
			{
				this.onBroken(player);
				stack.setCount(0);
			}
		}

		Vec3 vec = attacker.getViewVector(1.0f);
		double b = 70.0 * Math.sqrt(Math.max(0.0, speed) / Math.max(0.5, 2.0f * vec.length() * this.getSummaryMass(victim))) / 5.0;
		
		if (victim.isPassenger())
		{
			victim.getRootVehicle().setDeltaMovement(victim.getRootVehicle().getDeltaMovement().add(vec.x * b, vec.y * b, vec.z * b));
			victim.getRootVehicle().hasImpulse = true;
			if (dismount)
				victim.stopRiding();
		}
		else
		{
			victim.setDeltaMovement(victim.getDeltaMovement().add(vec.x * b, vec.y * b, vec.z * b));
			victim.hasImpulse = true;
		}
		
		if (!super.onHurtEntity(source, victim, bonusdamage + damage) && bonusdamage != 0.0f)
		{
			victim.hurt(ModDamageSource.additional(attacker), bonusdamage + damage);
			return true;
		}
		
		return false;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack)
	{
		return UseAnim.BOW;
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean selected)
	{
		if (KnightlyArmory.GENERAL_CONFIG.disableLanceCollision) 
		{
			super.inventoryTick(stack, level, entity, i, selected);
			return;
		}
		
		if (entity instanceof Player player)
		{
			if (level.isClientSide && player.getMainHandItem().getItem() instanceof LanceItem)
			{
				HitResult hit = ClientHelper.getMouseOver(Minecraft.getInstance(), CombatHelper.getAttackReach(player, this));
				if (hit instanceof EntityHitResult entityhit)
				{
					Entity victim = entityhit.getEntity();
					if (player.isPassenger() && victim instanceof LivingEntity && victim.isAlive() && victim.getId() != player.getVehicle().getId())
						this.collide(player, (LivingEntity) victim, level);
				}

				if (this.clickedticks > 0)
					this.clickedticks--;
			}

			if (!this.isRaised(player) && player.getCooldowns().isOnCooldown(this))
				this.setRaised(player, true);
		}
		super.inventoryTick(stack, level, entity, i, selected);
	}

	@Override
	public InteractionResult useOn(UseOnContext context)
	{
		return InteractionResult.PASS;
	}

	public float calcBonusDamage(Entity entity, float speed)
	{
        float bonusdamage = 3.0f * this.getSummaryMass(entity) * speed;
		return Math.min(Math.max(0.0f, bonusdamage), 0.7f * this.attackDamage);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag)
	{
		tooltip.add((new TranslatableComponent("lance.rideronly")).withStyle(ChatFormatting.BLUE));
		tooltip.add((new TranslatableComponent("lance.leftclick")).withStyle(ChatFormatting.BLUE));
		tooltip.add((new TranslatableComponent("lance.bonusdamage")).withStyle(ChatFormatting.BLUE));

		super.appendHoverText(stack, level, tooltip, flag);
	}


	float getVelocityProjection(Entity entity)
	{
		Vec3 velocity;
		if (entity.isPassenger())
			velocity = entity.getRootVehicle().getDeltaMovement();
		else
			velocity = entity.getDeltaMovement();

		Vec3 vec = entity.getViewVector(1.0f);

		if (vec.lengthSqr() == 0.0f)
			return 0.0f;

		return (float) (velocity.dot(vec) / vec.length());
	}


	public float getSummaryMass(Entity entity)
	{
		float summarymass = this.getMass(entity);
		
		Entity entity2 = entity;
		while (entity2.isPassenger())
		{
			entity2 = entity2.getVehicle();
			summarymass += this.getMass(entity2);
		}

		for (Entity passenger : entity.getPassengers())
			summarymass += this.getMass(passenger);

		return summarymass;
	}


	public float getMass(Entity entity)
	{
        float mass = 0.0f;

		AABB box = entity.getBoundingBox();
		if (box != null)
			mass += (box.getXsize()) * (box.getYsize()) * (box.getZsize());

		for (ItemStack armorpiece : entity.getArmorSlots())
		{
			if (!armorpiece.isEmpty() && armorpiece.getItem() instanceof ArmorItem)
				mass += (((ArmorItem)armorpiece.getItem()).getDefense() + ((ArmorItem)armorpiece.getItem()).getToughness()) / 20.0;
		}

		return mass;
	}

	public void onBroken(Player player)
	{
		if (player.getMainHandItem() != null && player.getMainHandItem().getItem() == this)
		{
			for (ItemStack stack : this.dropItems)
				player.drop(stack, true);
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

	public boolean getDismount(ItemStack stack)
	{
		if (stack.hasTag())
		{
			CompoundTag nbt = stack.getTag();
			if (nbt.contains("dismount"))
				return nbt.getBoolean("dismount");
		}

		return false;
	}

	public void setDismount(ItemStack stack, boolean dismount)
	{
		CompoundTag nbt = stack.getOrCreateTag();
		nbt.putBoolean("dismount", dismount);
		stack.setTag(nbt);
	}

	public float getRideSpeed(ItemStack stack)
	{
		if (stack.hasTag())
		{
			CompoundTag nbt = stack.getTag();
			if (nbt.contains("rideSpeed"))
				return nbt.getFloat("rideSpeed");
		}

		return 0.0f;
	}

	public void setRideSpeed(ItemStack stack, float speed)
	{
		CompoundTag nbt = stack.getOrCreateTag();
		nbt.putFloat("rideSpeed", speed);
		stack.setTag(nbt);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void registerModelProperty()
	{
		ItemPropertiesRegistry.register(this, new ResourceLocation(KnightlyArmory.ID, "raised"), (stack, level, entity, i) -> this.isRaised(entity) ? 1 : 0);
	}
}
