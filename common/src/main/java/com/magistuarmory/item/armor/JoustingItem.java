package com.magistuarmory.item.armor;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class JoustingItem extends MedievalArmorItem implements ISurcoat
{
	public JoustingItem(ArmorMaterial material, Type type, Properties properties)
	{
		super(material, type, properties);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean selected)
	{
		if (entity instanceof LivingEntity livingentity && livingentity.getItemBySlot(this.getType().getSlot()) == stack)
			livingentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1, false, false, false));
		
		super.inventoryTick(stack, level, entity, i, selected);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag)
	{
		tooltip.add((Component.translatable("slowmovementspeed")).withStyle(ChatFormatting.RED));
	}
}
