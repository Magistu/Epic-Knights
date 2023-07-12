package com.magistuarmory.item.crafting.forge;

import com.magistuarmory.forge.item.crafting.DecorationRemoveRecipeSerializerForge;
import com.magistuarmory.item.crafting.DecorationRemoveRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class DecorationRemoveRecipeImpl
{
	public static RecipeSerializer<DecorationRemoveRecipe> getSerializerInstance()
	{
		return DecorationRemoveRecipeSerializerForge.INSTANCE;
	}
}
