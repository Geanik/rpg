package org.geanik.rpg.data.stuff;

import org.junit.Test;

import java.util.Optional;

public class InventoryTest {

    private Inventory inventory = new Inventory();
    private Item weapon1 = new Item("Weapon 1", 20, 10, 0.05, ItemType.WEAPON);
    private Item weapon2 = new Item("Weapon 2", 30, 5, 0.07, ItemType.WEAPON);

    private Item helmet = new Item("Helmet", 15, 7, 0.03, ItemType.HEAD);
    private Item vest = new Item("Vest", 9, 12, 0.01, ItemType.UPPER_BODY);

    @Test
    public void obtainItem() {
        inventory.obtainItem(weapon1);

        assert inventory.getItemMap().size() == 1;
        assert inventory.getItemMap().get(0).equals(weapon1);
        assert inventory.getItemMap().get(0).getCount() == 1;
    }

    @Test
    public void obtainItemAlreadyObtainedItem() {
        inventory.obtainItem(weapon1);
        inventory.obtainItem(weapon1);

        assert inventory.getItemMap().size() == 1;
        assert inventory.getItemMap().get(0).equals(weapon1);
        assert inventory.getItemMap().get(0).getCount() == 2;
    }

    @Test
    public void equipItem() {
        assert inventory.equipItem(weapon1);

        assert inventory.getItemMap().size() == 1;
        assert inventory.getEquippedItemMap().size() == 1;
        assert inventory.getEquippedItemMap().get(0).equals(weapon1);
    }

    @Test
    public void equipObtainedItem() {
        Optional<ObtainedItem> obtainedItemOpt = inventory.obtainItem(weapon1);
        assert obtainedItemOpt.isPresent();

        assert inventory.equipItem(obtainedItemOpt.get());
        assert inventory.getEquippedItemMap().size() == 1;
        assert inventory.getEquippedItemMap().get(0).equals(weapon1);
    }

    @Test
    public void equipDuplicateItemTypeItem() {
        assert inventory.equipItem(weapon1);
        assert ! inventory.equipItem(weapon1);

        assert inventory.getItemMap().size() == 1;
        assert inventory.getEquippedItemMap().size() == 1;
        assert inventory.getEquippedItemMap().get(0).equals(weapon1);
    }

    @Test
    public void getBonusSums() {
        assert inventory.equipItem(weapon1);
        assert inventory.equipItem(helmet);
        assert inventory.equipItem(vest);

        assert inventory.getItemMap().size() == 3;
        assert inventory.getEquippedItemMap().size() == 3;

        assert inventory.getDamageBonusSum() ==
                weapon1.getDamageBonus() + helmet.getDamageBonus() + vest.getDamageBonus();
        assert inventory.getArmorBonusSum() ==
                weapon1.getArmorBonus() + helmet.getArmorBonus() + vest.getArmorBonus();
        assert inventory.getHitChanceBonusSum() ==
                weapon1.getHitChanceBonus() + helmet.getHitChanceBonus() + vest.getHitChanceBonus();
    }

}