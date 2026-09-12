package com.magistuarmory.neoforge.item;

import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.ShieldType;
import net.minecraft.resources.Identifier;


public class MedievalShieldItemNeoForge extends MedievalShieldItem
{
	public MedievalShieldItemNeoForge(String id, Identifier location, Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		super(id, location, properties, material, paintable, is3d, type);
	}
}
