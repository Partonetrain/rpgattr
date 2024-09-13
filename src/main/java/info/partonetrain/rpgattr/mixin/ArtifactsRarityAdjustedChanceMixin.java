package info.partonetrain.rpgattr.mixin;

import artifacts.loot.ArtifactRarityAdjustedChance;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.level.storage.loot.LootContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ArtifactRarityAdjustedChance.class)
public class ArtifactsRarityAdjustedChanceMixin {
    @ModifyVariable(method = "test(Lnet/minecraft/world/level/storage/loot/LootContext;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/loot/LootContext;getRandom()Lnet/minecraft/util/RandomSource;"), index = 4)
    private float rpgattr_addLuckToArtifactChance(float value, @Local(argsOnly = true) LootContext context){
        float boost = context.getLuck() / 20; //5% per level of luck
        return value + boost;
    }
}
