package com.ageofisolation.playScreen.Entity.Player.CardZones.Card.CardEffects;

import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.AbstractSimpleEffect;
import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.CardEffect;
import com.ageofisolation.playScreen.Entity.Player.PlayerFacade;
import com.ageofisolation.playScreen.Entity.Targetable;

public class DealDamageEffect extends AbstractSimpleEffect {
    private int magnitude;
    public DealDamageEffect(CardEffect next, int magnitude) {
        super(next);
        this.magnitude = magnitude;
    }

    @Override
    protected String getEffectString() {
        return "Deal " + magnitude + " damage.\n";
    }

    @Override
    protected void applyEffect(Targetable target) {
        PlayerFacade.getInstance().dealDamage(magnitude, target);
    }

    @Override
    public boolean isTargeted() {
        return true;
    }
}
