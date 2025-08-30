package com.magistuarmory.util;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;

public class ModDamageSources
{
	private static Registry<DamageType> DAMAGE_TYPES;
	
	private static DamageSource ADDITIONAL;
	
	public static void setup(RegistryAccess registryAccess)
	{
		DAMAGE_TYPES = registryAccess.registryOrThrow(Registries.DAMAGE_TYPE);
		ADDITIONAL = new DamageSource(DAMAGE_TYPES.getHolderOrThrow(ModDamageTypes.ADDITIONAL));
	}
	
	public static DamageSource additional()
	{
		return ADDITIONAL;
	}

	public static DamageSource additional(Entity attacker)
	{
		return attacker == null ? additional() : new DamageSource(DAMAGE_TYPES.getHolderOrThrow(ModDamageTypes.ENTITY_ADDITIONAL), attacker);
	}

	public static DamageSource silverAttack(Entity attacker)
	{
		return new DamageSource(DAMAGE_TYPES.getHolderOrThrow(ModDamageTypes.SILVER), attacker);
	}

	public static DamageSource armorPiercing(Entity attacker)
	{
		return new DamageSource(DAMAGE_TYPES.getHolderOrThrow(ModDamageTypes.ARMOR_PIERCING), attacker);
	}

	public static boolean isAdditional(DamageSource source) throws NullPointerException
	{
		if (source == null)
			throw new NullPointerException("Got a null damage source");
		return	source.is(DamageTypes.GENERIC) ||
				source.is(DamageTypes.MAGIC) ||
				source.is(ModDamageTypes.ADDITIONAL) || 
				source.is(ModDamageTypes.ENTITY_ADDITIONAL) || 
				source.is(ModDamageTypes.SILVER) || 
				source.is(ModDamageTypes.ARMOR_PIERCING);
	}
}
