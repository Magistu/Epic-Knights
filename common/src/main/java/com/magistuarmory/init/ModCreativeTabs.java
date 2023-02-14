package com.magistuarmory.init;

import com.magistuarmory.KnightlyArmory;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs
{
	public static final CreativeModeTab ARMOR = createTab("armor", "armet");
	public static final CreativeModeTab WEAPONS = createTab("weapons", "iron_flamebladedsword");
	public static final CreativeModeTab PARTICULAR_WEAPONS = createTab("particular_weapons", "noble_sword");
	public static final CreativeModeTab SHIELDS = createTab("shields", "iron_heatershield");

	public static CreativeModeTab createTab(String tab, String iconitem)
	{
		return CreativeTabRegistry.create(new ResourceLocation(KnightlyArmory.ID, tab), () -> new ItemStack(Registry.ITEM.getOptional(new ResourceLocation(KnightlyArmory.ID, iconitem)).get()));
	}
}
