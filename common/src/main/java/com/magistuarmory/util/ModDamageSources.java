package com.magistuarmory.util;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;

public class ModDamageSources
{
	private static DamageSource ADDITIONAL = new AdditionalDamageSource();
	
	public static void setup(RegistryAccess registryAccess)
	{
		
	}
	
	public static DamageSource additional()
	{
		return ADDITIONAL;
	}

	public static DamageSource additional(Entity attacker)
	{
		return attacker == null ? additional() : new AdditionalEntityDamageSource(attacker);
	}

	public static DamageSource silverAttack(Entity attacker)
	{
		return new SilverAttackDamageSource(attacker);
	}

	public static DamageSource armorPiercing(Entity attacker)
	{
		return new ArmorPiercingDamageSource(attacker);
	}

	public static boolean isAdditional(DamageSource source)
	{
		return source == DamageSource.GENERIC || source == DamageSource.MAGIC || source instanceof Additional;
	}

	interface Additional {}

	static class AdditionalDamageSource extends DamageSource implements Additional
	{
		AdditionalDamageSource()
		{
			super("additional");
		}
	}

	static class AdditionalEntityDamageSource extends EntityDamageSource implements Additional
	{
		AdditionalEntityDamageSource(Entity attacker)
		{
			super("entityAdditional", attacker);
		}
	}

	static class SilverAttackDamageSource extends EntityDamageSource implements Additional
	{
		SilverAttackDamageSource(Entity attacker)
		{
			super("silver", attacker);
			this.bypassArmor();
			this.setMagic();
		}
	}

	static class ArmorPiercingDamageSource extends EntityDamageSource implements Additional
	{
		ArmorPiercingDamageSource(Entity attacker)
		{
			super("armorPiercing", attacker);
			this.bypassArmor();
		}
	}
}
