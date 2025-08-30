package com.magistuarmory.item.crafting;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.armor.ISurcoat;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.jetbrains.annotations.NotNull;

public class HeraldryRecipe extends CustomRecipe
{
    public static RecipeSerializer<HeraldryRecipe> SERIALIZER = new SimpleCraftingRecipeSerializer<>(HeraldryRecipe::new);

    public HeraldryRecipe(CraftingBookCategory category)
    {
        super(category);
        //super(location, CraftingBookCategory.MISC);
    }

    @Override
    public boolean matches(CraftingInput container, Level level)
    {
        ItemStack stack = ItemStack.EMPTY;
        ItemStack stack2 = ItemStack.EMPTY;

        for(int i = 0; i < container.size(); ++i)
        {
            ItemStack stack3 = container.getItem(i);
            if (!stack3.isEmpty())
            {
                if (stack3.getItem() instanceof BannerItem)
                {
                    if (!stack2.isEmpty())
                        return false;

                    stack2 = stack3;
                }
                else
                {
                    if (!isApplicableForBanner(stack3.getItem()))
                        return false;

                    if (!stack.isEmpty())
                        return false;
                    
                    BannerPatternLayers patterns = stack3.get(DataComponents.BANNER_PATTERNS);
                    if (patterns != null && !patterns.layers().isEmpty())
                        return false;

                    stack = stack3;
                }
            }
        }

        return !stack.isEmpty() && !stack2.isEmpty();
    }

    @Override
    public @NotNull ItemStack assemble(CraftingInput container, @NotNull HolderLookup.Provider access)
    {
        ItemStack stack = ItemStack.EMPTY;
        ItemStack stack1 = ItemStack.EMPTY;

        for (int i = 0; i < container.size(); ++i)
        {
            ItemStack stack2 = container.getItem(i);
            if (!stack2.isEmpty())
            {
                if (stack2.getItem() instanceof BannerItem)
                {
                    stack = stack2;
                }
                else if (isApplicableForBanner(stack2.getItem()))
                {
                    stack1 = stack2.copy();
                }
            }
        }

        if (!stack1.isEmpty())
        {
            BannerPatternLayers patterns = stack.get(DataComponents.BANNER_PATTERNS);
            DyeColor color = ((BannerItem) stack.getItem()).getColor();

            if (wornWithSurcoat(stack1.getItem()))
                stack1.set(DataComponents.CUSTOM_NAME, Component.translatable("magistuarmory.withsurcoat." + color.getName(), stack1.getHoverName().getString()));
            else if (wornWithCaparison(stack1.getItem()))
                stack1.set(DataComponents.CUSTOM_NAME, Component.translatable("magistuarmory.withcaparison." + color.getName(), stack1.getHoverName().getString()));
            
            if (patterns != null)
                stack1.set(DataComponents.BANNER_PATTERNS, patterns);
            
            stack1.set(DataComponents.BASE_COLOR, color);
        }
        return stack1;
    }

    @Override
    public boolean canCraftInDimensions(int p_44298_, int p_44299_)
    {
        return p_44298_ * p_44299_ >= 2;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer()
    {
        return getSerializerInstance();
    }

    @ExpectPlatform
    public static RecipeSerializer<HeraldryRecipe> getSerializerInstance()
    {
        throw new AssertionError();
    }

    static boolean isPaintableShield(Item item)
    {
        return item instanceof MedievalShieldItem && ((MedievalShieldItem)item).isPaintable();
    }

    static boolean wornWithCaparison(Item item)
    {
        return item instanceof AnimalArmorItem animalarmor && animalarmor.getBodyType().equals(AnimalArmorItem.BodyType.EQUESTRIAN);
    }

    static boolean wornWithSurcoat(Item item)
    {
        return item instanceof ArmorItem && (EpicKnights.GENERAL_CONFIG.enableSurcoatRecipeForAllArmor || item instanceof ISurcoat) && ((ArmorItem) item).getType().getSlot().equals(EquipmentSlot.CHEST);
    }

    static boolean isApplicableForBanner(Item item)
    {
        return isPaintableShield(item) || wornWithCaparison(item) || wornWithSurcoat(item);
    }
}