package info.partonetrain.rpgattr.mixin;

import info.partonetrain.rpgattr.Rpgattr;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = DamageSource.class)
public class DamageSourceMixin {
    @Final
    @Shadow
    private Entity causingEntity;

    @Inject(method = "scalesWithDifficulty()Z", at=@At("HEAD"), cancellable = true)
    private void rpgattr_disable_scaling_gamerule(CallbackInfoReturnable<Boolean> cir){
        if(causingEntity != null && !causingEntity.level().isClientSide && !causingEntity.level().getGameRules().getBoolean(Rpgattr.DIFFICULTY_DAMAGE_SCALING)){
            cir.setReturnValue(false);
            cir.cancel();
        }
    }
}
