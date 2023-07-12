package com.magistuarmory.effects;

import com.magistuarmory.EpicKnights;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;

public class ModEffects
{
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(EpicKnights.ID, Registry.MOB_EFFECT_REGISTRY);

	public static final RegistrySupplier<LacerationEffect> LACERATION = EFFECTS.register("laceration", () -> LacerationEffect.INSTANCE);

	public static void init()
	{
		EFFECTS.register();
	}
}
