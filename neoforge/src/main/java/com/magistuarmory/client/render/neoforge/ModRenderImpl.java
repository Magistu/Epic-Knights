package com.magistuarmory.client.render.neoforge;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.api.item.ModItemsProvider;
import com.magistuarmory.client.render.ModRender;
import com.magistuarmory.client.render.entity.layer.ArmorDecorationLayer;
import com.magistuarmory.client.render.entity.layer.HorseArmorDecorationLayer;
import com.magistuarmory.client.render.model.decoration.ArmorDecorationModelSet;
import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.magistuarmory.item.ModItems;
import com.magistuarmory.neoforge.EpicKnightsNeoForge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
public class ModRenderImpl
{
	public static void addLayers(ModItemsProvider content, final EntityRenderersEvent.AddLayers ev)
	{
		if (content.armorDecorationItems.isEmpty())
			return;
		for (EntityType<?> entitytype : ev.getEntityTypes())
		{
			EntityRenderer<?> renderer = ev.getRenderer(entitytype);
			if (renderer instanceof LivingEntityRenderer renderer0 && renderer0.getModel() instanceof HumanoidModel)
				renderer0.addLayer(new ArmorDecorationLayer(new ArmorDecorationModelSet<>(content.armorDecorationItems, ev.getContext()), renderer0, ev.getContext(), ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "surcoat")));
			if (renderer instanceof HorseRenderer renderer0 && content instanceof ModItems)
				renderer0.addLayer(new HorseArmorDecorationLayer(renderer0, ev.getContext(), ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "textures/entity/horse/armor/caparison.png"), "caparison"));
		}
		for (EntityRenderer<?> renderer : Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().values())
		{
			if (renderer instanceof PlayerRenderer renderer0)
				renderer0.addLayer(new ArmorDecorationLayer(new ArmorDecorationModelSet<>(content.armorDecorationItems, ev.getContext()), renderer0, ev.getContext(), ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "surcoat")));
		}
	}

	public static void setupPlatform(ModItemsProvider content) {}

	public static void registerModelsLoadListener(ModItemsProvider content)
	{
		EpicKnightsNeoForge.MOD_EVENT_BUS.<EntityRenderersEvent.AddLayers>addListener(ev -> {
			ModRender.loadModels(content, ev.getContext());
			addLayers(content, ev);
		});
	}

	public static HeraldryItemStackRenderer createHeraldryItemStackRenderer(String id, ResourceLocation location)
	{
		return new HeraldryItemStackRenderer(id, location);
	}
}
