// 
// Decompiled by Procyon v0.5.36
// 

package com.magistuarmory.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.ConfigData;

@Config(name = "armor")
public class ArmorConfig implements ConfigData
{
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableKnightArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableJoustingArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableGothicArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableMaximilianArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableChainmailArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enablePlatemailArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableHalfarmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableCrusaderArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableBrigandineArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableGambesonArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableCeremonialArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableShishak;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableNormanHelmet;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRustedHalfarmorArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRustedChainmailArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRustedKettlehat;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRustedNormanHelmet;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRustedCrusaderArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableXIVCenturyKnightArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableWingedHussarArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableCuirassierArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableKastenbrustArmor;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableLamellarArmor;
    
    public ArmorConfig() {
        this.enableKnightArmor = true;
        this.enableJoustingArmor = true;
        this.enableGothicArmor = true;
        this.enableMaximilianArmor = true;
        this.enableChainmailArmor = true;
        this.enablePlatemailArmor = true;
        this.enableHalfarmor = true;
        this.enableCrusaderArmor = true;
        this.enableBrigandineArmor = true;
        this.enableGambesonArmor = true;
        this.enableCeremonialArmor = true;
        this.enableShishak = true;
        this.enableNormanHelmet = true;
        this.enableRustedHalfarmorArmor = true;
        this.enableRustedChainmailArmor = true;
        this.enableRustedKettlehat = true;
        this.enableRustedNormanHelmet = true;
        this.enableRustedCrusaderArmor = true;
        this.enableXIVCenturyKnightArmor = true;
        this.enableWingedHussarArmor = true;
        this.enableCuirassierArmor = true;
        this.enableKastenbrustArmor = true;
        this.enableLamellarArmor = true;
    }
}
