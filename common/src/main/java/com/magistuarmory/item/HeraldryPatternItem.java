package com.magistuarmory.item;

import java.util.List;

import com.magistuarmory.init.HeraldryPattern;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BannerPattern;
import org.jetbrains.annotations.Nullable;

public class HeraldryPatternItem extends BannerPatternItem
{
	private final HeraldryPattern heraldry;

	public HeraldryPatternItem(HeraldryPattern heraldry, Properties properties)
	{
		super(BannerPattern.BASE, properties.stacksTo(1));
		this.heraldry = heraldry;
	}

	@Override
	public BannerPattern getBannerPattern()
	{
		return this.heraldry.get();
	}

	@Override
	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag)
	{
		list.add(this.getDisplayName().withStyle(ChatFormatting.GRAY));
	}

	public MutableComponent getDisplayName()
	{
		return new TranslatableComponent(this.getDescriptionId() + ".desc");
	}
}
