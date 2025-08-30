package com.magistuarmory.neoforge.item;

import com.magistuarmory.item.LanceItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.WeaponType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;


public class LanceItemNeoForge extends LanceItem
{
	public LanceItemNeoForge(Properties properties, ModItemTier material, WeaponType type)
	{
		super(properties, material, type);
	}

	@Override
	public boolean onEntitySwing(ItemStack stack, LivingEntity entityLiving)
	{
		return true;
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ItemAbility action)
	{
		return (type.canBlock() && ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(action)) || ItemAbilities.DEFAULT_SWORD_ACTIONS.contains(action);
	}
}