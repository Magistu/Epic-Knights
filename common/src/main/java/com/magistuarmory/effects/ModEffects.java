package com.magistuarmory.effects;

import com.magistuarmory.EpicKnights;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;


public class ModEffects {
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(EpicKnights.ID, Registries.MOB_EFFECT);

	public static Holder<MobEffect> LACERATION;

	public static void init() {
		if (Platform.isFabric()) {
			LACERATION = EFFECTS.register("laceration", LacerationEffect::new);
			EFFECTS.register();
		}
	}
}
