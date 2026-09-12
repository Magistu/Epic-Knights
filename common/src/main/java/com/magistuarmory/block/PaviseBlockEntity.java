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
    String shieldId = "";
    @Nullable
    private DyeColor baseColor;
    private BannerPatternLayers patterns;
    private boolean enchanted = false;
    private ItemStack storedStack = ItemStack.EMPTY;

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
        this.patterns = stack.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY);
        this.storedStack = stack.copyWithCount(1);
        this.setChanged();
    }

    @Override
    protected void saveAdditional(net.minecraft.world.level.storage.ValueOutput output) {
        super.saveAdditional(output);
        output.putString("ShieldId", shieldId);
        if (baseColor != null) output.putInt("Base", baseColor.getId());
        output.putBoolean("Enchanted", enchanted);
        output.store("ItemStack", ItemStack.OPTIONAL_CODEC, storedStack);
        output.store("patterns", BannerPatternLayers.CODEC, patterns);
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
    protected void loadAdditional(net.minecraft.world.level.storage.ValueInput input) {
        super.loadAdditional(input);
        shieldId = input.getStringOr("ShieldId", "");
        baseColor = input.getInt("Base").map(DyeColor::byId).orElse(null);
        enchanted = input.getBooleanOr("Enchanted", false);
        storedStack = input.read("ItemStack", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
        patterns = input.read("patterns", BannerPatternLayers.CODEC).orElse(BannerPatternLayers.EMPTY);
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
        return storedStack.copy();
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
