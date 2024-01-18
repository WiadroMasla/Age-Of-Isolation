package com.ageofisolation.playScreen.Entity.Monster.Action.ConcreteActions;

import com.ageofisolation.playScreen.Entity.Monster.Action.MonsterAction;
import com.ageofisolation.playScreen.Entity.Monster.Action.MonsterActionIcon;
import com.ageofisolation.playScreen.Entity.Player.PlayerFacade;
import com.ageofisolation.playScreen.Entity.Targetable;

import java.util.Optional;

public class AttackAction implements MonsterAction {
    private int magnitude;
    public AttackAction(int magnitude) {
        this.magnitude = magnitude;
    }
    @Override
    public void takeAction(Targetable user) {
        user.dealDamage(magnitude, PlayerFacade.getInstance());
    }

    @Override
    public MonsterActionIcon getIcon() {
        return null; //TODO:
    }

    @Override
    public Optional<Integer> getMagnitude() {
        return Optional.of(magnitude);
    }
}
