package com.magistuarmory.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public class DyeableArmorDecorationItem extends ArmorDecorationItem implements DyeableLeatherItem
{
	int defaultcolor;

	public DyeableArmorDecorationItem(String name, Properties properties, EquipmentSlot armorType)
	{
		this(name, properties, armorType, 16777215);
		this.name = name;
		this.armorType = armorType;
	}

	public DyeableArmorDecorationItem(String name, Properties properties, EquipmentSlot armorType, int defaultcolor)
	{
		super(name, properties, armorType);
		this.defaultcolor = defaultcolor;
	}
	
	@Override
	public int getColor(ItemStack stack)
	{
		CompoundTag compoundnbt = stack.getTagElement("display");
		return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : this.defaultcolor;
	}

	@Override
	public CompoundTag getItemArmorDecorationData(ItemStack stack) {
		CompoundTag compoundnbt = new CompoundTag();

		compoundnbt.putString("name", this.name);
		compoundnbt.putBoolean("dyeable", true);
		compoundnbt.putInt("color", this.getColor(stack));
		
		return compoundnbt;
	}
}
