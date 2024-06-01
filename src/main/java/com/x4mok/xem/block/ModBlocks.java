package com.x4mok.xem.block;

import com.x4mok.xem.XEM;
import com.x4mok.xem.block.custom.GrapeBlock;
import com.x4mok.xem.block.custom.infuser.InfuserBlock;
import com.x4mok.xem.item.ModItemGroup;
import com.x4mok.xem.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
