package com.trekt.finkids;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.trekt.helpers.AssetLoader;
import com.trekt.screens.GameScreen;

public class FinGame extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new GameScreen(this));
	}

	@Override
	public void dispose() {
		//super.dispose();
		AssetLoader.dispose();

	}
}
