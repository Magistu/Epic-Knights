package com.magistuarmory.client.render.model.decoration;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

@Environment(EnvType.CLIENT)
public class ArmorDecorationModel<T extends LivingEntity> extends HumanoidModel<T>
{
    ModelPart[] parts;
    
    public ArmorDecorationModel(ModelPart root)
    {
        super(root);
        this.parts = new ModelPart[] { this.head, this.body, this.rightArm, this.leftArm };
    }

    public ModelPart[] parts()
    {
        return this.parts;
    }
}
