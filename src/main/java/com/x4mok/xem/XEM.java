package com.x4mok.xem;

import com.google.common.collect.ImmutableMap;
import com.x4mok.xem.block.ModBlocks;
import com.x4mok.xem.container.ModContainers;
import com.x4mok.xem.data.recipes.ModRecipeTypes;
import com.x4mok.xem.events.DragonDrops;
import com.x4mok.xem.item.ModItems;
import com.x4mok.xem.screen.InfuserScreen;
import com.x4mok.xem.tileentity.ModTileEntities;
import jdk.nashorn.internal.ir.annotations.Immutable;
import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.AxeItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(XEM.MODID)
public class XEM {
    // Directly reference a log4j logger.

    public static final String MODID = "xem";

    private static final Logger LOGGER = LogManager.getLogger();

    public XEM() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModTileEntities.register(eventBus);
        ModContainers.register(eventBus);
        ModRecipeTypes.register(eventBus);

        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(DragonDrops.class);
        event.enqueueWork(() -> {
            AxeItem.STRIPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPABLES)
                    .put(ModBlocks.MAHOGANYLOG.get(), ModBlocks.STRIPPEDMAHOGANYLOG.get())
                    .put(ModBlocks.MAHOGANYWOOD.get(), ModBlocks.STRIPPEDMAHOGANYWOOD.get()).build();
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.MAHOGANYDOOR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.MAHOGANYTRAPDOOR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.MAHOGANYHIDDENDOOR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.MAHOGANYHIDDENTRAPDOOR.get(), RenderType.cutout());

            RenderTypeLookup.setRenderLayer(ModBlocks.GRAPES.get(), RenderType.cutout());

            RenderTypeLookup.setRenderLayer(ModBlocks.MAHOGANYLEAVES.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.MAHOGANYSAPLING.get(), RenderType.cutout());

            ScreenManager.register(ModContainers.INFUSER_CONTAINER.get(), InfuserScreen::new);
        });
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(modid = XEM.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
    }
}
