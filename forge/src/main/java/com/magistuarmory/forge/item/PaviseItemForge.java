package com.magistuarmory.forge.item;

import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.PaviseItem;
import com.magistuarmory.item.ShieldType;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.client.IItemRenderProperties;
import java.util.function.Consumer;


public class PaviseItemForge extends PaviseItem
{
	public PaviseItemForge(String id, String name, Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Models.ShieldEnum modelkey)
	{
		super(id, name, properties, material, paintable, is3d, type, modelkey);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction action)
	{
		return ToolActions.DEFAULT_SHIELD_ACTIONS.contains(action);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void initializeClient(Consumer<IItemRenderProperties> consumer)
	{
		consumer.accept(new IItemRenderProperties()
		{
			@Override
			public BlockEntityWithoutLevelRenderer getItemStackRenderer()
			{
				return renderer;
			}
		});
	}
}