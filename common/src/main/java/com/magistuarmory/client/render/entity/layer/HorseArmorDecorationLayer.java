package com.magistuarmory.client.render.entity.layer;

import com.magistuarmory.client.render.model.decoration.HorseArmorDecorationModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.List;

@Environment(EnvType.CLIENT)
public class HorseArmorDecorationLayer extends RenderLayer<Horse, HorseModel<Horse>> implements PatternLayer
{
   private static final String BASE_DIR = "textures/entity/horse/armor/";
   private final HorseArmorDecorationModel<Horse> model;
   private final ResourceLocation baseTexture;
   private final String name;
   private final String dir;

   public HorseArmorDecorationLayer(RenderLayerParent<Horse, HorseModel<Horse>> parent, HorseArmorDecorationModel<Horse> model, ResourceLocation texture, String name)
   {
      super(parent);
      this.model = model;
      this.baseTexture = texture;
      this.name = name;
      this.dir = BASE_DIR + name + "/";
   }

   public void render(PoseStack pose, MultiBufferSource buffer, int p, Horse entity, float f, float f2, float f3, float f4, float f5, float f6)
   {
      ItemStack stack = entity.getArmor();
      if (stack.getItem() instanceof HorseArmorItem)
      {
         this.getParentModel().copyPropertiesTo(this.model);
         this.model.prepareMobModel(entity, f, f2, f3);
         this.model.setupAnim(entity, f, f2, f4, f5, f6);

         if (BlockItem.getBlockEntityData(stack) != null)
         {
            List<Pair<BannerPattern, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(stack), BannerBlockEntity.getItemPatterns(stack));

            this.renderPatterns(pose, buffer, p, OverlayTexture.NO_OVERLAY, list, false, this.model);
         }
      }
   }

   public ResourceLocation getBaseTexture()
   {
      return baseTexture;
   }

   public void renderPatterns(PoseStack pose, MultiBufferSource buffer, int p, int overlay, List<Pair<BannerPattern, DyeColor>> list, boolean hasfoil, HorseArmorDecorationModel<Horse> model)
   {
      this.renderPatterns(pose, buffer, p, overlay, list, hasfoil, model.getParts(), 1.0f, 1.0f, 1.0f, this.dir, getBaseTexture());
   }
}
