package com.x4mok.xem.block.custom.infuser;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import java.lang.Override;

public class InfuserBlock extends Block {
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