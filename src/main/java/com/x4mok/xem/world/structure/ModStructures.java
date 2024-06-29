package com.x4mok.xem.world.structure;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.x4mok.xem.XEM;
import com.x4mok.xem.world.structure.structures.*;
import jdk.nashorn.internal.ir.annotations.Immutable;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class ModStructures {
    public static final DeferredRegister<Structure<?>> STRUCTURES =
            DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, XEM.MODID);

    public static final RegistryObject<Structure<NoFeatureConfig>> WIZARD_TOWER =
            STRUCTURES.register("wizard_tower", WizardTowerStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> TREEHOUSE =
            STRUCTURES.register("treehouse", TreehouseStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> ANCIENT_FARM =
            STRUCTURES.register("ancient_farm", AncientFarmStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> BUNKER =
            STRUCTURES.register("bunker", BunkerStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> VAULT =
            STRUCTURES.register("vault", VaultStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> STATION =
            STRUCTURES.register("station", StationStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> FOSSIL =
            STRUCTURES.register("fossil", FossilStructure::new);

    public static void setupStructures() {
        setupMapSpacingAndLand(WIZARD_TOWER.get(),
                new StructureSeparationSettings(100, 35, 1234567890), true);
        setupMapSpacingAndLand(TREEHOUSE.get(),
                new StructureSeparationSettings(45, 33, 1983402567), true);
        setupMapSpacingAndLand(ANCIENT_FARM.get(),
                new StructureSeparationSettings(45, 33, 1053495435), true);
        setupMapSpacingAndLand(BUNKER.get(),
                new StructureSeparationSettings(45, 40, 743325235), true);
        setupMapSpacingAndLand(VAULT.get(),
                new StructureSeparationSettings(115, 114, 584929866), true);
        setupMapSpacingAndLand(STATION.get(),
                new StructureSeparationSettings(100, 35, 1243254523), true);
        setupMapSpacingAndLand(FOSSIL.get(),
                new StructureSeparationSettings(25, 5, 254302342), true);
        // int 1 = average dist in chunks between spawn attempts
        // int 2 = min dist in chunks between spawn attempts >> MUST BE SMALLER THAN int 1 <<
        // int 3 modifies see of structure so no two structures spawn over each-other - should be large and unique // btw 2147483647 is integer limit
    }

    public static <F extends Structure<?>> void  setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {

        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);

        if (transformSurroundingLand) {
            Structure.NOISE_AFFECTING_FEATURES = ImmutableList.<Structure<?>>builder()
                    .addAll(Structure.NOISE_AFFECTING_FEATURES)
                    .add(structure)
                    .build();
        }
        /*
         * This is the map that holds the default spacing of all structures.
         * Always add your structure to here so that other mods can utilize it if needed.
         *
         * However, while it does propagate the spacing to some correct dimensions from this map,
         * it seems it doesn't always work for code made dimensions as they read from this list beforehand.
         *
         * Instead, we will use the WorldEvent.Load event in ModWorldEvents to add the structure
         * spacing from this list into that dimension or to do dimension blacklisting properly.
         * We also use our entry in DimensionStructuresSettings.DEFAULTS in WorldEvent.Load as well.
         *
         * DEFAULTS requires AccessTransformer  (See resources/META-INF/accesstransformer.cfg)
         */
        DimensionStructuresSettings.DEFAULTS =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.DEFAULTS)
                        .put(structure, structureSeparationSettings)
                        .build();

        /*
         * There are very few mods that relies on seeing your structure in the
         * noise settings registry before the world is made.
         *
         * You may see some mods add their spacings to DimensionSettings.BUILTIN_OVERWORLD instead of the
         * NOISE_GENERATOR_SETTINGS loop below but that field only applies for the default overworld and
         * won't add to other worldtypes or dimensions (like amplified or Nether).
         * So yeah, don't do DimensionSettings.BUILTIN_OVERWORLD. Use the NOISE_GENERATOR_SETTINGS loop
         * below instead if you must.
         */
        WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap =
                    settings.getValue().structureSettings().structureConfig();
            /*
             * Pre-caution in case a mod makes the structure map immutable like datapacks do.
             * I take no chances myself. You never know what another mod does...
             *
             * structureConfig requires AccessTransformer  (See resources/META-INF/accesstransformer.cfg)
             */
            if (structureMap instanceof ImmutableMap) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().structureSettings().structureConfig();

            } else {
                structureMap.put(structure, structureSeparationSettings);
            }
        });

    }

    public static void register(IEventBus eventBus) {
        STRUCTURES.register(eventBus);
    }

}
