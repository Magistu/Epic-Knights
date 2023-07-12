package com.magistuarmory.item.crafting;

import com.magistuarmory.item.ArmorDecorationItem;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class ArmorDecorationRecipe extends CustomRecipe
{
    public ArmorDecorationRecipe(ResourceLocation location)
    {
        super(location);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level)
    {
        ItemStack armorstack = ItemStack.EMPTY;
        ItemStack decorationstack = ItemStack.EMPTY;
        
        for(int i = 0; i < container.getContainerSize(); ++i)
        {
            ItemStack stack = container.getItem(i);
            if (stack.isEmpty())
                continue;
            
            if (stack.getItem() instanceof ArmorDecorationItem)
            {
                if (!decorationstack.isEmpty())
                    return false;

                decorationstack = stack;
                continue;
            }

            if (stack.getItem() instanceof ArmorItem)
            {
                if (!armorstack.isEmpty())
                    return false;

                armorstack = stack;
                continue;
            }
            
            return false;
        }

        return isApplicableForDecoration(armorstack, decorationstack.getItem());
    }

    @Override
    public ItemStack assemble(CraftingContainer container)
    {
        ItemStack armorstack = ItemStack.EMPTY;
        ItemStack decorationstack = ItemStack.EMPTY;

        for(int i = 0; i < container.getContainerSize(); ++i)
        {
            ItemStack stack = container.getItem(i);
            if (stack.isEmpty())
                continue;
            if (stack.getItem() instanceof ArmorDecorationItem)
                decorationstack = stack;
            else if (stack.getItem() instanceof ArmorItem)
                armorstack = stack.copy();
        }

        if (!armorstack.isEmpty() && !decorationstack.isEmpty())
            attachDecoration(armorstack, decorationstack);
        
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

    static boolean isApplicableForDecoration(ItemStack stack, Item decorationitem)
    {
        return getDecorations(stack).size() < 8 && 
                stack.getItem() instanceof ArmorItem armor && 
                decorationitem instanceof ArmorDecorationItem decoration && 
                decoration.getArmorType() == armor.getSlot();
    }
    
    static ListTag getDecorations(ItemStack stack)
    {
        CompoundTag compoundtag = stack.getTagElement("ArmorDecoration");
        if (compoundtag == null)
            return new ListTag();
        
        return compoundtag.getList("Items", 10);
    }

    static void attachDecoration(ItemStack stack, ItemStack decorationstack)
    {
        CompoundTag compoundtag = stack.getTagElement("ArmorDecoration");
        ListTag listtag = getDecorations(stack);
        CompoundTag compoundtag1 = compoundtag != null ? compoundtag.copy() : new CompoundTag();
        
        boolean decoratedOnce = listtag.size() > 0;
        
        ArmorDecorationItem decorationitem = (ArmorDecorationItem) decorationstack.getItem();
        CompoundTag decorationdata = decorationitem.getItemArmorDecorationData(decorationstack);
        String name = decorationdata.getString("name");

        boolean set = false;
        for (int i = 0; i < listtag.size(); ++i)
        {
            if (listtag.getCompound(i).getString("name").equals(name))
            {
                listtag.set(i, decorationdata);
                set = true;
                break;
            }
        }
        if (!set)
        {
            listtag.add(decorationdata);
        }
        
        compoundtag1.put("Items", listtag);
        
        if (!decoratedOnce)
            stack.setHoverName(new TranslatableComponent("magistuarmory.decorated", stack.getHoverName().getString()));
        stack.addTagElement("ArmorDecoration", compoundtag1);
    }
}