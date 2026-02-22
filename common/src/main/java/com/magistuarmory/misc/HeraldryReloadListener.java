package com.magistuarmory.misc;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Map;

public class HeraldryReloadListener extends SimpleJsonResourceReloadListener {

    public HeraldryReloadListener() {
        super(new Gson(), "heraldry");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> data,
                         ResourceManager manager,
                         ProfilerFiller profiler) {
        for (Map.Entry<ResourceLocation, JsonElement> entry : data.entrySet()) {
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
