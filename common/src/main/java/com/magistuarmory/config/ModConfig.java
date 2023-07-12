// 
// Decompiled by Procyon v0.5.36
// 

package com.magistuarmory.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;

@Config(name = "epicknights")
public class ModConfig extends PartitioningSerializer.GlobalData
{
    @ConfigEntry.Gui.CollapsibleObject
    public GeneralConfig general;
    @ConfigEntry.Gui.CollapsibleObject
    public WeaponsConfig weapons;
    @ConfigEntry.Gui.CollapsibleObject
    public ShieldsConfig shields;
    @ConfigEntry.Gui.CollapsibleObject
    public ArmorConfig armor;
    @ConfigEntry.Gui.CollapsibleObject
    public MobEquipmentConfig mobEquipments;
    
    public ModConfig() {
        this.general = new GeneralConfig();
        this.weapons = new WeaponsConfig();
        this.shields = new ShieldsConfig();
        this.armor = new ArmorConfig();
        this.mobEquipments = new MobEquipmentConfig();
    }
}
