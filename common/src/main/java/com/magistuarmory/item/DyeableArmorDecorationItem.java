package com.magistuarmory.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public class DyeableArmorDecorationItem extends ArmorDecorationItem implements DyeableLeatherItem
{
	int defaultcolor;

	public DyeableArmorDecorationItem(ResourceLocation location, Properties properties, ArmorItem.Type armorType)
	{
		this(location, properties, armorType, 16777215);
		this.armorType = armorType;
	}

	public DyeableArmorDecorationItem(ResourceLocation location, Properties properties, ArmorItem.Type armorType, int defaultcolor)
	{
		super(location, properties, armorType);
		this.defaultcolor = defaultcolor;
	}
	
	@Override
	public int getColor(ItemStack stack)
	{
		CompoundTag compoundnbt = stack.getTagElement("display");
		return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : this.defaultcolor;
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
