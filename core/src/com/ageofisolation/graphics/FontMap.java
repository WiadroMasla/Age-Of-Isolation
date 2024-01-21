package com.ageofisolation.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.HashMap;
import java.util.Map;

public class FontMap {
    private Map<String, BitmapFont> map;

    public FontMap() {
        map = new HashMap<>();
    }

    public BitmapFont get(String path) {
        if(!map.containsKey(path)) {
            map.put(path, new BitmapFont(new FileHandle(path), false));
        }
        return map.get(path);
    }

    void dispose() {
        for( BitmapFont font : map.values()) font.dispose();
    }
}
