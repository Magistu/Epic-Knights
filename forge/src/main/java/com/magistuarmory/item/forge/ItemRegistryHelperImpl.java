package com.magistuarmory.item.forge;

import com.magistuarmory.forge.item.LanceItemForge;
import com.magistuarmory.forge.item.MedievalShieldItemForge;
import com.magistuarmory.forge.item.MedievalWeaponItemForge;
import com.magistuarmory.forge.item.PaviseItemForge;
import com.magistuarmory.forge.item.armor.*;
import com.magistuarmory.item.*;
import com.magistuarmory.item.armor.DyeableWearableArmorDecorationItem;
import com.magistuarmory.item.armor.MedievalArmorItem;
import com.magistuarmory.item.armor.WearableArmorDecorationItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public class ItemRegistryHelperImpl
{
	public static RegistrySupplier<MedievalArmorItem> registerKnightItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		return items.register(id, () -> new KnightItemForge(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerJoustingItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		return items.register(id, () -> new JoustingItemForge(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		return items.register(id, () -> new MedievalArmorItemForge(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties, int defaultcolor)
	{
		return items.register(id, () -> new DyeableMedievalArmorItemForge(material, type, properties, defaultcolor));
	}

	public static RegistrySupplier<WearableArmorDecorationItem> registerWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		return items.register(id, () -> new WearableArmorDecorationItemForge(material, type, properties));
	}

	public static RegistrySupplier<DyeableWearableArmorDecorationItem> registerDyeableWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties, int defaultcolor)
	{
		return items.register(id, () -> new DyeableWearableArmorDecorationItemForge(material, type, properties, defaultcolor));
	}

	public static RegistrySupplier<MedievalWeaponItem> registerMedievalWeaponItem(DeferredRegister<Item> items, String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		return items.register(id, () -> new MedievalWeaponItemForge(properties, material, type));
	}

	public static RegistrySupplier<MedievalWeaponItem> registerLanceItem(DeferredRegister<Item> items, String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		return items.register(id, () -> new LanceItemForge(properties, material, type));
	}

	public static RegistrySupplier<MedievalShieldItem> registerMedievalShieldItem(DeferredRegister<Item> items, String id, ResourceLocation location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		return items.register(id, () -> new MedievalShieldItemForge(id, location, properties, material, paintable, is3d, type));
	}

	public static RegistrySupplier<MedievalShieldItem> registerPaviseItem(DeferredRegister<Item> items, String id, ResourceLocation location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		return items.register(id, () -> new PaviseItemForge(id, location, properties, material, paintable, is3d, type));
	}
}
