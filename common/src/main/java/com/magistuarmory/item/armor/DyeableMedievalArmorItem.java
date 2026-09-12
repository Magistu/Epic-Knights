package com.magistuarmory.item.armor;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.item.DyeableItemLike;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.ARGB;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.DyedItemColor;

import java.util.List;

public class DyeableMedievalArmorItem extends MedievalArmorItem implements DyeableItemLike
{
    private final int defaultcolor;

	public DyeableMedievalArmorItem(ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Properties properties, int defaultcolor)
    {
        super(material, type, properties.component(DataComponents.DYED_COLOR, new DyedItemColor(defaultcolor)));
        this.defaultcolor = ARGB.opaque(defaultcolor);
    }

    public int getDefaultColor() {
        return defaultcolor;
    }

    @Override
    public int getColor(ItemStack stack)
    {
        DyedItemColor color = stack.get(DataComponents.DYED_COLOR);
        return ARGB.opaque(color != null ? color.rgb() : getDefaultColor());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> tooltip, TooltipFlag flag)
    {
        super.appendHoverText(stack, tooltipContext, display, tooltip, flag);
        tooltip.accept((Component.translatable(EpicKnights.ID + ".dyeable_armor.description")).withStyle(Style.EMPTY.withColor(ChatFormatting.BLUE).withItalic(true)));
    }
}
