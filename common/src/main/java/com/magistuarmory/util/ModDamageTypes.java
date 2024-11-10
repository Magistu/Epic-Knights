package com.magistuarmory.util;

import com.magistuarmory.EpicKnights;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypes
{
//    public static DeferredRegister<DamageType> DAMAGE_TYPES = DeferredRegister.create(EpicKnights.ID, Registries.DAMAGE_TYPE);
    
    public static final ResourceKey<DamageType> ADDITIONAL = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(EpicKnights.ID, "additional"));
    public static final ResourceKey<DamageType> ENTITY_ADDITIONAL = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(EpicKnights.ID, "entity_additional"));
    public static final ResourceKey<DamageType> SILVER = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(EpicKnights.ID, "silver"));
    public static final ResourceKey<DamageType> ARMOR_PIERCING = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(EpicKnights.ID, "armor_piercing"));
    
    public static void init()
    {
        
    }
}
