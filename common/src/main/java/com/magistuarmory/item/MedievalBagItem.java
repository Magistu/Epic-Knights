package com.magistuarmory.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;

import java.util.List;


public class MedievalBagItem extends Item
{
	public MedievalBagItem(Properties properties)
	{
		super(properties.stacksTo(1).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
	}
	
	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand)
	{
        if (level.isClientSide()) return InteractionResult.SUCCESS;
        ItemStack bagstack = player.getItemInHand(hand);
        player.setItemInHand(hand, ItemStack.EMPTY);

		getContents(bagstack).nonEmptyItemCopyStream().forEach(s -> {
			if (!player.addItem(s))
				level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), s));
		});
		
		return InteractionResult.SUCCESS;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> tooltip, TooltipFlag flag)
	{
		super.appendHoverText(stack, tooltipContext, display, tooltip, flag);
		tooltip.accept(Component.translatable("medieval_bag.rightclick").withStyle(Style.EMPTY.withColor(ChatFormatting.BLUE).withItalic(true)));
	}
	
	public static void setContents(ItemStack bagstack, List<ItemStack> stacks)
	{
		bagstack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(stacks));
	}
	
	public static ItemContainerContents getContents(ItemStack bagstack)
	{
		return bagstack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
	}
}
