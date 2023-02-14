package com.magistuarmory.util;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.item.ModItems;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.item.*;

import java.util.Random;

public class EquipmentHelper {
    static final ArmorItem[] rustedHelmets = new ArmorItem[] { ModItems.RUSTED_CHAINMAIL_HELMET.get(), ModItems.RUSTED_NORMAN_HELMET.get(), ModItems.RUSTED_KETTLEHAT.get(), ModItems.RUSTED_BARBUTE.get(), ModItems.RUSTED_GREATHELM.get() };
    static final ArmorItem[] rustedChestplates = new ArmorItem[] { ModItems.RUSTED_CHAINMAIL_CHESTPLATE.get(), ModItems.RUSTED_CRUSADER_CHESTPLATE.get(), ModItems.RUSTED_HALFARMOR_CHESTPLATE.get() };
    static final ArmorItem[] rustedLeggings = new ArmorItem[] { ModItems.RUSTED_CHAINMAIL_LEGGINGS.get() };
    static final ArmorItem[] rustedBoots = new ArmorItem[] { ModItems.RUSTED_CHAINMAIL_BOOTS.get(), ModItems.RUSTED_CRUSADER_BOOTS.get() };

    static final Item[] rustedMeleeWeapons = new Item[] { ModItems.RUSTED_BASTARD_SWORD.get(), ModItems.RUSTED_BASTARD_SWORD.get(), ModItems.RUSTED_HEAVY_MACE.get() };
    static final Item[] rustedShields = new ShieldItem[] { ModItems.CORRUPTED_ROUND_SHIELD.get() };

    static final ArmorItem[] goldenHelmets = new ArmorItem[] { (ArmorItem) Items.GOLDEN_HELMET };
    static final ArmorItem[] goldenChestplates = new ArmorItem[] { (ArmorItem) Items.GOLDEN_CHESTPLATE };
    static final ArmorItem[] goldenLeggings = new ArmorItem[] { (ArmorItem) Items.GOLDEN_LEGGINGS };
    static final ArmorItem[] goldenBoots = new ArmorItem[] { (ArmorItem) Items.GOLDEN_BOOTS };

    static final ArmorItem[] banditHelmets = new ArmorItem[] {};
    static final ArmorItem[] banditChestplates = new ArmorItem[] { ModItems.BRIGANDINE.get() };
    static final ArmorItem[] banditLeggings = new ArmorItem[] {};
    static final ArmorItem[] banditBoots = new ArmorItem[] { ModItems.GAMBESON_BOOTS.get() };

    static final Item[] goldenMeleeWeapons = new Item[] { ModItems.BASTARD_SWORDS.gold.get(), ModItems.GUISARMES.gold.get(), ModItems.SHORT_SWORDS.gold.get(), ModItems.LOCHABER_AXES.gold.get() };
    static final Item[] goldenShields = new Item[] { ModItems.BUCKLERS.gold.get(), ModItems.TARGETS.gold.get() };

    static final Item[] skeletonRangedWeapons = new Item[] { Items.BOW };

    static final ArmorItem[] witherHelmets = new ArmorItem[] { ModItems.SALLET.get(), ModItems.MAXIMILIAN_HELMET.get() };
    static final ArmorItem[] witherChestplates = new ArmorItem[] { ModItems.GOTHIC_CHESTPLATE.get(), ModItems.MAXIMILIAN_CHESTPLATE.get() };
    static final ArmorItem[] witherLeggings = new ArmorItem[] { ModItems.GOTHIC_LEGGINGS.get(), ModItems.MAXIMILIAN_LEGGINGS.get() };
    static final ArmorItem[] witherBoots = new ArmorItem[] { ModItems.GOTHIC_BOOTS.get(), ModItems.MAXIMILIAN_BOOTS.get() };

    static final Item[] witherMeleeWeapons = new Item[] { ModItems.ZWEIHANDERS.steel.get(), ModItems.FLAME_BLADED_SWORDS.steel.get(), ModItems.LUCERNE_HAMMERS.steel.get()};

    public static void equip(Entity entity)
    {
        if (KnightlyArmory.CONFIG.equipMonsters && entity.level.getDifficulty().equals(Difficulty.HARD))
        {
            double chance = KnightlyArmory.CONFIG.equipChance;
            
            if (entity instanceof Zombie && !((Zombie)entity).isBaby() && !(entity instanceof ZombifiedPiglin) && !(entity instanceof ZombieVillager))
            {
                Random rand0 = new Random();
                setRandomItemSlot(entity, EquipmentSlot.HEAD, rustedHelmets, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.CHEST, rustedChestplates, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.LEGS, rustedLeggings, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.FEET, rustedBoots, chance, rand0);
                
                if (setRandomItemSlot(entity, EquipmentSlot.MAINHAND, rustedMeleeWeapons, chance, rand0));
                {
                    setRandomItemSlot(entity, EquipmentSlot.OFFHAND, rustedShields, 0.5f * chance, rand0);
                }
            }
            else if (entity instanceof PiglinBrute || entity instanceof ZombifiedPiglin)
            {
                Random rand0 = new Random();
                if ((rand0).nextInt(2) == 1)
                {
                    setRandomItemSlot(entity, EquipmentSlot.HEAD, goldenHelmets, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlot.CHEST, goldenChestplates, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlot.LEGS, goldenLeggings, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlot.FEET, goldenBoots, chance, rand0);
                }
                else
                {
                    setRandomItemSlot(entity, EquipmentSlot.HEAD, banditHelmets, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlot.CHEST, banditChestplates, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlot.LEGS, banditLeggings, chance, rand0);
                    setRandomItemSlot(entity, EquipmentSlot.FEET, banditBoots, chance, rand0);
                }
                if (setRandomItemSlot(entity, EquipmentSlot.MAINHAND, goldenMeleeWeapons, chance, rand0));
                {
                    setRandomItemSlot(entity, EquipmentSlot.OFFHAND, goldenShields, 0.5f * chance, rand0);
                }
            }
            else if (entity instanceof Skeleton)
            {
                Random rand0 = new Random();
                setRandomItemSlot(entity, EquipmentSlot.HEAD, rustedHelmets, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.CHEST, rustedChestplates, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.LEGS, rustedLeggings, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.FEET, rustedBoots, chance, rand0);
                if (setRandomItemSlot(entity, EquipmentSlot.MAINHAND, rustedMeleeWeapons, chance, rand0))
                {
                    setRandomItemSlot(entity, EquipmentSlot.OFFHAND, rustedShields, 0.5f * chance, rand0);
                }
                else
                {
                    setRandomItemSlot(entity, EquipmentSlot.MAINHAND, skeletonRangedWeapons, chance, rand0);
                }
            }
            else if (entity instanceof WitherSkeleton)
            {
                Random rand0 = new Random();
                setRandomItemSlot(entity, EquipmentSlot.HEAD, witherHelmets, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.CHEST, witherChestplates, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.LEGS, witherLeggings, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.FEET, witherBoots, chance, rand0);
                setRandomItemSlot(entity, EquipmentSlot.MAINHAND, witherMeleeWeapons, chance, rand0, Items.STONE_SWORD);
            }
        }
    }

    static boolean setRandomItemSlot(Entity entity, EquipmentSlot slot, Item[] items, double chance, Random rand)
    {
        return setRandomItemSlot(entity, slot, items, chance, rand, Items.AIR);
    }

    static boolean setRandomItemSlot(Entity entity, EquipmentSlot slot, Item[] items, double chance, Random rand, Item defaultItem)
    {
        if (items.length == 0)
        {
            if (KnightlyArmory.CONFIG.overrideEquipment);
            {
                entity.setItemSlot(slot, new ItemStack(defaultItem));
            }
            return false;
        }

        int id = rand.nextInt((int) (items.length / chance));

        if (id < items.length)
        {
            entity.setItemSlot(slot, new ItemStack(items[id]));
            return true;
        }
        else if (KnightlyArmory.CONFIG.overrideEquipment)
        {
            entity.setItemSlot(slot, new ItemStack(defaultItem));
        }

        return false;
    }
}
