package com.magistuarmory.network;

import dev.architectury.networking.NetworkManager;
import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;

public class ModPackets
{
	public static void init()
	{
		NetworkManager.registerReceiver(NetworkManager.Side.C2S, PacketLongReachAttack.ID, PacketLongReachAttack::apply);
		NetworkManager.registerReceiver(NetworkManager.Side.C2S, PacketLanceCollision.ID, PacketLanceCollision::apply);
		if (Platform.getEnvironment() == Env.CLIENT)
			NetworkManager.registerReceiver(NetworkManager.Side.S2C, PacketBetterCombatOrEpicFightInstalled.ID, PacketBetterCombatOrEpicFightInstalled::apply);
	}
}