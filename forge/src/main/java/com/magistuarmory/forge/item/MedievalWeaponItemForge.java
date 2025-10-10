package com.magistuarmory.forge.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.WeaponType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.UUID;


public class MedievalWeaponItemForge extends MedievalWeaponItem
{
    static UUID BONUS_ENTITY_REACH_UUID = UUID.fromString("75ac9529-913d-4895-8386-64b20c98629a");
    
    public MedievalWeaponItemForge(Properties properties, ModItemTier material, WeaponType type)
    {
        super(properties, material, type);
    }

    @Override
    public ImmutableMultimap.Builder<Attribute, AttributeModifier> getDefaultAttributeModifiersBuilder()
    {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = super.getDefaultAttributeModifiersBuilder();
        return builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BONUS_ENTITY_REACH_UUID, "Weapon modifier", this.type.getBonusAttackReach(), AttributeModifier.Operation.ADDITION));
    }

    @Override
    public ImmutableMultimap.Builder<Attribute, AttributeModifier> getDecreasedAttributeModifiersBuilder()
    {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = super.getDecreasedAttributeModifiersBuilder();
        return builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BONUS_ENTITY_REACH_UUID, "Weapon modifier", this.type.getBonusAttackReach(), AttributeModifier.Operation.ADDITION));
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

    @Override
    public boolean onAttackClickEntity(ItemStack stack, Player player, Entity entity)
    {
        return true;
    }
}
