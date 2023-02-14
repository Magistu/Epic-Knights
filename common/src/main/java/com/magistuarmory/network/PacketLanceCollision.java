package com.magistuarmory.network;

import com.magistuarmory.KnightlyArmory;

import com.magistuarmory.item.LanceItem;
import com.magistuarmory.util.CombatHelper;
import dev.architectury.networking.NetworkManager;
import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;


public class PacketLanceCollision extends PacketBase
{
	public static final ResourceLocation ID = new ResourceLocation(KnightlyArmory.ID, "packet_lance_collision");

	private final int entityId;
	private final int damage;

	PacketLanceCollision(int entityid, int damage)
	{
		this.entityId = entityid;
		this.damage = damage;
	}

	@Override
	FriendlyByteBuf encode()
	{
		FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
		buf.writeInt(entityId);
		buf.writeInt(damage);
		return buf;
	}

	public static void apply(FriendlyByteBuf buf, NetworkManager.PacketContext context)
	{
		apply(context.getPlayer().level.getEntity(buf.readInt()), buf.readInt(), (ServerPlayer) context.getPlayer());
	}

	static void apply(Entity victim, int damage, ServerPlayer player)
	{
		ItemStack weapon = player.getItemBySlot(EquipmentSlot.MAINHAND);

		if (weapon.getItem() instanceof LanceItem lance)
		{
			lance.onCollide(weapon, player, victim, damage);
		}
	}
	
	public static void sendToServer(int entityid, int damage)
	{
		NetworkManager.sendToServer(ID, new PacketLanceCollision(entityid, damage).encode());
	}
}