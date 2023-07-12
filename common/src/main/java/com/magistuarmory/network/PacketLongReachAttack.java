package com.magistuarmory.network;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.item.MedievalWeaponItem;
import dev.architectury.networking.NetworkManager;
import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;


public class PacketLongReachAttack
{
	public static final ResourceLocation ID = new ResourceLocation(EpicKnights.ID, "packet_long_reach_attack");

	public static void sendToServer(int entityid)
	{
		NetworkManager.sendToServer(ID, PacketLongReachAttack.encode(entityid));
	}
	
	static FriendlyByteBuf encode(int entityId)
	{
		FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
		buf.writeInt(entityId);
		return buf;
	}

	public static void apply(FriendlyByteBuf buf, NetworkManager.PacketContext context)
	{
		if (!(context.getPlayer() instanceof ServerPlayer player))
			return;
		Entity victim = player.level.getEntity(buf.readInt());
		if (victim == null)
			return;
		context.queue(() -> execute(victim, player));
	}

	static void execute(Entity victim, ServerPlayer player)
	{
		ItemStack stack = player.getItemBySlot(EquipmentSlot.MAINHAND);
		if (!(stack.getItem() instanceof MedievalWeaponItem weapon) || !weapon.isLong())
			return;
		player.attack(victim);
		player.swing(InteractionHand.MAIN_HAND, true);
		player.resetAttackStrengthTicker();
	}
}