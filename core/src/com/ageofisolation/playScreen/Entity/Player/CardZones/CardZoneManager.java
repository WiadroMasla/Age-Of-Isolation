package com.ageofisolation.playScreen.Entity.Player.CardZones;


import com.ageofisolation.graphics.GraphicsSingleton;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class CardZoneManager {
    public static final int DRAW_TO = 5;
    public static final int HAND_SIZE = 7;
    public static final Rectangle GRAVEYARD_RECTANGLE = new Rectangle(50f, 0f, 100f, 200f);
    public static final Rectangle DECK_RECTANGLE = new Rectangle(175f, 0f, 100f, 200f);
    public static final Rectangle MANA_RECTANGLE = new Rectangle(50f, 250f, 100f, 100f);

    public static final String DECK_PATH = "Graphics/HUD/Deck.png";
    public static final String GRAVEYARD_PATH = "Graphics/HUD/Graveyard.png";
    public static final String MANA_PATH = "Graphics/HUD/Mana.png";

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
        SpriteBatch spriteBatch = GraphicsSingleton.getInstance().getSpriteBatch();
        spriteBatch.draw(GraphicsSingleton.getInstance().getTexture(DECK_PATH), DECK_RECTANGLE.getX(), DECK_RECTANGLE.getY(),
                DECK_RECTANGLE.getWidth(), DECK_RECTANGLE.getHeight());
        spriteBatch.draw(GraphicsSingleton.getInstance().getTexture(GRAVEYARD_PATH), GRAVEYARD_RECTANGLE.getX(), GRAVEYARD_RECTANGLE.getY(),
                GRAVEYARD_RECTANGLE.getWidth(), GRAVEYARD_RECTANGLE.getHeight());
        spriteBatch.draw(GraphicsSingleton.getInstance().getTexture(MANA_PATH), MANA_RECTANGLE.getX(), MANA_RECTANGLE.getY(),
                MANA_RECTANGLE.getWidth(), MANA_RECTANGLE.getHeight());
        //TODO: numbers
        hand.render();
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
