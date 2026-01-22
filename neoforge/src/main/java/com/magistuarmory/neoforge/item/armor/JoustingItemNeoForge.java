package com.magistuarmory.neoforge.item.armor;

import com.magistuarmory.item.armor.ArmorType;
import com.magistuarmory.item.armor.JoustingItem;
import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class JoustingItemNeoForge extends JoustingItem
{
	public JoustingItemNeoForge(ArmorType material, Type type, Properties properties)
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
				return Platform.getEnvironment() == Env.CLIENT ? JoustingItemNeoForge.this.getArmorModel(slot, _default) : null;
			}

			@Override
			public int getDefaultDyeColor(ItemStack stack) {
				return getColor(stack);
			}
		});
	}
}
