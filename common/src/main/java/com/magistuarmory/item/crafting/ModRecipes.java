package com.magistuarmory.item.crafting;

import com.magistuarmory.KnightlyArmory;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipes
{
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(KnightlyArmory.ID, Registry.RECIPE_SERIALIZER_REGISTRY);
	public static final RegistrySupplier<RecipeSerializer<?>> HERALDRY_SERIALIZER = RECIPE_SERIALIZERS.register(HeraldryRecipeSerializer.ID, HeraldryRecipe::getSerializerInstance);

	public static void init()
	{
		RECIPE_SERIALIZERS.register();
	}
}
