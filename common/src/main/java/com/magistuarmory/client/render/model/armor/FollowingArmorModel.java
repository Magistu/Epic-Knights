package com.magistuarmory.client.render.model.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;

/** Copies the entity-specific animation and baked scale when the deferred draw executes. */
public final class FollowingArmorModel extends Model<HumanoidRenderState> {
    private final HumanoidModel<HumanoidRenderState> source;
    private final HumanoidModel<?> armor;
    private final EquipmentSlot slot;

    @SuppressWarnings("unchecked")
    public FollowingArmorModel(HumanoidModel<?> source, HumanoidModel<?> armor, EquipmentSlot slot) {
        super(armor.root(), armor::renderType);
        this.source = (HumanoidModel<HumanoidRenderState>) source;
        this.armor = armor;
        this.slot = slot;
    }

    @Override
    public void setupAnim(HumanoidRenderState state) {
        armor.resetPose();
        source.setupAnim(state);
        copyPose(source, armor);
        if (slot == EquipmentSlot.HEAD && state.entityType == EntityType.WITHER_SKELETON) {
            armor.head.xScale *= 1.05F;
            armor.head.yScale *= 1.05F;
            armor.head.zScale *= 1.05F;
            armor.head.y -= 0.5F;
        }
        armor.head.visible = armor.hat.visible = slot == EquipmentSlot.HEAD;
        armor.body.visible = slot == EquipmentSlot.CHEST || slot == EquipmentSlot.LEGS;
        armor.rightArm.visible = armor.leftArm.visible = slot == EquipmentSlot.CHEST;
        armor.rightLeg.visible = armor.leftLeg.visible = slot == EquipmentSlot.LEGS || slot == EquipmentSlot.FEET;
    }

    public static void copyPose(HumanoidModel<?> source, HumanoidModel<?> target) {
        copyPart(source.root(), target.root());
        copyPart(source.head, target.head);
        copyPart(source.hat, target.hat);
        copyPart(source.body, target.body);
        copyPart(source.rightArm, target.rightArm);
        copyPart(source.leftArm, target.leftArm);
        copyPart(source.rightLeg, target.rightLeg);
        copyPart(source.leftLeg, target.leftLeg);
    }

    private static void copyPart(ModelPart source, ModelPart target) {
        target.loadPose(source.storePose());
    }
}
