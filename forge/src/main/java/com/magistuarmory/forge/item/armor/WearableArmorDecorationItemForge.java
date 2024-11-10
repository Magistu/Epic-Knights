package com.magistuarmory.forge.item.armor;

import com.magistuarmory.item.armor.WearableArmorDecorationItem;
import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class WearableArmorDecorationItemForge extends WearableArmorDecorationItem
{
	public WearableArmorDecorationItemForge(ArmorMaterial material, Type type, Properties properties)
	{
		super(material, type, properties);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer)
	{
		consumer.accept(new IClientItemExtensions()
		{
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> _default)
			{
				return Platform.getEnvironment() == Env.CLIENT ? WearableArmorDecorationItemForge.this.getArmorModel(slot, _default) : null;
			}
		});
	}
}
