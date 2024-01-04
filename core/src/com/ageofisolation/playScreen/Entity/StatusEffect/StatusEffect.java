package com.ageofisolation.playScreen.Entity.StatusEffect;

public interface StatusEffect extends NextStatusEffect, PrevStatusEffect {
    LayerEnum getLayerEnum();
    int getPriority();
    boolean isDebuff();
}
