package com.dontnag.mixin;

import com.dontnag.NoMoreOverlaysConfig;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(method = "renderConfusionOverlay", at = @At("HEAD"), cancellable = true)
    private void nauseaOverlay(GuiGraphics guiGraphics, float f, CallbackInfo ci){
        if(NoMoreOverlaysConfig.nausea){
            ci.cancel();
        }
    }
}
