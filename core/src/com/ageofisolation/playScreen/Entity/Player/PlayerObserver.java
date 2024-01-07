package com.ageofisolation.playScreen.Entity.Player;

import com.ageofisolation.playScreen.PlayScreen;

import static java.lang.System.exit;

public class PlayerObserver {
    private PlayScreen playScreen;
    public PlayerObserver(PlayScreen playScreen) {
        this.playScreen = playScreen;
    }

    public void notify(boolean isDead) {
        if (isDead) {
            exit(0);
            //TODO: playScreen.setState(new GameOverState());
        }
    }
}
