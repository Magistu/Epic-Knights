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
public class SalletModel {
	
	public static ModelPart createModel() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
	    PartDefinition partdefinition = meshdefinition.getRoot();
	    PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.1F, -4.2F, 8.0F, 7.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offset(-4.0F, -8.0F, -4.0F));
	    partdefinition1.addOrReplaceChild("helmet_r1", CubeListBuilder.create().texOffs(39, 5).addBox(-3.3F, -9.5F, -1.6F, 1.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -3.0F, 0.0F, 0.2618F, 1.5708F));
	    partdefinition1.addOrReplaceChild("helmet_r2", CubeListBuilder.create().texOffs(0, 18).addBox(-9.3F, 1.6F, 1.67F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, -1.789F, 0.1309F, 1.5708F));
	    partdefinition1.addOrReplaceChild("helmet_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-9.3F, 2.9F, -1.806F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3526F, 0.1309F, 1.5708F));
	    partdefinition1.addOrReplaceChild("helmet_r4", CubeListBuilder.create().texOffs(28, 18).addBox(-2.501F, -4.7F, -6.6F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -2.0071F, 0.2618F, 1.5708F));
	    partdefinition1.addOrReplaceChild("helmet_r5", CubeListBuilder.create().texOffs(28, 18).addBox(-2.5F, -6.4F, -3.01F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1345F, 0.2618F, 1.5708F));
	    partdefinition1.addOrReplaceChild("helmet_r6", CubeListBuilder.create().texOffs(45, 15).addBox(-4.7F, -2.6F, -4.7F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
	    partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
	    
		return LayerDefinition.create(meshdefinition, 64, 32).bakeRoot();
	
	}
}
