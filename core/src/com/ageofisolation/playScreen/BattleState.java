package com.ageofisolation.playScreen;

import com.ageofisolation.graphics.GraphicsSingleton;
import com.ageofisolation.playScreen.Entity.Player.PlayerFacade;

import java.util.Random;

public class BattleState extends PlayScreenState {
    public BattleState(PlayScreen playScreen, Random seededRNG) {
        super(playScreen, seededRNG);
    }

    @Override
    public void render() {
        PlayerFacade.getInstance().render();
    }

    @Override
    public void update(float delta) {

    }
}
