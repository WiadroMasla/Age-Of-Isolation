package com.ageofisolation.playScreen.Entity.Player;

import com.ageofisolation.graphics.GraphicsSingleton;
import com.ageofisolation.playScreen.Entity.EntityFacade;
import com.ageofisolation.playScreen.Entity.EntityModel;
import com.ageofisolation.playScreen.Entity.Player.CardZones.CardZoneManager;
import com.ageofisolation.playScreen.Entity.StatusEffect.StatusEffectHead;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderer;
import com.ageofisolation.playScreen.PlayScreen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PlayerFacade extends EntityFacade {
    public static final Rectangle MANA_RECTANGLE = new Rectangle(50f, 250f, 100f, 100f);
    public static final Vector2 MANA_LABEL_POS = new Vector2(100f, 300f);
    public static final String MANA_PATH = "Graphics/HUD/Mana.png";
    public static final String FONT_16 = "Fonts/16.fnt";
    public static final Rectangle BLOCK_RECTANGLE = new Rectangle(150f, 250f, 100f, 100f);
    public static final Vector2 BLOCK_LABEL_POS = new Vector2(200f, 300f);
    public static final String BLOCK_PATH = "Graphics/HUD/Block.png";
    public static final String FONT_16_BLACK = "Fonts/16_black.fnt";
    public static final int MAX_MANA = 4;
    private static PlayerFacade instance = null;
    private PlayerModel model;
    private CardZoneManager cardZoneManager;
    private int mana;

    private PlayerFacade() {
        super(null);
    }

    public static PlayerFacade getInstance() {
        if (instance == null) {
            instance = new PlayerFacade();
        }
        return instance;
    }

    @Override
    protected StatusEffectRenderer getStatusEffectRenderer() {
        return new PlayerStatusEffectRenderer();
    }

    @Override
    protected void specificRender() {
        SpriteBatch spriteBatch = GraphicsSingleton.getInstance().getSpriteBatch();
        spriteBatch.draw(GraphicsSingleton.getInstance().getTexture(MANA_PATH), MANA_RECTANGLE.getX(), MANA_RECTANGLE.getY(),
                MANA_RECTANGLE.getWidth(), MANA_RECTANGLE.getHeight());
        GraphicsSingleton.getInstance().getFont(FONT_16).draw(spriteBatch, String.valueOf(getMana()),
                MANA_LABEL_POS.x, MANA_LABEL_POS.y);

        spriteBatch.draw(GraphicsSingleton.getInstance().getTexture(BLOCK_PATH), BLOCK_RECTANGLE.getX(), BLOCK_RECTANGLE.getY(),
                BLOCK_RECTANGLE.getWidth(), BLOCK_RECTANGLE.getHeight());
        GraphicsSingleton.getInstance().getFont(FONT_16_BLACK).draw(spriteBatch, String.valueOf(model.getBlock()),
                BLOCK_LABEL_POS.x, BLOCK_LABEL_POS.y);

        cardZoneManager.render();
    }

    @Override
    public void startTurn() {
        mana = MAX_MANA;
        super.startTurn();
    }

    @Override
    public void endTurn() {
        cardZoneManager.endTurn();
        super.endTurn();
    }

    public void payMana(int amount) {
        mana-=amount;
    }
    public int getMana() {
        return mana;
    }

    public void reset(PlayScreen ps) {

        cardZoneManager = new CardZoneManager();
        model = new PlayerModel(new PlayerObserver(ps), cardZoneManager);
        statusEffectHead = new StatusEffectHead(model);
        mana = MAX_MANA;
    }

    public void update(float delta) {
        cardZoneManager.update(delta);
    }
}
