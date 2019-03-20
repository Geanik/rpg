package org.geanik.rpg.data.creatures;

import org.geanik.rpg.data.stuff.Inventory;

import java.util.Random;

public class Creature {

    // ----- members -----
    private String name;
    private int level;
    private int healthPoints;
    private int combatPower;
    private double hitChance;
    private Inventory inventory;

    private static Random rand = new Random();

    // ----- constructors -----
    public Creature(String name, int level) {
        this.name = name;
        this.level = level;

        int randFactorHp = 5 + rand.nextInt(10);
        this.healthPoints = level * 20 * (randFactorHp);

        int randFactorCp = 5 + rand.nextInt(10);
        this.combatPower = level * 5 * randFactorCp;

        this.hitChance = (50.0 + rand.nextInt(30)) / 100;

        this.inventory = new Inventory();
    }

    // ----- methods -----
    public boolean  attack(Creature target) {
        double hitProbability = rand.nextDouble();
        boolean hits = hitProbability <= (this.hitChance + this.inventory.getHitChanceBonusSum());

        if (hits) {
            int dmg = (this.combatPower + inventory.getDamageBonusSum())
                    - (target.getInventory().getArmorBonusSum());

            target.healthPoints -= dmg;
            System.out.println(target.getName() + " took " + dmg + " from " + this.name);
            return true;
        }

        System.out.println(this.name + " missed " + target.getName());
        return false;
    }

    public boolean isAlive() {
        return this.healthPoints > 0;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", healthPoints=" + healthPoints +
                ", combatPower=" + combatPower +
                '}';
    }

    // ----- getters & setters -----
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getCombatPower() {
        return combatPower;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
