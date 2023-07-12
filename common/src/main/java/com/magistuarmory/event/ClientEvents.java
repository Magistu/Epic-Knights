package com.magistuarmory.event;

import com.magistuarmory.client.ClientHelper;
import com.magistuarmory.client.render.ModRender;
import com.magistuarmory.item.LanceItem;
import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.util.CombatHelper;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.client.ClientRawInputEvent;
import dev.architectury.event.events.client.ClientTextureStitchEvent;
import dev.architectury.event.events.common.LifecycleEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class ClientEvents
{
	public static void init()
	{
		LifecycleEvent.SETUP.register(ClientEvents::onSetup);
		ClientTextureStitchEvent.PRE.register(ClientEvents::onStitchPre);
		ClientRawInputEvent.MOUSE_CLICKED_PRE.register(ClientEvents::onMouseInput);
	}

	public static void onSetup()
	{
		ModRender.setup();
	}

	public static void onStitchPre(TextureAtlas atlas, Consumer<ResourceLocation> adder)
	{
		ModRender.stitch(atlas, adder);
	}
	
	public static EventResult onMouseInput(Minecraft mc, int button, int action, int mods)
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
				HitResult hit = ClientHelper.getMouseOver(mc, CombatHelper.getAttackReach(player, weapon));
				if (hit instanceof EntityHitResult entityhit && !weapon.onAttackClickEntity(stack, player, entityhit.getEntity())) 
				{
					return weapon instanceof LanceItem ? EventResult.interruptFalse() : EventResult.interruptDefault();
				}
			}
		}
		return EventResult.pass();
	}
}