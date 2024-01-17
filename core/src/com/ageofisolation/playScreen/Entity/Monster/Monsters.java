package com.ageofisolation.playScreen.Entity.Monster;




import com.badlogic.gdx.math.Rectangle;

import java.util.LinkedList;
import java.util.List;

public class Monsters {
    public static final float START_X = 100f;
    public static final float START_Y = 100f;
    public static final float WIDTH = 100f;
    public static final float HEIGHT = 150f;
    private List<MonsterFacade> monsters;
    public Monsters() {
        monsters = new LinkedList<>();
    }

    public void update(MonsterFacade facade) {
        monsters.remove(facade);
    }

    public void endTurn() {
        for (MonsterFacade monsterFacade : monsters) {
            monsterFacade.startTurn();
            monsterFacade.endTurn();
        }
    }

    public boolean isDefeated() {
        return monsters.isEmpty();
    }

    public void addMonster(MonsterFacade monsterFacade) {
        monsters.add(monsterFacade);
    }

    public MonsterFacade getMonster(float x, float y) {
        if (y < START_Y || y > START_Y + HEIGHT || x < START_X || x >= START_X + monsters.size() * WIDTH) {
            return null;
        }
        return monsters.get((int) ((x - START_X) / WIDTH));
    }

    public void render() {
        for (int i = 0; i < monsters.size(); ++i) {
            MonsterFacade monsterFacade = monsters.get(i);
            monsterFacade.render(new Rectangle(START_X + i * WIDTH, START_Y, WIDTH, HEIGHT));
        }
    }
}
