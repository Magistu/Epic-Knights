package com.magistuarmory.block.neoforge;

import com.magistuarmory.block.PaviseBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.BiFunction;

public final class ModBlockEntityTypesImpl {
    public static BlockEntityType<PaviseBlockEntity> createType(BiFunction<BlockPos, BlockState, PaviseBlockEntity> factory, Block block) {
        return new BlockEntityType<>(factory::apply, java.util.Set.of(block));
    }
}
