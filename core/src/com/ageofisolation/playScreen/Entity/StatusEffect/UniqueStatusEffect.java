package com.ageofisolation.playScreen.Entity.StatusEffect;

import com.ageofisolation.playScreen.Entity.StatusEffectRenderInfo;

public abstract class UniqueStatusEffect extends AbstractStatusEffect {


    @Override
    public StatusEffectRenderInfo getStatusEffectRenderInfo() {
        return new StatusEffectRenderInfo(getTexturePath(), 1);
    }

    @Override
    public void applyStatusEffect(StatusEffect effect) {
        if (getLayerEnum().getLayerNumber() == effect.getLayerEnum().getLayerNumber()
                && getPriority() == effect.getPriority()) {
            //do nothing
        } else {
            super.applyStatusEffect(effect);
        }
    }
}
