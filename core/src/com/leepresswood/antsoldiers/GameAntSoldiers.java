package com.leepresswood.antsoldiers;

import com.badlogic.gdx.Game;
import com.leepresswood.antsoldiers.holders.ScreenHolder;
import com.leepresswood.antsoldiers.screens.ScreenGame;

public class GameAntSoldiers extends Game
{
	@Override
	public void create()
	{
		this.setScreen(new ScreenGame(new ScreenHolder()));
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
