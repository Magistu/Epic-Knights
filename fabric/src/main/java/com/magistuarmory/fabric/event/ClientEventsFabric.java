package com.magistuarmory.fabric.event;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.render.entity.layer.ArmorDecorationLayer;
import com.magistuarmory.client.render.entity.layer.HorseArmorDecorationLayer;
import com.magistuarmory.client.render.model.Models;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

@Environment(EnvType.CLIENT)
public class ClientEventsFabric
{
    public static void init()
    {
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register(ClientEventsFabric::addLayer);
    }

    static void addLayer(EntityType<? extends LivingEntity> entitytype, LivingEntityRenderer<?, ?> renderer, LivingEntityFeatureRendererRegistrationCallback.RegistrationHelper helper, EntityRendererProvider.Context context)
    {
        if (renderer.getModel() instanceof HumanoidModel)
        {
            helper.register(new ArmorDecorationLayer(renderer));
        }
        else if (renderer instanceof HorseRenderer renderer0)
        {
            helper.register(new HorseArmorDecorationLayer(renderer0, Models.CAPARISON, new ResourceLocation(EpicKnights.ID, "textures/entity/horse/armor/caparison.png"), "caparison"));
        }
        else if (renderer instanceof PlayerRenderer renderer0)
        {
            helper.register(new ArmorDecorationLayer(renderer0));
        }
    }
}
