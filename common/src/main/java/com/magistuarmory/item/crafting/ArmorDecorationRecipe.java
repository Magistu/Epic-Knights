package com.magistuarmory.item.crafting;

import com.magistuarmory.item.ArmorDecoration;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ArmorDecorationRecipe extends CustomRecipe
{
    public static RecipeSerializer<ArmorDecorationRecipe> SERIALIZER = new SimpleCraftingRecipeSerializer<>(ArmorDecorationRecipe::new);

    public ArmorDecorationRecipe(ResourceLocation location, CraftingBookCategory category) {
        super(location, CraftingBookCategory.MISC);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {
        ItemStack wearabledecorationstack = ItemStack.EMPTY;
        ItemStack armorstack = ItemStack.EMPTY;
        ItemStack decorationstack = ItemStack.EMPTY;

        for(ItemStack stack : container.getItems()) {
            if (stack.isEmpty())
                continue;

            if (stack.getItem() instanceof ArmorItem && stack.getItem() instanceof ArmorDecoration) {
                if (!wearabledecorationstack.isEmpty())
                    return false;

                wearabledecorationstack = stack;
                continue;
            }

            if (stack.getItem() instanceof ArmorDecoration) {
                if (!decorationstack.isEmpty())
                    return false;

                decorationstack = stack;
                continue;
            }

            if (stack.getItem() instanceof ArmorItem) {
                if (!armorstack.isEmpty())
                    return false;

                armorstack = stack;
                continue;
            }

            return false;
        }

        if (!wearabledecorationstack.isEmpty()) {
            if (!decorationstack.isEmpty() && armorstack.isEmpty()) {
                armorstack = wearabledecorationstack;
            } else if (decorationstack.isEmpty() && !armorstack.isEmpty()) {
                decorationstack = wearabledecorationstack;
            } else {
                return false;
            }
        }

        if (decorationstack.getItem() instanceof ArmorDecoration decoration) {
            return decoration.isApplicableForDecoration(armorstack);
        }

        return false;
    }

    @Override
    public ItemStack assemble(CraftingContainer container, @NotNull RegistryAccess access) {
        ItemStack wearabledecorationstack = ItemStack.EMPTY;
        ItemStack armorstack = ItemStack.EMPTY;
        ItemStack decorationstack = ItemStack.EMPTY;

        for(ItemStack stack : container.getItems()) {
            if (stack.isEmpty())
                continue;
            if (stack.getItem() instanceof ArmorDecoration && stack.getItem() instanceof ArmorItem)
                wearabledecorationstack = stack;
            else if (stack.getItem() instanceof ArmorDecoration)
                decorationstack = stack;
            else if (stack.getItem() instanceof ArmorItem)
                armorstack = stack.copy();
        }

        if (!wearabledecorationstack.isEmpty()) {
            if (!decorationstack.isEmpty() && armorstack.isEmpty()) {
                armorstack = wearabledecorationstack.copy();
            } else if (decorationstack.isEmpty() && !armorstack.isEmpty()) {
                decorationstack = wearabledecorationstack;
            } else {
                return armorstack;
            }
        }

        if (!armorstack.isEmpty() && !decorationstack.isEmpty() && decorationstack.getItem() instanceof ArmorDecoration decoration)
            decoration.decorate(armorstack, decorationstack);

        return armorstack;
    }

    @Override
    public boolean canCraftInDimensions(int n, int m)
    {
        return n * m >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return getSerializerInstance();
    }

    @ExpectPlatform
    public static RecipeSerializer<ArmorDecorationRecipe> getSerializerInstance()
    {
        throw new AssertionError();
    }
}