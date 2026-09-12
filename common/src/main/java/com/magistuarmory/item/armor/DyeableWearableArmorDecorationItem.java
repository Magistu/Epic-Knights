package com.magistuarmory.item.armor;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.api.client.render.model.ModModelsProvider;
import com.magistuarmory.item.ArmorDecoration;
import com.magistuarmory.item.ArmorDecorationItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DyeableWearableArmorDecorationItem extends DyeableMedievalArmorItem implements ArmorDecoration
{
	public DyeableWearableArmorDecorationItem(ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Properties properties, int defaultcolor)
	{
		super(material, type, properties, defaultcolor);
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
		compoundnbt.putInt("color", this.getColor(stack));

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
	public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> tooltip, TooltipFlag flag)
	{
		super.appendHoverText(stack, tooltipContext, display, tooltip, flag);
		tooltip.accept((Component.translatable(EpicKnights.ID + ".armor_decoration." + this.getType().getName() + ".description")).withStyle(Style.EMPTY.withColor(ChatFormatting.BLUE).withItalic(true)));
	}

	@Override
	@Environment(EnvType.CLIENT)
	public ModelLayerLocation createModelLocation()
	{
		return ModModelsProvider.createDecorationLocation(this.getIdentifier());
	}
}
