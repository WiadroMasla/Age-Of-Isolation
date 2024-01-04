package com.ageofisolation.graphics;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public class TextureMap {
    private Map<String, Texture> map;

    public TextureMap() {
        map = new HashMap<>();
    }

    public Texture get(String path) {
        if(!map.containsKey(path)) {
            map.put(path, new Texture(path));
        }
        return map.get(path);
    }

    void dispose() {
        for( Texture texture : map.values()) texture.dispose();
    }
}
