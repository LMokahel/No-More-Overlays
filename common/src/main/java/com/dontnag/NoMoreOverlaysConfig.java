package com.dontnag;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "nomoreoverlays")
public class NoMoreOverlaysConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean pumpkin;

    @ConfigEntry.Gui.Tooltip
    public boolean freezing;

    @ConfigEntry.Gui.Tooltip
    public boolean totem;

    @ConfigEntry.Gui.Tooltip
    public boolean elder_guardian;

    @ConfigEntry.Gui.Tooltip
    public boolean nausea;

    @ConfigEntry.Gui.Tooltip
    public boolean fire;

    @ConfigEntry.Gui.Tooltip
    public boolean spyglass;

    @ConfigEntry.Gui.Tooltip
    public boolean portal;

    @ConfigEntry.Gui.Tooltip
    public boolean underwater;

    @ConfigEntry.Gui.Tooltip
    public boolean darkness;

    @ConfigEntry.Gui.Tooltip
    public boolean vignette;
}