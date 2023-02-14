package com.magistuarmory.client.render.fabric;

import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.magistuarmory.fabric.client.render.entity.layer.MedievalArmorLayer;
import com.magistuarmory.fabric.client.render.tileentity.HeraldryItemStackRendererFabric;
import com.magistuarmory.item.ModItems;
import com.magistuarmory.item.armor.MedievalArmorItem;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.impl.client.rendering.ArmorRendererRegistryImpl;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

@Environment(EnvType.CLIENT)
public class ModRenderImpl
{
	public static void setupPlatform()
	{
		for (RegistrySupplier<MedievalArmorItem> supplier : ModItems.armorItems)
		{
			ArmorRendererRegistryImpl.register(new MedievalArmorLayer(), supplier.get());
		}
		
		for (ModItems.ShieldsSupply shields : ModItems.shieldsSupply)
		{
			shields.get().forEach(supplier -> 
					BuiltinItemRendererRegistry.INSTANCE.register(supplier.get(), (BuiltinItemRendererRegistry.DynamicItemRenderer) supplier.get().getRenderer()));
		}
	}

	public static BlockEntityWithoutLevelRenderer getHeraldryItemStackRenderer(String id, String name, Models.ShieldEnum modelkey)
	{
		return new HeraldryItemStackRendererFabric(id, name, Models.SHIELD_MAP.get(modelkey));
	}
}
