package com.trekt.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.trekt.finkids.FinGame;
import com.trekt.gameworld.GameRenderer;
import com.trekt.gameworld.GameWorld;
import com.trekt.helpers.AssetLoader;
import com.trekt.helpers.InputHandler;

/**
 * Created by AadityaPatwari on 29/7/16.
 */
public class GameScreen implements Screen{

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;
    float screenWidth = Gdx.graphics.getWidth();
    float screenHeight = Gdx.graphics.getHeight();
    float gameWidth = AssetLoader.gameWidth;
    float gameHeight = AssetLoader.gameHeight;

    public GameScreen (FinGame game){

        world = new GameWorld(game);
        Gdx.input.setInputProcessor(new InputHandler(world, screenWidth / gameWidth, screenHeight / gameHeight));
        renderer = new GameRenderer(world, (int) gameHeight);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {

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
    public void dispose() {

    }
}
