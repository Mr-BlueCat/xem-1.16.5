package com.x4mok.xem.world.gen;

import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        for (OreType ore : OreType.values()) {
            OreFeatureConfig oreFeatureConfig;

            if (new String(String.valueOf(ore)).equals("DIVINE")) {
                oreFeatureConfig = new OreFeatureConfig(
                        new BlockMatchRuleTest(Blocks.END_STONE),
                        ore.getBlock().get().defaultBlockState(), ore.getMaxVeinSize());
            } else {
                oreFeatureConfig = new OreFeatureConfig(
                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                        ore.getBlock().get().defaultBlockState(), ore.getMaxVeinSize());
            }

            ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configured(
                    new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));


            ConfiguredFeature<?,?> oreFeature = registerOreFeature(ore, oreFeatureConfig, configuredPlacement);

            //you can add if statements cause in biome thingy
            RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
            Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
/*
            if(types.contains(BiomeDictionary.Type.END)) {
                List<Supplier<ConfiguredFeature<?,?>>> base =
                        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES);
                base.add()
            }
*/
            if (new String(String.valueOf(ore)).equals("DIVINE")) {
                if(types.contains(BiomeDictionary.Type.END)) {
                    event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
                }
            } else {
                event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
            }



        }
    }


    private static ConfiguredFeature<?,?> registerOreFeature(OreType ore, OreFeatureConfig oreFeatureConfig,
                                                             ConfiguredPlacement configuredPlacement) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ore.getBlock().get().getRegistryName(), Feature.ORE.configured(oreFeatureConfig).decorated(configuredPlacement).squared().count(ore.getMaxVeinSize()));
    }
}
