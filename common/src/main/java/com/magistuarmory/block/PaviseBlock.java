package com.magistuarmory.block;

import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.ModItems;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import javax.annotation.Nonnull;


public class PaviseBlock extends BannerBlock
{
//	static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
	
	static final AABB COLLISION_AABB = new AABB(0.0 / 16.0, 0.0, 7.5 / 16.0, 1.0, 1.0, 8.5 / 16.0);
	public static final Vector3f CENTER = new Vector3f(0.5f, 0.5f, 0.5f);
	public static final Vector3f BOXMIN = new Vector3f(0.0f, 0.0f, 0.0f);
	public static final Vector3f BOXMAX = new Vector3f(1.0f, 1.0f, 1.0f);
	
	public PaviseBlock()
	{
		super(DyeColor.WHITE, BlockBehaviour.Properties.of(Material.WOOD).dynamicShape().sound(SoundType.WOOD));
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos blockpos, BlockState blockstate) 
	{
		return new PaviseBlockEntity(blockpos, blockstate);
	}
	
	@Override
	public @Nonnull Item asItem() 
	{
		RegistrySupplier<MedievalShieldItem> item = ModItems.PAVISES.wood;
		return item != null ? item.get() : Items.AIR;
	}
	
	@Override
	public void spawnDestroyParticles(Level level, Player player, BlockPos blockPos, BlockState blockstate)
	{
		
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) 
	{
		return this.defaultBlockState().setValue(ROTATION, Mth.floor((double)((blockPlaceContext.getRotation()) * 16.0F / 360.0F) + 0.5) & 15);
	}
	
	@Override
	public @Nonnull ItemStack getCloneItemStack(BlockGetter blockgetter, BlockPos blockpos, BlockState blockstate) 
	{
		if (blockgetter.getBlockEntity(blockpos) instanceof PaviseBlockEntity pavise)
			return pavise.getItem();
		
		return ItemStack.EMPTY;
	}

	@Override
	public VoxelShape getShape(BlockState blockstate, BlockGetter blockgetter, BlockPos blockpos, CollisionContext context)
	{
		AABB aabb = COLLISION_AABB;

		float yrot = -blockstate.getValue(BannerBlock.ROTATION) * 360.0F / 16.0F;
		aabb = rotateAABB(aabb, Vector3f.YP.rotationDegrees(yrot));
		
		return Shapes.create(aabb);
	}

	public static AABB rotateAABB(AABB axisAlignedBB, Quaternion quaternion)
	{
		// Extract the minimum and maximum coordinates of the AABB into vectors
		final Vector3f mincoords = new Vector3f((float) axisAlignedBB.minX, (float) axisAlignedBB.minY, (float) axisAlignedBB.minZ);
		final Vector3f maxcoords = new Vector3f((float) axisAlignedBB.maxX, (float) axisAlignedBB.maxY, (float) axisAlignedBB.maxZ);
		
		mincoords.sub(CENTER);
		maxcoords.sub(CENTER);

		mincoords.transform(quaternion);
		maxcoords.transform(quaternion);

		mincoords.add(CENTER);
		maxcoords.add(CENTER);
		
		float xmin = Math.max(mincoords.x(), BOXMIN.x());
		float ymin = Math.max(mincoords.y(), BOXMIN.y());
		float zmin = Math.max(mincoords.z(), BOXMIN.z());

		float xmax = Math.min(maxcoords.x(), BOXMAX.x());
		float ymax = Math.min(maxcoords.y(), BOXMAX.y());
		float zmax = Math.min(maxcoords.z(), BOXMAX.z());
		
		return new AABB(xmin, ymin, zmin, xmax, ymax, zmax);
	}

	@Override
	public void playerDestroy(Level level, Player player, BlockPos blockpos, BlockState blockstate, @Nullable BlockEntity blockentity, ItemStack stack)
	{
		player.awardStat(Stats.BLOCK_MINED.get(this));
		player.causeFoodExhaustion(0.005F);
		dropResources(blockstate, level, blockpos, blockentity, player, stack);
		if (blockentity instanceof PaviseBlockEntity pavise && pavise.getLevel() != null)
			level.addFreshEntity(new ItemEntity(pavise.getLevel(), blockpos.getX() + 0.5, blockpos.getY() + 0.5, blockpos.getZ() + 0.5, pavise.getItem()));
	}

	@Override
	public void destroy(LevelAccessor accessor, BlockPos blockpos, BlockState blockstate)
	{
		if (accessor.getBlockState(blockpos.above()).getBlock() == ModBlocks.PAVISE_UPPER_COLLISION.get())
			accessor.destroyBlock(blockpos.above(), false);
		super.destroy(accessor, blockpos, blockstate);
	}
}
