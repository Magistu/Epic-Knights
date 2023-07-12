// 
// Decompiled by Procyon v0.5.36
// 

package com.magistuarmory.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.ConfigData;

@Config(name = "weapons")
public class WeaponsConfig implements ConfigData
{
    @ConfigEntry.Gui.CollapsibleObject
    public StilettoConfig stiletto;
    @ConfigEntry.Gui.CollapsibleObject
    public ShortSwordConfig shortSword;
    @ConfigEntry.Gui.CollapsibleObject
    public KatzbalgerConfig katzbalger;
    @ConfigEntry.Gui.CollapsibleObject
    public PikeConfig pike;
    @ConfigEntry.Gui.CollapsibleObject
    public RanseurConfig ranseur;
    @ConfigEntry.Gui.CollapsibleObject
    public AhlspiessConfig ahlspiess;
    @ConfigEntry.Gui.CollapsibleObject
    public GiantLanceConfig giantLance;
    @ConfigEntry.Gui.CollapsibleObject
    public BastardSwordConfig bastardSword;
    @ConfigEntry.Gui.CollapsibleObject
    public EstocConfig estoc;
    @ConfigEntry.Gui.CollapsibleObject
    public ClaymoreConfig claymore;
    @ConfigEntry.Gui.CollapsibleObject
    public ZweihanderConfig zweihander;
    @ConfigEntry.Gui.CollapsibleObject
    public FlameBladedSwordConfig flameBladedSword;
    @ConfigEntry.Gui.CollapsibleObject
    public LochaberAxeConfig lochaberAxe;
    @ConfigEntry.Gui.CollapsibleObject
    public ConcaveEdgedHalberdConfig concaveEdgedHalberd;
    @ConfigEntry.Gui.CollapsibleObject
    public HeavyMaceConfig heavyMace;
    @ConfigEntry.Gui.CollapsibleObject
    public HeavyWarHammerConfig heavyWarHammer;
    @ConfigEntry.Gui.CollapsibleObject
    public LucerneHammerConfig lucerneHammer;
    @ConfigEntry.Gui.CollapsibleObject
    public MorningstarConfig morningstar;
    @ConfigEntry.Gui.CollapsibleObject
    public FlailConfig flail;
    @ConfigEntry.Gui.CollapsibleObject
    public GuisarmeConfig guisarme;
    @ConfigEntry.Gui.CollapsibleObject
    public BlacksmithHammerConfig blacksmithHammer;
    @ConfigEntry.Gui.CollapsibleObject
    public BarbedClubConfig barbedClub;
    @ConfigEntry.Gui.CollapsibleObject
    public PitchforkConfig pitchfork;
    @ConfigEntry.Gui.CollapsibleObject
    public NobleSwordConfig nobleSword;
    @ConfigEntry.Gui.CollapsibleObject
    public RustedBastardSwordConfig rustedBastardSword;
    @ConfigEntry.Gui.CollapsibleObject
    public RustedHeavyMaceConfig rustedHeavyMace;
    @ConfigEntry.Gui.CollapsibleObject
    public ClubConfig club;
    @ConfigEntry.Gui.CollapsibleObject
    public MesserSwordConfig messerSword;
    
    public WeaponsConfig() {
        this.stiletto = new StilettoConfig();
        this.shortSword = new ShortSwordConfig();
        this.katzbalger = new KatzbalgerConfig();
        this.pike = new PikeConfig();
        this.ranseur = new RanseurConfig();
        this.ahlspiess = new AhlspiessConfig();
        this.giantLance = new GiantLanceConfig();
        this.bastardSword = new BastardSwordConfig();
        this.estoc = new EstocConfig();
        this.claymore = new ClaymoreConfig();
        this.zweihander = new ZweihanderConfig();
        this.flameBladedSword = new FlameBladedSwordConfig();
        this.lochaberAxe = new LochaberAxeConfig();
        this.concaveEdgedHalberd = new ConcaveEdgedHalberdConfig();
        this.heavyMace = new HeavyMaceConfig();
        this.heavyWarHammer = new HeavyWarHammerConfig();
        this.lucerneHammer = new LucerneHammerConfig();
        this.morningstar = new MorningstarConfig();
        this.flail = new FlailConfig();
        this.guisarme = new GuisarmeConfig();
        this.blacksmithHammer = new BlacksmithHammerConfig();
        this.barbedClub = new BarbedClubConfig();
        this.pitchfork = new PitchforkConfig();
        this.nobleSword = new NobleSwordConfig();
        this.rustedBastardSword = new RustedBastardSwordConfig();
        this.rustedHeavyMace = new RustedHeavyMaceConfig();
        this.club = new ClubConfig();
        this.messerSword = new MesserSwordConfig();
    }
    
    public static class StilettoConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public StilettoConfig() {
            this.enabled = true;
            this.baseAttackDamage = 2.0f;
            this.baseAttackSpeed = 1.6f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class ShortSwordConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public ShortSwordConfig() {
            this.enabled = true;
            this.baseAttackDamage = 2.5f;
            this.baseAttackSpeed = 1.7f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class KatzbalgerConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public KatzbalgerConfig() {
            this.enabled = true;
            this.baseAttackDamage = 3.0f;
            this.baseAttackSpeed = 1.65f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class PikeConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public PikeConfig() {
            this.enabled = true;
            this.baseAttackDamage = 3.0f;
            this.baseAttackSpeed = 1.07f;
            this.bonusAttackReach = 3.0f;
        }
    }
    
    public static class RanseurConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public RanseurConfig() {
            this.enabled = true;
            this.baseAttackDamage = 3.1f;
            this.baseAttackSpeed = 1.07f;
            this.bonusAttackReach = 2.0f;
        }
    }
    
    public static class AhlspiessConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public AhlspiessConfig() {
            this.enabled = true;
            this.baseAttackDamage = 4.0f;
            this.baseAttackSpeed = 1.28f;
            this.bonusAttackReach = 1.2f;
        }
    }
    
    public static class GiantLanceConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public GiantLanceConfig() {
            this.enabled = true;
            this.baseAttackDamage = 2.5f;
            this.baseAttackSpeed = 0.84f;
            this.bonusAttackReach = 2.0f;
        }
    }
    
    public static class BastardSwordConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public BastardSwordConfig() {
            this.enabled = true;
            this.baseAttackDamage = 4.25f;
            this.baseAttackSpeed = 1.4f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class EstocConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public EstocConfig() {
            this.enabled = true;
            this.baseAttackDamage = 4.1f;
            this.baseAttackSpeed = 1.4f;
            this.bonusAttackReach = 0.5f;
        }
    }
    
    public static class ClaymoreConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public ClaymoreConfig() {
            this.enabled = true;
            this.baseAttackDamage = 5.4f;
            this.baseAttackSpeed = 1.22f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class ZweihanderConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public ZweihanderConfig() {
            this.enabled = true;
            this.baseAttackDamage = 6.5f;
            this.baseAttackSpeed = 1.12f;
            this.bonusAttackReach = 0.5f;
        }
    }
    
    public static class FlameBladedSwordConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public FlameBladedSwordConfig() {
            this.enabled = true;
            this.baseAttackDamage = 6.4f;
            this.baseAttackSpeed = 1.12f;
            this.bonusAttackReach = 0.5f;
        }
    }
    
    public static class LochaberAxeConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public LochaberAxeConfig() {
            this.enabled = true;
            this.baseAttackDamage = 7.0f;
            this.baseAttackSpeed = 1.0f;
            this.bonusAttackReach = 1.0f;
        }
    }
    
    public static class ConcaveEdgedHalberdConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public ConcaveEdgedHalberdConfig() {
            this.enabled = true;
            this.baseAttackDamage = 8.0f;
            this.baseAttackSpeed = 0.9f;
            this.bonusAttackReach = 2.0f;
        }
    }
    
    public static class HeavyMaceConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public HeavyMaceConfig() {
            this.enabled = true;
            this.baseAttackDamage = 4.5f;
            this.baseAttackSpeed = 1.15f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class HeavyWarHammerConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public HeavyWarHammerConfig() {
            this.enabled = true;
            this.baseAttackDamage = 5.2f;
            this.baseAttackSpeed = 1.05f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class LucerneHammerConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public LucerneHammerConfig() {
            this.enabled = true;
            this.baseAttackDamage = 4.8f;
            this.baseAttackSpeed = 1.1f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class MorningstarConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public MorningstarConfig() {
            this.enabled = true;
            this.baseAttackDamage = 5.0f;
            this.baseAttackSpeed = 1.25f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class FlailConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public FlailConfig() {
            this.enabled = true;
            this.baseAttackDamage = 6.2f;
            this.baseAttackSpeed = 1.1f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class GuisarmeConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public GuisarmeConfig() {
            this.enabled = true;
            this.baseAttackDamage = 3.15f;
            this.baseAttackSpeed = 1.02f;
            this.bonusAttackReach = 1.9f;
        }
    }
    
    public static class BlacksmithHammerConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public BlacksmithHammerConfig() {
            this.enabled = true;
            this.baseAttackDamage = 5.0f;
            this.baseAttackSpeed = 1.0f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class BarbedClubConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public BarbedClubConfig() {
            this.enabled = true;
            this.baseAttackDamage = 5.6f;
            this.baseAttackSpeed = 1.0f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class PitchforkConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public PitchforkConfig() {
            this.enabled = true;
            this.baseAttackDamage = 2.8f;
            this.baseAttackSpeed = 1.0f;
            this.bonusAttackReach = 1.0f;
        }
    }
    
    public static class NobleSwordConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public NobleSwordConfig() {
            this.enabled = true;
            this.baseAttackDamage = 4.25f;
            this.baseAttackSpeed = 1.51f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class RustedBastardSwordConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public RustedBastardSwordConfig() {
            this.enabled = true;
            this.baseAttackDamage = 2.0f;
            this.baseAttackSpeed = 1.51f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class RustedHeavyMaceConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public RustedHeavyMaceConfig() {
            this.enabled = true;
            this.baseAttackDamage = 2.0f;
            this.baseAttackSpeed = 1.51f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class ClubConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public ClubConfig() {
            this.enabled = true;
            this.baseAttackDamage = 11.3f;
            this.baseAttackSpeed = 0.8f;
            this.bonusAttackReach = 0.0f;
        }
    }
    
    public static class MesserSwordConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach;
        
        public MesserSwordConfig() {
            this.enabled = true;
            this.baseAttackDamage = 3.8f;
            this.baseAttackSpeed = 1.56f;
            this.bonusAttackReach = 0.0f;
        }
    }
}
