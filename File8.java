package com.aide.trainer.mylibgdxgame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;

public class MyGdxGame implements ApplicationListener
{
    SpriteBatch batch;
	OrthographicCamera camera;
	TextureRegion ballTexture;
	TextureRegion backgroundTexture;
	
	float time;
	Vector2 ballPosition; 
	Vector2 ballVelocity;

    @Override
    public void create()
	{
		camera = new OrthographicCamera();
		configureCamera();
        batch = new SpriteBatch();
		
		Texture texture = new Texture(Gdx.files.internal("ball.png"));
		ballTexture = new TextureRegion(texture, 0, 0, 256, 256);
		Texture texture2 = new Texture(Gdx.files.internal("skyBackground.jpg"));
		backgroundTexture = new TextureRegion(texture2, 0, 0, 2048, 563);
		
		ballPosition=new Vector2(0, 0);
		ballVelocity=new Vector2(30, 400);
    }

    @Override
    public void render()
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(backgroundTexture, 0, 0, 2900, 800);
		batch.draw(ballTexture, ballPosition.x, ballPosition.y, 50, 50);
        batch.end();
        
        time += Gdx.graphics.getDeltaTime();
		if (time > 2)
		{
			ballPosition.add(new Vector2(ballVelocity).scl(Gdx.graphics.getDeltaTime()));
			ballVelocity.y -= 300 * Gdx.graphics.getDeltaTime();
			if (ballPosition.y < 0 && ballVelocity.y < 0) 
				ballVelocity.y = -0.9f*ballVelocity.y;
			ballVelocity.scl(1-(0.1f*Gdx.graphics.getDeltaTime()));
		}
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