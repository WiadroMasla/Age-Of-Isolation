package com.ageofisolation.playScreen.Entity.Player.CardZones;


import com.ageofisolation.playScreen.Entity.Monster.MonstersWrapper;
import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Card;
import com.ageofisolation.playScreen.Entity.Targetable;
import com.badlogic.gdx.Gdx;
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
                cardRectangle.render(new Rectangle(Gdx.input.getX() - STATIC_RECTANGLE.getX()/2,
                        Gdx.input.getY() - STATIC_RECTANGLE.getY()/2, STATIC_RECTANGLE.getWidth(), STATIC_RECTANGLE.getHeight()));
            }
        }
    }

    public void playCard(Targetable targetable) {
        selectedCard.card().playCard(targetable);
        cardRectangles.remove(selectedCard);
        selectedCard = null;
    }

    public void update(float delta) {
        if (!Gdx.input.isTouched() && selectedCard != null) {

            Targetable target = MonstersWrapper.getInstance().getMonsters().getMonster(Gdx.input.getX(), Gdx.input.getY());
            if (target != null || !selectedCard.card().isTargeted()) {
                playCard(target);
            }

            selectedCard = null;
        }
        if (Gdx.input.justTouched()) {
            for (CardRectangle cardRectangle : cardRectangles) {
                if (cardRectangle.rectangle().contains(Gdx.input.getX(), Gdx.input.getY())) {
                    selectedCard = cardRectangle;
                    if (!selectedCard.card().isTargeted()) {
                        playCard(null);
                    }
                    break;
                }
            }
        }
    }

    public List<Card> returnHand() {
        List<Card> out = new LinkedList<>();
        while (cardRectangles.size() > 0) {
            out.add(cardRectangles.remove(cardRectangles.size()).card());
        }
        return out;
    }

    public int size() {
        return cardRectangles.size();
    }
}
