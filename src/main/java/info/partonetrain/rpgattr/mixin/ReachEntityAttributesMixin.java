package info.partonetrain.rpgattr.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ReachEntityAttributes.class, remap = false)
public class ReachEntityAttributesMixin {

    @Inject(method = "onInitialize", at = @At(value = "HEAD"), cancellable = true)
    private void rpgattr_cancel_rea_reg(CallbackInfo ci){
        ci.cancel();
    }
}
