package com.ageofisolation.playScreen.Entity.Player.CardZones.Card;

import com.ageofisolation.playScreen.Entity.Targetable;

public class ConditionalEffect implements CardEffect {
    Condition condition;
    CardEffect ifTrue;
    CardEffect next;

    @Override
    public void apply(Targetable target) {
        if (condition.isFulfilled()) {
            ifTrue.apply(target);
        }
        next.apply(target);
    }

    @Override
    public String getCardboxString() {
        return condition.getString() + " [\n" + ifTrue.getCardboxString() + " ]\n" + next.getCardboxString();
    }

    @Override
    public boolean isTargeted() {
        if (condition.isFulfilled() && ifTrue.isTargeted()) {
            return true;
        }
        return next.isTargeted();
    }
}
