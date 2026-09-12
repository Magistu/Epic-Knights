package com.magistuarmory.neoforge.item;

import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.WeaponType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;


public class MedievalWeaponItemNeoForge extends MedievalWeaponItem
{
    public MedievalWeaponItemNeoForge(Properties properties, ModItemTier material, WeaponType type)
    {
        super(properties, material, type);
    }

    @Override
    public boolean onAttackClickEntity(ItemStack stack, Player player, Entity entity)
    {
        return true;
    }
}
