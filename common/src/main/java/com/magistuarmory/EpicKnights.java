package com.magistuarmory;

import com.magistuarmory.block.ModBlocks;
import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.effects.ModEffects;
import com.magistuarmory.block.ModBlockEntityTypes;
import com.magistuarmory.event.ClientEvents;
import com.magistuarmory.event.CommonEvents;
import com.magistuarmory.misc.ModBannerPatterns;
import com.magistuarmory.misc.ModCreativeTabs;
import com.magistuarmory.item.ModItems;
import com.magistuarmory.item.crafting.ModRecipes;
import com.magistuarmory.misc.ModReloadListenerRegistry;
import com.magistuarmory.network.ModPackets;
import dev.architectury.platform.Platform;
import net.fabricmc.api.EnvType;


public class EpicKnights
{
    public static boolean BC_or_EF_installed;
	public static final String ID = "magistuarmory";
    
    public static void init()
    {
        ModEffects.init();
        ModPackets.init();
        ModRecipes.init();
        ModBannerPatterns.init();
        ModBlocks.init();
        ModBlockEntityTypes.init();
        CommonEvents.init();
        if (Platform.getEnv() == EnvType.CLIENT)
        {
            ClientEvents.init();
            ModModels.INSTANCE.init(ModItems.INSTANCE);
        }

        ModItems.INSTANCE.init();
        ModCreativeTabs.init();
        ModReloadListenerRegistry.init();
    }
    
    public static void checkBetterCombatOrEpicFightInstalled()
	{
        BC_or_EF_installed = Platform.isModLoaded("bettercombat") || Platform.isModLoaded("epicfight");
    }
}
