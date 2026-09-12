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
import net.minecraft.resources.Identifier;
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
    public static RecipeSerializer<DecorationRemoveRecipe> SERIALIZER = new RecipeSerializer<>(com.mojang.serialization.MapCodec.unit(() -> new DecorationRemoveRecipe(CraftingBookCategory.MISC)), net.minecraft.network.codec.StreamCodec.unit(new DecorationRemoveRecipe(CraftingBookCategory.MISC)));

    public DecorationRemoveRecipe(CraftingBookCategory category)
    {
        super();
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
    public @NotNull ItemStack assemble(CraftingInput container)
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
    public RecipeSerializer<DecorationRemoveRecipe> getSerializer()
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
        return com.magistuarmory.item.armor.ArmorComponents.isArmor(item) || item instanceof ShieldItem;
    }

    static boolean isDecorated(ItemStack stack)
    {
        if (!mightBeDecorated(stack.getItem()))
            return false;

        CustomData decorationdata = stack.get(ModDataComponents.ARMOR_DECORATION.get());
        if (decorationdata != null)
        {
            CompoundTag compoundtag = decorationdata.copyTag();
            ListTag listtag = compoundtag.getListOrEmpty("Items");
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
            BannerItem banner = (BannerItem) BuiltInRegistries.ITEM.getValue(net.minecraft.resources.Identifier.withDefaultNamespace(basecolor.getName() + "_banner"));
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
            ListTag listtag = compoundtag.getListOrEmpty("Items");
            while (!listtag.isEmpty())
            {
                CompoundTag tag = listtag.getCompoundOrEmpty(listtag.size() - 1);
                String name = tag.getStringOr("name", "");
                int color = tag.getIntOr("color", 0);
                ArmorDecoration decoration = (ArmorDecoration) BuiltInRegistries.ITEM.getValue(Identifier.parse(name + "_decoration"));
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
