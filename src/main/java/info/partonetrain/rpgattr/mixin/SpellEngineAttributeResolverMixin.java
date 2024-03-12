package info.partonetrain.rpgattr.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import de.dafuqs.additionalentityattributes.AdditionalEntityAttributes;
import dev.emi.stepheightentityattribute.StepHeightEntityAttributeMain;
import dev.shadowsoffire.attributeslib.api.ALObjects;
import info.partonetrain.rpgattr.Rpgattr;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.spell_engine.api.item.AttributeResolver;

import static net.jewelry.api.AttributeResolver.register;


@Mixin(AttributeResolver.class)
public abstract class SpellEngineAttributeResolverMixin {

	@Inject(method = "setup", at = @At("TAIL"), remap = false)
	private static void init(CallbackInfo info) {
		if(Rpgattr.AEA_INSTALLED){
			register(new Identifier("additionalentityattributes","generic.jump_height"), AdditionalEntityAttributes.JUMP_HEIGHT);
			register(new Identifier("additionalentityattributes","generic.lava_speed"), AdditionalEntityAttributes.LAVA_SPEED);
			register(new Identifier("additionalentityattributes","generic.lung_capacity"), AdditionalEntityAttributes.LUNG_CAPACITY);
			register(new Identifier("additionalentityattributes","generic.magic_protection"), AdditionalEntityAttributes.MAGIC_PROTECTION);
			register(new Identifier("additionalentityattributes","player.bonus_loot_count_rolls"), AdditionalEntityAttributes.BONUS_LOOT_COUNT_ROLLS);
			register(new Identifier("additionalentityattributes","player.bonus_rare_loot_rolls"), AdditionalEntityAttributes.BONUS_RARE_LOOT_ROLLS);
			register(new Identifier("additionalentityattributes","player.collection_range"), AdditionalEntityAttributes.COLLECTION_RANGE);
			register(new Identifier("additionalentityattributes","player.dig_speed"), AdditionalEntityAttributes.DIG_SPEED);
			register(new Identifier("additionalentityattributes","player.dropped_experience"), AdditionalEntityAttributes.DROPPED_EXPERIENCE);
			register(new Identifier("additionalentityattributes","player.lava_visibility"), AdditionalEntityAttributes.LAVA_VISIBILITY);
			register(new Identifier("additionalentityattributes","water_speed"), AdditionalEntityAttributes.WATER_SPEED);
			register(new Identifier("additionalentityattributes","water_visibility"), AdditionalEntityAttributes.WATER_VISIBILITY);
			register(new Identifier("additionalentityattributes","player.critical_bonus_damage"), AdditionalEntityAttributes.CRITICAL_BONUS_DAMAGE);
		}

		if(Rpgattr.REA_INSTALLED){
			register(new Identifier("reach-entity-attributes", "attack_range"), ReachEntityAttributes.ATTACK_RANGE);
			register(new Identifier("reach-entity-attributes", "reach"), ReachEntityAttributes.REACH);
		}

		if(Rpgattr.STEP_HEIGHT_INSTALLED){
			register(new Identifier("step-height-entity-attribute", "step_height"), StepHeightEntityAttributeMain.STEP_HEIGHT);
		}

		if(Rpgattr.ZENITHATTR_INSTALLED){
			register(new Identifier("zenith_attributes", "armor_pierce"), ALObjects.Attributes.ARMOR_PIERCE);
			register(new Identifier("zenith_attributes", "armor_shred"), ALObjects.Attributes.ARMOR_SHRED);
			register(new Identifier("zenith_attributes", "arrow_velocity"), ALObjects.Attributes.ARROW_VELOCITY);
			register(new Identifier("zenith_attributes", "cold_damage"), ALObjects.Attributes.COLD_DAMAGE);
			register(new Identifier("zenith_attributes", "creative_flight"), ALObjects.Attributes.CREATIVE_FLIGHT);
			register(new Identifier("zenith_attributes", "crit_chance"), ALObjects.Attributes.CRIT_CHANCE);
			register(new Identifier("zenith_attributes", "current_hp_damage"), ALObjects.Attributes.CURRENT_HP_DAMAGE);
			register(new Identifier("zenith_attributes", "dodge_chance"), ALObjects.Attributes.DODGE_CHANCE);
			register(new Identifier("zenith_attributes", "draw_speed"), ALObjects.Attributes.DRAW_SPEED);
			register(new Identifier("zenith_attributes", "elytra_flight"), ALObjects.Attributes.ELYTRA_FLIGHT);
			register(new Identifier("zenith_attributes", "fire_damage"), ALObjects.Attributes.FIRE_DAMAGE);
			register(new Identifier("zenith_attributes", "healing_received"), ALObjects.Attributes.HEALING_RECEIVED);
			register(new Identifier("zenith_attributes", "life_steal"), ALObjects.Attributes.LIFE_STEAL);
		}

	}
}