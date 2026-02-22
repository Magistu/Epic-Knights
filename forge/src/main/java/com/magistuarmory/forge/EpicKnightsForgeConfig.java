package com.magistuarmory.forge;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.config.GeneralConfig;
import com.magistuarmory.item.ShieldTypes;
import com.magistuarmory.item.WeaponTypes;
import com.magistuarmory.item.armor.ArmorTypes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EpicKnights.ID + "config")
public class EpicKnightsForgeConfig {
    public EpicKnightsForgeConfig() {
        FMLJavaModLoadingContext ctx = FMLJavaModLoadingContext.get();
        ctx.registerConfig(ModConfig.Type.SERVER, GeneralConfig.GENERAL_CONFIG, EpicKnights.ID + "/general-config.toml");
        ctx.registerConfig(ModConfig.Type.SERVER, WeaponTypes.WEAPONS_CONFIG, EpicKnights.ID + "/weapons-config.toml");
        ctx.registerConfig(ModConfig.Type.SERVER, ArmorTypes.ARMOR_CONFIG, EpicKnights.ID + "/armor-config.toml");
        ctx.registerConfig(ModConfig.Type.SERVER, ShieldTypes.SHIELDS_CONFIG, EpicKnights.ID + "/shields-config.toml");
    }
}
