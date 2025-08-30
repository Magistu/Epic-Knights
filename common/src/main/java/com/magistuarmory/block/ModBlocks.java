package com.magistuarmory.block;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.item.ModItemTier;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Properties;
import java.util.function.Supplier;

public class ModBlocks
{
	public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(EpicKnights.ID, Registries.BLOCK);

	public static RegistrySupplier<PaviseBlock> WOOD_PAVISE = BLOCKS.register("wood_pavise", () -> new PaviseBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.WOOD).ignitedByLava(), "wood_pavise", ModBlockEntityTypes.WOOD_PAVISE));
	public static RegistrySupplier<PaviseBlock> GOLD_PAVISE = BLOCKS.register("gold_pavise", () -> new PaviseBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.WOOD).ignitedByLava(), "gold_pavise", ModBlockEntityTypes.GOLD_PAVISE));
	public static RegistrySupplier<PaviseBlock> STONE_PAVISE = BLOCKS.register("stone_pavise", () -> new PaviseBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.WOOD).ignitedByLava(), "stone_pavise", ModBlockEntityTypes.STONE_PAVISE));
	public static RegistrySupplier<PaviseBlock> IRON_PAVISE = BLOCKS.register("iron_pavise", () -> new PaviseBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.WOOD).ignitedByLava(), "iron_pavise", ModBlockEntityTypes.IRON_PAVISE));
	public static RegistrySupplier<PaviseBlock> DIAMOND_PAVISE = BLOCKS.register("diamond_pavise", () -> new PaviseBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.WOOD).ignitedByLava(), "diamond_pavise", ModBlockEntityTypes.DIAMOND_PAVISE));
	public static RegistrySupplier<PaviseBlock> NETHERITE_PAVISE = BLOCKS.register("netherite_pavise", () -> new PaviseBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.WOOD).ignitedByLava(), "netherite_pavise", ModBlockEntityTypes.NETHERITE_PAVISE));
	public static RegistrySupplier<PaviseBlock> TIN_PAVISE = BLOCKS.register("tin_pavise", () -> new PaviseBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.WOOD).ignitedByLava(), "tin_pavise", ModBlockEntityTypes.TIN_PAVISE));
	public static RegistrySupplier<PaviseBlock> COPPER_PAVISE = BLOCKS.register("copper_pavise", () -> new PaviseBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.WOOD).ignitedByLava(), "copper_pavise", ModBlockEntityTypes.COPPER_PAVISE));
	public static RegistrySupplier<PaviseBlock> SILVER_PAVISE = BLOCKS.register("silver_pavise", () -> new PaviseBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.WOOD).ignitedByLava(), "silver_pavise", ModBlockEntityTypes.SILVER_PAVISE));
	public static RegistrySupplier<PaviseBlock> BRONZE_PAVISE = BLOCKS.register("bronze_pavise", () -> new PaviseBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.WOOD).ignitedByLava(), "bronze_pavise", ModBlockEntityTypes.BRONZE_PAVISE));
	public static RegistrySupplier<PaviseBlock> STEEL_PAVISE = BLOCKS.register("steel_pavise", () -> new PaviseBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().dynamicShape().noTerrainParticles().sound(SoundType.WOOD).ignitedByLava(), "steel_pavise", ModBlockEntityTypes.STEEL_PAVISE));
	
	public static RegistrySupplier<PaviseUpperCollisionBlock> PAVISE_UPPER_COLLISION = BLOCKS.register("pavise_upper_collision", PaviseUpperCollisionBlock::new);

	
	public static void init()
	{
		BLOCKS.register();
	}
	
	public static Supplier<PaviseBlock> getPaviseByMaterialName(ModItemTier material)
	{
		switch (material.getMaterialName())
		{
			case "wood" ->
			{
				return WOOD_PAVISE;
			}
			case "gold" ->
			{
				return GOLD_PAVISE;
			}
			case "stone" ->
			{
				return STONE_PAVISE;
			}
			case "iron" ->
			{
				return IRON_PAVISE;
			}
			case "diamond" ->
			{
				return DIAMOND_PAVISE;
			}
			case "netherite" ->
			{
				return NETHERITE_PAVISE;
			}
			case "tin" ->
			{
				return TIN_PAVISE;
			}
			case "copper" ->
			{
				return COPPER_PAVISE;
			}
			case "silver" ->
			{
				return SILVER_PAVISE;
			}
			case "bronze" ->
			{
				return BRONZE_PAVISE;
			}
			case "steel" ->
			{
				return STEEL_PAVISE;
			}
		}
		throw new IllegalArgumentException("unknown material " + material.getMaterialName());
	}
}
