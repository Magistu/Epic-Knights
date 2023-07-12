package com.magistuarmory.item.armor;

import com.magistuarmory.client.render.model.Models;
import dev.architectury.platform.Platform;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import org.apache.commons.io.output.ThresholdingOutputStream;


public class MedievalArmorItem extends ArmorItem implements ISurcoat
{
	public MedievalArmorItem(ArmorMaterial material, EquipmentSlot type, Properties properties)
	{
		super(material, type, properties);
	}

	@Environment(EnvType.CLIENT)
	public HumanoidModel<? extends LivingEntity> getArmorModel(EquipmentSlot slot, HumanoidModel<? extends LivingEntity> _default)
	{
		return _default;
	}
}
