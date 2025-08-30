package com.magistuarmory.item.armor;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.component.ModDataComponents;
import com.magistuarmory.item.ArmorDecorationItem;
import com.magistuarmory.item.DyeableItemLike;
import com.magistuarmory.item.IHasModelProperty;
import com.magistuarmory.item.ModItems;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

import java.util.Objects;

import static com.magistuarmory.item.ArmorDecorationItem.createDecorations;
import static com.magistuarmory.item.ArmorDecorationItem.getDecorationTags;

public class KnightItem extends MedievalArmorItem implements ISurcoat, DyeableItemLike, IHasModelProperty
{
	public KnightItem(ArmorType material, Type type, Properties properties) {
		super(material, type, properties);
	}

	@Override
    public int getColor(ItemStack itemstack)
    {
	    ArmorDecorationItem.DecorationInfo info = getPlumeDecorationInfo(itemstack);
		return FastColor.ARGB32.opaque(info != null ? info.color() : 0);
    }

	public boolean hasPlume(ItemStack itemstack)
	{
		return getPlumeDecorationInfo(itemstack) != null;
	}
	
	public ArmorDecorationItem.DecorationInfo getPlumeDecorationInfo(ItemStack itemstack)
	{
		if (!itemstack.has(ModDataComponents.ARMOR_DECORATION.get()))
			return null;
		
		String plumename = ModItems.BIG_PLUME_DECORATION.get().getResourceLocation().toString();
		return createDecorations(getDecorationTags(itemstack)).stream().filter(d -> Objects.equals(d.name(), plumename)).findFirst().orElse(null);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public void registerModelProperty()
	{
		ItemPropertiesRegistry.register(this, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "has_plume"), (stack, level, entity, i) -> this.hasPlume(stack) ? 1 : 0);
	}
}
