package com.magistuarmory.network;

import com.magistuarmory.EpicKnights;
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
	public static final ResourceLocation ID = new ResourceLocation(EpicKnights.ID, "packet_lance_collision");

	public static void sendToServer(int entityid, float damage)
	{
		NetworkManager.sendToServer(ID, PacketLanceCollision.encode(entityid, damage));
	}

	static FriendlyByteBuf encode(int entityid, float speed)
	{
		FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
		buf.writeInt(entityid);
		buf.writeFloat(speed);
		return buf;
	}

	public static void apply(FriendlyByteBuf buf, NetworkManager.PacketContext context)
	{
		if (!(context.getPlayer() instanceof ServerPlayer player))
			return;
		Entity victim = player.level().getEntity(buf.readInt());
		if (victim == null)
			return;
		float speed = buf.readFloat();
		context.queue(() -> execute(victim, speed, player));
	}

	static void execute(Entity victim, float speed, ServerPlayer player)
	{
		ItemStack stack = player.getMainHandItem();

		if (stack.getItem() instanceof LanceItem lance)
		{
			boolean dismount = victim.level().getRandom().nextDouble() > (1.0 - lance.getClickedScale());
			lance.setRideSpeed(stack, speed);
			lance.setDismount(stack, dismount);
			player.attack(victim);
			player.resetAttackStrengthTicker();
		}
	}
}