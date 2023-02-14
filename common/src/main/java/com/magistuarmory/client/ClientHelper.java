package com.magistuarmory.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.phys.*;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public class ClientHelper
{
	public static HitResult getMouseOver(Minecraft mc, float reach)
	{
		HitResult result = null;
		Entity cameraentity = mc.getCameraEntity();

		if (cameraentity != null)
		{
			result = cameraentity.pick(reach, 0.0F, false);
			Vec3 eyepos = cameraentity.getEyePosition();
			double d1 = reach;
			d1 *= d1;
			if (result != null)
				d1 = result.getLocation().distanceToSqr(eyepos);
			Vec3 view = cameraentity.getViewVector(1.0F);
			Vec3 attackvec = eyepos.add(view.x * (double) reach, view.y * (double) reach, view.z * (double) reach);
			AABB expBounds = cameraentity.getBoundingBox().expandTowards(view.scale(reach)).inflate(1.0D, 1.0D, 1.0D);
			EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(cameraentity, eyepos, attackvec, expBounds, entity -> (!entity.isSpectator() && entity.isPickable()), d1);
			result = Objects.requireNonNullElseGet(entityhitresult, () -> BlockHitResult.miss(attackvec, Direction.getNearest(view.x, view.y, view.z), new BlockPos(attackvec)));
		}
		return result;
	}
}
