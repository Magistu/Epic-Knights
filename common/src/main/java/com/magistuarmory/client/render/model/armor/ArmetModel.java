package com.magistuarmory.client.render.model.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

@Environment(EnvType.CLIENT)
public class ArmetModel
{
	public static LayerDefinition createLayer() 
	{
	    MeshDefinition meshdefinition = new MeshDefinition();
	    PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(54, 7).addBox(-0.5F, 0.0F, -6.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.025F, -4.725F, -8.85F, 2.3518F, 0.0F, 0.0F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(56, 7).addBox(-0.5F, 0.0F, -6.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.025F, -8.675F, -4.45F, 0.7374F, 0.0F, 0.0F));

		PartDefinition Armet = head.addOrReplaceChild("Armet", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.15F, 0.8F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.9F))
				.texOffs(6, 6).addBox(0.0F, 0.15F, 0.3F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.87F)), PartPose.offset(-4.0F, -8.0F, -4.0F));

		PartDefinition VisorTopLeft = head.addOrReplaceChild("VisorTopLeft", CubeListBuilder.create().texOffs(47, 0).addBox(0.4F, 0.7992F, -2.4668F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -0.7285F, -0.6829F, 0.0F));

		PartDefinition VisorTopRight = head.addOrReplaceChild("VisorTopRight", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -0.7285F, 0.6374F, 0.0F));

		PartDefinition VisorBottomLeft = head.addOrReplaceChild("VisorBottomLeft", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, 0.6829F, -0.6829F, 0.0F));

		PartDefinition VisorBottomRight = head.addOrReplaceChild("VisorBottomRight", CubeListBuilder.create().texOffs(30, 0).addBox(-0.925F, 1.8276F, -2.9631F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, 0.6829F, 0.6829F, 0.0F));

		PartDefinition VisorTopRight2 = head.addOrReplaceChild("VisorTopRight2", CubeListBuilder.create().texOffs(47, 0).mirror().addBox(-7.4F, 0.7992F, -2.4668F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -8.0F, -4.0F, -0.7285F, 0.6829F, 0.0F));

		PartDefinition VisorBottomLeft2 = head.addOrReplaceChild("VisorBottomLeft2", CubeListBuilder.create().texOffs(30, 0).mirror().addBox(-6.075F, 1.8276F, -2.9631F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -8.0F, -4.0F, 0.6829F, -0.6829F, 0.0F));

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
}