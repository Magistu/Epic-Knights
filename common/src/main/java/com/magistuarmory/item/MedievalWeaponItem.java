package com.magistuarmory.item;


import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;
import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.effects.LacerationEffect;
import com.magistuarmory.network.PacketLongReachAttack;
import com.magistuarmory.util.CombatHelper;
import com.magistuarmory.util.ModDamageSource;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class MedievalWeaponItem extends SwordItem implements IHasModelProperty
{
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;

	public final WeaponType type;
	protected final float attackDamage;
	protected final float attackSpeed;
	private final float decreasedAttackDamage;
	private final float decreasedAttackSpeed;
	private boolean isSilver = false;
	private float silverAttackDamage = 0.0f;
	private boolean blockingPriority = false;

	public MedievalWeaponItem(Properties properties, ModItemTier material, WeaponType type)
	{
		super(material, (int) CombatHelper.getBaseAttackDamage(material, type), CombatHelper.getBaseAttackSpeed(material, type), properties.durability(type.getDurability(material)));
		this.type = type;
		this.attackDamage = CombatHelper.getBaseAttackDamage(material, type);
		this.attackSpeed = CombatHelper.getBaseAttackSpeed(material, type);
		this.decreasedAttackDamage = CombatHelper.getDecreasedAttackDamage(this.attackDamage, type);
		this.decreasedAttackSpeed = CombatHelper.getDecreasedAttackSpeed(this.attackSpeed, type);
		if (material.equals(ModItemTier.SILVER))
		{
			this.isSilver = true;
			this.silverAttackDamage = CombatHelper.getSilverAttackDamage(material, type);
		}
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackDamage, Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", this.attackSpeed, Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}

	public boolean onAttackClickEntity(ItemStack stack, Player player, Entity entity)
	{
		if (!this.isLong())
			return true;
		
		if (entity != player && entity != player.getVehicle())
			PacketLongReachAttack.sendToServer(entity.getId());
		
		player.resetAttackStrengthTicker();

		return false;
	}
	
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(ItemStack stack, @NotNull EquipmentSlot slot)
	{
		if (slot == EquipmentSlot.MAINHAND)
		{
			Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.getAttackDamage(stack), Operation.ADDITION));
			builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", this.getAttackSpeed(stack), Operation.ADDITION));
			return builder.build();
		}

		return this.getDefaultAttributeModifiers(slot);
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot)
	{
		return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean selected)
	{
		if (entity instanceof LivingEntity livingentity)
		{
			boolean flag = false;
			if (type.getTwoHanded() > 0 && !livingentity.getOffhandItem().getItem().equals(Items.AIR)) 
			{
				if (this.getAttackDamage(stack) != this.decreasedAttackDamage)
				{
					this.setAttackDamage(stack, this.decreasedAttackDamage);
					flag = true;
				}
				if (this.getAttackSpeed(stack) != this.decreasedAttackSpeed)
				{
					this.setAttackSpeed(stack, this.decreasedAttackSpeed);
					flag = true;
				}
			}
			else
			{
				if (this.getAttackDamage(stack) != this.attackDamage)
				{
					this.setAttackDamage(stack, this.attackDamage);
					flag = true;
				}
				if (this.getAttackSpeed(stack) != this.attackSpeed)
				{
					this.setAttackSpeed(stack, this.attackSpeed);
					flag = true;
				}
			}
			if (flag) 
			{
				ItemStack itemstack = ((LivingEntity) entity).getMainHandItem();

				for (EquipmentSlot slot : EquipmentSlot.values()) 
				{
					livingentity.getAttributes().removeAttributeModifiers(itemstack.getAttributeModifiers(slot));
					livingentity.getAttributes().addTransientAttributeModifiers(itemstack.getAttributeModifiers(slot));
				}
			}
			if (this.canBlock()) 
			{
				this.blockingPriority = !(livingentity.getMainHandItem().getItem() instanceof ShieldItem) && !(livingentity.getOffhandItem().getItem() instanceof ShieldItem);
			}
		}
		super.inventoryTick(stack, level, entity, i, selected);
	}

	public boolean onHurtEntity(DamageSource source, LivingEntity victim, float damage)
	{
		if (victim.level.isClientSide() || ModDamageSource.isAdditional(source) || !(source.getEntity() instanceof LivingEntity attacker))
			return true;
		
		if (type.isFlamebladed())
			LacerationEffect.apply(victim, damage);
		
		if (type.isHalberd() && victim.isPassenger() && victim.level.getRandom().nextInt(20) >= 14)
			victim.stopRiding();
		
		boolean flag = false;
		if (this.isSilver())
			flag = this.dealSilverDamage(attacker, victim, damage);
		if (!flag && this.type.getArmorPiercing() != 0 && victim.getArmorValue() > 0)
			flag = this.dealArmorPiercingDamage(attacker, victim, damage);
		return flag;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag)
	{
		if (this.isSilver)
			tooltip.add(new TextComponent("+" + this.getSilverDamage(stack, this.getAttackDamage(stack)) + " ").append(new TranslatableComponent("silvertools.hurt")).withStyle(ChatFormatting.GREEN));
		if (type.isFlamebladed())
			tooltip.add(new TranslatableComponent("flamebladed.hurt").withStyle(ChatFormatting.BLUE));
		if (type.isHalberd())
			tooltip.add(new TranslatableComponent("halberd.hurt").withStyle(ChatFormatting.BLUE));
		if (type.getArmorPiercing() != 0)
			tooltip.add(new TextComponent(type.getArmorPiercing() + "% ").append(new TranslatableComponent("armorpiercing")).withStyle(ChatFormatting.BLUE));
		if (this.isLong())
			tooltip.add(new TextComponent("+" + type.getBonusAttackReach() + " ").append(new TranslatableComponent("bonusattackreach")).withStyle(ChatFormatting.BLUE));
		if (type.getTwoHanded() == 1)
			tooltip.add(new TranslatableComponent("twohandedi").withStyle(ChatFormatting.BLUE));
		else if (type.getTwoHanded() > 1)
			tooltip.add(new TranslatableComponent("twohandedii").withStyle(ChatFormatting.BLUE));
		if (this.canBlock())
			tooltip.add(new TextComponent(getMaxBlockDamage() + " ").append(new TranslatableComponent("maxdamageblock")).withStyle(ChatFormatting.BLUE));
		tooltip.add(new TextComponent(getWeight() + "").append(new TranslatableComponent("kgweight")).withStyle(ChatFormatting.BLUE));
		if (this.hasTwoHandedPenalty(stack))
		{
			tooltip.add(new TranslatableComponent("twohandedpenalty_1").withStyle(ChatFormatting.RED));
			tooltip.add(new TranslatableComponent("twohandedpenalty_2").withStyle(ChatFormatting.RED));
		}
	}

	public float getAttackDamage(ItemStack stack)
	{
		if (stack.hasTag())
		{
			CompoundTag nbt = stack.getTag();
			if (nbt.contains("currentAttackDamage")) 
				return nbt.getFloat("currentAttackDamage");
		}
		
		return this.attackDamage;
	}

	public float getAttackSpeed(ItemStack stack)
	{
		if (stack.hasTag())
		{
			CompoundTag nbt = stack.getTag();
			if (nbt.contains("currentAttackSpeed"))
				return nbt.getFloat("currentAttackSpeed");
		}

		return this.attackSpeed;
	}

	public void setAttackDamage(ItemStack stack, float attackdamage)
	{
		CompoundTag nbt = stack.getOrCreateTag();
		nbt.putFloat("currentAttackDamage", attackdamage);
		stack.setTag(nbt);
	}

	public void setAttackSpeed(ItemStack stack, float attackspeed)
	{
		CompoundTag nbt = stack.getOrCreateTag();
		nbt.putFloat("currentAttackSpeed", attackspeed);
		stack.setTag(nbt);
	}
	
	@Override
	public float getDamage()
	{
		return this.attackDamage;
	}

	public float getAttackReach(float baseReach)
	{
		return baseReach + getBonusAttackReach();
	}

	public float getBonusAttackReach()
	{
		return KnightlyArmory.BC_or_EF_installed ? 0.0f : type.getBonusAttackReach();
	}
	
	public boolean isLong()
	{
		return this.getBonusAttackReach() > 0.0;
	}

	public float getSilverDamage(ItemStack stack, float damage)
	{
		return this.silverAttackDamage * damage / this.getAttackDamage(stack);
	}

	public float getMaxBlockDamage()
	{
		return type.getMaxBlockDamage();
	}

	public float getWeight()
	{
		return type.getWeight();
	}

	public boolean isSilver()
	{
		return this.isSilver;
	}

	public boolean canBlock(Player player)
	{
		return player.getAttackStrengthScale(0.0f) == 1.0f && this.canBlock();
	}

	public boolean canBlock()
	{
		return type.canBlock();
	}

	boolean haveBlocked(Random rand, DamageSource source)
	{
		return !source.isProjectile() && rand.nextInt(18) > this.getWeight();
	}
	
	public boolean hasTwoHandedPenalty(ItemStack stack)
	{
		return this.type.getTwoHanded() > 0 && this.getAttackSpeed(stack) == this.decreasedAttackSpeed;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
	{
		if (canBlock(player) && blockingPriority)
		{
			ItemStack stack = player.getItemInHand(hand);
			player.startUsingItem(hand);

			return InteractionResultHolder.consume(stack);
		}

		return super.use(level, player, hand);
	}

	public int getUseDuration(ItemStack stack)
	{
		return this.canBlock() ? (int) (500 / this.getWeight()) : 0;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack)
	{
		return (canBlock() && blockingPriority) ? UseAnim.BLOCK : super.getUseAnimation(stack);
	}

	public void onBlocked(ItemStack stack, float damage, LivingEntity victim, DamageSource source)
	{
		if (!this.canBlock() || ModDamageSource.isAdditional(source))
			return;

		Entity attacker = source.getEntity();
		float f = CombatHelper.getArmorPiercingFactor(attacker);

		if (source.isExplosion())
		{
			victim.hurt(ModDamageSource.additional(), damage);
		}
		else if (!haveBlocked(victim.level.getRandom(), source))
		{
			victim.hurt(ModDamageSource.additional(), damage);
		}
		else if (damage > this.getMaxBlockDamage())
		{
			f *= 1.5f;
			float damage1 = damage - getMaxBlockDamage();
			victim.hurt(ModDamageSource.additional(), damage1);
		}

		stack.hurtAndBreak((int) (f * damage), victim, entity -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
	}

	public boolean dealSilverDamage(LivingEntity attacker, LivingEntity victim, float damage)
	{
		if (victim.getMobType().equals(MobType.UNDEAD))
		{
			victim.hurt(ModDamageSource.silverAttack(attacker), damage + this.getSilverDamage(attacker.getMainHandItem(), damage));
			return true;
		}
		return false;
	}

	public boolean dealArmorPiercingDamage(LivingEntity attacker, LivingEntity victim, float damage)
	{
		float afterabsorb = CombatRules.getDamageAfterAbsorb(damage, (float) victim.getArmorValue(), (float) victim.getAttributeValue(Attributes.ARMOR_TOUGHNESS));
		afterabsorb = Math.max(afterabsorb - victim.getAbsorptionAmount(), 0.0f);
		float pierced = Math.max(((float) type.getArmorPiercing()) / 100.0f * (damage - afterabsorb), 0.0f);
		victim.hurt(ModDamageSource.armorPiercing(attacker), afterabsorb + pierced);
		return true;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void registerModelProperty()
	{
		if (this.canBlock())
		{
			ItemPropertiesRegistry.register(this, new ResourceLocation("blocking"), (stack, level, entity, i) ->
					entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
		}
	}
}
