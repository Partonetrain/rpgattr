Allows you to use attributes from certain mods in Spell Engine item configs (Jewelry, Wizards, Archers, Paladins, etc.)

RPGAttr version 2.1.0+ for Spell Engine 0.14+ supports:
- [Zenith Attributes](https://www.curseforge.com/minecraft/mc-mods/zenith-attributes) (will have no effect if Zepyhr is installed, as it does the same thing)
- [AdditionalEntityAttributes](https://github.com/DaFuqs/AdditionalEntityAttributes)
- [Reach Entity Attributes](https://github.com/JamiesWhiteShirt/reach-entity-attributes)
- [Botania](https://www.curseforge.com/minecraft/mc-mods/botania)

Version 2.1.0 adds vanillaCrit gamerule (defaults to true), which will prevent vanilla (falling) crits when set to false (for use with Zenith Attributes crit chance attribute). It also removes the hard requirement for Spell Engine, but I am not sure if there are any other use cases for this mod.
Additionally, when Zenith Crits happen, Botania Will crit effects will activate.

Any mod that mixes in to EntityAttribute [yarn name] class initialization such as [Step Height Entity Attribute](https://github.com/emilyploszaj/step-height-entity-attribute/blob/master/src/main/java/dev/emi/stepheightentityattribute/mixin/EntityAttributesMixin.java) should already be compatible with Spell Engine.

**Note**: This mod works by literally cancelling the registration of these mods' attributes and registering them at a different time. I have not observed any problems with this, but keep this in mind while debugging your modpack.