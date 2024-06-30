package com.x4mok.xem.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {
    ALUMINIUM(2, 240, 4.0f, 1.5f, 30, () -> Ingredient.of(ModItems.ALUMINIUMINGOT.get())),
    COPPER(2, 300, 5.0f, 2.0f, 14, () -> Ingredient.of(ModItems.COPPERINGOT.get())),
    STEEL(2, 900, 6.5f, 2.5f, 11, () -> Ingredient.of(ModItems.STEELINGOT.get())),
    DRAGON(5, 3131, 10.5f, 5.0f, 15, () -> Ingredient.of(ModItems.DRAGONSCALE.get())),
    DIVINE(6, 3662, 11.5f, 6.0f, 16, () -> Ingredient.of(ModItems.DIVINEINGOT.get())),
    ANCIENT(7, 4181, 12.5f, 6.5f, 13, () -> Ingredient.of(ModItems.ANCIENTINGOT.get()));

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;

    ModItemTier(int level, int uses, float speed,
                float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyValue<>(repairIngredient);
    }


    @Override
    public int getUses() {
        return uses; // 300
    }

    @Override
    public float getSpeed() {
        return speed; // 5.0f
    }

    @Override
    public float getAttackDamageBonus() {
        return damage; // 2.0f
    }

    @Override
    public int getLevel() {
        return level; // 2
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue; // 14
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get(); //copper ingot
    }
}
