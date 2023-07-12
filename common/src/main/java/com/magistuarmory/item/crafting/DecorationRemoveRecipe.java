package com.magistuarmory.item.crafting;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.item.ArmorDecorationItem;
import com.magistuarmory.item.DyeableArmorDecorationItem;
import com.magistuarmory.item.MedievalBagItem;
import com.magistuarmory.item.ModItems;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BannerBlock;

import java.util.ArrayList;
import java.util.List;


public class DecorationRemoveRecipe extends CustomRecipe
{
    public DecorationRemoveRecipe(ResourceLocation location)
    {
        super(location);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level)
    {
        ItemStack stack = ItemStack.EMPTY;

        for(int i = 0; i < container.getContainerSize(); ++i)
        {
            ItemStack stack2 = container.getItem(i);
            if (stack2.isEmpty())
                continue;
            
            if (isDecorated(stack2))
            {
                if (!stack.isEmpty())
                    return false;
                
                stack = stack2;
                continue;
            }
            
            return false;
        }

        return !stack.isEmpty();
    }

    @Override
    public ItemStack assemble(CraftingContainer container)
    {
        ItemStack stack = ItemStack.EMPTY;

        for(int i = 0; i < container.getContainerSize(); ++i)
        {
            ItemStack stack2 = container.getItem(i);
            if (stack2.isEmpty())
                continue;

            if (isDecorated(stack2))
            {
                stack = stack2;
                break;
            }
        }
        
        if (!stack.isEmpty())
        {
            ItemStack bagstack = new ItemStack(ModItems.MEDIEVAL_BAG.get());
            List<ItemStack> stacks = takeApart(stack);
            if (stacks.isEmpty())
                return ItemStack.EMPTY;
            MedievalBagItem.setContents(bagstack, stacks);
            return bagstack;
        }
        
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int i, int j)
    {
        return i * j >= 1;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return getSerializerInstance();
    }

    @ExpectPlatform
    public static RecipeSerializer<DecorationRemoveRecipe> getSerializerInstance()
    {
        throw new AssertionError();
    }
    
    static boolean mightBeDecorated(Item item)
    {
        return item instanceof ArmorItem || item instanceof ShieldItem || item instanceof HorseArmorItem;
    }

    static boolean isDecorated(ItemStack stack)
    {
        if (!mightBeDecorated(stack.getItem()))
            return false;
        
        CompoundTag blockcompound = BlockItem.getBlockEntityData(stack);
        if (blockcompound != null && blockcompound.contains("Base"))
            return true;
        
        CompoundTag decorationdata = stack.getTagElement("ArmorDecoration");
        return decorationdata != null && !decorationdata.getList("Items", 10).isEmpty();
    }
    
    static List<ItemStack> takeApart(ItemStack stack)
    {
        List<ItemStack> stacks = new ArrayList<>();
        ItemStack newstack = stack.copy();
        CompoundTag blockcompound = BlockItem.getBlockEntityData(newstack);
        if (blockcompound != null)
        {
            if (blockcompound.contains("Base"))
            {
                BannerItem banner = (BannerItem) BannerBlock.byColor(DyeColor.byId(blockcompound.getInt("Base"))).asItem();
                ItemStack bannerstack = new ItemStack(banner);
                bannerstack.addTagElement("BlockEntityTag", blockcompound.copy());

                newstack.removeTagKey("BlockEntityTag");
                
                stacks.add(bannerstack);
            }
        }
        CompoundTag decorationdata = newstack.getTagElement("ArmorDecoration");
        if (decorationdata != null)
        {
            ListTag listtag = decorationdata.getList("Items", 10);
            while (!listtag.isEmpty())
            {
                CompoundTag tag = listtag.getCompound(listtag.size() - 1);
                String name = tag.getString("name");
                int color = tag.getInt("color");
                ArmorDecorationItem decoration = (ArmorDecorationItem) Registry.ITEM.get(new ResourceLocation(EpicKnights.ID, name + "_decoration"));
                ItemStack decorationstack = new ItemStack(decoration);
                if (decoration instanceof DyeableArmorDecorationItem dyeabedecoration)
                    dyeabedecoration.setColor(decorationstack, color);

                listtag.remove(listtag.size() - 1);
                decorationdata.put("Items", listtag);
                newstack.addTagElement("ArmorDecoration", decorationdata);
                
                stacks.add(decorationstack);
            }
        }
        newstack.resetHoverName();
        stacks.add(newstack);
        return stacks;
    }
}
