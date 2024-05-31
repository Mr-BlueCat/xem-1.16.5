package com.x4mok.xem.item.custom;

import com.x4mok.xem.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class EndPortalDestroyerAmulet extends Item {
    public EndPortalDestroyerAmulet(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getLevel();

        if(!world.isClientSide) {
            PlayerEntity playerEntity = context.getPlayer();
            BlockState clickedBlock = world.getBlockState(context.getClickedPos());

            rightClickOnCertainBlockState(clickedBlock, context, playerEntity);
            int damage = stack.getDamageValue();
            stack.setDamageValue(damage - 1);
            if (damage <= 1) {
                stack.shrink(1);
            }
        }

        return super.onItemUseFirst(stack, context);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {

        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.xem.amulet_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.xem.amulet"));
        }
        super.appendHoverText(stack, world, tooltip, flag);
    }

    private void rightClickOnCertainBlockState(BlockState clickedBlock, ItemUseContext context,
                                               PlayerEntity playerEntity) {
        ItemStack itemStack = new ItemStack(Items.END_PORTAL_FRAME);
        World world = context.getLevel();

        if (blockIsValidToBreak(clickedBlock)) {
            destroyBlock(context.getLevel(), context.getClickedPos());
            ItemEntity itemEntity = new ItemEntity(world, playerEntity.position().x, playerEntity.position().y, playerEntity.position().z, itemStack);
            world.addFreshEntity(itemEntity);
        }
    }

    private void destroyBlock(World world, BlockPos pos) {
        world.destroyBlock(pos, false);
    }

    private boolean blockIsValidToBreak(BlockState clickedBlock) {
        return clickedBlock.getBlock() == Blocks.END_PORTAL_FRAME;
    }
}
