package info.partonetrain.rpgattr.mixin;

import info.partonetrain.rpgattr.CompatibleAttributeFinder;
import info.partonetrain.rpgattr.Rpgattr;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Attributes.class)
public class AttributesMixin {

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void rpgattr_static_tail(CallbackInfo info) {
        CompatibleAttributeFinder.init();
        Rpgattr.LOGGER.info("RPGAttr found " + Rpgattr.attributesToRegister.size() + "attributes to register:");
        for(Rpgattr.CompatibleAttribute ca : Rpgattr.attributesToRegister){
            Rpgattr.LOGGER.info(String.valueOf(ca.resourceLocation()));
            if (BuiltInRegistries.ATTRIBUTE.containsKey(ca.resourceLocation())) {
                Rpgattr.LOGGER.info("RPGAttr tried to register attribute, but registry already contained " + ca.resourceLocation());
            }else{
                Registry.register(BuiltInRegistries.ATTRIBUTE, ca.resourceLocation(), ca.attribute());
            }
        }
    }
}
