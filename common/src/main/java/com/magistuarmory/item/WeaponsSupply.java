package com.magistuarmory.item;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;

import java.util.function.BiFunction;


public class WeaponsSupply extends ItemsSupply<MedievalWeaponItem>
{
	public WeaponsSupply(BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> workshop)
	{
		super(workshop, Item.Properties::new);
	}
}
