package com.ageofisolation.playScreen.Entity.Player;

import com.ageofisolation.playScreen.Entity.EntityModel;
import com.ageofisolation.playScreen.Entity.Player.CardZones.CardZoneManager;
import com.ageofisolation.playScreen.Entity.Targetable;

public class PlayerModel implements EntityModel {
    private int block;
    private PlayerObserver playerObserver;
    private CardZoneManager cardZoneManager;

    public PlayerModel(PlayerObserver playerObserver, CardZoneManager cardZoneManager) {
        block = 0;
        this.playerObserver = playerObserver;
        this.cardZoneManager = cardZoneManager;
    }



    @Override
    public void dealDamage(int amount, Targetable target) {
        target.takeDamage(amount);
    }

    @Override
    public void takeDamage(int amount) {
        if (amount > block) {
            amount-= block;
            block = 0;
            playerObserver.notify(cardZoneManager.mill(amount));
        } else {
            block-= amount;
        }

    }

    @Override
    public void gainBlock(int amount) {
        block+= amount;
    }

    @Override
    public void heal(int amount) {
        cardZoneManager.heal(amount);
    }

    @Override
    public void startTurn() {
        block = 0;
        cardZoneManager.startTurn();
    }

    public int getBlock() {
        return block;
    }
}
