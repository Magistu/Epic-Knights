package com.magistuarmory.fabric.client.render.tileentity;

import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

@Environment(EnvType.CLIENT)
public class HeraldryItemStackRendererFabric extends HeraldryItemStackRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer
{
	public HeraldryItemStackRendererFabric(String id, ResourceLocation location)
	{
		super(id, location);
	}

	@Override
	public void render(ItemStack stack, ItemDisplayContext mode, PoseStack matrices, MultiBufferSource vertexConsumers, int p, int overlay)
	{
		super.renderByItem(stack, mode, matrices, vertexConsumers, p, overlay);
	}
}