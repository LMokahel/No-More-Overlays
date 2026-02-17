package com.dontnag.mixin;

import com.dontnag.NoMoreOverlays;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class GuiMixin {

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private boolean pumpkinOverlay(ItemStack stack, Item item){
        if(NoMoreOverlays.config.pumpkin){
            return false;
        }
        return stack.is(item);
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getTicksFrozen()I"))
    private int freezingOverlay(LocalPlayer player){
        if(NoMoreOverlays.config.freezing){
            return 0;
        }
        return player.getTicksFrozen();
    }

    @Inject(method = "renderSpyglassOverlay", at = @At("HEAD"), cancellable = true)
    private void spyglassOverlay(GuiGraphics arg, float g, CallbackInfo ci){
        if(NoMoreOverlays.config.spyglass){
            ci.cancel();
        }
    }

    @Inject(method = "renderPortalOverlay", at = @At("HEAD"), cancellable = true)
    private void portalOverlay(GuiGraphics arg, float f, CallbackInfo ci){
        if(NoMoreOverlays.config.portal){
            ci.cancel();
        }
    }

    @Inject(method = "renderVignette", at = @At("HEAD"), cancellable = true)
    private void vignetteOverlay(GuiGraphics guiGraphics, Entity entity, CallbackInfo ci){
        if(NoMoreOverlays.config.vignette){
            ci.cancel();
        }
    }
}
