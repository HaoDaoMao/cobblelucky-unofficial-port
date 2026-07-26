package com.scouter.cobblelucky.setup;

import com.scouter.cobblelucky.blocks.CLBlocks;
import com.scouter.cobblelucky.items.CLItems;
import com.scouter.cobblelucky.CobbleLucky;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class Registration {

    public static void init() {
        CLBlocks.init();
        CLItems.init();

        // Register creative tab
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                ResourceLocation.fromNamespaceAndPath(CobbleLucky.MODID, "tab"),
                CLItems.CREATIVE_TAB
        );
    }
}