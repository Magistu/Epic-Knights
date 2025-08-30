package com.magistuarmory.item;

import com.magistuarmory.block.PaviseBlock;
import com.magistuarmory.item.armor.*;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;


public class ItemRegistryHelper
{
	@ExpectPlatform
	public static RegistrySupplier<KnightItem> registerKnightItem(DeferredRegister<Item> items, String id, ArmorType material, ArmorItem.Type type, Item.Properties properties)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalArmorItem> registerJoustingItem(DeferredRegister<Item> items, String id, ArmorType material, ArmorItem.Type type, Item.Properties properties)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<DyeableMedievalArmorItem> registerDyeableMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorType material, ArmorItem.Type type, Item.Properties properties, int defaultcolor)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorType material, ArmorItem.Type type, Item.Properties properties)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<WearableArmorDecorationItem> registerWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorType material, ArmorItem.Type type, Item.Properties properties)
	{
		throw new AssertionError();
	}

	@ExpectPlatform
	public static RegistrySupplier<DyeableWearableArmorDecorationItem> registerDyeableWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorType material, ArmorItem.Type type, Item.Properties properties, int defaultcolor)
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
	public static RegistrySupplier<MedievalShieldItem> registerPaviseItem(DeferredRegister<Item> items, String id, ResourceLocation location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Supplier<PaviseBlock> block)
	{
		throw new AssertionError();
	}
}
