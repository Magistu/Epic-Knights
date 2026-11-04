package com.magistuarmory.item;

import com.magistuarmory.item.armor.MedievalArmorItem;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class ModItemTags extends TagsProvider<Item> {

    TagKey<Item> INGOTS = tag("c", "ingots");
    TagKey<Item> NUGGETS = tag("c", "nuggets");
    TagKey<Item> SWORDS = tag("c", "swords");
    TagKey<Item> TOOLS = tag("c", "tools");
    TagKey<Item> TOOLS_BOWS = tag("c", "tools/bows");
    TagKey<Item> TOOLS_SHIELDS = tag("c", "tools/shields");
    TagKey<Item> ARMORS = tag("c", "armors");
    TagKey<Item> ARMORS_HELMETS = tag("c", "armors/helmets");
    TagKey<Item> ARMORS_CHESTPLATES = tag("c", "armors/chestplates");
    TagKey<Item> ARMORS_LEGGINGS = tag("c", "armors/leggings");
    TagKey<Item> ARMORS_BOOTS = tag("c", "armors/boots");

    public ModItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagsProvider.TagLookup<Item>> completableFuture2) {
        super(packOutput, Registries.ITEM, completableFuture, completableFuture2);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(INGOTS).add(ModItems.STEEL_INGOT.get().builtInRegistryHolder().key());
        tag(NUGGETS).add(ModItems.STEEL_NUGGET.get().builtInRegistryHolder().key());

        for (RegistrySupplier<? extends MedievalWeaponItem> supplier : ModItems.INSTANCE.weaponItems) {
            MedievalWeaponItem weapon = supplier.get();
            tag(TOOLS).add(weapon.builtInRegistryHolder().key());
            tag(SWORDS).add(weapon.builtInRegistryHolder().key());
        }

        for (RegistrySupplier<? extends Item> supplier : ModItems.INSTANCE.rangedWeaponItems) {
            Item bow = supplier.get();
            tag(TOOLS).add(bow.builtInRegistryHolder().key());
            tag(TOOLS_BOWS).add(bow.builtInRegistryHolder().key());
        }

        for (RegistrySupplier<? extends Item> supplier : ModItems.INSTANCE.shieldItems) {
            Item shield = supplier.get();
            tag(TOOLS).add(shield.builtInRegistryHolder().key());
            tag(TOOLS_SHIELDS).add(shield.builtInRegistryHolder().key());
        }

        for (RegistrySupplier<? extends MedievalArmorItem> supplier : ModItems.INSTANCE.armorItems) {
            MedievalArmorItem armor = supplier.get();
            tag(ARMORS).add(armor.builtInRegistryHolder().key());
            switch (armor.getEquipmentSlot()) {
                case HEAD -> tag(ARMORS_HELMETS).add(armor.builtInRegistryHolder().key());
                case CHEST -> tag(ARMORS_CHESTPLATES).add(armor.builtInRegistryHolder().key());
                case BODY -> tag(ARMORS_CHESTPLATES).add(armor.builtInRegistryHolder().key());
                case LEGS -> tag(ARMORS_LEGGINGS).add(armor.builtInRegistryHolder().key());
                case FEET -> tag(ARMORS_BOOTS).add(armor.builtInRegistryHolder().key());
            }

        }
    }

    private static TagKey<Item> tag(String namespace, String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(namespace, name));
    }
}
