package com.magistuarmory.fabric.client.render.entity.layer;

import com.magistuarmory.item.DyeableItemLike;
import com.magistuarmory.item.armor.MedievalArmorItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;

import java.util.List;

@Environment(EnvType.CLIENT)
public class MedievalArmorLayer implements ArmorRenderer
{
   public static final HumanoidModel<LivingEntity> OUTER_ARMOR = new HumanoidModel<>(LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(1.0F), 0.0F), 64, 32).bakeRoot());
   public static final HumanoidModel<LivingEntity> INNER_ARMOR = new HumanoidModel<>(LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.5F), 0.0F), 64, 32).bakeRoot());
   
   @Override
   public void render(PoseStack pose, MultiBufferSource buffer, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int i, HumanoidModel<LivingEntity> contextmodel)
   {
      if (stack.getItem() instanceof MedievalArmorItem armor) {
         if (armor.getType().getSlot() == slot)
         {
            HumanoidModel<? extends LivingEntity> model = armor.getArmorModel(slot, getVanillaArmorModel(slot));
            ((HumanoidModel) contextmodel).copyPropertiesTo(model);
            this.setPartVisibility(model, slot);
            boolean foil = stack.hasFoil();
            int color = -1;
            if (stack.getItem() instanceof DyeableItemLike dyeableitem && stack.is(ItemTags.DYEABLE))
            {
               color = FastColor.ARGB32.opaque(dyeableitem.getColor(stack));
            }
            this.renderModel(pose, buffer, i, armor.getArmorType().getLayers(), foil, model, usesInnerModel(slot), color);
         }
      }
   }

   protected void setPartVisibility(HumanoidModel<? extends LivingEntity> model, EquipmentSlot slot) {
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
         case LEGS -> {
            model.body.visible = true;
            model.rightLeg.visible = true;
            model.leftLeg.visible = true;
         }
         case FEET -> {
            model.rightLeg.visible = true;
            model.leftLeg.visible = true;
         }
      }

   }

   private void renderModel(PoseStack pose, MultiBufferSource buffer, int i, List<ArmorMaterial.Layer> layers, boolean foil, HumanoidModel<? extends LivingEntity> model, boolean secondLayer, int color) {
      for (ArmorMaterial.Layer layer : layers) {
         VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.armorCutoutNoCull(layer.texture(secondLayer)), foil);
         model.renderToBuffer(pose, vertexconsumer, i, OverlayTexture.NO_OVERLAY, layer.dyeable() ? color : -1);
      }
   }

   private HumanoidModel<? extends LivingEntity> getVanillaArmorModel(EquipmentSlot slot)
   {
      return usesInnerModel(slot) ? INNER_ARMOR : OUTER_ARMOR;
   }

   private boolean usesInnerModel(EquipmentSlot slot) {
      return slot == EquipmentSlot.LEGS;
   }
}
