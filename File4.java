package com.aide.trainer.mylibgdxgame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class MyGdxGame implements ApplicationListener
{
    SpriteBatch batch;
	OrthographicCamera camera;
	TextureRegion rockTexture;
	TextureRegion backgroundTexture;

    @Override
    public void create()
	{
		camera = new OrthographicCamera();
		configureCamera();
        batch = new SpriteBatch();
		
		Texture texture = new Texture(Gdx.files.internal("rock.png"));
		Texture texture2 = new Texture(Gdx.files.internal("skyBackground.jpg"));
		rockTexture = new TextureRegion(texture, 25, 0, 250, 250);
		backgroundTexture=new TextureRegion(texture2,0,0,2048,563);
    }

    @Override
    public void render()
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(backgroundTexture,0,0,2900,800);
		batch.draw(rockTexture, 0, 0, 100, 100);
		batch.draw(rockTexture,200,0,100,100);
        batch.end();
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