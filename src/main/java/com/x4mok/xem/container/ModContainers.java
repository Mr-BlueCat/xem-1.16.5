package com.x4mok.xem.container;

import com.x4mok.xem.XEM;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

    public static DeferredRegister<ContainerType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, XEM.MODID);

    public static final RegistryObject<ContainerType<InfuserContainer>> INFUSER_CONTAINER =
            CONTAINERS.register("infuser_container",
                    ()-> IForgeContainerType.create(((windowId, inv, data) -> {
                        BlockPos pos = data.readBlockPos();
                        World world = inv.player.getEntity().level;
                        return new InfuserContainer(windowId, world, pos, inv, inv.player);
                    })));

    public static final RegistryObject<ContainerType<InfuserContainer>> ALLOY_KILN_CONTAINER =
            CONTAINERS.register("alloy_kiln_container",
                    ()-> IForgeContainerType.create(((windowId, inv, data) -> {
                        BlockPos pos = data.readBlockPos();
                        World world = inv.player.getEntity().level;
                        return new AlloyKilnContainer(windowId, world, pos, inv, inv.player);
                    })));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }

}
