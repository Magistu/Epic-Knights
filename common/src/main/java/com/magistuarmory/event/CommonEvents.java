package com.magistuarmory.event;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.init.ModMerchOffers;

import com.magistuarmory.util.EquipmentHelper;
import com.magistuarmory.init.ModLoot;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.MedievalWeaponItem;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.event.events.common.LootEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTables;

public class CommonEvents
{
    public static void init()
    {
        LootEvent.MODIFY_LOOT_TABLE.register(CommonEvents::onModifyLootTable);
        LifecycleEvent.SETUP.register(CommonEvents::onSetup);
        LifecycleEvent.SERVER_STARTING.register(CommonEvents::onServerStarting);
        EntityEvent.ADD.register(CommonEvents::onEntityJoinLevel);
        EntityEvent.LIVING_HURT.register(CommonEvents::onLivingHurt);
    }

    public static void onModifyLootTable(LootTables tables, ResourceLocation id, LootEvent.LootTableModificationContext context, boolean builtin)
    {
        ModLoot.modifyLootTable(id, context);
    }

    public static void onSetup()
    {
        ModMerchOffers.setup();
    }

    public static void onServerStarting(MinecraftServer server)
    {
        KnightlyArmory.checkBetterCombatOrEpicFightInstalled();
    }
    
    public static EventResult onEntityJoinLevel(Entity entity, Level level)
    {
        EquipmentHelper.equip(entity);
        return EventResult.pass();
    }

    public static EventResult onLivingHurt(LivingEntity victim, DamageSource source, float damage) 
    {
        ItemStack stack = victim.getUseItem();

        if (victim.isBlocking() && stack.getItem() instanceof MedievalShieldItem shield)
        {
            shield.onBlocked(stack, damage, victim, source);
            return EventResult.pass();
        }
        if (victim.isBlocking() && stack.getItem() instanceof MedievalWeaponItem weapon && weapon.canBlock())
        {
            weapon.onBlocked(stack, damage, victim, source);
            return EventResult.pass();
        }
        if (source.getEntity() instanceof LivingEntity attacker && attacker.getMainHandItem().getItem() instanceof MedievalWeaponItem weapon2)
        {
            weapon2.onHurtEntity(source, victim, damage);
        }
        
        return EventResult.pass();
    }
}
