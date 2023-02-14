package com.magistuarmory.client.render;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.render.model.*;
import com.magistuarmory.item.ModItems;
import com.magistuarmory.item.IHasModelProperty;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class ModRender
{
	public static final ModelLayerLocation SURCOAT = new ModelLayerLocation(new ResourceLocation(KnightlyArmory.ID, "surcoat"), "decorations");
	public static final ModelLayerLocation CAPARISON = new ModelLayerLocation(new ResourceLocation(KnightlyArmory.ID, "caparison"), "decorations");
	
	public static void setup()
	{
		for (RegistrySupplier<? extends Item> supplier : ModItems.dyeableItems)
		{
			ColorHandlerRegistry.registerItemColors((stack, i) -> i > 0 ? -1 : ((DyeableLeatherItem) stack.getItem()).getColor(stack), supplier.get());
		}
		
		for (ModItems.ShieldsSupply shields : ModItems.shieldsSupply) 
		{
			shields.get().forEach(supplier -> ((IHasModelProperty) supplier.get()).registerModelProperty());
		}

		for (ModItems.WeaponsSupply weapons : ModItems.weaponsSupply)
		{
			weapons.get().forEach(supplier -> ((IHasModelProperty) supplier.get()).registerModelProperty());
		}

		((IHasModelProperty) ModItems.LONGBOW.get()).registerModelProperty();
		((IHasModelProperty) ModItems.HEAVY_CROSSBOW.get()).registerModelProperty();
		((IHasModelProperty) ModItems.NOBLE_SWORD.get()).registerModelProperty();
		((IHasModelProperty) ModItems.MESSER_SWORD.get()).registerModelProperty();
		((IHasModelProperty) ModItems.CORRUPTED_ROUND_SHIELD.get()).registerModelProperty();

		EntityModelLayerRegistry.register(SURCOAT, SurcoatModel::createLayer);
		EntityModelLayerRegistry.register(CAPARISON, CaparisonModel::createLayer);

		setupPlatform();
	}

	@ExpectPlatform
	public static void setupPlatform()
	{
		throw new AssertionError();
	}

	public static void stitch(TextureAtlas atlas, Consumer<ResourceLocation> adder)
	{
		ModItems.HEATER_SHIELDS.stitch(atlas, adder);
		ModItems.RONDACHES.stitchWithoutPatterns(atlas, adder);
		ModItems.TARTSCHES.stitch(atlas, adder);
		ModItems.ELLIPTICAL_SHIELDS.stitch(atlas, adder);
		ModItems.ROUND_SHIELDS.stitch(atlas, adder);
		ModItems.PAVESES.stitch(atlas, adder);
		ModItems.KITE_SHIELDS.stitch(atlas, adder);
		ModItems.BUCKLERS.stitchWithoutPatterns(atlas, adder);
		ModItems.TARGETS.stitchWithoutPatterns(atlas, adder);
		adder.accept(new ResourceLocation(KnightlyArmory.ID, "entity/corruptedroundshield_nopattern"));
	}

	@ExpectPlatform
	public static BlockEntityWithoutLevelRenderer getHeraldryItemStackRenderer(String id, String name, Models.ShieldEnum modelkey)
	{
		throw new AssertionError();
	}
}
