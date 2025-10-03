package com.magistuarmory.effects;

import com.magistuarmory.EpicKnights;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;

public class ModEffects
{
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(EpicKnights.ID, Registries.MOB_EFFECT);

	public static final RegistrySupplier<MobEffect> LACERATION = EFFECTS.register("magistuarmory_laceration", LacerationEffect::new);

	public static final RegistrySupplier<MobEffect> LACERATION_OLD = EFFECTS.register("laceration", LacerationEffect::new);

	public static void init()
	{
		EFFECTS.register();
	}
}
