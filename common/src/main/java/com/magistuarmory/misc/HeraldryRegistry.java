package com.magistuarmory.misc;

import java.util.HashSet;
import java.util.Set;

public class HeraldryRegistry
{
    static Set<String> HERALDRY = new HashSet<>();
    
    public static void register(String name) {
        HERALDRY.add(name);
    }
    
    public static boolean isRegistered(String name) {
        return HERALDRY.contains(name);
    }
}
