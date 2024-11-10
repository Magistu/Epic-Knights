package com.magistuarmory.item;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.entity.LivingEntity;

public interface IHasModelProperty 
{
	@Environment(EnvType.CLIENT)
	void registerModelProperty();
}
