package com.magistuarmory.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;

public class DyeableArmorDecorationItem extends ArmorDecorationItem implements DyeableItemLike
{
	int defaultcolor;

	public DyeableArmorDecorationItem(Identifier location, Properties properties, net.minecraft.world.item.equipment.ArmorType armorType)
	{
		this(location, properties, armorType, 0xFFFFFFFF);
		this.armorType = armorType;
	}

	public DyeableArmorDecorationItem(Identifier location, Properties properties, net.minecraft.world.item.equipment.ArmorType armorType, int defaultcolor)
	{
		super(location, properties, armorType);
		this.defaultcolor = ARGB.opaque(defaultcolor);
	}

	public void setColor(ItemStack stack, int color)
	{
		stack.set(DataComponents.DYED_COLOR, new DyedItemColor(color));
	}
	
	@Override
	public int getColor(ItemStack stack)
	{
		DyedItemColor color = stack.get(DataComponents.DYED_COLOR);
		return ARGB.opaque(color != null ? color.rgb() : defaultcolor);
	}

	@Override
	public CompoundTag getCompoundTag(ItemStack stack) {
		CompoundTag compoundnbt = new CompoundTag();

		compoundnbt.putString("name", this.location.toString());
		compoundnbt.putBoolean("dyeable", true);
		compoundnbt.putInt("color", this.getColor(stack));
		
		return compoundnbt;
	}
}
