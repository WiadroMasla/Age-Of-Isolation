package com.ageofisolation.playScreen.Entity.Player.CardZones.Card;

import com.ageofisolation.playScreen.Entity.Targetable;

public interface CardEffect {
    void apply(Targetable target);
    String getCardboxString();
    boolean isTargeted();
}
