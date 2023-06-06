package com.aide.trainer.mylibgdxgame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class MyGdxGame implements ApplicationListener
{
    SpriteBatch batch;
    BitmapFont font;

    @Override
    public void create()
	{        
        batch = new SpriteBatch();    
        font = new BitmapFont();
        font.setColor(Color.RED);
        font.setScale(3);
    }

    @Override
    public void render()
	{        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.draw(batch, "Hello World", 200, 100);
        batch.end();
    }

    @Override
    public void dispose()
	{
        batch.dispose();
        font.dispose();
    }

    @Override
    public void resize(int width, int height)
	{
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