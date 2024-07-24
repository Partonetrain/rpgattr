package info.partonetrain.rpgattr.mixin;

import info.partonetrain.rpgattr.Rpgattr;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import vazkii.botania.api.item.AncientWillContainer;
import vazkii.botania.common.BotaniaDamageTypes;
import vazkii.botania.common.helper.ItemNBTHelper;
import vazkii.botania.common.item.equipment.armor.terrasteel.TerrasteelHelmItem;

import java.util.Locale;

import static vazkii.botania.common.item.equipment.armor.terrasteel.TerrasteelHelmItem.TAG_ANCIENT_WILL;

@Mixin(Player.class)
public abstract class BotaniaPlayerMixin {
    //DOESN'T WORK SEE #2
    @ModifyArg(method = "attack(Lnet/minecraft/world/entity/Entity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    public DamageSource rpgattr_change_damage_source_on_crit(DamageSource source) {
        Player thisPlayer = (Player)(Object)this;
        if(Rpgattr.currentCriticalHitter == thisPlayer && TerrasteelHelmItem.hasTerraArmorSet(thisPlayer)){
            boolean hasVerac = ItemNBTHelper.getBoolean(thisPlayer.getItemBySlot(EquipmentSlot.HEAD), TAG_ANCIENT_WILL + "_" + AncientWillContainer.AncientWillType.VERAC.name().toLowerCase(Locale.ROOT), false);
            if (hasVerac) {
                source = BotaniaDamageTypes.Sources.playerAttackArmorPiercing(thisPlayer.level().registryAccess(), thisPlayer);
            }
        }
        return source;
    }
}
