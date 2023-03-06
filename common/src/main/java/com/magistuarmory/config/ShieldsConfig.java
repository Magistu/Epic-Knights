package com.magistuarmory.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "shields")
public class ShieldsConfig implements ConfigData
{
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableHeaterShield = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableTarget = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableBuckler = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRondache = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableTartsche = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableEllipticalShield = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRoundShield = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enablePavese = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableKiteShield = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableCorruptedRoundShield = true;
}
