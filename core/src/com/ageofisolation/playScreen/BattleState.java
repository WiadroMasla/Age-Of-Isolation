package com.ageofisolation.playScreen;

import com.ageofisolation.graphics.GraphicsSingleton;

import java.util.Random;

public class BattleState extends PlayScreenState {
    public BattleState(PlayScreen playScreen, Random seededRNG) {
        super(playScreen, seededRNG);
    }

    @Override
    public void render() {
        GraphicsSingleton.getInstance().getSpriteBatch().draw(
                GraphicsSingleton.getInstance().getTexture("badlogic.jpg"), 0.f, 0.f
        );
    }

    @Override
    public void update(float delta) {

    }
}
