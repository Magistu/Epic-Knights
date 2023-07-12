package com.magistuarmory.block;

import com.magistuarmory.EpicKnights;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;

public class ModBlocks
{
	public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(EpicKnights.ID, Registry.BLOCK_REGISTRY);

	public static RegistrySupplier<PaviseBlock> PAVISE = BLOCKS.register("pavise", PaviseBlock::new);
	public static RegistrySupplier<PaviseUpperCollisionBlock> PAVISE_UPPER_COLLISION = BLOCKS.register("pavise_upper_collision", PaviseUpperCollisionBlock::new);

	public static void init()
	{
		BLOCKS.register();
	}
}
