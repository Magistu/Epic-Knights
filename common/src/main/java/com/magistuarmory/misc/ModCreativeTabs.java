package com.magistuarmory.misc;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.item.ModItems;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import java.util.*;
import java.util.function.Supplier;

public class ModCreativeTabs
{
	public static final CreativeModeTab ARMOR = createTab("armor", "magistuarmory:armet");
	public static final CreativeModeTab WEAPONS = createTab("weapons", "magistuarmory:iron_flamebladedsword");
	public static final CreativeModeTab PARTICULAR_WEAPONS = createTab("particular_weapons", "magistuarmory:noble_sword");
	public static final CreativeModeTab SHIELDS = createTab("shields", "magistuarmory:iron_heatershield");
	public static final CreativeModeTab RUSTED = createTab("rusted", "magistuarmory:rusted_bastardsword");
	public static final CreativeModeTab ARMOR_DECORATIONS = createTab("armor_decorations", "magistuarmory:crown_decoration");

	public static CreativeModeTab createTab(String tab, String iconitemid)
	{
		return CreativeTabRegistry.create(new ResourceLocation(EpicKnights.ID, tab), () -> new ItemStack(Registry.ITEM.getOptional(new ResourceLocation(iconitemid)).orElse(Items.BARRIER)));
	}
	
	public static void init()
	{
		
	}
}
