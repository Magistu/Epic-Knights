package com.magistuarmory.item.armor;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public class MedievalHorseArmorItem extends AnimalArmorItem
{
	private final ResourceLocation texture;

	public MedievalHorseArmorItem(Holder<ArmorMaterial> material, ResourceLocation texture, boolean dyeable, Item.Properties properties) {
		super(material, AnimalArmorItem.BodyType.EQUESTRIAN, dyeable, properties.stacksTo(1));
		this.texture = texture;
	}

	@Override
	public ResourceLocation getTexture() {
		return texture;
	}
}
