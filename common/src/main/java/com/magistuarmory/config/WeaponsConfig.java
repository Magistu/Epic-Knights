package com.magistuarmory.config;

import com.magistuarmory.item.RangedWeaponType;
import com.magistuarmory.item.WeaponType;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import java.util.LinkedHashMap;
import java.util.Map;

@Config(name = "weapons")
public class WeaponsConfig implements ConfigData {

    @ConfigEntry.Gui.CollapsibleObject
    private Map<String, RangedWeaponType> rangedWeapons = new LinkedHashMap<>() {{
        put("longbow", RangedWeaponType.of(420, 36, 4.3f, true));
        put("heavyCrossbow", RangedWeaponType.of(500, 50, 4.3f, true));
    }};

    @ConfigEntry.Gui.CollapsibleObject
    private Map<String, WeaponType> meleeWeapons = new LinkedHashMap<>() {{
        put("barbedClub", WeaponType.of(2.00f, 1.60f, 0.00f, 0.0f, 0.6f, 15, true));
        put("blacksmithHammer", WeaponType.of(2.50f, 1.70f, 0.00f, 0.0f, 0.9f, 0, true));
        put("club", WeaponType.of(3.20f, 1.65f, 0.00f, 0.0f, 1.1f, 0, true));
        put("flail", WeaponType.of(3.00f, 1.17f, 3.00f, 0.0f, 3.0f, 0, true, 2, 0.0f, false, false, false));
        put("heavyMace", WeaponType.of(3.30f, 1.17f, 2.00f, 0.0f, 2.5f, 0, true, 1, 3.0f, true, false, false));
        put("heavyWarHammer", WeaponType.of(2.80f, 1.28f, 1.00f, 0.02f, 4.0f, 12, true, 2, 3.0f, true, false, false));
        put("lucerneHammer", WeaponType.of(2.50f, 0.84f, 2.00f, 0.0f, 4.5f, 10, true));
        put("morningstar", WeaponType.of(4.25f, 1.40f, 0.00f, 0.02f, 1.8f, 0, true, 1, 5.0f, true, false, false));
        put("rustedHeavyMace", WeaponType.of(4.10f, 1.40f, 0.50f, 0.02f, 2.0f, 3, true, 1, 5.0f, true, false, false));
        put("stiletto", WeaponType.of(5.30f, 1.22f, 0.00f, 0.1f, 2.6f, 0, true, 2, 6.0f, true, false, false));
        put("claymore", WeaponType.of(6.00f, 1.12f, 0.50f, 0.05f, 4.0f, 4, true, 2, 6.0f, true, false, false));
        put("flameBladedSword", WeaponType.of(6.00f, 1.12f, 0.50f, 0.05f, 4.0f, 4, true, 2, 6.0f, true, true, false));
        put("zweihander", WeaponType.of(7.00f, 1.00f, 0.90f, 0.05f, 3.5f, 0, true, 1, 3.0f, true, false, false));
        put("concaveEdgedHalberd", WeaponType.of(7.30f, 0.90f, 1.00f, 0.05f, 4.1f, 2, true, 2, 3.0f, true, false, true));
        put("giantLance", WeaponType.of(4.80f, 1.15f, 0.00f, 0.05f, 2.6f, 0, true));
        put("lochaberAxe", WeaponType.of(5.00f, 1.05f, 0.00f, 0.05f, 2.5f, 15, true));
        put("bastardSword", WeaponType.of(4.40f, 1.10f, 0.70f, 0.05f, 2.5f, 20, true, 1, 0.0f, false, false, false));
        put("estoc", WeaponType.of(4.70f, 1.25f, 0.00f, 0.05f, 2.5f, 0, true));
        put("messerSword", WeaponType.of(6.20f, 1.00f, 0.00f, 0.06f, 3.0f, 0, true));
        put("nobleSword", WeaponType.of(3.15f, 1.12f, 1.90f, 0.0f, 2.5f, 0, true, 1, 3.3f, true, false, false));
        put("rustedBastardSword", WeaponType.of(5.00f, 1.00f, 0.00f, 0.05f, 1.4f, 4, true));
        put("ahlspiess", WeaponType.of(5.20f, 1.00f, 0.00f, 0.0f, 1.0f, 0, true));
        put("guisarme", WeaponType.of(2.80f, 1.10f, 2.00f, 0.05f, 1.2f, 0, true));
        put("pike", WeaponType.of(4.25f, 1.51f, 0.00f, 0.02f, 2.7f, 0, true, 1, 5.0f, true, false, false));
        put("pitchfork", WeaponType.of(2.00f, 1.51f, 0.00f, 0.02f, 2.7f, 0, true, 1, 5.0f, true, false, false));
        put("ranseur", WeaponType.of(2.00f, 1.51f, 0.00f, 0.02f, 2.6f, 0, true));
        put("katzbalger", WeaponType.of(7.00f, 0.80f, 0.00f, 0.0f, 5.0f, 0, true, 1, 0.0f, false, false, false));
        put("shortSword", WeaponType.of(3.40f, 1.50f, 0.00f, 0.02f, 1.2f, 0, true, 0, 5.0f, true, false, false));
    }};

    public RangedWeaponType getRanged(String name) {
        return rangedWeapons.get(name);
    }

    public WeaponType getMelee(String name) {
        return meleeWeapons.get(name);
    }
}