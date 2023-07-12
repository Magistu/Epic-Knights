package com.magistuarmory.util;

import com.magistuarmory.EpicKnights;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

import java.util.List;
import java.util.Random;

public class MobEquipmentHelper
{
    public static void equip(LivingEntity entity)
    {
        if (!entity.level.isClientSide() && EpicKnights.GENERAL_CONFIG.equipMonsters && (!EpicKnights.GENERAL_CONFIG.equipMonstersOnlyIfHard || entity.level.getDifficulty().equals(Difficulty.HARD)))
        {
            Random rand = entity.level.getRandom();
            List<MobEquipment> equipments = MobEquipment.get(entity);
            if (equipments.size() > 0)
                equipments.get(rand.nextInt(equipments.size())).equip(entity, rand);
        }
    }

    static void setRandomItemSlot(LivingEntity entity, EquipmentSlot slot, List<? extends Item> items, double chance, Random rand)
    {
        if (items.size() == 0)
        {
            if (EpicKnights.GENERAL_CONFIG.overrideEquipment)
                entity.setItemSlot(slot, new ItemStack(Items.AIR));
            return;
        }

        int id = rand.nextInt((int) (items.size() / chance));

        if (id < items.size())
            entity.setItemSlot(slot, new ItemStack(items.get(id)));
        
        else if (EpicKnights.GENERAL_CONFIG.overrideEquipment)
            entity.setItemSlot(slot, new ItemStack(Items.AIR));
    }
}
