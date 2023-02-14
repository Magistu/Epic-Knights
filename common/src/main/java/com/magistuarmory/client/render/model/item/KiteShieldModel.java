package com.magistuarmory.client.render.model.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

@Environment(EnvType.CLIENT)
public class KiteShieldModel extends MedievalShieldModel
{
	private final ModelPart root;
	private final ModelPart plate;
	private final ModelPart handle;

	public KiteShieldModel(ModelPart part)
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

		partdefinition.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(0, 0).addBox(-15.5F, -17.0F, -2.0F, 31.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 33).addBox(-3.5F, -9.0F, -2.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 35).addBox(-5.5F, -8.0F, -2.0F, 11.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 38).addBox(-6.5F, -6.0F, -2.0F, 13.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 46).addBox(-5.5F, 1.0F, -2.0F, 11.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 49).addBox(-4.5F, 3.0F, -2.0F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 52).addBox(-3.5F, 5.0F, -2.0F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 55).addBox(-2.5F, 7.0F, -2.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 58).addBox(-1.5F, 9.0F, -2.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

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