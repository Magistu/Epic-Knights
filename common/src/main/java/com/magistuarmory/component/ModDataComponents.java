package com.magistuarmory.component;

import com.magistuarmory.EpicKnights;
import com.mojang.serialization.Codec;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.world.item.component.CustomData;

public class ModDataComponents
{
    public static final DeferredRegister<DataComponentType<?>> COMPONENT_TYPES = DeferredRegister.create(EpicKnights.ID, Registries.DATA_COMPONENT_TYPE);
    
    public static final RegistrySupplier<DataComponentType<Integer>> TWO_HANDED_PENALTY = COMPONENT_TYPES.register("two_handed_penalty", () -> DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());
    public static final RegistrySupplier<DataComponentType<Integer>> RAISED = COMPONENT_TYPES.register("raised", () -> DataComponentType.<Integer>builder().persistent(Codec.intRange(0, 1)).networkSynchronized(ByteBufCodecs.INT).build());
    public static final RegistrySupplier<DataComponentType<Boolean>> DISMOUNT = COMPONENT_TYPES.register("dismount", () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());
    public static final RegistrySupplier<DataComponentType<Float>> RIDE_SPEED = COMPONENT_TYPES.register("ride_speed", () -> DataComponentType.<Float>builder().persistent(Codec.FLOAT).networkSynchronized(ByteBufCodecs.FLOAT).build());
    public static final RegistrySupplier<DataComponentType<CustomData>> ARMOR_DECORATION = COMPONENT_TYPES.register("armor_decoration", () -> DataComponentType.<CustomData>builder().persistent(CustomData.CODEC).networkSynchronized(CustomData.STREAM_CODEC).build());


    public static void init() {
        COMPONENT_TYPES.register();
    }
}
