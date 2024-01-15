package com.ageofisolation.playScreen.Entity.Monster;

public class MonsterObserver {
    private MonsterFacade monsterFacade;
    private Monsters monsters;

    public MonsterObserver(MonsterFacade monsterFacade) {
        this.monsterFacade = monsterFacade;
        monsters = null;
    }


    public void update(boolean isDead) {
        if (isDead) {
            notifyMonsters();
        }
    }

    public void notifyMonsters() {
        monsters.update(monsterFacade);
    }

    public MonsterObserver setMonsters(Monsters monsters) {
        this.monsters = monsters;
        return this;
    }
}
