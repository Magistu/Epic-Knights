package com.magistuarmory.fabric.misc;

import com.chocohead.mm.api.ClassTinkerers;
import com.chocohead.mm.api.EnumAdder;
import com.magistuarmory.misc.HeraldryPattern;
import net.fabricmc.loader.api.MappingResolver;
import net.fabricmc.loader.api.FabricLoader;

import java.util.Locale;

public class HeraldryPatternsEarlyRiser implements Runnable
{
	@Override
	public void run()
	{
		MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
		String classname = remapper.mapClassName("intermediary", "net.minecraft.class_2582");
		EnumAdder adder = ClassTinkerers.enumBuilder(classname, String.class, String.class, boolean.class);

		for (HeraldryPattern pattern : HeraldryPattern.values())
		{
			adder.addEnum(pattern.name.toUpperCase(Locale.ROOT), () -> new Object[]{ pattern.name, pattern.hashname, true });
		}
		adder.build();
	}
}
