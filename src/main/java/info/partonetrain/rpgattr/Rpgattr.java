package info.partonetrain.rpgattr;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rpgattr implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("rpgattr");

	public static final boolean AEA_INSTALLED = FabricLoader.getInstance().isModLoaded("additionalentityattributes");
	public static final boolean REA_INSTALLED = FabricLoader.getInstance().isModLoaded("reach-entity-attributes");
	public static final boolean STEP_HEIGHT_INSTALLED = FabricLoader.getInstance().isModLoaded("step-height-entity-attribute");

	public static final boolean ZEPHYR_INSTALLED = FabricLoader.getInstance().isModLoaded("zephyr");
	public static final boolean ZENITHATTR_INSTALLED = FabricLoader.getInstance().isModLoaded("zenith_attributes");

	public static final boolean JEWELRY_INSTALLED = FabricLoader.getInstance().isModLoaded("jewelry");


	@Override
	public void onInitialize() {
		LOGGER.info("[RPGAttr] AEA Installed: " + AEA_INSTALLED
				+ " REA Installed: " + REA_INSTALLED
				+ " StepHeight Installed: " + STEP_HEIGHT_INSTALLED
				+ " Zephyr Installed: " + ZEPHYR_INSTALLED
				+ " ZenithAttr Installed: " + ZENITHATTR_INSTALLED
				+ " Jewelry Installed: " + JEWELRY_INSTALLED
		);
	}
}