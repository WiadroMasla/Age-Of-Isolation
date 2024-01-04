package com.ageofisolation.playScreen.Entity.StatusEffect;

public abstract class DecayingStatusEffect extends StackingStatusEffect {
    public DecayingStatusEffect(int stacks) {
        super(stacks);
    }

    @Override
    public final void endTurn() {
        endTurnEffect();
        decay();
        if(stacks == 0) {
            remove();
        }
        super.endTurn();
    }

    protected void decay() {
        --stacks;
    }

    protected void endTurnEffect() {

    }
}
