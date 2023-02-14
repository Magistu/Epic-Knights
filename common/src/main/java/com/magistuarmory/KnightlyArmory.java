package com.magistuarmory;

import com.magistuarmory.config.ServerConfig;
import com.magistuarmory.config.ServerConfigWrapper;
import com.magistuarmory.effects.ModEffects;
import com.magistuarmory.event.ClientEvents;
import com.magistuarmory.event.CommonEvents;
import com.magistuarmory.init.HeraldryPattern;
import com.magistuarmory.item.ModItems;
import com.magistuarmory.item.crafting.ModRecipes;
import com.magistuarmory.network.ModPackets;
import dev.architectury.platform.Platform;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.EnvType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KnightlyArmory
{
    public static boolean BC_or_EF_installed;
	public static final String ID = "magistuarmory";
    public static final Logger LOGGER = LogManager.getLogger();
    public static ServerConfig CONFIG;
    
    public static void init()
    {
        AutoConfig.register(ServerConfigWrapper.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
        CONFIG = AutoConfig.getConfigHolder(ServerConfigWrapper.class).getConfig().server;

        ModItems.init();
        ModEffects.init();
        ModPackets.init();
        CommonEvents.init();
        ModRecipes.init();
        if (Platform.getEnv() == EnvType.CLIENT)
            ClientEvents.init();
    }
    
    public static void checkBetterCombatOrEpicFightInstalled()
	{
        BC_or_EF_installed = Platform.isModLoaded("bettercombat") || Platform.isModLoaded("epicfight");
    }
}
