package com.ageofisolation.playScreen.Entity.Player.CardZones;

import com.ageofisolation.playScreen.Entity.Player.CardZones.Card.Card;
import com.badlogic.gdx.math.Rectangle;

public record CardRectangle(Card card, Rectangle rectangle) {
    public void render() {
        card().render(rectangle());
    }

    public void render(Rectangle rectangle) {
        card.render(rectangle);
    }
}
