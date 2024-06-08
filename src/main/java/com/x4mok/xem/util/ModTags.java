package com.x4mok.xem.util;

import com.x4mok.xem.XEM;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ModTags {

    public static class Blocks {

        private static Tags.IOptionalNamedTag<Block> createTag(String name) {
            return BlockTags.createOptional(new ResourceLocation(XEM.MODID, name));
        }

        private static Tags.IOptionalNamedTag<Block> createForgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }


    }

    public static class Items {
        public static final Tags.IOptionalNamedTag<Item> COPPER =
                createTag("ingots/copper");

        public static final Tags.IOptionalNamedTag<Item> FORGE_COPPER =
                createForgeTag("ingots/copper");

        public static final Tags.IOptionalNamedTag<Item> DIVINE =
                createTag("ingots/divine");

        public static final Tags.IOptionalNamedTag<Item> FORGE_DIVINE =
                createForgeTag("ingots/divine");

        public static final Tags.IOptionalNamedTag<Item> INGOT =
                createTag("ingots");

        public static final Tags.IOptionalNamedTag<Item> FORGE_INGOT =
                createForgeTag("ingots");

        public static final Tags.IOptionalNamedTag<Item> DRAGONSCALE =
                createTag("scales/dragon");

        public static final Tags.IOptionalNamedTag<Item> FORGE_DRAGONSCALE =
                createForgeTag("scales/dragon");

        public static final Tags.IOptionalNamedTag<Item> SCALE =
                createTag("scales");

        public static final Tags.IOptionalNamedTag<Item> FORGE_SCALE =
                createForgeTag("scales");
        private static Tags.IOptionalNamedTag<Item> createTag(String name) {
            return ItemTags.createOptional(new ResourceLocation(XEM.MODID, name));
        }

        private static Tags.IOptionalNamedTag<Item> createForgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }


    }
}
