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


public class PacketLanceCollision extends PacketBase
{
	public static final ResourceLocation ID = new ResourceLocation(KnightlyArmory.ID, "packet_lance_collision");

	private final int entityId;
	private final float speed;
	private final boolean dismount;

	PacketLanceCollision(int entityid, float speed, boolean dismount)
	{
		this.entityId = entityid;
		this.speed = speed;
		this.dismount = dismount;
	}

	@Override
	FriendlyByteBuf encode()
	{
		FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
		buf.writeInt(this.entityId);
		buf.writeFloat(this.speed);
		buf.writeBoolean(this.dismount);
		return buf;
	}

	public static void apply(FriendlyByteBuf buf, NetworkManager.PacketContext context)
	{
		apply(context.getPlayer().level.getEntity(buf.readInt()), buf.readFloat(), buf.readBoolean(), (ServerPlayer) context.getPlayer());
	}

	static void apply(Entity victim, float speed, boolean dismount, ServerPlayer player)
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
	
	public static void sendToServer(int entityid, float damage, boolean dismount)
	{
		NetworkManager.sendToServer(ID, new PacketLanceCollision(entityid, damage, dismount).encode());
	}
}