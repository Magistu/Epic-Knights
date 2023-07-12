package com.magistuarmory.client.render.fabric;

import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.fabric.client.render.entity.layer.MedievalArmorLayer;
import com.magistuarmory.fabric.client.render.tileentity.HeraldryItemStackRendererFabric;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.ModItems;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.impl.client.rendering.ArmorRendererRegistryImpl;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;

@Environment(EnvType.CLIENT)
public class ModRenderImpl
{
	public static void setupPlatform()
	{
		for (RegistrySupplier<? extends Item> supplier : ModItems.ARMOR_ITEMS)
		{
			ArmorRendererRegistryImpl.register(new MedievalArmorLayer(), supplier.get());
		}
		
		for (RegistrySupplier<MedievalShieldItem> supplier : ModItems.SHIELD_ITEMS)
		{
			BuiltinItemRendererRegistry.INSTANCE.register(supplier.get(), (BuiltinItemRendererRegistry.DynamicItemRenderer) supplier.get().getRenderer());
		}
	}

	public static BlockEntityWithoutLevelRenderer getHeraldryItemStackRenderer(String id, String name, Models.ShieldEnum modelkey)
	{
		return new HeraldryItemStackRendererFabric(id, name, Models.SHIELD_MAP.get(modelkey));
	}
}
