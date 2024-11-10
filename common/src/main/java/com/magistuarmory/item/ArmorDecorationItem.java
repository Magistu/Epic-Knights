package com.magistuarmory.item;

import com.google.common.collect.Lists;
import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.render.model.ModModels;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArmorDecorationItem extends Item implements ArmorDecoration
{
	ResourceLocation location;
	ArmorItem.Type armorType;

	public ArmorDecorationItem(ResourceLocation location, Properties properties, ArmorItem.Type armorType)
	{
		super(properties);
		this.location = location;
		this.armorType = armorType;
	}
	
	@Override
	public ResourceLocation getResourceLocation()
	{
		return this.location;
	}

	@Override
	public ArmorItem.Type getArmorType()
	{
		return this.armorType;
	}

	public record DecorationInfo(String name, boolean dyeable, int color) 
	{
		public ResourceLocation location()
		{
			ResourceLocation loc = new ResourceLocation(this.name);
			return new ResourceLocation(!loc.getNamespace().equals("minecraft") ? loc.getNamespace() : EpicKnights.ID, loc.getPath());
		}
	}

	public static List<DecorationInfo> createDecorations(@Nullable ListTag listtag)
	{
		List<DecorationInfo> list = Lists.newArrayList();
		if (listtag != null)
		{
			for (int i = 0; i < listtag.size(); ++i)
			{
				CompoundTag tag = listtag.getCompound(i);
				String name = tag.getString("name");
				boolean dyeable = tag.getBoolean("dyeable");
				int j = tag.getInt("color");
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
				stack.getItem() instanceof ArmorItem armor &&
				this.getArmorType() == armor.getType();
	}

	public static ListTag getDecorationTags(ItemStack stack)
	{
		CompoundTag compoundtag = stack.getTagElement("ArmorDecoration");
		if (compoundtag == null)
			return new ListTag();

		return compoundtag.getList("Items", 10);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public ModelLayerLocation createModelLocation()
	{
		return ModModels.createDecorationLocation(this.location);
	}
}
