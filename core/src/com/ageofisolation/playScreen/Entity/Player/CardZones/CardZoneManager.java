package com.ageofisolation.playScreen.Entity.Player.CardZones;

public class CardZoneManager {
    public static final int DRAW_TO = 5;
    public static final int HAND_SIZE = 7;

    private Hand hand;
    private Deck deck;
    private Graveyard graveyard;
    public CardZoneManager(){
        hand = new Hand();
        deck = new Deck();
        graveyard = new Graveyard();
    }
    public void startTurn() {
        System.out.println("START TURN");
        drawCards(DRAW_TO);
    }

    public void endTurn() {
        deck.addCards(hand.returnHand());
    }

    public void heal(int amount) {
        deck.addCards(graveyard.returnCards(amount));
    }

    public void drawCards(int amount) {
        System.out.println("DRAWING: " + amount);
        while (deck.size() > 0 && hand.size() < HAND_SIZE && amount > 0) {
            hand.addCard(deck.getCard());
            --amount;
        }
    }

    public Deck getDeck() {
        return deck;
    }

    public int size() {
        return hand.size() + deck.size() + graveyard.size();
    }

    public int deckSize() {
        return deck.size();
    }

    public int graveyardSize() {
        return graveyard.size();
    }

    public Hand getHand() {
        return hand;
    }

    public void render() {
        hand.render();
        //TODO: render deck and GY
    }

    public void update(float delta) {
        hand.update(delta);
    }

    public boolean mill(int amount) {
        if (graveyardSize() >= deckSize()) {
            return true;
        }
        while (amount > 0) {
            graveyard.addCard(deck.getCard());
            --amount;
        }
        return false;
    }
}
