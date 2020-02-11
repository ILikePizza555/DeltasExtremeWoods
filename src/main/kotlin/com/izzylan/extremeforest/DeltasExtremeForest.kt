package com.izzylan.extremeforest

import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate
import net.minecraft.entity.EntityCategory
import net.minecraft.entity.EntityType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.DefaultBiomeFeatures
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.ProbabilityConfig
import net.minecraft.world.gen.carver.Carver
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.FeatureConfig
import net.minecraft.world.gen.feature.MineshaftFeature
import net.minecraft.world.gen.feature.MineshaftFeatureConfig
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder

const val ModId: String = "deltas_extreme_forest"

val DeltasExtremeForestBiomeSettings: Biome.Settings = Biome.Settings()
    .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
    .precipitation(Biome.Precipitation.RAIN)
    .category(Biome.Category.FOREST)
    .depth(1.0F)
    .scale(0.5F)
    .temperature(0.6F)
    .downfall(0.7F)
    .waterColor(4159204)
    .waterFogColor(329011)
    .parent(null)

class DeltasExtremeForestBiome() : Biome(DeltasExtremeForestBiomeSettings) {
    init {
        addStructureFeature(Feature.MINESHAFT.configure(MineshaftFeatureConfig(0.05, MineshaftFeature.Type.NORMAL)))
        addStructureFeature(Feature.STRONGHOLD.configure(FeatureConfig.DEFAULT))

        addCarver(GenerationStep.Carver.AIR,
            configureCarver(
                Carver.CAVE,
                ProbabilityConfig(0.34285715f)
            )
        )
        addCarver(
            GenerationStep.Carver.AIR,
            configureCarver(
                Carver.CANYON,
                ProbabilityConfig(0.03f)
            )
        )

        DefaultBiomeFeatures.addDefaultStructures(this)
        DefaultBiomeFeatures.addDefaultLakes(this)
        DefaultBiomeFeatures.addDungeons(this)
        DefaultBiomeFeatures.addMineables(this)
        DefaultBiomeFeatures.addDefaultOres(this)
        DefaultBiomeFeatures.addDefaultDisks(this)
        DefaultBiomeFeatures.addExtraMountainTrees(this)
        DefaultBiomeFeatures.addDefaultFlowers(this)
        DefaultBiomeFeatures.addDefaultGrass(this)
        DefaultBiomeFeatures.addDefaultMushrooms(this)
        DefaultBiomeFeatures.addDefaultVegetation(this)
        DefaultBiomeFeatures.addSprings(this)
        DefaultBiomeFeatures.addEmeraldOre(this)
        DefaultBiomeFeatures.addInfestedStone(this)
        DefaultBiomeFeatures.addFrozenTopLayer(this)

        addSpawn(EntityCategory.CREATURE, SpawnEntry(EntityType.SHEEP, 12, 4, 4))
        addSpawn(EntityCategory.CREATURE, SpawnEntry(EntityType.PIG, 10, 4, 4))
        addSpawn(EntityCategory.CREATURE, SpawnEntry(EntityType.CHICKEN, 10, 4, 4))
        addSpawn(EntityCategory.CREATURE, SpawnEntry(EntityType.COW, 8, 4, 4))
        addSpawn(EntityCategory.CREATURE, SpawnEntry(EntityType.LLAMA, 5, 4, 6))
        addSpawn(EntityCategory.AMBIENT, SpawnEntry(EntityType.BAT, 10, 8, 8))
        addSpawn(EntityCategory.MONSTER, SpawnEntry(EntityType.SPIDER, 100, 4, 4))
        addSpawn(EntityCategory.MONSTER, SpawnEntry(EntityType.ZOMBIE, 95, 4, 4))
        addSpawn(EntityCategory.MONSTER, SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
        addSpawn(EntityCategory.MONSTER, SpawnEntry(EntityType.SKELETON, 100, 4, 4))
        addSpawn(EntityCategory.MONSTER, SpawnEntry(EntityType.CREEPER, 100, 4, 4))
        addSpawn(EntityCategory.MONSTER, SpawnEntry(EntityType.SLIME, 100, 4, 4))
        addSpawn(EntityCategory.MONSTER, SpawnEntry(EntityType.ENDERMAN, 10, 1, 4))
        addSpawn(EntityCategory.MONSTER, SpawnEntry(EntityType.WITCH, 5, 1, 1))
    }
}

val DELTAS_EXTREME_FOREST_BIOME: Biome = Registry.register(
    Registry.BIOME,
    Identifier(ModId, "delta_extreme_forest"),
    DeltasExtremeForestBiome()
)

@Suppress("unused")
fun init() {
    OverworldBiomes.addContinentalBiome(DELTAS_EXTREME_FOREST_BIOME, OverworldClimate.TEMPERATE, 2.0)
    OverworldBiomes.addContinentalBiome(DELTAS_EXTREME_FOREST_BIOME, OverworldClimate.COOL, 2.0)
}

