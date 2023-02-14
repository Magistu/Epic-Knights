package com.magistuarmory.client.render.forge;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.render.entity.layer.ArmorDecorationLayer;
import com.magistuarmory.client.render.entity.layer.HorseArmorDecorationLayer;
import com.magistuarmory.client.render.model.*;
import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
public class ModRenderImpl
{
	public static void addLayers(final EntityRenderersEvent.AddLayers ev)
	{
		for (EntityRenderer<?> renderer : Minecraft.getInstance().getEntityRenderDispatcher().renderers.values())
		{
			if (renderer instanceof LivingEntityRenderer renderer0 && renderer0.getModel() instanceof HumanoidModel)
			{
				renderer0.addLayer(new ArmorDecorationLayer(renderer0, Models.SURCOAT, new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/surcoat.png"), "surcoat"));
			}
			if (renderer instanceof HorseRenderer renderer0)
			{
				renderer0.addLayer(new HorseArmorDecorationLayer(renderer0, Models.CAPARISON, new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/caparison.png"), "caparison"));
			}
		}
		for (EntityRenderer<?> renderer : Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().values())
		{
			if (renderer instanceof PlayerRenderer renderer0)
			{
				renderer0.addLayer(new ArmorDecorationLayer(renderer0, Models.SURCOAT, new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/surcoat.png"), "surcoat"));
			}
		}
	}

	public static void setupPlatform() {}

	public static BlockEntityWithoutLevelRenderer getHeraldryItemStackRenderer(String id, String name, Models.ShieldEnum modelkey)
	{
		return new HeraldryItemStackRenderer(id, name, Models.SHIELD_MAP.get(modelkey));
	}
}
