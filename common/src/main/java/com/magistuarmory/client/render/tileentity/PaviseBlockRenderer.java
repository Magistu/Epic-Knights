package com.magistuarmory.client.render.tileentity;

import com.magistuarmory.block.PaviseBlockEntity;
import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.client.render.model.block.PaviseBlockModel;
import com.magistuarmory.client.render.model.item.MedievalShieldModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Environment(EnvType.CLIENT)
public class PaviseBlockRenderer implements BlockEntityRenderer<PaviseBlockEntity, PaviseBlockRenderer.State>, ShieldPatternLayer
{
	private final PaviseBlockModel model;
    private final net.minecraft.client.resources.model.sprite.SpriteGetter sprites;
    public net.minecraft.client.resources.model.sprite.SpriteGetter sprites() { return sprites; }
    public static class State extends net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState {
        public DyeColor base; public BannerPatternLayers patterns = BannerPatternLayers.EMPTY; public boolean foil; public float rotation;
    }
    public State createRenderState() { return new State(); }
    public void extractRenderState(PaviseBlockEntity pavise, State state, float partialTicks, net.minecraft.world.phys.Vec3 camera, net.minecraft.client.renderer.feature.ModelFeatureRenderer.CrumblingOverlay breaking) {
        BlockEntityRenderer.super.extractRenderState(pavise, state, partialTicks, camera, breaking);
        state.base = pavise.getBaseColor(); state.patterns = pavise.getPatterns(); state.foil = pavise.hasFoil();
        state.rotation = -pavise.getBlockState().getValue(BannerBlock.ROTATION) * 360.0F / 16;
    }
	private final Identifier location;
	private final String patternsDirectory;
	private final SpriteId baseWithPatternSpriteId;
	private final SpriteId baseWithoutPatternSpriteId;
	private final SpriteId basePatternSpriteId;

	public PaviseBlockRenderer(BlockEntityRendererProvider.Context context, String id, Identifier location)
	{
		this.sprites = context.sprites();
		this.model = new PaviseBlockModel(context.bakeLayer(ModModels.PAVISE_BLOCK_LOCATION));
		this.location = location;
		this.patternsDirectory = "entity/" + location.getPath() + "/";
		this.baseWithPatternSpriteId = new SpriteId(Sheets.SHIELD_SHEET, Identifier.fromNamespaceAndPath(location.getNamespace(), "entity/" + id + "_pattern"));
		this.baseWithoutPatternSpriteId = new SpriteId(Sheets.SHIELD_SHEET, Identifier.fromNamespaceAndPath(location.getNamespace(), "entity/" + id + "_nopattern"));
		this.basePatternSpriteId = new SpriteId(Sheets.SHIELD_SHEET, Identifier.fromNamespaceAndPath(this.location.getNamespace(), this.patternsDirectory + "base"));
	}

	@Override
	public int getViewDistance()
	{
		return 128;
	}

    @Override
    public void submit(State state, PoseStack pose, SubmitNodeCollector collector, net.minecraft.client.renderer.state.level.CameraRenderState camera) {
        pose.pushPose();
        pose.translate(0.5F, 0.5F, 0.5F);
        pose.mulPose(Axis.YP.rotationDegrees(state.rotation));
        pose.scale(1, -1, -1);
        submitPatternPart(pose, collector, model.handle(), state.lightCoords, OverlayTexture.NO_OVERLAY, -1, state.foil, state.base == null ? 0 : 1, null);
        renderPatterns(pose, collector, state.lightCoords, OverlayTexture.NO_OVERLAY,
                state.patterns.layers().stream().map(l -> Pair.of(l.pattern(), l.color())).toList(), state.foil, model.plate(), state.base);
        pose.popPose();
    }

	@Override
	public SpriteId getBaseMaterial(boolean withPattern)
	{
		return withPattern ? this.baseWithPatternSpriteId : this.baseWithoutPatternSpriteId;
	}

	@Override
	public SpriteId getBasePatternMaterial()
	{
		return this.basePatternSpriteId;
	}

	@Override
	public SpriteId getPatternMaterial(Identifier patternlocation)
	{
		return new SpriteId(Sheets.SHIELD_SHEET, Identifier.fromNamespaceAndPath(this.location.getNamespace(), this.patternsDirectory + patternlocation.getPath()));
	}
}
