package com.magistuarmory.client.render.entity.layer;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.client.render.model.decoration.HorseArmorDecorationModel;
import com.magistuarmory.component.ModDataComponents;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.animal.equine.HorseModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.equine.Horse;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Environment(EnvType.CLIENT)
public class HorseArmorDecorationLayer extends RenderLayer<net.minecraft.client.renderer.entity.state.HorseRenderState, HorseModel> implements ArmorPatternLayer
{
   private static final String BASE_DIR = "textures/entity/horse/armor/";
   private final HorseArmorDecorationModel model;
   private final Identifier baseTexture;
   private final Identifier basePatternTexture;
   private final String name;
   private final String dirprefix;

   public HorseArmorDecorationLayer(RenderLayerParent<net.minecraft.client.renderer.entity.state.HorseRenderState, HorseModel> parent, EntityRendererProvider.Context context, Identifier texture, String name)
   {
      super(parent);
      this.name = name;
      this.dirprefix = BASE_DIR + name + "/";
      this.baseTexture = texture;
      this.model = new HorseArmorDecorationModel(context.bakeLayer(ModModels.createDecorationLocation(Identifier.fromNamespaceAndPath(texture.getNamespace(), name))));
      this.basePatternTexture = Identifier.fromNamespaceAndPath(EpicKnights.ID, dirprefix + "base.png");
   }

   public void submit(PoseStack pose, SubmitNodeCollector buffer, int p, net.minecraft.client.renderer.entity.state.HorseRenderState entity, float yRot, float xRot)
   {
      ItemStack stack = entity.bodyArmorItem;
      BannerPatternLayers patterns = stack.get(DataComponents.BANNER_PATTERNS);
      if (com.magistuarmory.item.armor.ArmorComponents.isArmor(stack) && patterns != null)
      {
         DyeColor basecolor = stack.get(DataComponents.BASE_COLOR);
         this.model.setupAnim(entity);
         List<Pair<Holder<BannerPattern>, DyeColor>> list = patterns.layers().stream().map(l -> Pair.of(l.pattern(), l.color())).collect(Collectors.toList());
         this.renderPatterns(pose, buffer, p, OverlayTexture.NO_OVERLAY, list, false, this.model.parts(), basecolor);
      }
   }

   @Override
   public Identifier getBaseTexture(boolean withPattern)
   {
      return this.baseTexture;
   }

   @Override
   public Identifier getBasePatternTexture()
   {
      return this.basePatternTexture;
   }

   @Override
   public Identifier getPatternTexture(Identifier patternlocation)
   {
      return Identifier.fromNamespaceAndPath(this.baseTexture.getNamespace(), this.dirprefix + patternlocation.getPath() + ".png");
   }
}
