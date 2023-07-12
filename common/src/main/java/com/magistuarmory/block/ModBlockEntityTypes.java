package com.magistuarmory.block;

import com.magistuarmory.EpicKnights;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityTypes
{
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(EpicKnights.ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);
    
    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> PAVISE = BLOCK_ENTITY_TYPES.register("pavise", () -> BlockEntityType.Builder.of(PaviseBlockEntity::new, ModBlocks.PAVISE.get()).build(null));

    public static void init()
    {
        BLOCK_ENTITY_TYPES.register();
    }
}
