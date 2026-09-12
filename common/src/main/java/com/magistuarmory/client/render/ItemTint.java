package com.magistuarmory.client.render;

import com.magistuarmory.item.DyeableItemLike;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public record ItemTint() implements ItemTintSource {
    public static final MapCodec<ItemTint> CODEC = MapCodec.unit(new ItemTint());
    @Override
    public int calculate(ItemStack stack, ClientLevel level, LivingEntity owner) {
        return stack.getItem() instanceof DyeableItemLike dyeable ? dyeable.getColor(stack) : -1;
    }
    @Override
    public MapCodec<ItemTint> type() { return CODEC; }
}
