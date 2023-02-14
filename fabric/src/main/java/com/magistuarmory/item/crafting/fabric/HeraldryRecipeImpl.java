package com.magistuarmory.item.crafting.fabric;

import com.magistuarmory.item.crafting.HeraldryRecipe;
import com.magistuarmory.item.crafting.HeraldryRecipeSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class HeraldryRecipeImpl
{
    public static RecipeSerializer<HeraldryRecipe> getSerializerInstance()
    {
        return HeraldryRecipeSerializer.INSTANCE;
    }
}