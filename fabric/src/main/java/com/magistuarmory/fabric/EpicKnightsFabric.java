package com.magistuarmory.fabric;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.fabric.event.ClientEventsFabric;
import dev.architectury.platform.Platform;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;

public class EpicKnightsFabric implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        EpicKnights.init();
        if (Platform.getEnv() == EnvType.CLIENT)
            ClientEventsFabric.init();
    }
}
