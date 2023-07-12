package com.magistuarmory.item;

import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.item.armor.MedievalArmorItem;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;


public class ItemRegistryHelper
{
	@ExpectPlatform
	public static RegistrySupplier<MedievalArmorItem> registerKnightItem(String id, ArmorMaterial material, EquipmentSlot type, Item.Properties properties)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalArmorItem> registerJoustingItem(String id, ArmorMaterial material, EquipmentSlot type, Item.Properties properties)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot type, Item.Properties properties)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot type, Item.Properties properties, Models.ArmorEnum model)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot type, Item.Properties properties, int defaultcolor)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot type, Item.Properties properties, int defaultcolor, Models.ArmorEnum model)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalWeaponItem> registerMedievalWeaponItem(String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalWeaponItem> registerLanceItem(String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalShieldItem> registerMedievalShieldItem(String id, String name, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Models.ShieldEnum modelkey)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalShieldItem> registerPaviseItem(String id, String name, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Models.ShieldEnum modelkey)
	{
		throw new AssertionError();
	}
}
