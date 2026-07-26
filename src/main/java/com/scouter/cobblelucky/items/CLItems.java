package com.scouter.cobblelucky.items;

import com.scouter.cobblelucky.CobbleLucky;
import com.scouter.cobblelucky.blocks.CLBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class CLItems {

    public static final Item COBBLEMON_LUCKY_BLOCK = registerBlockItem("cobblemon_lucky_block", CLBlocks.COBBLEMON_LUCKY_BLOCK);
    public static final Item COBBLEMON_LUCKY_ITEM_BLOCK = registerBlockItem("cobblemon_lucky_item_block", CLBlocks.COBBLEMON_LUCKY_ITEM_BLOCK);

    public static final CreativeModeTab CREATIVE_TAB = FabricItemGroup.builder()
            .title(Component.translatable("itemGroup.cobblelucky"))
            .icon(() -> new ItemStack(COBBLEMON_LUCKY_BLOCK))
            .displayItems((parameters, output) -> {
                output.accept(COBBLEMON_LUCKY_BLOCK);
                output.accept(COBBLEMON_LUCKY_ITEM_BLOCK);
            })
            .build();

    private static Item registerBlockItem(String name, Block block) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(CobbleLucky.MODID, name);
        Item item = new BlockItem(block, new Item.Properties());
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void init() {
        // static initializer handles registration
    }
}