package com.dontnag;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "nomoreoverlays")
public class NoMoreOverlaysConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public static boolean pumpkin;

    @ConfigEntry.Gui.Tooltip
    public static boolean freezing;

    @ConfigEntry.Gui.Tooltip
    public static boolean totem;

    @ConfigEntry.Gui.Tooltip
    public static boolean elder_guardian;

    @ConfigEntry.Gui.Tooltip
    public static boolean nausea;

    @ConfigEntry.Gui.Tooltip
    public static boolean fire;

    @ConfigEntry.Gui.Tooltip
    public static boolean spyglass;

    @ConfigEntry.Gui.Tooltip
    public static boolean portal;

    @ConfigEntry.Gui.Tooltip
    public static boolean underwater;

    @ConfigEntry.Gui.Tooltip
    public static boolean darkness;

    @ConfigEntry.Gui.Tooltip
    public static boolean vignette;
}
