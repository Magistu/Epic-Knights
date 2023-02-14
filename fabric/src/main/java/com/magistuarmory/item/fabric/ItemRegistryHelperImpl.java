package com.magistuarmory.item.fabric;

import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.fabric.item.LanceItemFabric;
import com.magistuarmory.fabric.item.MedievalWeaponItemFabric;
import com.magistuarmory.item.*;
import com.magistuarmory.item.armor.DyeableMedievalArmorItem;
import com.magistuarmory.item.armor.JoustingItem;
import com.magistuarmory.item.armor.KnightItem;
import com.magistuarmory.item.armor.MedievalArmorItem;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

public class ItemRegistryHelperImpl
{
	public static RegistrySupplier<MedievalArmorItem> registerKnightItem(String id, ArmorMaterial material, EquipmentSlot slot, Item.Properties properties)
	{
		return ModItems.ITEMS.register(id, () -> new KnightItem(material, slot, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerJoustingItem(String id, ArmorMaterial material, EquipmentSlot slot, Item.Properties properties)
	{
		return ModItems.ITEMS.register(id, () -> new JoustingItem(material, slot, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, Item.Properties properties)
	{
		return ModItems.ITEMS.register(id, () -> new MedievalArmorItem(material, slot, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, Item.Properties properties, Models.ArmorEnum modelkey)
	{
		return ModItems.ITEMS.register(id, () -> new MedievalArmorItem(material, slot, properties)
		{ @Override public HumanoidModel<? extends LivingEntity> getArmorModel(EquipmentSlot slot0, HumanoidModel<?> _default) { return slot0 == slot ? Models.ARMOR_MAP.get(modelkey) : super.getArmorModel(slot0, _default); } });
	}

	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, Item.Properties properties, int defaultcolor)
	{
		return ModItems.ITEMS.register(id, () -> new DyeableMedievalArmorItem(material, slot, properties, defaultcolor));
	}

	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, Item.Properties properties, int defaultcolor, Models.ArmorEnum modelkey)
	{
		return ModItems.ITEMS.register(id, () -> new DyeableMedievalArmorItem(material, slot, properties, defaultcolor)
		{ @Override public HumanoidModel<? extends LivingEntity> getArmorModel(EquipmentSlot slot0, HumanoidModel<?> _default) { return slot0 == slot ? Models.ARMOR_MAP.get(modelkey) : super.getArmorModel(slot0, _default); } });
	}

	public static RegistrySupplier<MedievalWeaponItem> registerMedievalWeaponItem(String id, Item.Properties build, ModItemTier material, WeaponType type)
	{
		return ModItems.ITEMS.register(id, () -> new MedievalWeaponItemFabric(build, material, type));
	}

	public static RegistrySupplier<MedievalWeaponItem> registerLanceItem(String id, Item.Properties build, ModItemTier material, WeaponType type)
	{
		return ModItems.ITEMS.register(id, () -> new LanceItemFabric(build, material, type));
	}

	public static RegistrySupplier<MedievalShieldItem> registerMedievalShieldItem(String id, String name, Item.Properties build, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Models.ShieldEnum modelkey)
	{
		return ModItems.ITEMS.register(id, () -> new MedievalShieldItem(id, name, build, material, paintable, is3d, type, modelkey));
	}
}
