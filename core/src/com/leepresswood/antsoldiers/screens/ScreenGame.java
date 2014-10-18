package com.leepresswood.antsoldiers.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.holders.GUIHolder;
import com.leepresswood.antsoldiers.holders.GameHolder;
import com.leepresswood.antsoldiers.holders.ScreenCoordinates;

public class ScreenGame extends ScreenAdapter implements InputProcessor
{
	private Vector2 origin_point;
	private Vector2 screen_size;
	private final float GUI_PERCENT = 0.2f;
	
	private GUIHolder gui_holder;
	private GameHolder game_holder;
	
	private float GUI_boundary_top;
	
	public ScreenGame(ScreenCoordinates screen_coords)
	{
		origin_point = new Vector2(screen_coords.x, screen_coords.y);
		screen_size = new Vector2(screen_coords.width, screen_coords.height);
		
		GUI_boundary_top = screen_size.y * GUI_PERCENT;
		
		gui_holder = new GUIHolder(origin_point, new Vector2(screen_size.x, GUI_boundary_top));
		game_holder = new GameHolder(new Vector2(origin_point.x, origin_point.y + GUI_boundary_top), new Vector2(screen_size.x, screen_size.y * (1f - GUI_PERCENT)));
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
