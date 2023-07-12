package com.magistuarmory.item.crafting;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Function;

public record ArmorDecorationRecipeSerializer(Function<ResourceLocation, ArmorDecorationRecipe> constructor) implements RecipeSerializer<ArmorDecorationRecipe>
{
    public static final ArmorDecorationRecipeSerializer INSTANCE = new ArmorDecorationRecipeSerializer(ArmorDecorationRecipe::new);
    public static final String ID = "armor_decoration_recipes";

    @Override
    public ArmorDecorationRecipe fromJson(ResourceLocation id, JsonObject json) {
        return this.constructor.apply(id);
    }

    @Override
    public ArmorDecorationRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        return this.constructor.apply(id);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, ArmorDecorationRecipe recipe) {
    }
}