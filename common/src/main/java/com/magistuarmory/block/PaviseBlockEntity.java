package com.magistuarmory.block;

import com.magistuarmory.item.PaviseItem;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;


public class PaviseBlockEntity extends BlockEntity
{
    String shieldId;
    @Nullable
    private DyeColor baseColor;
    private BannerPatternLayers patterns;
    private boolean enchanted = false;
    private CompoundTag stackCompound;

    public PaviseBlockEntity(Supplier<BlockEntityType<PaviseBlockEntity>> type, BlockPos blockpos, BlockState blockstate)
    {
        super(type.get(), blockpos, blockstate);
        this.patterns = BannerPatternLayers.EMPTY;
    }
    
    public BannerPatternLayers getPatterns()
    {
        return this.patterns;
    }

    public void fromItem(ItemStack stack)
    {
        if (this.getLevel() == null || this.getLevel().isClientSide())
            return;
        Item item = stack.getItem();
        if (!(item instanceof PaviseItem paviseitem))
            return;
        ItemEnchantments enchantments = stack.get(DataComponents.ENCHANTMENTS);
        this.enchanted = enchantments != null && !enchantments.isEmpty();
        this.shieldId = paviseitem.getId();
        this.baseColor = stack.get(DataComponents.BASE_COLOR);
        this.patterns = stack.get(DataComponents.BANNER_PATTERNS);
        this.stackCompound = (CompoundTag) stack.save(this.getLevel().registryAccess());
        this.setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider)
    {
        super.saveAdditional(compound, provider);

        compound.putString("ShieldId", this.shieldId);

        if (this.baseColor != null)
            compound.putInt("Base", this.baseColor.getId());

        compound.putBoolean("Enchanted", this.enchanted);

        if (this.stackCompound != null)
            compound.put("ItemStack", this.stackCompound);

        if (this.patterns != null)
            compound.put("patterns", BannerPatternLayers.CODEC.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), this.patterns).getOrThrow());
    }
    
    public boolean hasFoil()
    {
        return this.enchanted;
    }

    public boolean isPainted()
    {
        return this.getBaseColor() != null;
    }

    @Override
    public void loadAdditional(CompoundTag compound, HolderLookup.Provider provider)
    {
        super.loadAdditional(compound, provider);
        this.shieldId = compound.getString("ShieldId");
        if (compound.contains("Base"))
            this.baseColor = DyeColor.byId(compound.getInt("Base"));
        this.stackCompound = compound.getCompound("ItemStack");
        this.enchanted = compound.getBoolean("Enchanted");

        if (compound.contains("patterns")) {
            BannerPatternLayers.CODEC.parse(provider.createSerializationContext(NbtOps.INSTANCE), compound.get("patterns")).resultOrPartial(string -> {
            }).ifPresent(patterns -> this.patterns = patterns);
        }
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.Provider provider)
    {
        return this.saveWithoutMetadata(provider);
    }

    public ItemStack getStack()
    {
        if (this.getLevel() == null)
            return ItemStack.EMPTY;
        return ItemStack.parse(this.getLevel().registryAccess(), this.stackCompound).orElse(ItemStack.EMPTY);
    }

    public DyeColor getBaseColor()
    {
        return this.baseColor;
    }

    public String getShieldId()
    {
        return this.shieldId;
    }
}
