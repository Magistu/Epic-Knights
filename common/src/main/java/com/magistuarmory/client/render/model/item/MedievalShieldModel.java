package com.magistuarmory.client.render.model.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.rendertype.RenderType;

@Environment(EnvType.CLIENT)
public class MedievalShieldModel extends Model<net.minecraft.util.Unit>
{
	private final ModelPart root;
	private final ModelPart[] plate;
	private final ModelPart handle;
	
	public MedievalShieldModel(ModelPart root) 
	{
		super(root, net.minecraft.client.renderer.rendertype.RenderTypes::entityCutout);
		this.root = root;
		this.plate = new ModelPart[]{root.getChild("plate")};
		this.handle = root.getChild("handle");
	}

	public ModelPart[] plate()
	{
		return this.plate;
	}

	public ModelPart handle()
	{
		return this.handle;
	}

}
