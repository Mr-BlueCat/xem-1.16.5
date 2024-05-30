package com.x4mok.xem.item;

import com.x4mok.xem.XEM;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, XEM.MODID);

    public static final RegistryObject<Item> DRAGONBLOOD = ITEMS.register("dragonblood",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(16).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> DRAGONSCALE = ITEMS.register("dragonscale",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(16).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> MAGICFRAME = ITEMS.register("magicframe",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(16).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> TRIDENTHANDLE = ITEMS.register("tridenthandle",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(16).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> TOTEMHEAD = ITEMS.register("totemhead",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(2).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> TOTEMCORE = ITEMS.register("totemcore",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(2).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> TOTEMARM = ITEMS.register("totemarm",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(4).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> TRUESCALE = ITEMS.register("truescale",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(64).rarity(Rarity.RARE)));
    


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
