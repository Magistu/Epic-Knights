package com.magistuarmory.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ArmorDecorationItem extends Item implements ArmorDecoration
{
	String name;
	EquipmentSlot armorType;

	public ArmorDecorationItem(String name, Properties properties, EquipmentSlot armorType)
	{
		super(properties);
		this.name = name;
		this.armorType = armorType;
	}
	
	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public CompoundTag getItemArmorDecorationData(ItemStack stack) {
		CompoundTag compoundnbt = new CompoundTag();

		compoundnbt.putString("name", this.name);
		compoundnbt.putBoolean("dyeable", false);
		compoundnbt.putInt("color", 1);

		return compoundnbt;
	}

	@Override
	public EquipmentSlot getArmorType()
	{
		return this.armorType;
	}
}
