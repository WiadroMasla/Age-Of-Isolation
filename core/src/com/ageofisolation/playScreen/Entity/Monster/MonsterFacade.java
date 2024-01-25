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
    public static final String HP_PATH = "Graphics/HUD/Health.png";
    public static final float HP_WIDTH = 100f;
    public static final float HP_HEIGHT = 100f;
    public static final String HP_FONT = "Fonts/18_black.fnt";
    public static final String BLOCK_PATH = "Graphics/HUD/Block.png";
    public static final float BLOCK_WIDTH = 100f;
    public static final float BLOCK_HEIGHT = 100f;
    public static final String BLOCK_FONT = "Fonts/18_black.fnt";
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
        spriteBatch.draw(GraphicsSingleton.getInstance().getTexture(HP_PATH), rectangle.getX(), rectangle.getY() + rectangle.getHeight(),
                HP_WIDTH, HP_HEIGHT);
        GraphicsSingleton.getInstance().getFont(HP_FONT).draw(spriteBatch, String.valueOf(model.getHealth()),
                rectangle.getX() + HP_WIDTH / 2, rectangle.getY() + rectangle.getHeight() + HP_HEIGHT / 2);

        spriteBatch.draw(GraphicsSingleton.getInstance().getTexture(BLOCK_PATH), rectangle.getX() + HP_WIDTH,
                rectangle.getY() + rectangle.getHeight(), HP_WIDTH, HP_HEIGHT);
        GraphicsSingleton.getInstance().getFont(BLOCK_FONT).draw(spriteBatch, String.valueOf(model.getBlock()),
                rectangle.getX() + HP_WIDTH + BLOCK_WIDTH / 2, rectangle.getY() + rectangle.getHeight() + BLOCK_HEIGHT / 2);

    }
}
