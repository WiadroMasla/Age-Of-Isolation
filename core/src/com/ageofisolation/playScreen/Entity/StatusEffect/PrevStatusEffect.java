package com.ageofisolation.playScreen.Entity.StatusEffect;

public interface PrevStatusEffect extends StatusEffectDecorator {
    void setNext(NextStatusEffect next);
}
