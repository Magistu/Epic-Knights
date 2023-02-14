package com.magistuarmory.client.render.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

@Environment(EnvType.CLIENT)
public class StechhelmModel {
	
	public static ModelPart createModel() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
	    PartDefinition partdefinition = meshdefinition.getRoot();
	    PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 0).addBox(-4.0F, -7.5F, -3.2F, 8.0F, 7.0F, 7.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("Helmet_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-10.001F, -4.2F, -2.46F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, -0.4363F, 1.5708F));
		head.addOrReplaceChild("Helmet_r2", CubeListBuilder.create().texOffs(0, 12).addBox(-10.0F, -4.2F, -4.54F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.0944F, -0.4363F, 1.5708F));
		head.addOrReplaceChild("Helmet_r3", CubeListBuilder.create().texOffs(0, 23).addBox(-4.0F, -9.3F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("Helmet_r4", CubeListBuilder.create().texOffs(54, 8).mirror().addBox(-9.96F, -4.16F, 4.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.03F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, -0.4363F, 1.5708F));
		head.addOrReplaceChild("Helmet_r5", CubeListBuilder.create().texOffs(56, 8).addBox(-9.96F, -4.16F, -4.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.03F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.0944F, -0.4363F, 1.5708F));
	    partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
		
		return LayerDefinition.create(meshdefinition, 64, 32).bakeRoot();
	
	}
}
