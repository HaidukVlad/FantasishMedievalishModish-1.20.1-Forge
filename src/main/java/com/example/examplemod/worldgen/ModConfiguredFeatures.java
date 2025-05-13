package com.example.examplemod.worldgen;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORICHALICUM_ORE_KEY = registerKey("orichalcum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_ORICHALICUM_ORE_KEY = registerKey("deepslate_orichalcum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOLAR_CRYSTAL_ORE_KEY = registerKey("solar_crystal_ore");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // Конфигурация для обычной орихалковой руды (заменяет только камень)
        List<OreConfiguration.TargetBlockState> orichalcumOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.ORICHALCUM_ORE.get().defaultBlockState())
        );
        register(context, ORICHALICUM_ORE_KEY, Feature.ORE, new OreConfiguration(orichalcumOres, 9));

        // Конфигурация для глубинной орихалковой руды (заменяет только глубокий сланец)
        List<OreConfiguration.TargetBlockState> deepslateOrichalcumOres = List.of(
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get().defaultBlockState())
        );
        register(context, DEEPSLATE_ORICHALICUM_ORE_KEY, Feature.ORE, new OreConfiguration(deepslateOrichalcumOres, 9));

        // Конфигурация для руды солнечного кристалла
        List<OreConfiguration.TargetBlockState> solarCrystalOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.SOLAR_CRYSTAL_ORE.get().defaultBlockState())
        );
        register(context, SOLAR_CRYSTAL_ORE_KEY, Feature.ORE, new OreConfiguration(solarCrystalOres, 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ExampleMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}