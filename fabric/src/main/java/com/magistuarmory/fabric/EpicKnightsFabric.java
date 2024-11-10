package com.magistuarmory.fabric;

import com.magistuarmory.EpicKnights;
import net.fabricmc.api.ModInitializer;

public class EpicKnightsFabric implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        EpicKnights.init();
    }
}
