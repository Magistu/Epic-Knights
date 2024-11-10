package com.magistuarmory.client.render;

import com.magistuarmory.api.item.ModItemsProvider;
import com.magistuarmory.block.ModBlockEntityTypes;
import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.magistuarmory.client.render.tileentity.PaviseBlockRenderer;
import com.magistuarmory.item.IHasModelProperty;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.armor.MedievalArmorItem;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;


@Environment(EnvType.CLIENT)
public class ModRender
{
	public static void setup(ModItemsProvider content)
	{
		for (RegistrySupplier<? extends Item> supplier : content.dyeableItems)
			ColorHandlerRegistry.registerItemColors((stack, i) -> i > 0 ? -1 : ((DyeableLeatherItem) stack.getItem()).getColor(stack), supplier.get());

		for (RegistrySupplier<? extends Item> supplier : content.items)
			if (supplier.get() instanceof IHasModelProperty havingproperty)
				havingproperty.registerModelProperty();

		setupPlatform(content);
	}

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
		BlockEntityRendererRegistry.register(ModBlockEntityTypes.PAVISE.get(), PaviseBlockRenderer::new);
	}

	public static void loadModels(ModItemsProvider content, EntityRendererProvider.Context context)
	{
		for (Supplier<? extends MedievalShieldItem> supplier : content.shieldItems)
			supplier.get().loadModel(context);

		for (Supplier<? extends MedievalArmorItem> supplier : content.armorItems)
			supplier.get().loadModel(context);
	}

	@ExpectPlatform
	public static HeraldryItemStackRenderer createHeraldryItemStackRenderer(String id, ResourceLocation location)
	{
		throw new AssertionError();
	}
}
