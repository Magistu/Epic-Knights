package com.magistuarmory.client.render.model.item;

import java.util.function.Function;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public abstract class MedievalShieldModel extends Model
{
	public MedievalShieldModel(Function<ResourceLocation, RenderType> function) 
	{
		super(function);
	}

	public abstract ModelPart plate();

	public abstract ModelPart handle();

	public abstract void renderToBuffer(PoseStack pose, VertexConsumer vertexconsumer, int i, int j, float f, float g, float h, float k);
}
