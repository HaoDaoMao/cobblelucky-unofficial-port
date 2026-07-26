package com.scouter.cobblelucky.blocks;

import com.scouter.cobblelucky.CobbleLucky;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class CLBlocks {

    public static final Block COBBLEMON_LUCKY_BLOCK = register(
            "cobblemon_lucky_block",
            CobblemonLuckyBlock::new,
            BlockBehaviour.Properties.of()
                    .strength(0.4F)
                    .sound(SoundType.STONE)
                    .randomTicks()
    );

    public static final Block COBBLEMON_LUCKY_ITEM_BLOCK = register(
            "cobblemon_lucky_item_block",
            CobblemonLuckyItemBlock::new,
            BlockBehaviour.Properties.of()
                    .strength(0.4F)
                    .sound(SoundType.STONE)
                    .randomTicks()
    );

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(CobbleLucky.MODID, name);
        Block block = factory.apply(properties);
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void init() {
        // static initializer handles registration
    }
}