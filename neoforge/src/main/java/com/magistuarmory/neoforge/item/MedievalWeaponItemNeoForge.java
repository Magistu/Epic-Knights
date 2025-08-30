package com.magistuarmory.neoforge.item;

import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.WeaponType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;


public class MedievalWeaponItemNeoForge extends MedievalWeaponItem
{
    public MedievalWeaponItemNeoForge(Properties properties, ModItemTier material, WeaponType type)
    {
        super(properties, material, type);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility action)
    {
        return type.canBlock() && ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(action) || ItemAbilities.DEFAULT_SWORD_ACTIONS.contains(action);
    }

    @Override
    public boolean onAttackClickEntity(ItemStack stack, Player player, Entity entity)
    {
        return true;
    }
}
