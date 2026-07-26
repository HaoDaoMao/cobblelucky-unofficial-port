package net.minecraft;

import net.minecraft.resources.ResourceLocation;

/**
 * Compatibility bridge class - maps old obfuscated name class_2960 to ResourceLocation
 * Required for Cobblemon 1.7.3 compatibility on Minecraft 1.21.1
 */
public class class_2960 extends ResourceLocation {
    public class_2960(String namespace, String path) {
        super(namespace, path);
    }

    public class_2960(ResourceLocation source) {
        super(source.getNamespace(), source.getPath());
    }
}
