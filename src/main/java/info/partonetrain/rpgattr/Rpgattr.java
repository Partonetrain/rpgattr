package info.partonetrain.rpgattr;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Rpgattr implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("rpgattr");

	public record CompatibleAttribute(ResourceLocation resourceLocation, Attribute attribute){ }
	public static List<CompatibleAttribute> attributesToRegister = new ArrayList<>();

	public static final boolean AEA_INSTALLED = FabricLoader.getInstance().isModLoaded("additionalentityattributes");
	public static final boolean BOTANIA_INSTALLED = FabricLoader.getInstance().isModLoaded("botania");
	public static final boolean REA_INSTALLED = FabricLoader.getInstance().isModLoaded("reach-entity-attributes");
	public static final boolean ZEPHYR_INSTALLED = FabricLoader.getInstance().isModLoaded("zephyr");
	public static final boolean ZENITHATTR_INSTALLED = FabricLoader.getInstance().isModLoaded("zenith_attributes");
	public static GameRules.Key<GameRules.BooleanValue> ALLOW_VANILLA_CRITS; //this would be set here, but for some reason that causes issues
	public static GameRules.Key<GameRules.BooleanValue> DISABLE_DIFFICULTY_DAMAGE_SCALING;
	public static Player currentCriticalHitter; //only used when Zenith Attributes and Botania is installed -- DOESN'T WORK SEE #2

	@Override
	public void onInitialize() {
		LOGGER.info("[RPGAttr] AEA Installed: " + AEA_INSTALLED
				+ " Botania Installed: " + BOTANIA_INSTALLED
				+ " REA Installed: " + REA_INSTALLED
				+ " Zephyr Installed: " + ZEPHYR_INSTALLED
				+ " ZenithAttr Installed: " + ZENITHATTR_INSTALLED
		);

		ALLOW_VANILLA_CRITS = GameRuleRegistry.register("vanillaCrits", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
		DISABLE_DIFFICULTY_DAMAGE_SCALING = GameRuleRegistry.register("difficultyDamageScaling", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
	}

	public static void addAttributeToCompat(ResourceLocation resourceLocation, Attribute attribute) {
		CompatibleAttribute compatibleAttribute = new CompatibleAttribute(resourceLocation, attribute);
		attributesToRegister.add(compatibleAttribute);
	}
}