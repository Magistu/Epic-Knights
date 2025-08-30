package com.magistuarmory.item.neoforge;

import com.magistuarmory.block.PaviseBlock;
import com.magistuarmory.item.*;
import com.magistuarmory.item.armor.*;
import com.magistuarmory.neoforge.item.LanceItemNeoForge;
import com.magistuarmory.neoforge.item.MedievalShieldItemNeoForge;
import com.magistuarmory.neoforge.item.MedievalWeaponItemNeoForge;
import com.magistuarmory.neoforge.item.PaviseItemNeoForge;
import com.magistuarmory.neoforge.item.armor.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ItemRegistryHelperImpl
{
	public static RegistrySupplier<MedievalArmorItem> registerKnightItem(DeferredRegister<Item> items, String id, ArmorType material, ArmorItem.Type type, Item.Properties properties)
	{
		return items.register(id, () -> new KnightItemNeoForge(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerJoustingItem(DeferredRegister<Item> items, String id, ArmorType material, ArmorItem.Type type, Item.Properties properties)
	{
		return items.register(id, () -> new JoustingItemNeoForge(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorType material, ArmorItem.Type type, Item.Properties properties)
	{
		return items.register(id, () -> new MedievalArmorItemNeoForge(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorType material, ArmorItem.Type type, Item.Properties properties, int defaultcolor)
	{
		return items.register(id, () -> new DyeableMedievalArmorItemNeoForge(material, type, properties, defaultcolor));
	}

	public static RegistrySupplier<WearableArmorDecorationItem> registerWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorType material, ArmorItem.Type type, Item.Properties properties)
	{
		return items.register(id, () -> new WearableArmorDecorationItemNeoForge(material, type, properties));
	}

	public static RegistrySupplier<DyeableWearableArmorDecorationItem> registerDyeableWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorType material, ArmorItem.Type type, Item.Properties properties, int defaultcolor)
	{
		return items.register(id, () -> new DyeableWearableArmorDecorationItemNeoForge(material, type, properties, defaultcolor));
	}

	public static RegistrySupplier<MedievalWeaponItem> registerMedievalWeaponItem(DeferredRegister<Item> items, String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		return items.register(id, () -> new MedievalWeaponItemNeoForge(properties, material, type));
	}

	public static RegistrySupplier<MedievalWeaponItem> registerLanceItem(DeferredRegister<Item> items, String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		return items.register(id, () -> new LanceItemNeoForge(properties, material, type));
	}

	public static RegistrySupplier<MedievalShieldItem> registerMedievalShieldItem(DeferredRegister<Item> items, String id, ResourceLocation location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		return items.register(id, () -> new MedievalShieldItemNeoForge(id, location, properties, material, paintable, is3d, type));
	}

	public static RegistrySupplier<MedievalShieldItem> registerPaviseItem(DeferredRegister<Item> items, String id, ResourceLocation location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Supplier<PaviseBlock> block)
	{
		return items.register(id, () -> new PaviseItemNeoForge(id, location, properties, material, paintable, is3d, type, block));
	}
}
