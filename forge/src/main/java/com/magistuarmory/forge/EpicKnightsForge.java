package com.magistuarmory.forge;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.render.forge.ModRenderImpl;
import com.magistuarmory.forge.misc.HeraldryPatterns;
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

        if (Platform.getEnvironment() == Env.CLIENT)
        {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::addLayers);
        }
        HeraldryPatterns.init();
        EpicKnights.init();
    }

    public void addLayers(final EntityRenderersEvent.AddLayers ev)
    {
        ModRenderImpl.addLayers(ev);
    }
}
