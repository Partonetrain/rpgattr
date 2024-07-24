package info.partonetrain.rpgattr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.common.handler.PixieHandler;

@Mixin(value = PixieHandler.class, remap = false)
public class BotaniaPixieHandlerMixin {

    @Inject(method = "registerAttribute", at = @At(value = "HEAD"), cancellable = true)
    private static void rpgattr_cancel_botania_reg(CallbackInfo ci) {
        ci.cancel();
    }

}