package com.ageofisolation.playScreen;

import com.ageofisolation.graphics.GraphicsSingleton;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;


public class NextTurnButton {
    public static final float X_OFFSET = 200f;
    public static final float Y = 200f;
    public static final float WIDTH = 100f;
    public static final float HEIGHT = 100f;
    public static String PATH = "Graphics/HUD/NextTurn.png";
    private BattleState battleState;

    public NextTurnButton(BattleState battleState) {
        this.battleState = battleState;
    }
    public void render() {
        float x = GraphicsSingleton.getInstance().getCamera().viewportWidth - X_OFFSET;
        GraphicsSingleton.getInstance().getSpriteBatch().draw(
                GraphicsSingleton.getInstance().getTexture(PATH), x, Y, WIDTH, HEIGHT
        );
    }

    public void update() {
        Rectangle rectangle = new Rectangle(GraphicsSingleton.getInstance().getCamera().viewportWidth - X_OFFSET, Y, WIDTH, HEIGHT);
        Vector3 vector = GraphicsSingleton.getInstance().getCamera().unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
        if (rectangle.contains(vector.x, vector.y) && Gdx.input.justTouched()) {
            battleState.processEndTurn();
        }
    }
}
