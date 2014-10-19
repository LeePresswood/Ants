package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.gamegrid.GameGrid;
import com.leepresswood.antsoldiers.gamegrid.tiles.GridBlock;

public class GameHolder extends Holder
{	
	private Texture texture_ant;
	private GameGrid grid;
	
	public GameHolder(int level)
	{
		super(origin_point, holder_size);		
				
		//Ants
		texture_ant = new Texture(Gdx.files.internal("ants/ant.png"));;
		
		//Initialize the grid.
		grid = new GameGrid(origin_point, holder_size, level, block_textures);
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
		batch.begin();
			GridBlock[][] blocks = grid.getBlocks();
			for(int j = 0; j < blocks.length; j++)
				for(int i = 0; i < blocks[0].length; i++)
					drawSprite(blocks[j][i]);
		batch.end();
	}

	@Override
	public void dispose()
	{
		super.dispose();
		texture_ant.dispose();
	}
}
