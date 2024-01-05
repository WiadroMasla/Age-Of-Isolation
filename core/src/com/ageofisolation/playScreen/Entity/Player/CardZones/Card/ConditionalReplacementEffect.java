package com.ageofisolation.playScreen.Entity.Player.CardZones.Card;

import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.CardEffect;
import com.ageofisolation.playScreen.Entity.Targetable;

public class ConditionalReplacementEffect implements CardEffect {
    private Condition condition;
    private CardEffect ifTrue;
    private CardEffect ifFalse;

    ConditionalReplacementEffect(Condition condition, CardEffect ifTrue, CardEffect ifFalse) {
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }
    @Override
    public void apply(Targetable target) {
        if (condition.isFulfilled()) {
            ifTrue.apply(target);
        } else {
            ifFalse.apply(target);
        }
    }

    @Override
    public String getCardboxString() {
        return "[ " + ifFalse.getCardboxString() + "\n] " + condition.getString() + "[\n" + ifTrue.getCardboxString()
                + "\n] instead.";
    }

    @Override
    public boolean isTargeted() {
        return condition.isFulfilled() ? ifTrue.isTargeted() : ifFalse.isTargeted();
    }
}
