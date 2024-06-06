package com.x4mok.xem.tileentity;

import com.x4mok.xem.XEM;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, XEM.MODID);

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
