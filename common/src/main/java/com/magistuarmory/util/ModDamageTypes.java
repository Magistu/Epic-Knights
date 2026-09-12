package com.magistuarmory.util;

import com.magistuarmory.EpicKnights;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypes
{
    public static final ResourceKey<DamageType> ADDITIONAL = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(EpicKnights.ID, "additional"));
    public static final ResourceKey<DamageType> ENTITY_ADDITIONAL = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(EpicKnights.ID, "entity_additional"));
    public static final ResourceKey<DamageType> SILVER = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(EpicKnights.ID, "silver"));
    public static final ResourceKey<DamageType> ARMOR_PIERCING = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(EpicKnights.ID, "armor_piercing"));

}
