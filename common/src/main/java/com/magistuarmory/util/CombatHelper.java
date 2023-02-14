package com.magistuarmory.util;

import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.WeaponType;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class CombatHelper
{
	public static float getReachDistance(Player player, MedievalWeaponItem weapon) 
	{
		return weapon.getReachDistance(getBaseReachDistance(player));
	}
	
	public static float getBaseReachDistance(Player player)
	{
		return player.isCreative() ? 5.0f : 4.5f;
	}

	public static float getBaseAttackDamage(ModItemTier material, WeaponType type)
	{
		return type.baseAttackDamage + 1.6f * material.getAttackDamageBonus() / type.getAttackSpeed(material);
	}

	public static float getBaseAttackSpeed(ModItemTier material, WeaponType type)
	{
		return type.getAttackSpeed(material) - 4;
	}

	public static float getDecreasedAttackDamage(float baseattackdamage, WeaponType type)
	{
		return type.twoHanded > 1 ? 14.0f * baseattackdamage / (3.0f * type.twoHanded + 12.0f) : baseattackdamage;
	}

	public static float getDecreasedAttackSpeed(float baseattackspeed, WeaponType type)
	{
		return 14.0f * (baseattackspeed + 4.0f) / (5.0f * type.twoHanded + 10.0f) - 4.0f;
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
				float f2 = ((float) weapon.type.armorPiercing) / 100.0f;
				f = f2 / (1.0f - f2);
			}
		}
		return f;
	}

}
