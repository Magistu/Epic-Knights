package com.magistuarmory.client.render.model.decoration;// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

@Environment(EnvType.CLIENT)
public class HoodModel<T extends LivingEntity> extends ArmorDecorationModel<T>
{
	public HoodModel(ModelPart modelpart)
	{
		super(modelpart);
	}

	public static LayerDefinition createLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
	    PartDefinition partdefinition = meshdefinition.getRoot();
	    partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -1.0F, -3.0F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.31F)).texOffs(1, 36).addBox(-4.0F, -1.1F, -1.75F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.41F)), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, -3.0F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -3.0F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
		
		return LayerDefinition.create(meshdefinition, 32, 64);
	}

	public ModelPart[] getParts()
	{
		return new ModelPart[] { body, leftArm, rightArm };
	}
}