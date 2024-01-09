package com.ageofisolation.playScreen.Entity.Monster.Action;

public interface ActionIterator {
    MonsterAction next();
    MonsterAction peekNext();
}
