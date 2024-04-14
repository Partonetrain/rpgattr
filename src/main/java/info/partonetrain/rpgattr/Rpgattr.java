package info.partonetrain.rpgattr;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Rpgattr implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("rpgattr");

	public record CompatibleAttribute(Attribute attribute, ResourceLocation resourceLocation){ };
	public static final List<CompatibleAttribute> attributesToRegister = new ArrayList<>();

	public static final boolean AEA_INSTALLED = FabricLoader.getInstance().isModLoaded("additionalentityattributes");
	public static final boolean REA_INSTALLED = FabricLoader.getInstance().isModLoaded("reach-entity-attributes");
	public static final boolean STEP_HEIGHT_INSTALLED = FabricLoader.getInstance().isModLoaded("step-height-entity-attribute");
	public static final boolean ZEPHYR_INSTALLED = FabricLoader.getInstance().isModLoaded("zephyr");
	public static final boolean ZENITHATTR_INSTALLED = FabricLoader.getInstance().isModLoaded("zenith_attributes");

	@Override
	public void onInitialize() {
		LOGGER.info("[RPGAttr] AEA Installed: " + AEA_INSTALLED
				+ " REA Installed: " + REA_INSTALLED
				+ " StepHeight Installed: " + STEP_HEIGHT_INSTALLED
				+ " Zephyr Installed: " + ZEPHYR_INSTALLED
				+ " ZenithAttr Installed: " + ZENITHATTR_INSTALLED
		);

		CompatibleAttributeFinder.init();
	}

	public static void addAttributeToCompat(Attribute attribute, ResourceLocation resourceLocation) {
		CompatibleAttribute compatibleAttribute = new CompatibleAttribute(attribute, resourceLocation);
		attributesToRegister.add(compatibleAttribute);
	}
}