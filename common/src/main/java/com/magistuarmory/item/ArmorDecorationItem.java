package com.magistuarmory.item;

import com.google.common.collect.Lists;
import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.component.ModDataComponents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArmorDecorationItem extends Item implements ArmorDecoration
{
	Identifier location;
	net.minecraft.world.item.equipment.ArmorType armorType;

	public ArmorDecorationItem(Identifier location, Properties properties, net.minecraft.world.item.equipment.ArmorType armorType)
	{
		super(properties.stacksTo(1));
		this.location = location;
		this.armorType = armorType;
	}
	
	@Override
	public Identifier getIdentifier()
	{
		return this.location;
	}

	@Override
	public net.minecraft.world.item.equipment.ArmorType getType()
	{
		return this.armorType;
	}

	public record DecorationInfo(String name, boolean dyeable, int color) 
	{
		public Identifier location()
		{
			Identifier loc = Identifier.parse(this.name);
			return Identifier.fromNamespaceAndPath(!loc.getNamespace().equals("minecraft") ? loc.getNamespace() : EpicKnights.ID, loc.getPath());
		}
	}

	public static List<DecorationInfo> createDecorations(@Nullable ListTag listtag)
	{
		List<DecorationInfo> list = Lists.newArrayList();
		if (listtag != null)
		{
			for (int i = 0; i < listtag.size(); ++i)
			{
				CompoundTag tag = listtag.getCompoundOrEmpty(i);
				String name = tag.getStringOr("name", "");
				boolean dyeable = tag.getBooleanOr("dyeable", false);
				int j = tag.getIntOr("color", 0);
				list.add(new DecorationInfo(name, dyeable, j));
			}
		}

		return list;
	}

	@Override
	public CompoundTag getCompoundTag(ItemStack stack) {
		CompoundTag compoundnbt = new CompoundTag();

		compoundnbt.putString("name", this.location.toString());
		compoundnbt.putBoolean("dyeable", false);
		compoundnbt.putInt("color", 1);

		return compoundnbt;
	}

	@Override
	public boolean isApplicableForDecoration(ItemStack stack)
	{
		return getDecorationTags(stack).size() < 8 &&
				com.magistuarmory.item.armor.ArmorComponents.isArmor(stack) &&
				this.getType().getSlot() == com.magistuarmory.item.armor.ArmorComponents.slot(stack.getItem());
	}

	public static ListTag getDecorationTags(ItemStack stack)
	{
		CustomData data = stack.get(ModDataComponents.ARMOR_DECORATION.get());
		return data == null ? new ListTag() : data.copyTag().getListOrEmpty("Items");
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
		return ModModels.createDecorationLocation(this.location);
	}
}
