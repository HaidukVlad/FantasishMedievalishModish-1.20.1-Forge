package com.example.examplemod.worldgen;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Vector;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ORICHALCUM_ORE_PLACED_KEY = registerKey("orichalcum_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ORICHALCUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORICHALICUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(50))));

    }


        private static ResourceKey<PlacedFeature> registerKey(String name) {
            return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ExampleMod.MODID, name));
        }
        private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                     List<PlacementModifier> modifiers) {
            context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
        }
    }



    /*public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registries.PLACED_FEATURE, ExampleMod.MODID);

    public static final RegistryObject<PlacedFeature> ORICHALCUM_ORE_PLACED =
            PLACED_FEATURES.register("orichalcum_ore_placed", () ->
                    new PlacedFeature(
                            ModConfiguredFeatures.ORICHALCUM_ORE.getHolder().get(),
                            List.of(
                                    CountPlacement.of(10),
                                    InSquarePlacement.spread(),
                                    HeightRangePlacement.uniform(
                                            VerticalAnchor.absolute(-64),
                                            VerticalAnchor.absolute(-20)
                                    ),
                                    BiomeFilter.biome()
                            )
                    ));*/
