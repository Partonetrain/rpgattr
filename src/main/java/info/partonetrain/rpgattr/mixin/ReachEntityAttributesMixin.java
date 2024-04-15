package info.partonetrain.rpgattr.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ReachEntityAttributes.class)
public class ReachEntityAttributesMixin {

    @Inject(method = "onInitialize", at = @At("HEAD"), cancellable = true)
    private void rpgattr_cancel_rea_reg(CallbackInfo ci){
        ci.cancel();
    }
}
