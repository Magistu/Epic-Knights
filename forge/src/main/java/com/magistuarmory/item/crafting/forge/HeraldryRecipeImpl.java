package com.magistuarmory.item.crafting.forge;

import com.magistuarmory.forge.item.crafting.HeraldryRecipeSerializerForge;
import com.magistuarmory.item.crafting.HeraldryRecipe;
import com.magistuarmory.item.crafting.HeraldryRecipeSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class HeraldryRecipeImpl
{
    public static RecipeSerializer<HeraldryRecipe> getSerializerInstance()
    {
        return HeraldryRecipeSerializerForge.INSTANCE;
    }
}