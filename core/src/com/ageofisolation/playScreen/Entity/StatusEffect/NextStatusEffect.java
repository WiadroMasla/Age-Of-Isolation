package com.ageofisolation.playScreen.Entity.StatusEffect;

public interface NextStatusEffect extends StatusEffectDecorator {
    void setPrev(PrevStatusEffect prev);
}
