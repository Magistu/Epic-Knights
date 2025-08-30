package com.magistuarmory.item.armor;

import com.magistuarmory.item.DyeableItemLike;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;

public class DyeableMedievalArmorItem extends MedievalArmorItem implements DyeableItemLike
{
    private int defaultcolor;

	public DyeableMedievalArmorItem(ArmorType material, Type type, Properties properties, int defaultcolor)
    {
        super(material, type, properties);
        this.defaultcolor = defaultcolor;
    }

    @Override
    public int getColor(ItemStack stack)
    {
        DyedItemColor color = stack.get(DataComponents.DYED_COLOR);
        return FastColor.ARGB32.opaque(color != null ? color.rgb() : defaultcolor);
    }
}
