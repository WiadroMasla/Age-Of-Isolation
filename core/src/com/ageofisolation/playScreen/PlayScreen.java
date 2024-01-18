package com.ageofisolation.playScreen;

import com.ageofisolation.AbstractScreen;
import com.ageofisolation.graphics.GraphicsSingleton;
import com.ageofisolation.playScreen.Entity.Monster.ConcreteMonsters.MonsterBiter;
import com.ageofisolation.playScreen.Entity.Monster.Monsters;
import com.ageofisolation.playScreen.Entity.Player.PlayerFacade;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class PlayScreen extends AbstractScreen {
    private Random seededRNG;
    private String backgroundPath;
    PlayScreenState playScreenState;

    public PlayScreen(int seed) {
        seededRNG = new Random(seed);
        PlayerFacade.getInstance().reset(this);
        Monsters monsters = new Monsters();
        monsters.addMonster(new MonsterBiter(monsters));
        monsters.addMonster(new MonsterBiter(monsters));
        playScreenState = new BattleState(this, seededRNG, monsters);
        backgroundPath = "Graphics/Backgrounds/backgroundPlaceholder.png";
    }

    @Override
    protected void innerRender() {
        Texture background = GraphicsSingleton.getInstance().getTexture(backgroundPath);
        GraphicsSingleton.getInstance().getSpriteBatch().draw(background, 0f, 0f,
                Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        playScreenState.render();
    }

    @Override
    protected void update(float delta) {
        playScreenState.update(delta);
    }


    @Override
    public void dispose() {

    }

    public void setState(PlayScreenState playScreenState) {
        this.playScreenState = playScreenState;
        playScreenState.init();
    }
}
