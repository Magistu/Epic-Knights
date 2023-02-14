package com.magistuarmory.client.render.model.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;

// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

@Environment(EnvType.CLIENT)
public class RoundShieldModel extends MedievalShieldModel 
{
	private final ModelPart root;
	private final ModelPart plate;
	private final ModelPart handle;

	public RoundShieldModel(ModelPart part)
	{
		super(RenderType::entityCutout);
		this.root = part;
		this.plate = part.getChild("plate");
		this.handle = part.getChild("handle");

	}
	
	public static LayerDefinition createLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(0, 0).addBox(-15.5F, -17.0F, -2.0F, 31F, 31F, 1.0F).texOffs(0, 33).addBox(-7.5F, -6.0F, -2.0F, 15.0F, 7.0F, 1.0F).texOffs(36, 33).addBox(-6.5F, 1.0F, -2.0F, 13.0F, 2.0F, 1.0F).texOffs(40, 36).addBox(-5.5F, 3.0F, -2.0F, 11.0F, 1.0F, 1.0F).texOffs(48, 38).addBox(-3.5F, 4.0F, -2.0F, 7.0F, 1.0F, 1.0F).texOffs(36, 44).addBox(-6.5F, -8.0F, -2.0F, 13.0F, 2.0F, 1.0F).texOffs(48, 40).addBox(-3.5F, -10.0F, -2.0F, 7.0F, 1.0F, 1.0F).texOffs(40, 42).addBox(-5.5F, -9.0F, -2.0F, 11.0F, 1.0F, 1.0F), PartPose.ZERO);
		partdefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(48, 52).addBox(-1.0F, -3.0F, -1.0F, 2F, 6F, 6F), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	
	public ModelPart plate() 
	{
		return this.plate;
	}

	public ModelPart handle() 
	{
		return this.handle;
	}

	public void renderToBuffer(PoseStack pose, VertexConsumer vertexconsumer, int i, int j, float f, float g, float h, float k) 
	{
		this.root.render(pose, vertexconsumer, i, j, f, g, h, k);
	}
}