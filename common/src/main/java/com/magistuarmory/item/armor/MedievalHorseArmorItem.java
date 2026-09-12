package com.magistuarmory.item.armor;

import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;

import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;

public class MedievalHorseArmorItem extends Item
{
	private final Identifier texture;

	public MedievalHorseArmorItem(ArmorMaterial material, Identifier texture, boolean dyeable, Item.Properties properties) {
		super(properties.horseArmor(withAsset(material, texture)));
		this.texture = texture;
	}

    private static ArmorMaterial withAsset(ArmorMaterial material, Identifier texture) {
        String name = texture.getPath().substring(texture.getPath().lastIndexOf('/') + 1).replace(".png", "");
        if (name.equals("horse_armor_chainmail")) name = "chainmail_horse_armor";
        return new ArmorMaterial(material.durability(), material.defense(), material.enchantmentValue(), material.equipSound(),
                material.toughness(), material.knockbackResistance(), material.repairIngredient(),
                net.minecraft.resources.ResourceKey.create(net.minecraft.world.item.equipment.EquipmentAssets.ROOT_ID,
                        Identifier.fromNamespaceAndPath(texture.getNamespace(), name)));
    }

	public Identifier getTexture() {
		return texture;
	}
}
