package com.magistuarmory.item.crafting.fabric;

import com.magistuarmory.item.crafting.DecorationRemoveRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class DecorationRemoveRecipeImpl
{
	public static RecipeSerializer<DecorationRemoveRecipe> getSerializerInstance()
	{
		return DecorationRemoveRecipe.SERIALIZER;
	}
}
