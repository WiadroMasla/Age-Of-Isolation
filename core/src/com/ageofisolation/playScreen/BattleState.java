package com.ageofisolation.playScreen;

import com.ageofisolation.graphics.GraphicsSingleton;
import com.ageofisolation.playScreen.Entity.Monster.Monsters;
import com.ageofisolation.playScreen.Entity.Monster.MonstersWrapper;
import com.ageofisolation.playScreen.Entity.Player.PlayerFacade;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import static java.lang.System.exit;

public class BattleState extends PlayScreenState {


    private Monsters monsters;
    private PlayerFacade playerFacade;
    private NextTurnButton nextTurnButton;
    public BattleState(PlayScreen playScreen, Random seededRNG, Monsters monsters) {
        super(playScreen, seededRNG);
        this.monsters = monsters;
        playerFacade = PlayerFacade.getInstance();
        nextTurnButton = new NextTurnButton(this);
    }

    @Override
    public void render() {
        SpriteBatch spriteBatch = GraphicsSingleton.getInstance().getSpriteBatch();

        nextTurnButton.render();
        monsters.render();
        playerFacade.render();
    }

    @Override
    public void update(float delta) {
        if (monsters.isDefeated()) {
            exit(0);
        }
        playerFacade.update(delta);
        nextTurnButton.update();
    }

    @Override
    public void init() {
        MonstersWrapper.getInstance().setMonsters(monsters);
        PlayerFacade.getInstance().startTurn();
    }

    public void processEndTurn() {
        PlayerFacade.getInstance().endTurn();
        monsters.endTurn();
        PlayerFacade.getInstance().startTurn();
    }
}
