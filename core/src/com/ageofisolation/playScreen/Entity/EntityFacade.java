package com.ageofisolation.playScreen.Entity;

import com.ageofisolation.playScreen.Entity.StatusEffect.AbstractStatusEffect;
import com.ageofisolation.playScreen.Entity.StatusEffect.StatusEffect;
import com.ageofisolation.playScreen.Entity.StatusEffect.StatusEffectHead;

public abstract class EntityFacade implements Targetable {
    protected StatusEffectHead statusEffectHead;
    public EntityFacade(EntityModel entityModel) {
        statusEffectHead = new StatusEffectHead(entityModel);
    }

    @Override
    public void dealDamage(int amount, Targetable targetable) {
        statusEffectHead.dealDamage(amount, targetable);
    }

    @Override
    public void takeDamage(int amount) {
        statusEffectHead.takeDamage(amount);
    }

    @Override
    public void gainBlock(int amount) {
        statusEffectHead.gainBlock(amount);
    }

    @Override
    public void heal(int amount) {
        statusEffectHead.heal(amount);
    }

    @Override
    public void applyStatusEffect(StatusEffect effect) {
        statusEffectHead.applyStatusEffect(effect);
    }

    @Override
    public void startTurn() {
        statusEffectHead.startTurn();
    }

    @Override
    public void endTurn() {
        statusEffectHead.endTurn();
    }

    public void render() {
        specificRender();
        statusEffectHead.render(getStatusEffectRenderer());
    }

    protected abstract StatusEffectRenderer getStatusEffectRenderer();
    protected abstract void specificRender();
}
