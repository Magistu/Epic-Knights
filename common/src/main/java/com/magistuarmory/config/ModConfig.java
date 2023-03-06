package com.magistuarmory.config;

import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;

@Config(name = "epicknights")
public class ModConfig extends PartitioningSerializer.GlobalData
{
    @ConfigEntry.Gui.CollapsibleObject
    public GeneralConfig general = new GeneralConfig();

    @ConfigEntry.Gui.CollapsibleObject
    public WeaponsConfig weapons = new WeaponsConfig();

    @ConfigEntry.Gui.CollapsibleObject
    public ShieldsConfig shields = new ShieldsConfig();

    @ConfigEntry.Gui.CollapsibleObject
    public ArmorConfig armor = new ArmorConfig();
    
    @ConfigEntry.Gui.CollapsibleObject
    public MobEquipmentConfig mobEquipments = new MobEquipmentConfig();
}
