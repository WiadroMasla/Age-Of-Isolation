package com.ageofisolation.playScreen.Entity.StatusEffect;

import com.ageofisolation.playScreen.Entity.EntityModel;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderInfo;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderer;
import com.ageofisolation.playScreen.Entity.Targetable;

public class StatusEffectHead implements PrevStatusEffect {
    private NextStatusEffect next;

    public StatusEffectHead(EntityModel entityModel) {
        next = new StatusEffectBase(entityModel, this);
    }

    @Override
    public void setNext(NextStatusEffect next) {
        this.next = next;
    }

    @Override
    public StatusEffectRenderInfo getStatusEffectRenderInfo() {
        return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void render(StatusEffectRenderer statusEffectRenderer) {
        next.render(statusEffectRenderer);
    }

    @Override
    public void dealDamage(int amount, Targetable target) {
        next.dealDamage(amount, target);
    }

    @Override
    public void takeDamage(int amount) {
        next.takeDamage(amount);
    }

    @Override
    public void gainBlock(int amount) {
        next.gainBlock(amount);
    }

    @Override
    public void heal(int amount) {
        next.heal(amount);
    }

    @Override
    public void applyStatusEffect(StatusEffect effect) {
        next.applyStatusEffect(effect);
    }

    @Override
    public void startTurn() {
        next.startTurn();
    }

    @Override
    public void endTurn() {
        next.endTurn();
    }

    void removeStatusEffects() {
        NextStatusEffect oldNext;
        do {
            oldNext = next;
            next.remove();
        } while (oldNext != next);
    }
}
