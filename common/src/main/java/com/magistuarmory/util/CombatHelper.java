package com.magistuarmory.util;

import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.WeaponType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class CombatHelper
{
	public static float getAttackReach(Player player, MedievalWeaponItem weapon) 
	{
		return weapon.getAttackReach(getBaseAttackReach(player));
	}
	
	public static float getBaseAttackReach(Player player)
	{
		return player.isCreative() ? 5.0f : 4.5f;
	}

	public static float getBaseAttackDamage(ModItemTier material, WeaponType type)
	{
		return type.getBaseAttackDamage() + 1.6f * material.getAttackDamageBonus() / type.getBaseAttackSpeed();
	}

	public static float getBaseAttackSpeed(ModItemTier material, WeaponType type)
	{
		return type.getAttackSpeed(material) - 4;
	}

	public static float getDecreasedAttackDamage(ModItemTier material, WeaponType type)
	{
		return getDecreasedAttackDamage(getBaseAttackDamage(material, type), type);
	}

	public static float getDecreasedAttackSpeed(ModItemTier material, WeaponType type)
	{
		return getDecreasedAttackSpeed(getBaseAttackSpeed(material, type), type);
	}

	public static float getDecreasedAttackDamage(float baseattackdamage, WeaponType type)
	{
		return type.getTwoHanded() > 1 ? 14.0f * baseattackdamage / (3.0f * type.getTwoHanded() + 12.0f) : baseattackdamage;
	}

	public static float getDecreasedAttackSpeed(float baseattackspeed, WeaponType type)
	{
		return 14.0f * (baseattackspeed + 4.0f) / (5.0f * type.getTwoHanded() + 10.0f) - 4.0f;
	}

	public static float getSilverAttackDamage(ModItemTier material, WeaponType type)
	{
		return Math.round(6.0F / type.getAttackSpeed(material) * 100.0f) / 100.0f;
	}
	
	public static float getArmorPiercingFactor(Entity attacker)
	{
		float f = 1.0f;
		if (attacker instanceof LivingEntity livingentity)
		{
			if (livingentity.getMainHandItem().getItem() instanceof MedievalWeaponItem weapon)
			{
				float f2 = ((float) weapon.type.getArmorPiercing()) / 100.0f;
				f = f2 / (1.0f - f2);
			}
		}
		return f;
	}
	
	public static float getDamageAfterArmorAbsorb(DamageSource source, LivingEntity victim, float damage) 
	{
		if (!source.is(DamageTypeTags.BYPASSES_ARMOR))
			damage = CombatRules.getDamageAfterAbsorb(victim, damage, source, (float) victim.getArmorValue(), (float) victim.getAttributeValue(Attributes.ARMOR_TOUGHNESS));

		return damage;
	}

	public static float getDamageAfterMagicAbsorb(DamageSource source, LivingEntity victim, float damage) 
	{
		if (source.is(DamageTypeTags.BYPASSES_EFFECTS)) 
		{
			return damage;
		} 
		else 
		{
			float k;
			if (victim.hasEffect(MobEffects.RESISTANCE) && !source.is(DamageTypeTags.BYPASSES_RESISTANCE))
			{
				k = (victim.getEffect(MobEffects.RESISTANCE).getAmplifier() + 1.0f) * 5.0f;
				float j = 25 - k;
				float f = damage * j;
				float f1 = damage;
				damage = Math.max(f / 25.0F, 0.0F);
				float f2 = f1 - damage;
				if (f2 > 0.0F && f2 < 3.4028235E37F) 
				{
					if (victim instanceof ServerPlayer) 
					{
						((ServerPlayer) victim).awardStat(Stats.CUSTOM.get(Stats.DAMAGE_RESISTED), Math.round(f2 * 10.0F));
					} 
					else if (source.getEntity() instanceof ServerPlayer) 
					{
						((ServerPlayer) source.getEntity()).awardStat(Stats.CUSTOM.get(Stats.DAMAGE_DEALT_RESISTED), Math.round(f2 * 10.0F));
					}
				}
			}

			if (damage <= 0.0F)
			{
				return 0.0F;
			} 
			else if (source.is(DamageTypeTags.BYPASSES_ENCHANTMENTS)) 
			{
				return damage;
			} 
			else 
			{
				k = EnchantmentHelper.getDamageProtection((ServerLevel) victim.level(), victim, source);
				if (k > 0)
					damage = CombatRules.getDamageAfterMagicAbsorb(damage, k);

				return damage;
			}
		}
	}

	public static float getDamageAfterAbsorb(DamageSource source, LivingEntity victim, float damage)
	{
		if (!(victim.level() instanceof net.minecraft.server.level.ServerLevel serverLevel) || victim.isInvulnerableTo(serverLevel, source) || damage <= 0.0f)
			return 0.0f;

		damage = getDamageAfterArmorAbsorb(source, victim, damage);
		damage = getDamageAfterMagicAbsorb(source, victim, damage);
		float f1 = Math.max(damage - victim.getAbsorptionAmount(), 0.0f);
		victim.setAbsorptionAmount(victim.getAbsorptionAmount() - (damage - f1));
		float f = damage - f1;
		if (f > 0.0f && f < 3.4028235E37f) 
		{
			Entity entity = source.getEntity();
			if (entity instanceof ServerPlayer serverplayer)
			{
                serverplayer.awardStat(Stats.DAMAGE_DEALT_ABSORBED, Math.round(f * 10.0f));
			}
		}

		return f1;
	}

}
