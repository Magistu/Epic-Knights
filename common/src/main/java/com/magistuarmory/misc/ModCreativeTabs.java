package com.magistuarmory.misc;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.item.ArmorDecoration;
import com.magistuarmory.item.ModItems;
import dev.architectury.platform.Platform;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.DeferredSupplier;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModCreativeTabs
{
	static Supplier<ItemStack> ARMET_WITH_PLUME_SUPPLIER = () -> ModItems.getDecoratedStack(ModItems.ARMET, ModItems.BIG_PLUME_DECORATION);
	static Supplier<ItemStack> CEREMONIAL_ARMET_WITH_PLUME_SUPPLIER = () -> ModItems.getDecoratedStack(ModItems.CEREMONIAL_ARMET, ModItems.BIG_PLUME_DECORATION);

	static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(EpicKnights.ID, Registries.CREATIVE_MODE_TAB);

	static final RegistrySupplier<CreativeModeTab> ARMOR = Platform.isFabric() ? TABS.register("armor", () -> CreativeTabRegistry.create(
		Component.translatable("itemGroup." + EpicKnights.ID + ".armor"), ARMET_WITH_PLUME_SUPPLIER)) : createTab("armor", ModItems.ARMET);
	static final RegistrySupplier<CreativeModeTab> WEAPONS = createTab("weapons", ModItems.FLAME_BLADED_SWORDS.iron);
	static final RegistrySupplier<CreativeModeTab> PARTICULAR_WEAPONS = createTab("particular_weapons", ModItems.NOBLE_SWORD);
	static final RegistrySupplier<CreativeModeTab> SHIELDS = createTab("shields", ModItems.HEATER_SHIELDS.iron);
	static final RegistrySupplier<CreativeModeTab> RUSTED = createTab("rusted", ModItems.RUSTED_BASTARD_SWORD);
	static final RegistrySupplier<CreativeModeTab> ARMOR_DECORATIONS = createTab("armor_decorations", ModItems.CROWN_DECORATION);

	public static final ResourceKey<CreativeModeTab> ARMOR_RESOURCE_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "armor"));
	public static final ResourceKey<CreativeModeTab> WEAPONS_RESOURCE_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "weapons"));
	public static final ResourceKey<CreativeModeTab> PARTICULAR_WEAPONS_RESOURCE_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "particular_weapons"));
	public static final ResourceKey<CreativeModeTab> SHIELDS_RESOURCE_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "shields"));
	public static final ResourceKey<CreativeModeTab> RUSTED_RESOURCE_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "rusted"));
	public static final ResourceKey<CreativeModeTab> ARMOR_DECORATIONS_RESOURCE_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "armor_decorations"));
	public static final ResourceKey<CreativeModeTab> INGRIDIENTS_RESOURCE_KEY = CreativeModeTabs.INGREDIENTS;

	public static RegistrySupplier<CreativeModeTab> createTab(String name, @Nullable RegistrySupplier<? extends Item> supplier)
	{
		return TABS.register(name, () -> CreativeTabRegistry.create(
				Component.translatable("itemGroup." + EpicKnights.ID + "." + name),
				() -> supplier == null ? ItemStack.EMPTY : new ItemStack(getIconItem(supplier))));
	}

	public static Item getIconItem(RegistrySupplier<? extends Item> supplier)
	{
		if (supplier != null && supplier.get() != null)
			return supplier.get();
		return Items.BARRIER;
	}

	public static void init()
	{
		TABS.register();
		
		if (Platform.isFabric())
			appendStack(ARMOR, ARMET_WITH_PLUME_SUPPLIER);
		else
			append(ARMOR, ModItems.ARMET);
		append(ARMOR, ModItems.KNIGHT_CHESTPLATE);
		append(ARMOR, ModItems.KNIGHT_LEGGINGS);
		append(ARMOR, ModItems.KNIGHT_BOOTS);
		append(ARMOR, ModItems.STECHHELM);
		append(ARMOR, ModItems.JOUSTING_CHESTPLATE);
		append(ARMOR, ModItems.JOUSTING_LEGGINGS);
		append(ARMOR, ModItems.JOUSTING_BOOTS);
		append(ARMOR, ModItems.SALLET);
		append(ARMOR, ModItems.GOTHIC_CHESTPLATE);
		append(ARMOR, ModItems.GOTHIC_LEGGINGS);
		append(ARMOR, ModItems.GOTHIC_BOOTS);
		append(ARMOR, ModItems.MAXIMILIAN_HELMET);
		append(ARMOR, ModItems.MAXIMILIAN_CHESTPLATE);
		append(ARMOR, ModItems.MAXIMILIAN_LEGGINGS);
		append(ARMOR, ModItems.MAXIMILIAN_BOOTS);
		append(ARMOR, ModItems.CHAINMAIL_HELMET);
		append(ARMOR, ModItems.CHAINMAIL_CHESTPLATE);
		append(ARMOR, ModItems.CHAINMAIL_LEGGINGS);
		append(ARMOR, ModItems.CHAINMAIL_BOOTS);
		append(ARMOR, ModItems.KETTLEHAT);
		append(ARMOR, ModItems.PLATEMAIL_CHESTPLATE);
		append(ARMOR, ModItems.PLATEMAIL_LEGGINGS);
		append(ARMOR, ModItems.PLATEMAIL_BOOTS);
		append(ARMOR, ModItems.BARBUTE);
		append(ARMOR, ModItems.HALFARMOR_CHESTPLATE);
		append(ARMOR, ModItems.GREATHELM);
		append(ARMOR, ModItems.CRUSADER_CHESTPLATE);
		append(ARMOR, ModItems.CRUSADER_LEGGINGS);
		append(ARMOR, ModItems.CRUSADER_BOOTS);
		if (Platform.isFabric())
			appendStack(ARMOR, CEREMONIAL_ARMET_WITH_PLUME_SUPPLIER);
		else
			append(ARMOR, ModItems.CEREMONIAL_ARMET);
		append(ARMOR, ModItems.CEREMONIAL_CHESTPLATE);
		append(ARMOR, ModItems.CEREMONIAL_BOOTS);
		append(ARMOR, ModItems.COIF);
		append(ARMOR, ModItems.GAMBESON);
		append(ARMOR, ModItems.PANTYHOSE);
		append(ARMOR, ModItems.GAMBESON_BOOTS);
		append(ARMOR, ModItems.BRIGANDINE);
		append(ARMOR, ModItems.NORMAN_HELMET);
		append(ARMOR, ModItems.SHISHAK);
		append(ARMOR, ModItems.BASCINET);
		append(ARMOR, ModItems.XIV_CENTURY_KNIGHT_CHESTPLATE);
		append(ARMOR, ModItems.XIV_CENTURY_KNIGHT_LEGGINGS);
		append(ARMOR, ModItems.XIV_CENTURY_KNIGHT_BOOTS);
		append(ARMOR, ModItems.WINGED_HUSSAR_CHESTPLATE);
		append(ARMOR, ModItems.BURGONET);
		append(ARMOR, ModItems.CUIRASSIER_CHESTPLATE);
		append(ARMOR, ModItems.CUIRASSIER_LEGGINGS);
		append(ARMOR, ModItems.CUIRASSIER_BOOTS);
		append(ARMOR, ModItems.GRAND_BASCINET);
		append(ARMOR, ModItems.KASTENBRUST_CHESTPLATE);
		append(ARMOR, ModItems.KASTENBRUST_LEGGINGS);
		append(ARMOR, ModItems.KASTENBRUST_BOOTS);
		append(ARMOR, ModItems.FACE_HELMET);
		append(ARMOR, ModItems.LAMELLAR_CHESTPLATE);
		append(ARMOR, ModItems.LAMELLAR_BOOTS);
		append(ARMOR, ModItems.BARDING);
		append(ARMOR, ModItems.CHAINMAIL_HORSE_ARMOR);

		append(PARTICULAR_WEAPONS, ModItems.BLACKSMITH_HAMMER);
		append(PARTICULAR_WEAPONS, ModItems.BARBED_CLUB);
		append(PARTICULAR_WEAPONS, ModItems.PITCHFORK);
		append(PARTICULAR_WEAPONS, ModItems.NOBLE_SWORD);
		append(PARTICULAR_WEAPONS, ModItems.CLUB);
		append(PARTICULAR_WEAPONS, ModItems.MESSER_SWORD);
		append(PARTICULAR_WEAPONS, ModItems.LONGBOW);
		append(PARTICULAR_WEAPONS, ModItems.HEAVY_CROSSBOW);

		append(RUSTED, ModItems.RUSTED_BASTARD_SWORD);
		append(RUSTED, ModItems.RUSTED_HEAVY_MACE);
		append(RUSTED, ModItems.CORRUPTED_ROUND_SHIELD);
		append(RUSTED, ModItems.RUSTED_BARBUTE);
		append(RUSTED, ModItems.RUSTED_HALFARMOR_CHESTPLATE);
		append(RUSTED, ModItems.RUSTED_GREATHELM);
		append(RUSTED, ModItems.RUSTED_CRUSADER_CHESTPLATE);
		append(RUSTED, ModItems.RUSTED_CRUSADER_BOOTS);
		append(RUSTED, ModItems.RUSTED_NORMAN_HELMET);
		append(RUSTED, ModItems.RUSTED_CHAINMAIL_HELMET);
		append(RUSTED, ModItems.RUSTED_CHAINMAIL_CHESTPLATE);
		append(RUSTED, ModItems.RUSTED_CHAINMAIL_LEGGINGS);
		append(RUSTED, ModItems.RUSTED_CHAINMAIL_BOOTS);
		append(RUSTED, ModItems.RUSTED_KETTLEHAT);
		
		for (RegistrySupplier<? extends Item> item : ModItems.INSTANCE.ingredientItems)
			append(INGRIDIENTS_RESOURCE_KEY, item);

		for (RegistrySupplier<? extends Item> supplier : ModItems.STILETTOS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.SHORT_SWORDS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.KATZBALGERS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.PIKES.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.RANSEURS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.AHLSPIESSES.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.GIANT_LANCES.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.BASTARD_SWORDS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.ESTOCS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.CLAYMORS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.ZWEIHANDERS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.FLAME_BLADED_SWORDS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.LOCHABER_AXES.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.CONCAVE_EDGED_HALBERDS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.HEAVY_MACES.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.HEAVY_WAR_HAMMERS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.LUCERNE_HAMMERS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.MORNINGSTARS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.FLAILS.get())
			append(WEAPONS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.GUISARMES.get())
			append(WEAPONS, supplier);

		for (RegistrySupplier<? extends Item> supplier : ModItems.HEATER_SHIELDS.get())
			append(SHIELDS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.TARGETS.get())
			append(SHIELDS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.BUCKLERS.get())
			append(SHIELDS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.RONDACHES.get())
			append(SHIELDS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.TARTSCHES.get())
			append(SHIELDS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.ELLIPTICAL_SHIELDS.get())
			append(SHIELDS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.ROUND_SHIELDS.get())
			append(SHIELDS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.PAVISES.get())
			append(SHIELDS, supplier);
		for (RegistrySupplier<? extends Item> supplier : ModItems.KITE_SHIELDS.get())
			append(SHIELDS, supplier);
		
		for (RegistrySupplier<? extends ArmorDecoration> supplier : ModItems.INSTANCE.armorDecorationItems) {
			if (supplier == ModItems.CAT_EARS_DECORATION) {
				continue;
			}
			append(ARMOR_DECORATIONS, () -> supplier.get().asItem());
		}
	}

	@SafeVarargs
	public static <I extends ItemStack, T extends Supplier<I>> void appendStack(DeferredSupplier<CreativeModeTab> tab, T... stacks)
	{
		Arrays.stream(stacks).filter(Objects::nonNull).forEach((stack) -> {
			if (!stack.get().isEmpty()) {
				CreativeTabRegistry.appendStack(tab, stack.get());
			}
		});
	}

	@SafeVarargs
	public static <I extends ItemLike, T extends Supplier<I>> void append(ResourceKey<CreativeModeTab> tab, T... items)
	{
		Arrays.stream(items).filter(Objects::nonNull).forEach((item) -> CreativeTabRegistry.append(tab, item));
	}
	
	@SafeVarargs
	public static <I extends ItemLike, T extends Supplier<I>> void append(DeferredSupplier<CreativeModeTab> tab, T... items)
	{
		Arrays.stream(items).filter(Objects::nonNull).forEach((item) -> CreativeTabRegistry.append(tab, item));
	}
}
