package com.magistuarmory.client.render;

import com.magistuarmory.misc.HeraldryRegistry;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.List;
import java.util.stream.Collectors;

@Environment(EnvType.CLIENT)
public interface PatternLayer
{
   VertexConsumer baseVertexConsumer(MultiBufferSource buffer, boolean hasfoil);
   
   VertexConsumer patternVertexConsumer(MultiBufferSource buffer, ResourceLocation patternlocation, boolean hasfoil);
   
   default void renderPatterns(PoseStack pose, MultiBufferSource buffer, int p, int overlay, List<Pair<Holder<BannerPattern>, DyeColor>> list, boolean hasfoil, ModelPart[] modelparts, float r, float g, float b)
   {
      list = filterFromUnregistered(list);
      
      for (ModelPart part : modelparts)
      {
         part.render(pose, baseVertexConsumer(buffer, hasfoil), p, overlay, r, g, b, 1.0F);

         for (int i = 0; i < 17 && i < list.size(); ++i)
         {
            Pair<Holder<BannerPattern>, DyeColor> pair = list.get(i);
            float[] color = pair.getSecond().getTextureDiffuseColors();
            part.render(pose, patternVertexConsumer(buffer, pair.getFirst().unwrapKey().get().location(), hasfoil), p, overlay, color[0], color[1], color[2], 1.0F);
         }
      }
   }

   static List<Pair<Holder<BannerPattern>, DyeColor>> filterFromUnregistered(List<Pair<Holder<BannerPattern>, DyeColor>> list) {
      return list.stream()
              .distinct()
              .filter(pair -> pair.getFirst().unwrapKey().isPresent() && HeraldryRegistry.isRegistered(pair.getFirst().unwrapKey().get().location().getPath()))
              .collect(Collectors.toList());
   }
}
