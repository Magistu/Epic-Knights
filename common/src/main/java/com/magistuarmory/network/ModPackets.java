package com.magistuarmory.network;

import dev.architectury.networking.NetworkManager;

public class ModPackets
{
	public static void init()
	{
		NetworkManager.registerReceiver(NetworkManager.Side.C2S, PacketLanceCollision.TYPE, PacketLanceCollision.STREAM_CODEC, PacketLanceCollision::apply);
	}
}