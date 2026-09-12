package com.magistuarmory.misc;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Map;

public class HeraldryReloadListener extends SimpleJsonResourceReloadListener<JsonElement> {

    public HeraldryReloadListener() {
        super(com.mojang.serialization.Codec.PASSTHROUGH.xmap(d -> d.convert(com.mojang.serialization.JsonOps.INSTANCE).getValue(), j -> new com.mojang.serialization.Dynamic<>(com.mojang.serialization.JsonOps.INSTANCE, j)), net.minecraft.resources.FileToIdConverter.json("heraldry"));
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> data,
                         ResourceManager manager,
                         ProfilerFiller profiler) {
        for (Map.Entry<Identifier, JsonElement> entry : data.entrySet()) {
            if (entry.getKey().getPath().equals("banner_patterns")) {
                for (Map.Entry<String, JsonElement> entry2 : entry.getValue().getAsJsonObject().entrySet()) {
                    if (entry2.getKey().equals("values")) {
                        for (JsonElement element : entry2.getValue().getAsJsonArray()) {
                            HeraldryRegistry.register(element.getAsString());
                        }
                    }
                }
            }
        }
    }
}
