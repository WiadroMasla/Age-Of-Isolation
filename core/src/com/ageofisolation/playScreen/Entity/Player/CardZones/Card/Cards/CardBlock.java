package com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Cards;

import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Card;
import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.CardEffectBase;
import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.CardEffects.GainBlockEffect;

public class CardBlock {
    private static Card instance = new Card("Block", "Graphics/Card/ArtPlaceholder.png",
            new GainBlockEffect(CardEffectBase.getInstance(), 4),
            1);

    public static Card getInstance() {
        return instance;
    }
}
