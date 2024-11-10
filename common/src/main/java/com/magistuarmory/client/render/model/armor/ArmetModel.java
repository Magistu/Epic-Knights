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
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
		head.addOrReplaceChild("Armet", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.05F, 0.8F, 8.0F, 7.0F, 7.0F, new CubeDeformation(1.0F)).texOffs(6, 6).addBox(0.0F, 0.05F, 0.3F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.97F)), PartPose.offset(-4.0F, -8.0F, -4.0F));
		head.addOrReplaceChild("VisorTopLeft", CubeListBuilder.create().texOffs(47, 0).addBox(0.4F, 0.65F, -2.6F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -0.7285F, -0.6829F, 0.0F));
		head.addOrReplaceChild("VisorTopRight", CubeListBuilder.create().texOffs(47, 0).mirror().addBox(-1.1F, -2.6F, 1.1F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -0.7285F, 0.6374F, 0.0F));
		head.addOrReplaceChild("VisorBottomLeft", CubeListBuilder.create().texOffs(30, 0).mirror().addBox(0.15F, -1.5F, -6.9F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, 0.6829F, -0.6829F, 0.0F));
		head.addOrReplaceChild("VisorBottomRight", CubeListBuilder.create().texOffs(30, 0).addBox(-0.95F, 1.75F, -2.9F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, 0.6829F, 0.6829F, 0.0F));
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 64, 32);
	}
}