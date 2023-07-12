package com.magistuarmory.client.render.model.decoration;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.animal.horse.AbstractHorse;

@Environment(EnvType.CLIENT)
public abstract class HorseArmorDecorationModel<T extends AbstractHorse> extends HorseModel<T>
{
    public HorseArmorDecorationModel(ModelPart modelpart)
    {
        super(modelpart);
    }

    public abstract ModelPart[] getParts();
}
