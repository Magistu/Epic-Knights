package com.magistuarmory.forge;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.render.forge.ModRenderImpl;
import com.magistuarmory.forge.init.HeraldryPatterns;
import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import dev.architectury.utils.Env;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(KnightlyArmory.ID)
public class KnightlyArmoryForge
{
    public KnightlyArmoryForge()
    {
        EventBuses.registerModEventBus(KnightlyArmory.ID, FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::addLayers);
        KnightlyArmory.init();
        HeraldryPatterns.init();
    }

    public void addLayers(final EntityRenderersEvent.AddLayers ev)
    {
        if (Platform.getEnvironment() == Env.CLIENT)
        {
            ModRenderImpl.addLayers(ev);
        }
    }
}
