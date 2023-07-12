// 
// Decompiled by Procyon v0.5.36
// 

package com.magistuarmory.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.ConfigData;

@Config(name = "shields")
public class ShieldsConfig implements ConfigData
{
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableHeaterShield;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableTarget;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableBuckler;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRondache;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableTartsche;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableEllipticalShield;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRoundShield;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enablePavese;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableKiteShield;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableCorruptedRoundShield;
    
    public ShieldsConfig() {
        this.enableHeaterShield = true;
        this.enableTarget = true;
        this.enableBuckler = true;
        this.enableRondache = true;
        this.enableTartsche = true;
        this.enableEllipticalShield = true;
        this.enableRoundShield = true;
        this.enablePavese = true;
        this.enableKiteShield = true;
        this.enableCorruptedRoundShield = true;
    }
}
