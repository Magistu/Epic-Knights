package com.magistuarmory.neoforge.item;

import com.magistuarmory.block.PaviseBlock;
import com.magistuarmory.item.ModItemTier;
import com.magistuarmory.item.PaviseItem;
import com.magistuarmory.item.ShieldType;
import net.minecraft.resources.Identifier;

import java.util.function.Supplier;

public class PaviseItemNeoForge extends PaviseItem
{
	public PaviseItemNeoForge(String id, Identifier location, Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Supplier<PaviseBlock> block)
	{
		super(id, location, properties, material, paintable, is3d, type, block);
	}
}
