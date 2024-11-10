package com.magistuarmory.client.render.tileentity;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.block.PaviseBlockEntity;
import com.magistuarmory.client.render.PatternLayer;
import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.client.render.model.block.PaviseBlockModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;


@Environment(EnvType.CLIENT)
public class PaviseBlockRenderer implements BlockEntityRenderer<PaviseBlockEntity>
{
	public static String DIR_PREFIX = "entity/pavese/";

	PaviseBlockModel model;
	ModelPart handle;
	ModelPart[] plate;

	public PaviseBlockRenderer(BlockEntityRendererProvider.Context context)
	{
		this.model = new PaviseBlockModel(context.bakeLayer(ModModels.PAVISE_BLOCK_LOCATION));
		this.handle = this.model.handle();
		this.plate = this.model.plate();
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
		pose.pushPose();
		pose.scale(1.0F, -1.0F, -1.0F);
		boolean painted = pavise.isPainted();
		Material material = new Material(Sheets.SHIELD_SHEET, new ResourceLocation(EpicKnights.ID, "entity/" + pavise.getShieldId() + (painted ? "_pattern" : "_nopattern")));
		VertexConsumer vertexconsumer = material.sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.model.renderType(material.atlasLocation()), true, pavise.hasFoil()));
		this.handle.render(pose, vertexconsumer, p, OverlayTexture.NO_OVERLAY);
		for (ModelPart part : this.plate)
		{
			part.render(pose, vertexconsumer, p, OverlayTexture.NO_OVERLAY);
		}
		if (painted)
		{
			List<Pair<Holder<BannerPattern>, DyeColor>> list = pavise.getPatterns();
			renderPatterns(pose, buffer, p, OverlayTexture.NO_OVERLAY, list, this.plate, ModelBakery.BANNER_BASE, pavise.hasFoil());
		}
		pose.popPose();
		pose.popPose();
	}

	public static void renderPatterns(PoseStack pose, MultiBufferSource buffer, int p, int overlay, List<Pair<Holder<BannerPattern>, DyeColor>> list, ModelPart[] modelparts, Material basematerial, boolean hasfoil)
	{
		list = PatternLayer.filterFromUnregistered(list);
		
		for (ModelPart part : modelparts)
		{
			for (int i = 0; i < 17 && i < list.size(); ++i)
			{
				Pair<Holder<BannerPattern>, DyeColor> pair = list.get(i);
				float[] color = pair.getSecond().getTextureDiffuseColors();
				if (pair.getFirst().unwrapKey().isPresent())
				{
					Material material = new Material(Sheets.SHIELD_SHEET, new ResourceLocation(EpicKnights.ID, DIR_PREFIX + pair.getFirst().unwrapKey().get().location().getPath()));
					part.render(pose, material.buffer(buffer, RenderType::entityNoOutline, hasfoil), p, overlay, color[0], color[1], color[2], 1.0F);
				}
			}
		}
	}
}
