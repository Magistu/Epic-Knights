package com.magistuarmory.item.armor;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.api.client.render.model.ModModelsProvider;
import com.magistuarmory.item.ArmorDecoration;
import com.magistuarmory.item.ArmorDecorationItem;
import com.magistuarmory.item.armor.DyeableMedievalArmorItem;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class DyeableWearableArmorDecorationItem extends DyeableMedievalArmorItem implements ArmorDecoration
{
	public DyeableWearableArmorDecorationItem(ArmorMaterial material, Type type, Properties properties, int defaultcolor)
	{
		super(material, type, properties, defaultcolor);
	}

	@Override
	public ResourceLocation getResourceLocation()
	{
		return new ResourceLocation(this.getMaterial().getName());
	}

	@Override
	public CompoundTag getCompoundTag(ItemStack stack)
	{
		CompoundTag compoundnbt = new CompoundTag();

		compoundnbt.putString("name", this.getResourceLocation().toString());
		compoundnbt.putBoolean("dyeable", true);
		compoundnbt.putInt("color", this.getColor(stack));

		return compoundnbt;
	}

	@Override
	public Type getArmorType()
	{
		return this.getType();
	}

	@Override
	public boolean isApplicableForDecoration(ItemStack stack)
	{
		return stack.getItem() != this &&
				ArmorDecorationItem.getDecorationTags(stack).size() < 8 &&
				stack.getItem() instanceof ArmorItem armor &&
				this.getArmorType() == armor.getType();
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag)
	{
		super.appendHoverText(stack, level, tooltip, flag);
		tooltip.add((Component.translatable(EpicKnights.ID + ".armor_decoration." + this.getType().getName() + ".description")).withStyle(Style.EMPTY.withColor(ChatFormatting.BLUE).withItalic(true)));
	}

	@Override
	@Environment(EnvType.CLIENT)
	public ModelLayerLocation createModelLocation()
	{
		return ModModelsProvider.createDecorationLocation(this.getResourceLocation());
	}
}
