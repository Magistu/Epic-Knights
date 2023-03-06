package com.magistuarmory.network;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.item.LanceItem;
import dev.architectury.networking.NetworkManager;
import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;


public class PacketLanceCollision
{
	public static final ResourceLocation ID = new ResourceLocation(KnightlyArmory.ID, "packet_lance_collision");

	public static void sendToServer(int entityid, float damage, boolean dismount)
	{
		NetworkManager.sendToServer(ID, PacketLanceCollision.encode(entityid, damage, dismount));
	}

	static FriendlyByteBuf encode(int entityid, float speed, boolean dismount)
	{
		FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
		buf.writeInt(entityid);
		buf.writeFloat(speed);
		buf.writeBoolean(dismount);
		return buf;
	}

	public static void apply(FriendlyByteBuf buf, NetworkManager.PacketContext context)
	{
		if (!(context.getPlayer() instanceof ServerPlayer player))
			return;
		Entity victim = player.level.getEntity(buf.readInt());
		if (victim == null)
			return;
		float speed = buf.readFloat();
		boolean dismount = buf.readBoolean();
		context.queue(() -> execute(victim, speed, dismount, player));
	}

	static void execute(Entity victim, float speed, boolean dismount, ServerPlayer player)
	{
		ItemStack stack = player.getMainHandItem();

		if (stack.getItem() instanceof LanceItem lance)
		{
			lance.setRideSpeed(stack, speed);
			lance.setDismount(stack, dismount);
			player.attack(victim);
			player.resetAttackStrengthTicker();
		}
	}
}