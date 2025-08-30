package com.magistuarmory.network;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.item.LanceItem;
import dev.architectury.networking.NetworkManager;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;


public class PacketLanceCollision implements CustomPacketPayload
{
	public static final CustomPacketPayload.Type<PacketLanceCollision> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "packet_lance_collision"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PacketLanceCollision> STREAM_CODEC = StreamCodec.composite(
			ByteBufCodecs.INT, p -> p.attackerid,
			ByteBufCodecs.INT, p -> p.victimid,
			PacketLanceCollision::new);

	public int attackerid;
	public int victimid;

	public PacketLanceCollision(Entity attacker, Entity victim)
	{
		this(attacker.getId(), victim.getId());
	}

	public PacketLanceCollision(int attackerid, int victimid) 
	{
		this.attackerid = attackerid;
		this.victimid = victimid;
	}
	
	public static void sendToServer(Entity attacker, Entity victim)
	{
		NetworkManager.sendToServer(new PacketLanceCollision(attacker, victim));
	}

	public static void apply(PacketLanceCollision packet, NetworkManager.PacketContext context)
	{
		if (!(context.getPlayer() instanceof ServerPlayer player))
			return;
		Entity attacker = player.level().getEntity(packet.attackerid);
		Entity victim = player.level().getEntity(packet.victimid);
		if (attacker == null || victim == null)
			return;
		context.queue(() -> execute(attacker, victim, player));
	}

	static void execute(Entity attacker, Entity victim, ServerPlayer player)
	{
		ItemStack stack = player.getMainHandItem();

		if (attacker == player && stack.getItem() instanceof LanceItem lance)
		{
			float speed = lance.getVelocityProjection(player);
			boolean dismount = victim.level().getRandom().nextDouble() > (1.0 - lance.getClickedScale());
			lance.setRideSpeed(stack, speed);
			lance.setDismount(stack, dismount);
			player.attack(victim);
			player.resetAttackStrengthTicker();
		}
	}

	@Override
	public @NotNull Type<? extends CustomPacketPayload> type()
	{
		return TYPE;
	}
}