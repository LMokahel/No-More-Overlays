package com.dontnag.neoforge;

import com.dontnag.NoMoreOverlays;
import com.dontnag.NoMoreOverlaysConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(NoMoreOverlaysNeoForge.MOD_ID)
public final class NoMoreOverlaysNeoForge {

    public static final String MOD_ID = "nomoreoverlays";

    public NoMoreOverlaysNeoForge() {
        AutoConfig.register(NoMoreOverlaysConfig.class, Toml4jConfigSerializer::new);
        NoMoreOverlays.config = AutoConfig.getConfigHolder(NoMoreOverlaysConfig.class).getConfig();
        if(FMLEnvironment.dist.isClient()){
            ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, NoMoreOverlaysNeoForge::getConfigScreen);
        }
    }

    public static IConfigScreenFactory getConfigScreen(){
        return (client, parent) -> AutoConfig.getConfigScreen(NoMoreOverlaysConfig.class, parent).get();
    }
}