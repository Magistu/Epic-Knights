package com.magistuarmory.item;

import com.magistuarmory.item.armor.MedievalArmorItem;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModItemTags extends ItemTagsProvider {

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

    public ModItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> completableFuture2) {
        super(packOutput, completableFuture, completableFuture2);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(INGOTS).add(ModItems.STEEL_INGOT.get());
        tag(NUGGETS).add(ModItems.STEEL_NUGGET.get());

        for (RegistrySupplier<? extends MedievalWeaponItem> supplier : ModItems.INSTANCE.weaponItems) {
            MedievalWeaponItem weapon = supplier.get();
            tag(TOOLS).add(weapon);
            tag(SWORDS).add(weapon);
        }

        for (RegistrySupplier<? extends Item> supplier : ModItems.INSTANCE.rangedWeaponItems) {
            Item bow = supplier.get();
            tag(TOOLS).add(bow);
            tag(TOOLS_BOWS).add(bow);
        }

        for (RegistrySupplier<? extends Item> supplier : ModItems.INSTANCE.shieldItems) {
            Item shield = supplier.get();
            tag(TOOLS).add(shield);
            tag(TOOLS_SHIELDS).add(shield);
        }

        for (RegistrySupplier<? extends MedievalArmorItem> supplier : ModItems.INSTANCE.armorItems) {
            MedievalArmorItem armor = supplier.get();
            tag(ARMORS).add(armor);
            switch (armor.getEquipmentSlot()) {
                case HEAD -> tag(ARMORS_HELMETS).add(armor);
                case CHEST -> tag(ARMORS_CHESTPLATES).add(armor);
                case BODY -> tag(ARMORS_CHESTPLATES).add(armor);
                case LEGS -> tag(ARMORS_LEGGINGS).add(armor);
                case FEET -> tag(ARMORS_BOOTS).add(armor);
            }
            tag(ARMORS_HELMETS).add(supplier.get());
        }
    }

    private static TagKey<Item> tag(String namespace, String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(namespace, name));
    }
}
