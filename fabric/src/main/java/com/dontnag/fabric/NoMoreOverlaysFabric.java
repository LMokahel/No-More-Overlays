package com.dontnag.fabric;

import com.dontnag.NoMoreOverlays;
import com.dontnag.NoMoreOverlaysConfig;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

import net.fabricmc.api.ClientModInitializer;

public final class NoMoreOverlaysFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AutoConfig.register(NoMoreOverlaysConfig.class, Toml4jConfigSerializer::new);
        NoMoreOverlays.config = AutoConfig.getConfigHolder(NoMoreOverlaysConfig.class).getConfig();
    }
}
