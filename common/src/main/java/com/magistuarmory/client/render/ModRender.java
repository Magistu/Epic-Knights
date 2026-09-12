package com.magistuarmory.client.render;

import com.magistuarmory.api.item.ModItemsProvider;
import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.client.render.model.item.MedievalShieldModel;
import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.magistuarmory.client.render.tileentity.PaviseBlockRenderer;
import com.magistuarmory.item.*;
import com.magistuarmory.item.armor.MedievalArmorItem;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Environment(EnvType.CLIENT)
public class ModRender
{
	public static HumanoidModel<net.minecraft.client.renderer.entity.state.HumanoidRenderState> INNER_ARMOR = null;
	public static HumanoidModel<net.minecraft.client.renderer.entity.state.HumanoidRenderState> OUTER_ARMOR = null;
	public static Map<Identifier, HumanoidModel<net.minecraft.client.renderer.entity.state.HumanoidRenderState>> ARMOR_MODELS_CACHE = new HashMap<>();
	public static Map<Identifier, Model> SHIELD_MODELS_CACHE = new HashMap<>();

	public static void setup(ModItemsProvider content)
	{
        registerModelCodecs();

		for (RegistrySupplier<? extends Item> supplier : content.items)
			if (supplier.get() instanceof IHasModelProperty havingproperty)
				havingproperty.registerModelProperty();

		content.shieldItems.stream()
				.filter(s -> s.get() instanceof PaviseItem)
				.map(s -> (PaviseItem) s.get())
				.forEach(p -> BlockEntityRendererRegistry.register(p.getBlock().getEntityType(), 
						context -> new PaviseBlockRenderer(context, p.getId(), p.getLocation())));
		
		setupPlatform(content);
	}

    /** Register ItemPropertiesRegistry.Property.CODEC, ItemTint.CODEC and HeraldryItemStackRenderer.Unbaked.CODEC before model loading. */
    @ExpectPlatform
    public static void registerModelCodecs() { throw new AssertionError(); }

	@ExpectPlatform
	public static void setupPlatform(ModItemsProvider content)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static void registerModelsLoadListener(ModItemsProvider content)
	{
		throw new AssertionError();
	}

	public static void registerRenderers()
	{
	}

	private static net.minecraft.client.model.geom.EntityModelSet loadedModelSet;
    private static final java.util.Set<ModItemsProvider> loadedContent = java.util.Collections.newSetFromMap(new java.util.IdentityHashMap<>());

    public static void loadModels(ModItemsProvider content, EntityRendererProvider.Context context)
    {
        if (loadedModelSet != context.getModelSet()) {
            loadedModelSet = context.getModelSet();
            loadedContent.clear();
            ARMOR_MODELS_CACHE.clear();
            SHIELD_MODELS_CACHE.clear();
        }
        if (!loadedContent.add(content)) return;
		OUTER_ARMOR = new HumanoidModel<>(context.bakeLayer(ModModels.DEFAULT_ARMOR_LOCATION));
		INNER_ARMOR = new HumanoidModel<>(context.bakeLayer(ModModels.DEFAULT_LEGGINGS_LOCATION));

		for (RegistrySupplier<? extends MedievalShieldItem> supplier : content.shieldItems)
			loadShieldModel(context, supplier.get());

		for (RegistrySupplier<? extends MedievalArmorItem> supplier : content.armorItems)
			loadArmorModel(context, supplier.get());
	}

	public static void loadShieldModel(EntityRendererProvider.Context context, MedievalShieldItem shield)
	{
		if (!shield.is3d()) {
			return;
		}

		Identifier location = shield.getLocation();
		Model model = SHIELD_MODELS_CACHE.computeIfAbsent(location,
				k -> new MedievalShieldModel(context.bakeLayer(ModModels.createLocation(location))));
		shield.getRenderer().setModel(model);
	}

	public static void loadArmorModel(EntityRendererProvider.Context context, MedievalArmorItem armor)
	{
        ModelLayerLocation location = armor.getArmorType().getModelLocation().orElse(
                armor.getEquipmentSlot() == net.minecraft.world.entity.EquipmentSlot.LEGS
                        ? ModModels.DEFAULT_LEGGINGS_LOCATION : ModModels.DEFAULT_ARMOR_LOCATION);
        armor.setModel(new com.magistuarmory.client.render.model.armor.SlottedArmorModel(
                context.bakeLayer(location), armor.getEquipmentSlot()));
	}

	@ExpectPlatform
	public static HeraldryItemStackRenderer createHeraldryItemStackRenderer(String id, Identifier location)
	{
		throw new AssertionError();
	}
}
