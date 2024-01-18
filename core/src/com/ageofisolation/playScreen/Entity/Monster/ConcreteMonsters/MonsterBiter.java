package com.ageofisolation.playScreen.Entity.Monster.ConcreteMonsters;

import com.ageofisolation.playScreen.Entity.Monster.Action.ActionIterator;
import com.ageofisolation.playScreen.Entity.Monster.Action.ConcreteActions.AttackAction;
import com.ageofisolation.playScreen.Entity.Monster.Action.MonsterAction;
import com.ageofisolation.playScreen.Entity.Monster.Action.MonsterActionCyclicList;
import com.ageofisolation.playScreen.Entity.Monster.MonsterFacade;
import com.ageofisolation.playScreen.Entity.Monster.Monsters;

public class MonsterBiter extends MonsterFacade {
    public static final MonsterActionCyclicList MONSTER_ACTIONS = new MonsterActionCyclicList(
            new MonsterAction[]{new AttackAction(3), new AttackAction(5)}
    );

    public static final int MAX_HEALTH = 18;
    public static final String TEXTURE_PATH = "Graphics/Monsters/Biter.png";

    public MonsterBiter(Monsters monsters) {
        super(monsters, MAX_HEALTH, TEXTURE_PATH, MONSTER_ACTIONS.getIterator());
    }
}
