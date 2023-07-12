package com.magistuarmory.util;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.config.MobEquipmentConfig;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;

import java.util.*;

public class MobEquipment
{
    public static final MobEquipmentConfig MOBS_EQUIPMENT_CONFIG = EpicKnights.CONFIG.mobEquipments;
    static Map<DualKey<EntityType<? extends LivingEntity>, ResourceKey<Level>>, List<MobEquipment>> EQUIPMENTS = new HashMap<>();

    public List<EntityType<? extends LivingEntity>> entities = new ArrayList<>();
    
    public List<ResourceKey<Level>> dimensions;
    
    public List<ArmorItem> helmets = new ArrayList<>();
    public List<ArmorItem> chestplates = new ArrayList<>();
    public List<ArmorItem> leggings = new ArrayList<>();
    public List<ArmorItem> boots = new ArrayList<>();
    
    public List<Item> weapons = new ArrayList<>();
    public List<ShieldItem> shields = new ArrayList<>();
    
    public double chance;

    @SuppressWarnings("unchecked")
    MobEquipment(MinecraftServer server, String[] ids)
    {
        List<ResourceKey<Level>> dimensions = new ArrayList<>();
        this.chance = EpicKnights.GENERAL_CONFIG.equipChance;
        
        for (String id : ids)
        {
            ResourceLocation resloc = new ResourceLocation(id);

            Optional<EntityType<?>> entityoptional = Registry.ENTITY_TYPE.getOptional(resloc);
            if (entityoptional.isPresent())
            {
                try
                {
                    this.entities.add((EntityType<? extends LivingEntity>) entityoptional.get());
                    continue;
                }
                catch (ClassCastException e)
                {
                    System.out.println("[Epic-Knights Mob Equipment] Non-living entity type \"" + id + "\" is not allowed");
                }
            }

            Optional<Item> itemoptional = Registry.ITEM.getOptional(resloc);
            if (itemoptional.isPresent())
            {
                if (itemoptional.get() instanceof ArmorItem armor)
                {
                    switch (armor.getSlot())
                    {
                        case HEAD -> this.helmets.add(armor);
                        case CHEST -> this.chestplates.add(armor);
                        case LEGS -> this.leggings.add(armor);
                        case FEET -> this.boots.add(armor);
                    }
                    continue;
                }
                if (itemoptional.get() instanceof ShieldItem shield)
                {
                    this.shields.add(shield);
                    continue;
                }
                this.weapons.add(itemoptional.get());
                continue;
            }

            ResourceKey<Level> resourcekey = ResourceKey.create(Registry.DIMENSION_REGISTRY, resloc);
            ServerLevel serverlevel = server.getLevel(resourcekey);
            if (serverlevel != null)
            {
                dimensions.add(serverlevel.dimension());
                continue;
            }

            if (id.matches("[-+]?[0-9]*\\.?[0-9]+"))
            {
                this.chance = Double.parseDouble(id);
                continue;
            }
        }
        
        if (dimensions.size() == 0)
            server.getAllLevels().forEach(serverlevel -> dimensions.add(serverlevel.dimension()));
        this.dimensions = dimensions;
    }

    public void equip(LivingEntity entity, Random rand)
    {
        MobEquipmentHelper.setRandomItemSlot(entity, EquipmentSlot.HEAD, this.helmets, this.chance, rand);
        MobEquipmentHelper.setRandomItemSlot(entity, EquipmentSlot.CHEST, this.chestplates, this.chance, rand);
        MobEquipmentHelper.setRandomItemSlot(entity, EquipmentSlot.LEGS, this.leggings, this.chance, rand);
        MobEquipmentHelper.setRandomItemSlot(entity, EquipmentSlot.FEET, this.boots, this.chance, rand);
        MobEquipmentHelper.setRandomItemSlot(entity, EquipmentSlot.MAINHAND, this.weapons, this.chance, rand);
        MobEquipmentHelper.setRandomItemSlot(entity, EquipmentSlot.OFFHAND, this.shields, 0.5f * chance, rand);
    }
    
    public static void setup(MinecraftServer server)
    {
        for (String ids : MOBS_EQUIPMENT_CONFIG.equipments)
        {
            MobEquipment equipment = new MobEquipment(server, ids.split(" "));
            equipment.entities.forEach(type -> equipment.dimensions.forEach(dimension -> {
                DualKey<EntityType<? extends LivingEntity>, ResourceKey<Level>> key = new DualKey<>(type, dimension);
                EQUIPMENTS.putIfAbsent(key, new ArrayList<>());
                EQUIPMENTS.get(key).add(equipment);
            }));
        }
    }
    
    public static List<MobEquipment> get(LivingEntity entity)
    {
        return EQUIPMENTS.getOrDefault(new DualKey<>(entity.getType(), entity.level.dimension()), new ArrayList<>());
    }
}
