package com.ageofisolation.playScreen.Entity.Player.CardZones;

import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Card;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private List<Card> cards;
    public Deck() {
        cards = new LinkedList<>();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
        shuffle();
    }

    public void addCards(Collection<? extends Card> cards) {
        this.cards.addAll(cards);
        shuffle();
    }

    public Card getCard() {
        if (size() <= 0) {
            return null;
        }
        return cards.remove(size()-1);
    }

    public int size() {
        return cards.size();
    }
}
