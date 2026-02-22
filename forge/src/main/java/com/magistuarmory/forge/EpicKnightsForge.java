package com.magistuarmory.forge;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.compat.ClientEpicFightCompat;
import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import dev.architectury.utils.Env;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EpicKnights.ID)
public class EpicKnightsForge {
    public EpicKnightsForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(EpicKnights.ID, modBus);

        MinecraftForge.EVENT_BUS.register(this);
        if (Platform.getEnvironment() == Env.CLIENT && Platform.isModLoaded("epicfight")) {
            ClientEpicFightCompat.register(modBus);
        }

        EpicKnights.init();
    }
}
