package com.magistuarmory.item.crafting;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.item.ArmorDecorationItem;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.armor.ISurcoat;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class HeraldryRecipe extends CustomRecipe
{
    public HeraldryRecipe(ResourceLocation location)
    {
        super(location);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level)
    {
        ItemStack stack = ItemStack.EMPTY;
        ItemStack stack2 = ItemStack.EMPTY;

        for(int i = 0; i < container.getContainerSize(); ++i)
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

                    if (BlockItem.getBlockEntityData(stack3) != null)
                        return false;

                    stack = stack3;
                }
            }
        }

        return !stack.isEmpty() && !stack2.isEmpty();
    }

    @Override
    public ItemStack assemble(CraftingContainer container)
    {
        ItemStack stack = ItemStack.EMPTY;
        ItemStack stack1 = ItemStack.EMPTY;

        for(int i = 0; i < container.getContainerSize(); ++i)
        {
            ItemStack stack2 = container.getItem(i);
            if (!stack2.isEmpty())
            {
                if (stack2.getItem() instanceof BannerItem)
                    stack = stack2;
                else if (isApplicableForBanner(stack2.getItem()))
                    stack1 = stack2.copy();
            }
        }

        if (!stack1.isEmpty())
        {
            CompoundTag compoundtag = BlockItem.getBlockEntityData(stack);
            CompoundTag compoundtag1 = compoundtag == null ? new CompoundTag() : compoundtag.copy();
            DyeColor basecolor = ((BannerItem) stack.getItem()).getColor();
            compoundtag1.putInt("Base", ((BannerItem) stack.getItem()).getColor().getId());

            if (wornWithSurcoat(stack1.getItem()))
                stack1.setHoverName(new TranslatableComponent("magistuarmory.withsurcoat." + basecolor.getName(), stack1.getHoverName().getString()));
            else if (wornWithCaparison(stack1.getItem()))
                stack1.setHoverName(new TranslatableComponent("magistuarmory.withcaparison." + basecolor.getName(), stack1.getHoverName().getString()));

            stack1.addTagElement("BlockEntityTag", compoundtag1);
        }
        return stack1;
    }

    @Override
    public boolean canCraftInDimensions(int p_44298_, int p_44299_)
    {
        return p_44298_ * p_44299_ >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
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
        return item instanceof HorseArmorItem;
    }

    static boolean wornWithSurcoat(Item item)
    {
        return item instanceof ArmorItem && (EpicKnights.GENERAL_CONFIG.enableSurcoatRecipeForAllArmor || item instanceof ISurcoat) && ((ArmorItem) item).getSlot().equals(EquipmentSlot.CHEST);
    }

    static boolean isApplicableForBanner(Item item)
    {
        return isPaintableShield(item) || wornWithCaparison(item) || wornWithSurcoat(item);
    }
}