package com.magistuarmory.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "armor")
public class ArmorConfig implements ConfigData
{
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableKnightArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableJoustingArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableGothicArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableMaximilianArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableChainmailArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enablePlatemailArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableHalfarmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableCrusaderArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableBrigandineArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableGambesonArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableCeremonialArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableShishak = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableNormanHelmet = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRustedHalfarmorArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRustedChainmailArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRustedKettlehat = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRustedNormanHelmet = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableRustedCrusaderArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableXIVCenturyKnightArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableWingedHussarArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableCuirassierArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableKastenbrustArmor = true;
    @ConfigEntry.Gui.RequiresRestart
    public boolean enableLamellarArmor = true;
}
