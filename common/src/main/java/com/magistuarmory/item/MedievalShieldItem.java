package com.magistuarmory.item;

import com.magistuarmory.client.render.ModRender;
import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.magistuarmory.util.CombatHelper;
import com.magistuarmory.util.ModDamageSources;
import dev.architectury.platform.Platform;
import com.magistuarmory.client.render.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
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
	private final Identifier location;
	private final boolean is3d;

	protected HeraldryItemStackRenderer renderer;
	private final boolean paintable;
	private final float maxBlockDamage;
	private final float weight;

	public MedievalShieldItem(String id, Identifier location, Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
    {
		super(blockingProperties(properties).stacksTo(1).durability(type.getDurability(material)).repairable(type.isRepairable() ? material.asToolMaterial().repairItems() : ItemTags.PLANKS));
		this.type = type;
	    this.id = id;
		this.location = location;
		this.is3d = is3d;
		this.paintable = paintable;
		this.maxBlockDamage = type.getMaxBlockDamage() + material.getAttackDamageBonus();
		this.weight = type.getWeight() + material.getAttackDamageBonus();
		


	    if (this.is3d && Platform.getEnv() == EnvType.CLIENT)
		    this.renderer = ModRender.createHeraldryItemStackRenderer(this.id, this.location);
    }

    public static Properties blockingProperties(Properties properties) {
        return properties.delayedComponent(net.minecraft.core.component.DataComponents.BLOCKS_ATTACKS, context ->
                new net.minecraft.world.item.component.BlocksAttacks(0.25F, 1.0F,
                        java.util.List.of(new net.minecraft.world.item.component.BlocksAttacks.DamageReduction(90, java.util.Optional.empty(), 0, 1)),
                        new net.minecraft.world.item.component.BlocksAttacks.ItemDamageFunction(3, 1, 1),
                        java.util.Optional.of(context.getOrThrow(net.minecraft.tags.DamageTypeTags.BYPASSES_SHIELD)),
                        java.util.Optional.of(net.minecraft.sounds.SoundEvents.SHIELD_BLOCK),
                        java.util.Optional.of(net.minecraft.sounds.SoundEvents.SHIELD_BREAK)))
                .component(net.minecraft.core.component.DataComponents.BREAK_SOUND, net.minecraft.sounds.SoundEvents.SHIELD_BREAK);
    }

	public String getId()
	{
		return this.id;
	}

	public Identifier getLocation()
	{
		return this.location;
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, TooltipContext tooltipContext, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag)
	{
		list.accept(Component.translatable("maxdamageblock", this.getMaxBlockDamage()).withStyle(ChatFormatting.BLUE));
		list.accept(Component.translatable("kgweight", this.getWeight()).withStyle(ChatFormatting.BLUE));
		if (this.getWeight() >= 10)
			list.accept(Component.translatable("slowmovementspeed").withStyle(ChatFormatting.RED));

		super.appendHoverText(stack, tooltipContext, display, list, flag);
	}
	
	@Override
    public void inventoryTick(ItemStack stack, net.minecraft.server.level.ServerLevel level, Entity entity, net.minecraft.world.entity.EquipmentSlot slot)
	{
    	if (this.getWeight() >= 10 && entity instanceof LivingEntity livingentity && (livingentity.getOffhandItem() == stack || livingentity.getMainHandItem() == stack))
    	{
			livingentity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 40, 0, false, false, false));
    	}
	super.inventoryTick(stack, level, entity, slot);
	}
	
	protected float getWeight() 
	{
		return this.weight;
	}

	
	@Override
	public int getUseDuration(ItemStack stack, LivingEntity entity)
    {
        return (int) (12000 * this.weight);
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
		
		stack.hurtAndBreak((int) (f * damage), victim, EquipmentSlot.MAINHAND);
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public void registerModelProperty() 
	{
		ItemPropertiesRegistry.register(this, Identifier.withDefaultNamespace("blocking"), (stack, level, entity, i) ->
				entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
	}

	public boolean is3d()
	{
		return this.is3d;
	}
}