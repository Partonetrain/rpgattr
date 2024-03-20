package info.partonetrain.rpgattr.mixin;

import dev.shadowsoffire.attributeslib.client.AttributesLibClient;
import info.partonetrain.rpgattr.Rpgattr;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;



@Mixin(AttributesLibClient.class)
public abstract class ZenithAttributesPotionTooltipMixin {

	/**
	 * @author Partonetrain
	 * @reason prevent feature overlap with ZenithAttributes
	 */
	@Redirect(method = "onInitializeClient", at = @At(value = "INVOKE", target = "Ldev/shadowsoffire/attributeslib/client/AttributesLibClient;potionTooltips()V"), remap = false)
	public void RPGAttr$disablePotionTooltip(AttributesLibClient instance) {
		Rpgattr.LOGGER.info("Zenith Attributes potion tooltips disabled by RPGAttr");
	}
}