package com.magistuarmory.client.render.model;

import com.magistuarmory.client.render.model.armor.*;
import com.magistuarmory.client.render.model.block.PaviseBlockModel;
import com.magistuarmory.client.render.model.decoration.*;
import com.magistuarmory.client.render.model.item.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.horse.Horse;

import static java.util.Map.entry;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class Models
{
    public enum ArmorEnum
    {
        ARMET,
        STECHHELM,
        SALLET,
        MAXIMILIAN_HELMET,
        KETTLEHAT,
        BARBUTE,
        BASCINET,
        GRAND_BASCINET,
        WINGED_HUSSAR_CHESTPLATE,
        ARMOR,
        ARMOR_LEGGINGS,
    }

    public enum ShieldEnum
    {
        HEATER_SHIELD,
	    PAVISE,
        ROUND_SHIELD,
        ELLIPTICAL_SHIELD,
        TARTSCHE,
        RONDACHE,
        KITE_SHIELD,
        BUCKLER,
        TARGET,
        CORRUPTED_ROUND_SHIELD,
    }
    
    public enum ArmorDecorationEnum
    {
        SURCOAT,
        HORNS,
        TORSE_AND_MANTLE,
        CROWN,
        FLOWERCROWN,
        ECRANCHE,
        RONDEL,
        HOOD,
        TOP_DECORATION,
        TOP_DECORATION_2,
        MINICROWN,
        TORSE,
        PLUME_LEFT,
        PLUME_MIDDLE,
        PLUME_RIGHT,
    }

    public static final HumanoidModel<LivingEntity> ARMET = new HumanoidModel<>(ArmetModel.createModel());
    public static final HumanoidModel<LivingEntity> STECHHELM = new HumanoidModel<>(StechhelmModel.createModel());
    public static final HumanoidModel<LivingEntity> SALLET = new HumanoidModel<>(SalletModel.createModel());
    public static final HumanoidModel<LivingEntity> MAXIMILIAN_HELMET = new HumanoidModel<>(MaximilianHelmetModel.createModel());
    public static final HumanoidModel<LivingEntity> KETTLEHAT = new HumanoidModel<>(KettlehatModel.createModel());
    public static final HumanoidModel<LivingEntity> BARBUTE = new HumanoidModel<>(BarbuteModel.createModel());
    public static final HumanoidModel<LivingEntity> BASCINET = new HumanoidModel<>(BascinetModel.createModel());
    public static final HumanoidModel<LivingEntity> GRAND_BASCINET = new HumanoidModel<>(GrandBascinetModel.createModel());
    public static final HumanoidModel<LivingEntity> WINGED_HUSSAR_CHESTPLATE = new HumanoidModel<>(WingedHussarChestplateModel.createModel());

    public static final HumanoidModel<LivingEntity> ARMOR = new HumanoidModel<>(LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(1.0F), 0.0F), 64, 32).bakeRoot());
    public static final HumanoidModel<LivingEntity> ARMOR_LEGGINGS = new HumanoidModel<>(LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.5F), 0.0F), 64, 32).bakeRoot());

    public static final Map<ArmorEnum, HumanoidModel<? extends LivingEntity>> ARMOR_MAP = Map.ofEntries(
            entry(ArmorEnum.ARMET, ARMET),
            entry(ArmorEnum.STECHHELM, STECHHELM),
            entry(ArmorEnum.SALLET, SALLET),
            entry(ArmorEnum.MAXIMILIAN_HELMET, MAXIMILIAN_HELMET),
            entry(ArmorEnum.KETTLEHAT, KETTLEHAT),
            entry(ArmorEnum.BARBUTE, BARBUTE),
            entry(ArmorEnum.BASCINET, BASCINET),
            entry(ArmorEnum.GRAND_BASCINET, GRAND_BASCINET),
            entry(ArmorEnum.WINGED_HUSSAR_CHESTPLATE, WINGED_HUSSAR_CHESTPLATE),
            entry(ArmorEnum.ARMOR, ARMOR),
            entry(ArmorEnum.ARMOR_LEGGINGS, ARMOR_LEGGINGS)
    );

    public static MedievalShieldModel HEATER_SHIELD = new HeaterShieldModel(HeaterShieldModel.createLayer().bakeRoot());
    public static MedievalShieldModel PAVISE = new PaviseModel(PaviseModel.createLayer().bakeRoot());
    public static MedievalShieldModel ROUND_SHIELD = new RoundShieldModel(RoundShieldModel.createLayer().bakeRoot());
    public static MedievalShieldModel ELLIPTICAL_SHIELD = new EllipticalShieldModel(EllipticalShieldModel.createLayer().bakeRoot());
    public static MedievalShieldModel TARTSCHE = new TartscheModel(TartscheModel.createLayer().bakeRoot());
    public static MedievalShieldModel RONDACHE = new RondacheModel(RondacheModel.createLayer().bakeRoot());
    public static MedievalShieldModel KITE_SHIELD = new KiteShieldModel(KiteShieldModel.createLayer().bakeRoot());
    public static MedievalShieldModel BUCKLER = new BucklerModel(BucklerModel.createLayer().bakeRoot());
    public static MedievalShieldModel TARGET = new TargeModel(TargeModel.createLayer().bakeRoot());
    public static MedievalShieldModel CORRUPTED_ROUND_SHIELD = new CorruptedRoundShieldModel(CorruptedRoundShieldModel.createLayer().bakeRoot());

    public static final Map<ShieldEnum, MedievalShieldModel> SHIELD_MAP = Map.ofEntries(
            entry(ShieldEnum.HEATER_SHIELD, HEATER_SHIELD),
            entry(ShieldEnum.PAVISE, PAVISE),
            entry(ShieldEnum.ROUND_SHIELD, ROUND_SHIELD),
            entry(ShieldEnum.ELLIPTICAL_SHIELD, ELLIPTICAL_SHIELD),
            entry(ShieldEnum.TARTSCHE, TARTSCHE),
            entry(ShieldEnum.RONDACHE, RONDACHE),
            entry(ShieldEnum.KITE_SHIELD, KITE_SHIELD),
            entry(ShieldEnum.BUCKLER, BUCKLER),
            entry(ShieldEnum.TARGET, TARGET),
            entry(ShieldEnum.CORRUPTED_ROUND_SHIELD, CORRUPTED_ROUND_SHIELD)
    );

    public static class ArmorDecorations<T extends LivingEntity>
    {
        public final SurcoatModel<T> surcoat;
        public final HornsModel<T> horns;
        public final TorseAndMantleModel<T> torseAndMantle;
        public final CrownModel<T> crown;
        public final FlowercrownModel<T> flowercrown;
        public final EcrancheModel<T> ecranche;
        public final RondelModel<T> rondel;
        public final HoodModel<T> hood;
        public final TopDecorationModel<T> topDecoration;
        public final TopDecoration2Model<T> topDecoration2;
        public final MiniCrownModel<T> minicrown;
        public final TorseModel<T> torse;
        public final PlumeLeftModel<T> plumeLeft;
        public final PlumeMiddleModel<T> plumeMiddle;
        public final PlumeRightModel<T> plumeRight;

        final Map<String, ArmorDecorationModel<T>> map;

        public ArmorDecorations()
        {
            this.surcoat = new SurcoatModel<>(SurcoatModel.createLayer().bakeRoot());
            this.horns = new HornsModel<>(HornsModel.createLayer().bakeRoot());
            this.torseAndMantle = new TorseAndMantleModel<>(TorseAndMantleModel.createLayer().bakeRoot());
            this.crown = new CrownModel<>(CrownModel.createLayer().bakeRoot());
            this.flowercrown = new FlowercrownModel<>(FlowercrownModel.createLayer().bakeRoot());
            this.ecranche = new EcrancheModel<>(EcrancheModel.createLayer().bakeRoot());
            this.rondel = new RondelModel<>(RondelModel.createLayer().bakeRoot());
            this.hood = new HoodModel<>(HoodModel.createLayer().bakeRoot());
            this.topDecoration = new TopDecorationModel<>(TopDecorationModel.createLayer().bakeRoot());
            this.topDecoration2 = new TopDecoration2Model<>(TopDecoration2Model.createLayer().bakeRoot());
            this.minicrown = new MiniCrownModel<>(MiniCrownModel.createLayer().bakeRoot());
            this.torse = new TorseModel<>(TorseModel.createLayer().bakeRoot());
            this.plumeLeft = new PlumeLeftModel<>(PlumeLeftModel.createLayer().bakeRoot());
            this.plumeMiddle = new PlumeMiddleModel<>(PlumeMiddleModel.createLayer().bakeRoot());
            this.plumeRight = new PlumeRightModel<>(PlumeRightModel.createLayer().bakeRoot());

            this.map = Map.ofEntries(
                    entry(ArmorDecorationEnum.SURCOAT.toString().toLowerCase(), this.surcoat),
                    entry(ArmorDecorationEnum.HORNS.toString().toLowerCase(), this.horns),
                    entry(ArmorDecorationEnum.TORSE_AND_MANTLE.toString().toLowerCase(), this.torseAndMantle),
                    entry(ArmorDecorationEnum.CROWN.toString().toLowerCase(), this.crown),
                    entry("flowercrown", this.flowercrown),
                    entry(ArmorDecorationEnum.ECRANCHE.toString().toLowerCase(), this.ecranche),
                    entry(ArmorDecorationEnum.RONDEL.toString().toLowerCase(), this.rondel),
                    entry(ArmorDecorationEnum.HOOD.toString().toLowerCase(), this.hood),
                    entry(ArmorDecorationEnum.TORSE.toString().toLowerCase(), this.torse),
                    entry("demon_horns", this.topDecoration2),
                    entry("griffin", this.topDecoration2),
                    entry("feathers", this.topDecoration2),
                    entry(ArmorDecorationEnum.MINICROWN.toString().toLowerCase(), this.minicrown),
                    entry(ArmorDecorationEnum.PLUME_LEFT.toString().toLowerCase(), this.plumeLeft),
                    entry(ArmorDecorationEnum.PLUME_MIDDLE.toString().toLowerCase(), this.plumeMiddle),
                    entry(ArmorDecorationEnum.PLUME_RIGHT.toString().toLowerCase(), this.plumeRight)
            );
        }
        
        public ArmorDecorationModel<T> getModelByName(String name)
        {
            return this.map.getOrDefault(name, this.topDecoration);
        }
    }
    
    public static final CaparisonModel<Horse> CAPARISON = new CaparisonModel<>(CaparisonModel.createLayer().bakeRoot());

    public static final LayerDefinition PAVISE_BLOCK_LAYER = PaviseBlockModel.createLayer();
    public static final PaviseBlockModel PAVISE_BLOCK = new PaviseBlockModel(PAVISE_BLOCK_LAYER.bakeRoot());
}
