package com.magistuarmory.neoforge;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.compat.ClientEpicFightCompat;
import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(EpicKnights.ID)
public class EpicKnightsNeoForge
{
    public static IEventBus MOD_EVENT_BUS;
    
    public EpicKnightsNeoForge(IEventBus modEventBus)
    {
        MOD_EVENT_BUS = modEventBus;
        ModEffectsNeoForge.init(modEventBus);
        EpicKnights.init();
        if (Platform.getEnvironment() == Env.CLIENT && Platform.isModLoaded("epicfight")) {
            ClientEpicFightCompat.register(modEventBus);
        }
    }
}
