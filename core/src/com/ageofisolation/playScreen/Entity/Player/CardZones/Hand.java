package com.ageofisolation.playScreen.Entity.Player.CardZones;


import com.ageofisolation.graphics.GraphicsSingleton;
import com.ageofisolation.playScreen.Entity.Monster.MonstersWrapper;
import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Card;
import com.ageofisolation.playScreen.Entity.Targetable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.LinkedList;
import java.util.List;

public class Hand {
    public static final Rectangle STATIC_RECTANGLE = new Rectangle(300f,0f, 100f,200f);
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
        Camera camera = GraphicsSingleton.getInstance().getCamera();
        Vector3 vector = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
        for (CardRectangle cardRectangle : cardRectangles) {
            if (cardRectangle != selectedCard) {
                cardRectangle.render();
            }

        }
        if (selectedCard != null) {
            selectedCard.render(new Rectangle(vector.x - STATIC_RECTANGLE.getWidth()/2,
                    vector.y - STATIC_RECTANGLE.getHeight()/2, STATIC_RECTANGLE.getWidth(), STATIC_RECTANGLE.getHeight()));
        }
    }

    public void playCard(Targetable targetable) {
        if (selectedCard.card().playCard(targetable)) {
            removeSelected();
        }

    }

    public void update(float delta) {
        Camera camera = GraphicsSingleton.getInstance().getCamera();
        Vector3 vector = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
        if (!Gdx.input.isTouched() && selectedCard != null) {

            Targetable target = MonstersWrapper.getInstance().getMonsters().getMonster(vector.x, vector.y);
            if (target != null || !selectedCard.card().isTargeted()) {
                playCard(target);
            }

            selectedCard = null;
        }
        if (Gdx.input.justTouched()) {
            for (CardRectangle cardRectangle : cardRectangles) {
                if (cardRectangle.rectangle().contains(vector.x, vector.y)) {
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
            out.add(cardRectangles.remove(cardRectangles.size() - 1).card());
        }
        return out;
    }

    public int size() {
        return cardRectangles.size();
    }

    private void removeSelected() {
        cardRectangles.remove(selectedCard);
        selectedCard = null; //TODO: move cards
    }
}
