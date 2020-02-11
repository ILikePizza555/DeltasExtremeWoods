package com.izzylan.extremeforest

import net.minecraft.entity.EntityCategory
import net.minecraft.entity.EntityType
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

@Suppress("unused")
fun init() {
    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.

    println("Hello Fabric world!")
}

