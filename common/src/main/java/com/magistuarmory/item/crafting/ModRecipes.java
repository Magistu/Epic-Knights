package com.magistuarmory.item.crafting;

import com.magistuarmory.EpicKnights;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipes
{
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(EpicKnights.ID, Registries.RECIPE_SERIALIZER);
	
	public static final RegistrySupplier<RecipeSerializer<?>> HERALDRY_SERIALIZER = RECIPE_SERIALIZERS.register("heraldry_recipes", HeraldryRecipe::getSerializerInstance);
	public static final RegistrySupplier<RecipeSerializer<?>> ARMOR_DECORATION_SERIALIZER = RECIPE_SERIALIZERS.register("armor_decoration_recipes", ArmorDecorationRecipe::getSerializerInstance);
	public static final RegistrySupplier<RecipeSerializer<?>> DECORATION_REMOVE_SERIALIZER = RECIPE_SERIALIZERS.register("decoration_remove_recipes", DecorationRemoveRecipe::getSerializerInstance);

	public static void init()
	{
		RECIPE_SERIALIZERS.register();
	}
}
