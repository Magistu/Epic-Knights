package com.magistuarmory.neoforge;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.effects.LacerationEffect;
import com.magistuarmory.effects.ModEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffectsNeoForge {
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, EpicKnights.ID);

	static {
		ModEffects.LACERATION = EFFECTS.register("laceration", LacerationEffect::new);
	}

	public static void init(IEventBus bus) {
		EFFECTS.register(bus);
	}
}
