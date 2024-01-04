package com.ageofisolation.playScreen.Entity.StatusEffect.Effects;

import com.ageofisolation.playScreen.Entity.StatusEffect.DecayingStatusEffect;
import com.ageofisolation.playScreen.Entity.StatusEffect.LayerEnum;

public final class PoisonStatusEffect extends DecayingStatusEffect {
    public PoisonStatusEffect(int stacks) {
        super(stacks);
    }

    @Override
    protected String getTexturePath() {
        return "Graphics/StatusEffects/Poison.png";
    }

    @Override
    public LayerEnum getLayerEnum() {
        return LayerEnum.TRIGGERS_AFTER;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    protected void endTurnEffect() {
        super.takeDamage(stacks);
    }

    @Override
    public boolean isDebuff() {
        return true;
    }
}
