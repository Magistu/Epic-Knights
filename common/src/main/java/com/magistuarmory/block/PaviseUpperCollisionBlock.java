package com.magistuarmory.block;

import com.mojang.math.Vector3f;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;


public class PaviseUpperCollisionBlock extends Block
{
	static final AABB COLLISION_AABB = new AABB(0.0 / 16.0, 0.0, 7.5 / 16.0, 1.0, 8.0 / 16.0, 8.5 / 16.0);
	
	public PaviseUpperCollisionBlock()
	{
		super(BlockBehaviour.Properties.of(Material.WOOD).dynamicShape());
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) 
	{
		return this.defaultBlockState();
	}
	
	@Override
	public @Nonnull ItemStack getCloneItemStack(BlockGetter blockgetter, BlockPos blockpos, BlockState blockstate) 
	{
		if (blockgetter.getBlockEntity(blockpos.below()) instanceof PaviseBlockEntity pavise)
			return pavise.getItem();
		
		return ItemStack.EMPTY;
	}

	@Override
	public void spawnDestroyParticles(Level level, Player player, BlockPos blockPos, BlockState blockstate)
	{

	}

	@Override
	public VoxelShape getShape(BlockState blockstate, BlockGetter blockgetter, BlockPos blockpos, CollisionContext context)
	{
		AABB aabb = COLLISION_AABB;

		if (blockgetter.getBlockEntity(blockpos.below()) instanceof PaviseBlockEntity pavise)
		{
			BlockState blockstate2 = pavise.getBlockState();
			float yrot = -blockstate2.getValue(BannerBlock.ROTATION) * 360.0F / 16.0F;
			aabb = PaviseBlock.rotateAABB(aabb, Vector3f.YP.rotationDegrees(yrot));
		}

		return Shapes.create(aabb);
	}

	@Override
	public void destroy(LevelAccessor accessor, BlockPos blockpos, BlockState blockstate)
	{
		BlockEntity blockentity = accessor.getBlockEntity(blockpos.below());
		if (blockentity instanceof PaviseBlockEntity pavise && pavise.getLevel() != null)
			accessor.addFreshEntity(new ItemEntity(pavise.getLevel(), blockpos.getX() + 0.5, blockpos.getY() - 0.5, blockpos.getZ() + 0.5, pavise.getItem()));

		if (accessor.getBlockState(blockpos.below()).getBlock() == ModBlocks.PAVISE.get())
			accessor.destroyBlock(blockpos.below(), false);
		super.destroy(accessor, blockpos, blockstate);
	}
}
