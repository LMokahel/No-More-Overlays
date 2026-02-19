package com.dontnag.forge;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(NoMoreOverlaysForge.MOD_ID)
public class NoMoreOverlaysForge {

    public static final String MOD_ID = "nomoreoverlays";
    public static NoMoreOverlaysConfig config;

    public NoMoreOverlaysForge(FMLJavaModLoadingContext context) {
        AutoConfig.register(NoMoreOverlaysConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(NoMoreOverlaysConfig.class).getConfig();
        if(FMLEnvironment.dist.isClient()){
            context.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, NoMoreOverlaysForge::getConfigScreen);
        }
    }

    public static ConfigScreenHandler.ConfigScreenFactory getConfigScreen(){
        return new ConfigScreenHandler.ConfigScreenFactory(
                (client, parent) -> AutoConfig.getConfigScreen(NoMoreOverlaysConfig.class, parent).get()
        );
    }
}
