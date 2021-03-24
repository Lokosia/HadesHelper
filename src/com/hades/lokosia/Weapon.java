package com.hades.lokosia;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Weapon {
    private static Weapon instance;
    private String type;
    private String aspect;

    public String getType() {
        return type;
    }

    public String getAspect() {
        return aspect;
    }

    private Weapon(String type, String aspect) {
        this.type = type;
        this.aspect = aspect;
    }

    public static Weapon getInstance(String type, String aspect) {
        if (instance == null) {
            instance = new Weapon(type, aspect);
            System.out.println("Weapon " + type + " of " + aspect + " created!");
        } else {
            System.out.println("Weapon changed!");
        }
        return instance;
    }

    public static LinkedHashMap<String, String[]> WeaponPrefs() {
        //main map
        LinkedHashMap<String, String[]> weaponPrefs = new LinkedHashMap<>();

        weaponPrefs.put("SWORD", new String[]{"ZAGREUS", "NEMESIS", "POSEIDON", "ARTHUR"});
        weaponPrefs.put("SPEAR", new String[]{"ZAGREUS", "ACHILLES", "HADES", "GUANYU"});
        weaponPrefs.put("SHIELD", new String[]{"ZAGREUS", "CHAOS", "ZEUS", "BEOWULF"});
        weaponPrefs.put("BOW", new String[]{"ZAGREUS", "CHIRON", "HERA", "RAMA"});
        weaponPrefs.put("FISTS", new String[]{"ZAGREUS", "TALOS", "DEMETER", "GILGAMESH"});
        weaponPrefs.put("RAIL", new String[]{"ZAGREUS", "ERIS", "HESTIA", "LUCIFER"});

        return weaponPrefs;
    }
}
