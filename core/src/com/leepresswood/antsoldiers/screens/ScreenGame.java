package com.leepresswood.antsoldiers.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.holders.GUIHolder;
import com.leepresswood.antsoldiers.holders.GameHolder;
import com.leepresswood.antsoldiers.holders.ScreenHolder;

public class ScreenGame extends ScreenAdapter
{
	//Holders
	private Vector2 origin_point;
	private Vector2 screen_size;
	private GUIHolder gui_holder;
	private GameHolder game_holder;
	
	//Sprites
	private SpriteBatch batch;
	
	public ScreenGame(ScreenHolder screen_holder)
	{
		origin_point = new Vector2(screen_holder.x, screen_holder.y);
		screen_size = new Vector2(screen_holder.width, screen_holder.height);
		gui_holder = new GUIHolder(origin_point, screen_size);
		game_holder = new GameHolder(origin_point, screen_size);
		
		batch = new SpriteBatch();
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
		
		gui_holder.render(batch);
		game_holder.render(batch);
	}
	
	public void update(float delta)
	{
		gui_holder.update(delta);
		game_holder.update(delta);
	}
}
