package com.magistuarmory.item;

import com.magistuarmory.component.ModDataComponents;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public interface ArmorDecoration extends ItemLike
{
	ResourceLocation getResourceLocation();
	
	CompoundTag getCompoundTag(ItemStack stack);
	
	ArmorItem.Type getType();
	
	boolean isApplicableForDecoration(ItemStack stack);

	default void decorate(ItemStack armorstack, ItemStack decorationstack)
	{
		CustomData data = armorstack.get(ModDataComponents.ARMOR_DECORATION.get());
		ListTag listtag = ArmorDecorationItem.getDecorationTags(armorstack);

		if (data == null || listtag.isEmpty())
			armorstack.set(DataComponents.CUSTOM_NAME, Component.translatable("magistuarmory.decorated", Component.translatable(armorstack.getHoverName().getString())));

		CompoundTag compoundtag1 = data != null ? data.copyTag() : new CompoundTag();

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

		armorstack.set(ModDataComponents.ARMOR_DECORATION.get(), CustomData.of(compoundtag1));
	}
	
	ModelLayerLocation createModelLocation();

	@Override
	default @NotNull Item asItem()
	{
		return (Item) this;
 	}
}
