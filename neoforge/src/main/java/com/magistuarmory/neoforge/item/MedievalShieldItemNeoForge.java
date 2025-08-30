package com.magistuarmory.neoforge.item;

import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.ShieldType;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.function.Consumer;

public class MedievalShieldItemNeoForge extends MedievalShieldItem
{
	public MedievalShieldItemNeoForge(String id, ResourceLocation location, Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		super(id, location, properties, material, paintable, is3d, type);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ItemAbility action)
	{
		return ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(action);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void initializeClient(Consumer<IClientItemExtensions> consumer)
	{
		consumer.accept(new IClientItemExtensions()
		{
			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer()
			{
				return renderer;
			}
		});
	}
}