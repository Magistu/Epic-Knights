package com.magistuarmory.client.render.tileentity;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.render.model.item.*;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

@Environment(EnvType.CLIENT)
public class HeraldryItemStackRenderer extends BlockEntityWithoutLevelRenderer
{
	private final Model model;
	private final Material materialPattern;
	private final Material materialNoPattern;
	private final String patternsDirectory;

	public HeraldryItemStackRenderer(String id, String name, Model model)
	{
		super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
		this.model = model;
		this.materialPattern = new Material(Sheets.SHIELD_SHEET, new ResourceLocation(EpicKnights.ID, "entity/" + id + "_pattern"));
		this.materialNoPattern = new Material(Sheets.SHIELD_SHEET, new ResourceLocation(EpicKnights.ID, "entity/" + id + "_nopattern"));
		this.patternsDirectory = "entity/" + name + "/";
	}

	public void onResourceManagerReload(ResourceManager manager)
	{
		super.onResourceManagerReload(manager);
	}

	@Override
	public void renderByItem(ItemStack stack, ItemTransforms.TransformType transform, PoseStack pose, MultiBufferSource buffer, int p, int overlay)
	{
		if (this.model instanceof MedievalShieldModel shieldmodel)
		{
			boolean flag = BlockItem.getBlockEntityData(stack) != null;
			pose.pushPose();
			pose.scale(1.0F, -1.0F, -1.0F);
			Material material = flag ? materialPattern : materialNoPattern;
			VertexConsumer vertexconsumer = material.sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.model.renderType(material.atlasLocation()), true, stack.hasFoil()));
			shieldmodel.handle().render(pose, vertexconsumer, p, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
			if (flag)
			{
				List<Pair<BannerPattern, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(stack), BannerBlockEntity.getItemPatterns(stack));
				this.renderPatterns(pose, buffer, p, overlay, shieldmodel.plate(), material, list, stack.hasFoil());
			}
			else
			{
				shieldmodel.plate().render(pose, vertexconsumer, p, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
			}

			pose.popPose();
		}
	}

	public void renderPatterns(PoseStack pose, MultiBufferSource buffer, int p, int overlay, ModelPart part, Material basematerial, List<Pair<BannerPattern, DyeColor>> list, boolean hasfoil)
	{
		part.render(pose, basematerial.buffer(buffer, RenderType::entityCutout, hasfoil), p, overlay);

		for(int i = 0; i < 17 && i < list.size(); ++i)
		{
			Pair<BannerPattern, DyeColor> pair = list.get(i);
			float[] color = pair.getSecond().getTextureDiffuseColors();
			Material material = new Material(Sheets.SHIELD_SHEET, new ResourceLocation(EpicKnights.ID, this.patternsDirectory + pair.getFirst().getFilename()));
			part.render(pose, material.buffer(buffer, RenderType::entityNoOutline, hasfoil), p, overlay, color[0], color[1], color[2], 1.0F);
		}
	}
}