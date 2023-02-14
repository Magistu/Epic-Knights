package com.magistuarmory.fabric;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.fabric.event.ClientEventsFabric;
import dev.architectury.platform.Platform;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;

public class KnightlyArmoryFabric implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        KnightlyArmory.init();
        if (Platform.getEnv() == EnvType.CLIENT)
            ClientEventsFabric.init();
    }
}
