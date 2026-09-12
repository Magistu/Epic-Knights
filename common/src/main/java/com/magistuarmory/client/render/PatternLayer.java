package com.magistuarmory.client.render;

import com.magistuarmory.misc.HeraldryRegistry;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BannerPattern;
import java.util.List;

public interface PatternLayer {
    void submitPatternPart(PoseStack pose, SubmitNodeCollector collector, ModelPart part, int light, int overlay,
                           int color, boolean foil, int layer, Identifier pattern);
    default void renderPatterns(PoseStack pose, SubmitNodeCollector collector, int light, int overlay,
            List<Pair<Holder<BannerPattern>, DyeColor>> patterns, boolean foil, ModelPart[] parts, DyeColor base) {
        patterns = filterFromUnregistered(patterns);
        for (ModelPart part : parts) {
            submitPatternPart(pose, collector, part, light, overlay, -1, foil, base == null ? 0 : 1, null);
            if (base != null) submitPatternPart(pose, collector, part, light, overlay, base.getTextureDiffuseColor(), false, 2, null);
            for (int i = 0; i < Math.min(17, patterns.size()); i++) {
                var pattern = patterns.get(i);
                submitPatternPart(pose, collector, part, light, overlay, pattern.getSecond().getTextureDiffuseColor(), false,
                        3, pattern.getFirst().unwrapKey().orElseThrow().identifier());
            }
        }
    }
    static List<Pair<Holder<BannerPattern>, DyeColor>> filterFromUnregistered(List<Pair<Holder<BannerPattern>, DyeColor>> patterns) {
        return patterns.stream().filter(p -> p.getFirst().unwrapKey().isPresent()
                && HeraldryRegistry.isRegistered(p.getFirst().unwrapKey().orElseThrow().identifier().getPath())).toList();
    }
}
