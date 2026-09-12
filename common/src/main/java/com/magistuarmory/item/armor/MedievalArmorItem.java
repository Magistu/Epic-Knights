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
import net.minecraft.world.item.Item;

import java.util.Optional;


public class MedievalArmorItem extends Item implements ISurcoat
{
	@Nullable
	protected HumanoidModel<net.minecraft.client.renderer.entity.state.HumanoidRenderState> model = null;
	
	private final ArmorType armortype;
    protected final net.minecraft.world.item.equipment.ArmorType type;
    public net.minecraft.world.item.equipment.ArmorType getType() { return type; }

	public MedievalArmorItem(ArmorType armortype, net.minecraft.world.item.equipment.ArmorType type, Properties properties)
	{
		super(properties.humanoidArmor(armortype.getMaterial(), type).durability(armortype.getDurabilityForType(type)).stacksTo(1));
		this.armortype = armortype;
        this.type = type;
	}

	public EquipmentSlot getEquipmentSlot() { return type.getSlot(); }

	public ArmorType getArmorType()
	{
		return this.armortype;
	}

	@Deprecated(forRemoval = true)
	@Environment(EnvType.CLIENT)
	public void loadModel(EntityRendererProvider.Context context)
	{
		Optional<ModelLayerLocation> location = this.armortype.getModelLocation();
        this.model = location.map(
				l -> new HumanoidModel<>(context.bakeLayer(l))).orElseGet(
						() -> getType() == net.minecraft.world.item.equipment.ArmorType.LEGGINGS ? ModRender.INNER_ARMOR : ModRender.OUTER_ARMOR);
	}

	@Environment(EnvType.CLIENT)
	public void setModel(HumanoidModel<net.minecraft.client.renderer.entity.state.HumanoidRenderState> model) {
		this.model = model;
	}

	@Environment(EnvType.CLIENT)
	public HumanoidModel<? extends net.minecraft.client.renderer.entity.state.HumanoidRenderState> getArmorModel(EquipmentSlot slot, HumanoidModel<? extends net.minecraft.client.renderer.entity.state.HumanoidRenderState> _default)
	{
		if (slot == this.type.getSlot() && this.model != null) {
			return this.model;
		}
		return _default;
	}
}
