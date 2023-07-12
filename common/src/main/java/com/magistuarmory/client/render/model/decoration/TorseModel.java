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
public class TorseModel<T extends LivingEntity> extends ArmorDecorationModel<T>
{
	public TorseModel(ModelPart modelpart)
	{
		super(modelpart);
	}

	public static LayerDefinition createLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -9.5F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.35F))
				.texOffs(0, 51).addBox(-2.0F, -9.0F, 5.15F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
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