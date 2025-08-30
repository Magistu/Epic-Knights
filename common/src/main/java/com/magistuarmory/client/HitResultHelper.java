package com.magistuarmory.client;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.phys.*;

import java.util.Objects;

public class HitResultHelper
{
	public static HitResult getMouseOver(Minecraft mc, float reach)
	{
		HitResult result = null;
		Player player = mc.player;

		if (player != null)
		{
			result = player.pick(reach, 0.0F, false);
			Vec3 eyepos = player.getEyePosition();
			double d1 = result.getLocation().distanceToSqr(eyepos);
			Vec3 view = player.getViewVector(1.0F);
			Vec3 attackvec = eyepos.add(view.x * (double) reach, view.y * (double) reach, view.z * (double) reach);
			AABB expBounds = player.getBoundingBox().expandTowards(view.scale(reach)).inflate(1.0D, 1.0D, 1.0D);
			EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyepos, attackvec, expBounds, entity -> (!entity.isSpectator() && entity.isPickable()), d1);
			result = Objects.requireNonNullElseGet(entityhitresult, () -> BlockHitResult.miss(attackvec, Direction.getNearest(view.x, view.y, view.z), new BlockPos((int) attackvec.x, (int) attackvec.y, (int) attackvec.z)));
		}
		return result;
	}
}
