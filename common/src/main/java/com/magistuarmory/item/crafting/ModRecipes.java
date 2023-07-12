package com.magistuarmory.item.crafting;

import com.magistuarmory.EpicKnights;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipes
{
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(EpicKnights.ID, Registry.RECIPE_SERIALIZER_REGISTRY);
	
	public static final RegistrySupplier<RecipeSerializer<?>> HERALDRY_SERIALIZER = RECIPE_SERIALIZERS.register(HeraldryRecipeSerializer.ID, HeraldryRecipe::getSerializerInstance);
	public static final RegistrySupplier<RecipeSerializer<?>> ARMOR_DECORATION_SERIALIZER = RECIPE_SERIALIZERS.register(ArmorDecorationRecipeSerializer.ID, ArmorDecorationRecipe::getSerializerInstance);
	public static final RegistrySupplier<RecipeSerializer<?>> DECORATION_REMOVE_SERIALIZER = RECIPE_SERIALIZERS.register(DecorationRemoveRecipeSerializer.ID, DecorationRemoveRecipe::getSerializerInstance);

	public static void init()
	{
		RECIPE_SERIALIZERS.register();
	}
}
