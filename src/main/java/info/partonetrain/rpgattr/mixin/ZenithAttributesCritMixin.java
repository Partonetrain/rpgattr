package info.partonetrain.rpgattr.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.shadowsoffire.attributeslib.impl.AttributeEvents;
import info.partonetrain.rpgattr.Rpgattr;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AttributeEvents.class)
public class ZenithAttributesCritMixin {

    @Inject(method = "lambda$apothCriticalStrike$3(Lnet/minecraft/world/damagesource/DamageSource;Lnet/minecraft/world/entity/LivingEntity;F)F", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getAttributeValue(Lnet/minecraft/world/entity/ai/attributes/Attribute;)D", ordinal = 0), cancellable = true)
    private static void rpgattr_check_melee_crit_gamerule(DamageSource source, LivingEntity damaged, float amount, CallbackInfoReturnable<Float> cir, @Local(ordinal = 1) LivingEntity attacker) {
        if(!attacker.level().isClientSide() && attacker.level().getGameRules().getBoolean(Rpgattr.ZENITH_CRITS_MELEE_ONLY)){
            if(!source.is(DamageTypes.PLAYER_ATTACK)){
                cir.setReturnValue(amount);
                cir.cancel();
            }
        }
    }
}
