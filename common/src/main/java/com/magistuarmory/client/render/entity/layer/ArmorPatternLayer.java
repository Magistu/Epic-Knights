package com.magistuarmory.client.render.entity.layer;

import com.magistuarmory.client.render.PatternLayer;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;

public interface ArmorPatternLayer extends PatternLayer
{
    ResourceLocation getBaseTexture(boolean withPattern);
    
    ResourceLocation getBasePatternTexture();

    ResourceLocation getPatternTexture(ResourceLocation patternlocation);
    
    @Override
    default VertexConsumer baseVertexConsumer(MultiBufferSource buffer, boolean withPattern, boolean hasfoil)
    {
        return ItemRenderer.getArmorFoilBuffer(buffer, RenderType.entityCutout(getBaseTexture(withPattern)), hasfoil);
    }
    
    @Override
    default VertexConsumer basePatternVertexConsumer(MultiBufferSource buffer, boolean hasfoil)
    {
        return ItemRenderer.getArmorFoilBuffer(buffer, RenderType.entityCutout(getBasePatternTexture()), hasfoil);
    }

    @Override
    default VertexConsumer patternVertexConsumer(MultiBufferSource buffer, ResourceLocation patternlocation, boolean hasfoil)
    {
        return ItemRenderer.getArmorFoilBuffer(buffer, RenderType.entityNoOutline(getPatternTexture(patternlocation)), hasfoil);
    }
}
