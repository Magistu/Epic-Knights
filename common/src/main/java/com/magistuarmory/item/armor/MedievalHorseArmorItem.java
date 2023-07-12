package com.magistuarmory.item.armor;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;

public class MedievalHorseArmorItem extends HorseArmorItem
{
	private final int protection;
	private final ResourceLocation texture;

	public MedievalHorseArmorItem(int i, ResourceLocation texture, Item.Properties properties) {
		super(i, "", properties);
		this.protection = i;
		this.texture = texture;
	}

	public ResourceLocation getTexture() {
		return texture;
	}

	public int getProtection() {
		return this.protection;
	}
}
