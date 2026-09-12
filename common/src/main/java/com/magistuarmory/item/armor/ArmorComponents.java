package com.magistuarmory.item.armor;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.Equippable;

public final class ArmorComponents {
    private ArmorComponents() {}
    public static Equippable equippable(Item item) { return item.components().get(DataComponents.EQUIPPABLE); }
    public static boolean isArmor(Item item) {
        Equippable equipment = equippable(item);
        return equipment != null && equipment.slot().isArmor();
    }
    public static EquipmentSlot slot(Item item) {
        Equippable equipment = equippable(item);
        return equipment == null ? null : equipment.slot();
    }
    public static boolean isArmor(ItemStack stack) {
        Equippable equipment = stack.get(DataComponents.EQUIPPABLE);
        return equipment != null && equipment.slot().isArmor();
    }
}
