package com.magistuarmory.item;

import com.magistuarmory.client.render.ModRender;
import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.magistuarmory.util.CombatHelper;
import com.magistuarmory.util.ModDamageSources;
import dev.architectury.platform.Platform;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;


public class MedievalShieldItem extends ShieldItem implements IHasModelProperty
{
	private final ShieldType type;
	private final String id;
	private final ResourceLocation location;
	private final boolean is3d;
	private Supplier<Ingredient> repairItem = () -> Ingredient.of(ItemTags.PLANKS);
	protected HeraldryItemStackRenderer renderer;
	private final boolean paintable;
	private final float maxBlockDamage;
	private final float weight;

	public MedievalShieldItem(String id, ResourceLocation location, Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
    {
		super(properties.durability(type.getDurability(material)));
		this.type = type;
	    this.id = id;
		this.location = location;
		this.is3d = is3d;
		this.paintable = paintable;
		this.maxBlockDamage = type.getMaxBlockDamage() + material.getAttackDamageBonus();
		this.weight = type.getWeight() + material.getAttackDamageBonus();
		
		if (type.isRepairable())
			this.repairItem = material::getRepairIngredient;

	    if (this.is3d && Platform.getEnv() == EnvType.CLIENT)
		    this.renderer = ModRender.createHeraldryItemStackRenderer(this.id, this.location);
    }

	public String getId()
	{
		return this.id;
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag)
	{
		list.add(Component.translatable("maxdamageblock", this.getMaxBlockDamage()).withStyle(ChatFormatting.BLUE));
		list.add(Component.translatable("kgweight", this.getWeight()).withStyle(ChatFormatting.BLUE));
		if (this.getWeight() >= 10)
			list.add(Component.translatable("slowmovementspeed").withStyle(ChatFormatting.RED));

		BannerItem.appendHoverTextFromBannerBlockEntityTag(stack, list);
	}
	
	@Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean selected)
	{
    	if (this.getWeight() >= 10 && entity instanceof LivingEntity livingentity && (livingentity.getOffhandItem() == stack || livingentity.getMainHandItem() == stack))
    	{
			livingentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, false, false, false));
    	}
    	super.inventoryTick(stack, level, entity, i, selected);
	}
	
	protected float getWeight() 
	{
		return this.weight;
	}

	@Override
	public String getDescriptionId(ItemStack stack)
    {
		return super.getDescriptionId();
    }
	
	@Override
	public int getUseDuration(ItemStack stack)
    {
        return (int) (12000 * this.weight);
    }
	
	@Override
	public boolean isValidRepairItem(ItemStack stack, ItemStack stack2) 
	{
		return this.repairItem.get().test(stack2);
	}
	
	public boolean isPaintable()
	{
		return this.paintable;
	}
	
	public void loadModel(EntityRendererProvider.Context context) 
	{
		if (this.is3d)
			this.renderer.loadModel(context);
	}
	
	public HeraldryItemStackRenderer getRenderer()
	{
		return this.renderer;
	}
	
	public float getMaxBlockDamage() 
	{
		return this.maxBlockDamage;
	}

	public void onBlocked(ItemStack stack, float damage, LivingEntity victim, DamageSource source) 
	{
		try
		{
			if (ModDamageSources.isAdditional(source))
				return;
		}
		catch (NullPointerException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		
		Entity attacker = source.getEntity();
		float f = CombatHelper.getArmorPiercingFactor(attacker);

		if (damage > this.getMaxBlockDamage())
		{
			f *= 1.5f;
			float damage2 = damage - getMaxBlockDamage();
			victim.hurt(ModDamageSources.additional(), damage2);
		}
		
		stack.hurtAndBreak((int) (f * damage), victim, entity -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public void registerModelProperty() 
	{
		ItemPropertiesRegistry.register(this, new ResourceLocation("blocking"), (stack, level, entity, i) ->
				entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
	}

	public boolean is3d()
	{
		return this.is3d;
	}
}