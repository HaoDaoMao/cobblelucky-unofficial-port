package net.minecraft;

import net.minecraft.world.phys.Vec3;

/**
 * Compatibility bridge class - maps old obfuscated name class_4048 to Vec3
 * Required for Cobblemon 1.7.3 compatibility on Minecraft 1.21.1
 * Note: Vec3 is a record in 1.21.1 and cannot be extended, so this wraps it
 */
public class class_4048 {
    public final Vec3 value;

    public class_4048(double x, double y, double z) {
        this.value = new Vec3(x, y, z);
    }

    public class_4048(Vec3 vec) {
        this.value = vec;
    }
}
