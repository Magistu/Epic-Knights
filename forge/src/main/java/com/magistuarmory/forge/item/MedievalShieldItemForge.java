package com.magistuarmory.forge.item;

import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.ShieldType;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.function.Consumer;

public class MedievalShieldItemForge extends MedievalShieldItem
{
	public MedievalShieldItemForge(String id, ResourceLocation location, Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		super(id, location, properties, material, paintable, is3d, type);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction action)
	{
		return ToolActions.DEFAULT_SHIELD_ACTIONS.contains(action);
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