package com.magistuarmory.item;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.HitResultHelper;
import com.magistuarmory.component.ModDataComponents;
import com.magistuarmory.network.PacketLanceCollision;
import com.magistuarmory.util.CombatHelper;
import com.magistuarmory.util.ModDamageSources;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
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

import java.util.ArrayList;
import java.util.List;


public class LanceItem extends MedievalWeaponItem
{
	private final ModItemTier material;
	private List<ItemStack> dropItems = new ArrayList<>();
	protected int clickedticks = 0;
	static int CLICKED_TICKS_COOLDOWN = 5;

	public LanceItem(Properties properties, ModItemTier material, WeaponType type)
	{
		super(properties, material, type);
		this.material = material;
	}

	public void resetClickedTicks()
	{
		this.clickedticks = CLICKED_TICKS_COOLDOWN;
	}

	public float getClickedScale()
	{
		return Mth.clamp((float) this.clickedticks / CLICKED_TICKS_COOLDOWN, 0.0F, 1.0F);
	}

	public void setupDropItems()
	{
		this.dropItems.add(new ItemStack(Items.STICK, 2));
		String materialname = this.material.getMaterialName();
		switch (materialname)
		{
			case "iron" -> this.dropItems.add(new ItemStack(Items.IRON_INGOT));
			case "gold" -> this.dropItems.add(new ItemStack(Items.GOLD_INGOT));
			case "diamond" -> this.dropItems.add(new ItemStack(Items.DIAMOND));
			case "netherite" ->
			{
				this.dropItems.add(new ItemStack(Items.NETHERITE_INGOT));
				this.dropItems.add(new ItemStack(Items.DIAMOND));
			}
			case "steel" -> this.dropItems.add(new ItemStack(ModItems.STEEL_INGOT.get()));
		}
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
		if (EpicKnights.GENERAL_CONFIG.disableLanceCollision)
			return super.onAttackClickEntity(stack, player, entity);

		if (player.isPassenger() && !this.isRaised(player) && !player.getCooldowns().isOnCooldown(this))
			this.resetClickedTicks();
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
				PacketLanceCollision.sendToServer(player, victim);
				player.resetAttackStrengthTicker();
			}
		}
	}

	@Override
	public boolean onHurtEntity(DamageSource source, LivingEntity victim, float damage)
	{
		if (EpicKnights.GENERAL_CONFIG.disableLanceCollision)
			return super.onHurtEntity(source, victim, damage);

		if (victim.level().isClientSide() || ModDamageSources.isAdditional(source) || !(source.getEntity() instanceof LivingEntity attacker))
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
			if (stack.getDamageValue() >= stack.getMaxDamage() - 1)
				this.onBroken(player);
			else if (!player.isCreative()) {
				if (victim.getArmorValue() >= 9 * (this.material.getAttackDamageBonus() + 1) || victim.isBlocking())
					stack.setDamageValue(stack.getDamageValue() + (int) ((0.6 + bonusdamage / 20) * victim.level().getRandom().nextDouble() * stack.getMaxDamage()));
				else
					stack.setDamageValue(stack.getDamageValue() + 1);
			}

			for (ItemStack stack0 : player.getInventory().items)
			{
				this.setRaised(player, true);
				player.getCooldowns().addCooldown(stack0.getItem(), (int) player.getCurrentItemAttackStrengthDelay());
			}

			if (stack.getDamageValue() >= stack.getMaxDamage())
			{
				this.onBroken(player);
				stack.setCount(0);
			}
		}

		Vec3 vec = attacker.getViewVector(1.0f);
		double magnitude = Math.min(1.0f, speed * this.getTotalMass(attacker) / this.getTotalMass(victim));
		Vec3 vel = vec.multiply(magnitude, magnitude, magnitude);
		
		if (victim.isPassenger())
		{
			victim.getRootVehicle().setDeltaMovement(victim.getRootVehicle().getDeltaMovement().add(vel));
			victim.getRootVehicle().hasImpulse = true;
			if (dismount)
				victim.stopRiding();
		}
		else
		{
			victim.setDeltaMovement(victim.getDeltaMovement().add(vel));
			victim.hasImpulse = true;
		}

		if (!super.onHurtEntity(source, victim, bonusdamage + damage) && bonusdamage != 0.0f)
		{
			victim.hurt(ModDamageSources.additional(attacker), bonusdamage + damage);
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
		if (EpicKnights.GENERAL_CONFIG.disableLanceCollision)
		{
			super.inventoryTick(stack, level, entity, i, selected);
			return;
		}

		if (entity instanceof Player player)
		{
			if (level.isClientSide && player.getMainHandItem().getItem() instanceof LanceItem)
			{
				HitResult hit = HitResultHelper.getMouseOver(Minecraft.getInstance(), CombatHelper.getAttackReach(player, this));
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
		float bonusdamage = 3.0f * this.getTotalMass(entity) * speed;
		return Math.min(Math.max(0.0f, bonusdamage), 0.7f * this.attackDamage);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag flag)
	{
		tooltip.add(Component.translatable("lance.rideronly").withStyle(ChatFormatting.BLUE));
		tooltip.add(Component.translatable("lance.leftclick").withStyle(ChatFormatting.BLUE));
		tooltip.add(Component.translatable("lance.bonusdamage").withStyle(ChatFormatting.BLUE));

		super.appendHoverText(stack, tooltipContext, tooltip, flag);
	}


	public float getVelocityProjection(Entity entity)
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


	public float getTotalMass(Entity entity)
	{
		float totalmass = this.getMass(entity);

		Entity entity2 = entity;
		while (entity2.isPassenger())
		{
			entity2 = entity2.getVehicle();
			totalmass += this.getMass(entity2);
		}

		for (Entity passenger : entity.getPassengers())
			totalmass += this.getMass(passenger);

		return totalmass;
	}


	public float getMass(Entity entity)
	{
		float mass = 0.0f;

		AABB box = entity.getBoundingBox();
		mass += (box.getXsize()) * (box.getYsize()) * (box.getZsize());

		if (entity instanceof LivingEntity livingentity) {
			for (ItemStack armorpiece : livingentity.getArmorSlots())
			{
				if (!armorpiece.isEmpty() && armorpiece.getItem() instanceof ArmorItem)
					mass += (((ArmorItem) armorpiece.getItem()).getDefense() + ((ArmorItem) armorpiece.getItem()).getToughness()) / 20.0;
			}
		}

		return mass;
	}

	public void onBroken(Player player)
	{
		if (player.getMainHandItem().getItem() == this)
		{
			for (ItemStack stack : this.dropItems)
				player.drop(stack, true);
			player.playSound(SoundEvents.ITEM_BREAK, 1.0f, 1.0f);
		}
	}

	@SuppressWarnings("ConstantConditions")
	public boolean isRaised(@Nullable LivingEntity entity)
	{
		if (entity == null)
			return false;
		
		ItemStack stack = entity.getMainHandItem();
		Integer raised = stack.get(ModDataComponents.RAISED.get());
		return raised != null && raised == 1;
	}

	public void setRaised(LivingEntity entity, boolean raised)
	{
		ItemStack stack = entity.getMainHandItem();
		stack.set(ModDataComponents.RAISED.get(), raised ? 1 : 0);
	}

	public boolean getDismount(ItemStack stack)
	{
		Boolean dismount = stack.get(ModDataComponents.DISMOUNT.get());
		return dismount != null ? dismount : false;
	}

	public void setDismount(ItemStack stack, boolean dismount)
	{
		stack.set(ModDataComponents.DISMOUNT.get(), dismount);
	}

	public float getRideSpeed(ItemStack stack)
	{
		Float speed = stack.get(ModDataComponents.RIDE_SPEED.get());
		return speed != null ? speed : 0.0f;
	}

	public void setRideSpeed(ItemStack stack, float speed)
	{
		stack.set(ModDataComponents.RIDE_SPEED.get(), speed);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void registerModelProperty()
	{
		ItemPropertiesRegistry.register(this, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "raised"), (stack, level, entity, i) -> this.isRaised(entity) ? 1 : 0);
	}
}