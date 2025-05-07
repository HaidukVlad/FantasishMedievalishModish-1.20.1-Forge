package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> PALACHE = ITEMS.register("palache",
            PalacheItem::new);

    public static final RegistryObject<Item> ORICHALCUM_INGOT = ITEMS.register("orichalcum_ingot",
            OrichalcumIngot::new);

    public static final RegistryObject<Item> RAW_ORICHALCUM = ITEMS.register("raw_orichalcum",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ORICHALCUM_BLOCK = ITEMS.register("orichalcum_block",
            () -> new BlockItem(ModBlocks.ORICHALCUM_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> ORICHALCUM_ORE = ITEMS.register("orichalcum_ore",
            () -> new BlockItem(ModBlocks.ORICHALCUM_ORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> DEEPSLATE_ORICHALCUM_ORE = ITEMS.register("deepslate_orichalcum_ore",
            () -> new BlockItem(ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(), new Item.Properties()));
}