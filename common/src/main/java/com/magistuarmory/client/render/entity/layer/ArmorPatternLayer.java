package com.magistuarmory.client.render.entity.layer;

import com.magistuarmory.client.render.PatternLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public interface ArmorPatternLayer extends PatternLayer {
    Identifier getBaseTexture(boolean withPattern);
    Identifier getBasePatternTexture();
    Identifier getPatternTexture(Identifier pattern);
    @Override
    default void submitPatternPart(PoseStack pose, SubmitNodeCollector collector, ModelPart part, int light, int overlay,
            int color, boolean foil, int layer, Identifier pattern) {
        Identifier texture = switch (layer) {
            case 0, 1 -> getBaseTexture(layer == 1);
            case 2 -> getBasePatternTexture();
            default -> getPatternTexture(pattern);
        };
        collector.submitModelPart(part, pose, RenderTypes.entityTranslucent(texture), light, overlay, null, false, foil, color, null, 0);
    }
}
