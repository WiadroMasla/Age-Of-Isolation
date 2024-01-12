package com.ageofisolation.playScreen;

import com.ageofisolation.graphics.GraphicsSingleton;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderInfo;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public abstract class AbstractStatusEffectRenderer implements StatusEffectRenderer {
    protected int statusEffectCounter;

    public AbstractStatusEffectRenderer() {
        statusEffectCounter = 0;
    }
    @Override
    public void render(StatusEffectRenderInfo info) {
        Rectangle rectangle = getRenderRectangle();
        SpriteBatch spriteBatch = GraphicsSingleton.getInstance().getSpriteBatch();
        spriteBatch.draw(GraphicsSingleton.getInstance().getTexture(info.statusEffectTexturePath()),
                rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        //TODO: render stacks amount
    }

    protected abstract Rectangle getRenderRectangle();
}
