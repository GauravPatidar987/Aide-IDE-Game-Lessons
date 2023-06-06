package com.aide.trainer.mylibgdxgame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.*;

public class MyGdxGame implements ApplicationListener
{
    ShapeRenderer shapeRenderer;
    OrthographicCamera camera;

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
		shapeRenderer.circle(50, 50, 40);
		shapeRenderer.circle(140,50,40);
		shapeRenderer.setColor(0.5f, 0, 0, 1);
		shapeRenderer.rect(10, 100, 80, 80);
		
		shapeRenderer.setColor(0, 0, 0.5f, 1);
		shapeRenderer.triangle(10, 200, 90, 200, 50, 270);
		
		shapeRenderer.end();
    }

	private void configureCamera()
	{
		float size = 1600;
		if (Gdx.graphics.getHeight() < Gdx.graphics.getWidth())
			camera.setToOrtho(false, size, size * Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
		else
			camera.setToOrtho(false, size * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), size);
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