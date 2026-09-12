package com.magistuarmory.client.render.model.decoration;

import net.minecraft.client.model.animal.equine.HorseModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.animal.equine.AbstractHorse;

public class HorseArmorDecorationModel<T extends AbstractHorse> extends HorseModel
{
    ModelPart[] parts;
    
    public HorseArmorDecorationModel(ModelPart root)
    {
        super(root);
        this.parts = new ModelPart[] { this.body };
    }
    
    public ModelPart[] parts()
    {
        return this.parts;
    }
}
