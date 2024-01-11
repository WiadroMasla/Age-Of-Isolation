package com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Conditions;

import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Condition;
import com.ageofisolation.playScreen.Entity.Player.PlayerFacade;

public class FinaleCondition implements Condition {

    @Override
    public boolean isFulfilled() {
        return PlayerFacade.getInstance().getMana() == 0;
    }

    @Override
    public String getString() {
        return "Finale:";
    }
}
