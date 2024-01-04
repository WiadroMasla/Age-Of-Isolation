package com.ageofisolation.playScreen.Entity;

import com.ageofisolation.playScreen.Entity.StatusEffect.StatusEffect;

public interface Targetable {
    void dealDamage(int amount, Targetable target);
    void takeDamage(int amount);
    void gainBlock(int amount);
    void heal(int amount);
    void applyStatusEffect(StatusEffect effect);
    void startTurn();
    void endTurn();
}
