package com.magistuarmory.api.client.render.model;

import com.magistuarmory.api.item.ModItemsProvider;
import com.magistuarmory.client.render.ModRender;
import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


@Environment(EnvType.CLIENT)
public abstract class ModModelsProvider
{
	public final String modId;
	
	public final Map<ModelLayerLocation, Supplier<LayerDefinition>> layers = new HashMap<>();
	
	public ModModelsProvider(String modId)
	{
		this.modId = modId;
	}
	
	public ModelLayerLocation addDecorationModel(String name, Supplier<LayerDefinition> definition)
	{
		ModelLayerLocation location = this.createDecorationLocation(name);
		layers.put(location, definition);
		return location;
	}

	public ModelLayerLocation addArmorModel(String name, Supplier<LayerDefinition> definition)
	{
		ModelLayerLocation location = this.createArmorLocation(name);
		layers.put(location, definition);
		return location;
	}

	public ModelLayerLocation addModel(String name, Supplier<LayerDefinition> definition)
	{
		ModelLayerLocation location = this.createLocation(name);
		layers.put(location, definition);
		return location;
	}

	public ModelLayerLocation createDecorationLocation(String name)
	{
		return createDecorationLocation(ResourceLocation.fromNamespaceAndPath(this.modId, name));
	}

	public ModelLayerLocation createArmorLocation(String name)
	{
		return createArmorLocation(ResourceLocation.fromNamespaceAndPath(this.modId, name));
	}
	
	public ModelLayerLocation createLocation(String name)
	{
		return createLocation(ResourceLocation.fromNamespaceAndPath(this.modId, name));
	}

	public ModelLayerLocation createLocation(String name, String layer)
	{
		return createLocation(ResourceLocation.fromNamespaceAndPath(this.modId, name), layer);
	}

	public static ModelLayerLocation createDecorationLocation(ResourceLocation location)
	{
		return createLocation(location, "decorations");
	}

	public static ModelLayerLocation createArmorLocation(ResourceLocation location)
	{
		return createLocation(location, "armor");
	}

	public static ModelLayerLocation createLocation(ResourceLocation location)
	{
		return createLocation(location, "main");
	}

	public static ModelLayerLocation createLocation(ResourceLocation location, String layer)
	{
		return new ModelLayerLocation(location, layer);
	}

	public void init(ModItemsProvider content)
	{
		this.layers.forEach(EntityModelLayerRegistry::register);
		ModRender.registerModelsLoadListener(content);
	}
}
