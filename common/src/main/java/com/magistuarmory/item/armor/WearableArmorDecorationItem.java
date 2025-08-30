package com.magistuarmory.item.armor;

import com.magistuarmory.api.client.render.model.ModModelsProvider;
import com.magistuarmory.item.ArmorDecoration;
import com.magistuarmory.item.ArmorDecorationItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class WearableArmorDecorationItem extends MedievalArmorItem implements ArmorDecoration
{
	public WearableArmorDecorationItem(ArmorType material, Type type, Properties properties)
	{
		super(material, type, properties);
	}

	@Override
	public ResourceLocation getResourceLocation()
	{
		return this.getArmorType().getLocation();
	}

	@Override
	public CompoundTag getCompoundTag(ItemStack stack)
	{
		CompoundTag compoundnbt = new CompoundTag();

		compoundnbt.putString("name", this.getResourceLocation().toString());
		compoundnbt.putBoolean("dyeable", true);
		compoundnbt.putInt("color", 1);

		return compoundnbt;
	}

	@Override
	public @NotNull Type getType()
	{
		return this.type;
	}

	@Override
	public boolean isApplicableForDecoration(ItemStack stack)
	{
		return stack.getItem() != this &&
				ArmorDecorationItem.getDecorationTags(stack).size() < 8 &&
				stack.getItem() instanceof ArmorItem armor &&
				this.getType() == armor.getType();
	}

	@Override
	@Environment(EnvType.CLIENT)
	public ModelLayerLocation createModelLocation()
	{
		return ModModelsProvider.createDecorationLocation(this.getResourceLocation());
	}
}
