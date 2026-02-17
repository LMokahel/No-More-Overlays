package com.dontnag.neoforge;

import com.dontnag.NoMoreOverlays;
import com.dontnag.NoMoreOverlaysConfig;

import me.shedaniel.autoconfig.AutoConfig;

import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.ConfigScreenHandler;

@Mod(NoMoreOverlays.MOD_ID)
public final class NoMoreOverlaysNeoForge {

    public NoMoreOverlaysNeoForge() {
        AutoConfig.register(NoMoreOverlaysConfig.class, Toml4jConfigSerializer::new);
        NoMoreOverlays.config = AutoConfig.getConfigHolder(NoMoreOverlaysConfig.class).getConfig();
        if(FMLEnvironment.dist.isClient()){
            NoMoreOverlaysNeoForge.registerScreen();
        }
    }

    public static void registerScreen(){
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory((client, parent) ->
                        AutoConfig.getConfigScreen(NoMoreOverlaysConfig.class, parent).get()
                )
        );
    }
}
