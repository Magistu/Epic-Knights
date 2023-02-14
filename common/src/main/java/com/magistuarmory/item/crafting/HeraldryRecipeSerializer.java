package com.magistuarmory.item.crafting;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Function;

public record HeraldryRecipeSerializer(Function<ResourceLocation, HeraldryRecipe> constructor) implements RecipeSerializer<HeraldryRecipe>
{
    public static final HeraldryRecipeSerializer INSTANCE = new HeraldryRecipeSerializer(HeraldryRecipe::new);
    public static final String ID = "heraldry_recipes";

    @Override
    public HeraldryRecipe fromJson(ResourceLocation id, JsonObject json) {
        return this.constructor.apply(id);
    }

    @Override
    public HeraldryRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        return this.constructor.apply(id);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, HeraldryRecipe recipe) {
    }
}