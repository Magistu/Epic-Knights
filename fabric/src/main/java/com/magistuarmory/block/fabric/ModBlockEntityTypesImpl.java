package com.magistuarmory.block.fabric;

import com.magistuarmory.block.PaviseBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.BiFunction;

public final class ModBlockEntityTypesImpl {
    public static BlockEntityType<PaviseBlockEntity> createType(BiFunction<BlockPos, BlockState, PaviseBlockEntity> factory, Block block) {
        return net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder.create(factory::apply, block).build();
    }
}
