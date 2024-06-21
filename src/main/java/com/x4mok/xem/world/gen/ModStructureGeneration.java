package com.x4mok.xem.world.gen;

import com.x4mok.xem.world.structure.ModStructures;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModStructureGeneration {
    public static void generateStructures(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();
        if(types.contains(BiomeDictionary.Type.OVERWORLD)) {
            if (!types.contains(BiomeDictionary.Type.OCEAN) && !types.contains(BiomeDictionary.Type.RIVER) && !types.contains(BiomeDictionary.Type.BEACH)) {
                structures.add(() -> ModStructures.WIZARD_TOWER.get().configured(IFeatureConfig.NONE));
                structures.add(() -> ModStructures.ANCIENT_FARM.get().configured(IFeatureConfig.NONE));
                if (!types.contains(BiomeDictionary.Type.PLAINS) && !types.contains(BiomeDictionary.Type.COLD) && !types.contains(BiomeDictionary.Type.HOT) && !types.contains(BiomeDictionary.Type.SWAMP)) {
                    structures.add(() -> ModStructures.TREEHOUSE.get().configured(IFeatureConfig.NONE));
                    structures.add(() -> ModStructures.BUNKER.get().configured(IFeatureConfig.NONE));
                }
            }
        }

    }

}
