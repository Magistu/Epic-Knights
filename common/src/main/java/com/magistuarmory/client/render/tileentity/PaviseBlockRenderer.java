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
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Environment(EnvType.CLIENT)
public class PaviseBlockRenderer implements BlockEntityRenderer<PaviseBlockEntity>, ShieldPatternLayer
{
	private final PaviseBlockModel model;
	private final ResourceLocation location;
	private final String patternsDirectory;
	private final Material baseWithPatternMaterial;
	private final Material baseWithoutPatternMaterial;
	private final Material basePatternMaterial;

	public PaviseBlockRenderer(BlockEntityRendererProvider.Context context, String id, ResourceLocation location)
	{
		this.model = new PaviseBlockModel(context.bakeLayer(ModModels.PAVISE_BLOCK_LOCATION));
		this.location = location;
		this.patternsDirectory = "entity/" + location.getPath() + "/";
		this.baseWithPatternMaterial = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "entity/" + id + "_pattern"));
		this.baseWithoutPatternMaterial = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "entity/" + id + "_nopattern"));
		this.basePatternMaterial = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(this.location.getNamespace(), this.patternsDirectory + "base"));
	}

	@Override
	public int getViewDistance()
	{
		return 128;
	}

	@Override
	public void render(PaviseBlockEntity pavise, float f, PoseStack pose, MultiBufferSource buffer, int p, int overlay)
	{
		pose.pushPose();
		BlockState blockstate = pavise.getBlockState();
		pose.translate(0.5F, 0.5F, 0.5F);
		float yrot = (float)(-(Integer)blockstate.getValue(BannerBlock.ROTATION) * 360) / 16.0F;
		pose.mulPose(Axis.YP.rotationDegrees(yrot));
		renderPatterns(pavise, pose, buffer, p, OverlayTexture.NO_OVERLAY);
		pose.popPose();
	}

	public void renderPatterns(PaviseBlockEntity pavise, PoseStack pose, MultiBufferSource buffer, int p, int overlay)
	{
		if (this.model instanceof MedievalShieldModel shieldmodel)
		{
			pose.pushPose();
			pose.scale(1.0F, -1.0F, -1.0F);
			DyeColor basecolor = pavise.getBaseColor();
			VertexConsumer vertexconsumer = this.getBaseMaterial(basecolor != null).sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.model.renderType(this.getBaseMaterial(basecolor != null).atlasLocation()), true, pavise.hasFoil()));
			shieldmodel.handle().render(pose, vertexconsumer, p, overlay, 0xFFFFFF);
			BannerPatternLayers patterns = pavise.getPatterns();
			List<Pair<Holder<BannerPattern>, DyeColor>> list = patterns == null ? new ArrayList<>() : patterns.layers().stream().map(l -> Pair.of(l.pattern(), l.color())).collect(Collectors.toList());
			this.renderPatterns(pose, buffer, p, overlay, list, pavise.hasFoil(), shieldmodel.plate(), basecolor);

			pose.popPose();
		}
	}

	@Override
	public Material getBaseMaterial(boolean withPattern)
	{
		return withPattern ? this.baseWithPatternMaterial : this.baseWithoutPatternMaterial;
	}

	@Override
	public Material getBasePatternMaterial()
	{
		return this.basePatternMaterial;
	}

	@Override
	public Material getPatternMaterial(ResourceLocation patternlocation)
	{
		return new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(this.location.getNamespace(), this.patternsDirectory + patternlocation.getPath()));
	}
}
