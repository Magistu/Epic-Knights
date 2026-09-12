package com.magistuarmory.misc;

import com.magistuarmory.EpicKnights;
import dev.architectury.registry.ReloadListenerRegistry;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;

public class ModReloadListenerRegistry {

    public static void init() {
        ReloadListenerRegistry.register(
                PackType.SERVER_DATA,
                new HeraldryReloadListener(),
                Identifier.fromNamespaceAndPath(EpicKnights.ID, "heraldry")
        );
    }
}
