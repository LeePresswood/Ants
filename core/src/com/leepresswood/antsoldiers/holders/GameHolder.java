package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.gamegrid.GameGrid;

public class GameHolder extends Holder
{	
	private Texture texture_ant;
	private GameGrid grid;
	
	public GameHolder(Vector2 origin_point, Vector2 holder_size, int level)
	{
		super(origin_point, holder_size);		
				
		//Ants
		texture_ant = new Texture(Gdx.files.internal("ants/ant.png"));;
		
		//Initialize the grid.
		grid = new GameGrid();
	}

	@Override
	public void doTouch(float x, float y)
	{
		
	}

	@Override
	public void update(float delta)
	{
		
	}

	@Override
	public void render()
	{
		for(Sprite s : grid.getBlocks())
			drawSprite(s);
	}

	@Override
	public void dispose()
	{
		super.dispose();
		texture_ant.dispose();
	}
}
