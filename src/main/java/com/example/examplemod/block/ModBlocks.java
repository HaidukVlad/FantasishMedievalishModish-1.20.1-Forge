package com.example.examplemod.block;

import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.example.examplemod.ExampleMod;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);

    public static final RegistryObject<Block> ORICHALCUM_ORE = BLOCKS.register("orichalcum_ore",
           () -> new OrichalcumOre());

    public static final RegistryObject<Block> DEEPSLATE_ORICHALCUM_ORE = BLOCKS.register("deepslate_orichalcum_ore",
            () -> new DeepslateOrichalcumOre());


    public static final RegistryObject<Block> ORICHALCUM_BLOCK = BLOCKS.register("orichalcum_block",
            () -> new OrichalcumBlock());

    public static final RegistryObject<Block> SOLAR_CRYSTAL_ORE = BLOCKS.register("solar_crystal_ore",
            () -> new SolarCrystalOre());
}
