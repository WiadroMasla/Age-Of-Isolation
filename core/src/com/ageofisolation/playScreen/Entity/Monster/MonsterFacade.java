package com.ageofisolation.playScreen.Entity.Monster;

import com.ageofisolation.graphics.GraphicsSingleton;
import com.ageofisolation.playScreen.Entity.EntityFacade;
import com.ageofisolation.playScreen.Entity.Monster.Action.ActionIterator;
import com.ageofisolation.playScreen.Entity.StatusEffect.StatusEffect;
import com.ageofisolation.playScreen.Entity.StatusEffect.StatusEffectHead;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderer;
import com.ageofisolation.playScreen.Entity.Targetable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class MonsterFacade extends EntityFacade {
    private ActionIterator actionIterator;
    private MonsterModel model;
    private String texturePath;
    private Rectangle rectangle = null;

    public MonsterFacade(Monsters monsters, int maxHealth, String texturePath, ActionIterator actionIterator) {

        super(null);
        MonsterObserver monsterObserver = new MonsterObserver(this);
        monsterObserver.setMonsters(monsters);
        model = new MonsterModel(maxHealth, monsterObserver);
        statusEffectHead = new StatusEffectHead(model);
        this.texturePath = texturePath;
        this.actionIterator = actionIterator;
    }

    public void startTurn() {
        statusEffectHead.startTurn();
        actionIterator.next().takeAction(this);
        statusEffectHead.endTurn();
    }

    public void render(Rectangle rectangle) {
        this.rectangle = rectangle;
        render();
    }

    @Override
    protected StatusEffectRenderer getStatusEffectRenderer() {
        return new MonsterStatusEffectRenderer();
    }

    @Override
    protected void specificRender() {
        SpriteBatch spriteBatch = GraphicsSingleton.getInstance().getSpriteBatch();
        spriteBatch.draw(GraphicsSingleton.getInstance().getTexture(texturePath), rectangle.getX(), rectangle.getY(),
                rectangle.getWidth(), rectangle.getHeight());
        //TODO: HP
    }
}
