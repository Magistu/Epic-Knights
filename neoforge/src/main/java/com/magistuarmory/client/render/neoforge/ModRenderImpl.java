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
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.HashMap;
import java.util.Map;

public class ModRenderImpl
{
	private static final Map<LivingEntityRenderer<?, ?, ?>, ArmorDecorationLayer<?, ?>> ARMOR_DECORATION_LAYERS = new HashMap<>();
	private static final Map<LivingEntityRenderer<?, ?, ?>, HorseArmorDecorationLayer> HORSE_ARMOR_DECORATION_LAYERS = new HashMap<>();

	public static <T extends HumanoidRenderState, M extends HumanoidModel<T>> void addLayers(ModItemsProvider content, final EntityRenderersEvent.AddLayers ev)
	{
		if (content.armorDecorationItems.isEmpty())
			return;
		for (EntityType<?> entitytype : ev.getEntityTypes())
		{
			EntityRenderer<?, ?> renderer = ev.getRenderer(entitytype);
			if (renderer instanceof LivingEntityRenderer<?, ?, ?> renderer0 && renderer0.getModel() instanceof HumanoidModel) {
				LivingEntityRenderer<?, T, M> renderer1 = (LivingEntityRenderer<?, T, M>) renderer;
				addArmorDecorationLayer(renderer1, content, ev);
			}
			if (renderer instanceof HorseRenderer renderer0 && content instanceof ModItems)
				addHorseArmorDecorationLayer(renderer0, content, ev);
		}
        for (var skin : ev.getSkins()) {
            var player = ev.getPlayerRenderer(skin);
            if (player != null) addArmorDecorationLayer(player, content, ev);
            var mannequin = ev.getMannequinRenderer(skin);
            if (mannequin != null) addArmorDecorationLayer(mannequin, content, ev);
        }
	}

	public static <T extends HumanoidRenderState, M extends HumanoidModel<T>> void addArmorDecorationLayer(LivingEntityRenderer<?, T, M> renderer, ModItemsProvider content, final EntityRenderersEvent.AddLayers ev) {
		ArmorDecorationLayer<T, M> decorationLayer;
		if (!ARMOR_DECORATION_LAYERS.containsKey(renderer)) {
			decorationLayer = new ArmorDecorationLayer<>(new ArmorDecorationModelSet<>(), renderer, ev.getContext(), Identifier.fromNamespaceAndPath(EpicKnights.ID, "surcoat"));
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
			decorationLayer = new HorseArmorDecorationLayer(renderer, ev.getContext(), Identifier.fromNamespaceAndPath(EpicKnights.ID, "textures/entity/horse/armor/caparison.png"), "caparison");
			renderer.addLayer(decorationLayer);
			HORSE_ARMOR_DECORATION_LAYERS.put(renderer, decorationLayer);
		}
	}

	public static void setupPlatform(ModItemsProvider content) {}

    private static void registerArmorExtensions(ModItemsProvider content) {
        EpicKnightsNeoForge.MOD_EVENT_BUS.addListener((net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent event) -> {
            for (var supplier : content.armorItems) {
                event.registerItem(new net.neoforged.neoforge.client.extensions.common.IClientItemExtensions() {
                    @Override
                    public net.minecraft.client.model.Model getHumanoidArmorModel(net.minecraft.world.item.ItemStack stack,
                            net.minecraft.client.resources.model.EquipmentClientInfo.LayerType layer, net.minecraft.client.model.Model original) {
                        if (stack.getItem() instanceof com.magistuarmory.item.armor.MedievalArmorItem armor && original instanceof HumanoidModel<?> humanoid)
                            return armor.getArmorModel(armor.getEquipmentSlot(), humanoid);
                        return original;
                    }
                }, supplier.get());
            }
        });
    }

	public static void registerModelsLoadListener(ModItemsProvider content)
	{
        registerModelCodecs();
        registerArmorExtensions(content);
		EpicKnightsNeoForge.MOD_EVENT_BUS.<EntityRenderersEvent.AddLayers>addListener(ev -> {
            prepareLayers(ev.getContext().getModelSet());
			ModRender.loadModels(content, ev.getContext());
			addLayers(content, ev);
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
        EpicKnightsNeoForge.MOD_EVENT_BUS.addListener((net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent event) -> event.register(Identifier.fromNamespaceAndPath(EpicKnights.ID, "property"), com.magistuarmory.client.render.ItemPropertiesRegistry.Property.CODEC));
        EpicKnightsNeoForge.MOD_EVENT_BUS.addListener((net.neoforged.neoforge.client.event.RegisterColorHandlersEvent.ItemTintSources event) -> event.register(Identifier.fromNamespaceAndPath(EpicKnights.ID, "item_tint"), com.magistuarmory.client.render.ItemTint.CODEC));
        EpicKnightsNeoForge.MOD_EVENT_BUS.addListener((net.neoforged.neoforge.client.event.RegisterSpecialModelRendererEvent event) -> event.register(Identifier.fromNamespaceAndPath(EpicKnights.ID, "heraldry"), HeraldryItemStackRenderer.Unbaked.CODEC));
    }

	public static HeraldryItemStackRenderer createHeraldryItemStackRenderer(String id, Identifier location)
	{
		return new HeraldryItemStackRenderer(id, location);
	}
}
