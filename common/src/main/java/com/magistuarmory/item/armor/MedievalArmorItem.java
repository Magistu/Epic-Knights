package com.magistuarmory.item.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

import java.util.Optional;


public class MedievalArmorItem extends ArmorItem implements ISurcoat
{
	protected Optional<HumanoidModel<LivingEntity>> model = Optional.empty();
	
	public MedievalArmorItem(ArmorMaterial material, Type type, Properties properties)
	{
		super(material, type, properties);
	}

	@Environment(EnvType.CLIENT)
	public void loadModel(EntityRendererProvider.Context context)
	{
		if (this.material instanceof ArmorType armortype)
		{
			Optional<ModelLayerLocation> location = armortype.getModelLocation();
			location.ifPresent(loc -> this.model = Optional.of(new HumanoidModel<>(context.bakeLayer(loc))));
		}
	}

	@Environment(EnvType.CLIENT)
	public HumanoidModel<? extends LivingEntity> getArmorModel(EquipmentSlot slot, HumanoidModel<? extends LivingEntity> _default)
	{
		return slot == this.type.getSlot() && this.model.isPresent() ? this.model.get() : _default;
	}
}
