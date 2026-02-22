package com.magistuarmory.item.armor;

import com.magistuarmory.EpicKnights;
import org.jetbrains.annotations.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class DyeableMedievalArmorItem extends MedievalArmorItem implements DyeableLeatherItem
{
    int defaultcolor;

	public DyeableMedievalArmorItem(ArmorMaterial material, Type type, Properties properties, int defaultcolor)
    {
        super(material, type, properties);
        this.defaultcolor = defaultcolor;
    }

    @Override
    public int getColor(ItemStack stack)
    {
        CompoundTag compoundnbt = stack.getTagElement("display");
        return compoundnbt != null && compoundnbt.contains("color", 99) ? compoundnbt.getInt("color") : defaultcolor;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag)
    {
        super.appendHoverText(stack, level, tooltip, flag);
        tooltip.add((Component.translatable(EpicKnights.ID + ".dyeable_armor.description")).withStyle(Style.EMPTY.withColor(ChatFormatting.BLUE).withItalic(true)));
    }
}
