package com.magistuarmory.misc;

import com.magistuarmory.EpicKnights;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ModBannerPatternTags
{
    public static final TagKey<BannerPattern> APOSTOLIC_CROSS_PATTERN = create("apostolic_cross");
    public static final TagKey<BannerPattern> BOWL_PATTERN = create("bowl");
    public static final TagKey<BannerPattern> BULL_PATTERN = create("bull");
    public static final TagKey<BannerPattern> CHESS_PATTERN = create("chess");
    public static final TagKey<BannerPattern> CRUSADER_CROSS_PATTERN = create("crusader_cross");
    public static final TagKey<BannerPattern> DRAGON_PATTERN = create("dragon");
    public static final TagKey<BannerPattern> EAGLE_PATTERN = create("eagle");
    public static final TagKey<BannerPattern> HORSE_PATTERN = create("horse");
    public static final TagKey<BannerPattern> LILY_PATTERN = create("lily");
    public static final TagKey<BannerPattern> LION1_PATTERN = create("lion1");
    public static final TagKey<BannerPattern> LION2_PATTERN = create("lion2");
    public static final TagKey<BannerPattern> ORTHODOX_CROSS_PATTERN = create("orthodox_cross");
    public static final TagKey<BannerPattern> SNAKE_PATTERN = create("snake");
    public static final TagKey<BannerPattern> SUN_PATTERN = create("sun");
    public static final TagKey<BannerPattern> SWORDS_PATTERN = create("swords");
    public static final TagKey<BannerPattern> TOWER_PATTERN = create("tower");
    public static final TagKey<BannerPattern> TREE_PATTERN = create("tree");
    public static final TagKey<BannerPattern> TWOHEADED_EAGLE_PATTERN = create("two_headed_eagle");

    private static TagKey<BannerPattern> create(String name) 
    {
        return TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "pattern_item/" + name));
    }
}
