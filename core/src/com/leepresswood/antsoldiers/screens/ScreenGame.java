package com.leepresswood.antsoldiers.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.GameAntSoldiers;
import com.leepresswood.antsoldiers.holders.GUIHolder;
import com.leepresswood.antsoldiers.holders.GameHolder;
import com.leepresswood.antsoldiers.management.Assets;

public class ScreenGame extends ScreenAdapter implements GestureListener
{	
	public GameAntSoldiers game;
	public Assets assets;
		
	public GUIHolder gui_holder;
	public GameHolder game_holder;	
	
	public ScreenGame(GameAntSoldiers game, int level)
	{
		this.game = game;
		this.assets = new Assets();
				
		gui_holder = new GUIHolder(this, level);
		game_holder = new GameHolder(this, level);
		
		Gdx.input.setInputProcessor(new GestureDetector(this));
	}

	@Override
	public void render(float delta)
	{//Update and draw -- in that order.
		//Clear screen with dark gray before drawing.
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game_holder.update(delta);
		//gui_holder.update(delta);
		
		game_holder.render();
		//gui_holder.render();
	}

	//Touch logic below. Don't read unless you hate yourself.
	@Override
	public boolean touchDown(float x, float y, int pointer, int button)
	{
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button)
	{
		return false;
	}

	@Override
	public boolean longPress(float x, float y)
	{
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button)
	{
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY)
	{//Move camera in the game world.
		game_holder.scroll(-deltaX * 0.01f, deltaY * 0.01f);
		return true;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button)
	{//Make sure we're still bound to the game world.
		
		//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		//game_holder.scroll_stop();
		//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		
		return true;
	}

	@Override
	public boolean zoom(float initialDistance, float distance)
	{
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2)
	{
		return false;
	}
}
