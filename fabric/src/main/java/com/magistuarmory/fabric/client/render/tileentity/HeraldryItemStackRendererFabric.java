package com.magistuarmory.fabric.client.render.tileentity;

import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;

@Environment(EnvType.CLIENT)
public class HeraldryItemStackRendererFabric extends HeraldryItemStackRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer
{
	public HeraldryItemStackRendererFabric(String id, String name, Model model)
	{
		super(id, name, model);
	}

	@Override
	public void render(ItemStack stack, ItemTransforms.TransformType mode, PoseStack matrices, MultiBufferSource vertexConsumers, int p, int overlay)
	{
		super.renderByItem(stack, mode, matrices, vertexConsumers, p, overlay);
	}
}