package com.magistuarmory.client.render.model.armor;

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
public class MaximilianHelmetModel {
	
	public static ModelPart createModel() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
	    PartDefinition partdefinition = meshdefinition.getRoot();
	    PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -7.9F, -3.2F, 8.0F, 7.0F, 7.0F, new CubeDeformation(1.0F))
		.texOffs(38, 6).addBox(-4.0F, -7.9F, -3.7F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.97F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("Helmet_r1", CubeListBuilder.create().texOffs(0, 5).addBox(-3.6F, -7.2F, -3.75F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.552F, -0.4648F, 0.0F));
		head.addOrReplaceChild("Helmet_r2", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-3.4F, -7.2F, -3.75F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.552F, 0.4648F, 0.0F));
		head.addOrReplaceChild("Helmet_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-3.6F, -4.9F, -8.1F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.552F, -0.4648F, 0.0F));
		head.addOrReplaceChild("Helmet_r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.4F, -4.9F, -8.1F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.552F, 0.4648F, 0.0F));
	    partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
		
		return LayerDefinition.create(meshdefinition, 64, 32).bakeRoot();
	
	}
}
