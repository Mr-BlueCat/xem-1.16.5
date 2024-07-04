package com.x4mok.xem.data.recipes;

import com.x4mok.xem.XEM;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeTypes {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, XEM.MODID);

    public static final RegistryObject<InfuserRecipe.Serializer> INFUSER_SERIALIZER
            = RECIPE_SERIALIZER.register("infuser", InfuserRecipe.Serializer::new);

    public static IRecipeType<InfuserRecipe> INFUSER_RECIPE
            = new InfuserRecipe.InfuserRecipeType();

    public static final RegistryObject<AlloyKilnRecipe.Serializer> ALLOY_KILN_SERIALIZER
            = RECIPE_SERIALIZER.register("alloying", AlloyKilnRecipe.Serializer::new);

    public static IRecipeType<AlloyKilnRecipe> ALLOY_KILN_RECIPE
            = new AlloyKilnRecipe.AlloyKilnRecipeType();


    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);

        Registry.register(Registry.RECIPE_TYPE, InfuserRecipe.TYPE_ID, INFUSER_RECIPE);
        Registry.register(Registry.RECIPE_TYPE, InfuserRecipe.TYPE_ID, ALLOY_KILN_RECIPE);
    }
}
