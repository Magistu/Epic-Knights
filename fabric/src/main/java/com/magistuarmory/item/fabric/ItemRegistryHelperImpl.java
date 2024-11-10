package com.magistuarmory.item.fabric;

import com.magistuarmory.fabric.item.LanceItemFabric;
import com.magistuarmory.fabric.item.MedievalWeaponItemFabric;
import com.magistuarmory.item.*;
import com.magistuarmory.item.armor.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public class ItemRegistryHelperImpl
{
	public static RegistrySupplier<MedievalArmorItem> registerKnightItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		return items.register(id, () -> new KnightItem(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerJoustingItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		return items.register(id, () -> new JoustingItem(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		return items.register(id, () -> new MedievalArmorItem(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties, int defaultcolor)
	{
		return items.register(id, () -> new DyeableMedievalArmorItem(material, type, properties, defaultcolor));
	}

	public static RegistrySupplier<WearableArmorDecorationItem> registerWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		return items.register(id, () -> new WearableArmorDecorationItem(material, type, properties));
	}

	public static RegistrySupplier<DyeableWearableArmorDecorationItem> registerDyeableWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties, int defaultcolor)
	{
		return items.register(id, () -> new DyeableWearableArmorDecorationItem(material, type, properties, defaultcolor));
	}

	public static RegistrySupplier<MedievalWeaponItem> registerMedievalWeaponItem(DeferredRegister<Item> items, String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		return items.register(id, () -> new MedievalWeaponItemFabric(properties, material, type));
	}

	public static RegistrySupplier<MedievalWeaponItem> registerLanceItem(DeferredRegister<Item> items, String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		return items.register(id, () -> new LanceItemFabric(properties, material, type));
	}

	public static RegistrySupplier<MedievalShieldItem> registerMedievalShieldItem(DeferredRegister<Item> items, String id, ResourceLocation location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		return items.register(id, () -> new MedievalShieldItem(id, location, properties, material, paintable, is3d, type));
	}

	public static RegistrySupplier<MedievalShieldItem> registerPaviseItem(DeferredRegister<Item> items, String id, ResourceLocation location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		return items.register(id, () -> new PaviseItem(id, location, properties, material, paintable, is3d, type));
	}
}
