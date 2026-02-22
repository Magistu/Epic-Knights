package com.magistuarmory.client.render.model.decoration;

import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.item.ArmorDecoration;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class ArmorDecorationModelSet<T extends LivingEntity>
{
    final Map<ModelLayerLocation, ArmorDecorationModel<T>> map = new HashMap<>();

    public void registerDecorations(List<RegistrySupplier<? extends ArmorDecoration>> decorations, EntityRendererProvider.Context context) {
        for (Supplier<? extends ArmorDecoration> supplier : decorations)
        {
            ModelLayerLocation location = supplier.get().createModelLocation();
            this.map.putIfAbsent(location, new ArmorDecorationModel<>(context.bakeLayer(location)));
        }
    }

    public ArmorDecorationModel<T> get(ModelLayerLocation location)
    {
        return this.map.get(location);
    }

    public ArmorDecorationModel<T> get(ResourceLocation location)
    {
        return this.get(ModModels.createDecorationLocation(location));
    }
}
