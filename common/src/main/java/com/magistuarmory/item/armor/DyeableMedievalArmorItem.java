package com.magistuarmory.item.armor;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public class DyeableMedievalArmorItem extends MedievalArmorItem implements DyeableLeatherItem
{
    int defaultcolor;

	public DyeableMedievalArmorItem(ArmorMaterial material, EquipmentSlot type, Properties properties, int defaultcolor)
    {
        super(material, type, properties);
        this.defaultcolor = defaultcolor;
    }

    @Override
    public int getColor(ItemStack stack)
    {
        CompoundTag compoundnbt = stack.getTagElement("display");
        return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : defaultcolor;
    }
}
