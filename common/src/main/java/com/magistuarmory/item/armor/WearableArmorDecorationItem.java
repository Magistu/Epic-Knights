package com.magistuarmory.item.armor;

import com.magistuarmory.api.client.render.model.ModModelsProvider;
import com.magistuarmory.item.ArmorDecoration;
import com.magistuarmory.item.ArmorDecorationItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;

import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class WearableArmorDecorationItem extends MedievalArmorItem implements ArmorDecoration
{
	public WearableArmorDecorationItem(ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Properties properties)
	{
		super(material, type, properties);
	}

	@Override
	public Identifier getIdentifier()
	{
		return this.getArmorType().getLocation();
	}

	@Override
	public CompoundTag getCompoundTag(ItemStack stack)
	{
		CompoundTag compoundnbt = new CompoundTag();

		compoundnbt.putString("name", this.getIdentifier().toString());
		compoundnbt.putBoolean("dyeable", true);
		compoundnbt.putInt("color", 1);

		return compoundnbt;
	}

	@Override
	public @NotNull net.minecraft.world.item.equipment.ArmorType getType()
	{
		return this.type;
	}

	@Override
	public boolean isApplicableForDecoration(ItemStack stack)
	{
		return stack.getItem() != this &&
				ArmorDecorationItem.getDecorationTags(stack).size() < 8 &&
				com.magistuarmory.item.armor.ArmorComponents.isArmor(stack) &&
				this.getType().getSlot() == com.magistuarmory.item.armor.ArmorComponents.slot(stack.getItem());
	}

	@Override
	@Environment(EnvType.CLIENT)
	public ModelLayerLocation createModelLocation()
	{
		return ModModelsProvider.createDecorationLocation(this.getIdentifier());
	}
}
