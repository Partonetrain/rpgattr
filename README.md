Allows you to use attributes from mods in Spell Engine item configs (Jewelry, Wizards, Archers, Paladins, etc.)

Currently supports:
- [Zenith Attributes](https://www.curseforge.com/minecraft/mc-mods/zenith-attributes) (will have no effect if Zepyhr is installed, as it does the same thing)
- [Step Height Entity Attribute](https://github.com/emilyploszaj/step-height-entity-attribute)
- [Reach Entity Attributes](https://github.com/JamiesWhiteShirt/reach-entity-attributes)

**Note**: This mod works by literally cancelling the registration of these mods' attributes and registering them at a different time. I have not observed any problems with this, but keep this in mind while debugging your modpack.