package com.magistuarmory.client.render.fabric;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.api.item.ModItemsProvider;
import com.magistuarmory.block.ModBlockEntityTypes;
import com.magistuarmory.client.render.ModRender;
import com.magistuarmory.client.render.entity.layer.ArmorDecorationLayer;
import com.magistuarmory.client.render.entity.layer.HorseArmorDecorationLayer;
import com.magistuarmory.client.render.model.decoration.ArmorDecorationModelSet;
import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.magistuarmory.client.render.tileentity.PaviseBlockRenderer;
import com.magistuarmory.fabric.client.render.entity.layer.MedievalArmorLayer;
import com.magistuarmory.fabric.client.render.tileentity.HeraldryItemStackRendererFabric;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.ModItems;
import com.magistuarmory.item.PaviseItem;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

@Environment(EnvType.CLIENT)
public class ModRenderImpl
{
	private static void addLayers(ModItemsProvider content, EntityType<? extends LivingEntity> entitytype, LivingEntityRenderer<?, ?> renderer, LivingEntityFeatureRendererRegistrationCallback.RegistrationHelper helper, EntityRendererProvider.Context context)
	{
		if (content.armorDecorationItems.isEmpty())
			return;
		if (renderer.getModel() instanceof HumanoidModel)
			helper.register(new ArmorDecorationLayer(new ArmorDecorationModelSet<>(content.armorDecorationItems, context), renderer, context, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "surcoat")));
		else if (renderer instanceof PlayerRenderer renderer0)
			helper.register(new ArmorDecorationLayer(new ArmorDecorationModelSet<>(content.armorDecorationItems, context), renderer0, context, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "surcoat")));
		if (renderer instanceof HorseRenderer renderer0 && content instanceof ModItems)
			helper.register(new HorseArmorDecorationLayer(renderer0, context, ResourceLocation.fromNamespaceAndPath(content.modId, "textures/entity/horse/armor/caparison.png"), "caparison"));

	}

	public static void setupPlatform(ModItemsProvider content)
	{
		MedievalArmorLayer layer = new MedievalArmorLayer();
		for (RegistrySupplier<? extends Item> supplier : content.armorItems)
			ArmorRenderer.register(layer, supplier.get());

		for (RegistrySupplier<? extends MedievalShieldItem> supplier : content.shieldItems)
		{
			MedievalShieldItem shield = supplier.get();
			if (supplier.get().is3d())
				BuiltinItemRendererRegistry.INSTANCE.register(supplier.get(), (BuiltinItemRendererRegistry.DynamicItemRenderer) shield.getRenderer());
		}
	}

	public static void registerModelsLoadListener(ModItemsProvider content)
	{
		LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entitytype, renderer, helper, context) -> {
			ModRender.loadModels(content, context);
			addLayers(content, entitytype, renderer, helper, context);
		});
	}

	public static HeraldryItemStackRenderer createHeraldryItemStackRenderer(String id, ResourceLocation location)
	{
		return new HeraldryItemStackRendererFabric(id, location);
	}
}
