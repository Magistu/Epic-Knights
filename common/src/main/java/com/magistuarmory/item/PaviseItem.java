package com.magistuarmory.item;

import com.magistuarmory.block.ModBlocks;
import com.magistuarmory.client.render.model.Models;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Objects;


public class PaviseItem extends MedievalShieldItem
{
	private final Direction attachmentDirection = Direction.DOWN;
	
	public PaviseItem(String id, String name, Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Models.ShieldEnum modelkey)
	{
		super(id, name, properties, material, paintable, is3d, type, modelkey);
	}

	private static <T extends Comparable<T>> BlockState updateState(BlockState blockstate, Property<T> property, String string)
	{
		return property.getValue(string).map((comparable) -> blockstate.setValue(property, comparable)).orElse(blockstate);
	}

	public static boolean updateCustomBlockEntityTag(Level level, @Nullable Player player, BlockPos blockpos, ItemStack stack)
	{
		MinecraftServer server = level.getServer();
        if (server != null)
        {
            CompoundTag blockentitytag = getBlockEntityData(stack);
            BlockEntity blockentity = level.getBlockEntity(blockpos);
            if (blockentity != null)
            {
                if (!level.isClientSide && blockentity.onlyOpCanSetNbt() && (player == null || !player.canUseGameMasterBlocks()))
                    return false;

                CompoundTag tag2 = blockentity.saveWithoutMetadata();
                CompoundTag tag3 = tag2.copy();
	            if (stack.getTag() != null)
		            tag2.put("ItemStack", stack.getTag());
	            tag2.putBoolean("Enchanted", stack.isEnchanted());
	            tag2.putString("ShieldId", ((PaviseItem) stack.getItem()).getId());
				if (blockentitytag != null)
				{
					blockentitytag.putInt("Base", PaviseItem.getColor(stack).getId());
					tag2.merge(blockentitytag);
				}
                if (!tag2.equals(tag3))
                {
                    blockentity.load(tag2);
                    blockentity.setChanged();
                    return true;
                }
            }

        }
        return false;
    }

	@Nullable
	public static CompoundTag getBlockEntityData(ItemStack stack)
	{
		return stack.getTagElement("BlockEntityTag");
	}

	public static ListTag getEnchantmentData(ItemStack stack)
	{
		return stack.getEnchantmentTags();
	}

	public static void setBlockEntityData(ItemStack stack, BlockEntityType<?> type, CompoundTag tag)
	{
		if (tag.isEmpty())
			stack.removeTagKey("BlockEntityTag");
		
		BlockEntity.addEntityType(tag, type);
		stack.addTagElement("BlockEntityTag", tag);
	}

	@Override
	public InteractionResult useOn(UseOnContext context)
	{
		InteractionResult result = super.useOn(context);
		if (result.consumesAction() || (context.getPlayer() != null && !context.getPlayer().isShiftKeyDown()))
			return result;
		
		result = this.place(new BlockPlaceContext(context));
		if (!result.consumesAction() && this.isEdible())
		{
			InteractionResult result2 = this.use(context.getLevel(), context.getPlayer(), context.getHand()).getResult();
			return result2 == InteractionResult.CONSUME ? InteractionResult.CONSUME_PARTIAL : result2;
		}
		return result;
	}

	public InteractionResult place(BlockPlaceContext context)
	{
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
			this.updateCustomBlockEntityTag(blockpos, level, player, stack, blockstate2);
			blockstate2.getBlock().setPlacedBy(level, blockpos, blockstate2, player, stack);
			if (player instanceof ServerPlayer)
				CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) player, blockpos, stack);
		}

		SoundType sound = blockstate2.getSoundType();
		level.playSound(player, blockpos, this.getPlaceSound(blockstate2), SoundSource.BLOCKS, (sound.getVolume() + 1.0F) / 2.0F, sound.getPitch() * 0.8F);
		level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
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

	protected boolean updateCustomBlockEntityTag(BlockPos blockpos, Level level, @Nullable Player player, ItemStack stack, BlockState blockstate)
	{
		return updateCustomBlockEntityTag(level, player, blockpos, stack);
	}

	private BlockState updateBlockStateFromTag(BlockPos blockpos, Level level, ItemStack stack, BlockState blockstate)
	{
		BlockState blockstate2 = blockstate;
		CompoundTag tag = stack.getTag();
		if (tag != null)
		{
			CompoundTag tag2 = tag.getCompound("BlockStateTag");
			StateDefinition<Block, BlockState> statedefinition = blockstate.getBlock().getStateDefinition();

            for (String string : tag2.getAllKeys())
            {
                Property<?> property = statedefinition.getProperty(string);
                if (property != null)
                {
                    String string2 = Objects.requireNonNull(tag2.get(string)).getAsString();
                    blockstate2 = updateState(blockstate2, property, string2);
                }
            }
		}

		if (blockstate2 != blockstate)
			level.setBlock(blockpos, blockstate2, 2);

		return blockstate2;
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
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag tooltipflag)
	{
		super.appendHoverText(stack, level, list, tooltipflag);
		list.add(new TranslatableComponent("canbeplacedonground").withStyle(ChatFormatting.BLUE));
	}

	public Block getBlock()
	{
		return ModBlocks.PAVISE.get();
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
