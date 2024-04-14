package info.partonetrain.rpgattr;

import dev.shadowsoffire.attributeslib.api.ALObjects;
import net.minecraft.resources.ResourceLocation;

public class CompatibleAttributeFinder {
    
    public static void init(){
        if (Rpgattr.AEA_INSTALLED) {
            return ;
        }

        if (Rpgattr.REA_INSTALLED) {
            return ;
        }

        if (Rpgattr.STEP_HEIGHT_INSTALLED) {
            return ;
        }

        if (!Rpgattr.ZEPHYR_INSTALLED && Rpgattr.ZENITHATTR_INSTALLED) {
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.ARMOR_PIERCE, new ResourceLocation("zenith_attributes", "armor_pierce"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.ARMOR_SHRED, new ResourceLocation("zenith_attributes", "armor_shred"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.ARROW_VELOCITY, new ResourceLocation("zenith_attributes", "arrow_velocity"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.COLD_DAMAGE, new ResourceLocation("zenith_attributes", "cold_damage"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.CREATIVE_FLIGHT, new ResourceLocation("zenith_attributes", "creative_flight"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.CRIT_CHANCE, new ResourceLocation("zenith_attributes", "crit_chance"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.CURRENT_HP_DAMAGE, new ResourceLocation("zenith_attributes", "current_hp_damage"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.DODGE_CHANCE, new ResourceLocation("zenith_attributes", "dodge_chance"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.DRAW_SPEED, new ResourceLocation("zenith_attributes", "draw_speed")); //you should use ranged_weapon:haste instead, if available
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.ELYTRA_FLIGHT, new ResourceLocation("zenith_attributes", "elytra_flight"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.FIRE_DAMAGE, new ResourceLocation("zenith_attributes", "fire_damage"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.GHOST_HEALTH, new ResourceLocation("zenith_attributes", "ghost_health"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.HEALING_RECEIVED, new ResourceLocation("zenith_attributes", "healing_received"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.LIFE_STEAL, new ResourceLocation("zenith_attributes", "life_steal"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.PROT_PIERCE, new ResourceLocation("zenith_attributes", "prot_pierce"));
            Rpgattr.addAttributeToCompat(ALObjects.Attributes.PROT_SHRED, new ResourceLocation("zenith_attributes", "prot_shred"));
        }
    }
}
