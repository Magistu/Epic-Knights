package com.magistuarmory.item.crafting;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.armor.ISurcoat;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.nbt.CompoundTag;
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
    public HeraldryRecipe(ResourceLocation p_44296_)
    {
        super(p_44296_);
    }

    @Override
    public boolean matches(CraftingContainer p_44308_, Level p_44309_)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        ItemStack itemstack1 = ItemStack.EMPTY;

        for(int i = 0; i < p_44308_.getContainerSize(); ++i)
        {
            ItemStack itemstack2 = p_44308_.getItem(i);
            if (!itemstack2.isEmpty())
            {
                if (itemstack2.getItem() instanceof BannerItem)
                {
                    if (!itemstack1.isEmpty())
                    {
                        return false;
                    }

                    itemstack1 = itemstack2;
                }
                else
                {
                    if (!isApplicableForBanner(itemstack2.getItem()))
                    {
                        return false;
                    }

                    if (!itemstack.isEmpty())
                    {
                        return false;
                    }

                    if (itemstack2.getTagElement("BlockEntityTag") != null)
                    {
                        return false;
                    }

                    itemstack = itemstack2;
                }
            }
        }
        
        return !itemstack.isEmpty() && !itemstack1.isEmpty();
    }

    @Override
    public ItemStack assemble(CraftingContainer p_44306_)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        ItemStack itemstack1 = ItemStack.EMPTY;

        for(int i = 0; i < p_44306_.getContainerSize(); ++i)
        {
            ItemStack itemstack2 = p_44306_.getItem(i);
            if (!itemstack2.isEmpty())
            {
                if (itemstack2.getItem() instanceof BannerItem)
                {
                    itemstack = itemstack2;
                }
                else if (isApplicableForBanner(itemstack2.getItem()))
                {
                    itemstack1 = itemstack2.copy();
                }
            }
        }

        if (!itemstack1.isEmpty())
        {
            CompoundTag compoundtag = itemstack.getTagElement("BlockEntityTag");
            CompoundTag compoundtag1 = compoundtag == null ? new CompoundTag() : compoundtag.copy();
            DyeColor basecolor = ((BannerItem) itemstack.getItem()).getColor();
            compoundtag1.putInt("Base", ((BannerItem) itemstack.getItem()).getColor().getId());

            if (wornWithSurcoat(itemstack1.getItem()))
            {
                if (itemstack1.getHoverName() instanceof TranslatableComponent)
                {
                    itemstack1.setHoverName(new TranslatableComponent(((TranslatableComponent) itemstack1.getHoverName()).getKey()).append(new TranslatableComponent("magistuarmory.withsurcoat." + basecolor.getName())));
                }
                else
                {
                    itemstack1.setHoverName(new TranslatableComponent(itemstack1.getHoverName().toString()).append(new TranslatableComponent("magistuarmory.withsurcoat." + basecolor.getName())));
                }
            }
            else if (wornWithCaparison(itemstack1.getItem()))
            {
                if (itemstack1.getHoverName() instanceof TranslatableComponent)
                {
                    itemstack1.setHoverName(new TranslatableComponent(((TranslatableComponent) itemstack1.getHoverName()).getKey()).append(new TranslatableComponent("magistuarmory.withcaparison." + basecolor.getName())));
                }
                else
                {
                    itemstack1.setHoverName(new TranslatableComponent(itemstack1.getHoverName().toString()).append(new TranslatableComponent("magistuarmory.withcaparison." + basecolor.getName())));
                }
            }

            itemstack1.addTagElement("BlockEntityTag", compoundtag1);
        }
        return itemstack1;
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
        return item instanceof ArmorItem && (KnightlyArmory.GENERAL_CONFIG.enableSurcoatRecipeForAllArmor || item instanceof ISurcoat) && ((ArmorItem) item).getSlot().equals(EquipmentSlot.CHEST);
    }

    static boolean isApplicableForBanner(Item item)
    {
        return isPaintableShield(item) || wornWithCaparison(item) || wornWithSurcoat(item);
    }
}