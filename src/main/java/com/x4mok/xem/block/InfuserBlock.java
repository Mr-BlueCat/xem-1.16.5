package com.x4mok.xem.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class InfuserBlock extends Block {

    // Define the shape of the block (16x16 horizontally and 13 units high)
    private static final VoxelShape SHAPE = VoxelShapes.box(0, 0, 0, 1, 13/16.0, 1);

    public InfuserBlock() {
        super(Properties.of(Material.STONE)
                .strength(7f)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}