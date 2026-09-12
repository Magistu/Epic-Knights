package com.magistuarmory.client.render.tileentity;

import com.magistuarmory.client.render.PatternLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.resources.Identifier;

public interface ShieldPatternLayer extends PatternLayer {
    SpriteId getBaseMaterial(boolean withPattern);
    SpriteId getBasePatternMaterial();
    SpriteId getPatternMaterial(Identifier pattern);
    SpriteGetter sprites();
    @Override
    default void submitPatternPart(PoseStack pose, SubmitNodeCollector collector, ModelPart part, int light, int overlay,
            int color, boolean foil, int layer, Identifier pattern) {
        SpriteId sprite = switch (layer) {
            case 0 -> getBaseMaterial(false);
            case 1 -> getBaseMaterial(true);
            case 2 -> getBasePatternMaterial();
            default -> getPatternMaterial(pattern);
        };
        collector.submitModelPart(part, pose, sprite.renderType(RenderTypes::entityTranslucent), light, overlay,
                sprites().get(sprite), true, foil, color, null, 0);
    }
}
