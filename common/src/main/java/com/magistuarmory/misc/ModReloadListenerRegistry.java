package com.magistuarmory.misc;

import com.magistuarmory.EpicKnights;
import dev.architectury.registry.ReloadListenerRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;

public class ModReloadListenerRegistry {

    public static void init() {
        ReloadListenerRegistry.register(
                PackType.SERVER_DATA,
                new HeraldryReloadListener(),
                ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "heraldry")
        );
    }
}
