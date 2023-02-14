package com.magistuarmory.forge.item.crafting;

import com.google.gson.JsonObject;
import com.magistuarmory.item.crafting.HeraldryRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.function.Function;

public class HeraldryRecipeSerializerForge extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<HeraldryRecipe>
{
    public static final HeraldryRecipeSerializerForge INSTANCE = new HeraldryRecipeSerializerForge(HeraldryRecipe::new);

    private final Function<ResourceLocation, HeraldryRecipe> constructor;

    HeraldryRecipeSerializerForge(Function<ResourceLocation, HeraldryRecipe> constructor)
    {
        this.constructor = constructor;
    }

    @Override
    public HeraldryRecipe fromJson(ResourceLocation id, JsonObject json)
    {
        return this.constructor.apply(id);
    }

    @Override
    public HeraldryRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf)
    {
        return this.constructor.apply(id);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, HeraldryRecipe recipe) {}
}