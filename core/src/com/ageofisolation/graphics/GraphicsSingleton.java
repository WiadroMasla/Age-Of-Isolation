package com.ageofisolation.graphics;

import com.ageofisolation.config.Config;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GraphicsSingleton {
    private static GraphicsSingleton instance = null;
    private SpriteBatch spriteBatch;
    private TextureMap textureMap;
    private OrthographicCamera camera;
    private FontMap fontMap;

    private GraphicsSingleton() {
        spriteBatch = new SpriteBatch();
        textureMap = new TextureMap();
        fontMap = new FontMap();
        camera = new OrthographicCamera(Config.DEFAULT_WIDTH, Config.DEFAULT_HEIGHT);
        camera.position.set(0, 0, 0);
        camera.update();
    }

    public static GraphicsSingleton getInstance() {
        if (instance == null) instance = new GraphicsSingleton();
        return instance;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public Texture getTexture(String path) {
        return textureMap.get(path);
    }

    public BitmapFont getFont(String path) {
        return fontMap.get(path);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void dispose() {
        spriteBatch.dispose();
        textureMap.dispose();
        fontMap.dispose();
    }
}
