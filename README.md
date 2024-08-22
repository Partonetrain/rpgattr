Allows you to use attributes from certain mods in Spell Engine item configs (Jewelry, Wizards, Archers, Paladins, etc.), and adds some other features to integrate involved mods more (configured via gamerules).

RPGAttr supports:
- [Zenith Attributes](https://modrinth.com/mod/zenith-attributes) (will have no effect if Zepyhr is installed, as it does the same thing)
- [AdditionalEntityAttributes](https://github.com/DaFuqs/AdditionalEntityAttributes)
- [Reach Entity Attributes](https://github.com/JamiesWhiteShirt/reach-entity-attributes)
- [Botania](https://modrinth.com/mod/botania)

RPGAttr adds the following gamerules:

- vanillaCrits: whether or not vanilla (falling) crits are enabled. Defaults to true (vanilla behavior).
- difficultyDamageScaling: whether or not the 0.5x (Easy) or 1.5x (Hard) damage scaling is applied. This does **not** effect other consequences of world and local difficulty. Defaults to true (vanilla behavior).
- zenithCritsMeleeOnly (Only when Zenith Attributes is installed): whether or not the zenith_attributes:crit_chance attribute is only effects melee crits. Defaults to false (standard ZA behavior).

**Note**: Any mod that mixes in to EntityAttribute [yarn name] class initialization such as [Step Height Entity Attribute](https://github.com/emilyploszaj/step-height-entity-attribute/blob/master/src/main/java/dev/emi/stepheightentityattribute/mixin/EntityAttributesMixin.java) should already be compatible with Spell Engine. This mod works by literally cancelling the registration of these mods' attributes and registering them at a different time. I have not observed any problems with this, but keep this in mind while debugging your modpack.