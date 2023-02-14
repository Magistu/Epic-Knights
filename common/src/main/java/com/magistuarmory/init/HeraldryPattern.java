package com.magistuarmory.init;

import com.magistuarmory.KnightlyArmory;
import net.minecraft.world.level.block.entity.BannerPattern;

public enum HeraldryPattern
{
	APOSTOLIC_CROSS_PATTERN("apostolic_cross"),
	BOWL_PATTERN("bowl"),
	BULL_PATTERN("bull"),
	CHESS_PATTERN("chess"),
	CRUSADER_CROSS_PATTERN("crusader_cross"),
	DRAGON_PATTERN("dragon"),
	EAGLE_PATTERN("eagle"),
	HORSE_PATTERN("horse"),
	LILY_PATTERN("lily"),
	LION1_PATTERN("lion1"),
	LION2_PATTERN("lion2"),
	ORTHODOX_CROSS_PATTERN("orthodox_cross"),
	SNAKE_PATTERN("snake"),
	SUN_PATTERN("sun"),
	SWORDS_PATTERN("swords"),
	TOWER_PATTERN("tower"),
	TREE_PATTERN("tree"),
	TWOHEADED_EAGLE_PATTERN("two-headed_eagle");

	public final String name;
	public final String hashname;

	HeraldryPattern(String name)
	{
		this.name = name;
		this.hashname = KnightlyArmory.ID + "." + name;
	}
	
	public BannerPattern get()
	{
		return BannerPattern.byHash(this.hashname);
	}
}
