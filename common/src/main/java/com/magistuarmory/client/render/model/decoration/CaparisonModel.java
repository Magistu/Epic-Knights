package com.magistuarmory.client.render.model.decoration;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.animal.horse.AbstractHorse;

@Environment(EnvType.CLIENT)
public class CaparisonModel<T extends AbstractHorse> extends HorseArmorDecorationModel<T>
{

    public CaparisonModel(ModelPart modelpart)
    {
        super(modelpart);
    }

    public static LayerDefinition createLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -8.0F, -17.0F, 10.0F, 18.0F, 22.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 11.0F, 5.0F));
	    partdefinition1.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition1.addOrReplaceChild("saddle", CubeListBuilder.create(), PartPose.ZERO);
        PartDefinition partdefinition2 = partdefinition.addOrReplaceChild("head_parts", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition2.addOrReplaceChild("left_saddle_mouth", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition2.addOrReplaceChild("right_saddle_mouth", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition2.addOrReplaceChild("left_saddle_line", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition2.addOrReplaceChild("right_saddle_line", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition2.addOrReplaceChild("head_saddle", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition2.addOrReplaceChild("mouth_saddle_wrap", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_hind_baby_leg", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("left_hind_baby_leg", CubeListBuilder.create(), PartPose.ZERO);
	    partdefinition.addOrReplaceChild("right_front_baby_leg", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("left_front_baby_leg", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition1.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.ZERO);

        return LayerDefinition.create(meshdefinition, 64, 64);
	}

    @Override
    public ModelPart[] getParts()
    {
        return new ModelPart[] { body };
    }
}
