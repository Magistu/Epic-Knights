package com.magistuarmory.event;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.client.HitResultHelper;
import com.magistuarmory.client.render.ModRender;
import com.magistuarmory.item.LanceItem;
import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.util.CombatHelper;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.client.ClientPlayerEvent;
import dev.architectury.event.events.client.ClientRawInputEvent;
import dev.architectury.event.events.common.LifecycleEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

@Environment(EnvType.CLIENT)
public class ClientEvents
{
	public static void init()
	{
		ClientRawInputEvent.MOUSE_CLICKED_PRE.register(ClientEvents::onMouseInput);
		LifecycleEvent.SETUP.register(ModRender::registerRenderers);
		ClientPlayerEvent.CLIENT_PLAYER_JOIN.register(ClientEvents::onClientPlayerJoin);
	}

	private static void onClientPlayerJoin(LocalPlayer player)
	{
		if (player.level().isClientSide() && player == Minecraft.getInstance().player)
			EpicKnights.checkBetterCombatOrEpicFightInstalled();
	}

	private static EventResult onMouseInput(Minecraft mc, int button, int action, int mods)
	{
		if (mc.level == null || mc.screen != null || mc.isPaused())
			return EventResult.pass();

		KeyMapping keyattack = mc.options.keyAttack;
		if (button == keyattack.getDefaultKey().getValue())
		{
			Player player = mc.player;
			if (player == null || player.isBlocking())
				return EventResult.pass();
			
			ItemStack stack = player.getMainHandItem();
			if (stack.getItem() instanceof MedievalWeaponItem weapon) 
			{
				HitResult hit = HitResultHelper.getMouseOver(mc, CombatHelper.getAttackReach(player, weapon));
				if (hit instanceof EntityHitResult entityhit && !weapon.onAttackClickEntity(stack, player, entityhit.getEntity()))
					return weapon instanceof LanceItem ? EventResult.interruptFalse() : EventResult.interruptDefault();
			}
		}
		return EventResult.pass();
	}
}