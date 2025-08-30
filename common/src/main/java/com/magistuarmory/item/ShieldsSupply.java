package com.magistuarmory.item;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;

import java.util.function.BiFunction;


public class ShieldsSupply extends ItemsSupply<MedievalShieldItem>
{
	public String shieldName;

	public String woodTexture;
	public String stoneTexture;
	public String ironTexture;
	public String goldTexture;
	public String diamondTexture;
	public String netheriteTexture;

	public String copperTexture;
	public String steelTexture;
	public String silverTexture;
	public String tinTexture;
	public String bronzeTexture;

	public ShieldsSupply(BiFunction<ModItemTier, Item.Properties, RegistrySupplier<MedievalShieldItem>> workshop, String shieldName)
	{
		super(workshop, Item.Properties::new);

		this.shieldName = shieldName;

		this.woodTexture = "entity/" + ModItemTier.WOOD.getMaterialName() + "_" + shieldName;
		this.stoneTexture = "entity/" + ModItemTier.STONE.getMaterialName() + "_" + shieldName;
		this.ironTexture = "entity/" + ModItemTier.IRON.getMaterialName() + "_" + shieldName;
		this.goldTexture = "entity/" + ModItemTier.GOLD.getMaterialName() + "_" + shieldName;
		this.diamondTexture = "entity/" + ModItemTier.DIAMOND.getMaterialName() + "_" + shieldName;
		this.copperTexture = "entity/" + ModItemTier.COPPER.getMaterialName() + "_" + shieldName;
		this.steelTexture = "entity/" + ModItemTier.STEEL.getMaterialName() + "_" + shieldName;
		this.silverTexture = "entity/" + ModItemTier.SILVER.getMaterialName() + "_" + shieldName;
		this.netheriteTexture = "entity/" + ModItemTier.NETHERITE.getMaterialName() + "_" + shieldName;
		this.tinTexture = "entity/" + ModItemTier.TIN.getMaterialName() + "_" + shieldName;
		this.bronzeTexture = "entity/" + ModItemTier.BRONZE.getMaterialName() + "_" + shieldName;
	}
}
