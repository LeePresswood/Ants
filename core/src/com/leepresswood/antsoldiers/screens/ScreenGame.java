package com.leepresswood.antsoldiers.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.GameAntSoldiers;
import com.leepresswood.antsoldiers.holders.GUIHolder;
import com.leepresswood.antsoldiers.holders.GameHolder;
import com.leepresswood.antsoldiers.holders.ScreenCoordinates;

public class ScreenGame extends ScreenAdapter implements InputProcessor
{	
	private GameAntSoldiers game;
	
	private OrthographicCamera camera;
	
	private GUIHolder gui_holder;
	private GameHolder game_holder;	
	
	private SpriteBatch game_batch;
	private SpriteBatch gui_batch;
	
	public ScreenGame(GameAntSoldiers game, int level)
	{
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 400);
				
		gui_holder = new GUIHolder(level);
		game_holder = new GameHolder(level);
		
		game_batch = new SpriteBatch();
		gui_batch = new SpriteBatch();
	
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render(float delta)
	{//Update and draw -- in that order.
		//Clear screen with dark gray before drawing.
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game_holder.update(delta);
		gui_holder.update(delta);
		
		game_holder.render();
		gui_holder.render();
	}

	@Override
	public boolean keyDown(int keycode)
	{
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		return false;
	}

	@Override
	public boolean keyTyped(char character)
	{
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		//Determine where the touch was.
		if(screenY <= GUI_boundary_top)
		{//Touched the GUI.
			gui_holder.doTouch(screenX, screenY);
		}
		else
		{//Touched the game.
			game_holder.doTouch(screenX, screenY);
		}
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		return false;
	}
}
