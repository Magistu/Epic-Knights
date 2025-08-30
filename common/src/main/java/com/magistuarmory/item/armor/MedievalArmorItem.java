package com.magistuarmory.item.armor;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;

import java.util.Optional;


public class MedievalArmorItem extends ArmorItem implements ISurcoat
{
	@Nullable
	protected HumanoidModel<LivingEntity> model = null;
	
	private final ArmorType armortype;

	public MedievalArmorItem(ArmorType armortype, Type type, Properties properties)
	{
		super(armortype.getMaterial(), type, properties.durability(armortype.getDurabilityForType(type)).stacksTo(1));
		this.armortype = armortype;
	}

	public ArmorType getArmorType()
	{
		return this.armortype;
	}

	@Environment(EnvType.CLIENT)
	public void loadModel(EntityRendererProvider.Context context)
	{
		Optional<ModelLayerLocation> location = this.armortype.getModelLocation();
		location.ifPresent(loc -> this.model = new HumanoidModel<>(context.bakeLayer(loc)));
	}

	@Environment(EnvType.CLIENT)
	public HumanoidModel<? extends LivingEntity> getArmorModel(EquipmentSlot slot, HumanoidModel<? extends LivingEntity> _default)
	{
		return slot == this.type.getSlot() && this.model != null ? this.model : _default;
	}
}
