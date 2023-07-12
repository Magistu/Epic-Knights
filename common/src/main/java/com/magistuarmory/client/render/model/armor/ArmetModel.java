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
public class ArmetModel
{
	public static ModelPart createModel() 
	{
	    MeshDefinition meshdefinition = new MeshDefinition();
	    PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
		head.addOrReplaceChild("Armet", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.05F, 0.8F, 8.0F, 7.0F, 7.0F, new CubeDeformation(1.0F)).texOffs(6, 6).addBox(0.0F, 0.05F, 0.3F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.97F)), PartPose.offset(-4.0F, -8.0F, -4.0F));
		head.addOrReplaceChild("VisorTopLeft", CubeListBuilder.create().texOffs(47, 0).addBox(0.4F, 0.65F, -2.6F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -0.7285F, -0.6829F, 0.0F));
		head.addOrReplaceChild("VisorTopRight", CubeListBuilder.create().texOffs(47, 0).mirror().addBox(-1.1F, -2.6F, 1.1F, 7.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -0.7285F, 0.6374F, 0.0F));
		head.addOrReplaceChild("VisorBottomLeft", CubeListBuilder.create().texOffs(30, 0).mirror().addBox(0.15F, -1.5F, -6.9F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, 0.6829F, -0.6829F, 0.0F));
		head.addOrReplaceChild("VisorBottomRight", CubeListBuilder.create().texOffs(30, 0).addBox(-0.95F, 1.75F, -2.9F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, 0.6829F, 0.6829F, 0.0F));
		head.addOrReplaceChild("Plume4", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(4.2F, -12.6F, 6.8F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -1.0016F, -0.2731F, 1.0016F));
		head.addOrReplaceChild("Plume12", CubeListBuilder.create().texOffs(0, 23).addBox(3.7F, 5.9F, 8.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, 0.8652F, -0.1367F, -0.5918F));
		head.addOrReplaceChild("Plume7", CubeListBuilder.create().texOffs(12, 25).mirror().addBox(-5.7F, -16.8F, 3.4F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -1.0016F, 0.1367F, 2.4586F));
		head.addOrReplaceChild("Plume21", CubeListBuilder.create().texOffs(12, 25).mirror().addBox(-2.9F, -14.8F, 2.8F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -1.3203F, 0.6829F, 0.0F));
		head.addOrReplaceChild("Plume1", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(2.5F, -6.8F, 9.7F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -0.3643F, 0.0F, 0.0F));
		head.addOrReplaceChild("Plume0", CubeListBuilder.create().texOffs(24, 17).addBox(1.1F, -11.9F, 3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -1.4114F, 0.0911F, -0.6829F));
		head.addOrReplaceChild("Plume2", CubeListBuilder.create().texOffs(12, 25).mirror().addBox(-0.6F, -15.6F, 2.7F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -1.1383F, -0.0911F, 1.2748F));
		head.addOrReplaceChild("Plume11", CubeListBuilder.create().texOffs(0, 23).addBox(2.5F, 4.5F, 12.1F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, 0.3643F, 0.0F, 0.0F));
		head.addOrReplaceChild("Plume27", CubeListBuilder.create().texOffs(12, 25).mirror().addBox(-0.6F, -14.6F, 5.2F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -0.9561F, 0.3643F, -0.1367F));
		head.addOrReplaceChild("Plume8", CubeListBuilder.create().texOffs(12, 25).mirror().addBox(-1.5F, -14.6F, 3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -1.5026F, -0.2276F, -0.9561F));
		head.addOrReplaceChild("Plume28", CubeListBuilder.create().texOffs(0, 23).addBox(2.3F, 5.7F, 7.2F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, 0.4098F, 0.182F, -1.4114F));
		head.addOrReplaceChild("Plume19", CubeListBuilder.create().texOffs(12, 25).mirror().addBox(-1.5F, -15.4F, 0.3F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -1.5026F, 0.4554F, 0.3643F));
		head.addOrReplaceChild("Plume5", CubeListBuilder.create().texOffs(12, 25).mirror().addBox(-0.6F, -15.5F, 5.2F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -0.8652F, 0.1367F, 0.4554F));
		head.addOrReplaceChild("Plume14", CubeListBuilder.create().texOffs(0, 23).addBox(6.6F, 1.7F, 6.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, 0.5463F, -0.5009F, -1.457F));
		head.addOrReplaceChild("Plume22", CubeListBuilder.create().texOffs(0, 23).addBox(-7.1F, 2.3F, 2.7F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -0.0911F, 0.6829F, -2.6407F));
		head.addOrReplaceChild("Plume17", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(3.4F, 5.4F, 2.1F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, 1.639F, -0.4554F, 0.2731F));
		head.addOrReplaceChild("Plume24", CubeListBuilder.create().texOffs(0, 23).addBox(-1.4F, 4.3F, 12.6F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, 0.3643F, 0.0456F, 0.0911F));
		head.addOrReplaceChild("Plume13", CubeListBuilder.create().texOffs(12, 17).mirror().addBox(-2.2F, -16.7F, 1.3F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -4.0F, -1.9124F, 0.0911F, -0.4554F));
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 64, 32).bakeRoot();
	}
}