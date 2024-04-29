package info.partonetrain.rpgattr.mixin;

import info.partonetrain.rpgattr.Rpgattr;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Player.class)
public class PlayerMixin { ;
    @ModifyVariable(method = "attack(Lnet/minecraft/world/entity/Entity;)V", at = @At("STORE"), ordinal = 2) //"bl3"
    public boolean attack(boolean value) {
        if(!((Player)(Object)this).level().isClientSide && !((Player) (Object) this).level().getGameRules().getBoolean(Rpgattr.ALLOW_VANILLA_CRITS)){
            return false;
        }
        return value;
    }
}