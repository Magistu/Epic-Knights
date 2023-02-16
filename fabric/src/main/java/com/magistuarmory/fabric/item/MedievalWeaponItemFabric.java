package com.magistuarmory.fabric.item;

import com.google.common.collect.Multimap;
import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.WeaponType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class MedievalWeaponItemFabric extends MedievalWeaponItem
{
    public MedievalWeaponItemFabric(Properties properties, ModItemTier material, WeaponType type)
    {
        super(properties, material, type);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(ItemStack stack, @NotNull EquipmentSlot slot)
    {
        return super.getAttributeModifiers(stack, slot);
    }
}
