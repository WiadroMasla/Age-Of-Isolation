package com.ageofisolation.playScreen.Entity.Player;

import com.ageofisolation.graphics.GraphicsSingleton;
import com.ageofisolation.playScreen.AbstractStatusEffectRenderer;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderInfo;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;


public class PlayerStatusEffectRenderer extends AbstractStatusEffectRenderer {
    public final static int WIDTH = 20;
    public final static int HEIGHT = 20;
    @Override
    protected Rectangle getRenderRectangle() {
        OrthographicCamera camera = GraphicsSingleton.getInstance().getCamera();
        Rectangle out = new Rectangle(WIDTH * statusEffectCounter, camera.viewportHeight - HEIGHT, WIDTH, HEIGHT);
        ++statusEffectCounter;
        return out; //TODO: implement going to the next row
    }
}
