package com.leepresswood.antsoldiers.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.holders.GUIHolder;
import com.leepresswood.antsoldiers.holders.GameHolder;
import com.leepresswood.antsoldiers.holders.ScreenCoordinates;

public class ScreenGame extends ScreenAdapter
{
	private Vector2 origin_point;
	private Vector2 screen_size;
	private final float GUI_PERCENT = 0.2f;
	
	private GUIHolder gui_holder;
	private GameHolder game_holder;
	
	public ScreenGame(ScreenCoordinates screen_holder)
	{
		origin_point = new Vector2(screen_holder.x, screen_holder.y);
		screen_size = new Vector2(screen_holder.width, screen_holder.height);
		
		gui_holder = new GUIHolder(origin_point, new Vector2(screen_size.x, screen_size.y * GUI_PERCENT));
		game_holder = new GameHolder(new Vector2(origin_point.x, origin_point.y + GUI_PERCENT * screen_holder.y), new Vector2(screen_size.x, screen_size.y * (1f - GUI_PERCENT)));
	}

	@Override
	public void render(float delta)
	{//Update and draw -- in that order.
		//Clear screen with dark gray before drawing.
		Gdx.gl.glClearColor(40, 40, 40, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		gui_holder.update(delta);
		game_holder.update(delta);
		
		gui_holder.render();
		game_holder.render();
	}
}
