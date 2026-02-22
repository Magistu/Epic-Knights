package com.magistuarmory.item;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;


public class MedievalBagItem extends Item
{
	public MedievalBagItem()
	{
		super(new Properties().stacksTo(1));
	}
	
	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
	{
		InteractionResultHolder<ItemStack> result = super.use(level, player, hand);
		if (level.isClientSide() || result.getResult().consumesAction())
			return result;
		
		ItemStack bagstack = player.getItemInHand(hand);
		player.getInventory().setItem(player.getInventory().findSlotMatchingItem(bagstack), ItemStack.EMPTY);
		
		for (ItemStack stack : getContents(bagstack))
		{
			if (!player.addItem(stack))
				level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), stack));
		}
		
		return new InteractionResultHolder<>(InteractionResult.SUCCESS, bagstack);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag)
	{
		super.appendHoverText(stack, level, tooltip, flag);
		tooltip.add(Component.translatable("medieval_bag.rightclick").withStyle(Style.EMPTY.withColor(ChatFormatting.BLUE).withItalic(true)));
	}
		
	public static void setContents(ItemStack bagstack, List<ItemStack> stacks)
	{
		ListTag listtag = new ListTag();
		for (ItemStack stack : stacks)
			listtag.add(stack.save(new CompoundTag()));
		
		bagstack.addTagElement("Contents", listtag);
	}
	
	public static List<ItemStack> getContents(ItemStack bagstack)
	{
		List<ItemStack> stacks = new ArrayList<>();
		CompoundTag compound = bagstack.getTag();
		ListTag listtag = compound != null ? bagstack.getTag().getList("Contents", 10) : new ListTag();
		for (int i = 0; i < listtag.size(); ++i)
			stacks.add(ItemStack.of(listtag.getCompound(i)));
		
		return stacks;
	}
}
