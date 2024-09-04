package info.partonetrain.rpgattr.mixin;

import com.google.common.collect.Multimap;
import elocindev.customitemattributes.api.GenericAttribute;
import elocindev.customitemattributes.api.ItemProperty;
import elocindev.customitemattributes.builder.AttributeBuilderCallback;
import info.partonetrain.rpgattr.CustomItemAttributesUtil;
import info.partonetrain.rpgattr.Rpgattr;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.item.v1.ModifyItemAttributeModifiersCallback;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(AttributeBuilderCallback.class)
public class CIAAttributeBuilderCallbackMixin {

    @Inject(method = "register", at = @At("HEAD"), cancellable = true, remap = false)
    private static void register(CallbackInfo ci) {
        if(Rpgattr.ciaVersion != null && Rpgattr.ciaVersion.getFriendlyString().equals("2.0.0")){
            ServerLifecycleEvents.SERVER_STARTED.register((server) -> {
                CustomItemAttributesUtil.onDatapackReloadStart();
            });
            ServerLifecycleEvents.START_DATA_PACK_RELOAD.register((server, serverResourceManager) -> {
                CustomItemAttributesUtil.onDatapackReloadStart();
            });
            ModifyItemAttributeModifiersCallback.EVENT.register((stack, slot, builder) -> {
                var key = stack.getItem().builtInRegistryHolder().unwrapKey().get().registry().toString();
                var configItem = CustomItemAttributesUtil.itemProperties.get(key);
                if (configItem == null) {
                    return;
                }
                CustomItemAttributesUtil.register(stack, slot, builder, configItem);
            });
            ci.cancel();
        }
    }

    @Inject(method = "applyModifiers", at = @At("HEAD"), cancellable = true, remap = false)
    private static void applyModifiers(ItemStack stack, ItemProperty property, List<GenericAttribute<String, ?>> attributes, Multimap<Attribute, AttributeModifier> builder, CallbackInfo ci) {
        if(Rpgattr.ciaVersion != null && Rpgattr.ciaVersion.getFriendlyString().equals("2.0.0")) {
            CustomItemAttributesUtil.applyModifiers(stack, property, attributes, builder);
            ci.cancel();
        }
    }
}