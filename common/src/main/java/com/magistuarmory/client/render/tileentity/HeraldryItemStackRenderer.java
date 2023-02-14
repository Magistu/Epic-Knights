package com.magistuarmory.client.render.tileentity;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.client.render.model.item.*;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

@Environment(EnvType.CLIENT)
public class HeraldryItemStackRenderer extends BlockEntityWithoutLevelRenderer 
{
	private static final Map<String, Model> models;

	static
	{
		models = new HashMap<>();

		models.put("heatershield", new HeaterShieldModel(HeaterShieldModel.createLayer().bakeRoot()));
		models.put("pavese", new PaviseModel(PaviseModel.createLayer().bakeRoot()));
		models.put("roundshield", new RoundShieldModel(RoundShieldModel.createLayer().bakeRoot()));
		models.put("ellipticalshield", new EllipticalShieldModel(EllipticalShieldModel.createLayer().bakeRoot()));
		models.put("tartsche", new TartscheModel(TartscheModel.createLayer().bakeRoot()));
		models.put("rondache", new RondacheModel(RondacheModel.createLayer().bakeRoot()));
		models.put("kiteshield", new KiteShieldModel(KiteShieldModel.createLayer().bakeRoot()));
		models.put("buckler", new BucklerModel(BucklerModel.createLayer().bakeRoot()));
		models.put("target", new TargeModel(TargeModel.createLayer().bakeRoot()));
		models.put("corruptedroundshield", new CorruptedRoundShieldModel(CorruptedRoundShieldModel.createLayer().bakeRoot()));
	}

	private final Model model;
	private final Material materialPattern;
	private final Material materialNoPattern;
	private final String patternsDirectory;
	

	public HeraldryItemStackRenderer(String id, String name, Model model) 
	{
		super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
		this.model = model;
		this.materialPattern = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(KnightlyArmory.ID, "entity/" + id + "_pattern"));
		this.materialNoPattern = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation(KnightlyArmory.ID, "entity/" + id + "_nopattern"));
		this.patternsDirectory = "entity/" + name + "/";
	}

	public void onResourceManagerReload(ResourceManager p_172555_) 
	{
		super.onResourceManagerReload(p_172555_);
	}

	@Override
	public void renderByItem(ItemStack p_108830_, ItemTransforms.TransformType p_108831_, PoseStack p_108832_, MultiBufferSource p_108833_, int p_108834_, int p_108835_) 
	{
		if (model instanceof MedievalShieldModel)
		{
			MedievalShieldModel shieldmodel = (MedievalShieldModel)model;

			boolean flag = p_108830_.getTagElement("BlockEntityTag") != null;
	        p_108832_.pushPose();
	        p_108832_.scale(1.0F, -1.0F, -1.0F);
	        Material material = flag ? materialPattern : materialNoPattern;
	        VertexConsumer vertexconsumer = material.sprite().wrap(ItemRenderer.getFoilBufferDirect(p_108833_, this.model.renderType(material.atlasLocation()), true, p_108830_.hasFoil()));
			shieldmodel.handle().render(p_108832_, vertexconsumer, p_108834_, p_108835_, 1.0F, 1.0F, 1.0F, 1.0F);
	        if (flag)
	        {
	           List<Pair<BannerPattern, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(p_108830_), BannerBlockEntity.getItemPatterns(p_108830_));
	           renderPatterns(p_108832_, p_108833_, p_108834_, p_108835_, shieldmodel.plate(), material, list, p_108830_.hasFoil());
	        }
	        else
	        {
				shieldmodel.plate().render(p_108832_, vertexconsumer, p_108834_, p_108835_, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
	
	        p_108832_.popPose();
	    }
	}

	public void renderPatterns(PoseStack p_112075_, MultiBufferSource p_112076_, int p_112077_, int p_112078_, ModelPart p_112079_, Material p_112080_, List<Pair<BannerPattern, DyeColor>> p_112082_, boolean p_112083_) 
	{
		p_112079_.render(p_112075_, p_112080_.buffer(p_112076_, RenderType::entityCutout, p_112083_), p_112077_, p_112078_);

		for(int i = 0; i < 17 && i < p_112082_.size(); ++i) 
		{
			Pair<BannerPattern, DyeColor> pair = p_112082_.get(i);
			float[] afloat = pair.getSecond().getTextureDiffuseColors();
			BannerPattern bannerpattern = pair.getFirst();
			Material material = new Material(Sheets.SHIELD_SHEET, new ResourceLocation(KnightlyArmory.ID, this.patternsDirectory + bannerpattern.getFilename()));
			p_112079_.render(p_112075_, material.buffer(p_112076_, RenderType::entityNoOutline), p_112077_, p_112078_, afloat[0], afloat[1], afloat[2], 1.0F);
		}
	}
}