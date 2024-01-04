package com.ageofisolation.playScreen.Entity.StatusEffect;

import com.ageofisolation.playScreen.Entity.StatusEffectRenderInfo;

public abstract class StackingStatusEffect extends AbstractStatusEffect {
    protected int stacks;
    public StackingStatusEffect(int stacks) {
        this.stacks = stacks;
    }

    @Override
    public StatusEffectRenderInfo getStatusEffectRenderInfo() {
        return new StatusEffectRenderInfo(getTexturePath(), stacks);
    }

    @Override
    public void applyStatusEffect(StatusEffect effect) {
        if (getLayerEnum().getLayerNumber() == effect.getLayerEnum().getLayerNumber()
                && getPriority() == effect.getPriority()) {
            if (effect instanceof StackingStatusEffect stackingStatusEffect) {
                stacks+= stackingStatusEffect.stacks;
                if (stacks == 0) {
                    remove();
                }
            }
        } else {
            super.applyStatusEffect(effect);
        }
    }
}
