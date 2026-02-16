package com.dontnag.mixin;

import com.dontnag.NoMoreOverlaysConfig;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.Entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class GuiMixin {

    @ModifyExpressionValue(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private boolean pumpkinOverlay(boolean original){
        return NoMoreOverlaysConfig.pumpkin ? false : original;
    }

    @ModifyExpressionValue(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getTicksFrozen()I"))
    private int freezingOverlay(int original){
        return NoMoreOverlaysConfig.freezing ? 0 : original;
    }

    @Inject(method = "renderSpyglassOverlay", at = @At("HEAD"), cancellable = true)
    private void spyglassOverlay(GuiGraphics arg, float g, CallbackInfo ci){
        if(NoMoreOverlaysConfig.spyglass){
            ci.cancel();
        }
    }

    @Inject(method = "renderPortalOverlay", at = @At("HEAD"), cancellable = true)
    private void portalOverlay(GuiGraphics arg, float f, CallbackInfo ci){
        if(NoMoreOverlaysConfig.portal){
            ci.cancel();
        }
    }

    @Inject(method = "renderVignette", at = @At("HEAD"), cancellable = true)
    private void vignetteOverlay(GuiGraphics guiGraphics, Entity entity, CallbackInfo ci){
        if(NoMoreOverlaysConfig.vignette){
            ci.cancel();
        }
    }
}
