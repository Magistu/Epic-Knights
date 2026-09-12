The common, Fabric, and NeoForge modules target Minecraft **26.1.2** and Java 25. Exact 26.1 is no longer advertised: the published Architectury NeoForge integration references events absent from the last NeoForge release for that version. The tested dependency set is Fabric Loader 0.19.5, Fabric API 0.155.3+26.1.2, NeoForge 26.1.2.109, Architectury 20.1.14, and Cloth Config 26.1.154.

Both loader adapters implement the pavise block-entity factory and register the shared numeric item-property, tint, and heraldry special-renderer codecs before model loading. Fabric uses ArmorRenderer and render-layer callbacks; NeoForge registers armor client extensions and render layers on its mod event bus. The old built-in item renderer and per-item initializeClient hooks are gone. Epic Fight compatibility remains disabled.

The common port uses item/equipment components instead of ArmorItem, AnimalArmorItem, and Tier. Item and block IDs are assigned before construction. Creative-tab stacks and lance break drops are constructed after item components are bound. Armor models use the nested head/hat hierarchy, apply equipment-slot visibility at draw time, and are rebuilt after resource reloads.

Item definitions live under assets/magistuarmory/items. Blocking, bow draw, crossbow ammunition, raised lances, and plume selection use the shared numeric property codec. Equipment assets reference textures under textures/entity/equipment. Pavise blockstates cover each registered material. Recipes use the new ingredient encoding; villager offers are data-driven; loot tables use the singular loot_table directory.

Validation from the repository root:

```sh
java -classpath gradle/wrapper/gradle-wrapper.jar org.gradle.wrapper.GradleWrapperMain :common:build :fabric:build :neoforge:build --console=plain
python3 -m unittest discover -s common/src/test/python -v
```

Both development clients were launched on 26.1.2 and completed resource loading without model-baking failures or resource-pack fallback, then exited normally. This is a startup smoke test, not a gameplay test. Combat, armor decorations in motion, resource reloading in a world, and placing/breaking decorated pavises still need an in-game playtest. Some pre-existing unused/add-on texture references and Architectury-transformed OnlyIn annotations still produce warnings.

Final shaded artifacts are fabric/build/libs/epic-knights-26.1.2-fabric-10.12.jar and neoforge/build/libs/epic-knights-26.1.2-neoforge-10.12.jar. Development runs include loader dependencies on their runtime classpaths; those dependencies must also be installed alongside the release jars.
