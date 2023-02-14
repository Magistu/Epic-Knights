package com.magistuarmory.util;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;

public class ModDamageSource
{
	public static EntityDamageSource entityAttack(Entity attacker)
	{
		return new EntityDamageSource("entity", attacker);
	}
	
	public static DamageSource additional(Entity attacker)
	{
		return attacker == null ? new AdditionalDamageSource() : new AdditionalEntityDamageSource(attacker);
	}
	
	public static EntityDamageSource silverAttack(Entity attacker)
	{
		return new SilverAttackDamageSource(attacker);
	}

	public static EntityDamageSource armorPiercing(Entity attacker)
	{
		return new ArmorPiercingDamageSource(attacker);
	}

	public static boolean isAdditional(DamageSource source)
	{
		return source instanceof Additional;
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
