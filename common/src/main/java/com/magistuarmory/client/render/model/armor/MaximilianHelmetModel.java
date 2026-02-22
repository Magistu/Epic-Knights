package com.magistuarmory.client.render.model.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

@Environment(EnvType.CLIENT)
public class MaximilianHelmetModel {
	
	public static LayerDefinition createLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
	    PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Helmet_r1 = head.addOrReplaceChild("Helmet_r1", CubeListBuilder.create().texOffs(0, 5).addBox(-3.6F, -7.2F, -3.75F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, 0.2F, 0.552F, -0.4648F, 0.0F));

		PartDefinition Helmet_r2 = head.addOrReplaceChild("Helmet_r2", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-3.4F, -7.2F, -3.75F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.1F, 0.2F, 0.552F, 0.4648F, 0.0F));

		PartDefinition Helmet_r3 = head.addOrReplaceChild("Helmet_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-3.6F, -4.9F, -8.1F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, 0.2F, -0.552F, -0.4648F, 0.0F));

		PartDefinition Helmet_r4 = head.addOrReplaceChild("Helmet_r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.4F, -4.9F, -8.1F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.1F, 0.2F, -0.552F, 0.4648F, 0.0F));

		PartDefinition Armet = head.addOrReplaceChild("Armet", CubeListBuilder.create().texOffs(32, 0).addBox(0.0F, 0.15F, 0.8F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.9F))
				.texOffs(38, 6).addBox(0.0F, 0.15F, 0.3F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.87F)), PartPose.offset(-4.0F, -8.0F, -4.0F));

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	
	}
}
