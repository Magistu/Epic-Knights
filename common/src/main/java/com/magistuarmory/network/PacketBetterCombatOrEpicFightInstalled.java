package com.magistuarmory.network;

import com.magistuarmory.KnightlyArmory;
import dev.architectury.networking.NetworkManager;
import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;


public class PacketBetterCombatOrEpicFightInstalled
{
	public static final ResourceLocation ID = new ResourceLocation(KnightlyArmory.ID, "packet_bc_or_ef_installed");
	
	public static void sendToPlayer(ServerPlayer player)
	{
		NetworkManager.sendToPlayer(player, ID, PacketBetterCombatOrEpicFightInstalled.encode(KnightlyArmory.BC_or_EF_installed));
	}

	static FriendlyByteBuf encode(boolean bcorefinstalled)
	{
		FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
		buf.writeBoolean(bcorefinstalled);
		return buf;
	}

	public static void apply(FriendlyByteBuf buf, NetworkManager.PacketContext context)
	{
		boolean bcorefinstalled = buf.readBoolean();
		context.queue(() -> execute(bcorefinstalled));
	}

	static void execute(boolean bcorefinstalled)
	{
		KnightlyArmory.BC_or_EF_installed = bcorefinstalled;
	}
}