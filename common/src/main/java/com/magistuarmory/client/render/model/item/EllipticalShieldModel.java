package com.magistuarmory.client.render.model.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

@Environment(EnvType.CLIENT)
public class EllipticalShieldModel extends MedievalShieldModel 
{
	public EllipticalShieldModel(ModelPart root) 
	{
		super(root);
	}
	
	public static LayerDefinition createLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(0, 0).addBox(-15.5F, -17.0F, -2.0F, 31F, 31F, 1F).texOffs(0, 33).addBox(-7.5F, -7.0F, -2.0F, 15F, 9F, 1F).texOffs(36, 33).addBox(-6.5F, 2.0F, -2.0F, 13F, 2F, 1F).texOffs(40, 36).addBox(-5.5F, 4.0F, -2.0F, 11F, 1F, 1F).texOffs(44, 38).addBox(-4.5F, 5.0F, -2.0F, 9F, 1F, 1F).texOffs(48, 40).addBox(-2.5F, -12.0F, -2.0F, 5F, 1F, 1F).texOffs(36, 48).addBox(-6.5F, -9.0F, -2.0F, 13F, 2F, 1F).texOffs(40, 42).addBox(-5.5F, -10.0F, -2.0F, 11F, 1F, 1F).texOffs(52, 44).addBox(-2.5F, 6.0F, -2.0F, 5F, 1F, 1F).texOffs(44, 46).addBox(-4.5F, -11.0F, -2.0F, 9F, 1F, 1F), PartPose.ZERO);
		partdefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(48, 52).addBox(-1.0F, -3.0F, -1.0F, 2F, 6F, 6F), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}