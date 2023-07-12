package com.magistuarmory.forge.item.armor;

import com.magistuarmory.item.armor.MedievalArmorItem;
import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import java.util.function.Consumer;

public class MedievalArmorItemForge extends MedievalArmorItem
{
	public MedievalArmorItemForge(ArmorMaterial material, EquipmentSlot type, Properties properties)
	{
		super(material, type, properties);
	}

	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer)
	{
		consumer.accept(new IItemRenderProperties()
		{
			@Override
			public HumanoidModel<?> getArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> _default)
			{
				return Platform.getEnvironment() == Env.CLIENT ? MedievalArmorItemForge.this.getArmorModel(slot, _default) : null;
			}
		});
	}
}
