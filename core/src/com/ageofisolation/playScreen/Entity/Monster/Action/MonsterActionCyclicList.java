package com.ageofisolation.playScreen.Entity.Monster.Action;

public class MonsterActionCyclicList {
    private MonsterAction[] actions;
    public MonsterActionCyclicList(MonsterAction[] actions) {
        this.actions = actions;
    }

    public MonsterAction get(int index) {
        return actions[index];
    }

    public CyclicListActionIterator getIterator() {
        return new CyclicListActionIterator(this);
    }

    public static class CyclicListActionIterator implements ActionIterator {
        private MonsterActionCyclicList cyclicList;
        private int index;
        public CyclicListActionIterator(MonsterActionCyclicList cyclicList) {
            this.cyclicList = cyclicList;
            index = 0;
        }


        @Override
        public MonsterAction next() {
            MonsterAction out = peekNext();
            index = (index + 1) % cyclicList.actions.length;
            return out;
        }

        @Override
        public MonsterAction peekNext() {
            return cyclicList.get(index);
        }
    }
}
