package com.leepresswood.antsoldiers.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.holders.ScreenHolder;

public class ScreenGame extends ScreenAdapter
{
	private Vector2 origin_point;
	private Vector2 screen_size;
	
	public ScreenGame(ScreenHolder screen_holder)
	{
		origin_point = new Vector2(screen_holder.x, screen_holder.y);
		screen_size = new Vector2(screen_holder.width, screen_holder.height);
	}

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
