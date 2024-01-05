package com.ageofisolation.playScreen.Entity.StatusEffect;

import com.ageofisolation.playScreen.Entity.EntityModel;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderInfo;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderer;
import com.ageofisolation.playScreen.Entity.Targetable;

public class StatusEffectBase implements NextStatusEffect {
    private EntityModel entityModel;
    private PrevStatusEffect prev;
    public StatusEffectBase(EntityModel model, PrevStatusEffect head) {
        entityModel = model;
        prev = head;
    }

    @Override
    public void setPrev(PrevStatusEffect prev) {
        this.prev = prev;
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

    }

    @Override
    public void dealDamage(int amount, Targetable target) {
        entityModel.dealDamage(amount, target);
    }

    @Override
    public void takeDamage(int amount) {
        entityModel.takeDamage(amount);
    }

    @Override
    public void gainBlock(int amount) {
        entityModel.gainBlock(amount);
    }

    @Override
    public void heal(int amount) {
        entityModel.heal(amount);
    }

    @Override
    public void applyStatusEffect(StatusEffect effect) {
        effect.setNext(this);
        effect.setPrev(prev);
        prev.setNext(effect);
        setPrev(effect);
    }

    @Override
    public void startTurn() {
        entityModel.startTurn();
    }

    @Override
    public void endTurn() {

    }
}
