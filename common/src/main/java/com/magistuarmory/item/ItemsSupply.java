package com.magistuarmory.item;

import dev.architectury.registry.registries.RegistrySupplier;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.minecraft.world.item.Item;
import java.util.ArrayList;
import java.util.function.BiFunction;


public class ItemsSupply<T extends Item>
{
	public @Nullable RegistrySupplier<T> wood;
	public @Nullable RegistrySupplier<T> stone;
	public @Nullable RegistrySupplier<T> iron;
	public @Nullable RegistrySupplier<T> gold;
	public @Nullable RegistrySupplier<T> diamond;

	public @Nullable RegistrySupplier<T> copper;
	public @Nullable RegistrySupplier<T> steel;
	public @Nullable RegistrySupplier<T> silver;
	public @Nullable RegistrySupplier<T> netherite;
	public @Nullable RegistrySupplier<T> tin;
	public @Nullable RegistrySupplier<T> bronze;

	public ItemsSupply(BiFunction<ModItemTier, Item.Properties, RegistrySupplier<T>> workshop, Item.Properties prop)
	{
		this.wood = workshop.apply(ModItemTier.WOOD, prop);
		this.stone = workshop.apply(ModItemTier.STONE, prop);
		this.iron = workshop.apply(ModItemTier.IRON, prop);
		this.gold = workshop.apply(ModItemTier.GOLD, prop);
		this.diamond = workshop.apply(ModItemTier.DIAMOND, prop);
		this.netherite = workshop.apply(ModItemTier.NETHERITE, prop.fireResistant());

		this.copper = workshop.apply(ModItemTier.COPPER, prop);
		this.steel = workshop.apply(ModItemTier.STEEL, prop);
		this.silver = workshop.apply(ModItemTier.SILVER, prop);
		this.tin = workshop.apply(ModItemTier.TIN, prop);
		this.bronze = workshop.apply(ModItemTier.BRONZE, prop);
	}

	public ArrayList<RegistrySupplier<T>> get()
	{
		ArrayList<RegistrySupplier<T>> suppliers = new ArrayList<>();

		suppliers.add(this.iron);
		suppliers.add(this.wood);
		suppliers.add(this.stone);
		suppliers.add(this.gold);
		suppliers.add(this.diamond);
		suppliers.add(this.copper);
		suppliers.add(this.steel);
		suppliers.add(this.silver);
		suppliers.add(this.netherite);
		suppliers.add(this.tin);
		suppliers.add(this.bronze);

		return suppliers;
	}
}
