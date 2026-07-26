package com.scouter.cobblelucky.setup;

import com.scouter.cobblelucky.CobbleLucky;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class ClientSetup implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Register render layers for blocks
        BlockRenderLayerMap.INSTANCE.putBlock(
                com.scouter.cobblelucky.blocks.CLBlocks.COBBLEMON_LUCKY_BLOCK,
                RenderType.solid()
        );
        BlockRenderLayerMap.INSTANCE.putBlock(
                com.scouter.cobblelucky.blocks.CLBlocks.COBBLEMON_LUCKY_ITEM_BLOCK,
                RenderType.solid()
        );
    }
}