package com.magistuarmory.forge.item.crafting;

import com.google.gson.JsonObject;
import com.magistuarmory.item.crafting.DecorationRemoveRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.function.Function;

public class DecorationRemoveRecipeSerializerForge extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<DecorationRemoveRecipe>
{
    public static final DecorationRemoveRecipeSerializerForge INSTANCE = new DecorationRemoveRecipeSerializerForge(DecorationRemoveRecipe::new);

    private final Function<ResourceLocation, DecorationRemoveRecipe> constructor;

    DecorationRemoveRecipeSerializerForge(Function<ResourceLocation, DecorationRemoveRecipe> constructor)
    {
        this.constructor = constructor;
    }

    @Override
    public DecorationRemoveRecipe fromJson(ResourceLocation id, JsonObject json)
    {
        return this.constructor.apply(id);
    }

    @Override
    public DecorationRemoveRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf)
    {
        return this.constructor.apply(id);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, DecorationRemoveRecipe recipe) {}
}