package com.magistuarmory.item;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public interface ArmorDecoration extends ItemLike
{
	ResourceLocation getResourceLocation();
	
	CompoundTag getCompoundTag(ItemStack stack);
	
	ArmorItem.Type getArmorType();
	
	boolean isApplicableForDecoration(ItemStack stack);

	default void decorate(ItemStack armorstack, ItemStack decorationstack)
	{
		CompoundTag compoundtag = armorstack.getTagElement("ArmorDecoration");
		ListTag listtag = ArmorDecorationItem.getDecorationTags(armorstack);

		if (compoundtag == null || listtag.isEmpty())
			armorstack.setHoverName(Component.translatable("magistuarmory.decorated", armorstack.getHoverName().getString()));

		CompoundTag compoundtag1 = compoundtag != null ? compoundtag.copy() : new CompoundTag();

		CompoundTag decorationdata = this.getCompoundTag(decorationstack);
		String name = decorationdata.getString("name");

		boolean set = false;
		for (int i = 0; i < listtag.size(); ++i)
		{
			if (listtag.getCompound(i).getString("name").equals(name))
			{
				listtag.set(i, decorationdata);
				set = true;
				break;
			}
		}
		if (!set)
		{
			listtag.add(decorationdata);
		}

		compoundtag1.put("Items", listtag);

		armorstack.addTagElement("ArmorDecoration", compoundtag1);
	}
	
	ModelLayerLocation createModelLocation();

	@Override
	default @NotNull Item asItem()
	{
		return (Item) this;
 	}
}
