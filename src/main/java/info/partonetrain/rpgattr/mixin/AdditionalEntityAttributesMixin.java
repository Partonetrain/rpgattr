package info.partonetrain.rpgattr.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import de.dafuqs.additionalentityattributes.AdditionalEntityAttributes;
import info.partonetrain.rpgattr.Rpgattr;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AdditionalEntityAttributes.class)
public class AdditionalEntityAttributesMixin {

    @Inject(method = "register", at = @At(value = "RETURN"), cancellable = true)
    private static void rpgattr_cancel_aea_reg(String name, double base, double min, double max, CallbackInfoReturnable<Attribute> cir, @Local Attribute attribute) {
        Rpgattr.addAttributeToCompat(attribute, new ResourceLocation("additionalentityattributes", name));
        cir.setReturnValue(attribute);
    }
}
