package com.magistuarmory.forge.misc;

import com.magistuarmory.misc.HeraldryPattern;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.Locale;

public class HeraldryPatterns
{
	public static void init()
	{
		for (HeraldryPattern pattern : HeraldryPattern.values())
		{
			BannerPattern.create(pattern.name.toUpperCase(Locale.ROOT), pattern.name, pattern.hashname, true);
		}
	}
}
