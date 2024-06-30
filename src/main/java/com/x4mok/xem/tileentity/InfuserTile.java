package com.x4mok.xem.tileentity;

import com.x4mok.xem.data.recipes.InfuserRecipe;
import com.x4mok.xem.data.recipes.ModRecipeTypes;
import com.x4mok.xem.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.inventory.Inventory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public class InfuserTile extends TileEntity implements ITickableTileEntity{

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public InfuserTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public InfuserTile() {
        this(ModTileEntities.INFUSER.get());
    }

    @Override
    public void load(BlockState blockState, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.load(blockState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        return super.save(compound);
    }

    public boolean isInfusingMaterial(ItemStack stack) {
        return stack.getItem().is(ItemTags.createOptional(new ResourceLocation("xem", "infusingmaterials"))) || stack.getItem().is(ItemTags.createOptional(new ResourceLocation("forge", "infusingmaterials")));
    }
    public boolean isInfusable(ItemStack stack) {
        return stack.getItem().is(ItemTags.createOptional(new ResourceLocation("xem", "infusablematerials"))) || stack.getItem().is(ItemTags.createOptional(new ResourceLocation("forge", "infusablematerials")));
    }

    public boolean isInfusingResult(ItemStack stack) {
        return stack.getItem().is(ItemTags.createOptional(new ResourceLocation("xem", "infusingresults"))) || stack.getItem().is(ItemTags.createOptional(new ResourceLocation("forge", "infusingresults")));
    }


    private ItemStackHandler createHandler() {
        return new ItemStackHandler(6) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot) {
                    case 0: return isInfusable(stack);
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        return isInfusingMaterial(stack);
                    case 5:
                        return isInfusingResult(stack);
                    default:
                        return false;
                }
            }

            @Override
            public int getSlotLimit(int slot) {
                return 64;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot, stack)) {
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }

        return super.getCapability(cap, side);
    }

    public void craft() {
        Inventory inv = new Inventory(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }

        Optional<InfuserRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ModRecipeTypes.INFUSER_RECIPE, inv, level);

        recipe.ifPresent(iRecipe -> {
            ItemStack output = iRecipe.getResultItem();
            if (itemHandler.getStackInSlot(5) != ItemStack.EMPTY) {
                if (itemHandler.getStackInSlot(5).getItem() == output.getStack().getItem() && itemHandler.getStackInSlot(5).getCount() <= 63) {
                    int amount = iRecipe.getAmount();

                    craftTheItem(output, amount);

                    setChanged();
                }
            } else {
                int amount = iRecipe.getAmount();

                craftTheItem(output, amount);

                setChanged();
            }

        });
    }

    private void craftTheItem(ItemStack output, int amount) {
        itemHandler.extractItem(0, 1, false);
        itemHandler.extractItem(1, 1, false);
        itemHandler.extractItem(2, 1, false);
        itemHandler.extractItem(3, 1, false);
        itemHandler.extractItem(4, 1, false);
        itemHandler.insertItem(5, output, false);
    }

    @Override
    public void tick() {
        if(level.isClientSide) {
            return;
        }

        craft();
    }
}
