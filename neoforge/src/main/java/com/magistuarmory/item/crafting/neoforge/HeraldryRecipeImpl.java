package com.magistuarmory.item.crafting.neoforge;

import com.magistuarmory.item.crafting.HeraldryRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class HeraldryRecipeImpl
{
    public static RecipeSerializer<HeraldryRecipe> getSerializerInstance()
    {
        return HeraldryRecipe.SERIALIZER;
    }
}