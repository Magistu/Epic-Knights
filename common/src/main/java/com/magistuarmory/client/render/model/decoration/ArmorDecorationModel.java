package com.magistuarmory.client.render.model.decoration;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class ArmorDecorationModel<T extends net.minecraft.client.renderer.entity.state.HumanoidRenderState> extends HumanoidModel<T>
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
