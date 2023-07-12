package com.magistuarmory.client.render.model.block;

import com.magistuarmory.client.render.model.item.MedievalShieldModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

@Environment(EnvType.CLIENT)
public class PaviseBlockModel extends MedievalShieldModel
{
	private final ModelPart root;
	private final ModelPart plate;
	private final ModelPart handleAndSupport;

	public PaviseBlockModel(ModelPart part)
	{
		super(RenderType::entityCutout);
		this.root = part;
		this.plate = part.getChild("plate");
		this.handleAndSupport = part.getChild("handle_and_support");

	}
	
	public static LayerDefinition createLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(52, 35).addBox(-9.5F, 7.0F, -5.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(52, 33).addBox(-9.5F, -18.0F, -5.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 58).addBox(-14.5F, 7.0F, -4.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 56).addBox(-15.5F, 6.0F, -4.0F, 17.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 33).addBox(-16.5F, -16.0F, -4.0F, 19.0F, 22.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 60).addBox(-15.5F, -17.0F, -4.0F, 17.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 62).addBox(-14.5F, -18.0F, -4.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(13, 0).addBox(-9.5F, -21.0F, -5.0F, 5.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-22.5F, -21.0F, -4.0F, 31.0F, 32.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition handleAndSupport = partdefinition.addOrReplaceChild("handle_and_support", CubeListBuilder.create(), PartPose.ZERO);
		handleAndSupport.addOrReplaceChild("support", CubeListBuilder.create().texOffs(41, 6).mirror().addBox(-15.0F, -8.0F, 3.0F, 2.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(41, 6).addBox(-1.0F, -8.0F, 3.0F, 2.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		handleAndSupport.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(48, 52).addBox(-8.0F, -9.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	
	public ModelPart plate() 
	{
		return this.plate;
	}

	public ModelPart handle() 
	{
		return this.handleAndSupport;
	}

	public void renderToBuffer(PoseStack pose, VertexConsumer vertexconsumer, int i, int j, float f, float g, float h, float k) 
	{
		this.root.render(pose, vertexconsumer, i, j, f, g, h, k);
	}
}
