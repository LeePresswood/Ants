package com.leepresswood.antsoldiers;

import com.badlogic.gdx.Game;
import com.leepresswood.antsoldiers.screens.ScreenGame;

public class GameAntSoldiers extends Game
{
	@Override
	public void create()
	{
		this.setScreen(new ScreenGame(this, 1));
	}	
	
	@Override
	public void render()
	{
		super.render();	
	}
	
	@Override
	public void dispose()
	{
		super.dispose();
	}
	
	@Override
	public void resume()
	{
		super.resume();	
	}
}
