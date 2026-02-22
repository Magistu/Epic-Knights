package com.magistuarmory.config;

import com.moandjiezana.toml.Toml;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class DisabledItemsParser {
    public static Set<String> getDisabledItems(File tomlFile) {
        if (!tomlFile.exists()) {
            return Set.of();
        }

        Toml toml = new Toml().read(tomlFile);
        Set<String> disabledItems = new HashSet<>();

        for (Map.Entry<String, Object> entry : toml.toMap().entrySet()) {
            String itemName = entry.getKey();
            Object tableObj = entry.getValue();

            if (!(tableObj instanceof Map<?, ?> table)) {
                continue;
            }

            Object enabledObj = table.get("enabled");
            if (enabledObj instanceof Boolean) {
                boolean enabled = (Boolean) enabledObj;
                if (!enabled) {
                    disabledItems.add(itemName);
                }
            }
        }

        return disabledItems;
    }
}