package com.magistuarmory.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "weapons")
public class WeaponsConfig implements ConfigData
{
    @ConfigEntry.Gui.CollapsibleObject
    public BarbedClubConfig barbedClub;
    @ConfigEntry.Gui.CollapsibleObject
    public BlacksmithHammerConfig blacksmithHammer;
    @ConfigEntry.Gui.CollapsibleObject
    public ClubConfig club;
    @ConfigEntry.Gui.CollapsibleObject
    public FlailConfig flail;
    @ConfigEntry.Gui.CollapsibleObject
    public HeavyMaceConfig heavyMace;
    @ConfigEntry.Gui.CollapsibleObject
    public HeavyWarHammerConfig heavyWarHammer;
    @ConfigEntry.Gui.CollapsibleObject
    public LucerneHammerConfig lucerneHammer;
    @ConfigEntry.Gui.CollapsibleObject
    public MorningstarConfig morningstar;
    @ConfigEntry.Gui.CollapsibleObject
    public RustedHeavyMaceConfig rustedHeavyMace;
    @ConfigEntry.Gui.CollapsibleObject
    public StilettoConfig stiletto;
    @ConfigEntry.Gui.CollapsibleObject
    public ClaymoreConfig claymore;
    @ConfigEntry.Gui.CollapsibleObject
    public FlameBladedSwordConfig flameBladedSword;
    @ConfigEntry.Gui.CollapsibleObject
    public ZweihanderConfig zweihander;
    @ConfigEntry.Gui.CollapsibleObject
    public ConcaveEdgedHalberdConfig concaveEdgedHalberd;
    @ConfigEntry.Gui.CollapsibleObject
    public GiantLanceConfig giantLance;
    @ConfigEntry.Gui.CollapsibleObject
    public LochaberAxeConfig lochaberAxe;
    @ConfigEntry.Gui.CollapsibleObject
    public BastardSwordConfig bastardSword;
    @ConfigEntry.Gui.CollapsibleObject
    public EstocConfig estoc;
    @ConfigEntry.Gui.CollapsibleObject
    public MesserSwordConfig messerSword;
    @ConfigEntry.Gui.CollapsibleObject
    public NobleSwordConfig nobleSword;
    @ConfigEntry.Gui.CollapsibleObject
    public RustedBastardSwordConfig rustedBastardSword;
    @ConfigEntry.Gui.CollapsibleObject
    public AhlspiessConfig ahlspiess;
    @ConfigEntry.Gui.CollapsibleObject
    public GuisarmeConfig guisarme;
    @ConfigEntry.Gui.CollapsibleObject
    public PikeConfig pike;
    @ConfigEntry.Gui.CollapsibleObject
    public PitchforkConfig pitchfork;
    @ConfigEntry.Gui.CollapsibleObject
    public RanseurConfig ranseur;
    @ConfigEntry.Gui.CollapsibleObject
    public KatzbalgerConfig katzbalger;
    @ConfigEntry.Gui.CollapsibleObject
    public ShortSwordConfig shortSword;

    public WeaponsConfig() {
        this.barbedClub = new BarbedClubConfig();
        this.blacksmithHammer = new BlacksmithHammerConfig();
        this.club = new ClubConfig();
        this.flail = new FlailConfig();
        this.heavyMace = new HeavyMaceConfig();
        this.heavyWarHammer = new HeavyWarHammerConfig();
        this.lucerneHammer = new LucerneHammerConfig();
        this.morningstar = new MorningstarConfig();
        this.rustedHeavyMace = new RustedHeavyMaceConfig();
        this.stiletto = new StilettoConfig();
        this.claymore = new ClaymoreConfig();
        this.flameBladedSword = new FlameBladedSwordConfig();
        this.zweihander = new ZweihanderConfig();
        this.concaveEdgedHalberd = new ConcaveEdgedHalberdConfig();
        this.giantLance = new GiantLanceConfig();
        this.lochaberAxe = new LochaberAxeConfig();
        this.bastardSword = new BastardSwordConfig();
        this.estoc = new EstocConfig();
        this.messerSword = new MesserSwordConfig();
        this.nobleSword = new NobleSwordConfig();
        this.rustedBastardSword = new RustedBastardSwordConfig();
        this.ahlspiess = new AhlspiessConfig();
        this.guisarme = new GuisarmeConfig();
        this.pike = new PikeConfig();
        this.pitchfork = new PitchforkConfig();
        this.ranseur = new RanseurConfig();
        this.katzbalger = new KatzbalgerConfig();
        this.shortSword = new ShortSwordConfig();
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
            this.baseAttackDamage = 5.20f;
            this.baseAttackSpeed = 1.00f;
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 5.00f;
            this.baseAttackSpeed = 1.00f;
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 7.00f;
            this.baseAttackSpeed = 0.80f;
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 6.20f;
            this.baseAttackSpeed = 1.00f;
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 4.80f;
            this.baseAttackSpeed = 1.15f;
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 5.00f;
            this.baseAttackSpeed = 1.05f;
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 4.40f;
            this.baseAttackSpeed = 1.10f;
            this.bonusAttackReach = 0.70f;
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
            this.baseAttackDamage = 4.70f;
            this.baseAttackSpeed = 1.25f;
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 2.00f;
            this.baseAttackSpeed = 1.51f;
            this.bonusAttackReach = 0.00f;
        }
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
            this.baseAttackDamage = 2.00f;
            this.baseAttackSpeed = 1.60f;
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 5.30f;
            this.baseAttackSpeed = 1.22f;
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 6.00f;
            this.baseAttackSpeed = 1.12f;
            this.bonusAttackReach = 0.50f;
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
            this.baseAttackDamage = 6.00f;
            this.baseAttackSpeed = 1.12f;
            this.bonusAttackReach = 0.50f;
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
            this.baseAttackDamage = 7.30f;
            this.baseAttackSpeed = 0.90f;
            this.bonusAttackReach = 1.00f;
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
            this.baseAttackDamage = 2.50f;
            this.baseAttackSpeed = 0.84f;
            this.bonusAttackReach = 2.00f;
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
            this.baseAttackDamage = 7.00f;
            this.baseAttackSpeed = 1.00f;
            this.bonusAttackReach = 0.90f;
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
            this.baseAttackSpeed = 1.40f;
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 4.10f;
            this.baseAttackSpeed = 1.40f;
            this.bonusAttackReach = 0.50f;
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
            this.baseAttackDamage = 3.40f;
            this.baseAttackSpeed = 1.50f;
            this.bonusAttackReach = 0.00f;
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
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 2.00f;
            this.baseAttackSpeed = 1.51f;
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 2.80f;
            this.baseAttackSpeed = 1.28f;
            this.bonusAttackReach = 1.00f;
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
            this.baseAttackSpeed = 1.12f;
            this.bonusAttackReach = 1.90f;
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
            this.baseAttackDamage = 3.00f;
            this.baseAttackSpeed = 1.17f;
            this.bonusAttackReach = 3.00f;
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
            this.baseAttackDamage = 2.80f;
            this.baseAttackSpeed = 1.10f;
            this.bonusAttackReach = 2.00f;
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
            this.baseAttackDamage = 3.30f;
            this.baseAttackSpeed = 1.17f;
            this.bonusAttackReach = 2.00f;
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
            this.baseAttackDamage = 3.20f;
            this.baseAttackSpeed = 1.65f;
            this.bonusAttackReach = 0.00f;
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
            this.baseAttackDamage = 2.50f;
            this.baseAttackSpeed = 1.70f;
            this.bonusAttackReach = 0.00f;
        }
    }
}
