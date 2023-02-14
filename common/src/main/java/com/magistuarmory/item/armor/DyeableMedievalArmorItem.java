package com.magistuarmory.item.armor;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public class DyeableMedievalArmorItem extends MedievalArmorItem implements DyeableLeatherItem
{
    int defaultcolor;

	public DyeableMedievalArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties, int defaultcolor)
    {
        super(material, slot, properties);
        this.defaultcolor = defaultcolor;
    }

    @Override
    public int getColor(ItemStack stack)
    {
        CompoundTag compoundnbt = stack.getTagElement("display");
        return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : defaultcolor;
    }
}
