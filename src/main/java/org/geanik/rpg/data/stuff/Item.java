package org.geanik.rpg.data.stuff;

import java.util.UUID;

public class Item {

    // ----- members -----
    private int id;
    private String name;
    private int damageBonus;
    private int armorBonus;
    private ItemType type;

    // ----- constructors -----
    public Item(String name, int damageBonus, int armorBonus, ItemType type) {
        this.id = UUID.randomUUID().variant();
        this.name = name;
        this.damageBonus = damageBonus;
        this.armorBonus = armorBonus;
        this.type = type;
    }

    // ----- getters & setters -----
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    public void setDamageBonus(int damageBonus) {
        this.damageBonus = damageBonus;
    }

    public int getArmorBonus() {
        return armorBonus;
    }

    public void setArmorBonus(int armorBonus) {
        this.armorBonus = armorBonus;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
