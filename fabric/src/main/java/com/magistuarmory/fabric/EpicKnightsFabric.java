package com.magistuarmory.fabric;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.config.GeneralConfig;
import com.magistuarmory.item.ShieldTypes;
import com.magistuarmory.item.WeaponTypes;
import com.magistuarmory.item.armor.ArmorTypes;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraftforge.fml.config.ModConfig;

public class EpicKnightsFabric implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        ForgeConfigRegistry.INSTANCE.register(EpicKnights.ID, ModConfig.Type.SERVER, GeneralConfig.GENERAL_CONFIG, EpicKnights.ID + "/general-config.toml");
        ForgeConfigRegistry.INSTANCE.register(EpicKnights.ID, ModConfig.Type.SERVER, WeaponTypes.WEAPONS_CONFIG, EpicKnights.ID + "/weapons-config.toml");
        ForgeConfigRegistry.INSTANCE.register(EpicKnights.ID, ModConfig.Type.SERVER, ArmorTypes.ARMOR_CONFIG, EpicKnights.ID + "/armor-config.toml");
        ForgeConfigRegistry.INSTANCE.register(EpicKnights.ID, ModConfig.Type.SERVER, ShieldTypes.SHIELDS_CONFIG, EpicKnights.ID + "/shields-config.toml");
        EpicKnights.init();
    }
}
