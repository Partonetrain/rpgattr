package info.partonetrain.rpgattr;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dev.shadowsoffire.attributeslib.api.ALObjects;
import net.minecraft.resources.ResourceLocation;

public class CompatibleAttributeFinder {


    public static void init(){

        /*
        if (Rpgattr.AEA_INSTALLED) {
            //done in AdditionalEntityAttributesMixin because the attribute constant
            //is set and registered by the same method
        }
         */

        if (Rpgattr.REA_INSTALLED) {
            Rpgattr.addAttributeToCompat(new ResourceLocation("reach-entity-attributes", "reach"), ReachEntityAttributes.REACH);
            Rpgattr.addAttributeToCompat(new ResourceLocation("reach-entity-attributes", "attack_range"), ReachEntityAttributes.ATTACK_RANGE);
        }

        /*
        if (Rpgattr.STEP_HEIGHT_INSTALLED) {
            Step Height already mixes into Attributes.class to register its attribute, so it should work out-of-the-box
        }
         */

        if (!Rpgattr.ZEPHYR_INSTALLED && Rpgattr.ZENITHATTR_INSTALLED) {
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "armor_pierce"), ALObjects.Attributes.ARMOR_PIERCE);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "armor_shred"), ALObjects.Attributes.ARMOR_SHRED);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "arrow_velocity"), ALObjects.Attributes.ARROW_VELOCITY);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "cold_damage"), ALObjects.Attributes.COLD_DAMAGE);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "creative_flight"), ALObjects.Attributes.CREATIVE_FLIGHT);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "crit_chance"), ALObjects.Attributes.CRIT_CHANCE);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "current_hp_damage"), ALObjects.Attributes.CURRENT_HP_DAMAGE);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "dodge_chance"), ALObjects.Attributes.DODGE_CHANCE);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "draw_speed"), ALObjects.Attributes.DRAW_SPEED); //you should use ranged_weapon:haste instead, if available
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "elytra_flight"), ALObjects.Attributes.ELYTRA_FLIGHT);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "fire_damage"), ALObjects.Attributes.FIRE_DAMAGE);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "ghost_health"), ALObjects.Attributes.GHOST_HEALTH);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "healing_received"), ALObjects.Attributes.HEALING_RECEIVED);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "life_steal"), ALObjects.Attributes.LIFE_STEAL);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "prot_pierce"), ALObjects.Attributes.PROT_PIERCE);
            Rpgattr.addAttributeToCompat(new ResourceLocation("zenith_attributes", "prot_shred"), ALObjects.Attributes.PROT_SHRED);
        }
    }
}
