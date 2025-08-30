package com.magistuarmory.config;

import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.ConfigData;

@Config(name = "armor")
public class ArmorConfig implements ConfigData
{
    @ConfigEntry.Gui.CollapsibleObject
    public MinicrownConfig minicrown;
    @ConfigEntry.Gui.CollapsibleObject
    public CrownConfig crown;
    @ConfigEntry.Gui.CollapsibleObject
    public FlowercrownConfig flowercrown;
    @ConfigEntry.Gui.CollapsibleObject
    public KnightConfig knight;
    @ConfigEntry.Gui.CollapsibleObject
    public ArmetConfig armet;
    @ConfigEntry.Gui.CollapsibleObject
    public StechhelmConfig stechhelm;
    @ConfigEntry.Gui.CollapsibleObject
    public JoustingConfig jousting;
    @ConfigEntry.Gui.CollapsibleObject
    public SalletConfig sallet;
    @ConfigEntry.Gui.CollapsibleObject
    public GothicConfig gothic;
    @ConfigEntry.Gui.CollapsibleObject
    public MaximilianHelmetConfig maximilianHelmet;
    @ConfigEntry.Gui.CollapsibleObject
    public MaximilianConfig maximilian;
    @ConfigEntry.Gui.CollapsibleObject
    public ChainmailConfig chainmail;
    @ConfigEntry.Gui.CollapsibleObject
    public KettlehatConfig kettlehat;
    @ConfigEntry.Gui.CollapsibleObject
    public PlatemailConfig platemail;
    @ConfigEntry.Gui.CollapsibleObject
    public BarbuteConfig barbute;
    @ConfigEntry.Gui.CollapsibleObject
    public HalfarmorConfig halfarmor;
    @ConfigEntry.Gui.CollapsibleObject
    public CrusaderConfig crusader;
    @ConfigEntry.Gui.CollapsibleObject
    public BrigandineConfig brigandine;
    @ConfigEntry.Gui.CollapsibleObject
    public GambesonConfig gambeson;
    @ConfigEntry.Gui.CollapsibleObject
    public CeremonialArmetConfig ceremonialArmet;
    @ConfigEntry.Gui.CollapsibleObject
    public CeremonialConfig ceremonial;
    @ConfigEntry.Gui.CollapsibleObject
    public ShishakConfig shishak;
    @ConfigEntry.Gui.CollapsibleObject
    public NormanConfig norman;
    @ConfigEntry.Gui.CollapsibleObject
    public RustedBarbuteConfig rustedBarbute;
    @ConfigEntry.Gui.CollapsibleObject
    public RustedHalfarmorConfig rustedHalfarmor;
    @ConfigEntry.Gui.CollapsibleObject
    public RustedChainmailConfig rustedChainmail;
    @ConfigEntry.Gui.CollapsibleObject
    public RustedKettlehatConfig rustedKettlehat;
    @ConfigEntry.Gui.CollapsibleObject
    public RustedNormanConfig rustedNorman;
    @ConfigEntry.Gui.CollapsibleObject
    public RustedCrusaderConfig rustedCrusader;
    @ConfigEntry.Gui.CollapsibleObject
    public BascinetConfig bascinet;
    @ConfigEntry.Gui.CollapsibleObject
    public XivCenturyKnightConfig xivCenturyKnight;
    @ConfigEntry.Gui.CollapsibleObject
    public WingedHussarChestplateConfig wingedHussarChestplate;
    @ConfigEntry.Gui.CollapsibleObject
    public CuirassierConfig cuirassier;
    @ConfigEntry.Gui.CollapsibleObject
    public KastenbrustConfig kastenbrust;
    @ConfigEntry.Gui.CollapsibleObject
    public GrandBascinetConfig grandBascinet;
    @ConfigEntry.Gui.CollapsibleObject
    public LamellarConfig lamellar;

    public ArmorConfig() {
        this.minicrown = new MinicrownConfig();
        this.crown = new CrownConfig();
        this.flowercrown = new FlowercrownConfig();
        this.knight = new KnightConfig();
        this.armet = new ArmetConfig();
        this.stechhelm = new StechhelmConfig();
        this.jousting = new JoustingConfig();
        this.sallet = new SalletConfig();
        this.gothic = new GothicConfig();
        this.maximilianHelmet = new MaximilianHelmetConfig();
        this.maximilian = new MaximilianConfig();
        this.chainmail = new ChainmailConfig();
        this.kettlehat = new KettlehatConfig();
        this.platemail = new PlatemailConfig();
        this.barbute = new BarbuteConfig();
        this.halfarmor = new HalfarmorConfig();
        this.crusader = new CrusaderConfig();
        this.brigandine = new BrigandineConfig();
        this.gambeson = new GambesonConfig();
        this.ceremonialArmet = new CeremonialArmetConfig();
        this.ceremonial = new CeremonialConfig();
        this.shishak = new ShishakConfig();
        this.norman = new NormanConfig();
        this.rustedBarbute = new RustedBarbuteConfig();
        this.rustedHalfarmor = new RustedHalfarmorConfig();
        this.rustedChainmail = new RustedChainmailConfig();
        this.rustedKettlehat = new RustedKettlehatConfig();
        this.rustedNorman = new RustedNormanConfig();
        this.rustedCrusader = new RustedCrusaderConfig();
        this.bascinet = new BascinetConfig();
        this.xivCenturyKnight = new XivCenturyKnightConfig();
        this.wingedHussarChestplate = new WingedHussarChestplateConfig();
        this.cuirassier = new CuirassierConfig();
        this.kastenbrust = new KastenbrustConfig();
        this.grandBascinet = new GrandBascinetConfig();
        this.lamellar = new LamellarConfig();
    }

    public static class MinicrownConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public MinicrownConfig() {
            this.enabled = true;
            this.toughness = 0.00f;
            this.helmetDurability = 77;
            this.helmetDefense = 2;
        }
    }
    public static class CrownConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public CrownConfig() {
            this.enabled = true;
            this.toughness = 0.00f;
            this.helmetDurability = 77;
            this.helmetDefense = 2;
        }
    }
    public static class FlowercrownConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public FlowercrownConfig() {
            this.enabled = true;
            this.toughness = 0.00f;
            this.helmetDurability = 10;
            this.helmetDefense = 0;
        }
    }
    public static class KnightConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public KnightConfig() {
            this.enabled = true;
            this.toughness = 1.25f;
            this.chestplateDurability = 335;
            this.chestplateDefense = 8;
            this.leggingsDurability = 315;
            this.leggingsDefense = 5;
            this.bootsDurability = 230;
            this.bootsDefense = 2;
        }
    }
    public static class ArmetConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public ArmetConfig() {
            this.enabled = true;
            this.toughness = 1.25f;
            this.helmetDurability = 275;
            this.helmetDefense = 3;
        }
    }
    public static class StechhelmConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public StechhelmConfig() {
            this.enabled = true;
            this.toughness = 2.00f;
            this.helmetDurability = 385;
            this.helmetDefense = 4;
        }
    }
    public static class JoustingConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public JoustingConfig() {
            this.enabled = true;
            this.toughness = 2.00f;
            this.chestplateDurability = 500;
            this.chestplateDefense = 9;
            this.leggingsDurability = 440;
            this.leggingsDefense = 6;
            this.bootsDurability = 345;
            this.bootsDefense = 3;
        }
    }
    public static class SalletConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public SalletConfig() {
            this.enabled = true;
            this.toughness = 1.25f;
            this.helmetDurability = 275;
            this.helmetDefense = 3;
        }
    }
    public static class GothicConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public GothicConfig() {
            this.enabled = true;
            this.toughness = 1.25f;
            this.chestplateDurability = 335;
            this.chestplateDefense = 8;
            this.leggingsDurability = 315;
            this.leggingsDefense = 5;
            this.bootsDurability = 230;
            this.bootsDefense = 2;
        }
    }
    public static class MaximilianHelmetConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public MaximilianHelmetConfig() {
            this.enabled = true;
            this.toughness = 1.80f;
            this.helmetDurability = 385;
            this.helmetDefense = 4;
        }
    }
    public static class MaximilianConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public MaximilianConfig() {
            this.enabled = true;
            this.toughness = 1.80f;
            this.chestplateDurability = 500;
            this.chestplateDefense = 9;
            this.leggingsDurability = 440;
            this.leggingsDefense = 6;
            this.bootsDurability = 345;
            this.bootsDefense = 3;
        }
    }
    public static class ChainmailConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public ChainmailConfig() {
            this.enabled = true;
            this.toughness = 0.00f;
            this.helmetDurability = 205;
            this.helmetDefense = 2;
            this.chestplateDurability = 250;
            this.chestplateDefense = 5;
            this.leggingsDurability = 235;
            this.leggingsDefense = 4;
            this.bootsDurability = 170;
            this.bootsDefense = 1;
        }
    }
    public static class KettlehatConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public KettlehatConfig() {
            this.enabled = true;
            this.toughness = 0.50f;
            this.helmetDurability = 240;
            this.helmetDefense = 2;
        }
    }
    public static class PlatemailConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public PlatemailConfig() {
            this.enabled = true;
            this.toughness = 0.50f;
            this.chestplateDurability = 290;
            this.chestplateDefense = 6;
            this.leggingsDurability = 230;
            this.leggingsDefense = 4;
            this.bootsDurability = 200;
            this.bootsDefense = 3;
        }
    }
    public static class BarbuteConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public BarbuteConfig() {
            this.enabled = true;
            this.toughness = 0.50f;
            this.helmetDurability = 170;
            this.helmetDefense = 2;
        }
    }
    public static class HalfarmorConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        public HalfarmorConfig() {
            this.enabled = true;
            this.toughness = 0.50f;
            this.chestplateDurability = 315;
            this.chestplateDefense = 6;
        }
    }
    public static class CrusaderConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public CrusaderConfig() {
            this.enabled = true;
            this.toughness = 0.60f;
            this.helmetDurability = 220;
            this.helmetDefense = 3;
            this.chestplateDurability = 295;
            this.chestplateDefense = 6;
            this.leggingsDurability = 280;
            this.leggingsDefense = 5;
            this.bootsDurability = 150;
            this.bootsDefense = 1;
        }
    }
    public static class BrigandineConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        public BrigandineConfig() {
            this.enabled = true;
            this.toughness = 0.25f;
            this.chestplateDurability = 265;
            this.chestplateDefense = 5;
        }
    }
    public static class GambesonConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public GambesonConfig() {
            this.enabled = true;
            this.toughness = 0.00f;
            this.helmetDurability = 88;
            this.helmetDefense = 1;
            this.chestplateDurability = 128;
            this.chestplateDefense = 3;
            this.leggingsDurability = 100;
            this.leggingsDefense = 1;
            this.bootsDurability = 100;
            this.bootsDefense = 1;
        }
    }
    public static class CeremonialArmetConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public CeremonialArmetConfig() {
            this.enabled = true;
            this.toughness = 1.25f;
            this.helmetDurability = 275;
            this.helmetDefense = 3;
        }
    }
    public static class CeremonialConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public CeremonialConfig() {
            this.enabled = true;
            this.toughness = 1.25f;
            this.chestplateDurability = 335;
            this.chestplateDefense = 8;
            this.bootsDurability = 230;
            this.bootsDefense = 2;
        }
    }
    public static class ShishakConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public ShishakConfig() {
            this.enabled = true;
            this.toughness = 0.30f;
            this.helmetDurability = 210;
            this.helmetDefense = 2;
        }
    }
    public static class NormanConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public NormanConfig() {
            this.enabled = true;
            this.toughness = 0.20f;
            this.helmetDurability = 190;
            this.helmetDefense = 2;
        }
    }
    public static class RustedBarbuteConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public RustedBarbuteConfig() {
            this.enabled = true;
            this.toughness = 0.00f;
            this.helmetDurability = 90;
            this.helmetDefense = 2;
        }
    }
    public static class RustedHalfarmorConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        public RustedHalfarmorConfig() {
            this.enabled = true;
            this.toughness = 0.00f;
            this.chestplateDurability = 170;
            this.chestplateDefense = 6;
        }
    }
    public static class RustedChainmailConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public RustedChainmailConfig() {
            this.enabled = true;
            this.toughness = 0.00f;
            this.helmetDurability = 100;
            this.helmetDefense = 2;
            this.chestplateDurability = 125;
            this.chestplateDefense = 5;
            this.leggingsDurability = 115;
            this.leggingsDefense = 4;
            this.bootsDurability = 85;
            this.bootsDefense = 1;
        }
    }
    public static class RustedKettlehatConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public RustedKettlehatConfig() {
            this.enabled = true;
            this.toughness = 0.00f;
            this.helmetDurability = 120;
            this.helmetDefense = 2;
        }
    }
    public static class RustedNormanConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public RustedNormanConfig() {
            this.enabled = true;
            this.toughness = 0.00f;
            this.helmetDurability = 85;
            this.helmetDefense = 2;
        }
    }
    public static class RustedCrusaderConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public RustedCrusaderConfig() {
            this.enabled = true;
            this.toughness = 0.00f;
            this.helmetDurability = 110;
            this.helmetDefense = 3;
            this.chestplateDurability = 150;
            this.chestplateDefense = 6;
            this.bootsDurability = 75;
            this.bootsDefense = 1;
        }
    }
    public static class BascinetConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public BascinetConfig() {
            this.enabled = true;
            this.toughness = 1.25f;
            this.helmetDurability = 250;
            this.helmetDefense = 3;
        }
    }
    public static class XivCenturyKnightConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public XivCenturyKnightConfig() {
            this.enabled = true;
            this.toughness = 1.25f;
            this.chestplateDurability = 320;
            this.chestplateDefense = 7;
            this.leggingsDurability = 300;
            this.leggingsDefense = 5;
            this.bootsDurability = 210;
            this.bootsDefense = 2;
        }
    }
    public static class WingedHussarChestplateConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        public WingedHussarChestplateConfig() {
            this.enabled = true;
            this.toughness = 0.50f;
            this.chestplateDurability = 360;
            this.chestplateDefense = 6;
        }
    }
    public static class CuirassierConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public CuirassierConfig() {
            this.enabled = true;
            this.toughness = 0.50f;
            this.helmetDurability = 170;
            this.helmetDefense = 2;
            this.chestplateDurability = 315;
            this.chestplateDefense = 6;
            this.leggingsDurability = 100;
            this.leggingsDefense = 1;
            this.bootsDurability = 150;
            this.bootsDefense = 1;
        }
    }
    public static class KastenbrustConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int leggingsDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public KastenbrustConfig() {
            this.enabled = true;
            this.toughness = 1.25f;
            this.chestplateDurability = 335;
            this.chestplateDefense = 8;
            this.leggingsDurability = 315;
            this.leggingsDefense = 5;
            this.bootsDurability = 230;
            this.bootsDefense = 2;
        }
    }
    public static class GrandBascinetConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        public GrandBascinetConfig() {
            this.enabled = true;
            this.toughness = 1.25f;
            this.helmetDurability = 275;
            this.helmetDefense = 3;
        }
    }
    public static class LamellarConfig
    {
        @ConfigEntry.Gui.RequiresRestart
        public boolean enabled;
        @ConfigEntry.Gui.RequiresRestart
        public float toughness;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int helmetDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int chestplateDefense;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDurability;
        @ConfigEntry.Gui.RequiresRestart
        public int bootsDefense;
        public LamellarConfig() {
            this.enabled = true;
            this.toughness = 0.30f;
            this.helmetDurability = 250;
            this.helmetDefense = 6;
            this.chestplateDurability = 250;
            this.chestplateDefense = 6;
            this.bootsDurability = 200;
            this.bootsDefense = 2;
        }
    }
}
