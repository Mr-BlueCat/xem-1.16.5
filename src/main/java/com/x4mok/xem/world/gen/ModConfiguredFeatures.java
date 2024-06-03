package com.x4mok.xem.world.gen;

import com.x4mok.xem.block.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MAHOGANY =
            register("mahogany", Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.MAHOGANYLOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(ModBlocks.MAHOGANYLEAVES.get().defaultBlockState()),
                    new AcaciaFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0)),
                    new ForkyTrunkPlacer(5, 4, 4),
                    new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String Id, ConfiguredFeature<FC, ?> pConfiguredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, Id, pConfiguredFeature);

    }
}
