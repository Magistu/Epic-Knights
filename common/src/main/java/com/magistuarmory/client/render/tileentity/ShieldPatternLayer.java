package com.magistuarmory.client.render.tileentity;

import com.magistuarmory.client.render.PatternLayer;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

public interface ShieldPatternLayer extends PatternLayer
{
    Material getBaseMaterial(boolean withPattern);
    
    Material getBasePatternMaterial();

    Material getPatternMaterial(ResourceLocation patternlocation);
    
    @Override
    default VertexConsumer baseVertexConsumer(MultiBufferSource buffer, boolean withPattern, boolean hasfoil)
    {
        return getBaseMaterial(withPattern).buffer(buffer, RenderType::entityCutout, hasfoil);
    }

    @Override
    default VertexConsumer basePatternVertexConsumer(MultiBufferSource buffer, boolean hasfoil)
    {
        return getBasePatternMaterial().buffer(buffer, RenderType::entityNoOutline, hasfoil);
    }

    @Override
    default VertexConsumer patternVertexConsumer(MultiBufferSource buffer, ResourceLocation patternlocation, boolean hasfoil)
    {
        return getPatternMaterial(patternlocation).buffer(buffer, RenderType::entityNoOutline, hasfoil);
    }
}
