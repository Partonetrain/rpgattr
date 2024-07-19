package info.partonetrain.rpgattr.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.shadowsoffire.attributeslib.impl.AttributeEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.botania.common.PlayerAccess;

@Mixin(AttributeEvents.class)
public class ZenithAttributesBotaniaCritMixin { //Causes Botania Will crit effects to activate on Zenith crits (I hope)
    //botania playermixin happens before this
    @Inject(method = "lambda$apothCriticalStrike$3(Lnet/minecraft/world/damagesource/DamageSource;Lnet/minecraft/world/entity/LivingEntity;F)F", at = @At(value= "TAIL"))
    private static void rpgattr_add_botania_crit_to_zenith_crit(DamageSource source, LivingEntity damaged, float amount, CallbackInfoReturnable<Float> cir, @Local(ordinal = 1) float critMult) {
        if(critMult > 1.0F && source.getEntity() instanceof Player player && ! player.level().isClientSide()){
            ((PlayerAccess)player).botania$setCritTarget(damaged);
            System.out.println(damaged.getDisplayName());
        }
        
    }
}
