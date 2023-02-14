package com.magistuarmory.client.render.model;

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
        PAVESE,
        ROUND_SHIELD,
        ELLIPTICAL_SHIELD,
        TARTSCHE,
        RONDACHE,
        KITE_SHIELD,
        BUCKLER,
        TARGET,
        CORRUPTED_ROUND_SHIELD,
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
    public static MedievalShieldModel PAVESE = new PaviseModel(PaviseModel.createLayer().bakeRoot());
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
            entry(ShieldEnum.PAVESE, PAVESE),
            entry(ShieldEnum.ROUND_SHIELD, ROUND_SHIELD),
            entry(ShieldEnum.ELLIPTICAL_SHIELD, ELLIPTICAL_SHIELD),
            entry(ShieldEnum.TARTSCHE, TARTSCHE),
            entry(ShieldEnum.RONDACHE, RONDACHE),
            entry(ShieldEnum.KITE_SHIELD, KITE_SHIELD),
            entry(ShieldEnum.BUCKLER, BUCKLER),
            entry(ShieldEnum.TARGET, TARGET),
            entry(ShieldEnum.CORRUPTED_ROUND_SHIELD, CORRUPTED_ROUND_SHIELD)
    );

    public static final SurcoatModel<LivingEntity> SURCOAT = new SurcoatModel<>(SurcoatModel.createLayer().bakeRoot());
    public static final CaparisonModel<Horse> CAPARISON = new CaparisonModel<>(CaparisonModel.createLayer().bakeRoot());

}
