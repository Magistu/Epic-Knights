package com.magistuarmory.item.armor;

import com.magistuarmory.client.render.ModRender;
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
	protected HumanoidModel<LivingEntity> model = null;
	
	public MedievalArmorItem(ArmorMaterial material, Type type, Properties properties)
	{
		super(material, type, properties);
	}

	@Deprecated(forRemoval = true)
	@Environment(EnvType.CLIENT)
	public void loadModel(EntityRendererProvider.Context context) {
		if (this.getMaterial() instanceof ArmorType armortype) {
			Optional<ModelLayerLocation> location = armortype.getModelLocation();
            this.model = location.map(
					l -> new HumanoidModel<>(context.bakeLayer(l))).orElseGet(
							() -> getEquipmentSlot() == EquipmentSlot.LEGS ? ModRender.OUTER_ARMOR : ModRender.INNER_ARMOR);
		}
	}

	@Environment(EnvType.CLIENT)
	public void setModel(HumanoidModel<LivingEntity> model) {
		this.model = model;
	}

	@Environment(EnvType.CLIENT)
	public HumanoidModel<? extends LivingEntity> getArmorModel(EquipmentSlot slot, HumanoidModel<? extends LivingEntity> _default)
	{
		if (slot == this.type.getSlot() && this.model != null) {
			return this.model;
		}
		return _default;
	}
}
