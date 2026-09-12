package com.magistuarmory.client.render.fabric;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.api.item.ModItemsProvider;
import com.magistuarmory.client.render.ModRender;
import com.magistuarmory.client.render.entity.layer.ArmorDecorationLayer;
import com.magistuarmory.client.render.entity.layer.HorseArmorDecorationLayer;
import com.magistuarmory.client.render.model.decoration.ArmorDecorationModelSet;
import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.magistuarmory.fabric.client.render.entity.layer.MedievalArmorLayer;
import com.magistuarmory.fabric.client.render.tileentity.HeraldryItemStackRendererFabric;
import com.magistuarmory.item.ModItems;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityRenderLayerRegistrationCallback;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class ModRenderImpl
{
	private static final Map<LivingEntityRenderer<?, ?, ?>, ArmorDecorationLayer<?, ?>> ARMOR_DECORATION_LAYERS = new HashMap<>();
	private static final Map<LivingEntityRenderer<?, ?, ?>, HorseArmorDecorationLayer> HORSE_ARMOR_DECORATION_LAYERS = new HashMap<>();

	static <T extends HumanoidRenderState, M extends HumanoidModel<T>> void addLayers(ModItemsProvider content, EntityType<? extends LivingEntity> entitytype, LivingEntityRenderer<?, ?, ?> renderer, LivingEntityRenderLayerRegistrationCallback.RegistrationHelper helper, EntityRendererProvider.Context context)
	{
		if (content.armorDecorationItems.isEmpty())
			return;

		if (renderer.getModel() instanceof HumanoidModel) {
			LivingEntityRenderer<?, T, M> renderer0 = (LivingEntityRenderer<?, T, M>) renderer;
			addArmorDecorationLayer(renderer0, content, context, helper);
		}

		if (renderer instanceof HorseRenderer renderer0 && content instanceof ModItems)
			addHorseArmorDecorationLayer(renderer0, content, context, helper);
	}

	public static <T extends HumanoidRenderState, M extends HumanoidModel<T>> void addArmorDecorationLayer(LivingEntityRenderer<?, T, M> renderer, ModItemsProvider content, EntityRendererProvider.Context context, LivingEntityRenderLayerRegistrationCallback.RegistrationHelper helper) {
		ArmorDecorationLayer<T, M> decorationLayer;
		if (!ARMOR_DECORATION_LAYERS.containsKey(renderer)) {
			decorationLayer = new ArmorDecorationLayer<>(new ArmorDecorationModelSet<>(), renderer, context, Identifier.fromNamespaceAndPath(EpicKnights.ID, "surcoat"));
			helper.register(decorationLayer);
			ARMOR_DECORATION_LAYERS.put(renderer, decorationLayer);
		} else {
			decorationLayer = (ArmorDecorationLayer<T, M>) ARMOR_DECORATION_LAYERS.get(renderer);
		}
		decorationLayer.registerDecorations(content.armorDecorationItems, context);
	}

	public static void addHorseArmorDecorationLayer(HorseRenderer renderer, ModItemsProvider content, EntityRendererProvider.Context context, LivingEntityRenderLayerRegistrationCallback.RegistrationHelper helper) {
		HorseArmorDecorationLayer decorationLayer;
		if (!HORSE_ARMOR_DECORATION_LAYERS.containsKey(renderer)) {
			decorationLayer = new HorseArmorDecorationLayer(renderer, context, Identifier.fromNamespaceAndPath(EpicKnights.ID, "textures/entity/horse/armor/caparison.png"), "caparison");
			// Fabric's helper requires an exact model-state type; HorseModel accepts the EquineRenderState superclass.
			helper.register((net.minecraft.client.renderer.entity.layers.RenderLayer) decorationLayer);
			HORSE_ARMOR_DECORATION_LAYERS.put(renderer, decorationLayer);
		}
	}

	public static void setupPlatform(ModItemsProvider content)
	{
        for (RegistrySupplier<? extends Item> supplier : content.armorItems)
            ArmorRenderer.register(context -> new MedievalArmorLayer(context), supplier.get());

	}

	public static void registerModelsLoadListener(ModItemsProvider content)
	{
        registerModelCodecs();
		LivingEntityRenderLayerRegistrationCallback.EVENT.register((entitytype, renderer, helper, context) -> {
            prepareLayers(context.getModelSet());
			ModRender.loadModels(content, context);
			addLayers(content, entitytype, renderer, helper, context);
		});
	}

    private static net.minecraft.client.model.geom.EntityModelSet layerModelSet;
    private static void prepareLayers(net.minecraft.client.model.geom.EntityModelSet modelSet) {
        if (layerModelSet != modelSet) {
            layerModelSet = modelSet;
            ARMOR_DECORATION_LAYERS.clear();
            HORSE_ARMOR_DECORATION_LAYERS.clear();
        }
    }

    private static boolean codecsRegistered;
    public static void registerModelCodecs() {
        if (codecsRegistered) return;
        codecsRegistered = true;
        net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperties.ID_MAPPER.put(Identifier.fromNamespaceAndPath(EpicKnights.ID, "property"), com.magistuarmory.client.render.ItemPropertiesRegistry.Property.CODEC);
        net.minecraft.client.color.item.ItemTintSources.ID_MAPPER.put(Identifier.fromNamespaceAndPath(EpicKnights.ID, "item_tint"), com.magistuarmory.client.render.ItemTint.CODEC);
        net.minecraft.client.renderer.special.SpecialModelRenderers.ID_MAPPER.put(Identifier.fromNamespaceAndPath(EpicKnights.ID, "heraldry"), HeraldryItemStackRenderer.Unbaked.CODEC);
    }

	public static HeraldryItemStackRenderer createHeraldryItemStackRenderer(String id, Identifier location)
	{
		return new HeraldryItemStackRendererFabric(id, location);
	}
}
