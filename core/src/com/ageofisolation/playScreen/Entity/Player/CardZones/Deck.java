package com.ageofisolation.playScreen.Entity.Player.CardZones;

import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Card;
import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Cards.CardPunch;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private List<Card> cards;
    public Deck() {
        cards = new LinkedList<>();
        addCards(CardPunch.getInstance(), 20);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
        shuffle();
    }

    public void addCards(Card card, int amount) {
        while (amount > 0) {
            cards.add(card);
            --amount;
        }
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
