package com.magistuarmory.network;

import dev.architectury.networking.NetworkManager;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;

public abstract class PacketBase
{
	abstract FriendlyByteBuf encode();
}