package org.geanik.rpg.data.stuff;

public class ObtainedItem extends Item {

    private int count;

    public ObtainedItem(Item item) {
        super(item.getId(), item.getName(), item.getDamageBonus(), item.getArmorBonus(), item.getHitChanceBonus(), item.getType());
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
