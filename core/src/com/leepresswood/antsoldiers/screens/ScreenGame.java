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

public class ScreenGame extends ScreenAdapter
{	
	public GameAntSoldiers game;
		
	public GUIHolder gui_holder;
	public GameHolder game_holder;	
	
	public ScreenGame(GameAntSoldiers game, int level)
	{
		this.game = game;
				
		gui_holder = new GUIHolder(this, level);
		game_holder = new GameHolder(this, level);
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
}
