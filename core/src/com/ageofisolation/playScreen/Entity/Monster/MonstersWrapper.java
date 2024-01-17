package com.ageofisolation.playScreen.Entity.Monster;

public class MonstersWrapper {
    private static MonstersWrapper instance = new MonstersWrapper();
    private Monsters monsters;
    private MonstersWrapper() {
        monsters = null;
    }
    public static MonstersWrapper getInstance() {
        return instance;
    }

    public void setMonsters(Monsters monsters) {
        this.monsters = monsters;
    }

    public Monsters getMonsters() {
        return monsters;
    }
}
