package com.dontnag.forge;

import com.dontnag.NoMoreOverlaysConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;


import com.dontnag.NoMoreOverlays;

@Mod(NoMoreOverlays.MOD_ID)
public final class NoMoreOverlaysForge {

    public NoMoreOverlaysForge() {
        AutoConfig.register(NoMoreOverlaysConfig.class, Toml4jConfigSerializer::new);

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            NoMoreOverlaysForge.registerScreen();
        });
    }

    public static void registerScreen() {
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory((client, parent) -> {
            return AutoConfig.getConfigScreen(NoMoreOverlaysConfig.class, parent).get();
        }));
    }
}
