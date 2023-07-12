package com.magistuarmory.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public interface ArmorDecoration
{
	String getName();
	
	CompoundTag getItemArmorDecorationData(ItemStack stack);
	
	EquipmentSlot getArmorType();
}
