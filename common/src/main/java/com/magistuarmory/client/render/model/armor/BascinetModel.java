package com.magistuarmory.client.render.model.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

@Environment(EnvType.CLIENT)
public class BascinetModel
{
	
	public static ModelPart createModel() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.95F, -3.2F, 8.0F, 7.0F, 7.0F, new CubeDeformation(1.0F))
				.texOffs(6, 6).addBox(-4.0F, -7.95F, -3.7F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.97F)), PartPose.offset(0.0F, 1.0F, 0.0F));
		head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(34, 0).addBox(-4.0F, 0.05F, -6.0F, 8.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -4.7F, 0.5672F, 0.0F, 0.0F));
		head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(36, 8).addBox(-4.0F, -0.078F, -1.5337F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.872F, -7.8663F, -0.2618F, 0.0F, 0.0F));
		head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 14).addBox(-4.0F, 0.85F, -2.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -5.5F, 0.7854F, 0.0F, 0.0F));
		head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(50, 21).addBox(-0.4F, -1.45F, -6.3F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -3.5F, -5.0F, 0.0F, 0.6615F, 0.0F));
		head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(50, 21).mirror().addBox(-5.95F, -1.45F, -1.37F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -3.5F, -5.0F, 0.0F, -0.6615F, 0.0F));
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);

		return LayerDefinition.create(meshdefinition, 64, 32).bakeRoot();
		
	}
}