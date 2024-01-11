package com.ageofisolation.playScreen.Entity.Player;

import com.ageofisolation.playScreen.Entity.EntityFacade;
import com.ageofisolation.playScreen.Entity.EntityModel;
import com.ageofisolation.playScreen.Entity.Player.CardZones.CardZoneManager;
import com.ageofisolation.playScreen.Entity.StatusEffect.StatusEffectHead;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderer;
import com.ageofisolation.playScreen.PlayScreen;

public class PlayerFacade extends EntityFacade {
    public static final int MAX_MANA = 4;
    private static PlayerFacade instance = null;
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
        cardZoneManager.render(); //TODO: mana
    }

    @Override
    public void startTurn() {
        mana = MAX_MANA;
        super.startTurn();
    }

    public void payMana(int amount) {
        mana-=amount;
    }
    public int getMana() {
        return mana;
    }

    public void reset(PlayScreen ps) {
        cardZoneManager = new CardZoneManager();
        statusEffectHead = new StatusEffectHead(new PlayerModel(new PlayerObserver(ps), cardZoneManager));
        mana = MAX_MANA;
    }
}
