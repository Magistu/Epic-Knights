package com.magistuarmory.item;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.effects.LacerationEffect;
import com.magistuarmory.component.ModDataComponents;
import com.magistuarmory.util.CombatHelper;
import com.magistuarmory.util.ModDamageSources;
import com.magistuarmory.client.render.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import java.util.List;


public class MedievalWeaponItem extends Item implements IHasModelProperty
{
	public static final Identifier BASE_ENTITY_INTERACTION_RANGE_ID = Identifier.fromNamespaceAndPath(EpicKnights.ID, "base_entity_interaction_range_id");

	private final ItemAttributeModifiers defaultModifiers;
	private final ItemAttributeModifiers decreasedModifiers;

	public final WeaponType type;
	protected final float attackDamage;
	private boolean isSilver = false;
	private float silverAttackDamage = 0.0f;

	public MedievalWeaponItem(Properties properties, ModItemTier material, WeaponType type)
	{
		super(material.asToolMaterial().applySwordProperties(type.canBlock() ? MedievalShieldItem.blockingProperties(properties) : properties, 0, 0).stacksTo(1).durability(type.getDurability(material)).attributes(createDefaultAttributeModifiersBuilder(material, type).build()));
		this.type = type;
		this.attackDamage = CombatHelper.getBaseAttackDamage(material, type);

		if (material.equals(ModItemTier.SILVER))
		{
			this.isSilver = true;
			this.silverAttackDamage = CombatHelper.getSilverAttackDamage(material, type);
		}

		this.defaultModifiers = createDefaultAttributeModifiersBuilder(material, type).build();
		this.decreasedModifiers = createDecreasedAttributeModifiersBuilder(material, type).build();
	}

	public static ItemAttributeModifiers.Builder createDefaultAttributeModifiersBuilder(ModItemTier material, WeaponType type) {
		return createAttributeModifiersBuilder(CombatHelper.getBaseAttackDamage(material, type), CombatHelper.getBaseAttackSpeed(material, type), type.getBonusAttackReach());
	}

	public static ItemAttributeModifiers.Builder createDecreasedAttributeModifiersBuilder(ModItemTier material, WeaponType type) {
		return createAttributeModifiersBuilder(CombatHelper.getDecreasedAttackDamage(material, type), CombatHelper.getDecreasedAttackSpeed(material, type), type.getBonusAttackReach());
	}

	public static ItemAttributeModifiers.Builder createAttributeModifiersBuilder(float damage, float speed, float reach) 
	{
		ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
		builder.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, damage, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
		builder.add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, speed, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
		builder.add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, reach, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
		return builder;
	}

	public boolean onAttackClickEntity(ItemStack stack, Player player, Entity entity)
	{
		return true;
	}
	
	public ItemAttributeModifiers getAttributeModifiers(ItemStack stack)
	{
		return this.hasTwoHandedPenalty(stack) ? this.decreasedModifiers : this.defaultModifiers;
	}

	@Override
	public void inventoryTick(ItemStack stack, net.minecraft.server.level.ServerLevel level, Entity entity, net.minecraft.world.entity.EquipmentSlot slot)
	{
		if (entity instanceof LivingEntity livingentity)
		{
			boolean penalty = this.type.getTwoHanded() > 0 && !livingentity.getOffhandItem().getItem().equals(Items.AIR);
			if (this.hasTwoHandedPenalty(stack) != penalty)
			{
				stack.set(ModDataComponents.TWO_HANDED_PENALTY.get(), penalty ? this.type.getTwoHanded() : 0);
				stack.set(DataComponents.ATTRIBUTE_MODIFIERS, this.getAttributeModifiers(stack));
			}
			
		}
		super.inventoryTick(stack, level, entity, slot);
	}

	public boolean onHurtEntity(DamageSource source, LivingEntity victim, float damage)
	{
		if (victim.level().isClientSide() || ModDamageSources.isAdditional(source) || !(source.getEntity() instanceof LivingEntity attacker))
			return true;
		
		float attackscale = source.getEntity() instanceof LivingEntity livingentity ? damage / this.getAttackDamage(livingentity.getMainHandItem()) : 1.0f;
		
		if (type.isHalberd() && victim.isPassenger() && victim.level().getRandom().nextInt(20) * attackscale >= 14)
			victim.stopRiding();
		
		boolean flag = false;
		if (this.isSilver())
			flag = this.dealSilverDamage(source, attacker, victim, damage, attackscale);
		if (!flag && this.type.getArmorPiercing() != 0 && victim.getArmorValue() > 0)
			flag = this.dealArmorPiercingDamage(source, attacker, victim, damage);

		if (type.isFlamebladed())
			LacerationEffect.apply(source, victim, damage * attackscale);

		postHurtEnemy(attacker.getWeaponItem(), attacker, victim);
		return flag;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> tooltip, TooltipFlag flag)
	{
		if (this.isSilver)
			tooltip.accept(Component.translatable("silvertools.hurt", this.silverAttackDamage).withStyle(ChatFormatting.GREEN));
		if (type.isFlamebladed())
			tooltip.accept(Component.translatable("flamebladed.hurt").withStyle(ChatFormatting.BLUE));
		if (type.isHalberd())
			tooltip.accept(Component.translatable("halberd.hurt").withStyle(ChatFormatting.BLUE));
		if (type.getArmorPiercing() != 0)
			tooltip.accept(Component.translatable("armorpiercing", this.type.getArmorPiercing()).withStyle(ChatFormatting.BLUE));
		if (this.isLong())
			tooltip.accept(Component.translatable("bonusattackreach", this.type.getBonusAttackReach()).withStyle(ChatFormatting.BLUE));
		if (type.getTwoHanded() == 1)
			tooltip.accept(Component.translatable("twohandedi").withStyle(ChatFormatting.BLUE));
		else if (type.getTwoHanded() > 1)
			tooltip.accept(Component.translatable("twohandedii").withStyle(ChatFormatting.BLUE));
		if (this.canBlock())
			tooltip.accept(Component.translatable("maxdamageblock", this.getMaxBlockDamage()).withStyle(ChatFormatting.BLUE));
		tooltip.accept(Component.translatable("kgweight", this.getWeight()).withStyle(ChatFormatting.BLUE));
		if (this.hasTwoHandedPenalty(stack))
		{
			tooltip.accept(Component.translatable("twohandedpenalty_1").withStyle(ChatFormatting.RED));
			tooltip.accept(Component.translatable("twohandedpenalty_2").withStyle(ChatFormatting.RED));
		}
		super.appendHoverText(stack, tooltipContext, display, tooltip, flag);
	}

	public boolean hasTwoHandedPenalty(ItemStack stack)
	{
		Integer value = stack.get(ModDataComponents.TWO_HANDED_PENALTY.get());
		return value != null && value > 0;
	}

	public float getAttackDamage(ItemStack stack)
	{
		return (float) this.getAttributeModifiers(stack).modifiers().stream().filter(m -> m.modifier().id().equals(BASE_ATTACK_DAMAGE_ID)).findFirst().orElseThrow().modifier().amount();
	}

	public float getAttackReach(float baseReach)
	{
		return baseReach + getBonusAttackReach();
	}

	public float getBonusAttackReach()
	{
		return EpicKnights.BC_or_EF_installed ? 0.0f : type.getBonusAttackReach();
	}
	
	public boolean isLong()
	{
		return this.getBonusAttackReach() > 0.0;
	}

	@Deprecated(forRemoval = true)
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

	boolean haveBlocked(RandomSource rand, DamageSource source)
	{
		return source.isDirect() && rand.nextInt(18) > this.getWeight();
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand)
	{
		if (canBlock(player) && !(player.getMainHandItem().getItem() instanceof ShieldItem) && !(player.getOffhandItem().getItem() instanceof ShieldItem))
		{
			ItemStack stack = player.getItemInHand(hand);
			player.startUsingItem(hand);

			return InteractionResult.CONSUME;
		}

		return InteractionResult.PASS;
	}

	@Override
	public int getUseDuration(ItemStack stack, LivingEntity entity)
	{
		return this.canBlock() ? (int) (500 / this.getWeight()) : 0;
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack stack)
	{
		return canBlock() ? ItemUseAnimation.BLOCK : super.getUseAnimation(stack);
	}

	public void onBlocked(ItemStack stack, float damage, LivingEntity victim, DamageSource source)
	{
		if (!this.canBlock() || ModDamageSources.isAdditional(source))
			return;

		Entity attacker = source.getEntity();
		float f = CombatHelper.getArmorPiercingFactor(attacker);

		if (source.is(DamageTypes.PLAYER_EXPLOSION) || source.is(DamageTypes.EXPLOSION))
		{
			victim.hurt(ModDamageSources.additional(), damage);
		}
		else if (!haveBlocked(victim.level().getRandom(), source))
		{
			victim.hurt(ModDamageSources.additional(), damage);
		}
		else if (damage > this.getMaxBlockDamage())
		{
			f *= 1.5f;
			float damage1 = damage - getMaxBlockDamage();
			victim.hurt(ModDamageSources.additional(), damage1);
		}

		stack.hurtAndBreak((int) (f * damage), victim, EquipmentSlot.MAINHAND);
	}

	public boolean dealSilverDamage(DamageSource source, LivingEntity attacker, LivingEntity victim, float damage, float attackscale)
	{
		if (victim.getType().builtInRegistryHolder().is(EntityTypeTags.UNDEAD))
		{
			victim.hurt(ModDamageSources.silverAttack(attacker), CombatHelper.getDamageAfterAbsorb(source, victim, this.silverAttackDamage) * attackscale + damage);
			return true;
		}
		return false;
	}

	public boolean dealArmorPiercingDamage(DamageSource source, LivingEntity attacker, LivingEntity victim, float damage)
	{
		float afterabsorb = CombatHelper.getDamageAfterAbsorb(source, victim, damage);
		afterabsorb = Math.max(afterabsorb - victim.getAbsorptionAmount(), 0.0f);
		float pierced = Math.max(((float) type.getArmorPiercing()) / 100.0f * (damage - afterabsorb), 0.0f);
		victim.hurt(ModDamageSources.armorPiercing(attacker), damage + pierced);
		return true;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void registerModelProperty()
	{
		if (this.canBlock())
		{
			ItemPropertiesRegistry.register(this, Identifier.withDefaultNamespace("blocking"), (stack, level, entity, i) ->
					entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
		}
	}
}
