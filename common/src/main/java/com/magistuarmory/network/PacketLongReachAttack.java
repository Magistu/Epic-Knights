package com.magistuarmory.network;

import com.magistuarmory.KnightlyArmory;

import com.magistuarmory.item.MedievalWeaponItem;
import com.magistuarmory.util.CombatHelper;
import dev.architectury.networking.NetworkManager;
import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;


public class PacketLongReachAttack extends PacketBase
{
	public static final ResourceLocation ID = new ResourceLocation(KnightlyArmory.ID, "packet_long_reach_attack");

	private final int entityId;
	
	PacketLongReachAttack(int entityId) 
	{
		this.entityId = entityId;
	}

	@Override
	FriendlyByteBuf encode() 
	{
		FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
		buf.writeInt(this.entityId);
		return buf;
	}

	public static void apply(FriendlyByteBuf buf, NetworkManager.PacketContext context)
	{
		apply(context.getPlayer().level.getEntity(buf.readInt()), (ServerPlayer) context.getPlayer());
	}

	static void apply(Entity victim, ServerPlayer player) 
	{
		ItemStack stack = player.getItemBySlot(EquipmentSlot.MAINHAND);
		if (!(stack.getItem() instanceof MedievalWeaponItem weapon) || !weapon.isLong())
			return;
		player.attack(victim);
		player.swing(InteractionHand.MAIN_HAND, true);
		player.resetAttackStrengthTicker();
	}

	public static void sendToServer(int entityid)
	{
		NetworkManager.sendToServer(ID, new PacketLongReachAttack(entityid).encode());
	}
}