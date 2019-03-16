package org.geanik.rpg.data.stuff;

import java.util.Objects;
import java.util.UUID;

public class Item {

    // ----- members -----
    private UUID id;
    private String name;
    private int damageBonus;
    private int armorBonus;
    private double hitChanceBonus;
    private ItemType type;

    // ----- constructors -----
    public Item(String name, int damageBonus, int armorBonus, double hitChanceBonus, ItemType type) {
        this.hitChanceBonus = hitChanceBonus;
        this.id = UUID.randomUUID();
        this.name = name;
        this.damageBonus = damageBonus;
        this.armorBonus = armorBonus;
        this.type = type;
    }

    public Item(UUID id, String name, int damageBonus, int armorBonus, double hitChanceBonus, ItemType type) {
        this.id = id;
        this.name = name;
        this.damageBonus = damageBonus;
        this.armorBonus = armorBonus;
        this.hitChanceBonus = hitChanceBonus;
        this.type = type;
    }

    // ----- methods -----
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||
                // both classes don't inherit from Item TODO: maybe better way to compare instances of different inheritance levels
                (!(o.getClass().isAssignableFrom(Item.class) || getClass().isAssignableFrom(Item.class)))) {
            return false;
        }

        Item item = (Item) o;
        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // ----- getters & setters -----
    public UUID getId() {
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

    public double getHitChanceBonus() {
        return hitChanceBonus;
    }

    public void setHitChanceBonus(double hitChanceBonus) {
        this.hitChanceBonus = hitChanceBonus;
    }
}
