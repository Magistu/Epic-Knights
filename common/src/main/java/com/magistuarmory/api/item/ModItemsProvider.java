package com.magistuarmory.api.item;

import com.magistuarmory.client.render.ModRender;
import com.magistuarmory.item.*;
import com.magistuarmory.item.armor.*;
import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;


public abstract class ModItemsProvider
{
	public final String modId;
	public final DeferredRegister<Item> items;

	public final List<RegistrySupplier<? extends MedievalShieldItem>> shieldItems = new ArrayList<>();
	public final List<RegistrySupplier<? extends MedievalWeaponItem>> weaponItems = new ArrayList<>();
	public final List<RegistrySupplier<? extends Item>> dyeableItems = new ArrayList<>();
	public final List<RegistrySupplier<? extends MedievalArmorItem>> armorItems = new ArrayList<>();
	public final List<RegistrySupplier<? extends Item>> ingredientItems = new ArrayList<>();
	public final List<RegistrySupplier<? extends ArmorDecoration>> armorDecorationItems = new ArrayList<>();
	public final List<RegistrySupplier<? extends Item>> rangedWeaponItems = new ArrayList<>();

	public ModItemsProvider(String modId)
	{
		this.modId = modId;
		this.items = DeferredRegister.create(modId, Registries.ITEM);
	}

	public WeaponsSupply addWeaponsSupply(BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalWeaponItem>> workshop)
	{
		return new WeaponsSupply(workshop);
	}

	public ShieldsSupply addShieldsSupply(BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalShieldItem>> workshop, String shieldName)
	{
		return new ShieldsSupply(workshop, shieldName);
	}

	public @Nullable RegistrySupplier<MedievalArmorItem> addKnightItem(String id, ArmorType type, ArmorItem.Type slot, Item.Properties properties)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalArmorItem> armor = ItemRegistryHelper.registerKnightItem(this.items, id, type, slot, properties);
		this.dyeableItems.add(armor);
		this.armorItems.add(armor);
		return armor;
	}

	public @Nullable RegistrySupplier<MedievalArmorItem> addJoustingItem(String id, ArmorType type, ArmorItem.Type slot, Item.Properties properties)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalArmorItem> armor = ItemRegistryHelper.registerJoustingItem(this.items, id, type, slot, properties);
		this.armorItems.add(armor);
		if (slot == ArmorItem.Type.HELMET) {
			this.dyeableItems.add(armor);
		}
		return armor;
	}

	public @Nullable RegistrySupplier<MedievalArmorItem> addMedievalArmorItem(String id, ArmorType type, ArmorItem.Type slot, Item.Properties properties)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalArmorItem> armor = ItemRegistryHelper.registerMedievalArmorItem(this.items, id, type, slot, properties);
		this.armorItems.add(armor);
		return armor;
	}

	public @Nullable RegistrySupplier<MedievalArmorItem> addDyeableMedievalArmorItem(String id, ArmorType type, ArmorItem.Type slot, Item.Properties properties, int defaultcolor)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalArmorItem> armor = ItemRegistryHelper.registerDyeableMedievalArmorItem(this.items, id, type, slot, properties, defaultcolor);
		this.dyeableItems.add(armor);
		this.armorItems.add(armor);
		return armor;
	}

	public @Nullable RegistrySupplier<MedievalWeaponItem> addMedievalWeaponItem(String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalWeaponItem> weapon = ItemRegistryHelper.registerMedievalWeaponItem(this.items, id, properties, material, type);
		this.weaponItems.add(weapon);
		return weapon;
	}

	public @Nullable RegistrySupplier<MedievalWeaponItem> addLanceItem(String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalWeaponItem> weapon = ItemRegistryHelper.registerLanceItem(this.items, id, properties, material, type);
		this.weaponItems.add(weapon);
		return weapon;
	}

	public RegistrySupplier<Item> addIngredientItem(String id, Supplier<Item> supplier)
	{
		RegistrySupplier<Item> registrysupplier = this.items.register(id, supplier);
		this.ingredientItems.add(registrysupplier);
		return registrysupplier;
	}

	public RegistrySupplier<ArmorDecorationItem> addArmorDecorationItem(String id, Supplier<ArmorDecorationItem> supplier)
	{
		RegistrySupplier<ArmorDecorationItem> registrysupplier = this.items.register(id, supplier);
		this.armorDecorationItems.add(registrysupplier);
		return registrysupplier;
	}

	public RegistrySupplier<DyeableArmorDecorationItem> addDyeableArmorDecorationItem(String id, Supplier<DyeableArmorDecorationItem> supplier)
	{
		RegistrySupplier<DyeableArmorDecorationItem> registrysupplier = this.items.register(id, supplier);
		this.armorDecorationItems.add(registrysupplier);
		this.dyeableItems.add(registrysupplier);
		return registrysupplier;
	}

	public RegistrySupplier<WearableArmorDecorationItem> addWearableArmorDecorationItem(String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties)
	{
		RegistrySupplier<WearableArmorDecorationItem> registrysupplier = ItemRegistryHelper.registerWearableArmorDecorationItem(this.items, id, material, type, properties);
		this.armorDecorationItems.add(registrysupplier);
		this.armorItems.add(registrysupplier);
		return registrysupplier;
	}

	public RegistrySupplier<DyeableWearableArmorDecorationItem> addDyeableWearableArmorDecorationItem(String id, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties, int defaultcolor)
	{
		RegistrySupplier<DyeableWearableArmorDecorationItem> registrysupplier = ItemRegistryHelper.registerDyeableWearableArmorDecorationItem(this.items, id, material, type, properties, defaultcolor);
		this.armorDecorationItems.add(registrysupplier);
		this.dyeableItems.add(registrysupplier);
		this.armorItems.add(registrysupplier);
		return registrysupplier;
	}

	public @Nullable RegistrySupplier<MedievalShieldItem> addMedievalShieldItem(String id, String name, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalShieldItem> shield = ItemRegistryHelper.registerMedievalShieldItem(this.items, id, new ResourceLocation(this.modId, name), properties, material, paintable, is3d, type);
		this.shieldItems.add(shield);
		return shield;
	}

	public @Nullable RegistrySupplier<MedievalShieldItem> addPaviseItem(String id, String name, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<MedievalShieldItem> shield = ItemRegistryHelper.registerPaviseItem(this.items, id, new ResourceLocation(this.modId, name), properties, material, paintable, is3d, type);
		this.shieldItems.add(shield);
		return shield;
	}

	public @Nullable RegistrySupplier<Item> addMedievalBowItem(String id, RangedWeaponType type)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<Item> bow = this.items.register(id, () -> new MedievalBowItem(new Item.Properties().stacksTo(1).durability(type.getDurability()), type.getProjectileSpeed(), type.getPullTime()));
		this.rangedWeaponItems.add(bow);
		return bow;
	}

	public @Nullable RegistrySupplier<Item> addMedievalCrossbowItem(String id, RangedWeaponType type)
	{
		if (type.isDisabled())
			return null;
		RegistrySupplier<Item> crossbow = this.items.register(id, () -> new MedievalCrossbowItem(new Item.Properties().stacksTo(1).durability(type.getDurability()), type.getProjectileSpeed(), type.getPullTime()));
		this.rangedWeaponItems.add(crossbow);
		return crossbow;
	}

	public @Nullable RegistrySupplier<Item> addMedievalBowItem(String id, int durability, float arrowSpeed, float pullTime)
	{
		RegistrySupplier<Item> bow = this.items.register(id, () -> new MedievalBowItem(new Item.Properties().stacksTo(1).durability(durability), arrowSpeed, pullTime));
		this.rangedWeaponItems.add(bow);
		return bow;
	}

	public @Nullable RegistrySupplier<Item> addMedievalCrossbowItem(String id, int durability, float arrowSpeed, int pullTime)
	{
		RegistrySupplier<Item> crossbow = this.items.register(id, () -> new MedievalCrossbowItem(new Item.Properties().stacksTo(1).durability(durability), arrowSpeed, pullTime));
		this.rangedWeaponItems.add(crossbow);
		return crossbow;
	}

	public static ItemStack getDecoratedStack(RegistrySupplier<MedievalArmorItem> armorsuppler, RegistrySupplier<? extends ArmorDecorationItem> decorationsuppler)
	{
		if (armorsuppler == null)
			return ItemStack.EMPTY;

		ItemStack armorstack = new ItemStack(armorsuppler.get());
		ArmorDecorationItem decorationitem = decorationsuppler.get();
		ItemStack decorationstack = new ItemStack(decorationitem);
		decorationitem.decorate(armorstack, decorationstack);
		return armorstack;
	}

	public void onSetup()
	{
		for (RegistrySupplier<? extends MedievalWeaponItem> supplier : this.weaponItems)
			if (supplier.get() instanceof LanceItem lance)
				lance.setupDropItems();
	}

	public void init()
	{
		this.items.register();
		LifecycleEvent.SETUP.register(this::onSetup);
		if (Platform.getEnv() == EnvType.CLIENT)
			LifecycleEvent.SETUP.register(() -> ModRender.setup(this));
	}
}





