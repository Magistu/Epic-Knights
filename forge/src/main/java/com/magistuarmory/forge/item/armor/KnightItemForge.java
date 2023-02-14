package com.magistuarmory.forge.item.armor;

import com.magistuarmory.item.armor.ISurcoat;
import com.magistuarmory.item.armor.KnightItem;
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

public class KnightItemForge extends KnightItem implements DyeableLeatherItem
{
	public KnightItemForge(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);
	}

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer)
    {
        consumer.accept(new IItemRenderProperties()
        {
            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> _default)
            {
                return Platform.getEnvironment() == Env.CLIENT ? KnightItemForge.this.getArmorModel(slot, _default) : null;
            }
        });
    }
}
