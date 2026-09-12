package com.magistuarmory.block;

import com.magistuarmory.EpicKnights;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.util.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ModBlockEntityTypes
{
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(EpicKnights.ID, Registries.BLOCK_ENTITY_TYPE);

    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> WOOD_PAVISE;
    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> GOLD_PAVISE;
    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> STONE_PAVISE;
    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> IRON_PAVISE;
    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> DIAMOND_PAVISE;
    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> NETHERITE_PAVISE;
    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> TIN_PAVISE;
    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> COPPER_PAVISE;
    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> SILVER_PAVISE;
    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> BRONZE_PAVISE;
    public static RegistrySupplier<BlockEntityType<PaviseBlockEntity>> STEEL_PAVISE;
    
    private static final Supplier<BlockEntityType<PaviseBlockEntity>> WOOD_PAVISE_BUILDER;
    private static final Supplier<BlockEntityType<PaviseBlockEntity>> GOLD_PAVISE_BUILDER;
    private static final Supplier<BlockEntityType<PaviseBlockEntity>> STONE_PAVISE_BUILDER;
    private static final Supplier<BlockEntityType<PaviseBlockEntity>> IRON_PAVISE_BUILDER;
    private static final Supplier<BlockEntityType<PaviseBlockEntity>> DIAMOND_PAVISE_BUILDER;
    private static final Supplier<BlockEntityType<PaviseBlockEntity>> NETHERITE_PAVISE_BUILDER;
    private static final Supplier<BlockEntityType<PaviseBlockEntity>> TIN_PAVISE_BUILDER;
    private static final Supplier<BlockEntityType<PaviseBlockEntity>> COPPER_PAVISE_BUILDER;
    private static final Supplier<BlockEntityType<PaviseBlockEntity>> SILVER_PAVISE_BUILDER;
    private static final Supplier<BlockEntityType<PaviseBlockEntity>> BRONZE_PAVISE_BUILDER;
    private static final Supplier<BlockEntityType<PaviseBlockEntity>> STEEL_PAVISE_BUILDER;

    static {

        WOOD_PAVISE_BUILDER = () -> createType((a, b) -> new PaviseBlockEntity(WOOD_PAVISE, a, b), ModBlocks.WOOD_PAVISE.get());
        GOLD_PAVISE_BUILDER = () -> createType((a, b) -> new PaviseBlockEntity(GOLD_PAVISE, a, b), ModBlocks.GOLD_PAVISE.get());
        STONE_PAVISE_BUILDER = () -> createType((a, b) -> new PaviseBlockEntity(STONE_PAVISE, a, b), ModBlocks.STONE_PAVISE.get());
        IRON_PAVISE_BUILDER = () -> createType((a, b) -> new PaviseBlockEntity(IRON_PAVISE, a, b), ModBlocks.IRON_PAVISE.get());
        DIAMOND_PAVISE_BUILDER = () -> createType((a, b) -> new PaviseBlockEntity(DIAMOND_PAVISE, a, b), ModBlocks.DIAMOND_PAVISE.get());
        NETHERITE_PAVISE_BUILDER = () -> createType((a, b) -> new PaviseBlockEntity(NETHERITE_PAVISE, a, b), ModBlocks.NETHERITE_PAVISE.get());
        TIN_PAVISE_BUILDER = () -> createType((a, b) -> new PaviseBlockEntity(TIN_PAVISE, a, b), ModBlocks.TIN_PAVISE.get());
        COPPER_PAVISE_BUILDER = () -> createType((a, b) -> new PaviseBlockEntity(COPPER_PAVISE, a, b), ModBlocks.COPPER_PAVISE.get());
        SILVER_PAVISE_BUILDER = () -> createType((a, b) -> new PaviseBlockEntity(SILVER_PAVISE, a, b), ModBlocks.SILVER_PAVISE.get());
        BRONZE_PAVISE_BUILDER = () -> createType((a, b) -> new PaviseBlockEntity(BRONZE_PAVISE, a, b), ModBlocks.BRONZE_PAVISE.get());
        STEEL_PAVISE_BUILDER = () -> createType((a, b) -> new PaviseBlockEntity(STEEL_PAVISE, a, b), ModBlocks.STEEL_PAVISE.get());

        WOOD_PAVISE = BLOCK_ENTITY_TYPES.register("wood_pavise", WOOD_PAVISE_BUILDER);
        GOLD_PAVISE = BLOCK_ENTITY_TYPES.register("gold_pavise", GOLD_PAVISE_BUILDER);
        STONE_PAVISE = BLOCK_ENTITY_TYPES.register("stone_pavise", STONE_PAVISE_BUILDER);
        IRON_PAVISE = BLOCK_ENTITY_TYPES.register("iron_pavise", IRON_PAVISE_BUILDER);
        DIAMOND_PAVISE = BLOCK_ENTITY_TYPES.register("diamond_pavise", DIAMOND_PAVISE_BUILDER);
        NETHERITE_PAVISE = BLOCK_ENTITY_TYPES.register("netherite_pavise", NETHERITE_PAVISE_BUILDER);
        TIN_PAVISE = BLOCK_ENTITY_TYPES.register("tin_pavise", TIN_PAVISE_BUILDER);
        COPPER_PAVISE = BLOCK_ENTITY_TYPES.register("copper_pavise", COPPER_PAVISE_BUILDER);
        SILVER_PAVISE = BLOCK_ENTITY_TYPES.register("silver_pavise", SILVER_PAVISE_BUILDER);
        BRONZE_PAVISE = BLOCK_ENTITY_TYPES.register("bronze_pavise", BRONZE_PAVISE_BUILDER);
        STEEL_PAVISE = BLOCK_ENTITY_TYPES.register("steel_pavise", STEEL_PAVISE_BUILDER);
    }
    
    @dev.architectury.injectables.annotations.ExpectPlatform
    public static BlockEntityType<PaviseBlockEntity> createType(java.util.function.BiFunction<net.minecraft.core.BlockPos, net.minecraft.world.level.block.state.BlockState, PaviseBlockEntity> factory, net.minecraft.world.level.block.Block block) {
        throw new AssertionError();
    }

    public static void init()
    {
        BLOCK_ENTITY_TYPES.register();
    }
}
