package com.dontnag.forge.mixin;

import com.dontnag.forge.NoMoreOverlaysForge;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPacketListener.class)
public class ClientPacketListenerMixin {

    @Redirect(method = "handleEntityEvent", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GameRenderer;displayItemActivation(Lnet/minecraft/world/item/ItemStack;)V"))
    private void totemOverlay(GameRenderer instance, ItemStack arg){
        if(!NoMoreOverlaysForge.config.totem){
            instance.displayItemActivation(arg);
        }
    }

    @Redirect(method = "handleGameEvent", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ClientLevel;addParticle(Lnet/minecraft/core/particles/ParticleOptions;DDDDDD)V"))
    private void elderGuardianOverlay(ClientLevel instance, ParticleOptions arg, double d, double e, double f, double g, double h, double i){
        if(!NoMoreOverlaysForge.config.elder_guardian){
            instance.addParticle(arg, d, e, f, g, h, i);
        }
    }
}
