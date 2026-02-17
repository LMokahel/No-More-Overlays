package com.dontnag.mixin;

import com.dontnag.NoMoreOverlays;

import net.minecraft.client.renderer.LightTexture;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LightTexture.class)
public class LightTextureClient {

    @Inject(method = "getDarknessGamma", at = @At("HEAD"), cancellable = true)
    private void darknessOverlay(float f, CallbackInfoReturnable<Float> cir){
        if(NoMoreOverlays.config.darkness){
            cir.setReturnValue(0f);
        }
    }
}
