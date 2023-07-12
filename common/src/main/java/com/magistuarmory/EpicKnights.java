package com.magistuarmory;

import com.magistuarmory.block.ModBlocks;
import com.magistuarmory.config.GeneralConfig;
import com.magistuarmory.config.ModConfig;
import com.magistuarmory.effects.ModEffects;
import com.magistuarmory.block.ModBlockEntityTypes;
import com.magistuarmory.event.ClientEvents;
import com.magistuarmory.event.CommonEvents;
import com.magistuarmory.misc.ModCreativeTabs;
import com.magistuarmory.item.ModItems;
import com.magistuarmory.item.crafting.ModRecipes;
import com.magistuarmory.network.ModPackets;
import dev.architectury.platform.Platform;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.EnvType;


public class EpicKnights
{
    public static boolean BC_or_EF_installed;
	public static final String ID = "magistuarmory";
    public static ModConfig CONFIG;
    public static GeneralConfig GENERAL_CONFIG;
    
    public static void init()
    {
        AutoConfig.register(ModConfig.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
        CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        GENERAL_CONFIG = CONFIG.general;

        ModItems.init();
        ModCreativeTabs.init();
        ModEffects.init();
        ModPackets.init();
        ModRecipes.init();
        ModBlocks.init();
        ModBlockEntityTypes.init();
        CommonEvents.init();
        if (Platform.getEnv() == EnvType.CLIENT)
            ClientEvents.init();
    }
    
    public static void checkBetterCombatOrEpicFightInstalled()
	{
        BC_or_EF_installed = Platform.isModLoaded("bettercombat") || Platform.isModLoaded("epicfight");
    }
}
