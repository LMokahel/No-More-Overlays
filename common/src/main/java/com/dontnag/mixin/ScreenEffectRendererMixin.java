package com.dontnag.mixin;

import com.dontnag.NoMoreOverlaysConfig;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenEffectRenderer.class)
public class ScreenEffectRendererMixin {

    @Inject(method = "renderFire", at = @At("HEAD"), cancellable = true)
    private static void fireOverlay(Minecraft minecraft, PoseStack poseStack, CallbackInfo ci){
        if(NoMoreOverlaysConfig.fire){
            ci.cancel();
        }
    }

    @Inject(method = "renderWater", at = @At("HEAD"), cancellable = true)
    private static void waterOverlay(Minecraft minecraft, PoseStack poseStack, CallbackInfo ci){
        if(NoMoreOverlaysConfig.underwater){
            ci.cancel();
        }
    }

    @Inject(method = "renderTex", at = @At("HEAD"), cancellable = true)
    private static void suffocationOverlay(TextureAtlasSprite textureAtlasSprite, PoseStack poseStack, CallbackInfo ci){
        if(NoMoreOverlaysConfig.suffocation){
            ci.cancel();
        }
    }
}
