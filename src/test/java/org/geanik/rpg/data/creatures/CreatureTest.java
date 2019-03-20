package org.geanik.rpg.data.creatures;

import org.junit.Test;

public class CreatureTest {

    private Creature deadCreature = new Creature("dead Creature", 0);

    private Creature creature1 = new Creature("Creature1", 10);
    private Creature creature2 = new Creature("Creature2", 4);

    @Test
    public void attack() {
        int hpOfCreature2 = creature2.getHealthPoints();
        boolean wasHit = false;

        while (!wasHit) {
            wasHit = creature1.attack(creature2);
        }

        int dmg = creature1.getCombatPower() + creature1.getInventory().getDamageBonusSum();
        dmg -= creature2.getInventory().getArmorBonusSum();
        assert creature2.getHealthPoints() == hpOfCreature2 - dmg;
    }

    @Test
    public void isAlive() {
        assert !deadCreature.isAlive();
    }
}