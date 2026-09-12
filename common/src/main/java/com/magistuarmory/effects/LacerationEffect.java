package com.magistuarmory.effects;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.util.CombatHelper;
import net.minecraft.resources.Identifier;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import org.jetbrains.annotations.NotNull;

public class LacerationEffect extends MobEffect 
{	
	public LacerationEffect()
	{
		super(MobEffectCategory.HARMFUL, -10092544);
		addAttributeModifier(Attributes.MAX_HEALTH, Identifier.fromNamespaceAndPath(EpicKnights.ID, "laceration"), -2.0f, Operation.ADD_VALUE);
	}

	@Override
	public @NotNull String getDescriptionId()
	{
		return "effect.laceration";
	}

	@Override
	public boolean isBeneficial()
	{
		return false;
	}

	@Override
	public boolean applyEffectTick(net.minecraft.server.level.ServerLevel level, LivingEntity victim, int i)
	{
		if (victim.getHealth() > victim.getMaxHealth())
		{
			victim.setHealth(victim.getMaxHealth());
			return true;
		}
		return false;
	}

	public static void apply(DamageSource source, LivingEntity victim, float damage)
	{
		damage = CombatHelper.getDamageAfterAbsorb(source, victim, damage);

		if (victim instanceof Creeper)
			return;
		
		int amplifier = Math.min((int) damage, 2);
		int duration = (int) (damage * 50);

		if (victim.hasEffect(ModEffects.LACERATION))
		{
			MobEffectInstance effect = victim.getEffect(ModEffects.LACERATION);
			amplifier = Math.max(effect.getAmplifier(), amplifier);
			duration = Math.max(effect.getDuration(), duration);
			victim.removeEffect(ModEffects.LACERATION);
		}
		
		victim.addEffect(new MobEffectInstance(ModEffects.LACERATION, duration, amplifier, true, true, true));
	}
}
