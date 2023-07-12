package com.magistuarmory.client.render.entity.layer;

import com.magistuarmory.EpicKnights;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.List;

@Environment(EnvType.CLIENT)
public interface PatternLayer
{
   default void renderPatterns(PoseStack pose, MultiBufferSource buffer, int p, int overlay, List<Pair<BannerPattern, DyeColor>> list, boolean hasfoil, ModelPart[] modelparts, float r, float g, float b, String dirprefix, ResourceLocation basetexture)
   {
      VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.entityCutout(basetexture), false, hasfoil);

      for (ModelPart part : modelparts)
      {
         part.render(pose, vertexconsumer, p, overlay, r, g, b, 1.0F);

         for (int i = 0; i < 17 && i < list.size(); ++i)
         {
            Pair<BannerPattern, DyeColor> pair = list.get(i);
            float[] color = pair.getSecond().getTextureDiffuseColors();
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.entityNoOutline(new ResourceLocation(EpicKnights.ID, dirprefix + pair.getFirst().getFilename() + ".png")), false, hasfoil);

            part.render(pose, vertexconsumer2, p, overlay, color[0], color[1], color[2], 1.0F);
         }
      }
   }
}
