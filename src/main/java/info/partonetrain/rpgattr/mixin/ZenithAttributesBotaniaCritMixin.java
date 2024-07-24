package info.partonetrain.rpgattr.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.shadowsoffire.attributeslib.impl.AttributeEvents;
import info.partonetrain.rpgattr.Rpgattr;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.botania.common.PlayerAccess;
import vazkii.botania.common.item.equipment.armor.terrasteel.TerrasteelHelmItem;

@Mixin(AttributeEvents.class)
public class ZenithAttributesBotaniaCritMixin { //Causes Botania Will crit effects to activate on Zenith crits (I hope)
    //botania's playermixin (not rpgattr BotaniaPlayerMixin) happens before this mixin does
    @Unique private static float dharokDamageMult = 1.0F; //dharok is factored in after crits!

    @Inject(method = "lambda$apothCriticalStrike$3(Lnet/minecraft/world/damagesource/DamageSource;Lnet/minecraft/world/entity/LivingEntity;F)F", at = @At(value= "TAIL"))
    private static void rpgattr_add_botania_crit_to_zenith_crit(DamageSource source, LivingEntity damaged, float amount, CallbackInfoReturnable<Float> cir, @Local(ordinal = 2) float critMult, @Local(ordinal = 1) LivingEntity attacker) {
        if(!attacker.level().isClientSide && attacker instanceof Player player && critMult > 1.0F){
            //((PlayerAccess)player).botania$setCritTarget(damaged); this doesn't work, we have to reimpl all of it
            dharokDamageMult = TerrasteelHelmItem.getCritDamageMult(player); // will return 1.0 if no dharok
            DamageSource src2 = TerrasteelHelmItem.onEntityAttacked(source, amount, player, damaged); //src2 is unused
            //onEntityAttacked applies the effects of AHRIM, GUTHAN, TORAG, KARIL
            Rpgattr.currentCriticalHitter = player; //ineffective at getting VERAC to work see #2
        }
    }

    @ModifyReturnValue(method = "lambda$apothCriticalStrike$3(Lnet/minecraft/world/damagesource/DamageSource;Lnet/minecraft/world/entity/LivingEntity;F)F", at = @At("TAIL"))
    private static float rpgattr_add_botania_damage_to_zenith_crit(float amount){
        Rpgattr.currentCriticalHitter = null;
        return amount * dharokDamageMult;
    }

}
