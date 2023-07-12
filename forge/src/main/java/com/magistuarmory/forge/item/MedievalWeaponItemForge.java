package com.magistuarmory.forge.item;

import com.google.common.collect.Multimap;
import com.magistuarmory.item.IHasModelProperty;
import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.WeaponType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;


public class MedievalWeaponItemForge extends MedievalWeaponItem
{
    public MedievalWeaponItemForge(Properties properties, ModItemTier material, WeaponType type)
    {
        super(properties, material, type);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction action)
    {
        return type.canBlock() && ToolActions.DEFAULT_SHIELD_ACTIONS.contains(action) || ToolActions.DEFAULT_SWORD_ACTIONS.contains(action);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack)
    {
        return super.getAttributeModifiers(stack, slot);
    }
}
