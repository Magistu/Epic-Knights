package com.magistuarmory.client.render.model;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.api.client.render.model.ModModelsProvider;
import com.magistuarmory.client.render.model.armor.*;
import com.magistuarmory.client.render.model.block.PaviseBlockModel;
import com.magistuarmory.client.render.model.decoration.*;
import com.magistuarmory.client.render.model.item.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;


@Environment(EnvType.CLIENT)
public class ModModels extends ModModelsProvider
{
	public static final ModModels INSTANCE = new ModModels(EpicKnights.ID);
	
	// Decorations
	public static final LayerDefinition BULLHORNS = HornsModel.createLayer();
	public static final LayerDefinition TORSE_AND_MANTLE = TorseAndMantleModel.createLayer();
	public static final LayerDefinition CROWN = CrownModel.createLayer();
	public static final LayerDefinition FLOWERCROWN = FlowercrownModel.createLayer();
	public static final LayerDefinition ECRANCHE = EcrancheModel.createLayer();
	public static final LayerDefinition RONDEL = RondelModel.createLayer();
	public static final LayerDefinition HOOD = HoodModel.createLayer();
	public static final LayerDefinition MINICROWN = MiniCrownModel.createLayer();
	public static final LayerDefinition TORSE = TorseModel.createLayer();
	public static final LayerDefinition BIG_PLUME = BigPlumeModel.createLayer();
	public static final LayerDefinition PLUME_LEFT = PlumeLeftModel.createLayer();
	public static final LayerDefinition PLUME_MIDDLE = PlumeMiddleModel.createLayer();
	public static final LayerDefinition PLUME_RIGHT = PlumeRightModel.createLayer();
	public static final LayerDefinition TOP_DECORATION = TopDecorationModel.createLayer();
	public static final LayerDefinition TOP_DECORATION_2 = TopDecoration2Model.createLayer();
	public static final LayerDefinition SURCOAT = SurcoatModel.createLayer();
	public static final LayerDefinition CAPARISON = CaparisonModel.createLayer();
	
	public static final ModelLayerLocation TORSE_AND_MANTLE_LOCATION = INSTANCE.addDecorationModel("torse_and_mantle", () -> TORSE_AND_MANTLE);
	public static final ModelLayerLocation CROWN_LOCATION = INSTANCE.addDecorationModel("crown", () -> CROWN);
	public static final ModelLayerLocation FLOWERCROWN_LOCATION = INSTANCE.addDecorationModel("flowercrown", () -> FLOWERCROWN);
	public static final ModelLayerLocation MINICROWN_LOCATION = INSTANCE.addDecorationModel("minicrown", () -> MINICROWN);
	public static final ModelLayerLocation TORSE_LOCATION = INSTANCE.addDecorationModel("torse", () -> TORSE);
	public static final ModelLayerLocation BIG_PLUME_LOCATION = INSTANCE.addDecorationModel("big_plume", () -> BIG_PLUME);
	public static final ModelLayerLocation PLUME_LEFT_LOCATION = INSTANCE.addDecorationModel("plume_left", () -> PLUME_LEFT);
	public static final ModelLayerLocation PLUME_MIDDLE_LOCATION = INSTANCE.addDecorationModel("plume_middle", () -> PLUME_MIDDLE);
	public static final ModelLayerLocation PLUME_RIGHT_LOCATION = INSTANCE.addDecorationModel("plume_right", () -> PLUME_RIGHT);
	public static final ModelLayerLocation HOOD_LOCATION = INSTANCE.addDecorationModel("hood", () -> HOOD);
	public static final ModelLayerLocation ECRANCHE_LOCATION = INSTANCE.addDecorationModel("ecranche", () -> ECRANCHE);
	public static final ModelLayerLocation RONDEL_LOCATION = INSTANCE.addDecorationModel("rondel", () -> RONDEL);
	public static final ModelLayerLocation DEMON_HORNS_LOCATION = INSTANCE.addDecorationModel("demon_horns", () -> TOP_DECORATION_2);
	public static final ModelLayerLocation FEATHERS_LOCATION = INSTANCE.addDecorationModel("feathers", () -> TOP_DECORATION_2);
	public static final ModelLayerLocation GRIFFIN_LOCATION = INSTANCE.addDecorationModel("griffin", () -> TOP_DECORATION_2);
	public static final ModelLayerLocation BULLHORNS_LOCATION = INSTANCE.addDecorationModel("bullhorns", () -> TOP_DECORATION);
	public static final ModelLayerLocation UNICORN_LOCATION = INSTANCE.addDecorationModel("unicorn", () -> TOP_DECORATION);
	public static final ModelLayerLocation DRAGON_LOCATION = INSTANCE.addDecorationModel("dragon", () -> TOP_DECORATION);
	public static final ModelLayerLocation TWO_PLUMES_LOCATION = INSTANCE.addDecorationModel("two_plumes", () -> TOP_DECORATION);
	public static final ModelLayerLocation ANTLERS_LOCATION = INSTANCE.addDecorationModel("antlers", () -> TOP_DECORATION);
	public static final ModelLayerLocation BEAR_LOCATION = INSTANCE.addDecorationModel("bear", () -> TOP_DECORATION);
	public static final ModelLayerLocation LILY_LOCATION = INSTANCE.addDecorationModel("lily", () -> TOP_DECORATION);
	public static final ModelLayerLocation LION_LOCATION = INSTANCE.addDecorationModel("lion", () -> TOP_DECORATION);
	public static final ModelLayerLocation VIKING_HORNS_LOCATION = INSTANCE.addDecorationModel("viking_horns", () -> TOP_DECORATION);
	public static final ModelLayerLocation GAZELLE_HORNS_LOCATION = INSTANCE.addDecorationModel("gazelle_horns", () -> TOP_DECORATION);
	public static final ModelLayerLocation DUCK_LOCATION = INSTANCE.addDecorationModel("duck", () -> TOP_DECORATION);
	public static final ModelLayerLocation SPIKE_LOCATION = INSTANCE.addDecorationModel("spike", () -> TOP_DECORATION);
	public static final ModelLayerLocation HORSE_LOCATION = INSTANCE.addDecorationModel("horse", () -> TOP_DECORATION);
	public static final ModelLayerLocation SURCOAT_LOCATION = INSTANCE.addDecorationModel("surcoat", () -> SURCOAT);
	public static final ModelLayerLocation CAPARISON_LOCATION = INSTANCE.addDecorationModel("caparison", () -> CAPARISON);

	// Armor
	public static final ModelLayerLocation CROWN_ARMOR_LOCATION = INSTANCE.addArmorModel("crown", CrownArmorModel::createLayer);
	public static final ModelLayerLocation FLOWERCROWN_ARMOR_LOCATION = INSTANCE.addArmorModel("flowercrown", () -> FLOWERCROWN);
	public static final ModelLayerLocation MINICROWN_ARMOR_LOCATION = INSTANCE.addArmorModel("minicrown", () -> MINICROWN);
	public static final ModelLayerLocation ARMET_LOCATION = INSTANCE.addArmorModel("armet", ArmetModel::createLayer);
	public static final ModelLayerLocation STECHHELM_LOCATION = INSTANCE.addArmorModel("stechhelm", StechhelmModel::createLayer);
	public static final ModelLayerLocation SALLET_LOCATION = INSTANCE.addArmorModel("sallet", SalletModel::createLayer);
	public static final ModelLayerLocation MAXIMILIAN_HELMET_LOCATION = INSTANCE.addArmorModel("maximilian_helmet", MaximilianHelmetModel::createLayer);
	public static final ModelLayerLocation KETTLEHAT_LOCATION = INSTANCE.addArmorModel("kettlehat", KettlehatModel::createLayer);
	public static final ModelLayerLocation BARBUTE_LOCATION = INSTANCE.addArmorModel("barbute", BarbuteModel::createLayer);
	public static final ModelLayerLocation BASCINET_LOCATION = INSTANCE.addArmorModel("bascinet", BascinetModel::createLayer);
	public static final ModelLayerLocation GRAND_BASCINET_LOCATION = INSTANCE.addArmorModel("grand_bascinet", GrandBascinetModel::createLayer);
	public static final ModelLayerLocation WINGED_HUSSAR_CHESTPLATE_LOCATION = INSTANCE.addArmorModel("wingedhussarchestplate", WingedHussarChestplateModel::createLayer);
	public static final ModelLayerLocation CRUSADER_LOCATION = INSTANCE.addArmorModel("crusader", CrusaderModel::createLayer);

	// Shields
	public static final ModelLayerLocation HEATER_SHIELD = INSTANCE.addModel("heatershield", HeaterShieldModel::createLayer);
	public static final ModelLayerLocation PAVISE = INSTANCE.addModel("pavese", PaviseModel::createLayer);
	public static final ModelLayerLocation ROUND_SHIELD = INSTANCE.addModel("roundshield", RoundShieldModel::createLayer);
	public static final ModelLayerLocation ELLIPTICAL_SHIELD = INSTANCE.addModel("ellipticalshield", EllipticalShieldModel::createLayer);
	public static final ModelLayerLocation TARTSCHE = INSTANCE.addModel("tartsche", TartscheModel::createLayer);
	public static final ModelLayerLocation RONDACHE = INSTANCE.addModel("rondache", RondacheModel::createLayer);
	public static final ModelLayerLocation KITE_SHIELD = INSTANCE.addModel("kiteshield", KiteShieldModel::createLayer);
	public static final ModelLayerLocation BUCKLER = INSTANCE.addModel("buckler", BucklerModel::createLayer);
	public static final ModelLayerLocation TARGET = INSTANCE.addModel("target", TargeModel::createLayer);
	public static final ModelLayerLocation CORRUPTED_ROUND_SHIELD = INSTANCE.addModel("corruptedroundshield", CorruptedRoundShieldModel::createLayer);
	
	// Blocks
	public static final ModelLayerLocation PAVISE_BLOCK_LOCATION = INSTANCE.addModel("pavise_block", PaviseBlockModel::createLayer);

	public ModModels(String modId)
	{
		super(modId);
	}
}
