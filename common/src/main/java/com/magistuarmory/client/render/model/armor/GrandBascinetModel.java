package com.magistuarmory.client.render.model.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

@Environment(EnvType.CLIENT)
public class GrandBascinetModel
{
	
	public static LayerDefinition createLayer() 
	{
	    MeshDefinition meshdefinition = new MeshDefinition();
	    PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -7.85F, -3.2F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.9F))
				.texOffs(38, 6).addBox(-4.0F, -7.85F, -3.7F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.87F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Helmet_r1 = head.addOrReplaceChild("Helmet_r1", CubeListBuilder.create().texOffs(0, 10).addBox(-0.0354F, -0.5F, 0.0F, 5.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0354F, -5.0F, -8.184F, 0.0F, -0.4648F, 0.0F));

		PartDefinition Helmet_r2 = head.addOrReplaceChild("Helmet_r2", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-5.0354F, -0.5F, 0.0F, 5.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0354F, -5.0F, -8.184F, 0.0F, 0.4648F, 0.0F));

		PartDefinition Helmet_r3 = head.addOrReplaceChild("Helmet_r3", CubeListBuilder.create().texOffs(23, 19).addBox(0.2F, -2.6856F, -2.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(23, 19).addBox(9.0F, -2.6856F, -2.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6F, -4.9144F, -3.9244F, -0.829F, 0.0F, 0.0F));

		PartDefinition Helmet_r4 = head.addOrReplaceChild("Helmet_r4", CubeListBuilder.create().texOffs(0, 5).addBox(-3.8F, -8.1F, -3.75F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.552F, -0.4648F, 0.0F));

		PartDefinition Helmet_r5 = head.addOrReplaceChild("Helmet_r5", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-3.2F, -8.1F, -3.75F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.552F, 0.4648F, 0.0F));

		PartDefinition Helmet_r6 = head.addOrReplaceChild("Helmet_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -4.931F, -0.1089F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9849F, -5.369F, -6.6221F, -0.7266F, -0.4648F, 0.0F));

		PartDefinition Helmet_r7 = head.addOrReplaceChild("Helmet_r7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.5F, -4.8762F, -0.1081F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9697F, -5.4238F, -6.5919F, -0.7266F, 0.4648F, 0.0F));

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
		
	}
}