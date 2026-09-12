package com.magistuarmory.client.render.tileentity;

import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.client.render.model.item.MedievalShieldModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.Model;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Environment(EnvType.CLIENT)
public class HeraldryItemStackRenderer implements net.minecraft.client.renderer.special.SpecialModelRenderer<net.minecraft.core.component.DataComponentMap>, ShieldPatternLayer {
    private Model model;
    private final Identifier location;
    private final SpriteIdContainer materialContainer;


    public HeraldryItemStackRenderer(String id, Identifier location) {

        this.location = location;
        this.materialContainer = new SpriteIdContainer(id, location, "entity/" + location.getPath() + "/");
    }

    @Deprecated(forRemoval = true)
    public void loadModel(EntityRendererProvider.Context context) {
        this.model = new MedievalShieldModel(context.bakeLayer(ModModels.createLocation(this.location)));
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public net.minecraft.client.resources.model.sprite.SpriteGetter sprites() { return Minecraft.getInstance().getAtlasManager(); }

    @Override
    public net.minecraft.core.component.DataComponentMap extractArgument(ItemStack stack) { return stack.immutableComponents(); }

    @Override
    public void getExtents(java.util.function.Consumer<org.joml.Vector3fc> output) {
        if (model != null) {
            PoseStack pose = new PoseStack();
            pose.scale(1, -1, -1);
            model.root().getExtentsForGui(pose, output);
        }
    }

    @Override
    public void submit(net.minecraft.core.component.DataComponentMap components, PoseStack pose, SubmitNodeCollector collector,
            int light, int overlay, boolean foil, int outlineColor) {
        if (!(model instanceof MedievalShieldModel shield)) return;
        DyeColor base = components == null ? null : components.get(DataComponents.BASE_COLOR);
        BannerPatternLayers patterns = components == null ? BannerPatternLayers.EMPTY : components.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY);
        pose.pushPose();
        pose.scale(1, -1, -1);
        submitPatternPart(pose, collector, shield.handle(), light, overlay, -1, foil, base == null ? 0 : 1, null);
        renderPatterns(pose, collector, light, overlay, patterns.layers().stream().map(l -> Pair.of(l.pattern(), l.color())).toList(), foil, shield.plate(), base);
        pose.popPose();
    }


    @Override
    public SpriteId getBaseMaterial(boolean withPattern) {
        return withPattern ?
                materialContainer.getBaseWithPatternSpriteId() :
                materialContainer.getBaseWithoutPatternSpriteId();
    }

    @Override
    public SpriteId getBasePatternMaterial() {
        return materialContainer.getBasePatternMaterial();
    }

    @Override
    public SpriteId getPatternMaterial(Identifier patternLocation) {
        return materialContainer.getPatternMaterial(patternLocation);
    }

    public record Unbaked(String id, Identifier location) implements net.minecraft.client.renderer.special.SpecialModelRenderer.Unbaked<net.minecraft.core.component.DataComponentMap> {
        public static final com.mojang.serialization.MapCodec<Unbaked> CODEC = com.mojang.serialization.codecs.RecordCodecBuilder.mapCodec(instance -> instance.group(
                com.mojang.serialization.Codec.STRING.fieldOf("id").forGetter(Unbaked::id),
                Identifier.CODEC.fieldOf("location").forGetter(Unbaked::location)).apply(instance, Unbaked::new));
        @Override
        public com.mojang.serialization.MapCodec<Unbaked> type() { return CODEC; }
        @Override
        public HeraldryItemStackRenderer bake(net.minecraft.client.renderer.special.SpecialModelRenderer.BakingContext context) {
            HeraldryItemStackRenderer renderer = new HeraldryItemStackRenderer(id, location);
            renderer.setModel(new MedievalShieldModel(context.entityModelSet().bakeLayer(ModModels.createLocation(location))));
            return renderer;
        }
    }

    private static final class SpriteIdContainer {
        private final String id;
        private final Identifier location;
        private final String patternsDirectory;
        private SpriteId baseWithPatternSpriteId = null;
        private SpriteId baseWithoutPatternSpriteId = null;
        private SpriteId basePatternSpriteId = null;

        private SpriteIdContainer(String id, Identifier location, String patternsDirectory) {
            this.id = id;
            this.location = location;
            this.patternsDirectory = patternsDirectory;
        }

        public synchronized SpriteId getBaseWithPatternSpriteId() {
            if (baseWithPatternSpriteId == null)
                baseWithPatternSpriteId = new SpriteId(Sheets.SHIELD_SHEET, Identifier.fromNamespaceAndPath(location.getNamespace(), "entity/" + id + "_pattern"));
            return baseWithPatternSpriteId;
        }

        public synchronized SpriteId getBaseWithoutPatternSpriteId() {
            if (baseWithoutPatternSpriteId == null)
                this.baseWithoutPatternSpriteId = new SpriteId(Sheets.SHIELD_SHEET, Identifier.fromNamespaceAndPath(location.getNamespace(), "entity/" + id + "_nopattern"));
            return baseWithoutPatternSpriteId;
        }

        public synchronized SpriteId getBasePatternMaterial() {
            if (basePatternSpriteId == null)
                basePatternSpriteId = new SpriteId(Sheets.SHIELD_SHEET, Identifier.fromNamespaceAndPath(this.location.getNamespace(), this.patternsDirectory + "base"));
            return basePatternSpriteId;
        }

        public SpriteId getPatternMaterial(Identifier patternLocation) {
            return new SpriteId(Sheets.SHIELD_SHEET, Identifier.fromNamespaceAndPath(this.location.getNamespace(), this.patternsDirectory + patternLocation.getPath()));
        }
    }
}