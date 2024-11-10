package com.magistuarmory.block;

import com.mojang.math.Axis;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3d;


public class PaviseUpperCollisionBlock extends Block
{
//	static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
	
	static final AABB COLLISION_AABB = new AABB(0.0 / 16.0, 0.0, 7.5 / 16.0, 1.0, 8.0 / 16.0, 8.5 / 16.0);
	static final Vector3d CENTER = new Vector3d(0.5, 0.5, 0.5);
	static final Vector3d BOXMIN = new Vector3d(0.0, 0.0, 0.0);
	static final Vector3d BOXMAX = new Vector3d(1.0, 1.0, 1.0);
	
	public PaviseUpperCollisionBlock()
	{
		super(Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.EMPTY));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) 
	{
		return this.defaultBlockState();
	}
	
	@Override
	public @NotNull ItemStack getCloneItemStack(BlockGetter blockgetter, BlockPos blockpos, BlockState blockstate) 
	{
		if (blockgetter.getBlockEntity(blockpos.below()) instanceof PaviseBlockEntity pavise)
			return pavise.getItem();
		
		return ItemStack.EMPTY;
	}

	@Override
	public VoxelShape getShape(BlockState blockstate, BlockGetter blockgetter, BlockPos blockpos, CollisionContext context)
	{
		AABB aabb = COLLISION_AABB;
		
		if (blockgetter.getBlockEntity(blockpos.below()) instanceof PaviseBlockEntity pavise)
		{
			BlockState blockstate2 = pavise.getBlockState();
			float yrot = -RotationSegment.convertToDegrees(blockstate2.getValue(BannerBlock.ROTATION));
			aabb = rotateAABB(aabb, Axis.YP.rotationDegrees(yrot));
		}
		
		return Shapes.create(aabb);
	}

	public static AABB rotateAABB(AABB axisAlignedBB, Quaternionf quaternion)
	{
		// Extract the minimum and maximum coordinates of the AABB into vectors
		final Vector3d mincoords = new Vector3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
		final Vector3d maxcoords = new Vector3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
		
		mincoords.sub(CENTER);
		maxcoords.sub(CENTER);

		// Rotate the vectors in-place
		quaternion.transform(mincoords);
		quaternion.transform(maxcoords);

		mincoords.add(CENTER).max(BOXMIN);
		maxcoords.add(CENTER).min(BOXMAX);
		
		// Return an AABB with the new coordinates
		return new AABB(mincoords.x(), mincoords.y(), mincoords.z(), maxcoords.x(), maxcoords.y(), maxcoords.z());
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
