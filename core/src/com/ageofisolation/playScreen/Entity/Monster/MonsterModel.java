package com.ageofisolation.playScreen.Entity.Monster;

import com.ageofisolation.playScreen.Entity.EntityModel;
import com.ageofisolation.playScreen.Entity.Targetable;

public class MonsterModel implements EntityModel {
    private int maxHealth;
    private int health;
    private int block;
    private MonsterObserver observer;
    public MonsterModel(int maxHealth, MonsterObserver observer) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.block = 0;
        this.observer = observer;
    }
    @Override
    public void dealDamage(int amount, Targetable target) {
        target.takeDamage(amount);
    }

    @Override
    public void takeDamage(int amount) {
        if (amount > block) {
            amount-= block;
            block = 0;
            health-= amount;
            if(health <= 0) {
                observer.notifyMonsters();
            }
        } else {
            block-= amount;
        }
    }

    @Override
    public void gainBlock(int amount) {
        block+= amount;
    }

    @Override
    public void heal(int amount) {
        health = Integer.min(maxHealth, health + amount);
    }

    @Override
    public void startTurn() {
        block = 0;
    }

    public int getHealth() {
        return health;
    }

}
