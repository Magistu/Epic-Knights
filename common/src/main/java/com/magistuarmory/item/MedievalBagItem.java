package com.magistuarmory.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public class MedievalBagItem extends Item
{
	public MedievalBagItem()
	{
		super(new Properties().stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
	{
		InteractionResultHolder<ItemStack> result = super.use(level, player, hand);
		if (level.isClientSide() || result.getResult().consumesAction())
			return result;
		
		ItemStack bagstack = player.getItemInHand(hand);
		player.getInventory().setItem(player.getInventory().findSlotMatchingItem(bagstack), ItemStack.EMPTY);

		getContents(bagstack).nonEmptyStream().forEach(s -> {
			if (!player.addItem(s))
				level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), s));
		});
		
		return new InteractionResultHolder<>(InteractionResult.SUCCESS, bagstack);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipflag)
	{
		list.add(Component.translatable("medieval_bag.rightclick").withStyle(ChatFormatting.BLUE));
	}
	
	public static void setContents(ItemStack bagstack, List<ItemStack> stacks)
	{
		bagstack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(stacks));
	}
	
	public static ItemContainerContents getContents(ItemStack bagstack)
	{
		return bagstack.get(DataComponents.CONTAINER);
	}
}
