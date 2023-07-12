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
public class HornsModel<T extends LivingEntity> extends ArmorDecorationModel<T>
{
	public HornsModel(ModelPart modelpart)
	{
		super(modelpart);
	}

	public static LayerDefinition createLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
	    PartDefinition partdefinition = meshdefinition.getRoot();
	    partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	public ModelPart[] getParts()
	{
		return new ModelPart[] { head };
	}
}