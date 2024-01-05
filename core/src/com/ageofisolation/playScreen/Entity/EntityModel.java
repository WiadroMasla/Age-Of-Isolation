package com.ageofisolation.playScreen.Entity;

public interface EntityModel {
    void dealDamage(int amount, Targetable target);
    void takeDamage(int amount);
    void gainBlock(int amount);
    void heal(int amount);
    void startTurn();
}
