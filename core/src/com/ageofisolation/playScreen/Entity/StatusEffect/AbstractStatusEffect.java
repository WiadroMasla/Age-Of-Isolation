package com.ageofisolation.playScreen.Entity.StatusEffect;

import com.ageofisolation.playScreen.Entity.StatusEffectRenderInfo;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderer;
import com.ageofisolation.playScreen.Entity.Targetable;

public abstract class AbstractStatusEffect implements StatusEffect {
    NextStatusEffect next;
    PrevStatusEffect prev;

    @Override
    public void setPrev(PrevStatusEffect prev) {
        this.prev = prev;
    }

    @Override
    public void setNext(NextStatusEffect next) {
        this.next = next;
    }

    @Override
    public void remove() {
        next.setPrev(prev);
        prev.setNext(next);
    }

    @Override
    public void render(StatusEffectRenderer statusEffectRenderer) {
        statusEffectRenderer.render(getStatusEffectRenderInfo());
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
        if (effect.getLayerEnum().getLayerNumber() > getLayerEnum().getLayerNumber() ||
                (effect.getLayerEnum().getLayerNumber() > getLayerEnum().getLayerNumber()
                && effect.getPriority() > getPriority())) {
            next.applyStatusEffect(effect);
        } else {
            effect.setNext(this);
            effect.setPrev(prev);
            prev.setNext(effect);
            setPrev(effect);
        }
    }

    @Override
    public void startTurn() {
        next.startTurn();
    }

    @Override
    public void endTurn() {
        next.endTurn();
    }

    protected abstract String getTexturePath();
}
