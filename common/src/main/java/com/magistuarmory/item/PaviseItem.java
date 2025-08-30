package com.magistuarmory.item;

import com.magistuarmory.block.ModBlocks;
import com.magistuarmory.block.PaviseBlock;
import com.magistuarmory.block.PaviseBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;


public class PaviseItem extends MedievalShieldItem
{
	private final Direction attachmentDirection = Direction.DOWN;
	private final Supplier<PaviseBlock> block;
	
	public PaviseItem(String id, ResourceLocation location, Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Supplier<PaviseBlock> block)
	{
		super(id, location, properties, material, paintable, is3d, type);
		this.block = block;
	}

	@Override
	public @NotNull InteractionResult useOn(UseOnContext context)
	{
		InteractionResult interactionResult = this.place(new BlockPlaceContext(context));
		if (!interactionResult.consumesAction() && context.getItemInHand().has(DataComponents.FOOD)) 
		{
			InteractionResult interactionResult2 = super.use(context.getLevel(), context.getPlayer(), context.getHand()).getResult();
			return interactionResult2 == InteractionResult.CONSUME ? InteractionResult.CONSUME_PARTIAL : interactionResult2;
		} 
		else 
		{
			return interactionResult;
		}
	}

	public InteractionResult place(BlockPlaceContext context)
	{
		if (!this.getBlock().isEnabled(context.getLevel().enabledFeatures()))
			return InteractionResult.FAIL;
		
		if (!context.canPlace())
			return InteractionResult.FAIL;
		
		BlockPlaceContext context2 = this.updatePlacementContext(context);
		if (context2 == null)
			return InteractionResult.FAIL;
		
		BlockState blockstate = this.getPlacementState(context2);
		if (blockstate == null)
			return InteractionResult.FAIL;
			
		if (!this.placeBlock(context2, blockstate))
			return InteractionResult.FAIL;
		
		BlockPos blockpos = context2.getClickedPos();
		Level level = context2.getLevel();
		Player player = context2.getPlayer();
		ItemStack stack = context2.getItemInHand();
		BlockState blockstate2 = level.getBlockState(blockpos);
		if (blockstate2.is(blockstate.getBlock()))
		{
			blockstate2 = this.updateBlockStateFromTag(blockpos, level, stack, blockstate2);
			BlockEntity blockentity = level.getBlockEntity(blockpos);
			if (blockentity instanceof PaviseBlockEntity paviseblockentity)
				paviseblockentity.fromItem(stack);
			blockstate2.getBlock().setPlacedBy(level, blockpos, blockstate2, player, stack);
			if (player instanceof ServerPlayer)
				CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) player, blockpos, stack);
		}

		SoundType sound = blockstate2.getSoundType();
		level.playSound(player, blockpos, this.getPlaceSound(blockstate2), SoundSource.BLOCKS, (sound.getVolume() + 1.0F) / 2.0F, sound.getPitch() * 0.8F);
		level.gameEvent(GameEvent.BLOCK_PLACE, blockpos, GameEvent.Context.of(player, blockstate2));
		if (player == null || !player.getAbilities().instabuild)
			stack.shrink(1);

		return InteractionResult.sidedSuccess(level.isClientSide);
	}

	protected SoundEvent getPlaceSound(BlockState blockstate)
	{
		return blockstate.getSoundType().getPlaceSound();
	}

	@Nullable
	public BlockPlaceContext updatePlacementContext(BlockPlaceContext context)
	{
		return context;
	}

	private BlockState updateBlockStateFromTag(BlockPos blockpos, Level level, ItemStack stack, BlockState blockstate)
	{
		BlockItemStateProperties blockItemStateProperties = stack.getOrDefault(DataComponents.BLOCK_STATE, BlockItemStateProperties.EMPTY);
		if (blockItemStateProperties.isEmpty()) 
		{
			return blockstate;
		} 
		else 
		{
			BlockState blockstate2 = blockItemStateProperties.apply(blockstate);
			if (blockstate2 != blockstate) {
				level.setBlock(blockpos, blockstate2, 2);
			}

			return blockstate2;
		}
	}

	protected boolean placeBlock(BlockPlaceContext context, BlockState blockstate)
	{
		Level level = context.getLevel();
		BlockPos aboveblockpos = context.getClickedPos().above();
		if (level.isStateAtPosition(aboveblockpos, (state) -> state.getBlock() != Blocks.AIR) && !level.isWaterAt(aboveblockpos))
			return false;
		if (!context.getLevel().setBlock(context.getClickedPos(), blockstate, 11))
			return false;
		level.setBlock(aboveblockpos, ModBlocks.PAVISE_UPPER_COLLISION.get().defaultBlockState(), 27);
		return true;
	}

	public String getDescriptionId()
	{
		return this.getBlock().getDescriptionId();
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipflag)
	{
		super.appendHoverText(stack, tooltipContext, list, tooltipflag);
		list.add(Component.translatable("canbeplacedonground").withStyle(ChatFormatting.BLUE));
	}

	public PaviseBlock getBlock()
	{
		return this.block.get();
	}

	@Override
	public @NotNull FeatureFlagSet requiredFeatures()
	{
		return this.getBlock().requiredFeatures();
	}

	protected boolean canPlace(LevelReader levelreader, BlockState blockstate, BlockPos blockpos)
	{
		return blockstate.canSurvive(levelreader, blockpos);
	}

	@Nullable
	protected BlockState getPlacementState(BlockPlaceContext context)
	{
		BlockState blockstate2 = null;
		LevelReader levelreader = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		Direction[] var6 = context.getNearestLookingDirections();

		for (Direction direction : var6)
		{
			if (direction != this.attachmentDirection.getOpposite())
			{
				BlockState blockstate3 = this.getBlock().getStateForPlacement(context);
				if (blockstate3 != null && this.canPlace(levelreader, blockstate3, blockpos))
				{
					blockstate2 = blockstate3;
					break;
				}
			}
		}

		return blockstate2 != null && levelreader.isUnobstructed(blockstate2, blockpos, CollisionContext.empty()) ? blockstate2 : null;
	}
}
