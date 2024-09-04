package info.partonetrain.rpgattr;

import com.google.common.collect.Multimap;
import elocindev.customitemattributes.CustomItemAttributes;
import elocindev.customitemattributes.api.GenericAttribute;
import elocindev.customitemattributes.api.ItemProperty;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

import java.util.*;

public class CustomItemAttributesUtil {

    public static HashMap<String, ItemProperty> itemProperties = new HashMap<>();

    public static void onDatapackReloadStart() {
        var configItems = CustomItemAttributes.CONFIG.items;
        itemProperties = new HashMap<>();
        for (ItemProperty item : configItems) {
            itemProperties.put(item.item, item);
        }
    }

    public static void register(ItemStack stack, EquipmentSlot slot, Multimap<Attribute, AttributeModifier> builder, ItemProperty item) {
        CompoundTag nbt = stack.getTag();
        if (nbt != null && nbt.getBoolean("Unbreakable") != item.unbreakable) {
            nbt.putBoolean("Unbreakable", item.unbreakable);
            stack.save(nbt);
        }

        switch(slot) {
            case MAINHAND:
                applyModifiers(stack, item, item.attribute_overrides, builder);
                break;
            case OFFHAND:
                applyModifiers(stack, item, item.attribute_overrides, builder);
                break;
            case HEAD:
                applyModifiers(stack, item, item.attribute_overrides, builder);
                break;
            case CHEST:
                applyModifiers(stack, item, item.attribute_overrides, builder);
                break;
            case LEGS:
                applyModifiers(stack, item, item.attribute_overrides, builder);
                break;
            case FEET:
                applyModifiers(stack, item, item.attribute_overrides, builder);
                break;
        }
    }

    public static void applyModifiers(ItemStack stack, ItemProperty property, List<GenericAttribute<String, ?>> attributes, Multimap<Attribute, AttributeModifier> builder) {
        for (GenericAttribute<?, ?> generic_attribute : attributes) {
            try {
                Attribute attribute = generic_attribute.getAttribute();
                Collection<AttributeModifier> newModifiers = new ArrayList<>();
                var identifierString = stack.toString() + generic_attribute.getString();

                newModifiers.add(
                        new AttributeModifier(
                                UUID.nameUUIDFromBytes(identifierString.getBytes()),
                                "Custom Item Attributes Modifier",
                                generic_attribute.getDouble(),
                                generic_attribute.getOperation()
                        ));

                if (builder.containsValue(attribute))
                    builder.replaceValues(attribute, newModifiers);
                else
                    builder.putAll(attribute, newModifiers);

            } catch (Exception e) {
                CustomItemAttributes.LOGGER.error("[Rpgattr CustomItemAttributesUtil] Error adding attribute modifier: " + e.getMessage());
            }
        }
    }

}