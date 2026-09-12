package com.magistuarmory.client.render.model.decoration;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.animal.equine.HorseModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.animal.equine.AbstractHorse;

@Environment(EnvType.CLIENT)
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
