package com.magistuarmory.forge.item.armor;

import com.magistuarmory.item.armor.DyeableMedievalArmorItem;
import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;

import java.util.function.Consumer;


public class DyeableMedievalArmorItemForge extends DyeableMedievalArmorItem implements DyeableLeatherItem
{
	public DyeableMedievalArmorItemForge(ArmorMaterial material, EquipmentSlot type, Properties properties, int defaultcolor)
    {
        super(material, type, properties, defaultcolor);
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer)
    {
        consumer.accept(new IItemRenderProperties()
        {
            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> _default)
            {
                return Platform.getEnvironment() == Env.CLIENT ? DyeableMedievalArmorItemForge.this.getArmorModel(slot, _default) : null;
            }
        });
    }
}
