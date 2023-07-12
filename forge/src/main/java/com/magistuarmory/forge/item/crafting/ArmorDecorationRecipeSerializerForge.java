package com.magistuarmory.forge.item.crafting;

import com.google.gson.JsonObject;
import com.magistuarmory.item.crafting.ArmorDecorationRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.function.Function;

public class ArmorDecorationRecipeSerializerForge extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<ArmorDecorationRecipe>
{
    public static final ArmorDecorationRecipeSerializerForge INSTANCE = new ArmorDecorationRecipeSerializerForge(ArmorDecorationRecipe::new);

    private final Function<ResourceLocation, ArmorDecorationRecipe> constructor;

    ArmorDecorationRecipeSerializerForge(Function<ResourceLocation, ArmorDecorationRecipe> constructor)
    {
        this.constructor = constructor;
    }

    @Override
    public ArmorDecorationRecipe fromJson(ResourceLocation id, JsonObject json)
    {
        return this.constructor.apply(id);
    }

    @Override
    public ArmorDecorationRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf)
    {
        return this.constructor.apply(id);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, ArmorDecorationRecipe recipe) {}
}