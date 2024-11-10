package com.magistuarmory.item.armor;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.item.ArmorDecorationItem;
import com.magistuarmory.item.IHasModelProperty;
import com.magistuarmory.item.ModItems;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

import static com.magistuarmory.item.ArmorDecorationItem.createDecorations;
import static com.magistuarmory.item.ArmorDecorationItem.getDecorationTags;

public class KnightItem extends MedievalArmorItem implements ISurcoat, DyeableLeatherItem, IHasModelProperty
{
	public KnightItem(ArmorMaterial material, Type type, Properties properties) {
		super(material, type, properties);
	}

	@Override
	public boolean hasCustomColor(ItemStack itemstack)
	{
		return getColor(itemstack) != 0;
	}

	@Override
    public int getColor(ItemStack itemstack)
    {
	    ArmorDecorationItem.DecorationInfo info = getPlumeDecorationInfo(itemstack);
		return info != null ? info.color() : 0;
    }

	@Override
	public void setColor(ItemStack itemstack, int col)
	{
		ListTag listtag = getDecorationTags(itemstack);
		String plumename = ModItems.BIG_PLUME_DECORATION.get().getResourceLocation().toString();
		for (int i = 0; i < listtag.size(); ++i)
		{
			CompoundTag tag = listtag.getCompound(i);
			if (Objects.equals(tag.getString("name"), plumename))
				tag.putInt("color", col);
		}
	}

	public boolean hasPlume(ItemStack itemstack)
	{
		return getPlumeDecorationInfo(itemstack) != null;
	}
	
	public ArmorDecorationItem.DecorationInfo getPlumeDecorationInfo(ItemStack itemstack)
	{
		CompoundTag tag = itemstack.getTagElement("ArmorDecoration");
		if (tag == null)
			return null;
		String plumename = ModItems.BIG_PLUME_DECORATION.get().getResourceLocation().toString();
		for (ArmorDecorationItem.DecorationInfo info : createDecorations(getDecorationTags(itemstack)))
		{
			if (Objects.equals(info.name(), plumename))
				return info;
		}
		return null;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void registerModelProperty()
	{
		ItemPropertiesRegistry.register(this, new ResourceLocation(EpicKnights.ID, "has_plume"), (stack, level, entity, i) -> this.hasPlume(stack) ? 1 : 0);
	}
}
