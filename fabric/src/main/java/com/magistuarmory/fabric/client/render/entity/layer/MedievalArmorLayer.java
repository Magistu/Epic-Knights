package com.magistuarmory.fabric.client.render.entity.layer;

import com.google.common.collect.Maps;
import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.item.armor.MedievalArmorItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Map;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class MedievalArmorLayer implements ArmorRenderer
{
   private static final Map<String, ResourceLocation> ARMOR_LOCATION_CACHE = Maps.newHashMap();
   
   @Override
   public void render(PoseStack pose, MultiBufferSource buffer, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int i, HumanoidModel<LivingEntity> contextmodel)
   {
      if (stack.getItem() instanceof MedievalArmorItem armor) {
         if (armor.getSlot() == slot)
         {
            HumanoidModel<? extends LivingEntity> model = armor.getArmorModel(slot, getVanillaArmorModel(slot));
            ((HumanoidModel)contextmodel).copyPropertiesTo(model);
            this.setPartVisibility(model, slot);
            boolean bl = this.usesInnerModel(slot);
            boolean bl2 = stack.hasFoil();
            if (armor instanceof DyeableLeatherItem) 
            {
               int j = ((DyeableLeatherItem)armor).getColor(stack);
               float f = (float)(j >> 16 & 255) / 255.0F;
               float g = (float)(j >> 8 & 255) / 255.0F;
               float h = (float)(j & 255) / 255.0F;
               this.renderModel(pose, buffer, i, armor, bl2, model, bl, f, g, h, null);
               this.renderModel(pose, buffer, i, armor, bl2, model, bl, 1.0F, 1.0F, 1.0F, "overlay");
            } 
            else 
            {
               this.renderModel(pose, buffer, i, armor, bl2, model, bl, 1.0F, 1.0F, 1.0F, null);
            }
         }
      }
   }

   protected void setPartVisibility(HumanoidModel<? extends LivingEntity> model, EquipmentSlot slot) {
      model.setAllVisible(false);
      switch(slot) {
         case HEAD:
            model.head.visible = true;
            model.hat.visible = true;
            break;
         case CHEST:
            model.body.visible = true;
            model.rightArm.visible = true;
            model.leftArm.visible = true;
            break;
         case LEGS:
            model.body.visible = true;
            model.rightLeg.visible = true;
            model.leftLeg.visible = true;
            break;
         case FEET:
            model.rightLeg.visible = true;
            model.leftLeg.visible = true;
      }

   }

   private void renderModel(PoseStack pose, MultiBufferSource buffer, int i, ArmorItem armor, boolean bl, HumanoidModel<? extends LivingEntity> model, boolean bl2, float f, float g, float h, @Nullable String suffix) {
      VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.armorCutoutNoCull(this.getArmorLocation(armor, bl2, suffix)), false, bl);
      model.renderToBuffer(pose, vertexconsumer, i, OverlayTexture.NO_OVERLAY, f, g, h, 1.0F);
   }

   private HumanoidModel<? extends LivingEntity> getVanillaArmorModel(EquipmentSlot slot)
   {
      return usesInnerModel(slot) ? Models.ARMOR_LEGGINGS : Models.ARMOR;
   }

   private boolean usesInnerModel(EquipmentSlot slot) {
      return slot == EquipmentSlot.LEGS;
   }

   private ResourceLocation getArmorLocation(ArmorItem armor, boolean secondLayer, @Nullable String suffix)
   {
      ResourceLocation materiallocation = new ResourceLocation(armor.getMaterial().getName());
      String name = materiallocation.getPath();
      String location = new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/" + name + "_layer_" + (secondLayer ? 2 : 1) + (suffix == null ? "" : "_" + suffix) + ".png").toString();
      return ARMOR_LOCATION_CACHE.computeIfAbsent(location, ResourceLocation::new);
   }
}
