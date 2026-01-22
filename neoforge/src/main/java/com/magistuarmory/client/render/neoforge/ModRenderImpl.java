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
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.HashMap;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ModRenderImpl
{
	private static final Map<LivingEntityRenderer<?, ?>, ArmorDecorationLayer<?, ?>> ARMOR_DECORATION_LAYERS = new HashMap<>();
	private static final Map<LivingEntityRenderer<?, ?>, HorseArmorDecorationLayer> HORSE_ARMOR_DECORATION_LAYERS = new HashMap<>();

	public static <T extends LivingEntity, M extends HumanoidModel<T>> void addLayers(ModItemsProvider content, final EntityRenderersEvent.AddLayers ev)
	{
		if (content.armorDecorationItems.isEmpty())
			return;
		for (EntityType<?> entitytype : ev.getEntityTypes())
		{
			EntityRenderer<?> renderer = ev.getRenderer(entitytype);
			if (renderer instanceof LivingEntityRenderer<?, ?> renderer0 && renderer0.getModel() instanceof HumanoidModel) {
				LivingEntityRenderer<T, M> renderer1 = (LivingEntityRenderer<T, M>) renderer;
				addArmorDecorationLayer(renderer1, content, ev);
			}
			if (renderer instanceof HorseRenderer renderer0 && content instanceof ModItems)
				addHorseArmorDecorationLayer(renderer0, content, ev);
		}
		for (EntityRenderer<?> renderer : Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().values())
		{
			if (renderer instanceof PlayerRenderer renderer0)
				addArmorDecorationLayer(renderer0, content, ev);
		}
	}

	public static <T extends LivingEntity, M extends HumanoidModel<T>> void addArmorDecorationLayer(LivingEntityRenderer<T, M> renderer, ModItemsProvider content, final EntityRenderersEvent.AddLayers ev) {
		ArmorDecorationLayer<T, M> decorationLayer;
		if (!ARMOR_DECORATION_LAYERS.containsKey(renderer)) {
			decorationLayer = new ArmorDecorationLayer<>(new ArmorDecorationModelSet<>(), renderer, ev.getContext(), ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "surcoat"));
			renderer.addLayer(decorationLayer);
			ARMOR_DECORATION_LAYERS.put(renderer, decorationLayer);
		} else {
			decorationLayer = (ArmorDecorationLayer<T, M>) ARMOR_DECORATION_LAYERS.get(renderer);
		}
		decorationLayer.registerDecorations(content.armorDecorationItems, ev.getContext());
	}

	public static void addHorseArmorDecorationLayer(HorseRenderer renderer, ModItemsProvider content, final EntityRenderersEvent.AddLayers ev) {
		HorseArmorDecorationLayer decorationLayer;
		if (!HORSE_ARMOR_DECORATION_LAYERS.containsKey(renderer)) {
			decorationLayer = new HorseArmorDecorationLayer(renderer, ev.getContext(), ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "textures/entity/horse/armor/caparison.png"), "caparison");
			renderer.addLayer(decorationLayer);
			HORSE_ARMOR_DECORATION_LAYERS.put(renderer, decorationLayer);
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
