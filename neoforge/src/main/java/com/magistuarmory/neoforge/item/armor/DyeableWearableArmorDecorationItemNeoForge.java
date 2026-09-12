package com.magistuarmory.neoforge.item.armor;

import com.magistuarmory.item.armor.ArmorType;
import com.magistuarmory.item.armor.DyeableWearableArmorDecorationItem;


public class DyeableWearableArmorDecorationItemNeoForge extends DyeableWearableArmorDecorationItem
{
	public DyeableWearableArmorDecorationItemNeoForge(ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Properties properties, int defaultcolor)
	{
		super(material, type, properties, defaultcolor);
	}

	@Override
	public int getDefaultColor() {
		return super.getDefaultColor();
	}
}
