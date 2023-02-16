package com.magistuarmory.item.forge;

import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.forge.item.LanceItemForge;
import com.magistuarmory.forge.item.MedievalShieldItemForge;
import com.magistuarmory.forge.item.MedievalWeaponItemForge;
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
	public static RegistrySupplier<MedievalArmorItem> registerKnightItem(String id, ArmorMaterial material, EquipmentSlot slot, Item.Properties properties)
	{
		return ModItems.ITEMS.register(id, () -> new KnightItemForge(material, slot, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerJoustingItem(String id, ArmorMaterial material, EquipmentSlot slot, Item.Properties properties)
	{
		return ModItems.ITEMS.register(id, () -> new JoustingItemForge(material, slot, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, Item.Properties properties)
	{
		return ModItems.ITEMS.register(id, () -> new MedievalArmorItemForge(material, slot, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, Item.Properties properties, Models.ArmorEnum modelkey)
	{
		return ModItems.ITEMS.register(id, () -> new MedievalArmorItemForge(material, slot, properties)
		{ @Override public HumanoidModel<?> getArmorModel(EquipmentSlot slot0, HumanoidModel<?> _default) { return slot0 == slot ? Models.ARMOR_MAP.get(modelkey) : super.getArmorModel(slot0, _default); } });
	}

	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, Item.Properties properties, int defaultcolor)
	{
		return ModItems.ITEMS.register(id, () -> new DyeableMedievalArmorItemForge(material, slot, properties, defaultcolor));
	}

	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, Item.Properties properties, int defaultcolor, Models.ArmorEnum modelkey)
	{
		return ModItems.ITEMS.register(id, () -> new DyeableMedievalArmorItemForge(material, slot, properties, defaultcolor)
		{ @Override public HumanoidModel<?> getArmorModel(EquipmentSlot slot0, HumanoidModel<?> _default) { return slot0 == slot ? Models.ARMOR_MAP.get(modelkey) : super.getArmorModel(slot0, _default); } });
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
}
