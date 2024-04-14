package info.partonetrain.rpgattr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = dev.shadowsoffire.attributeslib.api.ALObjects.Attributes.class, remap = false)
public class ZenithAttributesMixin {

    @Inject(method = "register", at = @At(value = "HEAD", remap = true), cancellable = true)
    private static void rpgattr_cancel_zenithattr_reg(CallbackInfo ci) {
        ci.cancel();
    }
}
