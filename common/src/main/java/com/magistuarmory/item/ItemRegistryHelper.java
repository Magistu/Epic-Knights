package com.magistuarmory.item;

import com.magistuarmory.item.armor.DyeableWearableArmorDecorationItem;
import com.magistuarmory.item.armor.MedievalArmorItem;
import com.magistuarmory.item.armor.WearableArmorDecorationItem;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;


public class ItemRegistryHelper
{
	@ExpectPlatform
	public static RegistrySupplier<MedievalArmorItem> registerKnightItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalArmorItem> registerJoustingItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties, int defaultcolor)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<WearableArmorDecorationItem> registerWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<DyeableWearableArmorDecorationItem> registerDyeableWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties, int defaultcolor)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalWeaponItem> registerMedievalWeaponItem(DeferredRegister<Item> items, String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalWeaponItem> registerLanceItem(DeferredRegister<Item> items, String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalShieldItem> registerMedievalShieldItem(DeferredRegister<Item> items, String id, ResourceLocation location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalShieldItem> registerPaviseItem(DeferredRegister<Item> items, String id, ResourceLocation location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		throw new AssertionError();
	}
}
