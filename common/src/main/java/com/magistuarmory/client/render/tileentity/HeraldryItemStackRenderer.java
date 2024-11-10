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
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.List;

@Environment(EnvType.CLIENT)
public class HeraldryItemStackRenderer extends BlockEntityWithoutLevelRenderer implements ShieldPatternLayer
{
	private Model model;
	private final ResourceLocation location;
	private final ResourceLocation locationPattern;
	private final ResourceLocation locationNoPattern;
	private final String patternsDirectory;

	public HeraldryItemStackRenderer(String id, ResourceLocation location)
	{
		super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
		this.location = location;
		this.locationPattern = new ResourceLocation(location.getNamespace(), "entity/" + id + "_pattern");
		this.locationNoPattern = new ResourceLocation(location.getNamespace(), "entity/" + id + "_nopattern");
		this.patternsDirectory = "entity/" + location.getPath() + "/";
	}

	public void loadModel(EntityRendererProvider.Context context)
	{
		this.model = new MedievalShieldModel(context.bakeLayer(ModModels.createLocation(this.location)));
	}

	@Override
	public void renderByItem(ItemStack stack, ItemDisplayContext transform, PoseStack pose, MultiBufferSource buffer, int p, int overlay)
	{
		if (this.model instanceof MedievalShieldModel shieldmodel)
		{
			pose.pushPose();
			pose.scale(1.0F, -1.0F, -1.0F);
			if (BlockItem.getBlockEntityData(stack) != null)
			{
				Material material = this.getBaseMaterial();
				VertexConsumer vertexconsumer = material.sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.model.renderType(material.atlasLocation()), true, stack.hasFoil()));
				shieldmodel.handle().render(pose, vertexconsumer, p, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
				List<Pair<Holder<BannerPattern>, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(stack), BannerBlockEntity.getItemPatterns(stack));
				this.renderPatterns(pose, buffer, p, overlay, list, stack.hasFoil(), shieldmodel.plate(), 1.0F, 1.0F, 1.0F);
			}
			else
			{
				Material material = new Material(Sheets.SHIELD_SHEET, locationNoPattern);
				VertexConsumer vertexconsumer = material.sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.model.renderType(material.atlasLocation()), true, stack.hasFoil()));
				shieldmodel.handle().render(pose, vertexconsumer, p, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
				for (ModelPart part : shieldmodel.plate())
				{
					part.render(pose, vertexconsumer, p, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
				}
			}

			pose.popPose();
		}
	}

	@Override
	public Material getBaseMaterial()
	{
		return new Material(Sheets.SHIELD_SHEET, this.locationPattern);
	}

	@Override
	public Material getPatternMaterial(ResourceLocation patternlocation)
	{
		return new Material(Sheets.SHIELD_SHEET, new ResourceLocation(this.location.getNamespace(), this.patternsDirectory + patternlocation.getPath()));
	}
}