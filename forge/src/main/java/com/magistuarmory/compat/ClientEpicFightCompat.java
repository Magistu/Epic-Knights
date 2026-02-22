package com.magistuarmory.compat;

import com.magistuarmory.client.render.entity.layer.ArmorDecorationLayer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;
import yesman.epicfight.api.client.model.Meshes;
import yesman.epicfight.client.mesh.HumanoidMesh;
import yesman.epicfight.client.renderer.patched.entity.PatchedLivingEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class ClientEpicFightCompat {

    public static void register(IEventBus modBus) {
        modBus.<PatchedRenderersEvent.Modify>addListener((event) -> {
            for (EntityType<?> entityType : ForgeRegistries.ENTITY_TYPES) {
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