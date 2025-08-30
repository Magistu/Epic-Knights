package com.magistuarmory.item.crafting;

import com.magistuarmory.component.ModDataComponents;
import com.magistuarmory.item.ArmorDecoration;
import com.magistuarmory.item.DyeableArmorDecorationItem;
import com.magistuarmory.item.MedievalBagItem;
import com.magistuarmory.item.ModItems;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class DecorationRemoveRecipe extends CustomRecipe
{
    public static RecipeSerializer<DecorationRemoveRecipe> SERIALIZER = new SimpleCraftingRecipeSerializer<>(DecorationRemoveRecipe::new);

    public DecorationRemoveRecipe(CraftingBookCategory category)
    {
        super(category);
        //super(location, CraftingBookCategory.MISC);
    }

    @Override
    public boolean matches(CraftingInput container, Level level)
    {
        ItemStack stack = ItemStack.EMPTY;

        for(int i = 0; i < container.size(); ++i)
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
    public @NotNull ItemStack assemble(CraftingInput container, @NotNull HolderLookup.Provider access)
    {
        ItemStack stack = ItemStack.EMPTY;

        for(int i = 0; i < container.size(); ++i)
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
        return item instanceof ArmorItem || item instanceof ShieldItem;
    }

    static boolean isDecorated(ItemStack stack)
    {
        if (!mightBeDecorated(stack.getItem()))
            return false;

        CustomData decorationdata = stack.get(ModDataComponents.ARMOR_DECORATION.get());
        if (decorationdata != null)
        {
            CompoundTag compoundtag = decorationdata.copyTag();
            ListTag listtag = compoundtag.getList("Items", 10);
            if (!listtag.isEmpty())
            {
                return true;
            }
        }
        return stack.get(DataComponents.BANNER_PATTERNS) != null;
    }
    
    static List<ItemStack> takeApart(ItemStack stack)
    {
        List<ItemStack> stacks = new ArrayList<>();
        ItemStack newstack = stack.copy();
        
        DyeColor basecolor = newstack.get(DataComponents.BASE_COLOR);
        if (basecolor != null) {
            BannerItem banner = (BannerItem) BannerBlock.byColor(basecolor).asItem();
            ItemStack bannerstack = new ItemStack(banner);

            BannerPatternLayers patterns = newstack.get(DataComponents.BANNER_PATTERNS);
            if (patterns != null && !patterns.layers().isEmpty()) {
                bannerstack.set(DataComponents.BANNER_PATTERNS, patterns);
            }
            stacks.add(bannerstack);
        }
        
        CustomData decorationdata = newstack.get(ModDataComponents.ARMOR_DECORATION.get());
        if (decorationdata != null)
        {
            CompoundTag compoundtag = decorationdata.copyTag();
            ListTag listtag = compoundtag.getList("Items", 10);
            while (!listtag.isEmpty())
            {
                CompoundTag tag = listtag.getCompound(listtag.size() - 1);
                String name = tag.getString("name");
                int color = tag.getInt("color");
                ArmorDecoration decoration = (ArmorDecoration) BuiltInRegistries.ITEM.get(ResourceLocation.parse(name + "_decoration"));
                ItemStack decorationstack = new ItemStack(decoration);
                if (decoration instanceof DyeableArmorDecorationItem dyeabedecoration && dyeabedecoration.getColor(decorationstack) != color)
                    dyeabedecoration.setColor(decorationstack, color);

                listtag.remove(listtag.size() - 1);
                compoundtag.put("Items", listtag);
                
                stacks.add(decorationstack);
            }
        }
        newstack.remove(ModDataComponents.ARMOR_DECORATION.get());
        newstack.remove(DataComponents.BANNER_PATTERNS);
        newstack.remove(DataComponents.BASE_COLOR);
        newstack.remove(DataComponents.CUSTOM_NAME);
        stacks.add(newstack);
        return stacks;
    }
}
