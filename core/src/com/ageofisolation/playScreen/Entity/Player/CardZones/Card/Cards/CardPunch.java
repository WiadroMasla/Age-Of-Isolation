package com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Cards;

import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Card;
import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.CardEffect;
import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.CardEffectBase;
import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.CardEffects.DealDamageEffect;

public class CardPunch {
    private static Card instance = new Card("Punch", "Graphics/Card/ArtPlaceholder.png",
            new DealDamageEffect(CardEffectBase.getInstance(), 5),
            1);

    public static Card getInstance() {
        return instance;
    }
}
