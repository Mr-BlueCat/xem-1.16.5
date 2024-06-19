package com.x4mok.xem.world;

import com.mojang.serialization.Codec;
import com.x4mok.xem.XEM;
import com.x4mok.xem.world.gen.ModOreGeneration;
import com.x4mok.xem.world.gen.ModStructureGeneration;
import com.x4mok.xem.world.gen.ModTreeGeneration;
import com.x4mok.xem.world.structure.ModStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = XEM.MODID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModStructureGeneration.generateStructures(event);

        ModOreGeneration.generateOres(event);

        ModTreeGeneration.generateTrees(event);
    }

    @SubscribeEvent
    public static void addDimensionalSpacing(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();

            try {
                Method GETCODEC_METHOD =
                        ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey(
                        (Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));

                if (cgRL != null && cgRL.getNamespace().equals("terraforged")) {
                    return;
                }
            } catch (Exception e) {
                LogManager.getLogger().error("Was unable to check if " + serverWorld.dimensionType()
                + " is using Terraforged's ChunkGenerator (i have 0 clue if the thing is right)");
            }

            Map<Structure<?>, StructureSeparationSettings> tempMap =
                    new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(ModStructures.WIZARD_TOWER.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.WIZARD_TOWER.get()));
            tempMap.putIfAbsent(ModStructures.TREEHOUSE.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.TREEHOUSE.get()));
            tempMap.putIfAbsent(ModStructures.ANCIENT_FARM.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.ANCIENT_FARM.get()));
            tempMap.putIfAbsent(ModStructures.BUNKER.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.BUNKER.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;

        }
    }
}
