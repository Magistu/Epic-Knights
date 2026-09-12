package com.magistuarmory.client.render.model.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.EquipmentSlot;

/** Applies slot visibility at draw time, after the deferred renderer resets the model pose. */
public final class SlottedArmorModel extends HumanoidModel<HumanoidRenderState> {
    private final EquipmentSlot slot;

    public SlottedArmorModel(ModelPart root, EquipmentSlot slot) {
        super(root);
        this.slot = slot;
    }

    @Override
    public void setupAnim(HumanoidRenderState state) {
        super.setupAnim(state);
        head.visible = hat.visible = slot == EquipmentSlot.HEAD;
        body.visible = slot == EquipmentSlot.CHEST || slot == EquipmentSlot.LEGS;
        rightArm.visible = leftArm.visible = slot == EquipmentSlot.CHEST;
        rightLeg.visible = leftLeg.visible = slot == EquipmentSlot.LEGS || slot == EquipmentSlot.FEET;
    }
}
