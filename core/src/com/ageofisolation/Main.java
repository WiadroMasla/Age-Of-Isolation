package com.ageofisolation;

import com.ageofisolation.graphics.GraphicsSingleton;
import com.ageofisolation.playScreen.PlayScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends Game {
	
	@Override
	public void create () {
		setScreen(new PlayScreen(2137));
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		OrthographicCamera camera = GraphicsSingleton.getInstance().getCamera();
		camera.update();
		SpriteBatch spriteBatch = GraphicsSingleton.getInstance().getSpriteBatch();
		spriteBatch.setProjectionMatrix(camera.combined);

		spriteBatch.begin();
		super.render();
		spriteBatch.end();
	}
	
	@Override
	public void dispose () {
		screen.dispose();
		GraphicsSingleton.getInstance().dispose();
	}
}