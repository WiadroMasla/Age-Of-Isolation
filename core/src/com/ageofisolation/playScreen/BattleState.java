package com.ageofisolation.playScreen;

import com.ageofisolation.graphics.GraphicsSingleton;
import com.ageofisolation.playScreen.Entity.Monster.Monsters;
import com.ageofisolation.playScreen.Entity.Monster.MonstersWrapper;
import com.ageofisolation.playScreen.Entity.Player.PlayerFacade;

import java.util.Random;

import static java.lang.System.exit;

public class BattleState extends PlayScreenState {
    private Monsters monsters;
    public BattleState(PlayScreen playScreen, Random seededRNG, Monsters monsters) {
        super(playScreen, seededRNG);
        this.monsters = monsters;
    }

    @Override
    public void render() {
        PlayerFacade.getInstance().render();
        monsters.render();
    }

    @Override
    public void update(float delta) {
        if (monsters.isDefeated()) {
            exit(0);
        }
    }

    @Override
    public void init() {
        MonstersWrapper.getInstance().setMonsters(monsters);
        PlayerFacade.getInstance().startTurn();
    }
}
