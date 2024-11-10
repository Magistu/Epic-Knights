package com.magistuarmory.forge;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.render.forge.ModRenderImpl;
import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import dev.architectury.utils.Env;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EpicKnights.ID)
public class EpicKnightsForge
{
    public EpicKnightsForge()
    {
        EventBuses.registerModEventBus(EpicKnights.ID, FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);

        EpicKnights.init();
    }
}
