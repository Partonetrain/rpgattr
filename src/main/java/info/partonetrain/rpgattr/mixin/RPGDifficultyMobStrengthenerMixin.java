package info.partonetrain.rpgattr.mixin;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Mob;
import net.rpgdifficulty.RpgDifficultyMain;
import net.rpgdifficulty.api.MobStrengthener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobStrengthener.class)
public class RPGDifficultyMobStrengthenerMixin {
    @Inject(method = "changeBossAttributes", at=@At("HEAD"), cancellable = true)
    private static void rpgattr_additionalCheckOnDifficultyConfig(Mob mobEntity, ServerLevel world, CallbackInfo ci){
        String entityId = BuiltInRegistries.ENTITY_TYPE.getKey(mobEntity.getType()).toString();
        if(RpgDifficultyMain.CONFIG.excludedEntity.contains(entityId)){
            ci.cancel();
        }
    }
}
