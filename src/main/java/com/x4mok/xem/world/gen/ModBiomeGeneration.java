package com.x4mok.xem.world.gen;

import com.x4mok.xem.world.biome.ModBiomes;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModBiomeGeneration {
    public static void generateBiomes() {
        addBiome(ModBiomes.MAHOGANY_FOREST.get(), BiomeManager.BiomeType.WARM, 20, BiomeDictionary.Type.HOT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET);
        addBiome(ModBiomes.MAHOGANY_OPEN_FOREST.get(), BiomeManager.BiomeType.WARM, 20, BiomeDictionary.Type.HOT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET);
    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.create(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }
}
