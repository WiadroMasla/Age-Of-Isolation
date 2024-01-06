package com.ageofisolation.playScreen.Entity.Player.CardZones;


import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Card;
import com.ageofisolation.playScreen.Entity.Targetable;
import com.badlogic.gdx.math.Rectangle;

import java.util.LinkedList;
import java.util.List;

public class Hand {
    public static final Rectangle STATIC_RECTANGLE = new Rectangle(0,-10f, 20f,40f);
    private List<CardRectangle> cardRectangles;
    private CardRectangle selectedCard;
    public Hand() {
        cardRectangles = new LinkedList<>();
        selectedCard = null;
    }

    public void addCard(Card card) {
        cardRectangles.add(new CardRectangle(card,new Rectangle(STATIC_RECTANGLE.getX() + STATIC_RECTANGLE.getWidth() * cardRectangles.size(),
                STATIC_RECTANGLE.getY(), STATIC_RECTANGLE.getWidth(), STATIC_RECTANGLE.getHeight())));
    }

    public void render() {
        for (CardRectangle cardRectangle : cardRectangles) {
            if (cardRectangle != selectedCard) {
                cardRectangle.render();
            }
            if (selectedCard != null) {
                //TODO: finish rectangle
                cardRectangle.render(new Rectangle());
            }
        }
    }

    public void playCard(Targetable targetable) {
        selectedCard.card().playCard(targetable);
        cardRectangles.remove(selectedCard);
    }
}
