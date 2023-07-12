package com.magistuarmory.item;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.config.ShieldsConfig;

public final class ShieldTypes
{
    public static final ShieldsConfig SHIELDS_CONFIG = EpicKnights.CONFIG.shields;

    public static final ShieldType HEATER_SHIELD = new ShieldType(350, 0.8f, 4, 10, SHIELDS_CONFIG.enableHeaterShield);
    public static final ShieldType TARGET = new ShieldType(350, 0.8f, 1, 6, SHIELDS_CONFIG.enableTarget);
    public static final ShieldType BUCKLER = new ShieldType(350, 0.8f, 1, 6, SHIELDS_CONFIG.enableBuckler);
    public static final ShieldType RONDACHE = new ShieldType(420, 1.2f, 6, 13, SHIELDS_CONFIG.enableRondache);
    public static final ShieldType TARTSCHE = new ShieldType(350, 0.8f, 4, 10, SHIELDS_CONFIG.enableTartsche);
    public static final ShieldType ELLIPTICAL_SHIELD = new ShieldType(370, 0.8f, 5, 10, SHIELDS_CONFIG.enableEllipticalShield);
    public static final ShieldType ROUND_SHIELD = new ShieldType(350, 0.8f, 3, 7, SHIELDS_CONFIG.enableRoundShield);
    public static final ShieldType PAVISE = new ShieldType(450, 0.7f, 10, 17, SHIELDS_CONFIG.enablePavese);
    public static final ShieldType KITE_SHIELD = new ShieldType(370, 0.8f, 5, 10, SHIELDS_CONFIG.enableKiteShield);
    
    public static final ShieldType CORRUPTED_ROUND_SHIELD = new ShieldType(100, 0.8f, 2, 4, SHIELDS_CONFIG.enableCorruptedRoundShield);
}
