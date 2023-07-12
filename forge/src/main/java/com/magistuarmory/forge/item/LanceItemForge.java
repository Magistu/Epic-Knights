package com.magistuarmory.forge.item;

import com.google.common.collect.Multimap;
import com.magistuarmory.item.LanceItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.WeaponType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;


public class LanceItemForge extends LanceItem
{
	public LanceItemForge(Properties properties, ModItemTier material, WeaponType type)
	{
		super(properties, material, type);
	}

	@Override
	public boolean onEntitySwing(ItemStack stack, LivingEntity entityLiving)
	{
		return true;
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction action)
	{
		return (type.canBlock() && ToolActions.DEFAULT_SHIELD_ACTIONS.contains(action)) || ToolActions.DEFAULT_SWORD_ACTIONS.contains(action);
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack)
	{
		return super.getAttributeModifiers(stack, slot);
	}
}