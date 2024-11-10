package com.magistuarmory.effects;

import com.magistuarmory.util.CombatHelper;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LacerationEffect extends MobEffect 
{
	public static LacerationEffect INSTANCE = new LacerationEffect();
	
	public LacerationEffect()
	{
		super(MobEffectCategory.HARMFUL, -10092544);
		addAttributeModifier(Attributes.MAX_HEALTH, "81AEAA56-376B-4498-935B-2F7F68070635", -2.0f, Operation.ADDITION);
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

	public void applyEffectTick(LivingEntity victim, int i) 
	{
		if (victim.getHealth() > victim.getMaxHealth())
			victim.setHealth(victim.getMaxHealth());
	}

	public static void apply(DamageSource source, LivingEntity victim, float damage)
	{
		damage = CombatHelper.getDamageAfterAbsorb(source, victim, damage);

		if (victim instanceof Creeper)
			return;
		
		int amplifier = Math.min((int) damage, 2);
		int duration = (int) (damage * 50);

		if (victim.hasEffect(LacerationEffect.INSTANCE))
		{
			MobEffectInstance effect = victim.getEffect(LacerationEffect.INSTANCE);
			amplifier = Math.max(effect.getAmplifier(), amplifier);
			duration = Math.max(effect.getDuration(), duration);
			victim.removeEffect(LacerationEffect.INSTANCE);
		}
		
		victim.addEffect(new MobEffectInstance(LacerationEffect.INSTANCE, duration, amplifier, true, true, true));
	}
}
