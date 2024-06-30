package com.x4mok.xem.item;

import com.x4mok.xem.XEM;
import com.x4mok.xem.block.ModBlocks;
import com.x4mok.xem.item.custom.EndPortalDestroyerAmulet;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, XEM.MODID);

    public static final RegistryObject<Item> DRAGONBLOOD = ITEMS.register("dragonblood",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(64).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> DRAGONSCALE = ITEMS.register("dragonscale",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(64).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> MAGICFRAME = ITEMS.register("magicframe",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(64).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> TRIDENTHANDLE = ITEMS.register("tridenthandle",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(64).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> TOTEMHEAD = ITEMS.register("totemhead",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(2).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> TOTEMCORE = ITEMS.register("totemcore",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(2).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> TOTEMARM = ITEMS.register("totemarm",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(4).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> TRUESCALE = ITEMS.register("truescale",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(64).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> COPPERINGOT = ITEMS.register("copperingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COPPERSWORD = ITEMS.register("coppersword",
            () -> new SwordItem(ModItemTier.COPPER, 3, -2.4F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> COPPERAXE = ITEMS.register("copperaxe",
            () -> new AxeItem(ModItemTier.COPPER, 6.5f, -3.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> COPPERPICKAXE = ITEMS.register("copperpickaxe",
            () -> new PickaxeItem(ModItemTier.COPPER, 1, -2.8F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> COPPERSHOVEL = ITEMS.register("coppershovel",
            () -> new ShovelItem(ModItemTier.COPPER, 1.5f, -3.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> COPPERHOE = ITEMS.register("copperhoe",
            () -> new HoeItem(ModItemTier.COPPER, 0, -2.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> DRAGONSWORD = ITEMS.register("dragonsword",
            () -> new SwordItem(ModItemTier.DRAGON, 3, -2.4F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DRAGONAXE = ITEMS.register("dragonaxe",
            () -> new AxeItem(ModItemTier.DRAGON, 6.5f, -3.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DRAGONPICKAXE = ITEMS.register("dragonpickaxe",
        () -> new PickaxeItem(ModItemTier.DRAGON, 1, -2.8F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DRAGONSHOVEL = ITEMS.register("dragonshovel",
            () -> new ShovelItem(ModItemTier.DRAGON, 1.5f, -3.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DRAGONHOE = ITEMS.register("dragonhoe",
            () -> new HoeItem(ModItemTier.DRAGON, 0, -2.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> AMULET = ITEMS.register("amulet",
            () -> new EndPortalDestroyerAmulet(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(1).rarity(Rarity.UNCOMMON).defaultDurability(12)));
    public static final RegistryObject<Item> DRAGONHELMET = ITEMS.register("dragonhelmet",
            () -> new ArmorItem(ModArmourMaterial.DRAGON, EquipmentSlotType.HEAD, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DRAGONCHESTPLATE = ITEMS.register("dragonchestplate",
            () -> new ArmorItem(ModArmourMaterial.DRAGON, EquipmentSlotType.CHEST, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DRAGONLEGGINGS = ITEMS.register("dragonleggings",
            () -> new ArmorItem(ModArmourMaterial.DRAGON, EquipmentSlotType.LEGS, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DRAGONBOOTS = ITEMS.register("dragonboots",
            () -> new ArmorItem(ModArmourMaterial.DRAGON, EquipmentSlotType.FEET, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> COPPERHELMET = ITEMS.register("copperhelmet",
            () -> new ArmorItem(ModArmourMaterial.COPPER, EquipmentSlotType.HEAD, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> COPPERCHESTPLATE = ITEMS.register("copperchestplate",
            () -> new ArmorItem(ModArmourMaterial.COPPER, EquipmentSlotType.CHEST, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> COPPERLEGGINGS = ITEMS.register("copperleggings",
            () -> new ArmorItem(ModArmourMaterial.COPPER, EquipmentSlotType.LEGS, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> COPPERBOOTS = ITEMS.register("copperboots",
            () -> new ArmorItem(ModArmourMaterial.COPPER, EquipmentSlotType.FEET, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes",
            () -> new BlockItem(ModBlocks.GRAPES.get(), (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON)).food(new Food.Builder().nutrition(1).saturationMod(1.0f).fast().build())));
    public static final RegistryObject<Item> DIVINEINGOT = ITEMS.register("divineingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> DIVINEHELMET = ITEMS.register("divinehelmet",
            () -> new ArmorItem(ModArmourMaterial.DIVINE, EquipmentSlotType.HEAD, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DIVINECHESTPLATE = ITEMS.register("divinechestplate",
            () -> new ArmorItem(ModArmourMaterial.DIVINE, EquipmentSlotType.CHEST, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DIVINELEGGINGS = ITEMS.register("divineleggings",
            () -> new ArmorItem(ModArmourMaterial.DIVINE, EquipmentSlotType.LEGS, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DIVINEBOOTS = ITEMS.register("divineboots",
            () -> new ArmorItem(ModArmourMaterial.DIVINE, EquipmentSlotType.FEET, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DIVINESWORD = ITEMS.register("divinesword",
            () -> new SwordItem(ModItemTier.DIVINE, 3, -2.4F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DIVINEAXE = ITEMS.register("divineaxe",
            () -> new AxeItem(ModItemTier.DIVINE, 6.5f, -3.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DIVINEPICKAXE = ITEMS.register("divinepickaxe",
            () -> new PickaxeItem(ModItemTier.DIVINE, 1, -2.8F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DIVINESHOVEL = ITEMS.register("divineshovel",
            () -> new ShovelItem(ModItemTier.DIVINE, 1.5f, -3.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> DIVINEHOE = ITEMS.register("divinehoe",
            () -> new HoeItem(ModItemTier.DIVINE, 0, -2.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.UNCOMMON))));
    public static final RegistryObject<Item> STEELINGOT = ITEMS.register("steelingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> STEELSWORD = ITEMS.register("steelsword",
            () -> new SwordItem(ModItemTier.STEEL, 3, -2.4F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> STEELAXE = ITEMS.register("steelaxe",
            () -> new AxeItem(ModItemTier.STEEL, 6.5f, -3.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> STEELPICKAXE = ITEMS.register("steelpickaxe",
            () -> new PickaxeItem(ModItemTier.STEEL, 1, -2.8F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> STEELSHOVEL = ITEMS.register("steelshovel",
            () -> new ShovelItem(ModItemTier.STEEL, 1.5f, -3.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> STEELHOE = ITEMS.register("steelhoe",
            () -> new HoeItem(ModItemTier.STEEL, 0, -2.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> STEELHELMET = ITEMS.register("steelhelmet",
            () -> new ArmorItem(ModArmourMaterial.STEEL, EquipmentSlotType.HEAD, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> STEELCHESTPLATE = ITEMS.register("steelchestplate",
            () -> new ArmorItem(ModArmourMaterial.STEEL, EquipmentSlotType.CHEST, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> STEELLEGGINGS = ITEMS.register("steelleggings",
            () -> new ArmorItem(ModArmourMaterial.STEEL, EquipmentSlotType.LEGS, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> STEELBOOTS = ITEMS.register("steelboots",
            () -> new ArmorItem(ModArmourMaterial.STEEL, EquipmentSlotType.FEET, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> ALUMINIUMINGOT = ITEMS.register("aluminiumingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.XEMTAB).stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> ALUMINIUMSWORD = ITEMS.register("aluminiumsword",
            () -> new SwordItem(ModItemTier.ALUMINIUM, 3, -2.4F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> ALUMINIUMAXE = ITEMS.register("aluminiumaxe",
            () -> new AxeItem(ModItemTier.ALUMINIUM, 6.5f, -3.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> ALUMINIUMPICKAXE = ITEMS.register("aluminiumpickaxe",
            () -> new PickaxeItem(ModItemTier.ALUMINIUM, 1, -2.8F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> ALUMINIUMSHOVEL = ITEMS.register("aluminiumshovel",
            () -> new ShovelItem(ModItemTier.ALUMINIUM, 1.5f, -3.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> ALUMINIUMHOE = ITEMS.register("aluminiumhoe",
            () -> new HoeItem(ModItemTier.ALUMINIUM, 0, -2.0F, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> ALUMINIUMHELMET = ITEMS.register("aluminiumhelmet",
            () -> new ArmorItem(ModArmourMaterial.ALUMINIUM, EquipmentSlotType.HEAD, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> ALUMINIUMCHESTPLATE = ITEMS.register("aluminiumchestplate",
            () -> new ArmorItem(ModArmourMaterial.ALUMINIUM, EquipmentSlotType.CHEST, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> ALUMINIUMLEGGINGS = ITEMS.register("aluminiumleggings",
            () -> new ArmorItem(ModArmourMaterial.ALUMINIUM, EquipmentSlotType.LEGS, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));
    public static final RegistryObject<Item> ALUMINIUMBOOTS = ITEMS.register("aluminiumboots",
            () -> new ArmorItem(ModArmourMaterial.ALUMINIUM, EquipmentSlotType.FEET, (new Item.Properties().tab(ModItemGroup.XEMTAB).rarity(Rarity.COMMON))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
