package com.magistuarmory.item.crafting.fabric;

import com.magistuarmory.item.crafting.DecorationRemoveRecipe;
import com.magistuarmory.item.crafting.DecorationRemoveRecipeSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class DecorationRemoveRecipeImpl
{
	public static RecipeSerializer<DecorationRemoveRecipe> getSerializerInstance()
	{
		return DecorationRemoveRecipeSerializer.INSTANCE;
	}
}
