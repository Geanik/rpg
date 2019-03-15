package org.geanik.rpg.data.stuff;

import java.util.*;

public class Inventory {

    // ----- members -----
    private Map<UUID, ObtainedItem> itemMap;
    private Map<UUID, ObtainedItem> equippedItemMap;

    // ----- constructors -----
    public Inventory() {
        itemMap = new HashMap<>();
        equippedItemMap = new HashMap<>();
    }

    // ----- methods -----
    public Optional<ObtainedItem> obtainItem(Item item) {

        Optional<ObtainedItem> obtainedItemOpt = itemMap.values().stream()
                .filter(i -> i.getName().equals(item.getName())).findAny();

        if (obtainedItemOpt.isPresent()) {
            // item already in inventory
            ObtainedItem obtainedItem = obtainedItemOpt.get();
            obtainedItem.setCount(obtainedItem.getCount() + 1);
        } else {
            // item needs to be added
            ObtainedItem obtainedItem = new ObtainedItem(item);
            itemMap.put(obtainedItem.getId(), obtainedItem);

            return Optional.of(obtainedItem);
        }

        return Optional.empty();
    }

    public boolean equipItem(ObtainedItem obtainedItem) {
        long nrOfBodyPartItems = equippedItemMap.values().stream()
                .filter(i -> i.getType().equals(obtainedItem.getType()))
                .count();

        if (nrOfBodyPartItems == 0) {
            // only allow to equip item if no other one of same bodyPart is already equipped
            if (itemMap.containsKey(obtainedItem.getId())) {
                equippedItemMap.put(obtainedItem.getId(), obtainedItem);
                return true;
            }
        }

        return false;
    }

    public boolean equipItem(Item item) {
        Optional<ObtainedItem> obtainedItem = obtainItem(item);

        if (obtainedItem.isPresent()) {
            return equipItem(obtainedItem.get());
        }

        return false;
        // can be replaced with "return obtainedItem.filter(this::equipItem).isPresent();" :o
    }

    public int getDamageBonusSum() {
        return equippedItemMap.values().stream().mapToInt(ObtainedItem::getDamageBonus).sum();
    }

    public int getArmorBonusSum() {
        return equippedItemMap.values().stream().mapToInt(ObtainedItem::getArmorBonus).sum();
    }

    // ----- getters & setters -----
    public Collection<ObtainedItem> getItemMap() {
        return itemMap.values();
    }

    public Collection<ObtainedItem> getEquippedItemMap() {
        return equippedItemMap.values();
    }
}
