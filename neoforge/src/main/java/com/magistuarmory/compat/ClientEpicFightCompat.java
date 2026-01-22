package com.magistuarmory.compat;

import com.magistuarmory.client.render.entity.layer.ArmorDecorationLayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import yesman.epicfight.api.client.event.EpicFightClientEventHooks;
import yesman.epicfight.api.client.model.Meshes;
import yesman.epicfight.client.mesh.HumanoidMesh;
import yesman.epicfight.client.renderer.patched.entity.PatchedLivingEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class ClientEpicFightCompat {

    public static void register(IEventBus modBus) {
        EpicFightClientEventHooks.Registry.MODIFY_PATCHED_ENTITY.registerEvent(event -> {
            for (EntityType<?> entityType : BuiltInRegistries.ENTITY_TYPE) {
                if (event.get(entityType) instanceof PatchedLivingEntityRenderer renderer && renderer.getDefaultMesh().get() instanceof HumanoidMesh) {
                    renderer.addPatchedLayerAlways(ArmorDecorationLayer.class, new PatchedArmorDecorationLayer<>(Meshes.BIPED));
                }
            }
        });

        modBus.<EntityRenderersEvent.AddLayers>addListener((event) -> {
            PatchedArmorDecorationLayer.clearModels();
        });
    }
}