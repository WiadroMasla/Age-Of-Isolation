package com.ageofisolation.playScreen.Entity.Monster.Action;

import com.ageofisolation.playScreen.Entity.Targetable;

import java.util.Optional;

public interface MonsterAction {
    void takeAction(Targetable user);
    MonsterActionIcon getIcon();
    Optional<Integer> getMagnitude();
}
