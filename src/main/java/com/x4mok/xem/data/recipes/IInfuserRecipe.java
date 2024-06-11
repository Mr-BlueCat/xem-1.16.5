package com.x4mok.xem.data.recipes;

import com.x4mok.xem.XEM;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public interface IInfuserRecipe extends IRecipe<IInventory> {
    ResourceLocation TYPE_ID = new ResourceLocation(XEM.MODID, "lightning");

    @Override
    default IRecipeType<?> getType(){
        return Registry.RECIPE_TYPE.getOptional(TYPE_ID).get();
    }

    @Override
    default boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    default boolean isSpecial(){
        return true;
    }

}
