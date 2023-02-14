package com.magistuarmory.item.armor;

import com.magistuarmory.client.render.model.Models;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class JoustingItem extends MedievalArmorItem implements ISurcoat
{
	public JoustingItem(ArmorMaterial material, EquipmentSlot slot, Item.Properties properties)
	{
		super(material, slot, properties);
	}

	@Environment(EnvType.CLIENT)
	@Override
	public HumanoidModel<? extends LivingEntity> getArmorModel(EquipmentSlot slot, HumanoidModel<? extends LivingEntity> _default)
	{
		return slot == EquipmentSlot.HEAD ? Models.STECHHELM : super.getArmorModel(slot, _default);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean selected)
	{
		if (entity instanceof LivingEntity livingentity && livingentity.getItemBySlot(this.getSlot()) == stack)
		{
			livingentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1, false, false, false));
		}
		super.inventoryTick(stack, level, entity, i, selected);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag)
	{
		tooltip.add((new TextComponent("Slow movement speed")).withStyle(ChatFormatting.RED));
	}
}
