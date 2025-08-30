package com.magistuarmory.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public interface DyeableItemLike extends ItemLike
{
    int getColor(ItemStack stack);
}
