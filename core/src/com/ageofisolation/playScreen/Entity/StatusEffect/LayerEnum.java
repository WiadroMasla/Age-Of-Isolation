package com.ageofisolation.playScreen.Entity.StatusEffect;

public enum LayerEnum {
    PRIORITY(0),
    TRIGGERS_BEFORE(1),
    ADDITIVE(2),
    MULTIPLICATIVE(3),
    TRIGGERS_AFTER(4),
    BASE(Integer.MAX_VALUE);
    private LayerEnum(int layerNumber) {
        this.layerNumber = layerNumber;
    }
    private int layerNumber;
    public int getLayerNumber() {
        return layerNumber;
    }

}
