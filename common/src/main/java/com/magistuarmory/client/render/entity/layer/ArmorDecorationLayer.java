package com.magistuarmory.client.render.entity.layer;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.client.render.model.decoration.ArmorDecorationModel;
import com.magistuarmory.client.render.model.decoration.ArmorDecorationModelSet;
import com.magistuarmory.client.render.model.decoration.SurcoatModel;
import com.magistuarmory.component.ModDataComponents;
import com.magistuarmory.item.ArmorDecoration;
import com.magistuarmory.item.ArmorDecorationItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.magistuarmory.item.ArmorDecorationItem.createDecorations;
import static com.magistuarmory.item.ArmorDecorationItem.getDecorationTags;


@Environment(EnvType.CLIENT)
public class ArmorDecorationLayer<T extends net.minecraft.client.renderer.entity.state.HumanoidRenderState, M extends HumanoidModel<T>> extends RenderLayer<T, M> implements ArmorPatternLayer
{

   private static final String ARMOR_DIR_PREFIX = "textures/models/armor/";
   private final ArmorDecorationModel<T> coatModel;
   private final String coatDirPrefix;
   private final Identifier coatTexture;
   private final Identifier basePatternTexture;
   private final ArmorDecorationModelSet<T> decorationModels;

   public ArmorDecorationLayer(ArmorDecorationModelSet<T> decorationModels, RenderLayerParent<T, M> parent, EntityRendererProvider.Context context, Identifier location)
   {
      super(parent);
      this.decorationModels = decorationModels;
      this.coatModel = new SurcoatModel<>(context.bakeLayer(ModModels.createDecorationLocation(location)));
      this.coatDirPrefix = this.getDirPrefix(location);
      this.coatTexture = this.getTexture(location);
      this.basePatternTexture = Identifier.fromNamespaceAndPath(EpicKnights.ID, coatDirPrefix + "base.png");
   }

   public Identifier getTexture(Identifier location)
   {
      return getTexture(location, false);
   }

   public Identifier getTexture(Identifier location, boolean overlay)
   {
      return Identifier.fromNamespaceAndPath(location.getNamespace(), ARMOR_DIR_PREFIX + location.getPath() + (overlay ? "_overlay.png" : ".png"));
   }

   public String getDirPrefix(Identifier location)
   {
      return ARMOR_DIR_PREFIX + location.getPath() + "/";
   }

   @Override
   public void submit(PoseStack pose, SubmitNodeCollector buffer, int p, T entity, float yRot, float xRot)
   {
      this.renderPiece(pose, buffer, entity, EquipmentSlot.CHEST, p);
      this.renderPiece(pose, buffer, entity, EquipmentSlot.LEGS, p);
      this.renderPiece(pose, buffer, entity, EquipmentSlot.FEET, p);
      this.renderPiece(pose, buffer, entity, EquipmentSlot.HEAD, p);
   }

   private void renderPiece(PoseStack pose, SubmitNodeCollector buffer, T entity, EquipmentSlot slot, int p)
   {
      ItemStack stack = switch (slot) { case HEAD -> entity.headEquipment; case CHEST -> entity.chestEquipment; case LEGS -> entity.legsEquipment; case FEET -> entity.feetEquipment; default -> ItemStack.EMPTY; };
      if (com.magistuarmory.item.armor.ArmorComponents.isArmor(stack))
      {
         if (stack.get(ModDataComponents.ARMOR_DECORATION.get()) != null)
         {
            for (ArmorDecorationItem.DecorationInfo info : createDecorations(getDecorationTags(stack)))
            {
               Identifier location = info.location();
               ArmorDecorationModel<T> model = this.getArmorDecorationModel(location);
               if (model != null)
               {
                  model.setupAnim(entity);
                  if (info.dyeable())
                  {
                     renderDecoration(pose, buffer, p, OverlayTexture.NO_OVERLAY, info.color(), stack.hasFoil(), model.parts(), getTexture(location));
                     renderDecoration(pose, buffer, p, OverlayTexture.NO_OVERLAY, stack.hasFoil(), model.parts(), getTexture(location, true));
                  }
                  else
                  {
                     renderDecoration(pose, buffer, p, OverlayTexture.NO_OVERLAY, stack.hasFoil(), model.parts(), getTexture(location));
                  }
               }
            }
         }
         BannerPatternLayers patterns = stack.get(DataComponents.BANNER_PATTERNS);
         if (slot == EquipmentSlot.CHEST && patterns != null)
         {
            DyeColor basecolor = stack.get(DataComponents.BASE_COLOR);
            this.coatModel.setupAnim(entity);
            renderDecoration(pose, buffer, p, OverlayTexture.NO_OVERLAY, stack.hasFoil(), this.coatModel.parts(), this.coatTexture);
            List<Pair<Holder<BannerPattern>, DyeColor>> list = patterns == null ? new ArrayList<>() : patterns.layers().stream().map(l -> Pair.of(l.pattern(), l.color())).collect(Collectors.toList());
            renderPatterns(pose, buffer, p, OverlayTexture.NO_OVERLAY, list, stack.hasFoil(), this.coatModel.parts(), basecolor);
         }
      }
   }

   public ArmorDecorationModel<T> getCoatModel() {
      return this.coatModel;
   }

   public ArmorDecorationModel<T> getArmorDecorationModel(Identifier location)
   {
      return this.decorationModels.get(location);
   }

   public void renderDecoration(PoseStack pose, SubmitNodeCollector buffer, int p, int overlay, boolean hasfoil, ModelPart[] modelparts, Identifier texture)
   {
      renderDecoration(pose, buffer, p, overlay, -1, hasfoil, modelparts, texture);
   }

   public void renderDecoration(PoseStack pose, SubmitNodeCollector buffer, int p, int overlay, int color, boolean hasfoil, ModelPart[] modelparts, Identifier texture)
   {
      for (ModelPart part : modelparts)
         buffer.submitModelPart(part, pose, net.minecraft.client.renderer.rendertype.RenderTypes.entityCutout(texture), p, overlay, null, false, hasfoil, color, null, 0);
   }

   @Override
   public Identifier getBaseTexture(boolean withPattern)
   {
      return this.coatTexture;
   }

   public Identifier getBaseTexture()
   {
      return this.coatTexture;
   }

   @Override
   public Identifier getBasePatternTexture()
   {
      return this.basePatternTexture;
   }

   @Override
   public Identifier getPatternTexture(Identifier patternlocation)
   {
      return Identifier.fromNamespaceAndPath(this.coatTexture.getNamespace(), this.coatDirPrefix + patternlocation.getPath() + ".png");
   }

   public void registerDecorations(List<RegistrySupplier<? extends ArmorDecoration>> armorDecorationItems, EntityRendererProvider.Context context) {
      this.decorationModels.registerDecorations(armorDecorationItems, context);
   }
}
