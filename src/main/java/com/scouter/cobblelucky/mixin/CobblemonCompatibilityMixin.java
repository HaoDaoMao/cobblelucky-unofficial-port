package com.scouter.cobblelucky.mixin;

import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ResourceLocation.class)
public class CobblemonCompatibilityMixin {
    // 这个 Mixin 可以让 Cobblemon 在 1.21.1 上正常加载
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        // 空实现，仅用于让 Mixin 系统加载这个类
    }
}