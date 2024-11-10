package com.magistuarmory.block;

import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.ModItems;
import com.mojang.math.Axis;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
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
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3d;


public class PaviseBlock extends AbstractBannerBlock
{
//	static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);

	public static final IntegerProperty ROTATION;

	static final AABB COLLISION_AABB = new AABB(0.0 / 16.0, 0.0, 7.5 / 16.0, 1.0, 1.0, 8.5 / 16.0);
	static final Vector3d CENTER = new Vector3d(0.5, 0.5, 0.5);
	static final Vector3d BOXMIN = new Vector3d(0.0, 0.0, 0.0);
	static final Vector3d BOXMAX = new Vector3d(1.0, 1.0, 1.0);

	public PaviseBlock()
	{
		super(DyeColor.WHITE, Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.WOOD).ignitedByLava());
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockpos, BlockState blockstate)
	{
		return new PaviseBlockEntity(blockpos, blockstate);
	}

	@Override
	public @NotNull Item asItem()
	{
		RegistrySupplier<MedievalShieldItem> item = ModItems.PAVISES.wood;
		return item != null ? item.get() : Items.AIR;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext)
	{
		return this.defaultBlockState().setValue(ROTATION, RotationSegment.convertToSegment(blockPlaceContext.getRotation()));
	}

	@Override
	public @NotNull ItemStack getCloneItemStack(BlockGetter blockgetter, BlockPos blockpos, BlockState blockstate)
	{
		if (blockgetter.getBlockEntity(blockpos) instanceof PaviseBlockEntity pavise)
			return pavise.getItem();

		return ItemStack.EMPTY;
	}

	@Override
	public VoxelShape getShape(BlockState blockstate, BlockGetter blockgetter, BlockPos blockpos, CollisionContext context)
	{
		AABB aabb = COLLISION_AABB;

		float yrot = -RotationSegment.convertToDegrees(blockstate.getValue(BannerBlock.ROTATION));
		aabb = rotateAABB(aabb, Axis.YP.rotationDegrees(yrot));

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

	public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		return levelReader.getBlockState(blockPos.below()).isSolid();
	}

	public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
		return direction == Direction.DOWN && !blockState.canSurvive(levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
	}

	public BlockState rotate(BlockState blockState, Rotation rotation) {
		return blockState.setValue(ROTATION, rotation.rotate(blockState.getValue(ROTATION), 16));
	}

	public BlockState mirror(BlockState blockState, Mirror mirror) {
		return blockState.setValue(ROTATION, mirror.mirror(blockState.getValue(ROTATION), 16));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(ROTATION);
	}

	static {
		ROTATION = BlockStateProperties.ROTATION_16;
	}
}
