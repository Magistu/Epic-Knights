package com.magistuarmory.item.forge;

import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.forge.item.LanceItemForge;
import com.magistuarmory.forge.item.MedievalShieldItemForge;
import com.magistuarmory.forge.item.MedievalWeaponItemForge;
import com.magistuarmory.forge.item.PaviseItemForge;
import com.magistuarmory.forge.item.armor.DyeableMedievalArmorItemForge;
import com.magistuarmory.forge.item.armor.JoustingItemForge;
import com.magistuarmory.forge.item.armor.KnightItemForge;
import com.magistuarmory.forge.item.armor.MedievalArmorItemForge;
import com.magistuarmory.item.*;
import com.magistuarmory.item.armor.MedievalArmorItem;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

public class ItemRegistryHelperImpl
{
	public static RegistrySupplier<MedievalArmorItem> registerKnightItem(String id, ArmorMaterial material, EquipmentSlot type, Item.Properties properties)
	{
		return ModItems.ITEMS.register(id, () -> new KnightItemForge(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerJoustingItem(String id, ArmorMaterial material, EquipmentSlot type, Item.Properties properties)
	{
		return ModItems.ITEMS.register(id, () -> new JoustingItemForge(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot type, Item.Properties properties)
	{
		return ModItems.ITEMS.register(id, () -> new MedievalArmorItemForge(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot type, Item.Properties properties, Models.ArmorEnum modelkey)
	{
		return ModItems.ITEMS.register(id, () -> new MedievalArmorItemForge(material, type, properties)
		{ @Override public HumanoidModel<?> getArmorModel(EquipmentSlot slot0, HumanoidModel<?> _default) { return slot0 == type ? Models.ARMOR_MAP.get(modelkey) : super.getArmorModel(slot0, _default); } });
	}

	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot type, Item.Properties properties, int defaultcolor)
	{
		return ModItems.ITEMS.register(id, () -> new DyeableMedievalArmorItemForge(material, type, properties, defaultcolor));
	}

	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot type, Item.Properties properties, int defaultcolor, Models.ArmorEnum modelkey)
	{
		return ModItems.ITEMS.register(id, () -> new DyeableMedievalArmorItemForge(material, type, properties, defaultcolor)
		{ @Override public HumanoidModel<?> getArmorModel(EquipmentSlot slot0, HumanoidModel<?> _default) { return slot0 == type ? Models.ARMOR_MAP.get(modelkey) : super.getArmorModel(slot0, _default); } });
	}

	public static RegistrySupplier<MedievalWeaponItem> registerMedievalWeaponItem(String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		return ModItems.ITEMS.register(id, () -> new MedievalWeaponItemForge(properties, material, type));
	}

	public static RegistrySupplier<MedievalWeaponItem> registerLanceItem(String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		return ModItems.ITEMS.register(id, () -> new LanceItemForge(properties, material, type));
	}

	public static RegistrySupplier<MedievalShieldItem> registerMedievalShieldItem(String id, String name, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Models.ShieldEnum modelkey)
	{
		return ModItems.ITEMS.register(id, () -> new MedievalShieldItemForge(id, name, properties, material, paintable, is3d, type, modelkey));
	}

	public static RegistrySupplier<MedievalShieldItem> registerPaviseItem(String id, String name, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Models.ShieldEnum modelkey)
	{
		return ModItems.ITEMS.register(id, () -> new PaviseItemForge(id, name, properties, material, paintable, is3d, type, modelkey));
	}
}
