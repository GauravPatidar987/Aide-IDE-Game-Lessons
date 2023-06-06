package com.aide.trainer.mylibgdxgame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class MyGdxGame implements ApplicationListener
{
    SpriteBatch batch;
	OrthographicCamera camera;
    Animation walkAnimation;
    float time;

    @Override
    public void create()
	{
        Texture walkSheet = new Texture(Gdx.files.internal("runAnimation.png"));
		int FRAME_COLS = 6;
		int FRAME_ROWS = 5;
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / FRAME_COLS, walkSheet.getHeight() / FRAME_ROWS);
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++)
            for (int j = 0; j < FRAME_COLS; j++)
                walkFrames[index++] = tmp[i][j];
        walkAnimation = new Animation(0.025f, walkFrames); 
		
		camera = new OrthographicCamera();
		configureCamera();
        batch = new SpriteBatch();
    }

    @Override
    public void render()
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(walkAnimation.getKeyFrame(time, true), 0, 0, 200, 200);
        batch.end();
        
        time+=Gdx.graphics.getDeltaTime();
    }
	
	private void configureCamera()
	{
		if (Gdx.graphics.getHeight() < Gdx.graphics.getWidth())
			camera.setToOrtho(false, 800, 800 * Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
		else
			camera.setToOrtho(false, 800 * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), 800);
	}

	@Override
    public void dispose()
	{
        batch.dispose();
    }

    @Override
    public void resize(int width, int height)
	{
		configureCamera();
    }

    @Override
    public void pause()
	{
    }

    @Override
    public void resume()
	{
    }
}