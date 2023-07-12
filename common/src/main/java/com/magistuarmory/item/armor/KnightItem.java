package com.magistuarmory.item.armor;

import com.magistuarmory.client.render.model.Models;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.objectweb.asm.TypeReference;

public class KnightItem extends MedievalArmorItem implements ISurcoat, DyeableLeatherItem
{
	public KnightItem(ArmorMaterial material, EquipmentSlot type, Item.Properties properties) {
		super(material, type, properties);
	}

	@Environment(EnvType.CLIENT)
	@Override
	public HumanoidModel<? extends LivingEntity> getArmorModel(EquipmentSlot slot, HumanoidModel<? extends LivingEntity> _default)
	{
		return slot == EquipmentSlot.HEAD ? Models.ARMET : super.getArmorModel(slot, _default);
	}

	@Override
    public int getColor(ItemStack stack)
    {
        CompoundTag compoundnbt = stack.getTagElement("display");
        return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : -10092544;
    }
}
