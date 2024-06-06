package com.x4mok.xem.block;

import com.x4mok.xem.XEM;
import com.x4mok.xem.block.custom.GhostPillarBlock;
import com.x4mok.xem.block.custom.GrapeBlock;
import com.x4mok.xem.block.custom.HiddenOpenableBlocks;
import com.x4mok.xem.block.custom.infuser.InfuserBlock;
import com.x4mok.xem.block.custom.trees.MahoganyTree;
import com.x4mok.xem.item.ModItemGroup;
import com.x4mok.xem.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, XEM.MODID);

    public static final RegistryObject<Block> MAGICENDSTONE = registerBlock("magicendstone",
        () -> new Block(AbstractBlock.Properties.of(Material.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(5f)));
    public static final RegistryObject<Block> INFUSER = registerBlock("infuser",
            InfuserBlock::new);
    public static final RegistryObject<Block> COPPERORE = registerBlock("copperore",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(5f)));
    public static final RegistryObject<Block> COPPERBLOCK = registerBlock("copperblock",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(5f)));
    public static final RegistryObject<Block> COPPERSTAIRS = registerBlock("copperstairs",
            () -> new StairsBlock(() -> COPPERBLOCK.get().defaultBlockState(), AbstractBlock.Properties.of(Material.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> IRONSTAIRS = registerBlock("ironstairs",
            () -> new StairsBlock(Blocks.IRON_BLOCK::defaultBlockState, AbstractBlock.Properties.of(Material.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DIAMONDSTAIRS = registerBlock("diamondstairs",
            () -> new StairsBlock(Blocks.DIAMOND_BLOCK::defaultBlockState, AbstractBlock.Properties.of(Material.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NETHERITESTAIRS = registerBlock("netheritestairs",
            () -> new StairsBlock(Blocks.NETHERITE_BLOCK::defaultBlockState, AbstractBlock.Properties.of(Material.METAL).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> REDSTONESTAIRS = registerBlock("redstonestairs",
            () -> new StairsBlock(Blocks.REDSTONE_BLOCK::defaultBlockState, AbstractBlock.Properties.of(Material.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LAPISSTAIRS = registerBlock("lapisstairs",
            () -> new StairsBlock(Blocks.LAPIS_BLOCK::defaultBlockState, AbstractBlock.Properties.of(Material.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COALSTAIRS = registerBlock("coalstairs",
            () -> new StairsBlock(Blocks.COAL_BLOCK::defaultBlockState, AbstractBlock.Properties.of(Material.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GOLDSTAIRS = registerBlock("goldstairs",
            () -> new StairsBlock(Blocks.GOLD_BLOCK::defaultBlockState, AbstractBlock.Properties.of(Material.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> EMERALDSTAIRS = registerBlock("emeraldstairs",
            () -> new StairsBlock(Blocks.EMERALD_BLOCK::defaultBlockState, AbstractBlock.Properties.of(Material.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GRAPES = BLOCKS.register("grapes_crop",
            () -> new GrapeBlock(AbstractBlock.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> MAHOGANYLOG = registerBlock("mahoganylog",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> MAHOGANYWOOD = registerBlock("mahoganywood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> STRIPPEDMAHOGANYLOG = registerBlock("strippedmahoganylog",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> STRIPPEDMAHOGANYWOOD = registerBlock("strippedmahoganywood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> MAHOGANYPLANKS = registerBlock("mahoganyplanks",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.OAK_PLANKS).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> MAHOGANYFENCE = registerBlock("mahoganyfence",
            () -> new FenceBlock(AbstractBlock.Properties.copy(Blocks.OAK_FENCE).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> MAHOGANYFENCEGATE = registerBlock("mahoganyfencegate",
            () -> new FenceGateBlock(AbstractBlock.Properties.copy(Blocks.OAK_FENCE).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> MAHOGANYSLAB = registerBlock("mahoganyslab",
            () -> new SlabBlock(AbstractBlock.Properties.copy(Blocks.OAK_FENCE).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> MAHOGANYPRESSUREPLATE = registerBlock("mahoganypressureplate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.copy(Blocks.OAK_FENCE).harvestTool(ToolType.AXE).noCollission()));
    public static final RegistryObject<Block> MAHOGANYBUTTON = registerBlock("mahoganybutton",
            () -> new WoodButtonBlock(AbstractBlock.Properties.copy(Blocks.OAK_FENCE).harvestTool(ToolType.AXE).noCollission()));
    public static final RegistryObject<Block> MAHOGANYDOOR = registerBlock("mahoganydoor",
            () -> new DoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_DOOR).harvestTool(ToolType.AXE).noOcclusion()));
    public static final RegistryObject<Block> MAHOGANYTRAPDOOR = registerBlock("mahoganytrapdoor",
            () -> new TrapDoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR).harvestTool(ToolType.AXE).noOcclusion()));
    public static final RegistryObject<Block> MAHOGANYHIDDENDOOR = BLOCKS.register("mahoganyhiddendoor",
            () -> new DoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_PLANKS).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> MAHOGANYHIDDENTRAPDOOR = BLOCKS.register("mahoganyhiddentrapdoor",
            () -> new TrapDoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_PLANKS).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Item> MAHOGANYHIDDENDOORITEM = ModItems.ITEMS.register("mahoganyhiddendoor",
            () -> new HiddenOpenableBlocks(MAHOGANYHIDDENDOOR.get(), new Item.Properties().tab(ModItemGroup.XEMTAB)));
    public static final RegistryObject<Item> MAHOGANYHIDDENTRAPDOORITEM = ModItems.ITEMS.register("mahoganyhiddentrapdoor",
            () -> new HiddenOpenableBlocks(MAHOGANYHIDDENTRAPDOOR.get(), new Item.Properties().tab(ModItemGroup.XEMTAB)));
    public static final RegistryObject<Block> GHOSTOAKLOG = BLOCKS.register("ghostoaklog",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG).harvestTool(ToolType.AXE).noCollission()));
    public static final RegistryObject<Item> GHOSTOAKLOGITEM = ModItems.ITEMS.register("ghostoaklog",
            () -> new GhostPillarBlock(GHOSTOAKLOG.get(), new Item.Properties().tab(ModItemGroup.XEMTAB)));
    public static final RegistryObject<Block> GHOSTSPRUCELOG = BLOCKS.register("ghostsprucelog",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG).harvestTool(ToolType.AXE).noCollission()));
    public static final RegistryObject<Item> GHOSTSPRUCELOGITEM = ModItems.ITEMS.register("ghostsprucelog",
            () -> new GhostPillarBlock(GHOSTSPRUCELOG.get(), new Item.Properties().tab(ModItemGroup.XEMTAB)));
    public static final RegistryObject<Block> GHOSTDARKOAKLOG = BLOCKS.register("ghostdarkoaklog",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG).harvestTool(ToolType.AXE).noCollission()));
    public static final RegistryObject<Item> GHOSTDARKOAKLOGITEM = ModItems.ITEMS.register("ghostdarkoaklog",
            () -> new GhostPillarBlock(GHOSTDARKOAKLOG.get(), new Item.Properties().tab(ModItemGroup.XEMTAB)));
    public static final RegistryObject<Block> MAHOGANYLEAVES = registerBlock("mahoganyleaves",
            () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).harvestTool(ToolType.HOE).strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> MAHOGANYSAPLING = registerBlock("mahoganysapling",
            () -> new SaplingBlock(new MahoganyTree(),AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> DIVINEORE = registerBlock("divineore",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE).harvestLevel(5).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(5f)));
    public static final RegistryObject<Block> DIVINEBLOCK = registerBlock("divineblock",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL).harvestLevel(5).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().strength(5f)));
    public static final RegistryObject<Block> DIVINESTAIRS = registerBlock("divinestairs",
            () -> new StairsBlock(() -> DIVINEBLOCK.get().defaultBlockState(), AbstractBlock.Properties.of(Material.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));


    private static  <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends  Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModItemGroup.XEMTAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
