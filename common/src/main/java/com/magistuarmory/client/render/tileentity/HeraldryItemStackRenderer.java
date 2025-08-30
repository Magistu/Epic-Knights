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
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Environment(EnvType.CLIENT)
public class HeraldryItemStackRenderer extends BlockEntityWithoutLevelRenderer implements ShieldPatternLayer
{
	private Model model;
	private final ResourceLocation location;
	private final String patternsDirectory;
	private final Material baseWithPatternMaterial;
	private final Material baseWithoutPatternMaterial;
	private final Material basePatternMaterial;

	public HeraldryItemStackRenderer(String id, ResourceLocation location)
	{
		super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
		this.location = location;
		this.patternsDirectory = "entity/" + location.getPath() + "/";
		this.baseWithPatternMaterial = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "entity/" + id + "_pattern"));
		this.baseWithoutPatternMaterial = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "entity/" + id + "_nopattern"));
		this.basePatternMaterial = new Material(Sheets.SHIELD_SHEET, ResourceLocation.fromNamespaceAndPath(this.location.getNamespace(), this.patternsDirectory + "base"));
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
			DyeColor basecolor = stack.get(DataComponents.BASE_COLOR);
			VertexConsumer vertexconsumer = this.getBaseMaterial(basecolor != null).sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer, this.model.renderType(this.getBaseMaterial(basecolor != null).atlasLocation()), true, stack.hasFoil()));
			shieldmodel.handle().render(pose, vertexconsumer, p, overlay, 0xFFFFFF);
			BannerPatternLayers patterns = stack.get(DataComponents.BANNER_PATTERNS);
			List<Pair<Holder<BannerPattern>, DyeColor>> list = patterns == null ? new ArrayList<>() : patterns.layers().stream().map(l -> Pair.of(l.pattern(), l.color())).collect(Collectors.toList());
			this.renderPatterns(pose, buffer, p, overlay, list, stack.hasFoil(), shieldmodel.plate(), basecolor);

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