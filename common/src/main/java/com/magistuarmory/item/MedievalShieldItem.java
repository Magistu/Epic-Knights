package com.magistuarmory.item;

import com.magistuarmory.client.render.ModRender;
import com.magistuarmory.client.render.model.Models;
import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.magistuarmory.util.CombatHelper;
import com.magistuarmory.util.ModDamageSource;
import dev.architectury.platform.Platform;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import dev.architectury.utils.Env;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class MedievalShieldItem extends ShieldItem implements IHasModelProperty
{
	private final ShieldType type;
	private Supplier<Ingredient> repairItem = () -> Ingredient.of(ItemTags.PLANKS);
	protected HeraldryItemStackRenderer renderer;
	private final boolean paintable;
	private final float maxBlockDamage;
	private final float weight;

	public MedievalShieldItem(String id, String name, Properties build, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Models.ShieldEnum modelkey)
    {
		super(build.durability(type.getDurability(material)));
		this.type = type;
		this.paintable = paintable;
		this.maxBlockDamage = type.maxBlockDamage + material.getAttackDamageBonus();
		this.weight = type.weigth + material.getAttackDamageBonus();
		if (type.repairable)
		{
			this.repairItem = material::getRepairIngredient;
		}
		if (is3d && Platform.getEnvironment() == Env.CLIENT)
		{
			renderer = (HeraldryItemStackRenderer) ModRender.getHeraldryItemStackRenderer(id, name, modelkey);
		}
    }
	
	@Override
	public void appendHoverText(@NotNull ItemStack p_43094_, @Nullable Level p_43095_, List<Component> p_43096_, TooltipFlag p_43097_)
    {
    	p_43096_.add(new TextComponent(getMaxBlockDamage() + " max damage block").withStyle(ChatFormatting.BLUE));
    	p_43096_.add(new TextComponent(getWeight() + "kg weight").withStyle(ChatFormatting.BLUE));
		if (this.getWeight() >= 10)
		{
			p_43096_.add(new TextComponent("Slow movement speed").withStyle(ChatFormatting.RED));
		}
	    BannerItem.appendHoverTextFromBannerBlockEntityTag(p_43094_, p_43096_);
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
		return weight;
	}

	@Override
	public String getDescriptionId(ItemStack p_43109_)
    {
		return getDescriptionId();
    }
	
	@Override
	public int getUseDuration(ItemStack p_43107_)
    {
        return (int) (12000 * weight);
    }
	
	@Override
	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) 
	{
		return this.repairItem.get().test(p_40393_);
	}
	
	public boolean isPaintable()
	{
		return paintable;
	}
	
	public HeraldryItemStackRenderer getRenderer() 
	{
		return renderer;
	}
	
	public float getMaxBlockDamage() 
	{
		return maxBlockDamage;
	}

	public void onBlocked(ItemStack stack, float damage, LivingEntity victim, DamageSource source) 
	{
		Entity attacker = source.getEntity();
		float f = CombatHelper.getArmorPiercingFactor(attacker);

		if (damage > this.getMaxBlockDamage())
		{
			f *= 1.5f;
			float damage1 = damage - getMaxBlockDamage();
			// float damage2 = CombatRules.getDamageAfterAbsorb(damage1, (float)blockingentity.getArmorValue(), (float)blockingentity.getAttributeValue(Attributes.ARMOR_TOUGHNESS));
			victim.hurt(ModDamageSource.additional(attacker), damage1);
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
}