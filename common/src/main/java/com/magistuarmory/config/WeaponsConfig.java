package com.magistuarmory.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "weapons")
public class WeaponsConfig implements ConfigData
{
    @ConfigEntry.Gui.CollapsibleObject
    public StilettoConfig stiletto = new StilettoConfig();
    public static class StilettoConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 2.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.6f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public ShortSwordConfig shortSword = new ShortSwordConfig();
    public static class ShortSwordConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 2.5f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.7f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public KatzbalgerConfig katzbalger = new KatzbalgerConfig();
    public static class KatzbalgerConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 3.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.65f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public PikeConfig pike = new PikeConfig();
    public static class PikeConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 3.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.07f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 3.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public RanseurConfig ranseur = new RanseurConfig();
    public static class RanseurConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 3.1f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.07f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 2.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public AhlspiessConfig ahlspiess = new AhlspiessConfig();
    public static class AhlspiessConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 4.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.28f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 1.2f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public GiantLanceConfig giantLance = new GiantLanceConfig();
    public static class GiantLanceConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 2.5f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 0.84f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 2.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public BastardSwordConfig bastardSword = new BastardSwordConfig();
    public static class BastardSwordConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 4.25f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.4f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public EstocConfig estoc = new EstocConfig();
    public static class EstocConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 4.1f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.4f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.5f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public ClaymoreConfig claymore = new ClaymoreConfig();
    public static class ClaymoreConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 5.4f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.22f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public ZweihanderConfig zweihander = new ZweihanderConfig();
    public static class ZweihanderConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 6.5f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.12f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.5f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public FlameBladedSwordConfig flameBladedSword = new FlameBladedSwordConfig();
    public static class FlameBladedSwordConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 6.4f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.12f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.5f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public LochaberAxeConfig lochaberAxe = new LochaberAxeConfig();
    public static class LochaberAxeConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 7.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 1.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public ConcaveEdgedHalberdConfig concaveEdgedHalberd = new ConcaveEdgedHalberdConfig();
    public static class ConcaveEdgedHalberdConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 8.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 0.9f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 2.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public HeavyMaceConfig heavyMace = new HeavyMaceConfig();
    public static class HeavyMaceConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 4.5f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.15f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public HeavyWarHammerConfig heavyWarHammer = new HeavyWarHammerConfig();
    public static class HeavyWarHammerConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 5.2f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.05f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public LucerneHammerConfig lucerneHammer = new LucerneHammerConfig();
    public static class LucerneHammerConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 4.8f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.1f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public MorningstarConfig morningstar = new MorningstarConfig();
    public static class MorningstarConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 5.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.25f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public FlailConfig flail = new FlailConfig();
    public static class FlailConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 6.2f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.1f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public GuisarmeConfig guisarme = new GuisarmeConfig();
    public static class GuisarmeConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 3.15f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.02f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 1.9f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public BlacksmithHammerConfig blacksmithHammer = new BlacksmithHammerConfig();
    public static class BlacksmithHammerConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 5.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public BarbedClubConfig barbedClub = new BarbedClubConfig();
    public static class BarbedClubConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 5.6f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public PitchforkConfig pitchfork = new PitchforkConfig();
    public static class PitchforkConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 2.8f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 1.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public NobleSwordConfig nobleSword = new NobleSwordConfig();
    public static class NobleSwordConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 4.25f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.51f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public RustedBastardSwordConfig rustedBastardSword = new RustedBastardSwordConfig();
    public static class RustedBastardSwordConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 2.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.51f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public RustedHeavyMaceConfig rustedHeavyMace = new RustedHeavyMaceConfig();
    public static class RustedHeavyMaceConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 2.0f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.51f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public ClubConfig club = new ClubConfig();
    public static class ClubConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 11.3f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 0.8f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public MesserSwordConfig messerSword = new MesserSwordConfig();
    public static class MesserSwordConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled = true;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackDamage = 3.8f;
        @ConfigEntry.Gui.RequiresRestart
        public float baseAttackSpeed = 1.56f;
        @ConfigEntry.Gui.RequiresRestart
        public float bonusAttackReach = 0.0f;
    }
}
