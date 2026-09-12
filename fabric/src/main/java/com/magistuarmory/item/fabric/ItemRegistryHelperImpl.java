package com.magistuarmory.item.fabric;

import com.magistuarmory.block.PaviseBlock;
import com.magistuarmory.item.*;
import com.magistuarmory.item.armor.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ItemRegistryHelperImpl
{
	public static RegistrySupplier<MedievalArmorItem> registerKnightItem(DeferredRegister<Item> items, String id, ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Item.Properties properties)
	{
		return items.register(id, () -> new KnightItem(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerJoustingItem(DeferredRegister<Item> items, String id, ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Item.Properties properties)
	{
		return items.register(id, () -> new JoustingItem(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Item.Properties properties)
	{
		return items.register(id, () -> new MedievalArmorItem(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Item.Properties properties, int defaultcolor)
	{
		return items.register(id, () -> new DyeableMedievalArmorItem(material, type, properties, defaultcolor));
	}

	public static RegistrySupplier<WearableArmorDecorationItem> registerWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Item.Properties properties)
	{
		return items.register(id, () -> new WearableArmorDecorationItem(material, type, properties));
	}

	public static RegistrySupplier<DyeableWearableArmorDecorationItem> registerDyeableWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Item.Properties properties, int defaultcolor)
	{
		return items.register(id, () -> new DyeableWearableArmorDecorationItem(material, type, properties, defaultcolor));
	}

	public static RegistrySupplier<MedievalWeaponItem> registerMedievalWeaponItem(DeferredRegister<Item> items, String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		return items.register(id, () -> new MedievalWeaponItem(properties, material, type));
	}

	public static RegistrySupplier<MedievalWeaponItem> registerLanceItem(DeferredRegister<Item> items, String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		return items.register(id, () -> new LanceItem(properties, material, type));
	}

	public static RegistrySupplier<MedievalShieldItem> registerMedievalShieldItem(DeferredRegister<Item> items, String id, Identifier location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		return items.register(id, () -> new MedievalShieldItem(id, location, properties, material, paintable, is3d, type));
	}

	public static RegistrySupplier<MedievalShieldItem> registerPaviseItem(DeferredRegister<Item> items, String id, Identifier location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Supplier<PaviseBlock> block)
	{
		return items.register(id, () -> new PaviseItem(id, location, properties, material, paintable, is3d, type, block));
	}
}
