package com.magistuarmory.network;

import dev.architectury.networking.NetworkManager;
import net.minecraft.server.level.ServerPlayer;

public class ModPackets
{
	public static void init()
	{
		NetworkManager.registerReceiver(NetworkManager.Side.C2S, PacketLongReachAttack.ID, PacketLongReachAttack::apply);
		NetworkManager.registerReceiver(NetworkManager.Side.C2S, PacketLanceCollision.ID, PacketLanceCollision::apply);
	}
}