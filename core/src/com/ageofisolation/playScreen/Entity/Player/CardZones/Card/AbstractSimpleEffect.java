package com.ageofisolation.playScreen.Entity.Player.CardZones.Card;

import com.ageofisolation.playScreen.Entity.Targetable;

public abstract class AbstractSimpleEffect implements CardEffect {
    private CardEffect next;

    public AbstractSimpleEffect(CardEffect next) {
        this.next = next;
    }

    @Override
    public final void apply(Targetable target) {
        applyEffect(target);
        next.apply(target);
    }

    @Override
    public final String getCardboxString() {
        return getEffectString() + '\n' + next.getCardboxString();
    }

    @Override
    public boolean isTargeted() {
        return next.isTargeted();
    }

    protected abstract String getEffectString();
    protected abstract void applyEffect(Targetable target);
}
