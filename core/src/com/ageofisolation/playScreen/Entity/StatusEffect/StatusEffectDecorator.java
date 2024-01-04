package com.ageofisolation.playScreen.Entity.StatusEffect;

import com.ageofisolation.playScreen.Entity.StatusEffectRenderInfo;
import com.ageofisolation.playScreen.Entity.StatusEffectRenderer;
import com.ageofisolation.playScreen.Entity.Targetable;

public interface StatusEffectDecorator extends Targetable {
    StatusEffectRenderInfo getStatusEffectRenderInfo();
    void remove();
    void render(StatusEffectRenderer statusEffectRenderer);
}
