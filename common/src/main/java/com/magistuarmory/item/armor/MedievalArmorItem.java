package com.magistuarmory.item.armor;

import com.magistuarmory.client.render.ModRender;
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
		if (getEquipmentSlot() == EquipmentSlot.LEGS) {
			this.model = ModRender.INNER_ARMOR;
		}
		Optional<ModelLayerLocation> location = this.armortype.getModelLocation();
		if (location.isPresent()) {
			this.model = new HumanoidModel<>(context.bakeLayer(location.get()));
		} else {
			this.model = ModRender.OUTER_ARMOR;
		}
	}

	@Environment(EnvType.CLIENT)
	public HumanoidModel<? extends LivingEntity> getArmorModel(EquipmentSlot slot, HumanoidModel<? extends LivingEntity> _default)
	{
		if (slot != EquipmentSlot.LEGS && slot == this.type.getSlot() && this.model != null) {
			return this.model;
		}
		return _default;
	}
}
