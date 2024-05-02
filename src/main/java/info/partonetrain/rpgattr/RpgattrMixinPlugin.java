package info.partonetrain.rpgattr;

import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class RpgattrMixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.contains("AdditionalEntityAttributes")) {
            return Rpgattr.AEA_INSTALLED;
        }

        if (mixinClassName.contains("Botania")) {
            if(mixinClassName.contains("Zenith")) { //for ZenithAttributesBotaniaCritMixin
                return Rpgattr.ZENITHATTR_INSTALLED;
            }
            return Rpgattr.BOTANIA_INSTALLED;
        }

        if (mixinClassName.contains("ReachEntityAttributes")) {
            return Rpgattr.REA_INSTALLED;
        }

        if (mixinClassName.contains("Zenith")) {
            return Rpgattr.ZENITHATTR_INSTALLED;
        }

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
