package com.magistuarmory.client.render;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/** Shared numeric properties used by the 26.1 range-select item models. */
public final class ItemPropertiesRegistry {
    private static final Map<Item, Map<Identifier, Getter>> GETTERS = new IdentityHashMap<>();
    private ItemPropertiesRegistry() {}

    public static void register(Item item, Identifier property, Getter getter) {
        GETTERS.computeIfAbsent(item, ignored -> new HashMap<>()).put(property, getter);
    }

    @FunctionalInterface
    public interface Getter {
        float get(ItemStack stack, ClientLevel level, LivingEntity entity, int seed);
    }

    public record Property(Identifier name) implements RangeSelectItemModelProperty {
        public static final MapCodec<Property> CODEC = Identifier.CODEC.fieldOf("name").xmap(Property::new, Property::name);
        @Override
        public float get(ItemStack stack, ClientLevel level, ItemOwner owner, int seed) {
            Getter getter = GETTERS.getOrDefault(stack.getItem(), Map.of()).get(name);
            return getter == null ? 0 : getter.get(stack, level, owner == null ? null : owner.asLivingEntity(), seed);
        }
        @Override
        public MapCodec<Property> type() { return CODEC; }
    }
}
