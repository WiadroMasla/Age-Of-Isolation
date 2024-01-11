package com.ageofisolation.playScreen.Entity.Player.CardZones.Card;

import com.ageofisolation.graphics.GraphicsSingleton;
import com.ageofisolation.playScreen.Entity.Player.PlayerFacade;
import com.ageofisolation.playScreen.Entity.Targetable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Card {
    private final String cardboxTexturePath = "TODO: TBA";
    private String cardName;
    private String texturePath;
    private CardEffect cardEffect;
    private int cost;
    public Card(String cardName, String texturePath, CardEffect cardEffect, int cost) {
        this.cardName = cardName;
        this.texturePath = texturePath;
        this.cardEffect = cardEffect;
        this.cost = cost;
    }

    public final boolean isTargeted() {
        return cardEffect.isTargeted();
    }

    public final boolean playCard(Targetable target) {
        boolean out = false;
        if (PlayerFacade.getInstance().getMana() >= cost) {
            PlayerFacade.getInstance().payMana(cost);
            out = true;
            cardEffect.apply(target);
        }
        return out;
    }

    public final void render(Rectangle rectangle) {
        SpriteBatch spriteBatch = GraphicsSingleton.getInstance().getSpriteBatch();
        spriteBatch.draw(GraphicsSingleton.getInstance().getTexture(cardboxTexturePath), rectangle.getX(),
                rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        //TODO: add text box and card art and MC
    }
}
