package com.magistuarmory.mixin.client;

import com.magistuarmory.item.MedievalWeaponItem;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemInHandRenderer.class)
public abstract class ItemInHandRendererMixin {
    @ModifyVariable(method = "renderArmWithItem", at = @At("STORE"), ordinal = 0)
    private ItemUseAnimation magistuarmory$useModelBlockingPose(ItemUseAnimation animation,
            net.minecraft.client.player.AbstractClientPlayer player, float frameInterp, float xRot,
            net.minecraft.world.InteractionHand hand, float attack, ItemStack stack, float inverseArmHeight,
            com.mojang.blaze3d.vertex.PoseStack poseStack, net.minecraft.client.renderer.SubmitNodeCollector collector, int light) {
        // The blocking item model already supplies the first-person pose. Keep actual use/third-person animation unchanged.
        return stack.getItem() instanceof MedievalWeaponItem && animation == ItemUseAnimation.BLOCK
                ? ItemUseAnimation.NONE : animation;
    }
}
