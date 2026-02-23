package com.magistuarmory.config;

import com.magistuarmory.item.ShieldType;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import java.util.LinkedHashMap;
import java.util.Map;

@Config(name = "shields")
public class ShieldsConfig implements ConfigData
{
    @ConfigEntry.Gui.CollapsibleObject
    public Map<String, ShieldType> shields = new LinkedHashMap<>() {{
        put("heaterShield", ShieldType.of(350, 0.8f, 4, 10, true, true));
        put("target", ShieldType.of(350, 0.8f, 1, 6, true, true));
        put("buckler", ShieldType.of(350, 0.8f, 1, 6, true, true));
        put("rondache", ShieldType.of(420, 1.2f, 6, 13, true, true));
        put("tartsche", ShieldType.of(350, 0.8f, 4, 10, true, true));
        put("ellipticalShield", ShieldType.of(370, 0.8f, 5, 10, true, true));
        put("roundShield", ShieldType.of(350, 0.8f, 3, 7, true, true));
        put("pavise", ShieldType.of(450, 0.7f, 10, 17, true, true));
        put("kiteShield", ShieldType.of(370, 0.8f, 5, 10, true, true));
        put("corruptedRoundShield", ShieldType.of(100, 0.8f, 2, 4, true, true));
    }};

    public ShieldType get(String name) {
        return this.shields.get(name);
    }
}
