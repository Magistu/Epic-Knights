package com.magistuarmory.client.render.entity.layer;

import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.client.render.model.decoration.ArmorDecorationModel;
import com.magistuarmory.client.render.model.decoration.ArmorDecorationModelSet;
import com.magistuarmory.client.render.model.decoration.SurcoatModel;
import com.magistuarmory.item.ArmorDecorationItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Holder;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.List;

import static com.magistuarmory.item.ArmorDecorationItem.createDecorations;
import static com.magistuarmory.item.ArmorDecorationItem.getDecorationTags;


@Environment(EnvType.CLIENT)
public class ArmorDecorationLayer<T extends LivingEntity, M extends HumanoidModel<T>> extends RenderLayer<T, M> implements ArmorPatternLayer
{
   private static final String ARMOR_DIR_PREFIX = "textures/models/armor/";
   private final ArmorDecorationModel<T> coatModel;
   private final String coatDirPrefix;
   private final ResourceLocation coatTexture;
   private final ArmorDecorationModelSet<T> decorationModels;

   public ArmorDecorationLayer(ArmorDecorationModelSet<T> decorationModels, RenderLayerParent<T, M> parent, EntityRendererProvider.Context context, ResourceLocation location)
   {
      super(parent);
      this.decorationModels = decorationModels;
      this.coatModel = new SurcoatModel<>(context.bakeLayer(ModModels.createDecorationLocation(location)));
      this.coatDirPrefix = this.getDirPrefix(location);
      this.coatTexture = this.getTexture(location);
   }

   public ResourceLocation getTexture(ResourceLocation location)
   {
      return getTexture(location, false);
   }

   public ResourceLocation getTexture(ResourceLocation location, boolean overlay)
   {
      return new ResourceLocation(location.getNamespace(), ARMOR_DIR_PREFIX + location.getPath() + (overlay ? "_overlay.png" : ".png"));
   }

   public String getDirPrefix(ResourceLocation location)
   {
      return ARMOR_DIR_PREFIX + location.getPath() + "/";
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
      if (itemstack.getItem() instanceof ArmorItem armoritem && armoritem.getEquipmentSlot() == slot)
      {
         if (itemstack.getTagElement("ArmorDecoration") != null)
         {
            for (ArmorDecorationItem.DecorationInfo info : createDecorations(getDecorationTags(itemstack)))
            {
               ResourceLocation location = info.location();
               ArmorDecorationModel<T> model = this.getArmorDecorationModel(location);
               if (model != null)
               {
                  this.getParentModel().copyPropertiesTo(model);
                  if (info.dyeable())
                  {
                     int j = info.color();
                     float r = (float) (j >> 16 & 255) / 255.0F;
                     float g = (float) (j >> 8 & 255) / 255.0F;
                     float b = (float) (j & 255) / 255.0F;
                     renderDecoration(pose, buffer, p, OverlayTexture.NO_OVERLAY, r, g, b, itemstack.hasFoil(), model.parts(), getTexture(location));
                     renderDecoration(pose, buffer, p, OverlayTexture.NO_OVERLAY, itemstack.hasFoil(), model.parts(), getTexture(location, true));
                  }
                  else
                  {
                     renderDecoration(pose, buffer, p, OverlayTexture.NO_OVERLAY, itemstack.hasFoil(), model.parts(), getTexture(location));
                  }
               }
            }
         }
         if (armoritem.getEquipmentSlot() == EquipmentSlot.CHEST && BlockItem.getBlockEntityData(itemstack) != null)
         {
            this.getParentModel().copyPropertiesTo(this.coatModel);
            renderDecoration(pose, buffer, p, OverlayTexture.NO_OVERLAY, itemstack.hasFoil(), this.coatModel.parts(), this.coatTexture);
            ListTag listtag = BannerBlockEntity.getItemPatterns(itemstack);
            List<Pair<Holder<BannerPattern>, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(itemstack), listtag);
            renderPatterns(pose, buffer, p, OverlayTexture.NO_OVERLAY, list, itemstack.hasFoil(), this.coatModel);
         }
      }
   }

   public ArmorDecorationModel<T> getArmorDecorationModel(ResourceLocation location)
   {
      return this.decorationModels.get(location);
   }

   public void renderPatterns(PoseStack pose, MultiBufferSource buffer, int p, int overlay, List<Pair<Holder<BannerPattern>, DyeColor>> list, boolean hasfoil, ArmorDecorationModel<T> model)
   {
      this.renderPatterns(pose, buffer, p, overlay, list, hasfoil, model.parts(), 1.0f, 1.0f, 1.0f);
   }

   public void renderDecoration(PoseStack pose, MultiBufferSource buffer, int p, int overlay, boolean hasfoil, ModelPart[] modelparts, ResourceLocation texture)
   {
      renderDecoration(pose, buffer, p, overlay, 1.0f, 1.0f, 1.0f, hasfoil, modelparts, texture);
   }

   public void renderDecoration(PoseStack pose, MultiBufferSource buffer, int p, int overlay, float r, float g, float b, boolean hasfoil, ModelPart[] modelparts, ResourceLocation texture)
   {
      VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.entityCutoutNoCull(texture), false, hasfoil);

      for (ModelPart part : modelparts)
         part.render(pose, vertexconsumer, p, overlay, r, g, b, 1.0F);
   }

   @Override
   public ResourceLocation getBaseTexture()
   {
      return this.coatTexture;
   }

   @Override
   public ResourceLocation getPatternTexture(ResourceLocation patternlocation)
   {
      return new ResourceLocation(this.coatTexture.getNamespace(), this.coatDirPrefix + patternlocation.getPath() + ".png");
   }
}
