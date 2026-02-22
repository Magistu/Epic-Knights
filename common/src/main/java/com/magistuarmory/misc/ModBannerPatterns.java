package com.magistuarmory.misc;

import com.magistuarmory.EpicKnights;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ModBannerPatterns
{
	public static final DeferredRegister<BannerPattern> PATTERNS = DeferredRegister.create(EpicKnights.ID, Registries.BANNER_PATTERN);

	public static final RegistrySupplier<BannerPattern> APOSTOLIC_CROSS_PATTERN = add("apostolic_cross");
	public static final RegistrySupplier<BannerPattern> BOWL_PATTERN = add("bowl");
	public static final RegistrySupplier<BannerPattern> BULL_PATTERN = add("bull");
	public static final RegistrySupplier<BannerPattern> CHESS_PATTERN = add("chess");
	public static final RegistrySupplier<BannerPattern> CRUSADER_CROSS_PATTERN = add("crusader_cross");
	public static final RegistrySupplier<BannerPattern> DRAGON_PATTERN = add("dragon");
	public static final RegistrySupplier<BannerPattern> EAGLE_PATTERN = add("eagle");
	public static final RegistrySupplier<BannerPattern> HORSE_PATTERN = add("horse");
	public static final RegistrySupplier<BannerPattern> LILY_PATTERN = add("lily");
	public static final RegistrySupplier<BannerPattern> LION1_PATTERN = add("lion1");
	public static final RegistrySupplier<BannerPattern> LION2_PATTERN = add("lion2");
	public static final RegistrySupplier<BannerPattern> ORTHODOX_CROSS_PATTERN = add("orthodox_cross");
	public static final RegistrySupplier<BannerPattern> SNAKE_PATTERN = add("snake");
	public static final RegistrySupplier<BannerPattern> SUN_PATTERN = add("sun");
	public static final RegistrySupplier<BannerPattern> SWORDS_PATTERN = add("swords");
	public static final RegistrySupplier<BannerPattern> TOWER_PATTERN = add("tower");
	public static final RegistrySupplier<BannerPattern> TREE_PATTERN = add("tree");
	public static final RegistrySupplier<BannerPattern> TWOHEADED_EAGLE_PATTERN = add("two-headed_eagle");

	public static RegistrySupplier<BannerPattern> add(String name) {
		return PATTERNS.register(name, () -> new BannerPattern(name));
	}

	public static void init()
	{
		PATTERNS.register();
	}
}

