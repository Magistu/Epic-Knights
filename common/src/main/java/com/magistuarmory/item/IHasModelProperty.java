package com.magistuarmory.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public interface IHasModelProperty 
{
	@Environment(EnvType.CLIENT)
	void registerModelProperty();
}
