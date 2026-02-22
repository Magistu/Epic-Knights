package com.magistuarmory.client.render.model.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

@Environment(EnvType.CLIENT)
public class StechhelmModel
{
	public static LayerDefinition createLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 0).addBox(-4.0F, -7.7F, -3.2F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.9F))
				.texOffs(40, 6).addBox(-4.0F, -7.65F, -3.7F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.87F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Helmet_r1 = head.addOrReplaceChild("Helmet_r1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, -0.4363F, 1.5708F));

		PartDefinition Helmet_r1_r1 = Helmet_r1.addOrReplaceChild("Helmet_r1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.7779F, -2.9347F, -1.8449F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1487F, -1.282F, -0.7257F, -0.0278F, -0.0436F, 0.0756F));

		PartDefinition Helmet_r2 = head.addOrReplaceChild("Helmet_r2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.0944F, -0.4363F, 1.5708F));

		PartDefinition Helmet_r2_r1 = Helmet_r2.addOrReplaceChild("Helmet_r2_r1", CubeListBuilder.create().texOffs(0, 12).addBox(-3.7769F, -2.9332F, -5.1559F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1487F, -1.282F, 0.7507F, 0.0453F, 0.0436F, 0.0756F));

		PartDefinition Helmet_r3 = head.addOrReplaceChild("Helmet_r3", CubeListBuilder.create().texOffs(0, 23).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	
	}
}
