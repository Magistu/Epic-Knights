package com.magistuarmory.compat;

import com.magistuarmory.client.render.entity.layer.ArmorDecorationLayer;
import com.magistuarmory.client.render.model.decoration.ArmorDecorationModel;
import com.magistuarmory.component.ModDataComponents;
import com.magistuarmory.item.ArmorDecorationItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.client.model.SkinnedMesh;
import yesman.epicfight.api.client.model.transformer.HumanoidModelBaker;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.client.events.engine.RenderEngine;
import yesman.epicfight.client.mesh.HumanoidMesh;
import yesman.epicfight.client.renderer.patched.layer.ModelRenderLayer;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.magistuarmory.client.render.PatternLayer.filterFromUnregistered;

public class PatchedArmorDecorationLayer<E extends LivingEntity, T extends LivingEntityPatch<E>, AM extends HumanoidMesh> extends ModelRenderLayer<E, T, ArmorDecorationModel<E>, ArmorDecorationLayer<E, ArmorDecorationModel<E>>, AM> {
	private static final Map<ResourceLocation, SkinnedMesh> SKINNED_MESHES_CACHE = new HashMap<> ();

	public static void clearModels() {
		SKINNED_MESHES_CACHE.values().forEach(SkinnedMesh::destroy);
		SKINNED_MESHES_CACHE.clear();
	}
	
	public static void putMesh(ResourceLocation rl, SkinnedMesh skinnedMesh) {
		SKINNED_MESHES_CACHE.computeIfPresent(rl, (key, mesh) -> {
			if (mesh != skinnedMesh) mesh.destroy();
			return mesh;
		});
		
		SKINNED_MESHES_CACHE.put(rl, skinnedMesh);
	}

	public PatchedArmorDecorationLayer(AssetAccessor<AM> meshProvider) {
		super(meshProvider);
	}
	
	private void renderArmorDecoration(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int overlay, SkinnedMesh model, Armature armature, float r, float g, float b, ResourceLocation armorTexture, OpenMatrix4f[] poses) {
		model.draw(poseStack, multiBufferSource, RenderType.armorCutoutNoCull(armorTexture), packedLight, r, g, b, 1.0F, overlay, armature, poses);
	}
	
	private void renderGlint(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int overlay, SkinnedMesh model, Armature armature, OpenMatrix4f[] poses) {
		model.draw(poseStack, multiBufferSource, RenderType.armorEntityGlint(), packedLight, 1.0F, 1.0F, 1.0F, 1.0F, overlay, armature, poses);
	}

	@Override
	public void renderLayer(T entitypatch, E entityliving, ArmorDecorationLayer<E, ArmorDecorationModel<E>> armorDecorationLayer, PoseStack poseStack, MultiBufferSource buf, int packedLight, OpenMatrix4f[] poses, float bob, float yRot, float xRot, float partialTicks) {
		renderPiece(EquipmentSlot.HEAD, entitypatch, entityliving, armorDecorationLayer, poseStack, buf, packedLight, poses, bob, yRot, xRot, partialTicks);
		renderPiece(EquipmentSlot.CHEST, entitypatch, entityliving, armorDecorationLayer, poseStack, buf, packedLight, poses, bob, yRot, xRot, partialTicks);
		renderPiece(EquipmentSlot.LEGS, entitypatch, entityliving, armorDecorationLayer, poseStack, buf, packedLight, poses, bob, yRot, xRot, partialTicks);
		renderPiece(EquipmentSlot.FEET, entitypatch, entityliving, armorDecorationLayer, poseStack, buf, packedLight, poses, bob, yRot, xRot, partialTicks);
	}

	private void renderPiece(EquipmentSlot slot, T entitypatch, E entityliving, ArmorDecorationLayer<E, ArmorDecorationModel<E>> armorDecorationLayer, PoseStack poseStack, MultiBufferSource buf, int packedLight, OpenMatrix4f[] poses, float bob, float yRot, float xRot, float partialTicks) {
		if (slot.getType() != EquipmentSlot.Type.HUMANOID_ARMOR) {
			return;
		}

		ItemStack itemstack = entityliving.getItemBySlot(slot);
		Item item = itemstack.getItem();

		if (item instanceof ArmorItem armorItem) {
			if (slot != armorItem.getEquipmentSlot()) {
				return;
			}

			boolean hasfoil = itemstack.hasFoil();
			if (itemstack.get(ModDataComponents.ARMOR_DECORATION.get()) != null) {
				for (ArmorDecorationItem.DecorationInfo info : ArmorDecorationItem.createDecorations(ArmorDecorationItem.getDecorationTags(itemstack))) {
					poseStack.pushPose();
					float head = 0.0F;

					if (slot == EquipmentSlot.HEAD) {
						poseStack.translate(0.0D, head * 0.055D, 0.0D);
					}

					ResourceLocation location = info.location();
					ArmorDecorationModel<E> model = armorDecorationLayer.getArmorDecorationModel(location);

					SkinnedMesh skinnedMesh;
					if (SKINNED_MESHES_CACHE.containsKey(location) && !RenderEngine.getInstance().shouldRenderVanillaModel()) {
						skinnedMesh = SKINNED_MESHES_CACHE.get(location);
					} else {
						skinnedMesh = this.getSkinnedMesh(armorDecorationLayer, model, entityliving, armorItem, itemstack, slot);
						putMesh(location, skinnedMesh);
					}
					if (skinnedMesh == null) {
						poseStack.popPose();
						return;
					}

					prepareSkinnedMesh(skinnedMesh, model, entityliving, bob, yRot, xRot, partialTicks);

					if (info.dyeable()) {
						int j = info.color();
						float r = (float) (j >> 16 & 255) / 255.0F;
						float g = (float) (j >> 8 & 255) / 255.0F;
						float b = (float) (j & 255) / 255.0F;

						this.renderArmorDecoration(poseStack, buf, packedLight, OverlayTexture.NO_OVERLAY, skinnedMesh, entitypatch.getArmature(), r, g, b, armorDecorationLayer.getTexture(location), poses);
						this.renderArmorDecoration(poseStack, buf, packedLight, OverlayTexture.NO_OVERLAY, skinnedMesh, entitypatch.getArmature(), 1.0F, 1.0F, 1.0F, armorDecorationLayer.getTexture(location, true), poses);
					} else {
						this.renderArmorDecoration(poseStack, buf, packedLight, OverlayTexture.NO_OVERLAY, skinnedMesh, entitypatch.getArmature(), 1.0F, 1.0F, 1.0F, armorDecorationLayer.getTexture(location), poses);
					}

					if (hasfoil) {
						this.renderGlint(poseStack, buf, packedLight, OverlayTexture.NO_OVERLAY, skinnedMesh, entitypatch.getArmature(), poses);
					}

					poseStack.popPose();
				}
			}

			BannerPatternLayers patterns = itemstack.get(DataComponents.BANNER_PATTERNS);
			if (armorItem.getEquipmentSlot() == EquipmentSlot.CHEST && patterns != null) {
				ResourceLocation location = armorDecorationLayer.getBaseTexture();

				ArmorDecorationModel<E> model = armorDecorationLayer.getCoatModel();

				SkinnedMesh skinnedMesh;
				if (SKINNED_MESHES_CACHE.containsKey(location) && !RenderEngine.getInstance().shouldRenderVanillaModel()) {
					skinnedMesh = SKINNED_MESHES_CACHE.get(location);
				} else {
					skinnedMesh = this.getSkinnedMesh(armorDecorationLayer, model, entityliving, armorItem, itemstack, slot);
					putMesh(location, skinnedMesh);
				}

				prepareSkinnedMesh(skinnedMesh, model, entityliving, bob, yRot, xRot, partialTicks);

				this.renderArmorDecoration(poseStack, buf, packedLight, OverlayTexture.NO_OVERLAY, skinnedMesh, entitypatch.getArmature(), 1.0F, 1.0F, 1.0F, armorDecorationLayer.getBaseTexture(), poses);
				List<Pair<Holder<BannerPattern>, DyeColor>> list = patterns == null ? new ArrayList<>() : patterns.layers().stream().map(l -> Pair.of(l.pattern(), l.color())).collect(Collectors.toList());
				this.renderPatterns(poseStack, buf, packedLight, OverlayTexture.NO_OVERLAY, list, hasfoil, armorDecorationLayer.getBaseTexture(), 1.0F, 1.0F, 1.0F, skinnedMesh, entitypatch, poses, armorDecorationLayer);
			}
		}
	}

	private void prepareSkinnedMesh(SkinnedMesh skinnedMesh, ArmorDecorationModel<E> model, E entityliving, float bob, float yRot, float xRot, float partialTicks) {
		boolean shouldSit = entityliving.isPassenger() && (entityliving.getVehicle() != null && entityliving.getVehicle().shouldRiderSit());
		float f8 = 0.0F;
		float f5 = 0.0F;

		if (!shouldSit && entityliving.isAlive()) {
			f8 = entityliving.walkAnimation.speed(partialTicks);
			f5 = entityliving.walkAnimation.position(partialTicks);

			if (entityliving.isBaby()) {
				f5 *= 3.0F;
			}

			if (f8 > 1.0F) {
				f8 = 1.0F;
			}
		}

		try {
			// Fix: Crash with better nether by unknown cause
			model.setupAnim(entityliving, f8, f5, bob, yRot, xRot);
		} catch (ClassCastException ignored) {
		}

		model.head.loadPose(model.head.getInitialPose());
		model.hat.loadPose(model.hat.getInitialPose());
		model.body.loadPose(model.body.getInitialPose());
		model.leftArm.loadPose(model.leftArm.getInitialPose());
		model.rightArm.loadPose(model.rightArm.getInitialPose());
		model.leftLeg.loadPose(model.leftLeg.getInitialPose());
		model.rightLeg.loadPose(model.rightLeg.getInitialPose());

		skinnedMesh.initialize();
	}
	
	private SkinnedMesh getSkinnedMesh(ArmorDecorationLayer<E, ArmorDecorationModel<E>> originalRenderer, ArmorDecorationModel<E> model, E entityliving, ArmorItem armorItem, ItemStack itemstack, EquipmentSlot slot) {
		PoseStack ps = new PoseStack();
		ps.translate(0, 0, 10000);

		//Render armor to get the visibility of each part
		originalRenderer.render(ps, Minecraft.getInstance().renderBuffers().bufferSource(), 0, entityliving, 0, 0, 0, 0, 0, 0);

		return HumanoidModelBaker.bakeArmor(entityliving, itemstack, armorItem, slot, null, model, originalRenderer.getParentModel(), this.mesh.get());
	}

	private void renderPatterns(PoseStack pose, MultiBufferSource buffer, int p, int overlay, List<Pair<Holder<BannerPattern>, DyeColor>> list, boolean hasfoil, ResourceLocation location, float r, float g, float b, SkinnedMesh mesh, T entitypatch, OpenMatrix4f[] poses, ArmorDecorationLayer armorDecorationLayer)
	{
		list = filterFromUnregistered(list);

		this.renderArmorDecoration(pose, buffer, p, overlay, mesh, entitypatch.getArmature(), r, g, b, location, poses);
		for (int i = 0; i < 17 && i < list.size(); ++i)
		{
			Pair<Holder<BannerPattern>, DyeColor> pair = list.get(i);
			float[] color = getTextureDiffuseColors(pair.getSecond().getTextureDiffuseColor());
			this.renderArmorDecoration(pose, buffer, p, overlay, mesh, entitypatch.getArmature(), color[0], color[1], color[2], armorDecorationLayer.getPatternTexture(pair.getFirst().unwrapKey().get().location()), poses);
		}
		if (hasfoil) {
			this.renderGlint(pose, buffer, p, overlay, mesh, entitypatch.getArmature(), poses);
		}
	}

	private static float[] getTextureDiffuseColors(int k) {
		int n = (k & 16711680) >> 16;
		int o = (k & '\uff00') >> 8;
		int p = (k & 255) >> 0;
		return new float[]{(float)n / 255.0F, (float)o / 255.0F, (float)p / 255.0F};
	}
}
