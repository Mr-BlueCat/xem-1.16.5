package com.x4mok.xem.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup XEMTAB = new ItemGroup("xemtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DRAGONBLOOD.get());
        }
    };

}
