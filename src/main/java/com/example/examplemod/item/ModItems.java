package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> PALACHE = ITEMS.register("palache",
            PalacheItem::new);

    public static final RegistryObject<Item> ORICHALCUM_INGOT = ITEMS.register("orichalcum_ingot",
            OrichalcumIngot::new);

    // Добавляем BlockItem для блоков
    public static final RegistryObject<Item> ORICHALCUM_BLOCK = ITEMS.register("orichalcum_block",
            () -> new BlockItem(ModBlocks.ORICHALCUM_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> ORICHALCUM_ORE = ITEMS.register("orichalcum_ore",
            () -> new BlockItem(ModBlocks.ORICHALCUM_ORE.get(), new Item.Properties()));
}