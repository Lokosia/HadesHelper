package com.hades.lokosia;

import com.hades.lokosia.enums.Gods;
import com.hades.lokosia.enums.Rarity;
import com.hades.lokosia.enums.Slots;

public class Boon {
    private int level = 1;
    private Gods god;
    private Rarity rarity = Rarity.COMMON;
    private Slots slot;
    private String name;
    private String description;
    private String notes;
    private Boon[] prerequisites;

    public Boon(Gods god, Slots slot, String name, String description, String notes, Boon[] prerequisites) {
        this.god = god;
        this.slot = slot;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.prerequisites = prerequisites;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public Gods getGod() {
        return god;
    }

    public Slots getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getNotes() {
        return notes;
    }

    public Boon[] getPrerequisites() {
        return prerequisites;
    }
}
