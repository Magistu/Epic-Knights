package com.magistuarmory.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;

public class LacerationEffect extends MobEffect 
{
	public static LacerationEffect INSTANCE = new LacerationEffect();
	
	public LacerationEffect() 
	{
		super(MobEffectCategory.HARMFUL, -10092544);
		addAttributeModifier(Attributes.MAX_HEALTH, "81AEAA56-376B-4498-935B-2F7F68070635", -2.0f, Operation.ADDITION);
	}

	@Override
	public String getDescriptionId() { return "effect.laceration"; }

	@Override
	public boolean isBeneficial() {
		return false;
	}

	@Override
	public boolean isInstantenous() {
		return false;
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMapIn, int amplifier) {
		super.addAttributeModifiers(entity, attributeMapIn, amplifier);
		if (entity.getHealth() > entity.getMaxHealth())
		{
			entity.setHealth(entity.getMaxHealth());
		}
	}
	
	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMapIn, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMapIn, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
	
	@Override
	public double getAttributeModifierValue(int amplifier, AttributeModifier modifier) {
		return -amplifier;
	}
	
	public static void apply(LivingEntity victim, float damage)
	{
		if (victim instanceof Creeper)
			return;
		
		if (victim.hasEffect(LacerationEffect.INSTANCE))
		{
			MobEffectInstance effect = victim.getEffect(LacerationEffect.INSTANCE);
			int amplifier = effect.getAmplifier();
			int duration = effect.getDuration();
			victim.removeEffect(LacerationEffect.INSTANCE);
			victim.addEffect(new MobEffectInstance(LacerationEffect.INSTANCE, duration + (int) (damage * 100), amplifier + (int) damage, true, true, true));
		}
		else
		{
			victim.addEffect(new MobEffectInstance(LacerationEffect.INSTANCE, (int) (damage * 50), (int) (0.5 * damage), true, true, true));
		}
	}
}
