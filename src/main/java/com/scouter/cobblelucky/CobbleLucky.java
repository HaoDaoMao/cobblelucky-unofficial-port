package com.scouter.cobblelucky;

import com.mojang.logging.LogUtils;
import com.scouter.cobblelucky.setup.ClientSetup;
import com.scouter.cobblelucky.setup.ModSetup;
import com.scouter.cobblelucky.setup.Registration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import java.util.Locale;

public class CobbleLucky implements ModInitializer {
    public static final String MODID = "cobblelucky";
    private static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        Registration.init();
        ModSetup.setup();

        if (FabricLoader.getInstance().isModLoaded("fabric")) {
            LOGGER.info("Cobblemon Lucky Blocks loaded on Fabric");
        }
    }

    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name.toLowerCase(Locale.ROOT));
    }
}