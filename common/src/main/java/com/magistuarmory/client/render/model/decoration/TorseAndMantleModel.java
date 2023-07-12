// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings

package com.magistuarmory.client.render.model.decoration;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

@Environment(EnvType.CLIENT)
public class TorseAndMantleModel<T extends LivingEntity> extends ArmorDecorationModel<T>
{
	public TorseAndMantleModel(ModelPart modelpart)
	{
		super(modelpart);
	}

	public static LayerDefinition createLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, -7.9F, -3.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(1.2F))
				.texOffs(0, 0).addBox(-5.0F, -9.5F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.3F))
				.texOffs(32, 16).addBox(-4.0F, -7.5F, -3.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(1.4F))
				.texOffs(1, 32).addBox(-4.0F, -7.5F, -3.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(1.6F))
				.texOffs(1, 15).addBox(-4.0F, -7.5F, -3.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(1.8F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
		
		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	public ModelPart[] getParts()
	{
		return new ModelPart[] { this.head };
	}
}