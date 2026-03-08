package com.dontnag.forge.mixin;

import com.dontnag.forge.NoMoreOverlaysForge;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(Gui.class)
public class GuiMixin {

    @Redirect(method = "renderCameraOverlays", at = @At(value = "INVOKE", target = "Ljava/util/Optional;isPresent()Z"))
    private boolean pumpkinOverlay(Optional<ResourceLocation> instance){
        if(NoMoreOverlaysForge.config.pumpkin){
            return false;
        }
        return instance.isPresent();
    }

    @Inject(method = "renderConfusionOverlay", at = @At("HEAD"), cancellable = true)
    private void nauseaOverlay(GuiGraphics guiGraphics, float f, CallbackInfo ci){
        if(NoMoreOverlaysForge.config.nausea){
            ci.cancel();
        }
    }

    @Redirect(method = "renderCameraOverlays", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getTicksFrozen()I"))
    private int freezingOverlay(LocalPlayer player){
        if(NoMoreOverlaysForge.config.freezing){
            return 0;
        }
        return player.getTicksFrozen();
    }

    @Inject(method = "renderSpyglassOverlay", at = @At("HEAD"), cancellable = true)
    private void spyglassOverlay(GuiGraphics arg, float g, CallbackInfo ci){
        if(NoMoreOverlaysForge.config.spyglass){
            ci.cancel();
        }
    }

    @Inject(method = "renderPortalOverlay", at = @At("HEAD"), cancellable = true)
    private void portalOverlay(GuiGraphics arg, float f, CallbackInfo ci){
        if(NoMoreOverlaysForge.config.portal){
            ci.cancel();
        }
    }

    @Inject(method = "renderVignette", at = @At("HEAD"), cancellable = true)
    private void vignetteOverlay(GuiGraphics guiGraphics, Entity entity, CallbackInfo ci){
        if(NoMoreOverlaysForge.config.vignette){
            ci.cancel();
        }
    }
}
