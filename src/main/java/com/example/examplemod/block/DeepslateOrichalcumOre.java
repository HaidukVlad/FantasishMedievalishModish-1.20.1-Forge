package com.example.examplemod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DeepslateOrichalcumOre extends DropExperienceBlock {
    public DeepslateOrichalcumOre() {
        super(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)
                .strength(50.0F, 1200.0F)
                .requiresCorrectToolForDrops());
    }
}
