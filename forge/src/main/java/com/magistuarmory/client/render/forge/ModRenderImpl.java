package com.magistuarmory.client.render.forge;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.render.ModRender;
import com.magistuarmory.client.render.entity.layer.ArmorDecorationLayer;
import com.magistuarmory.client.render.entity.layer.HorseArmorDecorationLayer;
import com.magistuarmory.client.render.model.decoration.ArmorDecorationModelSet;
import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.magistuarmory.api.item.ModItemsProvider;
import com.magistuarmory.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@OnlyIn(Dist.CLIENT)
public class ModRenderImpl
{
	public static void addLayers(ModItemsProvider content, final EntityRenderersEvent.AddLayers ev)
	{
		if (content.armorDecorationItems.isEmpty())
			return;
		for (EntityRenderer<?> renderer : Minecraft.getInstance().getEntityRenderDispatcher().renderers.values())
		{
			if (renderer instanceof LivingEntityRenderer renderer0 && renderer0.getModel() instanceof HumanoidModel)
				renderer0.addLayer(new ArmorDecorationLayer(new ArmorDecorationModelSet<>(content.armorDecorationItems, ev.getContext()), renderer0, ev.getContext(), new ResourceLocation(EpicKnights.ID, "surcoat")));
			if (renderer instanceof HorseRenderer renderer0 && content instanceof ModItems)
				renderer0.addLayer(new HorseArmorDecorationLayer(renderer0, ev.getContext(), new ResourceLocation(EpicKnights.ID, "textures/entity/horse/armor/caparison.png"), "caparison"));
		}
		for (EntityRenderer<?> renderer : Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().values())
		{
			if (renderer instanceof PlayerRenderer renderer0)
				renderer0.addLayer(new ArmorDecorationLayer(new ArmorDecorationModelSet<>(content.armorDecorationItems, ev.getContext()), renderer0, ev.getContext(), new ResourceLocation(EpicKnights.ID, "surcoat")));
		}
	}

	public static void setupPlatform(ModItemsProvider content) {}

	public static void registerModelsLoadListener(ModItemsProvider content)
	{
		FMLJavaModLoadingContext.get().getModEventBus().<EntityRenderersEvent.AddLayers>addListener(ev -> {
			ModRender.loadModels(content, ev.getContext());
			addLayers(content, ev);
		});
	}

	public static HeraldryItemStackRenderer createHeraldryItemStackRenderer(String id, ResourceLocation location)
	{
		return new HeraldryItemStackRenderer(id, location);
	}
}
