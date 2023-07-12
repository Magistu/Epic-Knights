package com.magistuarmory.block;

import com.google.common.collect.Lists;
import com.magistuarmory.EpicKnights;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.Nullable;
import java.util.List;


public class PaviseBlockEntity extends BlockEntity
{
    String shieldId = "wood_pavese";
    @Nullable
    private DyeColor baseColor;
    @Nullable
    private ListTag itemPatterns;
    private boolean enchanted = false;
    private CompoundTag stackCompound;
    @Nullable
    private List<Pair<BannerPattern, DyeColor>> patterns;

    public PaviseBlockEntity(BlockPos blockpos, BlockState blockstate)
    {
        super(ModBlockEntityTypes.PAVISE.get(), blockpos, blockstate);
    }

    @Nullable
    public static ListTag getItemPatterns(ItemStack stack)
    {
        ListTag listtag = null;
        CompoundTag compound = BlockItem.getBlockEntityData(stack);
        if (compound != null && compound.contains("Patterns", 9))
            listtag = compound.getList("Patterns", 10).copy();

        return listtag;
    }

    public void fromItem(ItemStack stack)
    {
        this.itemPatterns = getItemPatterns(stack);
        this.baseColor = ShieldItem.getColor(stack);
        this.stackCompound = stack.getTag();
        this.enchanted = stack.isEnchanted();
        this.patterns = null;
    }

    @Override
    protected void saveAdditional(CompoundTag compound)
    {
        super.saveAdditional(compound);

        compound.putString("ShieldId", this.shieldId);

        if (this.baseColor != null)
            compound.putInt("Base", this.baseColor.getId());

        compound.putBoolean("Enchanted", this.enchanted);

        if (this.stackCompound != null)
            compound.put("ItemStack", this.stackCompound);
        
        if (this.itemPatterns != null)
            compound.put("Patterns", this.itemPatterns);
    }
    
    public boolean hasFoil()
    {
        return this.enchanted;
    }

    public boolean isPainted()
    {
        return this.getBaseColor() != null;
    }

    public void load(CompoundTag compound)
    {
        super.load(compound);
        this.shieldId = compound.getString("ShieldId");
        if (compound.contains("Base"))
            this.baseColor = DyeColor.byId(compound.getInt("Base"));
        this.stackCompound = compound.getCompound("ItemStack");
        this.enchanted = compound.getBoolean("Enchanted");
        this.itemPatterns = compound.getList("Patterns", 10);
        this.patterns = null;
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag()
    {
        return this.saveWithoutMetadata();
    }

    public static int getPatternCount(ItemStack stack)
    {
        CompoundTag compound = BlockItem.getBlockEntityData(stack);
        return compound != null && compound.contains("Patterns") ? compound.getList("Patterns", 10).size() : 0;
    }

    public List<Pair<BannerPattern, DyeColor>> getPatterns()
    {
        if (this.patterns == null)
            this.patterns = createPatterns(this.baseColor, this.itemPatterns);

        return this.patterns;
    }

    public static List<Pair<BannerPattern, DyeColor>> createPatterns(DyeColor color, @Nullable ListTag listtag)
    {
        List<Pair<BannerPattern, DyeColor>> list = Lists.newArrayList();
        list.add(Pair.of(BannerPattern.BASE, color));
        if (listtag == null)
            return list;
        
        for(int i = 0; i < listtag.size(); ++i)
        {
            CompoundTag compound = listtag.getCompound(i);
            BannerPattern holder = BannerPattern.byHash(compound.getString("Pattern"));
            if (holder != null)
            {
                int j = compound.getInt("Color");
                list.add(Pair.of(holder, DyeColor.byId(j)));
            }
        }

        return list;
    }

    public static void removeLastPattern(ItemStack stack)
    {
        CompoundTag compound = BlockItem.getBlockEntityData(stack);
        if (compound != null && compound.contains("Patterns", 9))
        {
            ListTag listtag = compound.getList("Patterns", 10);
            if (listtag.isEmpty())
                return;
            
            listtag.remove(listtag.size() - 1);
            if (listtag.isEmpty())
                compound.remove("Patterns");

            BlockItem.setBlockEntityData(stack, ModBlockEntityTypes.PAVISE.get(), compound);
        }
    }

    public ItemStack getItem()
    {
        ItemStack stack = new ItemStack(Registry.ITEM.get(new ResourceLocation(EpicKnights.ID, this.shieldId)));
        stack.setTag(this.stackCompound.copy());
        return stack;
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
