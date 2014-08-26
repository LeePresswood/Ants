package com.leepresswood.antsoldiers.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class ScreenGame extends ScreenAdapter
{
	@Override
	public void render(float delta)
	{
		//Update
		update(delta);
		
		//Draw		
		//Clear screen with black
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	public void update(float delta)
	{
		
	}
}
