package com.magistuarmory.client.render.entity.layer;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.client.render.model.decoration.HorseArmorDecorationModel;
import com.magistuarmory.component.ModDataComponents;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Environment(EnvType.CLIENT)
public class HorseArmorDecorationLayer extends RenderLayer<Horse, HorseModel<Horse>> implements ArmorPatternLayer
{
   private static final String BASE_DIR = "textures/entity/horse/armor/";
   private final HorseArmorDecorationModel<Horse> model;
   private final ResourceLocation baseTexture;
   private final ResourceLocation basePatternTexture;
   private final String name;
   private final String dirprefix;

   public HorseArmorDecorationLayer(RenderLayerParent<Horse, HorseModel<Horse>> parent, EntityRendererProvider.Context context, ResourceLocation texture, String name)
   {
      super(parent);
      this.name = name;
      this.dirprefix = BASE_DIR + name + "/";
      this.baseTexture = texture;
      this.model = new HorseArmorDecorationModel<>(context.bakeLayer(ModModels.createDecorationLocation(ResourceLocation.fromNamespaceAndPath(texture.getNamespace(), name))));
      this.basePatternTexture = ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, dirprefix + "base.png");
   }

   public void render(PoseStack pose, MultiBufferSource buffer, int p, Horse entity, float f, float f2, float f3, float f4, float f5, float f6)
   {
      ItemStack stack = entity.getItemBySlot(EquipmentSlot.BODY);
      BannerPatternLayers patterns = stack.get(DataComponents.BANNER_PATTERNS);
      if (stack.getItem() instanceof AnimalArmorItem && patterns != null)
      {
         DyeColor basecolor = stack.get(DataComponents.BASE_COLOR);
         this.getParentModel().copyPropertiesTo(this.model);
         this.model.prepareMobModel(entity, f, f2, f3);
         this.model.setupAnim(entity, f, f2, f4, f5, f6);
         List<Pair<Holder<BannerPattern>, DyeColor>> list = patterns.layers().stream().map(l -> Pair.of(l.pattern(), l.color())).collect(Collectors.toList());
         this.renderPatterns(pose, buffer, p, OverlayTexture.NO_OVERLAY, list, false, this.model.parts(), basecolor);
      }
   }

   @Override
   public ResourceLocation getBaseTexture(boolean withPattern)
   {
      return this.baseTexture;
   }

   @Override
   public ResourceLocation getBasePatternTexture()
   {
      return this.basePatternTexture;
   }

   @Override
   public ResourceLocation getPatternTexture(ResourceLocation patternlocation)
   {
      return ResourceLocation.fromNamespaceAndPath(this.baseTexture.getNamespace(), this.dirprefix + patternlocation.getPath() + ".png");
   }
}
