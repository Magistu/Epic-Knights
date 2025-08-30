package com.magistuarmory.event;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.misc.ModLoot;
import com.magistuarmory.misc.ModMerchOffers;
import com.magistuarmory.util.MobEquipment;
import com.magistuarmory.util.MobEquipmentHelper;
import com.magistuarmory.util.ModDamageSources;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.event.events.common.LootEvent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;


public class CommonEvents
{
    public static void init()
    {
        LootEvent.MODIFY_LOOT_TABLE.register(CommonEvents::onModifyLootTable);
        LifecycleEvent.SETUP.register(CommonEvents::onSetup);
        LifecycleEvent.SERVER_STARTING.register(CommonEvents::onServerStarting);
        LifecycleEvent.SERVER_LEVEL_LOAD.register(CommonEvents::onServerLevelLoad);
        EntityEvent.ADD.register(CommonEvents::onEntityJoinLevel);
        EntityEvent.LIVING_HURT.register(CommonEvents::onLivingHurt);
    }

    private static void onModifyLootTable(ResourceKey<LootTable> key, LootEvent.LootTableModificationContext context, boolean builtin)
    {
        ModLoot.modifyLootTable(key, context, builtin);
    }

    private static void onSetup()
    {
        ModMerchOffers.setup();
    }

    private static void onServerStarting(MinecraftServer server)
    {
        MobEquipment.setup(server);
        EpicKnights.checkBetterCombatOrEpicFightInstalled();
    }

    private static void onServerLevelLoad(Level level)
    {
        ModDamageSources.setup(level.registryAccess());
    }

    private static EventResult onEntityJoinLevel(Entity entity, Level level)
    {
        if (entity instanceof LivingEntity livingentity)
            MobEquipmentHelper.equip(livingentity);
        return EventResult.pass();
    }

    private static EventResult onLivingHurt(LivingEntity victim, DamageSource source, float damage)
    {
        if (victim.level().isClientSide())
            return EventResult.pass();
        
        ItemStack stack = victim.getUseItem();
        
        if (victim.isInvulnerable() || (victim instanceof Player player && player.isCreative()))
            return EventResult.pass();

        if (victim.isBlocking())
        {
            if (stack.getItem() instanceof MedievalShieldItem shield) {
                shield.onBlocked(stack, damage, victim, source);
                return EventResult.pass();
            }
            else if (stack.getItem() instanceof MedievalWeaponItem weapon && weapon.canBlock())
            {
                weapon.onBlocked(stack, damage, victim, source);
                return EventResult.pass();
            }
        }
        if (source.getEntity() instanceof LivingEntity attacker && attacker.getMainHandItem().getItem() instanceof MedievalWeaponItem weapon2)
        {
            weapon2.onHurtEntity(source, victim, damage);
        }
        
        return EventResult.pass();
    }
}
