package com.aide.trainer.mylibgdxgame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.*;

public class MyGdxGame implements ApplicationListener
{
    ShapeRenderer shapeRenderer;
    OrthographicCamera camera;
	float x;

    @Override
    public void create()
	{
		camera = new OrthographicCamera();
		configureCamera();
        
		shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render()
	{        
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(0, 0.5f, 0, 1);
		shapeRenderer.circle(x, 50, 40);
		shapeRenderer.end();
        
        x = x + 100 * Gdx.graphics.getDeltaTime();
        if(x>camera.viewportWidth)x=-20;
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
        shapeRenderer.dispose();
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