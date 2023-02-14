package com.magistuarmory.client.render.model.item;
// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

@Environment(EnvType.CLIENT)
public class BucklerModel extends MedievalShieldModel 
{
	private final ModelPart root;
	private final ModelPart plate;
	private final ModelPart handle;

	public BucklerModel(ModelPart root)
	{
		super(RenderType::entityCutout);
		this.root = root;
		this.plate = root.getChild("plate");
		this.handle = root.getChild("handle");
	}

	public static LayerDefinition createLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(14, 32).addBox(-3.0F, -8.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 34).addBox(-5.0F, -7.0F, -2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(11, 36).addBox(-6.0F, -6.0F, -2.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 39).addBox(-7.0F, -4.0F, -2.0F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(11, 44).addBox(-6.0F, 0.0F, -2.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 47).addBox(-5.0F, 2.0F, -2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 49).addBox(-3.0F, 3.0F, -2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(47, 37).addBox(-3.0F, -5.0F, -3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(46, 39).addBox(-4.0F, -4.0F, -3.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(47, 44).addBox(-3.0F, 0.0F, -3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 54).addBox(-3.0F, -4.0F, -4.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.0F, 0.0F));
		partdefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(48, 52).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
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