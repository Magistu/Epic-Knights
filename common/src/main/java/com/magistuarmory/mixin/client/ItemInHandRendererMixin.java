package com.magistuarmory.mixin.client;

import com.magistuarmory.item.MedievalWeaponItem;
import net.minecraft.client.renderer.FirstPersonHandsAndItemsRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FirstPersonHandsAndItemsRenderer.class)
public abstract class ItemInHandRendererMixin {
    @Redirect(method = "submitHandsWithItems", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;getUseAnimation()Lnet/minecraft/world/item/ItemUseAnimation;"))
    private ItemUseAnimation magistuarmory$useModelBlockingPose(ItemStack stack) {
        // The blocking item model already supplies the first-person pose. Keep actual use/third-person animation unchanged.
        ItemUseAnimation animation = stack.getUseAnimation();
        return stack.getItem() instanceof MedievalWeaponItem && animation == ItemUseAnimation.BLOCK
                ? ItemUseAnimation.NONE : animation;
    }
}
