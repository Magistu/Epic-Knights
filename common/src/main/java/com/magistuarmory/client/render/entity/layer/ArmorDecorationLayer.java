package com.magistuarmory.client.render.entity.layer;

import com.google.common.collect.Lists;
import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.render.model.decoration.ArmorDecorationModel;
import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.client.render.model.decoration.SurcoatModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;
import org.jetbrains.annotations.Nullable;
import java.util.List;


@Environment(EnvType.CLIENT)
public class ArmorDecorationLayer<T extends LivingEntity, M extends HumanoidModel<T>> extends RenderLayer<T, M> implements PatternLayer
{
   private static final String BASE_DIR = "textures/models/armor/";
   private final Models.ArmorDecorations<T> armorDecorations;
   private final ArmorDecorationModel<T> surcoatModel;
   private final String surcoatDirPrefix;
   private final ResourceLocation surcoatBaseTexture;

   public ArmorDecorationLayer(RenderLayerParent<T, M> parent)
   {
      super(parent);
      this.armorDecorations = new Models.ArmorDecorations<>();
      this.surcoatModel = new SurcoatModel<>(SurcoatModel.createLayer().bakeRoot());
      this.surcoatDirPrefix = this.getDirPrefix("surcoat");
      this.surcoatBaseTexture = this.getTexture("surcoat");
   }

   public ResourceLocation getTexture(String name)
   {
      return getTexture(name, false);
   }
   
   public ResourceLocation getTexture(String name, boolean overlay)
   {
      return new ResourceLocation(EpicKnights.ID, "textures/models/armor/" + name + (overlay ? "_overlay.png" : ".png"));
   }

   public String getDirPrefix(String name)
   {
      return BASE_DIR + name + "/";
   }

   @Override
   public void render(PoseStack pose, MultiBufferSource buffer, int p, T entity, float f, float f2, float f3, float f4, float f5, float f6)
   {
      this.renderPiece(pose, buffer, entity, EquipmentSlot.CHEST, p);
      this.renderPiece(pose, buffer, entity, EquipmentSlot.LEGS, p);
      this.renderPiece(pose, buffer, entity, EquipmentSlot.FEET, p);
      this.renderPiece(pose, buffer, entity, EquipmentSlot.HEAD, p);
   }

   private void renderPiece(PoseStack pose, MultiBufferSource buffer, T entity, EquipmentSlot slot, int p)
   {
      ItemStack itemstack = entity.getItemBySlot(slot);
      if (itemstack.getItem() instanceof ArmorItem armoritem && armoritem.getSlot() == slot)
      {
         if (itemstack.getTagElement("ArmorDecoration") != null)
         {
            for (DecorationInfo info : createDecorations(getItemArmorDecorations(itemstack)))
            {
               String name = info.name();
               ArmorDecorationModel<T> model = this.getArmorDecorationModel(name);
               this.getParentModel().copyPropertiesTo(model);
               if (info.dyeable())
               {
                  int j = info.color();
                  float r = (float) (j >> 16 & 255) / 255.0F;
                  float g = (float) (j >> 8 & 255) / 255.0F;
                  float b = (float) (j & 255) / 255.0F;
                  renderDyeableDecoration(pose, buffer, p, OverlayTexture.NO_OVERLAY, r, g, b, itemstack.hasFoil(), model.getParts(), getTexture(name));
                  renderDyeableDecoration(pose, buffer, p, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, itemstack.hasFoil(), model.getParts(), getTexture(name, true));
               }
               else
               {
                  renderDyeableDecoration(pose, buffer, p, OverlayTexture.NO_OVERLAY, itemstack.hasFoil(), model.getParts(), getTexture(name));
               }
            }
         }
         if (BlockItem.getBlockEntityData(itemstack) != null)
         {
            this.getParentModel().copyPropertiesTo(this.surcoatModel);
            ListTag listtag = BannerBlockEntity.getItemPatterns(itemstack);
            List<Pair<BannerPattern, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(itemstack), listtag);
            renderPatterns(pose, buffer, p, OverlayTexture.NO_OVERLAY, list, itemstack.hasFoil(), this.surcoatModel);
         }
      }
   }
   
   public record DecorationInfo(String name, boolean dyeable, int color) {}

   public static List<DecorationInfo> createDecorations(@Nullable ListTag listtag)
   {
      List<DecorationInfo> list = Lists.newArrayList();
      if (listtag != null)
      {
         for (int i = 0; i < listtag.size(); ++i)
         {
            CompoundTag tag = listtag.getCompound(i);
            String name = tag.getString("name");
            boolean dyeable = tag.getBoolean("dyeable");
            int j = tag.getInt("color");
            list.add(new DecorationInfo(name, dyeable, j));
         }
      }

      return list;
   }

   @Nullable
   public static ListTag getItemArmorDecorations(ItemStack itemstack)
   {
      ListTag listtag = null;
      CompoundTag tag = itemstack.getTagElement("ArmorDecoration");
      if (tag.contains("Items", 9))
         listtag = tag.getList("Items", 10).copy();

      return listtag;
   }

   private ArmorDecorationModel<T> getArmorDecorationModel(String name)
   {
      return this.armorDecorations.getModelByName(name);
   }

   public void renderPatterns(PoseStack pose, MultiBufferSource buffer, int p, int overlay, List<Pair<BannerPattern, DyeColor>> list, boolean hasfoil, ArmorDecorationModel<T> model)
   {
      this.renderPatterns(pose, buffer, p, overlay, list, hasfoil, model.getParts(), 1.0f, 1.0f, 1.0f, this.surcoatDirPrefix, this.surcoatBaseTexture);
   }

   public void renderDyeableDecoration(PoseStack pose, MultiBufferSource buffer, int p, int overlay, boolean hasfoil, ModelPart[] modelparts, ResourceLocation texture)
   {
      renderDyeableDecoration(pose, buffer, p, overlay, 1.0f, 1.0f, 1.0f, hasfoil, modelparts, texture);
   }
   
   public void renderDyeableDecoration(PoseStack pose, MultiBufferSource buffer, int p, int overlay, float r, float g, float b, boolean hasfoil, ModelPart[] modelparts, ResourceLocation texture)
   {
      VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.entityCutoutNoCull(texture), false, hasfoil);
      
      for (ModelPart part : modelparts)
         part.render(pose, vertexconsumer, p, overlay, r, g, b, 1.0F);
   }
}
