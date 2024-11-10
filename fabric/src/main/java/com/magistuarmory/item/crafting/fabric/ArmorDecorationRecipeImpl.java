package com.magistuarmory.item.crafting.fabric;

import com.magistuarmory.item.crafting.ArmorDecorationRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ArmorDecorationRecipeImpl
{
	public static RecipeSerializer<ArmorDecorationRecipe> getSerializerInstance()
	{
		return ArmorDecorationRecipe.SERIALIZER;
	}
}
