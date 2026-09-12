package com.magistuarmory.fabric.client.render.entity.layer;

import com.magistuarmory.client.render.ModRender;
import com.magistuarmory.item.armor.MedievalArmorItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class MedievalArmorLayer implements ArmorRenderer {
    private final EquipmentLayerRenderer equipmentRenderer;

    public MedievalArmorLayer(EntityRendererProvider.Context context) {
        equipmentRenderer = context.getEquipmentRenderer();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void render(PoseStack pose, SubmitNodeCollector collector, ItemStack stack, HumanoidRenderState state,
                       EquipmentSlot slot, int light, HumanoidModel<HumanoidRenderState> contextModel) {
        if (!(stack.getItem() instanceof MedievalArmorItem armor) || armor.getEquipmentSlot() != slot) return;
        var equippable = stack.get(DataComponents.EQUIPPABLE);
        if (equippable == null || equippable.assetId().isEmpty()) return;
        var fallback = slot == EquipmentSlot.LEGS ? ModRender.INNER_ARMOR : ModRender.OUTER_ARMOR;
        var model = (HumanoidModel<HumanoidRenderState>) armor.getArmorModel(slot, fallback);
        var layer = state.isBaby && state.entityType != EntityType.ARMOR_STAND
                ? EquipmentClientInfo.LayerType.HUMANOID_BABY
                : slot == EquipmentSlot.LEGS ? EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS : EquipmentClientInfo.LayerType.HUMANOID;
        equipmentRenderer.renderLayers(layer, equippable.assetId().orElseThrow(), model, state, stack, pose, collector, light, state.outlineColor);
    }
}
