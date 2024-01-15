package com.ageofisolation.playScreen.Entity.Monster;

import com.ageofisolation.playScreen.AbstractStatusEffectRenderer;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderInfo;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderer;
import com.badlogic.gdx.math.Rectangle;

public class MonsterStatusEffectRenderer extends AbstractStatusEffectRenderer {
    public final static int WIDTH = 20;
    public final static int HEIGHT = 20;
    private float startX;
    private float startY;
    //TODO:
    @Override
    protected Rectangle getRenderRectangle() {
        return null;
    }
}
