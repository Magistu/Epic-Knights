package com.magistuarmory.item.crafting;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Function;

public record DecorationRemoveRecipeSerializer(Function<ResourceLocation, DecorationRemoveRecipe> constructor) implements RecipeSerializer<DecorationRemoveRecipe>
{
    public static final DecorationRemoveRecipeSerializer INSTANCE = new DecorationRemoveRecipeSerializer(DecorationRemoveRecipe::new);
    public static final String ID = "decoration_remove_recipes";

    @Override
    public DecorationRemoveRecipe fromJson(ResourceLocation id, JsonObject json) {
        return this.constructor.apply(id);
    }

    @Override
    public DecorationRemoveRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        return this.constructor.apply(id);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, DecorationRemoveRecipe recipe) {
    }
}