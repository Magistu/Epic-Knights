package com.magistuarmory.client.render.entity.layer;

import com.magistuarmory.client.render.model.ArmorDecorationModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.List;

@Environment(EnvType.CLIENT)
public class ArmorDecorationLayer<T extends LivingEntity, M extends HumanoidModel<T>, A extends ArmorDecorationModel<T>> extends RenderLayer<T, M> implements PatternLayer
{
   private static final String BASE_DIR = "textures/models/armor/";
   private final A model;
   private final ResourceLocation baseTexture;
   private final String name;
   private final String dir;

   public ArmorDecorationLayer(RenderLayerParent<T, M> parent, A model, ResourceLocation texture, String name)
   {
      super(parent);
      this.model = model;
      this.baseTexture = texture;
      this.name = name;
      this.dir = BASE_DIR + name + "/";
   }

   @Override
   public void render(PoseStack pose, MultiBufferSource buffer, int p, T entity, float f, float f2, float f3, float f4, float f5, float f6)
   {
      this.renderArmorPiece(pose, buffer, entity, EquipmentSlot.CHEST, p, this.getArmorDecorationModel(EquipmentSlot.CHEST));
      this.renderArmorPiece(pose, buffer, entity, EquipmentSlot.LEGS, p, this.getArmorDecorationModel(EquipmentSlot.LEGS));
      this.renderArmorPiece(pose, buffer, entity, EquipmentSlot.FEET, p, this.getArmorDecorationModel(EquipmentSlot.FEET));
      this.renderArmorPiece(pose, buffer, entity, EquipmentSlot.HEAD, p, this.getArmorDecorationModel(EquipmentSlot.HEAD));
   }

   private void renderArmorPiece(PoseStack pose, MultiBufferSource buffer, T entity, EquipmentSlot slot, int p, A model)
   {
      ItemStack itemstack = entity.getItemBySlot(slot);
      if (itemstack.getItem() instanceof ArmorItem armoritem && armoritem.getSlot() == slot)
      {
         this.getParentModel().copyPropertiesTo(model);
         this.setPartVisibility(model, slot);
         boolean flag1 = itemstack.hasFoil();

         if (itemstack.getTagElement("BlockEntityTag") != null)
         {
            List<Pair<BannerPattern, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(itemstack), BannerBlockEntity.getItemPatterns(itemstack));

            renderPatterns(pose, buffer, p, OverlayTexture.NO_OVERLAY, list, flag1, model);
         }
      }
   }

   protected void setPartVisibility(A model, EquipmentSlot slot)
   {
      model.setAllVisible(false);
      switch (slot) 
      {
         case HEAD -> {
            model.head.visible = true;
            model.hat.visible = true;
         }
         case CHEST -> {
            model.body.visible = true;
            model.rightArm.visible = true;
            model.leftArm.visible = true;
         }
         case LEGS, FEET -> {
            model.rightLeg.visible = true;
            model.leftLeg.visible = true;
         }
      }
   }

   private A getArmorDecorationModel(EquipmentSlot slot)
   {
      return this.model;
   }

   public ResourceLocation getBaseTexture()
   {
      return baseTexture;
   }

   public void renderPatterns(PoseStack pose, MultiBufferSource buffer, int p, int overlay, List<Pair<BannerPattern, DyeColor>> list, boolean hasfoil, A model)
   {
      this.renderPatterns(pose, buffer, p, overlay, list, hasfoil, model.getParts(), 1.0f, 1.0f, 1.0f, this.dir, this.getBaseTexture());
   }
}
