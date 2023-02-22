package com.magistuarmory.network;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.item.LanceItem;
import dev.architectury.networking.NetworkManager;
import io.netty.buffer.Unpooled;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;


public class PacketBetterCombatOrEpicFightInstalled extends PacketBase
{
	public static final ResourceLocation ID = new ResourceLocation(KnightlyArmory.ID, "packet_bc_or_ef_installed");

	private final boolean betterCombatOrEpicFightInstalled;

	PacketBetterCombatOrEpicFightInstalled(boolean betterCombatOrEpicFightInstalled)
	{
		this.betterCombatOrEpicFightInstalled = betterCombatOrEpicFightInstalled;
	}

	@Override
	FriendlyByteBuf encode()
	{
		FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
		buf.writeBoolean(this.betterCombatOrEpicFightInstalled);
		return buf;
	}

	public static void apply(FriendlyByteBuf buf, NetworkManager.PacketContext context)
	{
		apply(buf.readBoolean());
	}

	static void apply(boolean betterCombatOrEpicFightInstalled)
	{
		KnightlyArmory.BC_or_EF_installed = betterCombatOrEpicFightInstalled;
	}
	
	public static void sendToPlayer(ServerPlayer player)
	{
		NetworkManager.sendToPlayer(player, ID, new PacketBetterCombatOrEpicFightInstalled(KnightlyArmory.BC_or_EF_installed).encode());
	}
}