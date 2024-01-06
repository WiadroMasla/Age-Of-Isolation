package com.ageofisolation.playScreen.Entity.Player.CardZones;

import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Card;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graveyard {
    private List<Card> cards;
    public Graveyard() {
        cards = new LinkedList<>();
    }

    public int size() {
        return cards.size();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Collection<Card> returnCards(int amount) {
        Collection<Card> out = new LinkedList<>();
        Collections.shuffle(cards);
        while (amount > 0 && size() > 0) {
            out.add(cards.remove(0));
            --amount;
        }
        return out;
    }
}
