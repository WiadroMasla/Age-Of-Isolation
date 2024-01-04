package com.ageofisolation;

import com.ageofisolation.graphics.GraphicsSingleton;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;

public abstract class AbstractScreen implements Screen {
    protected abstract void innerRender();
    protected abstract void update(float delta);

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        update(delta);
        innerRender();
    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void resize(int width, int height) {
        Camera camera = GraphicsSingleton.getInstance().getCamera();
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
    }
}
