package com.magistuarmory.item;

import dev.architectury.registry.registries.RegistrySupplier;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.item.Item;
import java.util.ArrayList;
import java.util.function.BiFunction;


public class ItemsSupply<T extends Item>
{
	public RegistrySupplier<T> wood;
	public RegistrySupplier<T> stone;
	public RegistrySupplier<T> iron;
	public RegistrySupplier<T> gold;
	public RegistrySupplier<T> diamond;

	public RegistrySupplier<T> copper;
	public RegistrySupplier<T> steel;
	public RegistrySupplier<T> silver;
	public RegistrySupplier<T> netherite;
	public RegistrySupplier<T> tin;
	public RegistrySupplier<T> bronze;

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
