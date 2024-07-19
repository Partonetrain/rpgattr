package info.partonetrain.rpgattr.mixin;

import info.partonetrain.rpgattr.Rpgattr;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.common.entity.PixieEntity;
import vazkii.botania.common.handler.PixieHandler;
import vazkii.botania.common.helper.PlayerHelper;
import vazkii.botania.common.item.BotaniaItems;
import vazkii.botania.common.item.equipment.armor.elementium.ElementiumHelmItem;

@Mixin(value = PixieHandler.class, remap = false)
public class BotaniaPixieHandlerMixin {

    @Inject(method = "registerAttribute", at = @At(value = "HEAD"), cancellable = true)
    private static void rpgattr_cancel_botania_reg(CallbackInfo ci) {
        ci.cancel();
    }


    /**
     * @author Partonetrain
     * @reason To fix #3 while avoid classloading nonsense. I am open to better solutions than an overwrite
     * (especially since BotaniaCombat mixins here) but want to get a fix out since it's a crash bug.
     * thewormbo: "Your AttributesMixin adds code at the end of the class initializer of the Attributes class.
     * That code calls CompatibleAttributeFinder.init(), which in turn references the PixieHandler class, causing it to
     * be loaded and initialized. However, the Attributes class might be initially loaded by the class initializer of
     * MobEffects." Basically, PixieHandler gets loaded with variables that are null.
     * Initially I wanted this to be an INVOKE mixin on setApplyPotionEffect but the MobEffectInstance constructor always happens first, and I would rather not mixin to said constructor
     * This method mirrors the original almost entirely, the only differences being selection of potion effects from not-classinit and an extra second on the effect to fix Botania#4247
     */
     @Overwrite
     public static void onDamageTaken(Player player, DamageSource source){
         if (!player.level().isClientSide && source.getEntity() instanceof LivingEntity livingSource) {
             double chance = player.getAttributes().hasAttribute(PixieHandler.PIXIE_SPAWN_CHANCE)
                     ? player.getAttributeValue(PixieHandler.PIXIE_SPAWN_CHANCE) : 0;
             ItemStack sword = PlayerHelper.getFirstHeldItem(player, s -> s.is(BotaniaItems.elementiumSword));

             if (Math.random() < chance) {
                 PixieEntity pixie = new PixieEntity(player.level());
                 pixie.setPos(player.getX(), player.getY() + 2, player.getZ());

                 if (((ElementiumHelmItem) BotaniaItems.elementiumHelm).hasArmorSet(player)) {
                     int rand = player.level().random.nextInt(4);
                     Rpgattr.LOGGER.info(String.valueOf(rand));
                     MobEffect mobEffect = switch (rand) {
                         case 1 -> MobEffects.WITHER;
                         case 2 -> MobEffects.MOVEMENT_SLOWDOWN;
                         case 3 -> MobEffects.WEAKNESS;
                         default -> MobEffects.BLINDNESS;
                     };

                     pixie.setApplyPotionEffect(new MobEffectInstance(mobEffect, 60, 0));
                 }

                 float dmg = 4;
                 if (!sword.isEmpty()) {
                     dmg += 2;
                 }

                 pixie.setProps(livingSource, player, 0, dmg);
                 pixie.finalizeSpawn((ServerLevelAccessor) player.level(), player.level().getCurrentDifficultyAt(pixie.blockPosition()),
                         MobSpawnType.EVENT, null, null);
                 player.level().addFreshEntity(pixie);
             }
         }
     }

}