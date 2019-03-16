package org.geanik.rpg;

import org.geanik.rpg.data.creatures.Creature;
import org.geanik.rpg.data.stuff.Item;
import org.geanik.rpg.data.stuff.ItemType;

public class App {

    public static void main(String[] args) {
        Creature c1 = new Creature("Boss", 10);
        Item item1 = new Item("Excalibur", 45, 0, 0.05, ItemType.WEAPON);
        Item item2 = new Item("Excalibur2", 45, 0, 0.05, ItemType.WEAPON);
        Item item3 = new Item("Excalibur3", 45, 0, 0.05, ItemType.WEAPON);
        c1.getInventory().equipItem(item1);

        Creature c2 = new Creature("Noob", 5);

        System.out.println("Created creatures:");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println();
        System.out.println();
        System.out.println();

        while (c2.isAlive()) {
            System.out.println(c1.attack(c2));
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(c1);
        System.out.println(c2);
    }
}
