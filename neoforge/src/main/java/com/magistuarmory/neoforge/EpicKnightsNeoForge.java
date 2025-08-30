package com.magistuarmory.neoforge;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.event.ClientEvents;
import com.magistuarmory.item.ModItems;
import dev.architectury.platform.Platform;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(EpicKnights.ID)
public class EpicKnightsNeoForge
{
    public static IEventBus MOD_EVENT_BUS;
    
    public EpicKnightsNeoForge(IEventBus modEventBus)
    {
        MOD_EVENT_BUS = modEventBus;
        EpicKnights.init();
    }
}
