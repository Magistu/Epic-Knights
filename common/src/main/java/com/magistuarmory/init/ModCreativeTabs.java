package com.magistuarmory.init;

import com.magistuarmory.KnightlyArmory;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeTabs
{
	public static final CreativeModeTab ARMOR = createTab("armor", "magistuarmory:armet");
	public static final CreativeModeTab WEAPONS = createTab("weapons", "magistuarmory:iron_flamebladedsword");
	public static final CreativeModeTab PARTICULAR_WEAPONS = createTab("particular_weapons", "magistuarmory:noble_sword");
	public static final CreativeModeTab SHIELDS = createTab("shields", "magistuarmory:iron_heatershield");
	public static final CreativeModeTab RUSTED = createTab("rusted", "magistuarmory:rusted_bastardsword");

	public static CreativeModeTab createTab(String tab, String iconitemid)
	{
		return CreativeTabRegistry.create(new ResourceLocation(KnightlyArmory.ID, tab), () -> new ItemStack(Registry.ITEM.getOptional(new ResourceLocation(iconitemid)).orElse(Items.BARRIER)));
	}
}
