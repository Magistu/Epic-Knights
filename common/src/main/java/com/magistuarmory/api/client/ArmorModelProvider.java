package com.magistuarmory.api.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.magistuarmory.item.armor.DyeableMedievalArmorItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ArmorModelProvider implements DataProvider {

    private final PackOutput output;
    private final String modid;
    private final List<DyeableMedievalArmorItem> armors;

    public ArmorModelProvider(
            PackOutput output,
            String modid,
            List<DyeableMedievalArmorItem> armors
    ) {
        this.output = output;
        this.modid = modid;
        this.armors = armors;
    }

    @Override
    public @NotNull CompletableFuture<?> run(CachedOutput cache) {
        List<CompletableFuture<?>> futures = new ArrayList<>();

        for (DyeableMedievalArmorItem armor : armors) {
            ResourceLocation id = BuiltInRegistries.ITEM.getKey(armor);

            Path path = output.getOutputFolder()
                    .resolve("assets")
                    .resolve(id.getNamespace())
                    .resolve("equipment")
                    .resolve(id.getPath() + ".json");

            JsonObject root = createEquipmentModelJson(
                    id.getNamespace(),
                    id.getPath(),
                    armor.getDefaultColor()
            );

            futures.add(DataProvider.saveStable(cache, root, path));
        }

        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    private JsonObject createEquipmentModelJson(
            String namespace,
            String name,
            int defaultColor
    ) {
        JsonObject root = new JsonObject();
        JsonObject layers = new JsonObject();

        layers.add("humanoid", humanoidLayer(namespace, name, defaultColor));
        layers.add("humanoid_leggings", leggingsLayer(namespace, name, defaultColor));

        root.add("layers", layers);
        return root;
    }

    private JsonArray humanoidLayer(String ns, String name, int color) {
        JsonArray arr = new JsonArray();

        arr.add(texture(ns, "armor/" + name + "_outer"));
        arr.add(dyeableTexture(ns, "armor/" + name + "_outer_overlay", color));

        return arr;
    }

    private JsonArray leggingsLayer(String ns, String name, int color) {
        JsonArray arr = new JsonArray();

        arr.add(texture(ns, "armor/" + name + "_inner"));
        arr.add(dyeableTexture(ns, "armor/" + name + "_inner_overlay", color));

        return arr;
    }

    private JsonObject texture(String ns, String path) {
        JsonObject obj = new JsonObject();
        obj.addProperty("texture", ns + ":" + path);
        return obj;
    }

    private JsonObject dyeableTexture(String ns, String path, int color) {
        JsonObject obj = texture(ns, path);

        JsonObject dyeable = new JsonObject();
        dyeable.addProperty("color_when_undyed", color);

        obj.add("dyeable", dyeable);
        return obj;
    }

    @Override
    public @NotNull String getName() {
        return "Equipment Models";
    }
}