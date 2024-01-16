package com.ageofisolation.playScreen;

import java.util.Random;

public abstract class PlayScreenState {
    protected PlayScreen playScreen;
    protected Random seededRNG;
    public PlayScreenState(PlayScreen playScreen, Random seededRNG) {
        this.playScreen = playScreen;
        this.seededRNG = seededRNG;
    }

    public abstract void render();
    public abstract void update(float delta);
    public void init(){

    }
}
