package com.x4mok.xem.tileentity;

import com.x4mok.xem.XEM;
import com.x4mok.xem.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, XEM.MODID);

    public static final RegistryObject<TileEntityType<InfuserTile>> INFUSER = TILE_ENTITIES.register("infuser_tile",
            () -> (TileEntityType.Builder.of(InfuserTile::new, ModBlocks.INFUSER.get())).build(null));

    public static final RegistryObject<TileEntityType<InfuserTile>> ALLOY_KILN = TILE_ENTITIES.register("alloy_kiln_tile",
            () -> (TileEntityType.Builder.of(AlloyKilnTile::new, ModBlocks.ALLOYKILN.get())).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
