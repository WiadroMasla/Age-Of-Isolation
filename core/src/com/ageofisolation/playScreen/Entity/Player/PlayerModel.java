package com.ageofisolation.playScreen.Entity.Player;

import com.ageofisolation.playScreen.Entity.EntityModel;
import com.ageofisolation.playScreen.Entity.Targetable;

public class PlayerModel implements EntityModel {
    private int block;

    public PlayerModel(PlayerObserver playerObserver) {
        block = 0;
        //TODO:
    }

    @Override
    public void dealDamage(int amount, Targetable target) {

    }

    @Override
    public void takeDamage(int amount) {
        //TODO:
    }

    @Override
    public void gainBlock(int amount) {
        block+= amount;
    }

    @Override
    public void heal(int amount) {
        //TODO:
    }

    @Override
    public void startTurn() {
        block = 0;
        //TODO:
    }
}
