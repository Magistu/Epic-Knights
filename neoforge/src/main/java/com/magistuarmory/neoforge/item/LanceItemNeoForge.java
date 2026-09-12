package com.magistuarmory.neoforge.item;

import com.magistuarmory.item.LanceItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.WeaponType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;


public class LanceItemNeoForge extends LanceItem
{
	public LanceItemNeoForge(Properties properties, ModItemTier material, WeaponType type)
	{
		super(properties, material, type);
	}

	@Override
	public boolean onEntitySwing(ItemStack stack, LivingEntity entityLiving, net.minecraft.world.InteractionHand hand)
	{
		return true;
	}
}