package com.magistuarmory.neoforge.item.armor;

import com.magistuarmory.item.armor.ArmorType;
import com.magistuarmory.item.armor.DyeableMedievalArmorItem;


public class DyeableMedievalArmorItemNeoForge extends DyeableMedievalArmorItem
{
	public DyeableMedievalArmorItemNeoForge(ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Properties properties, int defaultcolor)
    {
        super(material, type, properties, defaultcolor);
    }

    @Override
    public int getDefaultColor() {
        return super.getDefaultColor();
    }
}
