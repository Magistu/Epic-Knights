package com.magistuarmory.client.render.model.decoration;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

@Environment(EnvType.CLIENT)
public abstract class ArmorDecorationModel<T extends LivingEntity> extends HumanoidModel<T>
{
    public ArmorDecorationModel(ModelPart modelpart)
    {
        super(modelpart);
    }

    public abstract ModelPart[] getParts();
}
