package com.example.examplemod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class OrichalcumBlock extends Block {
    public OrichalcumBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK));
    }
}
