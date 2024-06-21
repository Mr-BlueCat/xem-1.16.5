package com.x4mok.xem.world.biome;

import com.x4mok.xem.XEM;
import com.x4mok.xem.world.gen.ModConfiguredFeatures;
import com.x4mok.xem.world.gen.ModTreeGeneration;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, XEM.MODID);

    public static final RegistryObject<Biome> MAHOGANY_FOREST = BIOMES.register("mahogany_forest",
            () -> makeMahoganyForest(() -> ModConfiguredSurfaceBuilders.MAHOGANY_SURFACE, 0.125f, 0.05f));

    private static Biome makeMahoganyForest(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        BiomeGenerationSettings.Builder biomeGenerationSettingsBuilder = new BiomeGenerationSettings.Builder()
                .surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);

        // Adding structures
        biomeGenerationSettingsBuilder.addStructureStart(StructureFeatures.VILLAGE_SAVANNA)
                .addStructureStart(StructureFeatures.PILLAGER_OUTPOST)
                .addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);

        // Adding default features
        DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeGenerationSettingsBuilder);
        DefaultBiomeFeatures.addDefaultCarvers(biomeGenerationSettingsBuilder);
        DefaultBiomeFeatures.addDefaultLakes(biomeGenerationSettingsBuilder);
        DefaultBiomeFeatures.addDefaultMonsterRoom(biomeGenerationSettingsBuilder);
        DefaultBiomeFeatures.addSavannaGrass(biomeGenerationSettingsBuilder);
        DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeGenerationSettingsBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeGenerationSettingsBuilder);
        DefaultBiomeFeatures.addDefaultSoftDisks(biomeGenerationSettingsBuilder);
        biomeGenerationSettingsBuilder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModConfiguredFeatures.MAHOGANY);
        DefaultBiomeFeatures.addWarmFlowers(biomeGenerationSettingsBuilder);
        DefaultBiomeFeatures.addSavannaExtraGrass(biomeGenerationSettingsBuilder);
        DefaultBiomeFeatures.addDefaultMushrooms(biomeGenerationSettingsBuilder);
        DefaultBiomeFeatures.addDefaultExtraVegetation(biomeGenerationSettingsBuilder);
        DefaultBiomeFeatures.addDefaultSprings(biomeGenerationSettingsBuilder);
        DefaultBiomeFeatures.addSurfaceFreezing(biomeGenerationSettingsBuilder);

        return (new Biome.Builder())
                .precipitation(Biome.RainType.RAIN)
                .biomeCategory(Biome.Category.FOREST)
                .depth(depth)
                .scale(scale)
                .temperature(1.0f)
                .downfall(0.0F)
                .specialEffects((new BiomeAmbience.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(1.0f))
                        .ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS)
                        .build())
                .mobSpawnSettings(new MobSpawnInfo.Builder().build())
                .generationSettings(biomeGenerationSettingsBuilder.build())
                .build();
    }

    private static int calculateSkyColor(float pTemperature) {
        float lvt_1_1_ = pTemperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }

}
