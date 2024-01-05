package com.ageofisolation.playScreen.Entity.Player.CardZones.Card;

import com.ageofisolation.playScreen.Entity.Targetable;

public class CardEffectBase implements CardEffect {
    private static final CardEffectBase instance = new CardEffectBase();

    private CardEffectBase(){

    }

    public static CardEffectBase getInstance() {
        return instance;
    }

    @Override
    public void apply(Targetable target) {

    }

    @Override
    public String getCardboxString() {
        return "";
    }

    @Override
    public boolean isTargeted() {
        return false;
    }
}
